package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.homepage.BitableCreatePanelFragment;
import com.bytedance.ee.bear.bitable.homepage.BitableDefaultTabViewModel;
import com.bytedance.ee.bear.bitable.homepage.list.BitableFavoriteFragment;
import com.bytedance.ee.bear.bitable.homepage.list.BitableHomeRecentFragment;
import com.bytedance.ee.bear.bitable.homepage.list.BitablePinFragment;
import com.bytedance.ee.bear.bitable.homepage.m0;
import com.bytedance.ee.bear.bitable.homepage.recommend.report.LoadFrom;
import com.bytedance.ee.bear.bitable.homepage.recommend.report.TabName;
import com.bytedance.ee.bear.bitable.homepage.tabchoose.BitableTabChooseResponse;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.header.ActivityHeader;
import com.bytedance.ee.bear.lark.header.m;
import com.bytedance.ee.bear.lark.header.n;
import com.bytedance.ee.bear.lark.header.p;
import com.bytedance.ee.bear.lark.header.q;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.list.homepage.banner.BitableCreateActionItem;
import com.bytedance.ee.bear.list.homepage.banner.TemplatesItem;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import vs4.o;
import vs4.s;
import vs4.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0003hijB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00103\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020+H\u0002J\u0012\u0010<\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\u001aH\u0016J\u0012\u0010@\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u001aH\u0014J\b\u0010I\u001a\u00020JH\u0014J\b\u0010K\u001a\u00020FH\u0014J\b\u0010L\u001a\u00020FH\u0014J\b\u0010M\u001a\u00020FH\u0014J\b\u0010N\u001a\u00020FH\u0016J\b\u0010O\u001a\u00020FH\u0016J\b\u0010P\u001a\u00020FH\u0016J\u0010\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020\fH\u0014J\f\u0010S\u001a\b\u0012\u0004\u0012\u00020F0TJ\u0012\u0010U\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u00010/H\u0016J\n\u0010V\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020YJ0\u0010Z\u001a\u00020+2\u0006\u0010X\u001a\u00020Y2\u0006\u0010[\u001a\u00020F2\u0006\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\fH\u0002J,\u0010`\u001a\u00020+2\u0006\u0010a\u001a\u00020F2\u0006\u0010b\u001a\u00020F2\u0006\u0010c\u001a\u00020F2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u000e\u0010f\u001a\u00020+2\u0006\u0010X\u001a\u00020YJ\b\u0010g\u001a\u00020\fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006k"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableTabFragment;", "Lcom/bytedance/ee/bear/lark/biz/bitable/BitableHomeFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/IMenuScrollChangeNotifier;", "<init>", "()V", "templateConfig", "Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;", "getTemplateConfig", "()Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;", "setTemplateConfig", "(Lcom/bytedance/ee/bear/list/homepage/banner/TemplatesItem;)V", "isOldVersion", "", "()Z", "setOldVersion", "(Z)V", "homePageCreateTime", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;", "getHomePageCreateTime", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;", "setHomePageCreateTime", "(Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/HomePageCreateTimeData;)V", "titleContainer", "Landroid/view/ViewGroup;", "hasReportedLanding", "mOrientation", "", "mCreatePanelFragment", "Lcom/bytedance/ee/bear/bitable/homepage/BitableCreatePanelFragment;", "isInForseti", "defaultTabViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "getDefaultTabViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/BitableDefaultTabViewModel;", "defaultTabViewModel$delegate", "Lkotlin/Lazy;", "onMenuScrollChangeListener", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "getOnMenuScrollChangeListener", "()Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", "setOnMenuScrollChangeListener", "(Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onActivityCreated", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setUserVisibleHint", "isVisibleToUser", "setMenuScrollListener", "reLayoutForNewVersion", "root", "onTabSelected", "index", "initLarkTitleBar", "titleBar", "Lcom/bytedance/ee/bear/list/homepage/title/ITitleBar;", "getHeaderConfig", "Lcom/bytedance/ee/bear/lark/header/IHeaderConfig;", "getSubModule", "", "getTabType", "position", "getHomeTabConfig", "Lcom/bytedance/ee/bear/list/homepage/tab/IHomeTabConfig;", "getHomePageViewEvent", "getHomePageClickEvent", "getHomePageSwitchClickEvent", "getContainerEnv", "getHomePageFrom", "getCreateTemplateSource", "updateHomeSubMenuFilterView", "visible", "getSpecifyMoreItemList", "", "onMenuCreateClick", "getCreatePanelFragment", "createEmptyBitable", "context", "Landroid/content/Context;", "handleCreateError", "parentToken", "module", "throwable", "", "createInWiki", "handleCreateSuccess", "url", "openType", DocRedirectToDocxPlugin.FROM, "documentCreateInfo", "Lcom/bytedance/ee/bear/contract/create/DocumentCreateInfo;", "showCreateLoading", "netCheck", "Companion", "BitableTabHeaderConfig", "BitableHomeTabConfig", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabFragment extends BitableHomeFragment implements m0 {
    public static final /* synthetic */ int P = 0;
    public TemplatesItem G;
    public boolean H;
    public z I;
    public ViewGroup J;
    public boolean K;
    public int L;
    public BitableCreatePanelFragment M;
    public final Lazy N;
    public com.bytedance.ee.bear.list.list.d.c O;

    public static final class a implements ad5.f {
        public final boolean a;

        public a() {
            this.a = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.homepage.fav.disable");
        }

        public final List<ad5.e> a(boolean r5) {
            ArrayList r6 = new ArrayList();
            r6.add(new ad5.e(HomeTabEnum.RECENT.id, 2131886925, BitableHomeRecentFragment.class.getName()));
            int r1 = HomeTabEnum.PIN.id;
            if (ex4.a.a(new ce5.a().d) == false) goto L5;
            int r2 = 2131886601;
        L6:
            r6.add(new ad5.e(r1, r2, BitablePinFragment.class.getName()));
            if (this.a == true) goto L9;
            r6.add(new ad5.e(HomeTabEnum.FAVORITE.id, 2131886908, BitableFavoriteFragment.class.getName()));
        L9:
            return r6;
        L5:
            r2 = 2131886924;
            goto L6
        }
    }

    public static final class b implements com.bytedance.ee.bear.lark.header.h {
        public final HashMap<com.bytedance.ee.bear.lark.header.i, Integer> a;

        @Override // com.bytedance.ee.bear.lark.header.h
        public final Map<com.bytedance.ee.bear.lark.header.i, Integer> getHeaders() {
            return this.a;
        }

        public b(boolean r9, String r10, BitableHomeFragment r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "hpFrom");
            Intrinsics.checkNotNullParameter(r11, "fragment");
            LinkedHashMap r0 = new LinkedHashMap();
            this.a = r0;
            com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
            boolean r2 = r1.h("ccm.bitable.tab.activity.enable");
            boolean r3 = r1.h("bitable.homepage.v3.enable");
            boolean r4 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base");
            if (r12 == false) goto L5;
            int r5 = 2131165446;
        L6:
            int r6 = 0;
            if (r9 == false) goto L9;
            r0.put(new com.bytedance.ee.bear.lark.header.b(), 0);
            r6 = 1;
        L9:
            int r7 = r6 + 1;
            r0.put(new m(true), Integer.valueOf(r6));
            if (r12 == false) goto L14;
            if (r3 == true) goto L14;
            if (r4 == false) goto L14;
            n r8 = new n(r9, r10, r11);
            int r13 = r7 + 1;
            r0.put(r8, Integer.valueOf(r7));
            r7 = r13;
        L14:
            if (r12 == false) goto L17;
            if (r2 == false) goto L17;
            ActivityHeader r14 = new ActivityHeader(r11, r9);
            r0.put(r14, Integer.valueOf(r7));
            r7 = r7 + 1;
        L17:
            if (r12 == false) goto L21;
            if (r3 == true) goto L21;
            if (r4 == false) goto L21;
            r0.put(new q(), Integer.valueOf(r7));
            r7 = r7 + 1;
        L21:
            Integer r16 = Integer.valueOf(r7);
            r0.put(new p(r5), r16);
            return;
        L5:
            r5 = 2131165447;
            goto L6
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BitableTabFragment a;

        public d(BitableTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableTabFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = BitableTabFragment.P;     // Catch: Throwable -> L4
            r0.o.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements BitableCreatePanelFragment.b {
        public final /* synthetic */ BitableTabFragment a;

        public static final class a implements com.bytedance.ee.bear.templates.dto.e {
            public final /* synthetic */ BitableTabFragment a;

            public a(BitableTabFragment r1) {
                this.a = r1;
            }

            public final void onSuccess(int r10, String r11) {
                lc5.f.a r0 = lc5.f.a;
                this.a.getClass();
                String r2 = this.a.m6();
                String r6 = this.a.m6();
                String r7 = this.a.W9();
                String r8 = this.a.ba0();
                this.a.getClass();
                r0.q("lark_workspace_bitable_landing", r2, "new_form", "ccm_bitable_content_page_view", r11, r6, r7, r8);
                tt5.a.b("BitableTabFragment", "onSuccess: " + r10);
            }
        }

        public final void a() {
            tt5.a.b("BitableTabFragment", "clickCancel: ");
        }

        public final void qa() {
            this.a.M = null;
        }

        public e(BitableTabFragment r1) {
            this.a = r1;
        }

        public final void b(BitableCreateActionItem r14) {
            Intrinsics.checkNotNullParameter(r14, "item");
            if (TextUtils.equals("CREATE_BITABLE", r14.getType()) == false) goto L26;
            Context r16 = this.a.getContext();
            if (r16 == null) goto L43;
            BitableTabFragment r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r16, "context");
            int r2 = qc5.a.a;
            ce5.a r3 = new ce5.a();
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            boolean r5 = r3.g.n1().hasBenefit("common_create_to_my_doc_library");
            boolean r4 = r3.d.isCurrentEnable("ccm.space.default_create_to_my_library_enabled");
            tt5.a.h("SpaceFeatureGatingV2", "isCreate2MyLibraryEnable()...enable = " + r4);
            boolean r6 = false;
            if (r4 == true) goto L9;
        L12:
            boolean r7 = false;
        L13:
            if (r7 == true) goto L15;
        L17:
            boolean r11 = false;
        L18:
            int r12 = sbb.e.i.b;
            ConnectionService.NetworkState r8 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
            if ((!r8.a()) == false) goto L21;
            tt5.a.h("BitableTabFragment", "create template offline, state:" + r8);
            Toast.showFailureText(r0.getContext(), 2131887937);
        L22:
            if (r6 == false) goto L50;
            Intrinsics.checkNotNullParameter(r16, "context");
            tt5.a.h("BitableTabFragment", "showCreateLoading()...");
            Toast.showLoading(r16, r16.getString(2131887993));
            r0.z.add(q0.b(r12, "", "lark_workspace_bitable_landing", true, r11, null, 0, null, null).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.lark.biz.bitable.e(r0, r12), new com.bytedance.ee.bear.lark.biz.bitable.f(r0, r16, r11)));
            return;
        L50:
            return;
        L21:
            r6 = true;
            goto L22
        L15:
            if (Intrinsics.areEqual("create_new", "create_new") == true) goto L17;
            r11 = true;
            goto L18
        L9:
            if (qc5.a.c() == false) goto L12;
            if (r5 == false) goto L12;
            r7 = true;
            goto L13
        L43:
            return;
        L26:
            if (TextUtils.equals("CREATE_NEW_SURVEY", r14.getType()) == false) goto L29;
            BitableTabFragment r17 = this.a;
            r17.Ca0(r17.W9(), "base_hp_create_form");
            lc5.f.a r9 = lc5.f.a;
            this.a.getClass();
            String r10 = this.a.m6();
            String r13 = this.a.m6();
            String r18 = this.a.W9();
            String r19 = this.a.ba0();
            this.a.getClass();
            r9.q("lark_workspace_bitable_landing", r10, "new_form_templates", "ccm_template_systemcenter_view", null, r13, r18, r19);
            return;
        L29:
            if (TextUtils.equals("CREATE_FORM", r14.getType()) == false) goto L40;
            wn5.a r1 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
            BitableTabFragment r110 = this.a;
            TemplatesItem r20 = r110.G;
            if (r20 != null) goto L33;
            return;
        L33:
            if (r110.getActivity() == null) goto L47;
            FragmentActivity r111 = this.a.getActivity();
            String r21 = r20.getObjToken();
            int r22 = r20.getObjType();
            BitableTabFragment r23 = this.a;
            if (r23.F == false) goto L37;
            String r24 = "base_hp_workbench_form";
        L38:
            r1.h(r111, r21, r22, r24, null, null, "", "", "", false, "", new a(r23));
            return;
        L37:
            r24 = "base_hp_larktab_form";
            goto L38
        L47:
            return;
        L40:
            if (TextUtils.equals("OPEN_TEMPLATE", r14.getType()) == false) goto L49;
            BitableTabFragment r112 = this.a;
            r112.Ca0(r112.W9(), this.a.W9());
            lc5.f.a r26 = lc5.f.a;
            this.a.getClass();
            String r27 = this.a.m6();
            String r28 = this.a.m6();
            String r29 = this.a.W9();
            String r113 = this.a.ba0();
            this.a.getClass();
            r26.q("lark_workspace_bitable_landing", r27, "templates", "none", null, r28, r29, r113);
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ BitableTabFragment a;

        public f(BitableTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableTabFragment r0 = this.a;     // Catch: Throwable -> L9
            int r1 = BitableTabFragment.P;     // Catch: Throwable -> L9
            HomeTabAdapter r2 = r0.p;     // Catch: Throwable -> L9
            if (r2 == null) goto L12;
            m0 r3 = r2.c;     // Catch: Throwable -> L9
            if ((r3 instanceof m0) == false) goto L16;
            r3.gL(r0.O);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void Aa0(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final String aa0() {
        return "ccm_base_homepage_landing_click";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final String ca0() {
        return "ccm_base_homepage_filelist_click";
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final String da0() {
        return "ccm_base_homepage_landing_view";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final String ga0(int r2) {
        if (r2 != 1) goto L5;
        return "quick_access";
    L5:
        if (r2 == 2) goto L7;
        return "recent";
    L7:
        return "favorites";
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final String W9() {
        if (this.F == false) goto L5;
        return "workbench";
    L5:
        return "larktab_bitable";
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final com.bytedance.ee.bear.lark.header.h Z90() {
        return new b(this.F, ba0(), this, this.H);
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final String ba0() {
        if (this.F == true) goto L7;
        return "lark_tab";
    L7:
        return super.ba0();
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final ad5.f ea0() {
        return new a();
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final String m6() {
        return ga0(this.y);
    }

    public BitableTabFragment() {
        this.H = true;
        this.I = new z();
        this.N = LazyKt.lazy(new BitableTabFragment$defaultTabViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment
    public final String Ba0() {
        return W9();
    }

    public final void gL(com.bytedance.ee.bear.list.list.d.c r1) {
        this.O = r1;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ja0(com.bytedance.ee.bear.list.homepage.title.b r2) {
        if (r2 == null) goto L5;
        r2.setTitle(getString(2131886906));
        return;
    }

    public final void onActivityCreated(Bundle r11) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r11);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.new.native.enable") == true) goto L6;
        return;
    L6:
        if (this.I.a == 0) goto L12;
        int r12 = vs4.a.a;
        Long r5 = Long.valueOf(System.currentTimeMillis() - this.I.a);
        String r6 = TabName.PERSONAL.getValue();
        BitableTabChooseResponse r13 = (BitableTabChooseResponse) ((BitableDefaultTabViewModel) this.N.getValue()).getBitableTabChooseResponse().getValue();
        if (r13 == null) goto L10;
        LoadFrom r14 = r13.getLoadFrom();
    L11:
        Intrinsics.checkNotNullParameter(r6, "tabName");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new vs4.b(r5, r6, r14, 0L, 0L));
        return;
    L10:
        r14 = null;
        goto L11
    L12:
        tt5.a.h("BitableTabFragment", "May be from single line, time is: " + this.I.a);
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        if (r3.orientation == this.L) goto L8;
        ViewPager r0 = this.o;
        if (r0 == null) goto L9;
        r0.post(new d(this));
        this.L = r3.orientation;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.L = getResources().getConfiguration().orientation;
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.BitableHomeFragment, com.bytedance.ee.bear.lark.DocTabFragment
    public final void onMenuCreateClick(View r12) {
        boolean r1 = true;
        Fragment r4 = null;
        if (this.M != null) goto L5;
    L12:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L17;
        Fragment r2 = r0.getSupportFragmentManager().findFragmentByTag("BitableCreatePanelFragment");
        if ((r2 instanceof BitableCreatePanelFragment) == false) goto L17;
        BitableCreatePanelFragment r3 = (BitableCreatePanelFragment) r2;
    L18:
        if (r3 == null) goto L21;
        tt5.a.b("BitableTabFragment", "bitable create panel already exists ");
        return;
    L21:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L70;
        BitableBannerConfig r6 = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        if (r6 == null) goto L26;
        TemplatesItem r7 = r6.getNewFormTemplate();
    L27:
        this.G = r7;
        ArrayList r8 = new ArrayList();
        Context r9 = getContext();
        if (r9 == null) goto L30;
        String r10 = r9.getString(2131886914);
    L31:
        r8.add(new BitableCreateActionItem("CREATE_BITABLE", r10, Integer.valueOf(kac.a.b(2131254400))));
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.homepage.hassurvey.enable") == false) goto L39;
        Context r11 = getContext();
        if (r11 == null) goto L36;
        String r13 = r11.getString(2131886599);
    L37:
        r8.add(new BitableCreateActionItem("CREATE_NEW_SURVEY", r13, Integer.valueOf(kac.a.b(2131254460))));
        goto L39
    L36:
        r13 = null;
    L39:
        if (this.G == null) goto L45;
        Context r14 = getContext();
        if (r14 == null) goto L43;
        String r16 = r14.getString(2131886915);
    L44:
        r8.add(new BitableCreateActionItem("CREATE_FORM", r16, Integer.valueOf(kac.a.b(2131254460))));
        goto L45
    L43:
        r16 = null;
    L45:
        Context r17 = getContext();
        if (r17 == null) goto L48;
        String r18 = r17.getString(2131886927);
    L49:
        r8.add(new BitableCreateActionItem("OPEN_TEMPLATE", r18, 2131255980));
        int r19 = BitableCreatePanelFragment.o;
        Intrinsics.checkNotNullParameter(r8, "actionList");
        Bundle r20 = new Bundle();
        r20.putSerializable("action_list", r8);
        Fragment r21 = Fragment.instantiate(r5, BitableCreatePanelFragment.class.getName(), r20);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.homepage.BitableCreatePanelFragment");
        Fragment r110 = (BitableCreatePanelFragment) r21;
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L52;
    L54:
        r1 = false;
    L55:
        if (r1 == false) goto L57;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.h(r110, r5, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r12, -2, "BitableCreatePanelFragment", null, false, 256);
    L65:
        ((BitableCreatePanelFragment) r110).m = new e(this);
        this.M = r110;
        return;
    L57:
        FragmentManager r111 = r5.getSupportFragmentManager();
        if ((r110 instanceof Fragment) == false) goto L60;
        r4 = r110;
    L60:
        LandscapeRestrictionOperation r22 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "BitableCreatePanelFragment", r22);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r111, r4, r22) == true) goto L65;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L67
    L64:
        r110.show(r111, "BitableCreatePanelFragment");
        goto L65
    L52:
        if (ForsetiHelper.s(this) == false) goto L54;
    L48:
        r18 = null;
        goto L49
    L30:
        r10 = null;
        goto L31
    L26:
        r7 = null;
        goto L27
    L70:
        return;
    L17:
        r3 = null;
        goto L18
    L5:
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L7;
    L9:
        boolean r23 = false;
    L10:
        if (r23 == false) goto L12;
        r3 = this.M;
        goto L18
    L7:
        if (ForsetiHelper.s(this) == false) goto L9;
        r23 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        if (r3 == true) goto L5;
        return;
    L5:
        if (this.K == true) goto L9;
        int r4 = s.a;
        Intrinsics.checkNotNullParameter("personal", "tabName");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new o("personal"));
        this.K = true;
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void xa0(int r6) {
        if (this.H == true) goto L29;
        ViewGroup r0 = this.J;
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = r0.getChildCount();
    L8:
        if (r6 >= r2) goto L36;
        ViewGroup r3 = this.J;
        if (r3 == null) goto L34;
        Sequence r4 = ViewGroupKt.getChildren(r3);
        if (r4 == null) goto L35;
        Iterator r5 = r4.iterator();
    L16:
        if (r5.hasNext() == false) goto L37;
        Object r7 = r5.next();
        int r8 = r1 + 1;
        if (r1 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        View r9 = (View) r7;
        if ((r9 instanceof TextView) == false) goto L28;
        if ((r9 instanceof xuc.b) == false) goto L28;
        if (r6 != r1) goto L26;
        Drawable r10 = UIHelper.getDrawable(2131232385);
    L27:
        r9.setBackground(r10);
        goto L28
    L26:
        r10 = UIHelper.getDrawable(2131232386);
    L28:
        r1 = r8;
        goto L16
    L37:
        return;
    L35:
        return;
    L34:
        return;
    L36:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ViewPager r4 = this.o;
        if (r4 == null) goto L6;
        r4.addOnPageChangeListener(new AnonymousClass1(this));
        this.o.post(new f(this));
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r16 = super.onCreateView(r12, r13, r14);
        if (r16 == null) goto L7;
        ViewPager r17 = r16.findViewById(2131378123);
        if (r17 == null) goto L7;
        r17.setOffscreenPageLimit(2);
    L7:
        ViewGroup.MarginLayoutParams r1 = null;
        if (this.H == false) goto L22;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.homepage.v3.enable") == false) goto L67;
        if (r16 == null) goto L15;
        ViewGroup r18 = (ViewGroup) r16.findViewById(2131374462);
        if (r18 == null) goto L15;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
    L17:
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r1 = (ViewGroup.MarginLayoutParams) r19;
    L19:
        if (r1 == null) goto L67;
        r1.bottomMargin = com.bytedance.ee.util.ui.n.d(5);
    L15:
        r19 = null;
    L67:
        return r16;
    L22:
        if (r16 == null) goto L27;
        ViewGroup r110 = (ViewGroup) r16.findViewById(2131374462);
        if (r110 == null) goto L27;
        r110.setBackgroundColor(0);
    L27:
        if (r16 == null) goto L31;
        View r2 = r16.findViewById(2131375232);
        if (r2 == null) goto L31;
        r2.setVisibility(8);
    L31:
        if (r16 == null) goto L35;
        CollapsingToolbarLayout r3 = r16.findViewById(2131378079);
        if (r3 == null) goto L35;
        r3.setMinimumHeight(com.bytedance.ee.util.ui.n.d(52));
    L35:
        if (r16 == null) goto L37;
        ViewGroup r4 = (ViewGroup) r16.findViewById(2131388843);
    L38:
        this.J = r4;
        if (r4 == null) goto L41;
        r4.setPadding(com.bytedance.ee.util.ui.n.d(10), 0, 0, 0);
    L41:
        ViewGroup r5 = this.J;
        if (r5 == null) goto L67;
        Sequence r6 = ViewGroupKt.getChildren(r5);
        if (r6 == null) goto L67;
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L47:
        if (r7.hasNext() == false) goto L67;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        View r11 = (View) r9;
        if ((r11 instanceof TextView) == false) goto L66;
        if ((r11 instanceof xuc.b) == false) goto L66;
        TextView r20 = (TextView) r11;
        r20.setTextSize(12.0f);
        r20.setPadding(com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(5), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(5));
        ViewGroup.LayoutParams r21 = r11.getLayoutParams();
        if ((r21 instanceof LinearLayout.LayoutParams) == false) goto L58;
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r21;
    L59:
        if (r22 == null) goto L62;
        r22.setMargins(0, 0, com.bytedance.ee.util.ui.n.d(8), 0);
    L62:
        if (r8 != this.y) goto L64;
        Drawable r23 = UIHelper.getDrawable(2131232385);
    L65:
        r11.setBackground(r23);
        goto L66
    L64:
        r23 = UIHelper.getDrawable(2131232386);
        goto L65
    L58:
        r22 = null;
    L66:
        r8 = r10;
        goto L47
    L37:
        r4 = null;
        goto L38
    }
}
