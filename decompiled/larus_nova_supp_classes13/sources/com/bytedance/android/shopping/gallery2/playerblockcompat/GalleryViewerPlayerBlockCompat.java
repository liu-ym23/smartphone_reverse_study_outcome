package com.bytedance.android.shopping.gallery2.playerblockcompat;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper$Companion$setDialogNavBarColor$;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ee3.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/playerblockcompat/GalleryViewerPlayerBlockCompat;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryViewerPlayerBlockCompat extends GalleryViewer {
    public final f d;
    public Function0<Unit> e;

    public static final class a implements f.b {
        public final /* synthetic */ GalleryViewerPlayerBlockCompat a;

        public a(GalleryViewerPlayerBlockCompat r1) {
            this.a = r1;
        }

        @Override // ee3.f.b
        public final void a(int r2) {
            this.a.getPager().smoothScrollToPosition(r2);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GalleryViewerPlayerBlockCompat a;

        public b(GalleryViewerPlayerBlockCompat r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryViewerPlayerBlockCompat, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (isShowing() == false) goto L8;
        Function0<Unit> r0 = this.e;
        if (r0 == null) goto L7;
        Unit r1 = (Unit) r0.invoke();
    L7:
        this.e = null;
    L8:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryViewerPlayerBlockCompat(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, new GalleryPlayerBlockCompatAdapter());
        f r7 = new f();
        this.d = r7;
        r7.d = new a(this);
        r7.e = new b(this);
        Map r8 = PdpBottomNavBarHelper.c;
        Function1<Function0<? extends Unit>, Unit> r9 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r9, "setDismissAction");
        if (PdpBottomNavBarHelper.e == false) goto L17;
        Window r0 = getWindow();
        if (r0 == null) goto L7;
        r0.setNavigationBarColor(-16777216);
        Lazy r2 = UIUtils.a;
        UIUtils.b(r0, -16777216);
    L7:
        Window r1 = getWindow();
        if (r1 == null) goto L18;
        View r3 = r1.getDecorView();
        if (c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L14;
        c.a(r4, "getDecorView");
    L14:
        if (r3 == null) goto L19;
        int r5 = com.bytedance.commerce.base.view.a.d;
        com.bytedance.commerce.base.view.a r10 = new com.bytedance.commerce.base.view.a(r3, new PdpBottomNavBarHelper$Companion$setDialogNavBarColor$.inlined.doOnPreDraw.1(r3, this, -16777216, r9));
        r3.getViewTreeObserver().addOnPreDrawListener(r10);
        r3.addOnAttachStateChangeListener(r10);
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void b(ee3.c r2) {
        GalleryAdapter r0 = this.c;
        if (r0 == null) goto L7;
        ((GalleryPlayerBlockCompatAdapter) r0).g = r2;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter");
    }

    public final void onPageSelected(int r2) {
        super.onPageSelected(r2);
        GalleryAdapter r0 = this.c;
        if (r0 == null) goto L11;
        if (((GalleryPlayerBlockCompatAdapter) r0).B2() == false) goto L12;
        if (r2 != 0) goto L8;
        this.d.d();
        return;
    L8:
        this.d.c();
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter");
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void onTransitionEnd(int r2) {
        if (r2 != 0) goto L13;
        GalleryAdapter r3 = this.c;
        if (r3 == null) goto L11;
        if (((GalleryPlayerBlockCompatAdapter) r3).B2() == false) goto L12;
        this.d.a(getRootContainer());
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter");
    }
}
