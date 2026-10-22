package com.bytedance.android.shopping.feed.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DataChecker {
    public static final Lazy a = null;

    public static final class a<V> implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(String r1, Context r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            JSONObject r0 = com.bytedance.android.shopping.extensions.k.w(this.a);
            if (r0 != null) goto L5;
            Lazy r1 = DataChecker.a;
            DataChecker.b(this.b, this.c, this.d, "entranceInfo error to json");
            return;
        L5:
            Lazy r2 = DataChecker.a;
            Context r3 = this.b;
            String r4 = this.c;
            String r5 = this.d;
            boolean r6 = false;
            if (r0.optString("carrier_source").length() != 0) goto L8;
            boolean r7 = true;
        L9:
            if (r7 == false) goto L12;
            DataChecker.b(r3, r4, r5, "carrier_source is empty");
            return;
        L12:
            if (r0.optString("source_method").length() != 0) goto L14;
            boolean r8 = true;
        L15:
            if (r8 == false) goto L18;
            DataChecker.b(r3, r4, r5, "source_method is empty");
            return;
        L18:
            if (r0.optString("group_id").length() != 0) goto L20;
            boolean r9 = true;
        L21:
            if (r9 == false) goto L29;
            if (r0.optString(PdpOpenThirdParam.KEY_ITEM_ID).length() != 0) goto L25;
            boolean r10 = true;
        L26:
            if (r10 == false) goto L29;
            DataChecker.b(r3, r4, r5, "group_id is empty");
            return;
        L25:
            r10 = false;
        L29:
            if (r0.opt("cid") == null) goto L36;
            if (r0.optString("cid").length() != 0) goto L33;
            r6 = true;
        L33:
            if (r6 == false) goto L36;
            DataChecker.b(r3, r4, r5, "cid length is zero");
            return;
        L36:
            if (r0.opt("shop_id") == null) goto L44;
            DataChecker.b(r3, r4, r5, "shop_id is forbidden");
            return;
        L44:
            return;
        L20:
            r9 = false;
            goto L21
        L14:
            r8 = false;
            goto L15
        L8:
            r7 = false;
            goto L9
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                if (r1 == null) goto L5;
                r1.dismiss();
                return;
            }
        }

        public d(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new AlertDialog.Builder(com.bytedance.android.ec.sdk.plugin.e.getActivity(this.a)).setMessage(this.b).setPositiveButton(2131897346, a.a).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = LazyKt.lazy(DataChecker$handler$2.INSTANCE);
    }

    public static void a(Context r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "enterTo");
        Intrinsics.checkNotNullParameter(r4, "entranceInfo");
        Single.fromCallable(new a(r4, r1, r2, r3)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(b.a, c.a);
    }

    public static void b(Context r2, String r3, String r4, String r5) {
        if (ECAppInfoService.e.i() == false) goto L10;
        ((Handler) a.getValue()).post(new d(r2, r5));
    L10:
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L7
        r6.put("data_type", "commerce_data");     // Catch: Throwable -> L7
        r6.put("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Throwable -> L7
        r6.put(SimilarProductParam.ENTER_FROM, r3);     // Catch: Throwable -> L7
        r6.put("enter_to", r4);     // Catch: Throwable -> L7
        r6.put("error_info", r5);     // Catch: Throwable -> L7
        com.bytedance.android.ec.sdk.helper.g.a.logV3("", r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }
}
