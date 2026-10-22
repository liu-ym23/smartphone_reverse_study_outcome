package com.bytedance.ee.bear.lark.space;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.BaseHeaderFragment;
import com.bytedance.ee.bear.lark.CCMPlaceHolderFragment;
import com.bytedance.ee.bear.list.create.x0;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.t0;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0004J \u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020-H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020403H&J\u0010\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u000103H&J\b\u00107\u001a\u00020-H&J\b\u00108\u001a\u00020%H\u0016J\b\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0012\u0010=\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010>\u001a\u0004\u0018\u00010-H\u0014J\b\u0010?\u001a\u00020\"H\u0014J\b\u0010@\u001a\u00020\"H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "Lcom/bytedance/ee/bear/lark/BaseHeaderFragment;", "<init>", "()V", "mSubMenuView", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad;", "getMSubMenuView", "()Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad;", "setMSubMenuView", "(Lcom/bytedance/ee/bear/list/homepage/title/SubMenuViewPad;)V", "mViewPager", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "getMViewPager", "()Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "setMViewPager", "(Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;)V", "mHeaderTitle", "Landroid/widget/TextView;", "mBackButton", "Landroid/view/View;", "getMBackButton", "()Landroid/view/View;", "setMBackButton", "(Landroid/view/View;)V", "mCreateBtn", "mSelectCreationMenuViewModel", "Lcom/bytedance/ee/bear/content/creation/SelectCreationMenuViewModel;", "mCreationMenuManager", "Lcom/bytedance/ee/bear/list/create/ListSelectCreationMenuManager;", "getMCreationMenuManager", "()Lcom/bytedance/ee/bear/list/create/ListSelectCreationMenuManager;", "mCreationMenuManager$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "findCCMPlaceHolderFragment", "Landroidx/fragment/app/Fragment;", "onSubMenuSelect", "index", "", "id", "text", "", "notifyForsetiViewMode", "mode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "getLogTag", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "getArg", "isDisableCreateBtn", "", "onCreateBtnClick", "v", "onMenuCreateClick", "getHomePageClickEvent", "observeCreatePopupMenu", "closePopupMenu", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePadHomeFragment extends BaseHeaderFragment {
    public static final /* synthetic */ int w = 0;
    public SubMenuViewPad p;
    public HomeViewPager q;
    public TextView r;
    public View s;
    public View t;
    public SelectCreationMenuViewModel u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BasePadHomeFragment a;

        public b(BasePadHomeFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            BasePadHomeFragment r0 = this.a;
            Intrinsics.checkNotNull(r10);
            int r1 = BasePadHomeFragment.w;
            r0.getClass();
            com.bytedance.ee.bear.contract.j r2 = com.bytedance.ee.bear.contract.j.a.a;
            boolean r3 = false;
            if (r2 == null) goto L8;
            r2.getNetworkState();
            boolean r4 = r2.getNetworkState().a();
            int r5 = com.bytedance.ee.bear.content.creation.location.a.a;
            if (com.bytedance.ee.bear.content.creation.location.a.a().a == false) goto L8;
            if (r4 == true) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == false) goto L11;
            Context r11 = r0.getContext();
            int r7 = com.bytedance.ee.bear.content.creation.location.a.a;
            Toast.showWarningText(r11, r0.getString(com.bytedance.ee.bear.content.creation.location.a.a().b), 0);
            return;
        L11:
            tt5.a.h("BasePadHomeFragment", "onMenuCreateClick()...");
            FragmentActivity r8 = r0.requireActivity();
            if (((x0) r0.v.getValue()).a(r8) == false) goto L14;
            tt5.a.h("BasePadHomeFragment", "create menu is already showing");
            return;
        L14:
            boolean r9 = ((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().d().a;
            boolean r12 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6)).d();
            SelectCreationMenuConfig r13 = new SelectCreationMenuConfig();
            r13.k = true;
            r13.l = t0.s();
            if (r12 == true) goto L17;
        L20:
            boolean r14 = true;
        L21:
            r13.o = r14;
            com.bytedance.ee.bear.appsetting.c r16 = com.bytedance.ee.bear.appsetting.c.a.a;
            r13.p = r16.f("spacekit.mobile.docx_create_enable");
            r13.n = r9;
            r13.q = r16.i("ccm.bitable.ccmspace.hassurvey.enable", false);
            int r17 = com.bytedance.ee.bear.content.creation.location.a.a;
            r13.i = com.bytedance.ee.bear.content.creation.location.a.g();
            r13.b = com.bytedance.ee.bear.content.creation.location.a.i();
            r13.e = com.bytedance.ee.bear.content.creation.location.a.h();
            r13.h = com.bytedance.ee.bear.content.creation.location.a.f();
            r13.j = true;
            com.bytedance.ee.bear.content.creation.location.a.b r18 = com.bytedance.ee.bear.content.creation.location.a.j();
            if (r18.a == false) goto L24;
            boolean r19 = r18.b;
        L25:
            r13.a = r19;
            r13.d = true;
            r13.f = true;
            r13.g = true;
            iw4.h r20 = new iw4.h();
            r20.b = r0.W90();
            r20.c = r0.m6();
            if (r10 != null) goto L28;
            r3 = true;
        L28:
            r20.f = r3;
            qc5.a.j();
            r20.g = true;
            ((x0) r0.v.getValue()).c(r8, r20, r13, r0.getParentFragment());
            lc5.f.a r110 = lc5.f.a;
            p r21 = new p(r0.W90(), r0.m6(), "create", "ccm_space_create_new_view", r0.m6(), "ccm_space_home_page_click");
            Intrinsics.checkNotNullParameter(r21, "param");
            r110.I(r21);
            return;
        L24:
            r19 = false;
            goto L25
        L17:
            if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true) == true) goto L20;
            r14 = false;
        L8:
            r6 = false;
            goto L9
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BasePadHomeFragment a;

        public c(BasePadHomeFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h(this.a.getLogTag(), "onViewCreated: on back click ");
            Fragment r4 = this.a;
            r4.getClass();
            Fragment r0 = r4;
        L3:
            if (r0 == null) goto L9;
            if ((r0 instanceof CCMPlaceHolderFragment) == true) goto L6;
            r0 = r0.getParentFragment();
            goto L3
        L6:
            r4 = r0;
        L9:
            if (ForsetiHelper.c(r4) == false) goto L11;
            return;
        L11:
            Context r5 = this.a.getContext();
            ComponentActivity r1 = null;
            if (r5 == null) goto L14;
            Activity r6 = ContextsKt.findActivity(r5);
        L16:
            if ((r6 instanceof ComponentActivity) == false) goto L18;
            r1 = (ComponentActivity) r6;
        L18:
            if (r1 == null) goto L25;
            OnBackPressedDispatcher r7 = r1.getOnBackPressedDispatcher();
            if (r7 == null) goto L26;
            r7.onBackPressed();
            return;
        L26:
            return;
        L25:
            return;
        L14:
            r6 = null;
            goto L16
        }
    }

    public static final class d implements SubMenuViewPad.b {
        public final /* synthetic */ BasePadHomeFragment a;

        public d(BasePadHomeFragment r1) {
            this.a = r1;
        }

        public final void a(int r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "text");
            tt5.a.h(this.a.getLogTag(), "onItemClick() called with: index = " + r4 + ", id = " + r5);
            HomeViewPager r0 = this.a.q;
            if (r0 == null) goto L5;
            r0.setCurrentItem(r4);
        L5:
            this.a.da0(r4, r5, r6);
        }
    }

    static {
    }

    public abstract String ca0();

    public void da0(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
    }

    public abstract List<ad5.e> ea0();

    public abstract List<DocPageEnum> fa0();

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public String getLogTag() {
        return "BasePadHomeFragment";
    }

    public BasePadHomeFragment() {
        this.v = LazyKt.lazy(BasePadHomeFragment$mCreationMenuManager$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public void aa0(ForsetiViewMode r5) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        super.aa0(r5);
        View r0 = this.s;
        int r1 = 0;
        if (r0 != null) goto L5;
    L9:
        View r2 = this.t;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r5.isExpand() == false) goto L15;
        r1 = 8;
    L15:
        r2.setVisibility(r1);
        return;
    L5:
        if (r5.isCompact() == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        goto L9
    L7:
        r3 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.p = r4.findViewById(2131387539);
        this.s = r4.findViewById(2131363762);
        View r6 = r4.findViewById(2131381786);
        this.t = r6;
        if (r6 == null) goto L6;
        r6.setOnClickListener(new b(this));
    L6:
        if (getActivity() != null) goto L9;
        tt5.a.d("BasePadHomeFragment", "observeCreatePopupMenu()...activity is null");
    L16:
        View r7 = this.s;
        if (r7 == null) goto L19;
        r7.setOnClickListener(new c(this));
    L19:
        this.q = r4.findViewById(2131374495);
        TextView r8 = (TextView) r4.findViewById(2131374316);
        this.r = r8;
        if (r8 == null) goto L22;
        r8.setTextColor(UDColorUtils.getColor(LarkContext.getApplication(), 2131106622));
    L22:
        TextView r9 = this.r;
        if (r9 == null) goto L25;
        r9.setText(ca0());
    L25:
        List<ad5.e> r10 = ea0();
        FragmentManager r0 = getChildFragmentManager();
        Context r1 = getContext();
        Bundle r2 = getArguments();
        if (r2 != null) goto L28;
        r2 = new Bundle();
    L28:
        HomeTabAdapter r11 = new HomeTabAdapter(r0, r1, r10, r2);
        HomeViewPager r12 = this.q;
        if (r12 == null) goto L31;
        r12.setAdapter(r11);
    L31:
        HomeViewPager r13 = this.q;
        if (r13 == null) goto L34;
        r13.setCurrentItem(0);
    L34:
        HomeViewPager r14 = this.q;
        if (r14 == null) goto L37;
        r14.setOffscreenPageLimit(2);
    L37:
        SubMenuViewPad r16 = this.p;
        if (r16 == null) goto L40;
        r16.setDataList(fa0());
    L40:
        tt5.a.h(getLogTag(), "onViewCreated: ");
        da0(0, DocPageEnum.RECENT_VISIT.getId(), "RECENT_VISIT");
        SubMenuViewPad r17 = this.p;
        if (r17 == null) goto L44;
        r17.setOnItemClickListener(new d(this));
        return;
    L44:
        return;
    L9:
        if (this.u != null) goto L11;
        this.u = (SelectCreationMenuViewModel) ViewModelProviders.of(requireActivity()).get(SelectCreationMenuViewModel.class);
    L11:
        SelectCreationMenuViewModel r18 = this.u;
        if (r18 == null) goto L16;
        LiveData<Integer> r19 = r18.getSelectedCreationTypeLiveData();
        if (r19 == null) goto L16;
        r19.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.lark.space.a(this));
        goto L16
    }
}
