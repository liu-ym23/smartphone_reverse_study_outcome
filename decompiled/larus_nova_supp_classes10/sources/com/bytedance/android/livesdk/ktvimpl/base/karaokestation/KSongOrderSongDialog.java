package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.karaokestation.view.CommonOrderSongDialog;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.viewmodel.KtvComponentOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.q;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.x8;
import com.bytedance.live.datacontext.j;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/KSongOrderSongDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongOrderSongDialog extends BaseKtvDialogFragment {
    public static final /* synthetic */ int p = 0;
    public boolean g;
    public boolean h;
    public int i;
    public final CompositeDisposable j;
    public CommonOrderSongDialog k;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d l;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e m;
    public final Function0<Unit> n;
    public final Function0<Unit> o;

    public static final class a {
        public a() {
        }

        public static KSongOrderSongDialog a(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1, BaseFirstLevelTabManager r2, Function0 r3, int r4) {
            int r0 = KSongOrderSongDialog.p;
            if ((r4 & 8) == 0) goto L5;
            r3 = null;
        L5:
            Intrinsics.checkNotNullParameter(r2, "kSongBaseFirstLevelTabManager");
            return new KSongOrderSongDialog(r1, r2, null, r3);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ KSongOrderSongDialog a;

        public b(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            KSongOrderSongUtilKt.i(this.a.getContext(), CloseOrderSongDialogSource.MANUAL);
            Function0<Unit> r3 = this.a.o;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KSongOrderSongDialog a;

        public c(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            KSongOrderSongDialog r3 = this.a;
            int r0 = KSongOrderSongDialog.p;
            r3.dismissDialog();
            return;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ KSongOrderSongDialog a;

        public d(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        public final void run() {
            KSongOrderSongDialog r0 = this.a;
            int r1 = KSongOrderSongDialog.p;
            r0.dismissDialog();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KSongOrderSongDialog a;

        public e(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            i r5 = (i) r4;
            KSongOrderSongDialog r0 = this.a;
            int r1 = r0.i;
            if (r1 != 0) goto L5;
        L7:
            KSongOrderSongDialog r2 = this.a;
            r2.i = r5.a;
            return;
        L5:
            if (r1 == r5.a) goto L7;
            r0.dismissDialog();
            goto L7
        }
    }

    public static final class f implements DialogInterface.OnShowListener {
        public final /* synthetic */ KSongOrderSongDialog a;

        public f(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r3) {
            KSongOrderSongDialog r4 = this.a;
            int r0 = KSongOrderSongDialog.p;
            int[] r1 = new int[2];
            View r2 = ((BaseKtvDialogFragment) r4).f;
            if (r2 == null) goto L5;
            r2.getLocationOnScreen(r1);
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = r4.l;
            if (r5 == null) goto L9;
            r5.onDialogShow(r1);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KSongOrderSongDialog a;

        public g(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            CommonOrderSongDialog r5 = this.a.k;
            if (r5 == null) goto L10;
            u r0 = r5.t.b;
            if (r0.j == false) goto L11;
            Function1 r1 = r0.k;
            if (r1 == null) goto L12;
            Unit r6 = (Unit) r1.invoke(r5.j);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ KSongOrderSongDialog a;

        public h(KSongOrderSongDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            CommonOrderSongDialog r5 = this.a.k;
            if (r5 == null) goto L10;
            u r0 = r5.t.b;
            if (r0.j == false) goto L11;
            Function1 r1 = r0.k;
            if (r1 == null) goto L12;
            Unit r6 = (Unit) r1.invoke(r5.j);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        new a();
    }

    public final String S90() {
        return "KSongOrderSongDialog";
    }

    public final int getLayoutId() {
        return 2131566522;
    }

    public KSongOrderSongDialog() {
        this(null, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.c(), AnonymousClass1.INSTANCE, null);
    }

    public final void Z90() {
        ALogger.i("KSongOrderSongDialog", "before hideDialog ;; isDialogShowing == " + this.h);
        if (this.h == false) goto L16;
        ALogger.i("KSongOrderSongDialog", "real hideDialog");
        this.h = false;
        xs2.b.a().post(new td2.a("hide_order_song_dialog"));
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        r0.hide();
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.l;
        if (r1 == null) goto L10;
        r1.onDialogDismiss();
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.l;
        if (r2 == null) goto L17;
        MutableLiveData<vb0.a> r3 = r2.getOrderSongUiState();
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r3, KSongOrderSongDialog$hideDialog$1.INSTANCE);
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void dismissDialog() {
        ALogger.i("KSongOrderSongDialog", "dismissDialog");
        xs2.b.a().post(new td2.a("dismiss_order_song_dialog"));
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.h = false;
        this.j.dispose();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.g == false) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.l;
        if (r0 == null) goto L13;
        MutableLiveData<vb0.a> r1 = r0.getOrderSongUiState();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r1, C02131.INSTANCE);
    L13:
        this.g = false;
        Map<String, cm2.a> r2 = q.a;
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r3 = q.b();
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.b == true) goto L20;
        r3.g = System.currentTimeMillis() - r3.c;
        return;
    L20:
        return;
    L5:
        if (this.h == false) goto L7;
        aa0(this, true, null, 2);
        goto L13
    L7:
        dismissDialog();
        goto L13
    }

    public static View X90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void Y90(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super.onDismiss(r4);
        View r5 = getView();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = null;
        if (r5 == null) goto L16;
        IBinder r6 = r5.getWindowToken();
        if (r6 == null) goto L16;
        Activity r1 = ContextUtil.contextToActivity(getContext());
        if (r1 == null) goto L9;
        Object r2 = r1.getSystemService("input_method");
    L11:
        if ((r2 instanceof InputMethodManager) == true) goto L13;
        r2 = null;
    L13:
        InputMethodManager r3 = (InputMethodManager) r2;
        if (r3 == null) goto L16;
        r3.hideSoftInputFromWindow(r6, 0);
        goto L16
    L9:
        r2 = null;
    L16:
        com.bytedance.android.livesdk.chatroom.u r7 = m.d();
        if (r7 == null) goto L19;
        r7.B();
    L19:
        this.m.clearData();
        Function0<Unit> r8 = this.n;
        if (r8 == null) goto L22;
        Unit r9 = (Unit) r8.invoke();
    L22:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r10 = this.l;
        if (r10 == null) goto L27;
        MutableLiveData<vb0.a> r11 = r10.getOrderSongUiState();
        if (r11 == null) goto L27;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r11, AnonymousClass2.INSTANCE);
    L27:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = KtvComponentOrderSongDataContext.Companion.a();
        if ((r12 instanceof KtvComponentOrderSongViewModel) == false) goto L31;
        r0 = r12;
    L31:
        KtvComponentOrderSongViewModel r13 = (KtvComponentOrderSongViewModel) r0;
        if (r13 == null) goto L34;
        r13.updateCurrentKSongElementMethod(true);
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = this.l;
        if (r14 == null) goto L38;
        r14.onDialogDismiss();
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        Dialog r11 = getDialog();
        boolean r0 = true;
        if (r11 == null) goto L18;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        int r4 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L16:
        r12.setLayout(r4, -1);
        goto L18
    L15:
        r4 = -1;
        goto L16
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r3 = false;
    L18:
        if (PadConfigUtils.c() == false) goto L85;
        Dialog r13 = getDialog();
        View r5 = null;
        if (r13 == null) goto L41;
        RadiusLayout r6 = r13.findViewById(2131389519);
        if (r6 == null) goto L41;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = -2;
        r7.width = -1;
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L26;
        ViewGroup.LayoutParams r2 = null;
    L27:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r2;
        if (r8 == null) goto L31;
        r8.setMargins(0, 0, 0, 0);
    L31:
        if ((r7 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        ViewGroup.LayoutParams r9 = null;
    L34:
        CoordinatorLayout.LayoutParams r14 = (CoordinatorLayout.LayoutParams) r9;
        if (r14 == null) goto L38;
        r14.gravity = 85;
    L38:
        if ((r6 instanceof RadiusLayout) == false) goto L40;
        r6.setMaxHeight(0);
    L40:
        r6.setLayoutParams(r7);
        goto L41
    L33:
        r9 = r7;
        goto L34
    L26:
        r2 = r7;
    L41:
        if (r13 == null) goto L46;
        Window r15 = r13.getWindow();
        if (r15 == null) goto L46;
        r15.setNavigationBarColor(s1.h(2131106784));
    L46:
        if (s1.getResources().getConfiguration().orientation == 2) goto L49;
        r0 = false;
    L49:
        if (r0 == false) goto L79;
        if (r13 == null) goto L54;
        View r1 = r13.findViewById(2131389483);
        if (r1 == null) goto L54;
        r1.setFitsSystemWindows(false);
        r1.setPadding(0, 0, 0, 0);
    L54:
        if (r13 == null) goto L58;
        View r16 = r13.findViewById(2131389519);
        if (r16 == null) goto L58;
        r16.setFitsSystemWindows(false);
        r16.setPadding(0, 0, 0, 0);
    L58:
        if (r13 == null) goto L64;
        Window r17 = r13.getWindow();
        if (r17 == null) goto L64;
        View r18 = X90(r17);
        if (r18 == null) goto L64;
        r18.setFitsSystemWindows(false);
        r18.setPadding(0, 0, 0, 0);
    L64:
        if (r13 == null) goto L68;
        Window r19 = r13.getWindow();
        if (r19 == null) goto L68;
        View r20 = X90(r19);
    L70:
        if ((r20 instanceof ViewGroup) == false) goto L73;
        r5 = r20;
    L73:
        ViewGroup r21 = (ViewGroup) r5;
        if (r21 == null) goto L78;
        View r22 = r21.getChildAt(0);
        if (r22 == null) goto L78;
        r22.setFitsSystemWindows(false);
        r22.setPadding(0, 0, 0, 0);
    L78:
        x8.b(r13);
    L68:
        r20 = null;
    L79:
        if (r13 == null) goto L85;
        Window r110 = r13.getWindow();
        if (r110 == null) goto L85;
        View r111 = X90(r110);
        if (r111 == null) goto L85;
        r111.invalidate();
    L85:
        Dialog r112 = getDialog();
        if (r112 == null) goto L91;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L92;
        r113.setGravity(85);
        return;
    L92:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        dismissDialog();
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h = true;
    }

    public final void onDismiss(DialogInterface r2) {
        Y90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r4, r5);
        Observable r0 = null;
        if (((Boolean) vm2.d.S2.getValue(null, vm2.d.a[198(0xc6, float:2.77E-43)])).booleanValue() == false) goto L10;
        Dialog r6 = getDialog();
        if (r6 == null) goto L10;
        View r7 = r6.findViewById(2131389843);
        if (r7 == null) goto L10;
        r7.setVisibility(8);
    L10:
        if (isAdded() == false) goto L20;
        int r8 = CommonOrderSongDialog.u;
        com.bytedance.android.live.ktv.common.karaokestation.model.a r9 = this.m.b(new C02141(this));
        Intrinsics.checkNotNullParameter(r9, "config");
        CommonOrderSongDialog r10 = new CommonOrderSongDialog(r9);
        r10.s = new KSongOrderSongDialog$onViewCreated$$inlined$apply$lambda$1(this);
        Unit r11 = Unit.INSTANCE;
        this.k = r10;
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction();
        CommonOrderSongDialog r13 = this.k;
        Intrinsics.checkNotNull(r13);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131381651) == true) goto L15;
        r12 = r12.add(2131381651, r13);
    L15:
        r12.commitAllowingStateLoss();
        View r14 = ((BaseKtvDialogFragment) this).f;
        if (r14 == null) goto L20;
        View r15 = r14.findViewById(2131381758);
        if (r15 == null) goto L20;
        r15.setOnClickListener(new b(this));
    L20:
        com.bytedance.android.livesdk.chatroom.u r16 = m.d();
        if (r16 == null) goto L29;
        com.bytedance.live.datacontext.m r17 = r16.I1();
        if (r17 == null) goto L29;
        Observable r18 = r17.a();
        if (r18 == null) goto L29;
        ObservableSubscribeProxy r19 = (ObservableSubscribeProxy) r18.as(AutoDispose.bind(this));
        if (r19 == null) goto L29;
        r19.subscribe(new c(this));
    L29:
        StringBuilder r20 = new StringBuilder("observeAdminChanged UserAttr:  ");
        IMiddlewareUserService r21 = k.f(IMiddlewareUserService.class);
        if (r21 == null) goto L34;
        com.bytedance.android.livesdk.user.e r22 = r21.user();
        if (r22 == null) goto L34;
        r0 = r22.u();
    L34:
        r20.append(r0);
        r20.append(" isAdmin : ");
        r20.append(k.n(IMiddlewareUserService.class).user().isAdmin());
        ALogger.d("KSongOrderSongDialog", r20.toString());
        IMiddlewareUserService r23 = k.f(IMiddlewareUserService.class);
        if (r23 == null) goto L43;
        com.bytedance.android.livesdk.user.e r24 = r23.user();
        if (r24 == null) goto L43;
        Observable r25 = r24.u();
        if (r25 == null) goto L43;
        Disposable r26 = r25.subscribe(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.f(this));
        if (r26 == null) goto L43;
        RxUtilKt.c(r26, this.j);
    L43:
        CommonOrderSongDialog r27 = this.k;
        if (r27 == null) goto L48;
        Function3 r28 = r27.t.b.l;
        if (r28 == null) goto L48;
        Unit r29 = (Unit) r28.invoke(r27.n, r27.p, r27.j);
    L48:
        o r30 = m.i();
        if (r30 == null) goto L57;
        RoomContext r31 = r30.L1();
        if (r31 == null) goto L57;
        Completable r32 = r31.getOnCleared();
        if (r32 == null) goto L57;
        com.bytedance.android.live.core.utils.rxutils.autodispose.u r33 = (com.bytedance.android.live.core.utils.rxutils.autodispose.u) r32.as(AutoDispose.bind(this));
        if (r33 == null) goto L57;
        r33.a(new d(this));
    L57:
        com.bytedance.android.livesdk.chatroom.u r34 = m.d();
        if (r34 == null) goto L68;
        j r35 = r34.s();
        if (r35 == null) goto L68;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r36 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.getValue();
        if (r36 == null) goto L68;
        BehaviorSubject r37 = r36.a();
        if (r37 == null) goto L68;
        ObservableSubscribeProxy r38 = (ObservableSubscribeProxy) r37.as(AutoDispose.bind(this));
        if (r38 == null) goto L68;
        r38.subscribe(new e(this));
    L68:
        Dialog r39 = getDialog();
        if (r39 == null) goto L71;
        r39.setOnShowListener(new f(this));
    L71:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r40 = this.l;
        if (r40 == null) goto L74;
        r40.observeSingUserChange(this, true, new g(this));
    L74:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r41 = this.l;
        if (r41 == null) goto L78;
        r41.observeMusicPlayerState(this, new h(this));
        return;
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (Build.VERSION.SDK_INT < 26) goto L9;
        Dialog r0 = getDialog();
        if (r0 == null) goto L14;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        r1.setType(2038);
    L14:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r2) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.showNow(r3, r4);
        return;
    L23:
        return;
    L9:
        Dialog r5 = getDialog();
        if (r5 == null) goto L14;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L14;
        r6.setType(2002);
        goto L14
    }

    public KSongOrderSongDialog(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e r3, Function0<Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabManager");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.g = true;
        this.j = new CompositeDisposable();
    }

    public static void aa0(KSongOrderSongDialog r6, boolean r7, String r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r7 = false;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r8 = "";
    L8:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "source");
        Map<String, cm2.a> r10 = q.a;
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r11 = q.b();
        if (r11 != null) goto L11;
    L13:
        ALogger.i("KSongOrderSongDialog", "before showDialog ;; isDialogShowing == " + r6.h + " ;; isForceOpen == " + r7);
        if (r6.h == false) goto L16;
        if (r7 == true) goto L16;
        return;
    L16:
        ALogger.i("KSongOrderSongDialog", "real showDialog");
        r6.h = true;
        Dialog r12 = r6.getDialog();
        if (r12 != null) goto L19;
    L23:
        View r13 = ((BaseKtvDialogFragment) r6).f;
        if (r13 == null) goto L26;
        r13.post(new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.g(r6));
    L26:
        pd2.d.n.getClass();
        pd2.d.G(r8, false);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = r6.l;
        if (r14 == null) goto L36;
        MutableLiveData<vb0.a> r15 = r14.getOrderSongUiState();
        if (r15 == null) goto L37;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r15, KSongOrderSongDialog$showDialog$2.INSTANCE);
        return;
    L37:
        return;
    L36:
        return;
    L19:
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(r12);
        goto L23
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L22:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        goto L23
    L11:
        if (r11.b == true) goto L13;
        r11.g = System.currentTimeMillis() - r11.c;
        goto L13
    }
}
