package y5;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.view.popup.anim.AnimController;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import k2.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f566180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimController f566181c;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f566182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f566183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f566184c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f566182a.f566181c.a(AnimController.AnimProcessType.DONE, true, null);
            Function0<Unit> r101 = this.f566184c;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f566182a.f566181c.a(AnimController.AnimProcessType.DONE, true, null);
            Function0<Unit> r101 = this.f566184c;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f566182a.f566180b.setVisibility(0);
            this.f566182a.f566181c.a(AnimController.AnimProcessType.DOING, true, this.f566183b.element);
        }

        public a(b r100, Ref.ObjectRef<String> r101, Function0<Unit> r102) {
            this.f566182a = r100;
            this.f566183b = r101;
            this.f566184c = r102;
        }
    }

    @Override // x5.a
    public final void invoke() {
        AppletPopupSchemaParam.getRealTransitionAnimation$default(this.f566179a, this.f566180b.getContext(), false, 2, null);
    }

    public final String a(boolean r100) {
        String r101 = this.f566179a.getRealTransitionAnimation(this.f566180b.getContext(), r100);
        if (Intrinsics.areEqual(r101, AnimationStyle.START.getValue()) == false) goto L10;
        int r102 = z5.a.f570044a;
        if (z5.a.a(this.f566180b.getContext()) == false) goto L8;
        return AnimationStyle.RIGHT.getValue();
    L8:
        return AnimationStyle.LEFT.getValue();
    L10:
        if (Intrinsics.areEqual(r101, AnimationStyle.END.getValue()) == false) goto L17;
        int r103 = z5.a.f570044a;
        if (z5.a.a(this.f566180b.getContext()) == false) goto L15;
        return AnimationStyle.LEFT.getValue();
    L15:
        return AnimationStyle.RIGHT.getValue();
    L17:
        return r101;
    }

    public b(AppletPopupSchemaParam r100, View r101, AnimController r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "animController");
        this.f566179a = r100;
        this.f566180b = r101;
        this.f566181c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    public final void b(v5.a r110, int r111, Function0<Unit> r210) {
        boolean r100 = false;
        if (this.f566181c.f37826a == AnimController.AnimProcessType.NONE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = a(true);
        r102.element = r103;
        if (Intrinsics.areEqual(r103, AnimationStyle.ZOOM.getValue()) == false) goto L52;
        PathInterpolator r104 = w5.d.f558292a;
        View r105 = this.f566180b;
        String r112 = this.f566179a.getFloatingPageName();
        AnimController r113 = this.f566181c;
        Intrinsics.checkNotNullParameter(r105, "transitionView");
        Intrinsics.checkNotNullParameter(r112, "floatingPageName");
        Intrinsics.checkNotNullParameter(r113, "animController");
        i2.j r114 = i2.i.f488034a;
        s r115 = i2.i.a.a().j();
        if (r115 != null) goto L14;
    L49:
        if (r100 == false) goto L51;
        return;
    L51:
        r102.element = AnimationStyle.SLIDE.getValue();
        goto L52
    L14:
        if (Intrinsics.areEqual(r115.getPageInfo().getPageName(), r112) == true) goto L16;
    L18:
        boolean r116 = false;
    L19:
        if (r116 == false) goto L49;
        Rect r117 = i2.i.a.a().b();
        if (r117 == null) goto L49;
        com.bytedance.ai.view.popup.anim.b r118 = new com.bytedance.ai.view.popup.anim.b(r105, r113, r210);
        if (r105.getWidth() > 0) goto L38;
        l r119 = l.f37675a;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r120 = AppletRuntimeManager.f36749d;
        if (r120 == null) goto L29;
        Activity r121 = r120.currentActivity();
    L30:
        if (r121 != null) goto L32;
        int r122 = l.c(null);
    L39:
        com.bytedance.ai.utils.g r106 = com.bytedance.ai.utils.g.f37637a;
        r106.i("AppletPopup", "zoomIn: hide floating widget");
        i2.i.a.a().a(r115.getPageID(), false);
        r106.i("AppletPopup", "zoomIn: zoomIn with Animation");
        r106.i("AppletPopup", "zoomUpAnimation " + r117.flattenToString());
        r105.setPivotX(0.0f);
        r105.setPivotY(0.0f);
        r105.setScaleX(r117.width() / r122);
        r105.setScaleY(r117.height() / r111);
        r105.setTranslationX(r117.left);
        r105.setTranslationY(r117.top - (l.b(null) - r111));
        r105.setAlpha(0.0f);
        r105.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).alpha(1.0f).translationX(0.0f).translationY(0.0f).setInterpolator(w5.d.f558292a).setDuration(300).setListener(r118).start();
        View r107 = r105.getRootView();
        if (r107 == null) goto L48;
        ViewPropertyAnimator r108 = r107.animate();
        if (r108 == null) goto L48;
        ViewPropertyAnimator r109 = r108.alpha(1.0f);
        if (r109 == null) goto L48;
        ViewPropertyAnimator r123 = r109.setDuration(300);
        if (r123 == null) goto L48;
        r123.start();
    L48:
        r100 = true;
        goto L49
    L32:
        Rect r124 = new Rect();
        View r125 = r121.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L37;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r126 = ThreadMethodProxy.currentThread();
        if (r126 == com.larus.home.impl.utils.c.f346341a) goto L37;
        com.larus.home.impl.utils.c.a(r126, "getDecorView");
    L37:
        r125.getWindowVisibleDisplayFrame(r124);
        r122 = r124.right - r124.left;
        goto L39
    L29:
        r121 = null;
        goto L30
    L38:
        r122 = r105.getWidth();
        goto L39
    L16:
        if (i2.i.a.a().e() == false) goto L18;
        r116 = true;
    L52:
        a r127 = new a(this, r102, r210);
        String r128 = (String) r102.element;
        if (Intrinsics.areEqual(r128, AnimationStyle.SLIDE.getValue()) == false) goto L56;
        this.f566180b.setVisibility(4);
        View r129 = this.f566180b;
        r129.setTranslationY(r111);
        r129.animate().translationY(0.0f).setDuration(this.f566179a.getResizeDurationInMillSeconds()).setListener(r127);
    L81:
        if (r110 == null) goto L83;
        r110.b(this.f566180b.animate());
    L83:
        this.f566180b.animate().start();
        return;
    L56:
        if (Intrinsics.areEqual(r128, AnimationStyle.LEFT.getValue()) == false) goto L67;
        this.f566180b.setVisibility(4);
        DisplayMetrics r130 = new DisplayMetrics();
        if ((this.f566180b.getContext() instanceof Activity) == false) goto L60;
        Context r131 = this.f566180b.getContext();
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r132 = ((Activity) r131).getWindowManager();
    L61:
        if (r132 == null) goto L65;
        Display r133 = r132.getDefaultDisplay();
        if (r133 == null) goto L65;
        r133.getMetrics(r130);
    L65:
        View r134 = this.f566180b;
        r134.setTranslationX(-r130.widthPixels);
        r134.animate().translationX(0.0f).setDuration(this.f566179a.getResizeDurationInMillSeconds()).setListener(r127);
        goto L81
    L60:
        Object r135 = this.f566180b.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type android.view.WindowManager");
        r132 = (WindowManager) r135;
        goto L61
    L67:
        if (Intrinsics.areEqual(r128, AnimationStyle.RIGHT.getValue()) == false) goto L78;
        this.f566180b.setVisibility(4);
        DisplayMetrics r136 = new DisplayMetrics();
        if ((this.f566180b.getContext() instanceof Activity) == false) goto L71;
        Context r137 = this.f566180b.getContext();
        Intrinsics.checkNotNull(r137, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r138 = ((Activity) r137).getWindowManager();
    L72:
        if (r138 == null) goto L76;
        Display r139 = r138.getDefaultDisplay();
        if (r139 == null) goto L76;
        r139.getMetrics(r136);
    L76:
        View r140 = this.f566180b;
        r140.setTranslationX(r136.widthPixels);
        r140.animate().translationX(0.0f).setDuration(this.f566179a.getResizeDurationInMillSeconds()).setListener(r127);
        goto L81
    L71:
        Object r141 = this.f566180b.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r141, "null cannot be cast to non-null type android.view.WindowManager");
        r138 = (WindowManager) r141;
        goto L72
    L78:
        if (Intrinsics.areEqual(r128, AnimationStyle.AUTO.getValue()) == false) goto L80;
        this.f566180b.setVisibility(4);
        View r142 = this.f566180b;
        r142.setAlpha(0.0f);
        r142.animate().alpha(1.0f).setDuration(this.f566179a.getResizeDurationInMillSeconds()).setListener(r127);
        goto L81
    L80:
        this.f566181c.a(AnimController.AnimProcessType.DONE, true, null);
        r210.invoke();
        Unit r143 = Unit.INSTANCE;
        goto L81
    L5:
        r101 = false;
        goto L6
    }
}
