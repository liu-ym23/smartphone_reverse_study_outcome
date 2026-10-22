package com.bytedance.ee.bear.tts.impl;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.lark.dependency.l0;
import com.bytedance.ee.bear.lark.dependency.u;
import com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment;
import com.bytedance.ee.bear.tts.ITtsRecorder$ETtsViewType;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxFloatView;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxFullscreenPlayerView;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxModalControllerView;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxPlaylistView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements mo5.f {
    public final mo5.a a;
    public boolean b;
    public final b c;
    public final a d;
    public final com.bytedance.ee.bear.tts.media.b e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public TtsLynxFloatView i;
    public BaseLynxDialogFragment j;
    public TtsLynxFullscreenPlayerView k;
    public TtsLynxPlaylistView l;
    public int m;
    public FragmentActivity n;
    public boolean o;
    public boolean p;

    public final class a implements LifecycleEventObserver {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3 == Lifecycle.Event.ON_DESTROY) goto L5;
            return;
        L5:
            r2.getLifecycle().removeObserver(this);
            FragmentActivity r4 = this.a.n;
            if (r4 == null) goto L10;
            Lifecycle r5 = r4.getLifecycle();
            if (r5 == null) goto L10;
            r5.removeObserver(this);
        L10:
            this.a.n = null;
        }
    }

    public final class b implements y {
        public final a a;
        public final /* synthetic */ d b;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d r0 = this.a;     // Catch: Throwable -> L8
                if (r0.b == false) goto L5;
                return;
            L5:
                if (r0.l() == true) goto L15;
                tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, ");     // Catch: Throwable -> L8
                this.a.h();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public b(d r2) {
            this.b = r2;
            this.a = new a(r2);
        }

        public final void f(y.a r3, y.a r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            if (r4.c == false) goto L5;
            tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, enter foreground, check float view later.");
            com.bytedance.ee.util.ui.j.e(this.a);
            com.bytedance.ee.util.ui.j.d(this.a, 500);
            return;
        L5:
            tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, enter background, dismissFloatView");
            com.bytedance.ee.util.ui.j.e(this.a);
            this.b.c();
        }
    }

    public static final class c {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.d$d, reason: collision with other inner class name */
    public final class C0190d implements BaseUDBottomSheetDialogFragment.b, LifecycleEventObserver {
        public final /* synthetic */ d a;

        public C0190d(d r1) {
            this.a = r1;
        }

        public final void a(BaseUDBottomSheetDialogFragment r11) {
            Intrinsics.checkNotNullParameter(r11, "dialogFragment");
            r11.ka0(this);
            boolean r5 = false;
            if ((r11 instanceof TtsLynxModalControllerView) == false) goto L25;
            d r0 = this.a;
            BaseLynxDialogFragment r9 = r0.j;
            if (r9 == null) goto L7;
            r9.ka0(r0.q());
        L7:
            d r1 = this.a;
            r1.j = null;
            List<mo5.g> r2 = mo5.h.d(r1.a);
            if (r2 != null) goto L10;
        L13:
            boolean r3 = true;
        L14:
            if (r3 == false) goto L16;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", album list is empty, destroy session.");
            this.a.j();
            return;
        L16:
            this.a.getClass();
            d.t();
            FragmentActivity r4 = ((TtsLynxModalControllerView) r11).getActivity();
            if (r4 != null) goto L19;
        L21:
            if (r5 == false) goto L23;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", changing configuration.");
            this.a.w();
            return;
        L23:
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", show float view.");
            this.a.w();
            this.a.h();
            return;
        L19:
            if (r4.isChangingConfigurations() != true) goto L21;
            r5 = true;
            goto L21
        L10:
            if (r2.isEmpty() == true) goto L13;
            r3 = false;
            goto L14
        L25:
            if ((r11 instanceof TtsLynxFullscreenPlayerView) == false) goto L47;
            d r6 = this.a;
            TtsLynxFullscreenPlayerView r10 = r6.k;
            if (r10 == null) goto L29;
            r10.ka0(r6.q());
        L29:
            d r7 = this.a;
            r7.k = null;
            List<mo5.g> r8 = mo5.h.d(r7.a);
            if (r8 != null) goto L32;
        L35:
            boolean r12 = true;
        L36:
            if (r12 == false) goto L38;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", album list is empty, destroy session.");
            this.a.j();
            return;
        L38:
            this.a.getClass();
            d.t();
            FragmentActivity r13 = ((TtsLynxFullscreenPlayerView) r11).getActivity();
            if (r13 != null) goto L41;
        L43:
            if (r5 == false) goto L45;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", changing configuration.");
            this.a.w();
            return;
        L45:
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r11 + ", show float view.");
            this.a.w();
            this.a.h();
            return;
        L41:
            if (r13.isChangingConfigurations() != true) goto L43;
            r5 = true;
            goto L43
        L32:
            if (r8.isEmpty() == true) goto L35;
            r12 = false;
            goto L36
        L47:
            if ((r11 instanceof TtsLynxPlaylistView) == false) goto L59;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed, playlistView: " + r11);
            d r14 = this.a;
            TtsLynxPlaylistView r15 = r14.l;
            if (r15 == null) goto L51;
            r15.ka0(r14.q());
        L51:
            d r16 = this.a;
            r16.l = null;
            r16.w();
            return;
        }

        public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3 != Lifecycle.Event.ON_DESTROY) goto L14;
            r2.getLifecycle().removeObserver(this);
            if ((r2 instanceof TtsLynxModalControllerView) == false) goto L8;
            d r4 = this.a;
            r4.j = null;
            d.m(r4);
            return;
        L8:
            if ((r2 instanceof TtsLynxFullscreenPlayerView) == false) goto L11;
            d r5 = this.a;
            r5.k = null;
            d.m(r5);
            return;
        L11:
            if ((r2 instanceof TtsLynxPlaylistView) == false) goto L17;
            this.a.l = null;
            return;
        L17:
            return;
        }
    }

    public interface e {
        void a(d r1);
    }

    public final class f implements View.OnAttachStateChangeListener {
        public final /* synthetic */ d a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public f(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            r2.removeOnAttachStateChangeListener(this);
            if ((r2 instanceof TtsLynxFloatView) == false) goto L9;
            d r3 = this.a;
            r3.o = false;
            TtsLynxFloatView r0 = r3.i;
            if (r0 == null) goto L7;
            r0.removeOnAttachStateChangeListener((f) r3.f.getValue());
        L7:
            this.a.i = null;
            return;
        }
    }

    @Override // mo5.f
    public final void c() {
        this.o = false;
        TtsLynxFloatView r0 = this.i;
        if (r0 == null) goto L5;
        tt5.a.h("TtsSession", "dismissFloatView, dismiss: " + r0);
        r0.a();
        r0.removeOnAttachStateChangeListener((f) this.f.getValue());
        this.i = null;
        return;
    L5:
        tt5.a.k("TtsSession", "dismissFloatView, not showing");
    }

    static {
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(LarkContext.getApplication());
        Boolean r0 = Boolean.valueOf(((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).isInit());
        if ((!r0.booleanValue()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.booleanValue();
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).init(false);
        return;
    }

    public static boolean s() {
        return !DowngradeSettingUtil.a("downgradeTtsWithoutFloatPermission");
    }

    public static boolean t() {
        ((l0) LarkContext.spiByDwarf(l0.class)).a();
        return false;
    }

    @Override // mo5.f
    public final void b() {
        TtsLynxFullscreenPlayerView r0 = this.k;
        if (r0 == null) goto L12;
        tt5.a.h("TtsSession", "dismissFullscreenPlayer, dismiss: " + r0);
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r0.ka0(q());
        this.k = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissFullscreenPlayer, not showing");
    }

    @Override // mo5.f
    public final void d() {
        if (this.b == false) goto L6;
        tt5.a.k("TtsSession", "showFullscreenPlayer, session already destroyed.");
        return;
    L6:
        TtsLynxFullscreenPlayerView r0 = this.k;
        if (r0 == null) goto L10;
        tt5.a.k("TtsSession", "showFullscreenPlayer, already showing: " + r0);
        return;
    L10:
        no5.a.a.getClass();
        FragmentActivity r1 = no5.a.a();
        if (r1 != null) goto L14;
        tt5.a.k("TtsSession", "showFullscreenPlayer, topActivity not found");
        n("showFullscreenPlayer");
        return;
    L14:
        p(r1);
        if (r(r1) == false) goto L17;
        TtsLynxFullscreenPlayerView r2 = new TtsLynxFullscreenPlayerView(this.a);
        this.k = r2;
        u(r1, r2, ForsetiNavOptions.DestinationStyle.FULL_SCREEN);
    L26:
        tt5.a.h("TtsSession", "showFullscreenPlayer, fullscreenPlayerView: " + this.k);
        mo5.g r3 = mo5.h.e(this.a);
        if (r3 == null) goto L35;
        to5.a r4 = r3.m();
        if (r4 == null) goto L36;
        r4.d(ITtsRecorder$ETtsViewType.FULLSCREEN_PLAYER);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        String r5 = TtsLynxFullscreenPlayerView.class.getName();
        TtsLynxFullscreenPlayerView r6 = o("showFullscreenPlayer", r1, r5);
        if (r6 != null) goto L20;
        r6 = new TtsLynxFullscreenPlayerView(this.a);
    L20:
        C0190d r7 = q();
        Intrinsics.checkNotNullParameter(r7, "listener");
        ((Set) ((BaseUDBottomSheetDialogFragment) r6).l.getValue()).add(r7);
        FragmentManager r8 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r5, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r6, r9) == false) goto L33;
    L25:
        this.k = r6;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r6.show(r8, r5);
        goto L25
    }

    @Override // mo5.f
    public final void e() {
        BaseLynxDialogFragment r0 = this.j;
        if (r0 == null) goto L12;
        tt5.a.h("TtsSession", "dismissModalController, dismiss: " + r0);
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r0.ka0(q());
        this.j = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissModalController, not showing");
    }

    @Override // mo5.f
    public final void f() {
        TtsLynxPlaylistView r0 = this.l;
        if (r0 == null) goto L12;
        tt5.a.h("TtsSession", "dismissPlaylist, dismiss: " + r0);
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r0.ka0(q());
        this.l = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissPlaylist, not showing");
    }

    @Override // mo5.f
    public final void g() {
        if (this.b == false) goto L6;
        tt5.a.k("TtsSession", "showPlaylist, session already destroyed.");
        return;
    L6:
        TtsLynxPlaylistView r0 = this.l;
        if (r0 == null) goto L10;
        tt5.a.k("TtsSession", "showPlaylist, already showing: " + r0);
        return;
    L10:
        no5.a.a.getClass();
        FragmentActivity r1 = no5.a.a();
        if (r1 != null) goto L14;
        tt5.a.k("TtsSession", "showPlaylist, topActivity not found");
        n("showPlaylist");
        return;
    L14:
        p(r1);
        if (r(r1) == false) goto L17;
        TtsLynxPlaylistView r2 = new TtsLynxPlaylistView(this.a);
        this.l = r2;
        u(r1, r2, ForsetiNavOptions.DestinationStyle.HALF_FLOAT);
    L26:
        tt5.a.h("TtsSession", "showPlaylist, playlistView: " + this.l);
        mo5.g r3 = mo5.h.e(this.a);
        if (r3 == null) goto L35;
        to5.a r4 = r3.m();
        if (r4 == null) goto L36;
        r4.d(ITtsRecorder$ETtsViewType.PLAYLIST);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        String r5 = TtsLynxPlaylistView.class.getName();
        TtsLynxPlaylistView r6 = o("showPlaylist", r1, r5);
        if (r6 != null) goto L20;
        r6 = new TtsLynxPlaylistView(this.a);
    L20:
        C0190d r7 = q();
        Intrinsics.checkNotNullParameter(r7, "listener");
        ((Set) ((BaseUDBottomSheetDialogFragment) r6).l.getValue()).add(r7);
        FragmentManager r8 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r5, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r6, r9) == false) goto L33;
    L25:
        this.l = r6;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r6.show(r8, r5);
        goto L25
    }

    @Override // mo5.f
    public final void h() {
        if (this.b == false) goto L5;
        tt5.a.k("TtsSession", "showFloatView, session already destroyed.");
        return;
    L5:
        TtsLynxFloatView r0 = this.i;
        if (r0 == null) goto L8;
        tt5.a.k("TtsSession", "showFloatView, already showing: " + r0);
        return;
    L8:
        boolean r1 = s();
        boolean r2 = com.ss.android.lark.floating.b.a(LarkContext.getApplication());
        boolean r4 = false;
        if (this.p == false) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L37;
        if (r2 == true) goto L37;
        tt5.a.h("TtsSession", "showFloatView, wait permission dialog");
        this.o = true;
        this.p = false;
        no5.a.a.getClass();
        FragmentActivity r5 = no5.a.a();
        if (r5 != null) goto L20;
        tt5.a.d("TtsSession", "showPermissionDialog, topActivity not found");
        n("showPermissionDialog");
        return;
    L20:
        String r6 = r5.getString(2131889235);
        String r7 = UIHelper.mustacheFormat(2131889235, "APP_DISPLAY_NAME", UIHelper.getAppName());
        if (r7 != null) goto L23;
    L35:
        Intrinsics.checkNotNull(r6);
        r7 = StringsKt.replace$default(r6, "{{APP_DISPLAY_NAME}}", UIHelper.getAppName(), false, 4, null);
        tt5.a.h("TtsSession", "showPermissionDialog, format failed, replace manually: " + r7);
    L36:
        new UDDialogBuilder(r5).title(2131889236).titleBold(true).message(r7).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391778, 2131891541, new com.bytedance.ee.bear.tts.impl.e(this)).addActionButton(2131391777, 2131891623, new com.bytedance.ee.bear.tts.impl.f(r5, this)).onDismissListener(new g(this)).onCancelListener(new h(this)).show();
        return;
    L23:
        if (r7.length() <= 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L28;
    L30:
        if (r4 == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L35;
    L28:
        if (Intrinsics.areEqual(r7, r6) == true) goto L30;
        r4 = true;
        goto L30
    L25:
        r8 = false;
    L37:
        no5.a.a.getClass();
        FragmentActivity r9 = no5.a.a();
        if (r9 != null) goto L40;
        tt5.a.k("TtsSession", "showFloatView, topActivity not found");
        n("showFloatView");
        return;
    L40:
        TtsLynxFloatView r10 = new TtsLynxFloatView(r9);
        if (r1 == true) goto L43;
        r10.addOnAttachStateChangeListener((f) this.f.getValue());
    L43:
        mo5.a r11 = this.a;
        if (r2 == true) goto L46;
        if (r1 == false) goto L46;
    L48:
        if (r10.b(r11, r4) == true) goto L50;
        n("showFloatViewFailed");
    L50:
        this.i = r10;
        tt5.a.h("TtsSession", "showFloatView, floatView: " + this.j);
        mo5.g r12 = mo5.h.e(this.a);
        if (r12 == null) goto L55;
        to5.a r13 = r12.m();
        if (r13 == null) goto L55;
        r13.d(ITtsRecorder$ETtsViewType.FLOAT);
    L55:
        ((u) LarkContext.spiByDwarf(u.class)).b();
        return;
    L46:
        r4 = true;
        goto L48
    L11:
        if (s() == false) goto L14;
        r3 = false;
        goto L15
    }

    @Override // mo5.f
    public final void i() {
        if (this.b == false) goto L6;
        tt5.a.k("TtsSession", "showModalController, session already destroyed.");
        return;
    L6:
        BaseLynxDialogFragment r0 = this.j;
        if (r0 == null) goto L10;
        tt5.a.k("TtsSession", "showModalController, already showing: " + r0);
        return;
    L10:
        no5.a.a.getClass();
        FragmentActivity r1 = no5.a.a();
        if (r1 != null) goto L15;
        tt5.a.k("TtsSession", "showModalController, topActivity not found");
        n("showModalController");
        return;
    L15:
        if (r(r1) == false) goto L17;
        TtsLynxModalControllerView r2 = new TtsLynxModalControllerView(this.a);
        this.j = r2;
        u(r1, r2, ForsetiNavOptions.DestinationStyle.HALF_FLOAT);
    L26:
        tt5.a.h("TtsSession", "showModalController, modalControllerView: " + this.j);
        mo5.g r3 = mo5.h.e(this.a);
        if (r3 == null) goto L35;
        to5.a r4 = r3.m();
        if (r4 == null) goto L36;
        r4.d(ITtsRecorder$ETtsViewType.MODAL_PLAYER);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        p(r1);
        String r5 = TtsLynxModalControllerView.class.getName();
        TtsLynxModalControllerView r6 = o("showModalController", r1, r5);
        if (r6 != null) goto L20;
        r6 = new TtsLynxModalControllerView(this.a);
    L20:
        C0190d r7 = q();
        Intrinsics.checkNotNullParameter(r7, "listener");
        ((Set) ((BaseUDBottomSheetDialogFragment) r6).l.getValue()).add(r7);
        FragmentManager r8 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r5, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r6, r9) == false) goto L33;
    L25:
        this.j = r6;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r6.show(r8, r5);
        goto L25
    }

    @Override // mo5.f
    public final void j() {
        tt5.a.h("TtsSession", "destroySession");
        this.b = true;
        b r2 = this.c;     // Catch: Exception -> L5
        r2.getClass();     // Catch: Exception -> L5
        AppLifecycle.a.a.h.remove(r2);     // Catch: Exception -> L5
    L52:
        this.a.j();     // Catch: Exception -> L9
    L40:
        this.e.b();     // Catch: Exception -> L13
    L44:
        c();     // Catch: Exception -> L17
    L50:
        e();     // Catch: Exception -> L21
    L42:
        b();     // Catch: Exception -> L25
    L46:
        f();     // Catch: Exception -> L29
    L54:
        w();     // Catch: Exception -> L33
    L35:
        Iterator r0 = ((Set) this.h.getValue()).iterator();
    L37:
        if (r0.hasNext() == false) goto L39;
        ((e) r0.next()).a(this);
        goto L37
    L39:
        return;
    L33:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, resetOrientation error:", e, false);
    L29:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, dismissPlaylist error:", e, false);
    L25:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, dismissFullscreenPlayer error:", e, false);
    L21:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, dismissModalController error:", e, false);
    L17:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, dismissFloatView error:", e, false);
    L13:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, onMediaDestroy error:", e, false);
    L9:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, onAlbumDestroy error:", e, false);
    L5:
        e = move-exception;
        tt5.a.e("TtsSession", "destroySession, destroy appLifecycleListener error:", e, false);
        goto L52
    }

    @Override // mo5.f
    public final boolean l() {
        if (this.i == null) goto L5;
    L12:
        return true;
    L5:
        if (this.j != null) goto L12;
        if (this.k != null) goto L12;
        if (this.l != null) goto L12;
        return false;
    }

    public final C0190d q() {
        return (C0190d) this.g.getValue();
    }

    public final void w() {
        if (r(this.n) == false) goto L7;
        tt5.a.h("TtsSession", "resetOrientation, forseti enabled, skipped.");
        return;
    L7:
        if (this.j == null) goto L9;
    L27:
        tt5.a.h("TtsSession", "resetOrientation, some DialogFragments are still showing, skipped.");
        return;
    L9:
        if (this.k != null) goto L27;
        if (this.l != null) goto L27;
        FragmentActivity r0 = this.n;
        if (r0 != null) goto L18;
        tt5.a.h("TtsSession", "resetOrientation, orientationRequestedActivity is null, skipped.");
        return;
    L18:
        if (r0.isDestroyed() == false) goto L21;
        tt5.a.h("TtsSession", "resetOrientation, activity is destroyed.");
        return;
    L21:
        this.n = null;
        r0.getLifecycle().removeObserver(this.d);
        int r2 = r0.getRequestedOrientation();
        if (r2 != 1) goto L24;
        tt5.a.h("TtsSession", "resetOrientation, reset to lastRequestedOrientation: " + this.m + ", ");
        r0.setRequestedOrientation(this.m);
    L25:
        this.m = -1;
        return;
    L24:
        tt5.a.h("TtsSession", "resetOrientation, requestedOrientation changed: " + r2 + ", skipped");
        goto L25
    }

    @Override // mo5.f
    public final boolean a() {
        return this.b;
    }

    @Override // mo5.f
    public final mo5.a k() {
        return this.a;
    }

    public d(TtsAlbumViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "albumVM");
        this.a = r3;
        b r0 = new b(this);
        this.c = r0;
        this.d = new a(this);
        com.bytedance.ee.bear.tts.media.b r1 = new com.bytedance.ee.bear.tts.media.b(r3);
        this.e = r1;
        this.f = LazyKt.lazy(new TtsSession$viewStateListener$2(this));
        this.g = LazyKt.lazy(new TtsSession$dialogStateListener$2(this));
        this.h = LazyKt.lazy(TtsSession$stateCallbackSet$2.INSTANCE);
        this.m = -1;
        AppLifecycle.a.a.c(r0);
        tt5.a.h("TtsMediaViewModel", "onStart.");
        tt5.a.h("TtsMediaViewModel", "initRemoteService.");
        com.bytedance.ee.util.ui.j.f(new com.bytedance.ee.bear.tts.media.e(r1));
        tt5.a.h("TtsMediaViewModel", "startAlbumObservers.");
        r1.a.e().observeForever(r1.b);
        r1.a.b().observeForever(r1.c);
        ((u) LarkContext.spiByDwarf(u.class)).a();
    }

    public static final void m(d r3) {
        List<mo5.g> r0 = mo5.h.d(r3.a);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r3 + ", album list is empty, destroy session.");
        r3.j();
        return;
    L12:
        t();
        tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r3 + ", show float view.");
        r3.h();
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public static boolean r(FragmentActivity r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (ForsetiHelper.t(r1) == true) goto L8;
        return false;
    L8:
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void n(String r3) {
        if (l() == true) goto L6;
        tt5.a.h("TtsSession", "checkDestroy, reason: " + r3 + ", no view showing, destroy session.");
        j();
        return;
    }

    public final void p(FragmentActivity r6) {
        if (r(r6) == false) goto L6;
        tt5.a.h("TtsSession", "forcePortrait, forseti enabled, skipped.");
        return;
    L6:
        int r0 = r6.getRequestedOrientation();
        int r2 = r6.getResources().getConfiguration().orientation;
        tt5.a.h("TtsSession", "forcePortrait, requestedOrientation: " + r0 + ", configurationOrientation: " + r2);
        if (r0 != 1) goto L10;
        if (r2 != 1) goto L10;
        return;
    L10:
        this.m = r0;
        r6.setRequestedOrientation(1);
        r6.getLifecycle().addObserver(this.d);
        this.n = r6;
    }

    public final void v(e r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.h("TtsSession", "removeStateCallback, callback: " + r4 + ", result: " + ((Set) this.h.getValue()).remove(r4));
    }

    public static Fragment o(String r5, FragmentActivity r6, String r7) {
        Fragment r8 = r6.getSupportFragmentManager().findFragmentByTag(r7);
        if (r8 != null) goto L14;
        return null;
    L14:
        tt5.a.h("TtsSession", "findFragment(" + r5 + "), found instance: " + r8);     // Catch: Exception -> L6
    L16:
        return r8;
    L6:
        e = move-exception;
        if (DevEnvUtil.isDebugMode(r6) == true) goto L12;
        tt5.a.e("TtsSession", "findFragment(" + r5 + "), found instance type error: " + r8, e, false);
        r8 = null;
        goto L16
    L12:
        throw new IllegalStateException("Found instance: " + r8 + ", type error: " + e);
    }

    public final void u(FragmentActivity r3, BaseLynxDialogFragment r4, final ForsetiNavOptions.DestinationStyle r5) {
        com.suite.lark.component.navroute.forseti.g r6 = com.suite.lark.component.navroute.forseti.f.c(r3, true);
        if (r6 == null) goto L5;
        r6.h(new com.suite.lark.component.navroute.fragment.c(r4), new TtsSession$openPlayerWithForseti$1$1(r5));
    L5:
        r4.getLifecycle().addObserver(q());
    }
}
