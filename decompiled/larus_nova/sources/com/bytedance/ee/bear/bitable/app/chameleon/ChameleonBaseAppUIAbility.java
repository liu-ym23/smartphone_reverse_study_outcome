package com.bytedance.ee.bear.bitable.app.chameleon;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.app.BitableAppDrawerManager;
import com.bytedance.ee.bear.bitable.app.BitableAppFrameworkPlugin;
import com.bytedance.ee.bear.bitable.app.model.AppTheme;
import com.bytedance.ee.bear.bitable.app.model.NavigationBarColor;
import com.bytedance.ee.bear.bitable.app.o;
import com.bytedance.ee.bear.bitable.app.titlebar.BitableAppTitleBarAdapter;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.restore.DocDeletedCtrlView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class ChameleonBaseAppUIAbility implements com.bytedance.ee.bear.bitable.app.chameleon.d, com.bytedance.ee.bear.bitable.core.c {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChameleonPluginHost f206864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f206865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.app.chameleon.a f206866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableAppTitleBarAdapter f206867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final do4.c f206868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vz4.b f206869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.bottompanel.a f206870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DocViewModel f206871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppBarLayout f206872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f206873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.infoarch.swipe.b f206874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BitableAppDrawerManager f206875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.utils.c.a f206876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f206877n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f206878o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f206879p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.app.chameleon.c f206880q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vz4.b.a f206881r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a f206882s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a f206883t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f206884u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f206885v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f206886w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f206887x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f206888y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f206889z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.app.chameleon.ChameleonBaseAppUIAbility$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r100) {
            super(1, r100, ChameleonBaseAppUIAbility.class, "updateTitleBarOnDrawerStateChanged", "updateTitleBarOnDrawerStateChanged(Z)V", 0);
        }

        public final void invoke(boolean r100) {
            ChameleonBaseAppUIAbility r101 = (ChameleonBaseAppUIAbility) this.receiver;
            if (r101.f206866c.f206896a.getWidth() > n.d(600)) goto L5;
            if (r100 == false) goto L5;
            return;
        L5:
            MutableLiveData<Boolean> r102 = r101.f206867d.f206959s;
            if (r102 == null) goto L10;
            r102.setValue(Boolean.valueOf(r100));
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.app.chameleon.ChameleonBaseAppUIAbility$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(Object r100) {
            super(1, r100, ChameleonBaseAppUIAbility.class, "updateHostControlsForDrawer", "updateHostControlsForDrawer(Z)V", 0);
        }

        public final void invoke(boolean r100) {
            ChameleonBaseAppUIAbility r101 = (ChameleonBaseAppUIAbility) this.receiver;
            com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r102 = null;
            if (r100 == true) goto L5;
            int r103 = ChameleonBaseAppUIAbility.A;
            vz4.b.a r104 = r101.f206881r;
            if (r104 == null) goto L20;
            r104.close();
        L20:
            r101.f206881r = null;
            com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r105 = r101.f206882s;
            if (r105 == null) goto L23;
            r105.close();
        L23:
            r101.f206882s = null;
            return;
        L5:
            if (r101.f206881r != null) goto L12;
            vz4.b r106 = r101.f206869f;
            if (r106 == null) goto L9;
            vz4.c.b r107 = r106.qh("OfficeBaseAppDrawer");
        L10:
            r101.f206881r = r107;
            goto L12
        L9:
            r107 = null;
        L12:
            if (r101.f206882s != null) goto L25;
            com.bytedance.ee.bear.bitable.core.bottompanel.a r108 = r101.f206870g;
            if (r108 == null) goto L16;
            r102 = r108.Yc("OfficeBaseAppDrawer");
        L16:
            r101.f206882s = r102;
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonBaseAppUIAbility f206890a;

        public a(ChameleonBaseAppUIAbility r100) {
            this.f206890a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f206890a.a();     // Catch: Throwable -> L4
            this.f206890a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonBaseAppUIAbility f206891a;

        public c(ChameleonBaseAppUIAbility r100) {
            this.f206891a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f206891a.a();
            this.f206891a.c();
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonBaseAppUIAbility f206892a;

        public d(ChameleonBaseAppUIAbility r100) {
            this.f206892a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (this.f206892a.f206875l.c() == false) goto L12;
            ChameleonBaseAppUIAbility r102 = this.f206892a;
            BitableAppDrawerManager r103 = r102.f206875l;
            DocViewModel r104 = r102.f206871h;
            if (r104 == null) goto L9;
            MutableLiveData<IconInfo> r105 = r104.getShowingIconInfo();
            if (r105 == null) goto L9;
            IconInfo r106 = r105.getValue();
        L10:
            r103.d(null, r102.b(r101, r106));
            return;
        L9:
            r106 = null;
            goto L10
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonBaseAppUIAbility f206893a;

        public e(ChameleonBaseAppUIAbility r100) {
            this.f206893a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IconInfo r101 = (IconInfo) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (this.f206893a.f206875l.c() == false) goto L15;
            ChameleonBaseAppUIAbility r102 = this.f206893a;
            BitableAppDrawerManager r103 = r102.f206875l;
            DocViewModel r104 = r102.f206871h;
            if (r104 == null) goto L11;
            LiveData<String> r105 = r104.getDocName();
            if (r105 == null) goto L11;
            String r106 = r105.getValue();
        L12:
            r103.d(null, r102.b(r106, r101));
            return;
        L11:
            r106 = null;
            goto L12
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonBaseAppUIAbility f206894a;

        public f(ChameleonBaseAppUIAbility r100) {
            this.f206894a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AppTheme r101 = (AppTheme) r100;
            Intrinsics.checkNotNullParameter(r101, "theme");
            int r102 = ColorProtector.parseColor(r101.getNavigationBgColor());
            ChameleonBaseAppUIAbility r103 = this.f206894a;
            r103.f206878o = Integer.valueOf(r102);
            this.f206894a.f206866c.f206896a.setBackgroundColor(r102);
            ChameleonBaseAppUIAbility r104 = this.f206894a;
            r104.f(r104.f206877n, Integer.valueOf(r102));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void Ha() {
        this.f206885v = true;
        if (h18.f.a(this.f206864a.getContext()) == false) goto L5;
        String r100 = "#262626";
    L6:
        S2(new AppTheme("Default", r100, null, null, null, null, null, 124, null));
        jc(false);
        d();
        this.f206867d.setLeftVisible(false);
        this.f206867d.setTitleVisibility(false);
        return;
    L5:
        r100 = "#F8F9FA";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void n5() {
        this.f206885v = false;
        this.f206867d.setLeftVisible(true);
        this.f206867d.setTitleVisibility(true);
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean Y4() {
        return this.f206880q.f206910d;
    }

    public final void a() {
        com.bytedance.ee.bear.bitable.app.chameleon.a r100 = this.f206866c;
        if (r100.f206897b.getPaddingTop() == 0) goto L6;
        ViewGroup r101 = r100.f206897b;
        r101.setPadding(r101.getPaddingLeft(), 0, r100.f206897b.getPaddingRight(), r100.f206897b.getPaddingBottom());
    L6:
        AppBarLayout r102 = this.f206872i;
        if (r102 != null) goto L9;
        return;
    L9:
        int r103 = h();
        if (r102.getVisibility() != 0) goto L13;
        if (r103 != 0) goto L13;
        return;
    L13:
        com.bytedance.ee.bear.bitable.app.chameleon.a r104 = this.f206866c;
        ViewGroup.LayoutParams r105 = r104.f206898c.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L17:
        if (r106 != null) goto L20;
        return;
    L20:
        if (r106.topMargin == r103) goto L25;
        r106.topMargin = r103;
        r104.f206898c.setLayoutParams(r106);
        return;
    L25:
        return;
    L16:
        r106 = null;
        goto L17
    }

    public final void c() {
        m.u(this.f206866c.f206901f, h(), false);
    }

    public final void d() {
        FragmentManager r100 = this.f206865b.getFragmentManager();
        if (r100.getBackStackEntryCount() <= 0) goto L6;
        r100.popBackStack(null, 1);
    L6:
        if ((!r100.getFragments().isEmpty()) == false) goto L14;
        FragmentTransaction r101 = r100.beginTransaction();
        Iterator<T> r102 = r100.getFragments().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r101.remove((Fragment) r102.next());
        goto L9
    L11:
        r101.commitNowAllowingStateLoss();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void destroy() {
        if (this.f206884u == false) goto L5;
        return;
    L5:
        this.f206884u = true;
        vz4.b.a r100 = this.f206881r;
        if (r100 == null) goto L8;
        r100.close();
    L8:
        this.f206881r = null;
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r101 = this.f206882s;
        if (r101 == null) goto L11;
        r101.close();
    L11:
        this.f206882s = null;
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r102 = this.f206883t;
        if (r102 == null) goto L14;
        r102.close();
    L14:
        this.f206883t = null;
        do4.c r103 = this.f206868e;
        if (r103 != null) goto L17;
    L21:
        this.f206873j.f206955d.removeObserver(this.f206886w);
        DocViewModel r104 = this.f206871h;
        if (r104 == null) goto L26;
        LiveData<String> r105 = r104.getDocName();
        if (r105 == null) goto L26;
        r105.removeObserver(this.f206887x);
    L26:
        DocViewModel r106 = this.f206871h;
        if (r106 == null) goto L31;
        MutableLiveData<IconInfo> r107 = r106.getShowingIconInfo();
        if (r107 == null) goto L31;
        r107.removeObserver(this.f206888y);
    L31:
        AppBarLayout r108 = this.f206872i;
        if (r108 == null) goto L34;
        r108.removeOnLayoutChangeListener(this.f206889z);
    L34:
        this.f206875l.a();
        this.f206874k.w0();
        com.bytedance.ee.bear.bitable.app.chameleon.c r109 = this.f206880q;
        if (r109.f206914h == false) goto L39;
        com.bytedance.ee.bear.bitable.utils.c.a r110 = r109.f206907a;
        if (r110 == null) goto L39;
        r110.g();
    L39:
        r109.f206914h = false;
        r109.f206912f = null;
        r109.f206913g = null;
        r109.f206909c = false;
        r109.f206910d = false;
        com.bytedance.ee.bear.bitable.utils.c.a r111 = this.f206876m;
        if (r111 == null) goto L43;
        r111.g();
        return;
    L43:
        return;
    L17:
        if (h18.f.a(this.f206864a.getContext()) == false) goto L19;
        String r112 = "#262626";
    L20:
        r103.B1(ColorProtector.parseColor(r112));
        goto L21
    L19:
        r112 = "#F8F9FA";
        goto L20
    }

    public final int h() {
        AppBarLayout r100 = this.f206872i;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.getVisibility() == 0) goto L8;
        return 0;
    L8:
        Integer r101 = Integer.valueOf(r100.getMeasuredHeight());
        if (r101.intValue() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        r101 = null;
    L15:
        if (r101 == null) goto L18;
        return r101.intValue();
    L18:
        return RangesKt.coerceAtLeast(r100.getHeight(), 0);
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean onBackPressed() {
        if (this.f206880q.f206910d == false) goto L5;
        return false;
    L5:
        com.bytedance.ee.bear.bitable.infoarch.swipe.c r100 = this.f206874k.c();
        if (r100 != null) goto L8;
        return false;
    L8:
        this.f206874k.w0();
        r100.f213690b.b(new JSONObject());
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void p9() {
        this.f206867d.setLeftVisible(true);
        this.f206867d.setTitleVisibility(true);
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void w0() {
        this.f206874k.w0();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void y() {
        this.f206875l.y();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean mo() {
        return this.f206885v;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void Hf(DocDeletedCtrlView r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (h18.f.a(this.f206864a.getContext()) == false) goto L5;
        String r100 = "#262626";
    L6:
        S2(new AppTheme("Default", r100, null, null, null, null, null, 124, null));
        jc(false);
        d();
        this.f206867d.setLeftVisible(false);
        this.f206867d.setTitleVisibility(false);
        ViewParent r101 = r110.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ViewGroup r102 = (ViewGroup) r101;
    L11:
        if (r102 == this.f206866c.f206898c) goto L16;
        if (r102 == null) goto L14;
        r102.removeView(r110);
    L14:
        this.f206866c.f206898c.addView(r110);
        return;
    L16:
        return;
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = "#F8F9FA";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void S2(AppTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "appTheme");
        this.f206873j.a(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r100.getNavigationBgColor())));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r102) == false) goto L12;
        int r103 = ((Number) r102).intValue();
        do4.c r104 = this.f206868e;
        if (r104 == null) goto L12;
        r104.B1(r103);
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r102);
        if (r105 == null) goto L18;
        tt5.a.e("ChameleonBaseAppUIAbility", "set AI chat theme failed", r105, false);
        return;
    L18:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final int e(Integer r100) {
        if (r100 != null) goto L17;
        r100 = this.f206879p;
        if (r100 != null) goto L17;
        AppTheme r101 = this.f206873j.f206955d.getValue();
        if (r101 == null) goto L12;
        String r102 = r101.getNavigationBgColor();
        if (r102 == null) goto L12;
        r100 = Integer.valueOf(ColorProtector.parseColor(r102));
    L13:
        if (r100 != null) goto L17;
        return 0;
    L12:
        r100 = null;
    L17:
        return r100.intValue();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void ed(NavigationBarColor r100) {
        Intrinsics.checkNotNullParameter(r100, "colorModel");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Integer r102 = Integer.valueOf(Color.parseColor(r100.getBgColor()));     // Catch: Throwable -> L5
        this.f206879p = r102;     // Catch: Throwable -> L5
        f(this.f206877n, r102);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        tt5.a.e("ChameleonBaseAppUIAbility", "setNavigationBarColor failed", r104, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void gc(qo4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        IconInfo r101 = null;
        if (this.f206875l.c() == false) goto L6;
        this.f206875l.d(r100, null);
        return;
    L6:
        BitableAppTitleBarAdapter r102 = this.f206867d;
        MenuItem r103 = new MenuItem(BitableAppFrameworkPlugin.MENU_ID_DRAWER, l.a(this.f206864a.getContext(), R.drawable.ud_icon_menu_outlined, R.color.facade_selector_icon_n1), null);
        r103.setClickListener(new g(this));
        Unit r104 = Unit.INSTANCE;
        r102.j(CollectionsKt.mutableListOf(new MenuItem[]{r103}), TitleBar.MenuType.Left);
        BitableAppDrawerManager r105 = this.f206875l;
        DocViewModel r106 = this.f206871h;
        if (r106 == null) goto L11;
        LiveData<String> r107 = r106.getDocName();
        if (r107 == null) goto L11;
        String r108 = r107.getValue();
    L12:
        DocViewModel r109 = this.f206871h;
        if (r109 == null) goto L17;
        MutableLiveData<IconInfo> r110 = r109.getShowingIconInfo();
        if (r110 == null) goto L17;
        r101 = r110.getValue();
    L17:
        r105.d(r100, b(r108, r101));
        return;
    L11:
        r108 = null;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void hl(boolean r100) {
        this.f206874k.a(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.core.c
    public final void ij(boolean r100) {
        com.bytedance.ee.bear.bitable.app.chameleon.c r101 = this.f206880q;
        r101.f206910d = r100;
        r101.a();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean jc(boolean r100) {
        AppBarLayout r101 = this.f206872i;
        if (r101 != null) goto L7;
        tt5.a.d("ChameleonBaseAppUIAbility", "setFullscreen failed: app bar missing");
        return false;
    L7:
        if (r100 == true) goto L9;
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r102 = this.f206883t;
        if (r102 == null) goto L18;
        r102.close();
    L18:
        this.f206883t = null;
    L19:
        this.f206866c.f206896a.suppressLayout(true);
        if (r100 == false) goto L22;
        this.f206875l.y();     // Catch: Throwable -> L26
        this.f206877n = false;     // Catch: Throwable -> L26
        com.bytedance.ee.bear.bitable.app.chameleon.c r103 = this.f206880q;     // Catch: Throwable -> L26
        int r104 = e(null);     // Catch: Throwable -> L26
        r103.f206909c = true;     // Catch: Throwable -> L26
        r103.f206911e = r104;     // Catch: Throwable -> L26
        r103.a();     // Catch: Throwable -> L26
        r101.setVisibility(8);     // Catch: Throwable -> L26
        a();     // Catch: Throwable -> L26
    L23:
        this.f206866c.f206896a.requestApplyInsets();     // Catch: Throwable -> L26
        this.f206866c.f206896a.suppressLayout(false);
        return true;
    L22:
        r101.setVisibility(0);     // Catch: Throwable -> L26
        this.f206879p = null;     // Catch: Throwable -> L26
        this.f206877n = true;     // Catch: Throwable -> L26
        com.bytedance.ee.bear.bitable.app.chameleon.c r105 = this.f206880q;     // Catch: Throwable -> L26
        int r106 = e(null);     // Catch: Throwable -> L26
        r105.f206909c = false;     // Catch: Throwable -> L26
        r105.f206911e = r106;     // Catch: Throwable -> L26
        r105.a();     // Catch: Throwable -> L26
        a();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.f206866c.f206896a.suppressLayout(false);
        throw th;
    L9:
        if (this.f206883t != null) goto L19;
        com.bytedance.ee.bear.bitable.core.bottompanel.a r107 = this.f206870g;
        if (r107 == null) goto L13;
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r108 = r107.Yc("OfficeBaseAppFullScreen");
    L14:
        this.f206883t = r108;
        goto L19
    L13:
        r108 = null;
        goto L14
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void onConfigurationChanged(Configuration r100) {
        this.f206875l.y();
    }

    public final String b(String r100, IconInfo r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        if (r101 != null) goto L14;
        return null;
    L14:
        return mu5.b.e(MapsKt.mapOf(new Pair[]{TuplesKt.to("title", r100), TuplesKt.to("icon_info", r101)}));
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void f(boolean r100, Integer r101) {
        this.f206877n = r100;
        com.bytedance.ee.bear.bitable.app.chameleon.c r102 = this.f206880q;
        boolean r103 = r102.f206909c;
        if (r103 == true) goto L6;
        this.f206878o = r101;
    L6:
        if (r103 == false) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L16;
        if (r103 == false) goto L18;
        r102.f206911e = e(r101);
        r102.a();
        return;
    L18:
        return;
    L16:
        g(this, r100, r101, false, 4);
        return;
    L8:
        if (r102.f206910d == true) goto L11;
        r104 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void kk(FragmentActivity r100, tb5.m r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.ee.bear.bitable.infoarch.swipe.b r102 = this.f206874k;
        com.bytedance.ee.bear.bitable.infoarch.swipe.c r103 = new com.bytedance.ee.bear.bitable.infoarch.swipe.c(r100, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "interceptor");
        Activity r104 = r103.getActivity();
        if (r104 == null) goto L5;
        r102.f213686a.invoke(r104, Boolean.FALSE);
    L5:
        r102.f213687b.set(r103);
    }

    public static void g(ChameleonBaseAppUIAbility r100, boolean r101, Integer r102, boolean r103, int r104) {
        Integer r105 = null;
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        int r106 = 0;
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        r100.f206877n = r101;
        com.bytedance.ee.bear.bitable.utils.c.a r107 = r100.f206876m;
        if (r107 == null) goto L28;
        if (r102 != null) goto L22;
        r102 = r100.f206878o;
        if (r102 != null) goto L22;
        AppTheme r108 = r100.f206873j.f206955d.getValue();
        if (r108 == null) goto L20;
        String r109 = r108.getNavigationBgColor();
        if (r109 == null) goto L20;
        r105 = Integer.valueOf(ColorProtector.parseColor(r109));
    L20:
        if (r105 == null) goto L23;
        r102 = r105;
    L23:
        boolean r110 = !r100.f206877n;
        int r111 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.status_bar.reset") == true) goto L27;
        r103 = true;
    L27:
        r107.j(r106, r110, r103);
    L22:
        r106 = r102.intValue();
    L28:
        com.bytedance.ee.bear.bitable.utils.c.a r112 = r100.f206876m;
        if (r112 == null) goto L32;
        r112.f();
        return;
    }

    public ChameleonBaseAppUIAbility(ChameleonPluginHost r210, t r211, com.bytedance.ee.bear.bitable.app.chameleon.a r212, BitableAppTitleBarAdapter r213, do4.c r214, vz4.b r215, com.bytedance.ee.bear.bitable.core.bottompanel.a r216) {
        Intrinsics.checkNotNullParameter(r210, "host");
        Intrinsics.checkNotNullParameter(r211, "uiContainer");
        Intrinsics.checkNotNullParameter(r212, "viewHolder");
        Intrinsics.checkNotNullParameter(r213, "titleBar");
        this.f206864a = r210;
        this.f206865b = r211;
        this.f206866c = r212;
        this.f206867d = r213;
        this.f206868e = r214;
        this.f206869f = r215;
        this.f206870g = r216;
        this.f206871h = (DocViewModel) r210.getHostAbilityOrNull(DocViewModel.class);
        AppBarLayout r100 = r213.f218653a.getTitleBarLayout();
        this.f206872i = r100;
        o r101 = new o(r212.f206897b, new ChameleonBaseAppUIAbility$themeController$1(this));
        this.f206873j = r101;
        this.f206874k = new com.bytedance.ee.bear.bitable.infoarch.swipe.b(null);
        Context r110 = r210.getContext();
        Lifecycle r111 = r210.getLifecycleOwner().getLifecycle();
        LifecycleOwner r112 = r210.getLifecycleOwner();
        Function0<String> r113 = new ChameleonBaseAppUIAbility$drawerManager$1(this);
        ViewGroup r102 = r212.f206896a;
        this.f206875l = new BitableAppDrawerManager(r110, r111, r112, r113, new com.bytedance.ee.bear.bitable.app.g(r102, r102, r212.f206900e, r212.f206897b, r212.f206898c, r100, false), r101.f206955d);
        FragmentActivity r103 = r210.getActivity();
        if (r103 != null) goto L67;
        com.bytedance.ee.bear.bitable.utils.c.a r104 = null;
    L16:
        this.f206876m = r104;
        String r105 = "#262626";
        if (h18.f.a(this.f206864a.getContext()) == false) goto L19;
        String r106 = "#262626";
    L20:
        this.f206878o = Integer.valueOf(ColorProtector.parseColor(r106));
        FragmentActivity r107 = this.f206864a.getActivity();
        if (r107 != null) goto L69;
        com.bytedance.ee.bear.bitable.utils.c.a r108 = null;
    L34:
        this.f206880q = new com.bytedance.ee.bear.bitable.app.chameleon.c(r108, new ChameleonBaseAppUIAbility$immersiveStatusBarController$2(this));
        f r109 = new f(this);
        this.f206886w = r109;
        d r114 = new d(this);
        this.f206887x = r114;
        e r115 = new e(this);
        this.f206888y = r115;
        c r116 = new c(this);
        this.f206889z = r116;
        ViewGroup r117 = this.f206866c.f206896a;
        if (h18.f.a(this.f206864a.getContext()) == false) goto L37;
        String r118 = "#262626";
    L38:
        r117.setBackgroundColor(ColorProtector.parseColor(r118));
        ViewGroup r119 = this.f206866c.f206897b;
        if (h18.f.a(this.f206864a.getContext()) == false) goto L41;
        String r120 = "#262626";
    L42:
        r119.setBackgroundColor(ColorProtector.parseColor(r120));
        do4.c r121 = this.f206868e;
        if (r121 != null) goto L45;
    L49:
        BitableAppDrawerManager r122 = this.f206875l;
        AnonymousClass1 r123 = new AnonymousClass1(this);
        r122.getClass();
        Intrinsics.checkNotNullParameter(r123, "listener");
        r122.f206820s = r123;
        BitableAppDrawerManager r124 = this.f206875l;
        AnonymousClass2 r125 = new AnonymousClass2(this);
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "listener");
        r124.f206821t = r125;
        this.f206873j.f206955d.observe(this.f206864a.getLifecycleOwner(), r109);
        DocViewModel r126 = this.f206871h;
        if (r126 == null) goto L54;
        LiveData<String> r127 = r126.getDocName();
        if (r127 == null) goto L54;
        r127.observe(this.f206864a.getLifecycleOwner(), r114);
    L54:
        DocViewModel r128 = this.f206871h;
        if (r128 == null) goto L59;
        MutableLiveData<IconInfo> r129 = r128.getShowingIconInfo();
        if (r129 == null) goto L59;
        r129.observe(this.f206864a.getLifecycleOwner(), r115);
    L59:
        AppBarLayout r130 = this.f206872i;
        if (r130 == null) goto L62;
        r130.addOnLayoutChangeListener(r116);
    L62:
        AppBarLayout r131 = this.f206872i;
        if (r131 == null) goto L65;
        r131.post(new a(this));
    L65:
        a();
        c();
        g(this, true, null, true, 2);
        return;
    L45:
        if (h18.f.a(this.f206864a.getContext()) == true) goto L48;
        r105 = "#F8F9FA";
    L48:
        r121.B1(ColorProtector.parseColor(r105));
        goto L49
    L41:
        r120 = "#F8F9FA";
        goto L42
    L37:
        r118 = "#F8F9FA";
        goto L38
    L69:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L24
        Object r133 = Result.m9449constructorimpl(com.bytedance.ee.bear.bitable.utils.c.a(r107, this.f206864a.getFragment()));     // Catch: Throwable -> L24
    L26:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L30;
        tt5.a.e("ChameleonBaseAppUIAbility", "create immersive status bar failed", r134, false);
    L30:
        if (Result.m9455isFailureimpl(r133) == false) goto L32;
        r133 = null;
    L32:
        r108 = (com.bytedance.ee.bear.bitable.utils.c.a) r133;
    L24:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L19:
        r106 = "#F8F9FA";
        goto L20
    L67:
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L6
        Object r137 = Result.m9449constructorimpl(com.bytedance.ee.bear.bitable.utils.c.b(r103, r210.getFragment(), true));     // Catch: Throwable -> L6
    L8:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L12;
        tt5.a.e("ChameleonBaseAppUIAbility", "create status bar failed", r138, false);
    L12:
        if (Result.m9455isFailureimpl(r137) == false) goto L14;
        r137 = null;
    L14:
        r104 = (com.bytedance.ee.bear.bitable.utils.c.a) r137;
    L6:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
