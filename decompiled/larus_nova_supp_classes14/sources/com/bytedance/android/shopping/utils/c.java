package com.bytedance.android.shopping.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.elements.ToastElement;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ToastElement a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Function0 c;

        public a(ToastElement r1, Context r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r15) {
            Integer r16 = (Integer) r15;
            ToastElement r17 = this.a;
            if (r17 != null) goto L9;
            Context r18 = this.b;
            if (r18 == null) goto L7;
            String r0 = th.a.g(r18, 2131894096);
        L8:
            UIUtils.displayToast(r18, r0);
        L18:
            this.c.invoke();
            return;
        L7:
            r0 = null;
            goto L8
        L9:
            int r1 = c.a;
            Context r2 = this.b;
            if (r2 == null) goto L18;
            LinearLayout r7 = new LinearLayout(r2);
            r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            int r8 = 1;
            r7.setOrientation(1);
            r7.setGravity(17);
            TextWithOneIconElementView r10 = new TextWithOneIconElementView(r2, null, 0, null, 30);
            TextWithOneIconElementView.b(r10, r17.getContent(), null, false, null, 14);
            r7.addView(r10);
            Toast r3 = new Toast(r2);
            r3.setView(r7);
            r3.setGravity(17, 0, 0);
            Float r19 = r17.getDuration();
            if (r19 != null) goto L15;
        L16:
            r8 = 0;
        L17:
            r3.setDuration(r8);
            r3.show();
            goto L18
        L15:
            if (r19.floatValue() >= 2.5f) goto L17;
            goto L16
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorV4VM a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        public b(AnchorV4VM r1, Context r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
            if (this.a.pathParams().a == false) goto L11;
            if (((Activity) this.b).isFinishing() == false) goto L8;
        L13:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L8:
            if (((Activity) this.b).isDestroyed() == true) goto L13;
            int r5 = c.a;     // Catch: Throwable -> L15
            c.a(this.b, this.c);     // Catch: Throwable -> L15
            goto L13
        L11:
            if (com.bytedance.android.shopping.service.c.b.a == false) goto L13;
            int r6 = c.a;     // Catch: Throwable -> L15
            c.a(this.b, this.c);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.utils.c$c, reason: collision with other inner class name */
    public static final class C0022c<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        public C0022c(e r1, Context r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
            if (this.a.e() == false) goto L11;
            if (((Activity) this.b).isFinishing() == false) goto L8;
        L13:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L8:
            if (((Activity) this.b).isDestroyed() == true) goto L13;
            int r5 = c.a;     // Catch: Throwable -> L15
            c.a(this.b, this.c);     // Catch: Throwable -> L15
            goto L13
        L11:
            if (com.bytedance.android.shopping.service.c.b.a == false) goto L13;
            int r6 = c.a;     // Catch: Throwable -> L15
            c.a(this.b, this.c);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public c() {
    }

    static {
    }

    public static final void a(Context r7, String r8) {
        Uri.Builder r9 = UriProtector.parse(r8).buildUpon();
        r9.appendQueryParameter("identifier", AnchorV4DataManager.d);
        ECLiveHybridUtil.k(r7, r9.build().toString(), false, false, false, null, 252);
        com.bytedance.android.ec.sdk.helper.q.a.e("detail_last_show_add_cart_popup", System.currentTimeMillis());
    }

    public static void d(Context r3, final ToastElement r4, final j73.d r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        final Function0 r1 = null;
        r5.g(e(r3, r4, 0, new AnchorV4ToastUtil$buildAddCartToast$disposable$1(r5, r4, r1)));
    }

    public static void b(Context r3, final ToastElement r4, final AnchorV4VM r5, final Function0 r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        com.bytedance.android.ec.core.async.a.a(e(r3, r4, 350, new AnchorV4ToastUtil$buildAddCartToast$1(r5, r4, r6)), r5);
    }

    public static void c(Context r3, final ToastElement r4, final e r5, final Function0 r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        r5.g(e(r3, r4, 350, new AnchorV4ToastUtil$buildAddCartToast$disposable$2(r5, r4, r6)));
    }

    public static Disposable e(Context r2, ToastElement r3, long r4, Function0 r6) {
        return Observable.just(0).delay(r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r3, r2, r6));
    }

    public static void f(Context r6, AnchorV4VM r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "anchorV4VM");
        if (r8 != null) goto L6;
        return;
    L6:
        if ((r6 instanceof Activity) == true) goto L8;
        return;
    L8:
        long r0 = 0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        r0 = com.bytedance.android.ec.sdk.helper.q.a.getLong("detail_last_show_add_cart_popup", 0);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if ((System.currentTimeMillis() - r0) <= 86400000) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == false) goto L22;
        com.bytedance.android.ec.core.async.a.a(Observable.just(0).delay(r9, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r7, r6, r8)), r7);
        return;
    L22:
        return;
    L16:
        r1 = false;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static void g(Context r6, e r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "anchorV4VM");
        if (r8 != null) goto L6;
        return;
    L6:
        if ((r6 instanceof Activity) == true) goto L8;
        return;
    L8:
        long r0 = 0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        r0 = com.bytedance.android.ec.sdk.helper.q.a.getLong("detail_last_show_add_cart_popup", 0);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if ((System.currentTimeMillis() - r0) <= 86400000) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == false) goto L22;
        r7.g(Observable.just(0).delay(r9, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0022c(r7, r6, r8)));
        return;
    L22:
        return;
    L16:
        r1 = false;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
