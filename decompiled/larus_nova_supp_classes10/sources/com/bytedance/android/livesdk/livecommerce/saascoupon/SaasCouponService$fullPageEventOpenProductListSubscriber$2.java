package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.sdk.helper.i;
import com.larus.apm.impl.protector.RunnableProtector;
import el2.k;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/livesdk/livecommerce/saascoupon/SaasCouponService$fullPageEventOpenProductListSubscriber$2$a", "invoke", "()Lcom/bytedance/android/livesdk/livecommerce/saascoupon/SaasCouponService$fullPageEventOpenProductListSubscriber$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class SaasCouponService$fullPageEventOpenProductListSubscriber$2 extends Lambda implements Function0<a> {
    final /* synthetic */ SaasCouponService this$0;

    public static final class a implements j {
        public final /* synthetic */ SaasCouponService$fullPageEventOpenProductListSubscriber$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.saascoupon.SaasCouponService$fullPageEventOpenProductListSubscriber$2$a$a, reason: collision with other inner class name */
        public static final class RunnableC0121a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0121a(String r1, a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i r0 = i.a;     // Catch: Throwable -> L8
                WeakReference<Context> r1 = this.b.a.this$0.j;     // Catch: Throwable -> L8
                if (r1 == null) goto L5;
                Context r2 = r1.get();     // Catch: Throwable -> L8
            L6:
                r0.e(r2, this.a, false, false);     // Catch: Throwable -> L8
                return;
            L5:
                r2 = null;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public static final class b implements zk.b {
            public b() {
            }

            public final String entryName() {
                return "full_lynx_dialog";
            }

            public final String getCouponId() {
                return null;
            }
        }

        public a(SaasCouponService$fullPageEventOpenProductListSubscriber$2 r1) {
            this.a = r1;
        }

        public final void a(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L30
            String r7 = r6.optString("toast");     // Catch: Throwable -> L30
            if (r7 != null) goto L6;
        L9:
            boolean r1 = true;
        L10:
            boolean r2 = true ^ r1;     // Catch: Throwable -> L30
            Unit r3 = null;
            if (r2 == true) goto L14;
            r7 = null;
        L14:
            if (r7 == null) goto L16;
            SaasCouponService r4 = this.a.this$0;     // Catch: Throwable -> L30
            RunnableC0121a r5 = new RunnableC0121a(r7, this);     // Catch: Throwable -> L30
            r4.t = r5;     // Catch: Throwable -> L30
            r4.d.postDelayed(r5, 1000);     // Catch: Throwable -> L30
        L16:
            SaasCouponService r8 = this.a.this$0;     // Catch: Throwable -> L30
            k r9 = r8.a;     // Catch: Throwable -> L30
            if (r9 == null) goto L28;
            WeakReference<Context> r10 = r8.j;     // Catch: Throwable -> L30
            if (r10 == null) goto L21;
            Context r11 = r10.get();     // Catch: Throwable -> L30
        L23:
            if ((r11 instanceof FragmentActivity) == true) goto L25;
            r11 = null;
        L25:
            FragmentActivity r12 = (FragmentActivity) r11;     // Catch: Throwable -> L30
            if (r12 == null) goto L28;
            r9.c(r12, new b(), null);     // Catch: Throwable -> L30
            r3 = Unit.INSTANCE;     // Catch: Throwable -> L30
            goto L28
        L21:
            r11 = null;
        L28:
            Result.constructor-impl(r3);     // Catch: Throwable -> L30
            return;
        L6:
            if (r7.length() == 0) goto L9;
            r1 = false;
        L30:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public SaasCouponService$fullPageEventOpenProductListSubscriber$2(SaasCouponService r1) {
        this.this$0 = r1;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1241invoke() {
        return invoke();
    }
}
