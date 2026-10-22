package com.ss.android.lark.compose.foundation.toast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f417639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f417640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowManager f417641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f417642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UDShadowLayout f417643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f417644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f417645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f417647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDToast.c f417648j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.foundation.toast.b$b, reason: collision with other inner class name */
    public static final class C4907b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f417649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f417650b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f417649a.b();
            this.f417650b.invoke();
        }

        public C4907b(b r100, Function0<Unit> r101) {
            this.f417649a = r100;
            this.f417650b = r101;
        }
    }

    static {
    }

    public final void b() {
        this.f417640b = 0;
        i r100 = this.f417642d;
        ViewPropertyAnimator r101 = r100.f417660c;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        r100.f417660c = null;
        if (this.f417643e.isAttachedToWindow() == false) goto L8;
        this.f417641c.removeView(this.f417643e);
    L8:
        UDToast.c r102 = this.f417648j;
        if (r102 == null) goto L12;
        r102.a();
        return;
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void cancel() {
        if (this.f417640b >= 1) goto L5;
        return;
    L5:
        Handler r100 = FlowActionToastManager.f417620a;
        Intrinsics.checkNotNullParameter(this, "toast");
        if (FlowActionToastManager.f417620a != null) goto L9;
        FlowActionToastManager.f417620a = new Handler(Looper.getMainLooper(), e.f417653a);
    L9:
        Handler r101 = FlowActionToastManager.f417620a;
        if (r101 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r101 = null;
    L12:
        r101.post(new FlowActionToastManager$remove$1(this));
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final boolean isShowing() {
        if (this.f417640b != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void show() {
        boolean r100 = true;
        if (this.f417640b < 1) goto L5;
        return;
    L5:
        this.f417640b = 1;
        Handler r101 = FlowActionToastManager.f417620a;
        Intrinsics.checkNotNullParameter(this, "toast");
        if (this.f417639a.isDestroyed() == false) goto L8;
    L15:
        r100 = false;
    L16:
        if (r100 == true) goto L21;
        this.f417640b = 0;
        UDToast.c r102 = this.f417648j;
        if (r102 == null) goto L22;
        r102.a();
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (this.f417639a.isFinishing() == true) goto L15;
        if (FlowActionToastManager.f417620a != null) goto L14;
        FlowActionToastManager.f417620a = new Handler(Looper.getMainLooper(), e.f417653a);
    L14:
        FlowActionToastManager.a r103 = new FlowActionToastManager.a(this);
        FlowActionToastManager.f417621b.addLast(r103);
        this.f417639a.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) FlowActionToastManager.f417622c.getValue());
        FlowActionToastManager.b();
        goto L16
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.ss.android.lark.compose.foundation.toast.a.f417638a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Activity r102 = com.ss.android.lark.compose.foundation.toast.a.a(r100);
        if (r102 == null) goto L7;
        this.f417639a = r102;
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.WindowManager");
        this.f417641c = (WindowManager) r103;
        i r104 = new i(r100);
        this.f417642d = r104;
        this.f417647i = 4000;
        this.f417643e = r104.f417659b.f424293a;
        return;
    L7:
        throw new IllegalArgumentException((r100 + " is not an Activity!").toString());
    }

    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onDismissed");
        final i r101 = this.f417642d;
        C4907b r102 = new C4907b(this, r100);
        ViewPropertyAnimator r103 = r101.f417659b.f424293a.animate().setDuration(200).alpha(0.0f).setListener(new j(r102, r101, new FlowToastViewController$startDismissAnimate$1(r101)));
        r103.start();
        r101.f417660c = r103;
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void setIcon(int r100) {
        i r101 = this.f417642d;
        r101.a(UDIconUtils.getIconDrawable(r101.f417658a, r100));
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        i r101 = this.f417642d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "s");
        r101.f417659b.f424297e.setText(r100);
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f417642d.a(r100);
    }
}
