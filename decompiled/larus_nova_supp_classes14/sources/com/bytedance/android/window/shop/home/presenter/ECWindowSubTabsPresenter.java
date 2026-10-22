package com.bytedance.android.window.shop.home.presenter;

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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.tab.WindowTabFragmentBase;
import com.bytedance.android.window.shop.home.tab.WindowTabLynxFragment;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowMemberShopPointPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowReceiveExitJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowShowPopupPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.subtabs.ECWindowTabsSelectionJSbPluginExp;
import com.bytedance.android.window.shop.home.tabcard.TabCardFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowCategoryConfigDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import com.bytedance.android.window.shop.widget.ECWindowTabLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
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
import java.util.concurrent.CopyOnWriteArrayList;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowSubTabsPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/j;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onStop", "<init>", "()V", "SaasTabAdapter", "TabAdapter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSubTabsPresenter extends j implements LifecycleObserver {
    public static final /* synthetic */ int r = 0;
    public final Lazy m;
    public final Map<String, String> n;
    public final Map<String, String> o;
    public List<com.bytedance.android.window.shop.repository.dto.p> p;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f q;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowSubTabsPresenter$SaasTabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SaasTabAdapter extends FragmentPagerAdapter {
        public final List<com.bytedance.android.window.shop.repository.dto.p> a;
        public final List<CharSequence> b;
        public final Function1<String, Long> c;

        public final int getCount() {
            return this.a.size();
        }

        public final Fragment getItem(int r6) {
            com.bytedance.android.window.shop.repository.dto.p r0 = (com.bytedance.android.window.shop.repository.dto.p) ListProtector.get(this.a, r6);
            WindowCategoryConfigDTO r1 = r0.a();
            if (r1 == null) goto L5;
            Integer r2 = r1.a();
        L6:
            String r3 = "";
            if (r2 != null) goto L10;
        L26:
            CopyOnWriteArrayList<WindowTabFragmentBase> r4 = com.bytedance.android.window.shop.home.tab.h.a;
            String r5 = r0.b();
            if (r5 != null) goto L29;
            r5 = "";
        L29:
            List<CharSequence> r7 = this.b;
            if (r6 >= 0) goto L32;
        L34:
            Object r8 = "";
        L35:
            String r9 = r8.toString();
            Function1<String, Long> r10 = this.c;
            String r11 = r0.b();
            if (r11 == null) goto L40;
            r3 = r11;
        L40:
            return com.bytedance.android.window.shop.home.tab.h.a(r5, r9, ((Number) r10.invoke(r3)).longValue());
        L32:
            if (r6 > CollectionsKt.getLastIndex(r7)) goto L34;
            r8 = ListProtector.get(r7, r6);
            goto L35
        L10:
            if (r2.intValue() != 1) goto L26;
            int r12 = WindowTabLynxFragment.f;
            String r13 = r0.b();
            if (r13 != null) goto L14;
            r13 = "";
        L14:
            List<CharSequence> r14 = this.b;
            if (r6 >= 0) goto L17;
        L19:
            Object r15 = "";
        L20:
            String r16 = r15.toString();
            Function1<String, Long> r17 = this.c;
            String r18 = r0.b();
            if (r18 == null) goto L25;
            r3 = r18;
        L25:
            return WindowTabLynxFragment.a.a(r13, r16, ((Number) r17.invoke(r3)).longValue());
        L17:
            if (r6 > CollectionsKt.getLastIndex(r14)) goto L19;
            r15 = ListProtector.get(r14, r6);
            goto L20
        L5:
            r2 = null;
            goto L6
        }

        public final CharSequence getPageTitle(int r2) {
            return (CharSequence) ListProtector.get(this.b, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SaasTabAdapter(List<com.bytedance.android.window.shop.repository.dto.p> r2, List<? extends CharSequence> r3, FragmentManager r4, Function1<? super String, Long> r5) {
            Intrinsics.checkNotNullParameter(r2, "categories");
            Intrinsics.checkNotNullParameter(r3, "tabNames");
            Intrinsics.checkNotNullParameter(r4, "fragmentMgr");
            Intrinsics.checkNotNullParameter(r5, "lifecycleMonitorIdGenerator");
            super(r4);
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowSubTabsPresenter$TabAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabAdapter extends FragmentPagerAdapter {
        public final List<com.bytedance.android.window.shop.repository.dto.p> a;
        public final List<CharSequence> b;
        public final Function1<String, Long> c;

        public final int getCount() {
            return this.a.size();
        }

        public final Fragment getItem(int r6) {
            com.bytedance.android.window.shop.repository.dto.p r0 = (com.bytedance.android.window.shop.repository.dto.p) ListProtector.get(this.a, r6);
            WindowCategoryConfigDTO r1 = r0.a();
            if (r1 == null) goto L5;
            Integer r2 = r1.a();
        L6:
            String r3 = "";
            if (r2 != null) goto L10;
        L26:
            CopyOnWriteArrayList<WindowTabFragmentBase> r4 = com.bytedance.android.window.shop.home.tab.h.a;
            String r5 = r0.b();
            if (r5 != null) goto L29;
            r5 = "";
        L29:
            List<CharSequence> r7 = this.b;
            if (r6 >= 0) goto L32;
        L34:
            Object r8 = "";
        L35:
            String r9 = r8.toString();
            Function1<String, Long> r10 = this.c;
            String r11 = r0.b();
            if (r11 == null) goto L40;
            r3 = r11;
        L40:
            return com.bytedance.android.window.shop.home.tab.h.a(r5, r9, ((Number) r10.invoke(r3)).longValue());
        L32:
            if (r6 > CollectionsKt.getLastIndex(r7)) goto L34;
            r8 = ListProtector.get(r7, r6);
            goto L35
        L10:
            if (r2.intValue() != 1) goto L26;
            int r12 = WindowTabLynxFragment.f;
            String r13 = r0.b();
            if (r13 != null) goto L14;
            r13 = "";
        L14:
            List<CharSequence> r14 = this.b;
            if (r6 >= 0) goto L17;
        L19:
            Object r15 = "";
        L20:
            String r16 = r15.toString();
            Function1<String, Long> r17 = this.c;
            String r18 = r0.b();
            if (r18 == null) goto L25;
            r3 = r18;
        L25:
            return WindowTabLynxFragment.a.a(r13, r16, ((Number) r17.invoke(r3)).longValue());
        L17:
            if (r6 > CollectionsKt.getLastIndex(r14)) goto L19;
            r15 = ListProtector.get(r14, r6);
            goto L20
        L5:
            r2 = null;
            goto L6
        }

        public final CharSequence getPageTitle(int r2) {
            return (CharSequence) ListProtector.get(this.b, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TabAdapter(List<com.bytedance.android.window.shop.repository.dto.p> r2, List<? extends CharSequence> r3, FragmentManager r4, Function1<? super String, Long> r5) {
            Intrinsics.checkNotNullParameter(r2, "categories");
            Intrinsics.checkNotNullParameter(r3, "tabNames");
            Intrinsics.checkNotNullParameter(r4, "fragmentMgr");
            Intrinsics.checkNotNullParameter(r5, "lifecycleMonitorIdGenerator");
            super(r4, 1);
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowSubTabsPresenter a;

        public a(ECWindowSubTabsPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            final WindowTabDataListResponseDTODeprecated r16 = (WindowTabDataListResponseDTODeprecated) r15;
            this.a.O().runLowPriorityTask(new ECWindowSubTabsPresenter$onBind$1$1(this));
            this.a.p = r16.categories();
            this.a.O().getHeaderSubTabsParam().e.setValue(Unit.INSTANCE);
            ECWindowSubTabsPresenter r0 = this.a;
            r0.getClass();
            TabCardFragment r1 = new TabCardFragment();
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
            final ECWindowSubTabsPresenter r6 = this.a;
            r6.getClass();
            if (r16.categories().isEmpty() == true) goto L127;
            List<com.bytedance.android.window.shop.repository.dto.p> r7 = r16.categories();
            if ((!r7.isEmpty()) == true) goto L23;
            r7 = null;
        L23:
            if (r7 == null) goto L127;
            int r8 = com.bytedance.android.window.shop.repository.tab.entity.x.l;
            com.bytedance.android.window.shop.repository.tab.entity.x r9 = com.bytedance.android.window.shop.repository.tab.entity.x.a.a(r16.categories(), r16.getSelectCategoryId());
            if (r9 == null) goto L127;
            ((LinkedHashMap) r6.n).clear();
            List<com.bytedance.android.window.shop.repository.dto.p> r10 = r16.categories();
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L30:
            if (r12.hasNext() == false) goto L41;
            T r13 = r12.next();
            com.bytedance.android.window.shop.repository.dto.p r14 = (com.bytedance.android.window.shop.repository.dto.p) r13;
            if (r14.b() == null) goto L38;
            String r17 = r14.c();
            if (r17 == null) goto L38;
            if ((!StringsKt.isBlank(r17)) != true) goto L38;
            boolean r18 = true;
        L39:
            if (r18 == false) goto L30;
            r11.add(r13);
        L38:
            r18 = false;
            goto L39
        L41:
            ArrayList r19 = new ArrayList();
            Iterator r20 = r11.iterator();
        L43:
            if (r20.hasNext() == false) goto L47;
            String r21 = ((com.bytedance.android.window.shop.repository.dto.p) r20.next()).b();
            if (r21 == null) goto L43;
            r19.add(r21);
            goto L43
        L47:
            ArrayList r22 = new ArrayList();
            Iterator r23 = r11.iterator();
        L49:
            if (r23.hasNext() == false) goto L53;
            String r24 = ((com.bytedance.android.window.shop.repository.dto.p) r23.next()).c();
            if (r24 == null) goto L49;
            r22.add(r24);
            goto L49
        L53:
            Iterator r25 = r19.iterator();
            int r26 = 0;
        L55:
            if (r25.hasNext() == false) goto L63;
            Object r110 = r25.next();
            int r111 = r26 + 1;
            if (r26 >= 0) goto L59;
            CollectionsKt.throwIndexOverflow();
        L59:
            String r112 = (String) r110;
            if (r26 >= r22.size()) goto L127;
            r6.n.put((String) ListProtector.get(r22, r26), r112);
            r26 = r111;
            goto L55
        L63:
            Iterator<T> r27 = r16.categories().iterator();
            int r28 = 0;
        L65:
            if (r27.hasNext() == false) goto L73;
            T r113 = r27.next();
            int r114 = r28 + 1;
            if (r28 >= 0) goto L69;
            CollectionsKt.throwIndexOverflow();
        L69:
            com.bytedance.android.window.shop.repository.dto.p r115 = (com.bytedance.android.window.shop.repository.dto.p) r113;
            if (r115.g() == null) goto L72;
            r6.o.put(r115.c(), r115.g());
        L72:
            r28 = r114;
            goto L65
        L73:
            Iterator r29 = r19.iterator();
            Integer r116 = null;
            int r30 = 0;
        L75:
            if (r29.hasNext() == false) goto L83;
            Object r117 = r29.next();
            int r118 = r30 + 1;
            if (r30 >= 0) goto L80;
            CollectionsKt.throwIndexOverflow();
        L80:
            if (Intrinsics.areEqual((String) r117, r16.getSelectCategoryId()) == false) goto L82;
            r116 = Integer.valueOf(r30);
        L82:
            r30 = r118;
            goto L75
        L83:
            ViewPager r31 = (ViewPager) r6.y().findViewById(2131370962);
            ECWindowDialogFragment r32 = ECQuickUtilKt.b(r6.u(), ECWindowDialogFragment.class);
            if (r32 == null) goto L87;
            FragmentManager r33 = r32.getChildFragmentManager();
            if (r33 == null) goto L87;
        L93:
            Function1<String, Long> r119 = new ECWindowSubTabsPresenter$initTabContent$generator$1(r6, r16);
            Lazy r120 = ECAppInfoService.a;
            if (we.a.a == true) goto L148;
            r31.setAdapter(new TabAdapter(r11, r22, r33, r119));
        L101:
            r6.c0().setupWithViewPager(r31);
            r6.c0().populateFromPagerAdapter();
            r6.c0().b(r9);
            r6.c0().addOnTabSelectedListener(new y1(r6));
            r6.c0().addOnTabSelectedListener(new z1(r6));
            if (r116 != null) goto L105;
        L106:
            if (r116 == null) goto L115;
            ECTabLayout.Tab r34 = r6.c0().getTabAt(r116.intValue());
            if (r34 == null) goto L115;
            ECTabLayout.TabView r35 = r34.view;
            if (r35 == null) goto L114;
            r35.setTag(ClickSeparatedTabSelectListener.ActionType.NONE);
            r34.select();
            goto L115
        L114:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L115:
            if (r116 != null) goto L117;
            String r36 = (String) CollectionsKt.firstOrNull(r19);
        L118:
            String r37 = r36;
            if (r37 != null) goto L121;
        L123:
            Iterator r38 = r19.iterator();
        L125:
            if (r38.hasNext() == false) goto L127;
            String r39 = (String) r38.next();
            int r40 = WindowTabEventReporter.a;
            WindowTabEventReporter.g(r6.y(), r6.O(), r6.O().getShopParam(), r39, r6.b0(r39));
            goto L125
        L121:
            if (Intrinsics.areEqual(r37, (String) CollectionsKt.firstOrNull(r19)) == false) goto L123;
            int r41 = WindowTabEventReporter.a;
            WindowTabEventReporter.e(r6.y(), r6.O(), r6.O().getShopParam(), r37, r6.b0(r37), null);
            goto L123
        L117:
            r36 = (String) CollectionsKt.getOrNull(r19, r116.intValue());
            goto L118
        L105:
            if (r116.intValue() == 0) goto L115;
        L148:
            PagerAdapter r121 = new TabAdapter(r11, r22, r33, r119);     // Catch: Throwable -> L97
        L99:
            r31.setAdapter(r121);
        L97:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th);
            r121 = new SaasTabAdapter(r11, r22, r33, r119);
        L87:
            QContext r42 = r6.u();
            FragmentActivity r122 = com.bytedance.android.ec.core.utils.l0.c(r42.c());
            if ((r122 instanceof FragmentActivity) == true) goto L90;
            r122 = null;
        L90:
            if (r122 != null) goto L92;
            r122 = r42.a();
        L92:
            r33 = r122.getSupportFragmentManager();
        L127:
            ECWindowSubTabsPresenter r43 = this.a;
            r43.getClass();
            List<com.bytedance.android.window.shop.repository.dto.p> r123 = r16.categories();
            if (r123 == null) goto L130;
            int r124 = r123.size();
        L131:
            if (r124 > 1) goto L134;
            r43.O().getTabBarHeight().setValue(0);
            r43.c0().setVisibility(8);
        L134:
            if (this.a.O().getShopParam().isCroppedStyle() == true) goto L142;
            com.bytedance.android.window.shop.home.tab.tabplugin.f r125 = this.a.q;
            com.bytedance.android.window.shop.home.tab.tabplugin.e[] r44 = new com.bytedance.android.window.shop.home.tab.tabplugin.e[1];
            String r45 = this.a.O().getShopParam().getSecAuthorId();
            QContext r46 = this.a.u();
            FragmentActivity r47 = com.bytedance.android.ec.core.utils.l0.c(r46.c());
            if ((r47 instanceof FragmentActivity) == false) goto L139;
            r3 = r47;
        L139:
            if (r3 != null) goto L141;
            r3 = r46.a();
        L141:
            r44[0] = new ECWindowReceiveExitJsbPlugin(r45, r3);
            r125.a(r44);
        L142:
            com.bytedance.android.window.shop.home.tab.tabplugin.f r126 = this.a.q;
            com.bytedance.android.window.shop.home.tab.tabplugin.e[] r48 = new com.bytedance.android.window.shop.home.tab.tabplugin.e[4];
            r48[0] = new WindowMemberShopPointPlugin(this.a.u().c(), this.a.O());
            r48[1] = new com.bytedance.android.window.shop.home.presenter.plugin.eventcard.a(this.a.u().c(), this.a.U(), this.a.O());
            ECWindowViewModel r49 = this.a.O();
            ECWindowSubTabsPresenter$onBind$1$2 r50 = new ECWindowSubTabsPresenter$onBind$1$2(this.a);
            ECWindowSubTabsPresenter r51 = this.a;
            zn.b<WindowTabDataListResponseDTODeprecated> r52 = r51.O().getHeaderSubTabsParam().c;
            ECWindowSubTabsPresenter$onBind$1$3 r53 = ECWindowSubTabsPresenter$onBind$1$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r52, "source");
            Intrinsics.checkNotNullParameter(r53, "transformer");
            r48[2] = new ECWindowTabsSelectionJSbPluginExp(r49, r50, new AbsECWindowPresenter$observableSourceFromLiveData$2(r51, r52, r53));
            String r54 = this.a.O().getShopParam().getSecAuthorId();
            View r55 = this.a.y();
            if (r55 == null) goto L147;
            r48[3] = new ECWindowShowPopupPlugin(r54, (ViewGroup) r55, this.a.U());
            r126.a(r48);
            return;
        L147:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L130:
            r124 = 0;
        L6:
            QContext r56 = r0.u();
            FragmentActivity r57 = com.bytedance.android.ec.core.utils.l0.c(r56.c());
            if ((r57 instanceof FragmentActivity) == true) goto L9;
            r57 = null;
        L9:
            if (r57 != null) goto L11;
            r57 = r56.a();
        L11:
            r4 = r57.getSupportFragmentManager();
            goto L12
        }
    }

    public final ECWindowTabLayout c0() {
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
        ap3.i.a(new io.d(r1, r2, r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a2.a, b2.a);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public ECWindowSubTabsPresenter() {
        this.m = LazyKt.lazy(new ECWindowSubTabsPresenter$tabLayout$2(this));
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.q = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
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

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        O().doAnyEventActionWithBtm("a1.b7635.c68164.d0", PageFinder.via(y()), "stay_store_page_tab", MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - O().getTabDuration())), TuplesKt.to("store_source_page", O().getShopParam().getStoreSourcePage()), TuplesKt.to("store_source_method", O().getShopParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", O().getShopParam().getStoreGroupType())}), new Pair[0]);
    }

    public final void A(QModel r4) {
        U().getLifecycle().addObserver(this);
        O().getHeaderSubTabsParam().c.a(U(), new a(this), false);
        O().getParamProvider().b("current_category_id", new ECWindowSubTabsPresenter$addWindowEventCardBaseParam$1(this));
        O().getParamProvider().b("follow_status", new ECWindowSubTabsPresenter$addWindowEventCardBaseParam$2(this));
    }

    public final Integer b0(String r4) {
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

    public static final String a0(ECWindowSubTabsPresenter r0, ECTabLayout.Tab r1) {
        if (r1 != null) goto L4;
        r0.getClass();
        return null;
    L4:
        Map<String, String> r2 = r0.n;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        return (String) r3.get(String.valueOf(r1.getText()));
    }
}
