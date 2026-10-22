package com.bytedance.android.window.shop.home.presenter;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.tab.WindowTabH5Fragment;
import com.bytedance.android.window.shop.home.tab.WindowTabHybridFragment;
import com.bytedance.android.window.shop.home.tab.WindowTabLynxFragment;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowMemberShopPointPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowReceiveExitJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowShowPopupPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowTabsSelectionJSbPluginExp;
import com.bytedance.android.window.shop.home.tabcard.HybridTabCardFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowCategoryConfigDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import com.bytedance.android.window.shop.widget.ECWindowTabLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0007\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowHybridSubTabsPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/j;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "<init>", "()V", "SaasTabAdapter", "TabAdapter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowHybridSubTabsPresenter extends j implements LifecycleObserver {
    public static final /* synthetic */ int s = 0;
    public final Lazy m;
    public final Map<String, String> n;
    public final Map<String, String> o;
    public List<com.bytedance.android.window.shop.repository.dto.p> p;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f q;
    public final cr3.b r;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowHybridSubTabsPresenter$SaasTabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SaasTabAdapter extends FragmentPagerAdapter {
        public final List<com.bytedance.android.window.shop.repository.dto.p> a;
        public final List<CharSequence> b;
        public final Function1<String, Long> c;
        public final boolean d;
        public final /* synthetic */ ECWindowHybridSubTabsPresenter e;

        public final int getCount() {
            return this.a.size();
        }

        public final Fragment getItem(int r9) {
            com.bytedance.android.window.shop.repository.dto.p r0 = (com.bytedance.android.window.shop.repository.dto.p) ListProtector.get(this.a, r9);
            ECWindowHybridSubTabsPresenter r1 = this.e;
            WindowCategoryConfigDTO r2 = r0.a();
            if (r2 == null) goto L5;
            Integer r3 = r2.a();
        L6:
            Function1<String, Long> r4 = this.c;
            String r5 = r0.b();
            Object r6 = "";
            if (r5 != null) goto L9;
            r5 = "";
        L9:
            long r7 = ((Number) r4.invoke(r5)).longValue();
            String r8 = r0.b();
            if (r8 != null) goto L12;
            r8 = "";
        L12:
            List<CharSequence> r10 = this.b;
            if (r9 >= 0) goto L15;
        L17:
            String r11 = r8;
            return ECWindowHybridSubTabsPresenter.a0(r1, r3, r7, r11, r6.toString(), this.d);
        L15:
            if (r9 > CollectionsKt.getLastIndex(r10)) goto L17;
            r6 = ListProtector.get(r10, r9);
            goto L17
        L5:
            r3 = null;
            goto L6
        }

        public final CharSequence getPageTitle(int r2) {
            return (CharSequence) ListProtector.get(this.b, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SaasTabAdapter(ECWindowHybridSubTabsPresenter r2, List<com.bytedance.android.window.shop.repository.dto.p> r3, List<? extends CharSequence> r4, FragmentManager r5, Function1<? super String, Long> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r3, "categories");
            Intrinsics.checkNotNullParameter(r4, "tabNames");
            Intrinsics.checkNotNullParameter(r5, "fragmentMgr");
            Intrinsics.checkNotNullParameter(r6, "lifecycleMonitorIdGenerator");
            this.e = r2;
            super(r5);
            this.a = r3;
            this.b = r4;
            this.c = r6;
            this.d = r7;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowHybridSubTabsPresenter$TabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class TabAdapter extends FragmentPagerAdapter {
        public final List<com.bytedance.android.window.shop.repository.dto.p> a;
        public final List<CharSequence> b;
        public final Function1<String, Long> c;
        public final boolean d;
        public final /* synthetic */ ECWindowHybridSubTabsPresenter e;

        public final int getCount() {
            return this.a.size();
        }

        public final Fragment getItem(int r11) {
            com.bytedance.android.window.shop.repository.dto.p r0 = (com.bytedance.android.window.shop.repository.dto.p) ListProtector.get(this.a, r11);
            String r1 = r0.b();
            Object r2 = "";
            if (r1 != null) goto L5;
            String r7 = "";
        L6:
            long r5 = ((Number) this.c.invoke(r7)).longValue();
            com.bytedance.android.window.shop.lifecycle.f r3 = com.bytedance.android.window.shop.lifecycle.c.a(r5);
            if (r3 == null) goto L9;
            r3.k();
        L9:
            ECWindowHybridSubTabsPresenter r4 = this.e;
            WindowCategoryConfigDTO r6 = r0.a();
            if (r6 == null) goto L12;
            Integer r8 = r6.a();
        L13:
            Integer r9 = r8;
            List<CharSequence> r10 = this.b;
            if (r11 < 0) goto L19;
            if (r11 > CollectionsKt.getLastIndex(r10)) goto L19;
            r2 = ListProtector.get(r10, r11);
        L19:
            return ECWindowHybridSubTabsPresenter.a0(r4, r9, r5, r7, r2.toString(), this.d);
        L12:
            r8 = null;
            goto L13
        L5:
            r7 = r1;
            goto L6
        }

        public final long getItemId(int r7) {
            zq3.e r0 = zq3.e.b;
            String r8 = ((com.bytedance.android.window.shop.repository.dto.p) ListProtector.get(this.a, r7)).b();
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            monitor-enter(r0);
            Intrinsics.checkNotNullParameter(r8, "id");     // Catch: Throwable -> L13
            Map<String, Long> r1 = zq3.e.a;     // Catch: Throwable -> L13
            Long r2 = (Long) ((LinkedHashMap) r1).get(r8);     // Catch: Throwable -> L13
            if (r2 == null) goto L9;
            long r3 = r2.longValue();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r0);
            return r3;
        L9:
            long r4 = ((long) r1.size()) + 1;     // Catch: Throwable -> L13
            r1.put(r8, Long.valueOf(r4));     // Catch: Throwable -> L13
            r3 = r4;
        L13:
            th = move-exception;
            throw th;
        }

        public final CharSequence getPageTitle(int r2) {
            return (CharSequence) ListProtector.get(this.b, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TabAdapter(ECWindowHybridSubTabsPresenter r2, List<com.bytedance.android.window.shop.repository.dto.p> r3, List<? extends CharSequence> r4, FragmentManager r5, Function1<? super String, Long> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r3, "categories");
            Intrinsics.checkNotNullParameter(r4, "tabNames");
            Intrinsics.checkNotNullParameter(r5, "fragmentMgr");
            Intrinsics.checkNotNullParameter(r6, "lifecycleMonitorIdGenerator");
            this.e = r2;
            super(r5, 1);
            this.a = r3;
            this.b = r4;
            this.c = r6;
            this.d = r7;
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowHybridSubTabsPresenter a;

        public a(ECWindowHybridSubTabsPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            WindowHybridTabDataListResponseDTO r11 = (WindowHybridTabDataListResponseDTO) r10;
            this.a.O().runLowPriorityTask(new ECWindowHybridSubTabsPresenter$onBind$1$1(this));
            this.a.p = r11.categories();
            this.a.O().getHeaderSubTabsParam().e.setValue(Unit.INSTANCE);
            ECWindowHybridSubTabsPresenter r0 = this.a;
            r0.getClass();
            HybridTabCardFragment r1 = new HybridTabCardFragment();
            ECWindowDialogFragment r2 = ECQuickUtilKt.b(r0.u(), ECWindowDialogFragment.class);
            FragmentActivity r3 = null;
            if (r2 == null) goto L6;
            FragmentManager r4 = r2.getChildFragmentManager();
            if (r4 == null) goto L6;
        L12:
            FragmentTransaction r5 = r4.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131371271) == true) goto L16;
            r5 = r5.replace(2131371271, r1);
        L16:
            r5.commitAllowingStateLoss();
            ECWindowHybridSubTabsPresenter r6 = this.a;
            r6.getClass();
            r6.f0(r11.categories(), r11.getTargetSelectCategoryId(), false);
            ECWindowHybridSubTabsPresenter r7 = this.a;
            r7.getClass();
            List<com.bytedance.android.window.shop.repository.dto.p> r12 = r11.categories();
            if (r12 == null) goto L19;
            int r13 = r12.size();
        L21:
            if (r13 > 1) goto L23;
            r7.O().getTabBarHeight().setValue(0);
            r7.e0().setVisibility(8);
        L25:
            if (((Boolean) WindowConstDef.i.getValue()).booleanValue() == false) goto L28;
            int r14 = com.bytedance.android.shopping.extensions.b.b(30);
            float r8 = r14 * 0.123222746f;
            r7.e0().setSelectedTabIndicator(new cr3.c(r14, r8, com.bytedance.android.ec.core.utils.q.a(6), new ECWindowHybridSubTabsPresenter$initTab$indicator$1(r7)));
            r7.e0().setSelectedTabIndicatorHeight((int) r8);
        L28:
            if (this.a.O().getShopParam().isCroppedStyle() == true) goto L36;
            com.bytedance.android.window.shop.home.tab.tabplugin.f r15 = this.a.q;
            com.bytedance.android.window.shop.home.tab.tabplugin.e[] r9 = new com.bytedance.android.window.shop.home.tab.tabplugin.e[1];
            String r16 = this.a.O().getShopParam().getSecAuthorId();
            QContext r17 = this.a.u();
            FragmentActivity r18 = com.bytedance.android.ec.core.utils.l0.c(r17.c());
            if ((r18 instanceof FragmentActivity) == false) goto L33;
            r3 = r18;
        L33:
            if (r3 != null) goto L35;
            r3 = r17.a();
        L35:
            r9[0] = new ECWindowReceiveExitJsbPlugin(r16, r3);
            r15.a(r9);
        L36:
            com.bytedance.android.window.shop.home.tab.tabplugin.f r19 = this.a.q;
            com.bytedance.android.window.shop.home.tab.tabplugin.e[] r20 = new com.bytedance.android.window.shop.home.tab.tabplugin.e[4];
            r20[0] = new WindowMemberShopPointPlugin(this.a.u().c(), this.a.O());
            r20[1] = new com.bytedance.android.window.shop.home.presenter.plugin.eventcard.a(this.a.u().c(), this.a.U(), this.a.O());
            ECWindowViewModel r21 = this.a.O();
            ECWindowHybridSubTabsPresenter$onBind$1$2 r22 = new ECWindowHybridSubTabsPresenter$onBind$1$2(this.a);
            ECWindowHybridSubTabsPresenter r23 = this.a;
            zn.b<WindowHybridTabDataListResponseDTO> r24 = r23.O().getHeaderSubTabsParam().d;
            ECWindowHybridSubTabsPresenter$onBind$1$3 r25 = ECWindowHybridSubTabsPresenter$onBind$1$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r24, "source");
            Intrinsics.checkNotNullParameter(r25, "transformer");
            r20[2] = new ECWindowTabsSelectionJSbPluginExp(r21, r22, new AbsECWindowPresenter$observableSourceFromLiveData$2(r23, r24, r25));
            String r26 = this.a.O().getShopParam().getSecAuthorId();
            View r27 = this.a.y();
            if (r27 == null) goto L41;
            r20[3] = new ECWindowShowPopupPlugin(r26, (ViewGroup) r27, this.a.U());
            r19.a(r20);
            return;
        L41:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L23:
            r7.e0().setVisibility(0);
            goto L25
        L19:
            r13 = 0;
        L6:
            QContext r28 = r0.u();
            FragmentActivity r29 = com.bytedance.android.ec.core.utils.l0.c(r28.c());
            if ((r29 instanceof FragmentActivity) == true) goto L9;
            r29 = null;
        L9:
            if (r29 != null) goto L11;
            r29 = r28.a();
        L11:
            r4 = r29.getSupportFragmentManager();
            goto L12
        }
    }

    public final ECWindowTabLayout e0() {
        return (ECWindowTabLayout) this.m.getValue();
    }

    public final void C() {
        this.q.b();
        if (O().getShopParam().getTargetLayoutType() != null) goto L11;
        ap3.i r0 = ap3.i.a;
        String r1 = com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId();
        String r2 = O().getShopParam().getSecAuthorId();
        WindowLayoutType r3 = O().getHeaderSubTabsParam().b;
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.getType());
    L9:
        com.bytedance.android.ec.core.async.a.a(ap3.i.a(new io.d(r1, r2, r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d1.a, e1.a), O());
        return;
    L8:
        r4 = null;
        goto L9
    }

    public ECWindowHybridSubTabsPresenter() {
        this.m = LazyKt.lazy(new ECWindowHybridSubTabsPresenter$tabLayout$2(this));
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.q = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        Float r4 = Float.valueOf(0.0f);
        this.r = new cr3.b(r4, r4, r4, 0, 0, 0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        O().setTabDuration(SystemClock.elapsedRealtime());
        BtmSDK r0 = BtmSDK.INSTANCE;
        PageFinder r1 = PageFinder.via(y());
        BcmParams.a r2 = BcmParams.Companion;
        Map r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_location", O().getShopParam().getEntranceLocation()), TuplesKt.to("author_id", O().getShopParam().getAuthorId())});
        r2.getClass();
        r0.setBcmPageParams(r1, BcmParams.a.c(r3), false);
    }

    public final void A(QModel r5) {
        U().getLifecycle().addObserver(this);
        fo.a<WindowLayoutType> r6 = WindowConstDef.a;
        if (((Boolean) WindowConstDef.o.getValue()).booleanValue() == false) goto L8;
        String r7 = com.bytedance.android.ec.core.utils.a2.c(O().getShopParam().getTargetCategory());
        if (r7 != null) goto L7;
        r7 = "-1";
    L7:
        e0().setVisibility(4);
        f0(CollectionsKt.listOf(new com.bytedance.android.window.shop.repository.dto.p("", r7, 2044)), null, true);
    L8:
        O().getHeaderSubTabsParam().d.a(U(), new a(this), true);
        O().getParamProvider().b("current_category_id", new ECWindowHybridSubTabsPresenter$addWindowEventCardBaseParam$1(this));
        O().getParamProvider().b("follow_status", new ECWindowHybridSubTabsPresenter$addWindowEventCardBaseParam$2(this));
    }

    public final Integer d0(String r4) {
        List<com.bytedance.android.window.shop.repository.dto.p> r0 = this.p;
        if (r0 == null) goto L13;
        Iterator<com.bytedance.android.window.shop.repository.dto.p> r1 = r0.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r1.next().b(), r4) == true) goto L17;
        r2 = r2 + 1;
    L17:
        return Integer.valueOf(r2);
    L11:
        r2 = -1;
        goto L17
    L13:
        return null;
    }

    public static final String c0(ECWindowHybridSubTabsPresenter r0, ECTabLayout.Tab r1) {
        if (r1 != null) goto L4;
        r0.getClass();
        return null;
    L4:
        Map<String, String> r2 = r0.n;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        return (String) r3.get(String.valueOf(r1.getText()));
    }

    public static final long b0(ECWindowHybridSubTabsPresenter r2, String r3, String r4) {
        r2.getClass();
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        r2.O().isCroppedStyle();
        return com.bytedance.android.window.shop.lifecycle.c.b(r2.O().getShopParam().getLifecycleMonitorId(), Intrinsics.areEqual(r3, r4));
    }

    public final void f0(List<com.bytedance.android.window.shop.repository.dto.p> r17, final String r18, boolean r19) {
        List<com.bytedance.android.window.shop.repository.dto.p> r0 = r17;
        boolean r9 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        List<com.bytedance.android.window.shop.repository.dto.p> r2 = CollectionsKt.listOf(new com.bytedance.android.window.shop.repository.dto.p("全部商品", "-1", 2044));
    L12:
        List<com.bytedance.android.window.shop.repository.dto.p> r3 = r2;
        ArrayList r11 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (((com.bytedance.android.window.shop.repository.dto.p) r5).b() == null) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L14;
        r11.add(r5);
        goto L14
    L18:
        r6 = false;
        goto L19
    L21:
        ArrayList r12 = new ArrayList();
        Iterator r7 = r11.iterator();
    L23:
        if (r7.hasNext() == false) goto L27;
        String r8 = ((com.bytedance.android.window.shop.repository.dto.p) r7.next()).b();
        if (r8 == null) goto L23;
        r12.add(r8);
        goto L23
    L27:
        ArrayList r10 = new ArrayList();
        Iterator<T> r13 = r3.iterator();
    L29:
        if (r13.hasNext() == false) goto L36;
        Object r14 = r13.next();
        if (((com.bytedance.android.window.shop.repository.dto.p) r14).c() == null) goto L33;
        boolean r15 = true;
    L34:
        if (r15 == false) goto L29;
        r10.add(r14);
        goto L29
    L33:
        r15 = false;
        goto L34
    L36:
        ArrayList r16 = new ArrayList();
        Iterator r20 = r10.iterator();
    L38:
        if (r20.hasNext() == false) goto L42;
        String r21 = ((com.bytedance.android.window.shop.repository.dto.p) r20.next()).c();
        if (r21 == null) goto L38;
        r16.add(r21);
        goto L38
    L42:
        Iterator r22 = r12.iterator();
        int r23 = 0;
    L44:
        if (r22.hasNext() == false) goto L52;
        Object r24 = r22.next();
        int r25 = r23 + 1;
        if (r23 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        String r26 = (String) r24;
        if (r23 >= r16.size()) goto L50;
        this.n.put((String) ListProtector.get(r16, r23), r26);
        r23 = r25;
        goto L44
    L50:
        return;
    L52:
        Iterator<T> r27 = r3.iterator();
        int r28 = 0;
    L54:
        if (r27.hasNext() == false) goto L62;
        Object r29 = r27.next();
        int r30 = r28 + 1;
        if (r28 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        com.bytedance.android.window.shop.repository.dto.p r31 = (com.bytedance.android.window.shop.repository.dto.p) r29;
        if (r31.g() == null) goto L61;
        this.o.put(r31.c(), r31.g());
    L61:
        r28 = r30;
        goto L54
    L62:
        ViewPager r110 = (ViewPager) y().findViewById(2131370962);
        ECWindowDialogFragment r32 = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        Integer r111 = null;
        if (r32 == null) goto L68;
        FragmentManager r33 = r32.getChildFragmentManager();
        if (r33 == null) goto L68;
    L67:
        FragmentManager r34 = r33;
        if (r34.isDestroyed() == true) goto L85;
        Lazy r35 = ECAppInfoService.a;
        if (we.a.a == false) goto L80;
        r110.setAdapter(new SaasTabAdapter(this, r11, r16, r34, new ECWindowHybridSubTabsPresenter$bindAdapter$1(this, r18), r19));
    L81:
        e0().setupWithViewPager(r110);
        e0().populateFromPagerAdapter();
        int r36 = com.bytedance.android.window.shop.repository.tab.entity.x.l;
        com.bytedance.android.window.shop.repository.tab.entity.x r37 = com.bytedance.android.window.shop.repository.tab.entity.x.a.a(r11, r18);
        if (r37 == null) goto L85;
        e0().b(r37);
        goto L85
    L80:
        r110.setAdapter(new TabAdapter(this, r11, r16, r34, new ECWindowHybridSubTabsPresenter$bindAdapter$2(this, r18), r19));
    L85:
        if (r19 == true) goto L125;
        e0().addOnTabSelectedListener(new b1(this));
        e0().addOnTabSelectedListener(new c1(this));
        Iterator r38 = r12.iterator();
        int r39 = 0;
    L88:
        if (r38.hasNext() == false) goto L93;
        if (Intrinsics.areEqual(r18, (String) r38.next()) == true) goto L94;
        r39 = r39 + 1;
    L94:
        Integer r40 = Integer.valueOf(r39);
        if (r40.intValue() >= 0) goto L98;
        r9 = false;
    L98:
        if (r9 == false) goto L100;
        r111 = r40;
    L100:
        if (r111 != null) goto L103;
    L104:
        if (r111 == null) goto L113;
        ECTabLayout.Tab r41 = e0().getTabAt(r111.intValue());
        if (r41 == null) goto L113;
        ECTabLayout.TabView r42 = r41.view;
        if (r42 == null) goto L112;
        r42.setTag(ClickSeparatedTabSelectListener.ActionType.NONE);
        r41.select();
        goto L113
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L113:
        if (r111 != null) goto L115;
        String r43 = (String) CollectionsKt.firstOrNull(r12);
    L116:
        String r44 = r43;
        if (r44 != null) goto L119;
    L121:
        Iterator r45 = r12.iterator();
    L123:
        if (r45.hasNext() == false) goto L154;
        String r46 = (String) r45.next();
        int r47 = WindowTabEventReporter.a;
        WindowTabEventReporter.g(y(), O(), O().getShopParam(), r46, d0(r46));
        goto L123
    L154:
        return;
    L119:
        if (Intrinsics.areEqual(r44, (String) CollectionsKt.firstOrNull(r12)) == false) goto L121;
        int r48 = WindowTabEventReporter.a;
        WindowTabEventReporter.e(y(), O(), O().getShopParam(), r44, d0(r44), null);
        goto L121
    L115:
        r43 = (String) CollectionsKt.getOrNull(r12, r111.intValue());
        goto L116
    L103:
        if (r111.intValue() == 0) goto L113;
    L93:
        r39 = -1;
        goto L94
    L125:
        return;
    L68:
        QContext r49 = u();
        FragmentActivity r50 = com.bytedance.android.ec.core.utils.l0.c(r49.c());
        if ((r50 instanceof FragmentActivity) == true) goto L71;
        r50 = null;
    L71:
        if (r50 != null) goto L73;
        r50 = r49.a();
    L73:
        r33 = r50.getSupportFragmentManager();
        goto L67
    L11:
        r2 = r17;
        goto L12
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final Fragment a0(ECWindowHybridSubTabsPresenter r5, Integer r6, long r7, String r9, String r10, boolean r11) {
        r5.getClass();
        if (r6 == null) goto L9;
        if (r6.intValue() != 1) goto L9;
        int r8 = WindowTabLynxFragment.f;
        return WindowTabLynxFragment.a.a(r9, r10, r7);
    L9:
        if (r6 != null) goto L12;
    L15:
        int r12 = WindowTabHybridFragment.g;
        Intrinsics.checkNotNullParameter(r9, "categoryId");
        Intrinsics.checkNotNullParameter(r10, "categoryName");
        com.bytedance.android.window.shop.lifecycle.f r13 = com.bytedance.android.window.shop.lifecycle.c.a(r7);
        if (r13 == null) goto L18;
        r13.k();
    L18:
        WindowTabHybridFragment r14 = new WindowTabHybridFragment();
        Bundle r2 = new Bundle();
        r2.putString("window_tab_category_id", r9);
        r2.putString("window_tab_category_name", r10);
        r2.putLong("lifecycleMonitorId", r7);
        Unit r15 = Unit.INSTANCE;
        r14.setArguments(r2);
        r14.d = r11;
        Fragment r16 = r14;
    L20:
        return r16;
    L12:
        if (r6.intValue() != 2) goto L15;
        int r17 = WindowTabH5Fragment.g;
        Intrinsics.checkNotNullParameter(r9, "categoryId");
        Intrinsics.checkNotNullParameter(r10, "categoryName");
        WindowTabH5Fragment r18 = new WindowTabH5Fragment();
        Bundle r19 = new Bundle();
        r19.putString("window_tab_category_id", r9);
        r19.putString("window_tab_category_name", r10);
        r19.putLong("lifecycleMonitorId", r7);
        Unit r20 = Unit.INSTANCE;
        r18.setArguments(r19);
        r16 = r18;
        goto L20
    }
}
