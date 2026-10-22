package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.window.base.shop.ECWindowAwemeFeedVideoZoomController;
import com.bytedance.android.ec.window.base.utils.window.ECWindowShopLiveData;
import com.bytedance.android.ec.window.base.utils.window.IECFeedControllerPresenter;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.header.WindowHeaderFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.gyf.barlibrary.ImmersionBar;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowCroppedStyleRootPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStop", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCroppedStyleRootPresenter extends AbsECWindowPresenter implements LifecycleObserver {
    public static final /* synthetic */ int s = 0;
    public final a m;
    public final Lazy n;
    public ECWindowAwemeFeedVideoZoomController o;
    public final c p;
    public ImmersionBar q;
    public final Lazy r;

    public final class a extends IECFeedControllerPresenter {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter d;

        public final Context b() {
            ECWindowCroppedStyleRootPresenter r0 = this.d;
            int r1 = ECWindowCroppedStyleRootPresenter.s;
            return r0.u().c();
        }

        public final ECWindowShopLiveData c() {
            return this.d.O().getCroppedState();
        }

        public final LifecycleOwner d() {
            return this.d.U();
        }

        public final boolean e() {
            return this.d.Q();
        }

        public final boolean f() {
            return this.d.T();
        }

        public a(ECWindowCroppedStyleRootPresenter r1) {
            this.d = r1;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

        public b(ECWindowCroppedStyleRootPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.D();
        }
    }

    public static final class c implements ECWindowOverScrollExpandBehavior.c {
        public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

        public final void b() {
        }

        public final boolean d() {
            return false;
        }

        public final long f() {
            return 200;
        }

        public final int a() {
            return this.a.G() / 2;
        }

        public final void e() {
            this.a.D();
        }

        public c(ECWindowCroppedStyleRootPresenter r1) {
            this.a = r1;
        }

        public final void c(int r4) {
            ECWindowCroppedStyleRootPresenter r0 = this.a;
            ECWindowAwemeFeedVideoZoomController r1 = r0.o;
            if (r1 == null) goto L25;
            int r2 = ((Number) r0.f.getValue()).intValue() - r4;
            ValueAnimator r5 = r1.a;
            if (r5 != null) goto L7;
        L8:
            ValueAnimator r6 = r1.f;
            if (r6 != null) goto L11;
        L13:
            boolean r7 = false;
        L14:
            if (r7 == true) goto L26;
            ValueAnimator r8 = r1.d;
            if (r8 != null) goto L19;
        L23:
            r1.b(r2);
            return;
        L19:
            if (r8.isRunning() != true) goto L23;
            ValueAnimator r9 = r1.d;
            if (r9 == null) goto L23;
            r9.cancel();
            goto L23
        L26:
            return;
        L11:
            if (r6.isRunning() != true) goto L13;
        L12:
            r7 = true;
            goto L14
        L7:
            if (r5.isRunning() == true) goto L12;
        }

        public final void onRelease(int r5) {
            ECWindowAwemeFeedVideoZoomController r0 = this.a.o;
            if (r0 == null) goto L11;
            ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0.e, r0.g});
            r0.d = r1;
            if (r1 == null) goto L7;
            r1.setDuration(100);
            r1.addUpdateListener(new com.bytedance.android.ec.window.base.shop.a(r0));
        L7:
            ValueAnimator r2 = r0.d;
            if (r2 == null) goto L11;
            r2.start();
        L11:
            if (r5 <= ((int) (this.a.G() * 1.35f))) goto L14;
            this.a.D();
            return;
        }
    }

    public final void C() {
        a r0 = this.m;
        r0.c().removeObserver((Observer) ((IECFeedControllerPresenter) r0).b.getValue());
        r0.d().getLifecycle().removeObserver((LifecycleEventObserver) ((IECFeedControllerPresenter) r0).c.getValue());
        U().getLifecycle().removeObserver(this);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r2 = this.q;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        this.q = null;
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public ECWindowCroppedStyleRootPresenter() {
        this.m = new a(this);
        this.n = LazyKt.lazy(new ECWindowCroppedStyleRootPresenter$doDragShowFullShopWindowEventReportOnce$2(this));
        this.p = new c(this);
        this.r = LazyKt.lazy(new ECWindowCroppedStyleRootPresenter$slideNoticeView$2(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        boolean r0 = O().getShopParam().getStatusBarDarkFont();
        QContext r1 = u();
        Activity r2 = com.bytedance.android.ec.core.utils.l0.c(r1.c());
        if ((r2 instanceof FragmentActivity) == true) goto L5;
        r2 = null;
    L5:
        if (r2 != null) goto L7;
        r2 = r1.a();
    L7:
        int r3 = com.bytedance.android.ec.core.utils.y1.a;
        com.bytedance.android.ec.core.utils.y1.c(r2, r2.getWindow(), r0);
    }

    public final void A(QModel r7) {
        this.m.a();
        w().b(2131370890).f().setOnClickListener(new t(this));
        w().b(2131370890).g(4);
        O().getHeaderResponse().a(U(), new u(this), true);
        O().getHeaderResponse().a(U(), new v(this), true);
        O().getOffsetState().a(U(), new w(this), false);
        O().getCroppedState().observe(U(), new s(this));
        Fragment r8 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if ((r8 instanceof DialogFragment) == true) goto L5;
        r8 = null;
    L5:
        DialogFragment r9 = (DialogFragment) r8;
        if (r9 != null) goto L245;
    L15:
        View r10 = y().findViewById(2131371106);
        if (r10 == null) goto L18;
        r10.setVisibility(0);
        r10.setOnClickListener(new b(this));
    L18:
        View r11 = y();
    L19:
        if (r11 == null) goto L27;
        View r0 = com.bytedance.android.ec.window.base.utils.c.a(X(), ECWindowCroppedStyleRootPresenter$setupOverScrollController$owner$1.INSTANCE);
        if (r0 != null) goto L22;
        Object r12 = r11.getParent();
        if ((r12 instanceof View) == true) goto L26;
        r12 = null;
    L26:
        r11 = (View) r12;
        goto L19
    L22:
        r11 = r0;
    L27:
        if (r11 == null) goto L29;
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
    L31:
        if ((r13 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        r13 = null;
    L33:
        CoordinatorLayout.LayoutParams r14 = (CoordinatorLayout.LayoutParams) r13;
        if (r14 == null) goto L43;
        CoordinatorLayout.Behavior r15 = r14.getBehavior();
        if (r15 == null) goto L43;
        if ((r15 instanceof ECWindowOverScrollExpandBehavior) == true) goto L41;
        r15 = null;
    L41:
        if (r15 == null) goto L43;
        ((ECWindowOverScrollExpandBehavior) r15).setExpandController(this.p);
    L43:
        U().getLifecycle().addObserver(this);
        int r16 = com.bytedance.android.ec.window.base.shop.r.a;
        int r17 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r18 = 0;
        boolean r1 = ECServiceManager.a;
        s83.g r2 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r2 == null) goto L49;
        s83.a r3 = r2.q();
        if (r3 == null) goto L49;
        Object r4 = r3.e("ec_store_video_zoom");
        if (r4 == null) goto L49;
    L214:
        if (((Number) r4).intValue() != 1) goto L220;
        Uri r19 = O().getSchema();
        if (r19 == null) goto L220;
        String r20 = UriProtector.getQueryParameter(r19, "video_zoom_controller_hash");
        if (r20 == null) goto L220;
        ECWindowAwemeFeedVideoZoomController r5 = new ECWindowAwemeFeedVideoZoomController(((Number) this.f.getValue()).intValue() - G(), CastIntegerProtector.parseInt(r20));
        U().getLifecycle().addObserver(r5);
        Unit r21 = Unit.INSTANCE;
        this.o = r5;
    L220:
        ECWindowDialogFragment r22 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        if (r22 == null) goto L251;
        FragmentManager r23 = r22.getChildFragmentManager();
        if (r23 == null) goto L252;
        FragmentTransaction r24 = r23.beginTransaction();
        if (r24 == null) goto L253;
        WindowHeaderFragment r6 = new WindowHeaderFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r24, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131370889) == true) goto L230;
        r24 = r24.replace(2131370889, r6);
    L230:
        if (r24 == null) goto L254;
        r24.commit();
        return;
    L254:
        return;
    L253:
        return;
    L252:
        return;
    L251:
        return;
    L49:
        int r25 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r26 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L204
        Object r28 = com.bytedance.android.ec.base.settings.d.c.get("ec_store_video_zoom");     // Catch: Throwable -> L100
        if (r28 != null) goto L55;
    L97:
        Object r29 = null;
    L98:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L100
    L102:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L204
        if (r31 == null) goto L106;
        EnsureManager.ensureNotReachHere(r31);     // Catch: Throwable -> L204
    L106:
        if (Result.isFailure-impl(r30) == false) goto L109;
        r30 = null;
    L109:
        if ((r30 instanceof Integer) == true) goto L111;
        r30 = null;
    L111:
        r4 = (Integer) r30;     // Catch: Throwable -> L204
        if (r4 != null) goto L118;
        Object r32 = com.bytedance.android.ec.base.settings.d.a.get("ec_store_video_zoom");     // Catch: Throwable -> L204
        if ((r32 instanceof Integer) == true) goto L117;
        r32 = null;
    L117:
        r4 = (Integer) r32;     // Catch: Throwable -> L204
    L118:
        if (r4 != null) goto L214;
        int r33 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L204
        Object r34 = com.bytedance.android.ec.base.settings.d.c.get("ec_store_video_zoom");     // Catch: Throwable -> L170
        if (r34 != null) goto L125;
    L167:
        Object r35 = null;
    L168:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L170
    L172:
        Throwable r37 = Result.exceptionOrNull-impl(r36);     // Catch: Throwable -> L195
        if (r37 == null) goto L176;
        EnsureManager.ensureNotReachHere(r37);     // Catch: Throwable -> L195
    L176:
        if (Result.isFailure-impl(r36) == false) goto L179;
        r36 = null;
    L179:
        if ((r36 instanceof Integer) == true) goto L181;
        r36 = null;
    L181:
        r4 = (Integer) r36;     // Catch: Throwable -> L195
        if (r4 != null) goto L202;
        IHybridHostService r38 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L195
        if (r38 == null) goto L187;
        Object r39 = r38.getHostABValue("ec_store_video_zoom", r18);     // Catch: Throwable -> L195
    L188:
        if (r39 != null) goto L190;
    L201:
        r4 = r18;
        goto L202
    L190:
        if ((r39 instanceof Integer) == true) goto L192;
        r39 = null;
    L192:
        r4 = (Integer) r39;     // Catch: Throwable -> L195
        if (r4 != null) goto L202;
    L195:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L204
        r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
        Throwable r41 = Result.exceptionOrNull-impl(r4);     // Catch: Throwable -> L204
        if (r41 == null) goto L200;
        EnsureManager.ensureNotReachHere(r41);     // Catch: Throwable -> L204
    L200:
        if (Result.isFailure-impl(r4) == false) goto L202;
    L187:
        r39 = null;
    L202:
        com.bytedance.android.ec.base.settings.d.d("ec_store_video_zoom", r4);     // Catch: Throwable -> L204
        goto L214
    L125:
        if ((r34 instanceof Integer) == true) goto L127;
        Object r42 = null;
    L128:
        r35 = (Integer) r42;     // Catch: Throwable -> L170
        if (r35 != null) goto L168;
        if ((r34 instanceof Number) == false) goto L155;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L140;
        Float r43 = Float.valueOf(((Number) r34).floatValue());     // Catch: Throwable -> L170
        if ((r43 instanceof Integer) == true) goto L138;
        r43 = null;
    L138:
        r35 = (Integer) r43;     // Catch: Throwable -> L170
        goto L168
    L140:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L146;
        Double r44 = Double.valueOf(((Number) r34).doubleValue());     // Catch: Throwable -> L170
        if ((r44 instanceof Integer) == true) goto L144;
        r44 = null;
    L144:
        r35 = (Integer) r44;     // Catch: Throwable -> L170
        goto L168
    L146:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L149;
        r35 = Integer.valueOf(((Number) r34).intValue());     // Catch: Throwable -> L170
        goto L168
    L149:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L155;
        Long r45 = Long.valueOf(((Number) r34).longValue());     // Catch: Throwable -> L170
        if ((r45 instanceof Integer) == true) goto L153;
        r45 = null;
    L153:
        r35 = (Integer) r45;     // Catch: Throwable -> L170
    L155:
        if ((r34 instanceof JSONObject) == false) goto L157;
    L235:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L163
        Object r46 = SDKSettingsCacheManager.a().fromJson(r34.toString(), Integer.class);     // Catch: Throwable -> L163
        if ((r46 instanceof Integer) == true) goto L161;
        r46 = null;
    L161:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L163
    L165:
        r35 = r47;
        if (Result.isFailure-impl(r35) == false) goto L168;
    L163:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L170
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        goto L165
    L157:
        if ((r34 instanceof JSONArray) == false) goto L167;
    L127:
        r42 = r34;
    L170:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L195
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L195
        goto L172
    L55:
        if ((r28 instanceof Integer) == true) goto L57;
        Object r50 = null;
    L58:
        r29 = (Integer) r50;     // Catch: Throwable -> L100
        if (r29 != null) goto L98;
        if ((r28 instanceof Number) == false) goto L85;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L70;
        Float r51 = Float.valueOf(((Number) r28).floatValue());     // Catch: Throwable -> L100
        if ((r51 instanceof Integer) == true) goto L68;
        r51 = null;
    L68:
        r29 = (Integer) r51;     // Catch: Throwable -> L100
        goto L98
    L70:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L76;
        Double r52 = Double.valueOf(((Number) r28).doubleValue());     // Catch: Throwable -> L100
        if ((r52 instanceof Integer) == true) goto L74;
        r52 = null;
    L74:
        r29 = (Integer) r52;     // Catch: Throwable -> L100
        goto L98
    L76:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L79;
        r29 = Integer.valueOf(((Number) r28).intValue());     // Catch: Throwable -> L100
        goto L98
    L79:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L85;
        Long r53 = Long.valueOf(((Number) r28).longValue());     // Catch: Throwable -> L100
        if ((r53 instanceof Integer) == true) goto L83;
        r53 = null;
    L83:
        r29 = (Integer) r53;     // Catch: Throwable -> L100
    L85:
        if ((r28 instanceof JSONObject) == false) goto L87;
    L233:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L93
        Object r54 = SDKSettingsCacheManager.a().fromJson(r28.toString(), Integer.class);     // Catch: Throwable -> L93
        if ((r54 instanceof Integer) == true) goto L91;
        r54 = null;
    L91:
        Object r55 = Result.constructor-impl((Integer) r54);     // Catch: Throwable -> L93
    L95:
        r29 = r55;
        if (Result.isFailure-impl(r29) == false) goto L98;
    L93:
        th = move-exception;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L100
        r55 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L100
        goto L95
    L87:
        if ((r28 instanceof JSONArray) == false) goto L97;
    L57:
        r50 = r28;
    L100:
        th = move-exception;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L204
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
    L204:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        Object r59 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r60 = Result.exceptionOrNull-impl(r59);
        if (r60 == null) goto L209;
        EnsureManager.ensureNotReachHere(r60);
    L209:
        if (Result.isFailure-impl(r59) == true) goto L212;
        r18 = r59;
    L212:
        r4 = r18;
        goto L214
    L29:
        r13 = null;
        goto L31
    L245:
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L9
        Object r62 = Result.constructor-impl(ImmersionBar.with(r9));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r62) == false) goto L14;
        r62 = null;
    L14:
        this.q = (ImmersionBar) r62;
    L9:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        r62 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
