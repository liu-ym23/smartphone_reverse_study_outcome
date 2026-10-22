package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedBottomPanelDialog;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.BottomPanelSwitch;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.collect.serviceapi.AoCollectService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoFeedGesturePresenter extends g04.a<jz3.a> implements r0.a {
    public static final /* synthetic */ int r = 0;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final View f;
    public final FeedGesturePresenterConfig g;
    public final GestureDetector h;
    public final com.bytedance.awemeopen.apps.framework.utils.h i;
    public boolean j;
    public boolean k;
    public final k l;
    public final r24.c m;
    public final Lazy n;
    public boolean o;
    public jz3.a p;
    public boolean q;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements BottomPanelSwitch.b {
        public final /* synthetic */ VideoFeedGesturePresenter a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.BottomPanelSwitch.b
        public final void a() {
            this.a.e.c.turnOnAutoPlaySwitch();
            zx3.a.c(this.a.getContext(), 2131894140).d();
            AosEventReporter r0 = AosEventReporter.a;
            VideoFeedGesturePresenter r1 = this.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = r1.e;
            jz3.a r3 = r1.p;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r3 = null;
        L5:
            r0.getClass();
            AosEventReporter.f(r2, r3, "on");
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.BottomPanelSwitch.b
        public final void b() {
            this.a.e.c.turnOffAutoPlaySwitch();
            zx3.a.c(this.a.getContext(), 2131894139).d();
            AosEventReporter r0 = AosEventReporter.a;
            VideoFeedGesturePresenter r1 = this.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = r1.e;
            jz3.a r3 = r1.p;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r3 = null;
        L5:
            r0.getClass();
            AosEventReporter.f(r2, r3, "off");
        }

        public b(VideoFeedGesturePresenter r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0 {
        public c() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0
        public final void onClose() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0
        public final void onOpen() {
        }
    }

    @Override // g04.a
    public final void g() {
        com.bytedance.awemeopen.apps.framework.utils.c r0 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        String r1 = this.e.c.getPageConfig().getHostEnterFrom();
        String r2 = this.e.c.sceneId();
        jz3.a r3 = this.p;
        jz3.a r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L5:
        String r5 = r3.a.c();
        jz3.a r6 = this.p;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L9:
        r14.a0 r7 = r4.a.d;
        if (r7 == null) goto L13;
        String r8 = r7.a();
        if (r8 == null) goto L13;
    L14:
        com.bytedance.awemeopen.apps.framework.utils.c.c(new k34.a(r1, r2, r5, r8));
        return;
    L13:
        r8 = "";
        goto L14
    L8:
        r4 = r6;
        goto L9
    }

    @Override // g04.a
    public final void h() {
        this.e.e.d.getLifecycle().removeObserver(this.l);
    }

    @Override // g04.a
    public final void i() {
        com.bytedance.awemeopen.apps.framework.utils.c r0 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        jz3.a r1 = this.p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r1 = null;
    L5:
        String r2 = r1.a.c();
        k34.b r3 = com.bytedance.awemeopen.apps.framework.utils.c.b;
        if (r3 == null) goto L9;
        r3.M1();
        com.bytedance.awemeopen.appserviceimpl.user.a.a.a(r2);
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        this.p = r3;
        this.e.e.d.getLifecycle().addObserver(this.l);
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r2) {
        boolean r0 = false;
        if (r2 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.o == true) goto L11;
        return;
    L11:
        if (this.q == true) goto L18;
        Function0<Boolean> r3 = this.g.b;
        if (r3 == null) goto L19;
        Boolean r4 = (Boolean) r3.invoke();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r2.what != 0) goto L7;
        r0 = true;
        goto L7
    }

    public final void m(MotionEvent r28) {
        jz3.a r1 = this.p;
        jz3.a r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r1 = null;
    L6:
        if (p0.e(r1.a.r().b) == false) goto L8;
        return;
    L8:
        if (r28 == null) goto L12;
        View r3 = iz3.a.b(this.e);
        if (r3 == null) goto L12;
        r3.dispatchTouchEvent(MotionEvent.obtain(r28.getDownTime(), r28.getEventTime(), 3, r28.getX(), r28.getY(), r28.getMetaState()));
    L12:
        final String r4 = this.e.c.sceneId();
        Activity r5 = this.e.getActivity();
        Intrinsics.checkNotNull(r5);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r6 = this.e;
        jz3.a r7 = this.p;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r7 = null;
    L15:
        AosFeedBottomPanelDialog r8 = new AosFeedBottomPanelDialog(r5, r6, r7, new c());
        r8.q = new VideoFeedGesturePresenter$showBottomPanel$2(this, r4);
        Boolean r9 = this.e.c.showAutoPlaySwitch();
        if (r9 == null) goto L18;
        boolean r10 = r9.booleanValue();
    L20:
        if (Intrinsics.areEqual(r4, "homepage_hot") == false) goto L22;
    L25:
        boolean r11 = true;
    L26:
        boolean r12 = ((Boolean) this.g.f.invoke()).booleanValue();
        if (Intrinsics.areEqual(r4, "collection_feed") == true) goto L41;
        z44.a r13 = AosExtConfig.b.b0();
        if (r13 == null) goto L31;
        boolean r14 = r13.a;
    L32:
        if (r14 == false) goto L41;
        AoCollectService r15 = (AoCollectService) this.n.getValue();
        if (r15 == null) goto L36;
        boolean r16 = r15.u();
    L37:
        if (r16 == true) goto L41;
        if (this.e.c.getPageConfig().isTeenagerModel() == true) goto L41;
        boolean r17 = true;
    L42:
        r8.L0(r11, r12, r10, r17);
        if (r10 == false) goto L49;
        Boolean r18 = this.e.c.getAutoPlayState();
        if (r18 == null) goto L47;
        boolean r19 = r18.booleanValue();
    L48:
        r8.p = r19;
        b r20 = new b(this);
        Intrinsics.checkNotNullParameter(r20, "listener");
        r8.o = r20;
        goto L49
    L47:
        r19 = true;
    L49:
        Activity r21 = this.e.getActivity();
        if ((r21 instanceof Activity) == true) goto L53;
        r21 = null;
    L53:
        if (r21 != null) goto L55;
    L62:
        AosEventReporter r22 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r23 = this.e;
        jz3.a r24 = this.p;
        if (r24 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L66:
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r2, "data");
        String r110 = r23.c.sceneId();
        if (r28 == null) goto L69;
        float r25 = r28.getRawX() / com.bytedance.awemeopen.apps.framework.utils.d0.d(r23.getActivity());
        float r26 = r28.getRawY() / com.bytedance.awemeopen.apps.framework.utils.d0.c(r23.getActivity());
    L70:
        d14.a r27 = b14.a.a;
        t24.a r29 = b14.a.a(t24.a.class);
        User r30 = r2.a.f();
        if (r30 == null) goto L76;
        String r31 = r30.u();
        if (r31 == null) goto L76;
        String r111 = r31;
    L77:
        String r112 = r2.a.c();
        String r32 = AosEventReporter.b(r2.a, r23.c.getPageConfig());
        if (r32 != null) goto L80;
        String r113 = "";
    L81:
        r14.a0 r33 = r2.a.d;
        if (r33 == null) goto L87;
        String r34 = r33.a();
        if (r34 == null) goto L87;
        String r114 = r34;
    L88:
        String r115 = AosEventReporter.c(r2.a);
        boolean r116 = AosEventReporter.e(r2.a);
        boolean r117 = r23.c.getPageConfig().isCardMode();
        User r35 = r2.a.f();
        if (r35 != null) goto L91;
    L93:
        boolean r118 = false;
    L95:
        if (r2.a.W() == false) goto L97;
        String r36 = "origin";
    L98:
        String r210 = r36;
        String r37 = r23.c.getPageConfig().getPreviousPage();
        if (r37 != null) goto L101;
        String r211 = "";
    L102:
        r29.w3(r110, r111, r112, r113, r114, r115, r116, r117, r118, null, r25, r26, r210, r211, r2.a.u(), r23.c.getPageConfig().getHostEnterFrom(), r23.c.getPageConfig().getHostExtraParams());
        return;
    L101:
        r211 = r37;
        goto L102
    L97:
        r36 = "sdk";
        goto L98
    L91:
        if (r35.R() != true) goto L93;
        r118 = true;
    L87:
        r114 = "";
        goto L88
    L80:
        r113 = r32;
    L76:
        r111 = "";
        goto L77
    L69:
        r25 = 0.0f;
        r26 = 0.0f;
        goto L70
    L65:
        r2 = r24;
        goto L66
    L55:
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L105;
        DialogLancet.handleBlockedDialogShow(r8);
    L59:
        this.e.c.getEnterCleanMode().setValue(Boolean.TRUE);
        Function0<Unit> r38 = this.g.g;
        if (r38 == null) goto L62;
        r38.invoke();
        goto L62
    L105:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L104
    L58:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L59
    L36:
        r16 = false;
        goto L37
    L31:
        r14 = false;
    L41:
        r17 = false;
        goto L42
    L22:
        if (Intrinsics.areEqual(r4, "video_channel") == true) goto L25;
        r11 = false;
        goto L26
    L18:
        r10 = false;
        goto L20
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.k] */
    public VideoFeedGesturePresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3, View r4, FeedGesturePresenterConfig r5) {
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r4, "gestureView");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r3.a);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        r0 r6 = new r0(this);
        d14.a r7 = b14.a.a;
        this.m = b14.a.a(r24.c.class);
        this.n = LazyKt.lazy(VideoFeedGesturePresenter$bdpCollectService$2.INSTANCE);
        this.o = true;
        Reflection.getOrCreateKotlinClass(VideoFeedGesturePresenter.class).getSimpleName();
        this.l = new k(this);
        this.h = new GestureDetector(getContext(), new m(this));
        int r8 = com.bytedance.awemeopen.apps.framework.utils.g.a;
        Context r9 = getContext();
        n r0 = new n(this);
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r6, "handler");
        Intrinsics.checkNotNullParameter(r0, "listener");
        this.i = new com.bytedance.awemeopen.apps.framework.utils.h(r9, r0, r6);
        r4.setOnTouchListener(new l(this));
    }
}
