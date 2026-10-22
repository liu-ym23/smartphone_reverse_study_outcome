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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public final class d implements mo5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mo5.a f239538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f239539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f239540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f239541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.tts.media.b f239542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f239543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f239544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f239545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TtsLynxFloatView f239546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseLynxDialogFragment f239547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TtsLynxFullscreenPlayerView f239548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TtsLynxPlaylistView f239549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f239550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FragmentActivity f239551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f239552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f239553p;

    public final class a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239554a;

        public a(d r100) {
            this.f239554a = r100;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 == Lifecycle.Event.ON_DESTROY) goto L5;
            return;
        L5:
            r100.getLifecycle().removeObserver(this);
            FragmentActivity r102 = this.f239554a.f239551n;
            if (r102 == null) goto L10;
            Lifecycle r103 = r102.getLifecycle();
            if (r103 == null) goto L10;
            r103.removeObserver(this);
        L10:
            this.f239554a.f239551n = null;
        }
    }

    public final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f239555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f239556b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f239557a;

            public a(d r100) {
                this.f239557a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d r100 = this.f239557a;     // Catch: Throwable -> L8
                if (r100.f239539b == false) goto L5;
                return;
            L5:
                if (r100.l() == true) goto L15;
                tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, ");     // Catch: Throwable -> L8
                this.f239557a.h();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public b(d r100) {
            this.f239556b = r100;
            this.f239555a = new a(r100);
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(y.a r100, y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            if (r101.f408860c == false) goto L5;
            tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, enter foreground, check float view later.");
            com.bytedance.ee.util.ui.j.e(this.f239555a);
            com.bytedance.ee.util.ui.j.d(this.f239555a, 500);
            return;
        L5:
            tt5.a.h("TtsSession", "AppLifecycleListener-onAppLifecycleChanged, enter background, dismissFloatView");
            com.bytedance.ee.util.ui.j.e(this.f239555a);
            this.f239556b.c();
        }
    }

    public static final class c {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.impl.d$d, reason: collision with other inner class name */
    public final class C3437d implements BaseUDBottomSheetDialogFragment.b, LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239558a;

        public C3437d(d r100) {
            this.f239558a = r100;
        }

        @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment.b
        public final void a(BaseUDBottomSheetDialogFragment r110) {
            Intrinsics.checkNotNullParameter(r110, "dialogFragment");
            r110.ka0(this);
            boolean r100 = false;
            if ((r110 instanceof TtsLynxModalControllerView) == false) goto L25;
            d r101 = this.f239558a;
            BaseLynxDialogFragment r102 = r101.f239547j;
            if (r102 == null) goto L7;
            r102.ka0(r101.q());
        L7:
            d r103 = this.f239558a;
            r103.f239547j = null;
            List<mo5.g> r104 = mo5.h.d(r103.f239538a);
            if (r104 != null) goto L10;
        L13:
            boolean r105 = true;
        L14:
            if (r105 == false) goto L16;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", album list is empty, destroy session.");
            this.f239558a.j();
            return;
        L16:
            this.f239558a.getClass();
            d.t();
            FragmentActivity r106 = ((TtsLynxModalControllerView) r110).getActivity();
            if (r106 != null) goto L19;
        L21:
            if (r100 == false) goto L23;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", changing configuration.");
            this.f239558a.w();
            return;
        L23:
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", show float view.");
            this.f239558a.w();
            this.f239558a.h();
            return;
        L19:
            if (r106.isChangingConfigurations() != true) goto L21;
            r100 = true;
            goto L21
        L10:
            if (r104.isEmpty() == true) goto L13;
            r105 = false;
            goto L14
        L25:
            if ((r110 instanceof TtsLynxFullscreenPlayerView) == false) goto L47;
            d r107 = this.f239558a;
            TtsLynxFullscreenPlayerView r108 = r107.f239548k;
            if (r108 == null) goto L29;
            r108.ka0(r107.q());
        L29:
            d r109 = this.f239558a;
            r109.f239548k = null;
            List<mo5.g> r111 = mo5.h.d(r109.f239538a);
            if (r111 != null) goto L32;
        L35:
            boolean r112 = true;
        L36:
            if (r112 == false) goto L38;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", album list is empty, destroy session.");
            this.f239558a.j();
            return;
        L38:
            this.f239558a.getClass();
            d.t();
            FragmentActivity r113 = ((TtsLynxFullscreenPlayerView) r110).getActivity();
            if (r113 != null) goto L41;
        L43:
            if (r100 == false) goto L45;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", changing configuration.");
            this.f239558a.w();
            return;
        L45:
            tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r110 + ", show float view.");
            this.f239558a.w();
            this.f239558a.h();
            return;
        L41:
            if (r113.isChangingConfigurations() != true) goto L43;
            r100 = true;
            goto L43
        L32:
            if (r111.isEmpty() == true) goto L35;
            r112 = false;
            goto L36
        L47:
            if ((r110 instanceof TtsLynxPlaylistView) == false) goto L59;
            tt5.a.h("TtsSession", "DialogStateListener-onClosed, playlistView: " + r110);
            d r114 = this.f239558a;
            TtsLynxPlaylistView r115 = r114.f239549l;
            if (r115 == null) goto L51;
            r115.ka0(r114.q());
        L51:
            d r116 = this.f239558a;
            r116.f239549l = null;
            r116.w();
            return;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L14;
            r100.getLifecycle().removeObserver(this);
            if ((r100 instanceof TtsLynxModalControllerView) == false) goto L8;
            d r102 = this.f239558a;
            r102.f239547j = null;
            d.m(r102);
            return;
        L8:
            if ((r100 instanceof TtsLynxFullscreenPlayerView) == false) goto L11;
            d r103 = this.f239558a;
            r103.f239548k = null;
            d.m(r103);
            return;
        L11:
            if ((r100 instanceof TtsLynxPlaylistView) == false) goto L17;
            this.f239558a.f239549l = null;
            return;
        L17:
            return;
        }
    }

    public interface e {
        void a(d r100);
    }

    public final class f implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239559a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        public f(d r100) {
            this.f239559a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            r100.removeOnAttachStateChangeListener(this);
            if ((r100 instanceof TtsLynxFloatView) == false) goto L9;
            d r101 = this.f239559a;
            r101.f239552o = false;
            TtsLynxFloatView r102 = r101.f239546i;
            if (r102 == null) goto L7;
            r102.removeOnAttachStateChangeListener((f) r101.f239543f.getValue());
        L7:
            this.f239559a.f239546i = null;
            return;
        }
    }

    @Override // mo5.f
    public final void c() {
        this.f239552o = false;
        TtsLynxFloatView r100 = this.f239546i;
        if (r100 == null) goto L5;
        tt5.a.h("TtsSession", "dismissFloatView, dismiss: " + r100);
        r100.a();
        r100.removeOnAttachStateChangeListener((f) this.f239543f.getValue());
        this.f239546i = null;
        return;
    L5:
        tt5.a.k("TtsSession", "dismissFloatView, not showing");
    }

    static {
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(LarkContext.getApplication());
        Boolean r100 = Boolean.valueOf(((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).isInit());
        if ((!r100.booleanValue()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.booleanValue();
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
        TtsLynxFullscreenPlayerView r100 = this.f239548k;
        if (r100 == null) goto L12;
        tt5.a.h("TtsSession", "dismissFullscreenPlayer, dismiss: " + r100);
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r100.ka0(q());
        this.f239548k = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissFullscreenPlayer, not showing");
    }

    @Override // mo5.f
    public final void d() {
        if (this.f239539b == false) goto L6;
        tt5.a.k("TtsSession", "showFullscreenPlayer, session already destroyed.");
        return;
    L6:
        TtsLynxFullscreenPlayerView r100 = this.f239548k;
        if (r100 == null) goto L10;
        tt5.a.k("TtsSession", "showFullscreenPlayer, already showing: " + r100);
        return;
    L10:
        no5.a.f519907a.getClass();
        FragmentActivity r101 = no5.a.a();
        if (r101 != null) goto L14;
        tt5.a.k("TtsSession", "showFullscreenPlayer, topActivity not found");
        n("showFullscreenPlayer");
        return;
    L14:
        p(r101);
        if (r(r101) == false) goto L17;
        TtsLynxFullscreenPlayerView r102 = new TtsLynxFullscreenPlayerView(this.f239538a);
        this.f239548k = r102;
        u(r101, r102, ForsetiNavOptions.DestinationStyle.FULL_SCREEN);
    L26:
        tt5.a.h("TtsSession", "showFullscreenPlayer, fullscreenPlayerView: " + this.f239548k);
        mo5.g r103 = mo5.h.e(this.f239538a);
        if (r103 == null) goto L35;
        to5.a r104 = r103.m();
        if (r104 == null) goto L36;
        r104.d(ITtsRecorder$ETtsViewType.FULLSCREEN_PLAYER);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        String r105 = TtsLynxFullscreenPlayerView.class.getName();
        TtsLynxFullscreenPlayerView r106 = (TtsLynxFullscreenPlayerView) o("showFullscreenPlayer", r101, r105);
        if (r106 != null) goto L20;
        r106 = new TtsLynxFullscreenPlayerView(this.f239538a);
    L20:
        C3437d r107 = q();
        Intrinsics.checkNotNullParameter(r107, "listener");
        ((Set) r106.f216380l.getValue()).add(r107);
        FragmentManager r108 = r101.getSupportFragmentManager();
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, r105, r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r106, r109) == false) goto L33;
    L25:
        this.f239548k = r106;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r106.show(r108, r105);
        goto L25
    }

    @Override // mo5.f
    public final void e() {
        BaseLynxDialogFragment r100 = this.f239547j;
        if (r100 == null) goto L12;
        tt5.a.h("TtsSession", "dismissModalController, dismiss: " + r100);
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r100.ka0(q());
        this.f239547j = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissModalController, not showing");
    }

    @Override // mo5.f
    public final void f() {
        TtsLynxPlaylistView r100 = this.f239549l;
        if (r100 == null) goto L12;
        tt5.a.h("TtsSession", "dismissPlaylist, dismiss: " + r100);
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        r100.ka0(q());
        this.f239549l = null;
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L12:
        tt5.a.k("TtsSession", "dismissPlaylist, not showing");
    }

    @Override // mo5.f
    public final void g() {
        if (this.f239539b == false) goto L6;
        tt5.a.k("TtsSession", "showPlaylist, session already destroyed.");
        return;
    L6:
        TtsLynxPlaylistView r100 = this.f239549l;
        if (r100 == null) goto L10;
        tt5.a.k("TtsSession", "showPlaylist, already showing: " + r100);
        return;
    L10:
        no5.a.f519907a.getClass();
        FragmentActivity r101 = no5.a.a();
        if (r101 != null) goto L14;
        tt5.a.k("TtsSession", "showPlaylist, topActivity not found");
        n("showPlaylist");
        return;
    L14:
        p(r101);
        if (r(r101) == false) goto L17;
        TtsLynxPlaylistView r102 = new TtsLynxPlaylistView(this.f239538a);
        this.f239549l = r102;
        u(r101, r102, ForsetiNavOptions.DestinationStyle.HALF_FLOAT);
    L26:
        tt5.a.h("TtsSession", "showPlaylist, playlistView: " + this.f239549l);
        mo5.g r103 = mo5.h.e(this.f239538a);
        if (r103 == null) goto L35;
        to5.a r104 = r103.m();
        if (r104 == null) goto L36;
        r104.d(ITtsRecorder$ETtsViewType.PLAYLIST);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        String r105 = TtsLynxPlaylistView.class.getName();
        TtsLynxPlaylistView r106 = (TtsLynxPlaylistView) o("showPlaylist", r101, r105);
        if (r106 != null) goto L20;
        r106 = new TtsLynxPlaylistView(this.f239538a);
    L20:
        C3437d r107 = q();
        Intrinsics.checkNotNullParameter(r107, "listener");
        ((Set) r106.f216380l.getValue()).add(r107);
        FragmentManager r108 = r101.getSupportFragmentManager();
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, r105, r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r106, r109) == false) goto L33;
    L25:
        this.f239549l = r106;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r106.show(r108, r105);
        goto L25
    }

    @Override // mo5.f
    public final void h() {
        if (this.f239539b == false) goto L5;
        tt5.a.k("TtsSession", "showFloatView, session already destroyed.");
        return;
    L5:
        TtsLynxFloatView r100 = this.f239546i;
        if (r100 == null) goto L8;
        tt5.a.k("TtsSession", "showFloatView, already showing: " + r100);
        return;
    L8:
        boolean r101 = s();
        boolean r102 = com.ss.android.lark.floating.b.a(LarkContext.getApplication());
        boolean r103 = false;
        if (this.f239553p == false) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L37;
        if (r102 == true) goto L37;
        tt5.a.h("TtsSession", "showFloatView, wait permission dialog");
        this.f239552o = true;
        this.f239553p = false;
        no5.a.f519907a.getClass();
        FragmentActivity r105 = no5.a.a();
        if (r105 != null) goto L20;
        tt5.a.d("TtsSession", "showPermissionDialog, topActivity not found");
        n("showPermissionDialog");
        return;
    L20:
        String r106 = r105.getString(R.string.LarkCCM_Docs_ReadAloud_FloatWinPerm_Desc);
        String r107 = UIHelper.mustacheFormat(R.string.LarkCCM_Docs_ReadAloud_FloatWinPerm_Desc, "APP_DISPLAY_NAME", UIHelper.getAppName());
        if (r107 != null) goto L23;
    L35:
        Intrinsics.checkNotNull(r106);
        r107 = StringsKt.replace$default(r106, "{{APP_DISPLAY_NAME}}", UIHelper.getAppName(), false, 4, null);
        tt5.a.h("TtsSession", "showPermissionDialog, format failed, replace manually: " + r107);
    L36:
        new UDDialogBuilder(r105).title(R.string.LarkCCM_Docs_ReadAloud_FloatWinPerm_Title).titleBold(true).message(r107).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_Legacy_Cancel, new com.bytedance.ee.bear.tts.impl.e(this)).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_Confirm, new com.bytedance.ee.bear.tts.impl.f(r105, this)).onDismissListener(new g(this)).onCancelListener(new h(this)).show();
        return;
    L23:
        if (r107.length() <= 0) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == true) goto L28;
    L30:
        if (r103 == true) goto L33;
        r107 = null;
    L33:
        if (r107 == null) goto L35;
    L28:
        if (Intrinsics.areEqual(r107, r106) == true) goto L30;
        r103 = true;
        goto L30
    L25:
        r108 = false;
    L37:
        no5.a.f519907a.getClass();
        FragmentActivity r109 = no5.a.a();
        if (r109 != null) goto L40;
        tt5.a.k("TtsSession", "showFloatView, topActivity not found");
        n("showFloatView");
        return;
    L40:
        TtsLynxFloatView r110 = new TtsLynxFloatView(r109);
        if (r101 == true) goto L43;
        r110.addOnAttachStateChangeListener((f) this.f239543f.getValue());
    L43:
        mo5.a r111 = this.f239538a;
        if (r102 == true) goto L46;
        if (r101 == false) goto L46;
    L48:
        if (r110.b(r111, r103) == true) goto L50;
        n("showFloatViewFailed");
    L50:
        this.f239546i = r110;
        tt5.a.h("TtsSession", "showFloatView, floatView: " + this.f239547j);
        mo5.g r112 = mo5.h.e(this.f239538a);
        if (r112 == null) goto L55;
        to5.a r113 = r112.m();
        if (r113 == null) goto L55;
        r113.d(ITtsRecorder$ETtsViewType.FLOAT);
    L55:
        ((u) LarkContext.spiByDwarf(u.class)).b();
        return;
    L46:
        r103 = true;
        goto L48
    L11:
        if (s() == false) goto L14;
        r104 = false;
        goto L15
    }

    @Override // mo5.f
    public final void i() {
        if (this.f239539b == false) goto L6;
        tt5.a.k("TtsSession", "showModalController, session already destroyed.");
        return;
    L6:
        BaseLynxDialogFragment r100 = this.f239547j;
        if (r100 == null) goto L10;
        tt5.a.k("TtsSession", "showModalController, already showing: " + r100);
        return;
    L10:
        no5.a.f519907a.getClass();
        FragmentActivity r101 = no5.a.a();
        if (r101 != null) goto L15;
        tt5.a.k("TtsSession", "showModalController, topActivity not found");
        n("showModalController");
        return;
    L15:
        if (r(r101) == false) goto L17;
        TtsLynxModalControllerView r102 = new TtsLynxModalControllerView(this.f239538a);
        this.f239547j = r102;
        u(r101, r102, ForsetiNavOptions.DestinationStyle.HALF_FLOAT);
    L26:
        tt5.a.h("TtsSession", "showModalController, modalControllerView: " + this.f239547j);
        mo5.g r103 = mo5.h.e(this.f239538a);
        if (r103 == null) goto L35;
        to5.a r104 = r103.m();
        if (r104 == null) goto L36;
        r104.d(ITtsRecorder$ETtsViewType.MODAL_PLAYER);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        p(r101);
        String r105 = TtsLynxModalControllerView.class.getName();
        TtsLynxModalControllerView r106 = (TtsLynxModalControllerView) o("showModalController", r101, r105);
        if (r106 != null) goto L20;
        r106 = new TtsLynxModalControllerView(this.f239538a);
    L20:
        C3437d r107 = q();
        Intrinsics.checkNotNullParameter(r107, "listener");
        ((Set) r106.f216380l.getValue()).add(r107);
        FragmentManager r108 = r101.getSupportFragmentManager();
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, r105, r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r106, r109) == false) goto L33;
    L25:
        this.f239547j = r106;
        goto L26
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L24:
        r106.show(r108, r105);
        goto L25
    }

    @Override // mo5.f
    public final void j() {
        tt5.a.h("TtsSession", "destroySession");
        this.f239539b = true;
        b r100 = this.f239540c;     // Catch: Exception -> L5
        r100.getClass();     // Catch: Exception -> L5
        AppLifecycle.a.f408803a.f408785h.remove(r100);     // Catch: Exception -> L5
    L52:
        this.f239538a.j();     // Catch: Exception -> L9
    L40:
        this.f239542e.b();     // Catch: Exception -> L13
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
        Iterator r101 = ((Set) this.f239545h.getValue()).iterator();
    L37:
        if (r101.hasNext() == false) goto L39;
        ((e) r101.next()).a(this);
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
        if (this.f239546i == null) goto L5;
    L12:
        return true;
    L5:
        if (this.f239547j != null) goto L12;
        if (this.f239548k != null) goto L12;
        if (this.f239549l != null) goto L12;
        return false;
    }

    public final C3437d q() {
        return (C3437d) this.f239544g.getValue();
    }

    public final void w() {
        if (r(this.f239551n) == false) goto L7;
        tt5.a.h("TtsSession", "resetOrientation, forseti enabled, skipped.");
        return;
    L7:
        if (this.f239547j == null) goto L9;
    L27:
        tt5.a.h("TtsSession", "resetOrientation, some DialogFragments are still showing, skipped.");
        return;
    L9:
        if (this.f239548k != null) goto L27;
        if (this.f239549l != null) goto L27;
        FragmentActivity r100 = this.f239551n;
        if (r100 != null) goto L18;
        tt5.a.h("TtsSession", "resetOrientation, orientationRequestedActivity is null, skipped.");
        return;
    L18:
        if (r100.isDestroyed() == false) goto L21;
        tt5.a.h("TtsSession", "resetOrientation, activity is destroyed.");
        return;
    L21:
        this.f239551n = null;
        r100.getLifecycle().removeObserver(this.f239541d);
        int r101 = r100.getRequestedOrientation();
        if (r101 != 1) goto L24;
        tt5.a.h("TtsSession", "resetOrientation, reset to lastRequestedOrientation: " + this.f239550m + ", ");
        r100.setRequestedOrientation(this.f239550m);
    L25:
        this.f239550m = -1;
        return;
    L24:
        tt5.a.h("TtsSession", "resetOrientation, requestedOrientation changed: " + r101 + ", skipped");
        goto L25
    }

    @Override // mo5.f
    public final boolean a() {
        return this.f239539b;
    }

    @Override // mo5.f
    public final mo5.a k() {
        return this.f239538a;
    }

    public d(TtsAlbumViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "albumVM");
        this.f239538a = r100;
        b r101 = new b(this);
        this.f239540c = r101;
        this.f239541d = new a(this);
        com.bytedance.ee.bear.tts.media.b r102 = new com.bytedance.ee.bear.tts.media.b(r100);
        this.f239542e = r102;
        this.f239543f = LazyKt.lazy(new TtsSession$viewStateListener$2(this));
        this.f239544g = LazyKt.lazy(new TtsSession$dialogStateListener$2(this));
        this.f239545h = LazyKt.lazy(TtsSession$stateCallbackSet$2.INSTANCE);
        this.f239550m = -1;
        AppLifecycle.a.f408803a.c(r101);
        tt5.a.h("TtsMediaViewModel", "onStart.");
        tt5.a.h("TtsMediaViewModel", "initRemoteService.");
        com.bytedance.ee.util.ui.j.f(new com.bytedance.ee.bear.tts.media.e(r102));
        tt5.a.h("TtsMediaViewModel", "startAlbumObservers.");
        r102.f239698a.e().observeForever(r102.f239699b);
        r102.f239698a.b().observeForever(r102.f239700c);
        ((u) LarkContext.spiByDwarf(u.class)).a();
    }

    public static final void m(d r100) {
        List<mo5.g> r101 = mo5.h.d(r100.f239538a);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r100 + ", album list is empty, destroy session.");
        r100.j();
        return;
    L12:
        t();
        tt5.a.h("TtsSession", "DialogStateListener-onClosed: " + r100 + ", show float view.");
        r100.h();
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public static boolean r(FragmentActivity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (ForsetiHelper.t(r100) == true) goto L8;
        return false;
    L8:
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void n(String r100) {
        if (l() == true) goto L6;
        tt5.a.h("TtsSession", "checkDestroy, reason: " + r100 + ", no view showing, destroy session.");
        j();
        return;
    }

    public final void p(FragmentActivity r100) {
        if (r(r100) == false) goto L6;
        tt5.a.h("TtsSession", "forcePortrait, forseti enabled, skipped.");
        return;
    L6:
        int r101 = r100.getRequestedOrientation();
        int r102 = r100.getResources().getConfiguration().orientation;
        tt5.a.h("TtsSession", "forcePortrait, requestedOrientation: " + r101 + ", configurationOrientation: " + r102);
        if (r101 != 1) goto L10;
        if (r102 != 1) goto L10;
        return;
    L10:
        this.f239550m = r101;
        r100.setRequestedOrientation(1);
        r100.getLifecycle().addObserver(this.f239541d);
        this.f239551n = r100;
    }

    public final void v(e r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        tt5.a.h("TtsSession", "removeStateCallback, callback: " + r100 + ", result: " + ((Set) this.f239545h.getValue()).remove(r100));
    }

    public static Fragment o(String r100, FragmentActivity r101, String r102) {
        Fragment r103 = r101.getSupportFragmentManager().findFragmentByTag(r102);
        if (r103 != null) goto L14;
        return null;
    L14:
        tt5.a.h("TtsSession", "findFragment(" + r100 + "), found instance: " + r103);     // Catch: Exception -> L6
    L16:
        return r103;
    L6:
        e = move-exception;
        if (DevEnvUtil.isDebugMode(r101) == true) goto L12;
        tt5.a.e("TtsSession", "findFragment(" + r100 + "), found instance type error: " + r103, e, false);
        r103 = null;
        goto L16
    L12:
        throw new IllegalStateException("Found instance: " + r103 + ", type error: " + e);
    }

    public final void u(FragmentActivity r100, BaseLynxDialogFragment r101, final ForsetiNavOptions.DestinationStyle r102) {
        com.suite.lark.component.navroute.forseti.g r103 = com.suite.lark.component.navroute.forseti.f.c(r100, true);
        if (r103 == null) goto L5;
        r103.h(new com.suite.lark.component.navroute.fragment.c(r101), new TtsSession$openPlayerWithForseti$1$1(r102));
    L5:
        r101.getLifecycle().addObserver(q());
    }
}
