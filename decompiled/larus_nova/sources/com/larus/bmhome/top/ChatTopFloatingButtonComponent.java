package com.larus.bmhome.top;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.component.list.v4;
import com.larus.bmhome.chat.component.list.w4;
import com.larus.bmhome.top.view.BackTopButton;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import ds8.c;
import ds8.e;
import ds8.f;
import ds8.g;
import ds8.h;
import ds8.i;
import ds8.j;
import ds8.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import s1a.d;
import v19.i5;
import va8.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0002J\b\u00103\u001a\u00020\"H\u0017J\b\u00104\u001a\u00020\"H\u0016J\b\u00105\u001a\u00020'H\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020'H\u0016J\u0016\u00108\u001a\u00020\"2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0016\u0010:\u001a\u00020\"2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/top/ChatTopFloatingButtonComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "bindingViewStub", "Landroid/view/ViewStub;", "binding", "Lcom/larus/chat/core/impl/databinding/LarusPageChatTopFloatingButtonBinding;", "getBinding", "()Lcom/larus/chat/core/impl/databinding/LarusPageChatTopFloatingButtonBinding;", "fragmentOutAbility", "Lcom/larus/chat/api/IChatFragmentOutAbility;", "getFragmentOutAbility", "()Lcom/larus/chat/api/IChatFragmentOutAbility;", "fragmentOutAbility$delegate", "Lkotlin/Lazy;", "totalY", "", "showClipHeight", "showAnimator", "Landroid/animation/AnimatorSet;", "hideClipHeight", "hideAnimator", "hideTopButtonDuration", "", "topButtonOnClick", "Lkotlin/Function0;", "", "topButtonHideCallback", "mainHandler", "Landroid/os/Handler;", "isForceHide", "", "onViewCreated", "view", "Landroid/view/View;", "initBinding", "showTopButtonWithAnimation", "hideTopButtonWithAnimation", "isEventInView", "event", "Landroid/view/MotionEvent;", "hideTopButtonTask", "Ljava/lang/Runnable;", "show", "hide", "isShow", "setForceHide", "forceHide", SendEventContainerMethodParamModel.EventKinds.onClick, "callback", "onHideCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTopFloatingButtonComponent extends BaseContentWidget implements w {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f314716z = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f314717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewStub f314718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LarusPageChatTopFloatingButtonBinding f314719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f314720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f314721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f314722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f314723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f314724t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<Unit> f314725u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Unit> f314726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f314727w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f314728x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f314729y;

    public static final class a {
    }

    public static final class b implements Function0<ry8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f314730a;

        public b(AttachReceiver r100) {
            this.f314730a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ry8.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ry8.a invoke() {
            AttachReceiver r100 = this.f314730a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r100).o(Reflection.getOrCreateKotlinClass(ry8.a.class));
        }
    }

    static {
    }

    public final LarusPageChatTopFloatingButtonBinding Y2() {
        if (this.f314719o != null) goto L6;
        this.f314719o = h3();
    L6:
        return this.f314719o;
    }

    public final LarusPageChatTopFloatingButtonBinding h3() {
        ViewStub r100 = this.f314718n;
        if (r100 == null) goto L12;
        r100.setLayoutResource(R.layout.larus_page_chat_top_floating_button);
        View r101 = r100.inflate();
        if (r101 == null) goto L12;
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-2, -2);
        r102.startToStart = 0;
        r102.endToEnd = 0;
        r102.bottomToBottom = R.id.tv_login_guide_banner;
        r101.setLayoutParams(r102);
        BackTopButton r103 = (BackTopButton) ViewBindings.findChildViewById(r101, R.id.back_top_button);
        if (r103 == null) goto L11;
        FrameLayout r104 = (FrameLayout) r101;
        LarusPageChatTopFloatingButtonBinding r105 = new LarusPageChatTopFloatingButtonBinding(r104, r103, r104);
        this.f314718n = null;
        return r105;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.back_top_button)));
    L12:
        return null;
    }

    @Override // va8.w
    public final void show() {
        if (this.f314728x == false) goto L5;
        return;
    L5:
        if (d() == true) goto L19;
        this.f314727w.removeCallbacks(this.f314729y);
        final LarusPageChatTopFloatingButtonBinding r100 = Y2();
        if (r100 == null) goto L10;
        this.f314722r = 0;
        r100.f324096a.setOutlineProvider(new j(this));
        r100.f324096a.setClipToOutline(true);
        FrameLayout r101 = r100.f324096a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), this.f314721q});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f324096a, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100.f324097b, "alpha", new float[]{0.0f, 1.0f});
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, r100.f324096a.getHeight()});
        r105.addUpdateListener(new g(this, r100));
        r105.setDuration(90);
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r102, r103, r104, r105});
        r106.setDuration(300);
        r106.addListener(new k(r100, this));
        r106.start();
    L10:
        ry8.a r107 = (ry8.a) this.f314720p.getValue();
        if (r107 == null) goto L13;
        TouchInterceptingView r108 = r107.Rv();
    L14:
        if (r108 == null) goto L16;
        e1.x(r108);
        r108.setEventHandler(new e(this));
    L16:
        this.f314727w.postDelayed(this.f314729y, this.f314724t);
        return;
    L13:
        r108 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [ds8.c] */
    public ChatTopFloatingButtonComponent() {
        this.f314717m = R.id.top_floating_button_container;
        this.f314720p = LazyKt.lazy(new b(this));
        this.f314721q = i5.o0();
        this.f314724t = z2.f365865a.chatTopFloatButtonShowTime();
        this.f314727w = new Handler(Looper.getMainLooper());
        this.f314729y = new c(this);
    }

    public final boolean d() {
        LarusPageChatTopFloatingButtonBinding r100 = Y2();
        if (r100 == null) goto L13;
        BackTopButton r101 = r100.f324097b;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getVisibility() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @Override // va8.w
    public final void hide() {
        if (d() == true) goto L5;
        return;
    L5:
        final LarusPageChatTopFloatingButtonBinding r100 = Y2();
        if (r100 == null) goto L8;
        this.f314723s = r100.f324096a.getHeight();
        r100.f324096a.setOutlineProvider(new h(this));
        r100.f324096a.setClipToOutline(true);
        FrameLayout r101 = r100.f324096a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), 0.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f324096a, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100.f324097b, "alpha", new float[]{1.0f, 0.0f});
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r100.f324096a.getHeight(), 0});
        r105.addUpdateListener(new f(this, r100));
        r105.setDuration(90);
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r102, r103, r104, r105});
        r106.setDuration(300);
        r106.addListener(new i(r100, this));
        r106.start();
    L8:
        ry8.a r107 = (ry8.a) this.f314720p.getValue();
        if (r107 == null) goto L13;
        TouchInterceptingView r108 = r107.Rv();
        if (r108 == null) goto L13;
        e1.o(r108);
        r108.setEventHandler(new ds8.d());
    L13:
        Function0<Unit> r109 = this.f314726v;
        if (r109 == null) goto L17;
        r109.invoke();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f314717m;
    }

    @Override // va8.w
    public final void H9(boolean r100) {
        this.f314728x = r100;
        if (r100 == false) goto L6;
        hide();
        return;
    }

    @Override // va8.w
    public final void VP(v4 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f314725u = r100;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f314717m = r100;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewStub) == false) goto L8;
        this.f314718n = (ViewStub) r100;
        if (Y2() != null) goto L9;
        this.f314719o = h3();
        return;
    L9:
        return;
    }

    @Override // va8.w
    public final void v90(w4 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f314726v = r100;
    }
}
