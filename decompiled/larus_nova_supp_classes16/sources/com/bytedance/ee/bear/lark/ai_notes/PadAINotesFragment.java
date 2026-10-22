package com.bytedance.ee.bear.lark.ai_notes;

import ad5.e;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.creationmenu.c;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.lark.space.BasePadHomeFragment;
import com.bytedance.ee.bear.list.ainote.AINoteTabFragment;
import com.bytedance.ee.bear.list.ainote.my_involved.MyInvolvedTabFragment;
import com.bytedance.ee.bear.list.ainote.owned_by_me.OwnedByMeTabFragment;
import com.bytedance.ee.bear.list.ainote.share_with_me.AIShareWithMeTabFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0016H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/lark/ai_notes/PadAINotesFragment;", "Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "<init>", "()V", "mOpenSource", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initStatusBar", "notifyForsetiViewMode", "mode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "onSubMenuSelect", "index", "", "id", "text", "initOpenSource", "reportHomePageClick", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "provideHasTemplate", "", "getModule", "getSrcModule", "getLogTag", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PadAINotesFragment extends BasePadHomeFragment {
    public static final /* synthetic */ int y = 0;
    public String x;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String W90() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String X90() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<DocPageEnum> fa0() {
        return CollectionsKt.listOf(new DocPageEnum[]{DocPageEnum.OWNED_BY_ME, DocPageEnum.MY_INVOLVED, DocPageEnum.AI_NOTE_SHARE_WITH_ME});
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String getLogTag() {
        return "PadAINotesFragment";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new e(HomeTabEnum.OWNED_BY_ME.id, 2131888707, OwnedByMeTabFragment.class.getName()));
        r0.add(new e(HomeTabEnum.MY_INVOLVED.id, 2131894005, MyInvolvedTabFragment.class.getName()));
        r0.add(new e(HomeTabEnum.SHARE_WITH_ME.id, 2131887929, AIShareWithMeTabFragment.class.getName()));
        return r0;
    }

    public PadAINotesFragment() {
        this.x = "other";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final String ca0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131888699);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final void aa0(ForsetiViewMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        View r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2.isCompact() == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        super.onViewCreated(r22, r23);
        c r1 = this.n;
        if (r1 == null) goto L10;
        ViewGroup r2 = r1.w;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        Bundle r3 = getArguments();
        if (r3 != null) goto L14;
        r3 = new Bundle();
    L14:
        if (Intrinsics.areEqual(r3.getString("extra_from"), "vc_tab") == true) goto L17;
    L22:
        Bundle r4 = getArguments();
        String r5 = "other";
        if (r4 == null) goto L28;
        String r6 = r4.getString("extra_from", "other");
        if (r6 == null) goto L28;
        r5 = r6;
    L28:
        this.x = r5;
        f.a.l(new p("ccm_space_ai_notes_view", "", "none", "", "", "", sbb.e.o.b, "", "", false, false, false, 0, null, "", null), null, null, this.x);
        return;
    L17:
        if ((getParentFragment() instanceof SpaceRouteFragment) == false) goto L22;
        int r7 = UIUtils.getColor(getActivity(), 2131100548);
        Fragment r8 = ForsetiHelper.g(getParentFragment());
        if (r8 != null) goto L21;
        r8 = this;
    L21:
        WindowInsetsUtils.b(r8).b(r7);
        goto L22
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final void da0(int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r11, "text");
        if (r9 != 1) goto L7;
        SubMenuViewPad r12 = this.p;
        if (r12 == null) goto L12;
        r12.c();
    L12:
        HomeViewPager r13 = this.q;
        PagerAdapter r0 = null;
        if (r13 == null) goto L15;
        PagerAdapter r14 = r13.getAdapter();
    L17:
        if ((r14 instanceof HomeTabAdapter) == false) goto L19;
        HomeTabAdapter r16 = (HomeTabAdapter) r14;
    L20:
        if (r16 == null) goto L22;
        Fragment r17 = r16.c;
    L24:
        if ((r17 instanceof AINoteTabFragment) == false) goto L31;
        HomeViewPager r18 = this.q;
        if (r18 == null) goto L28;
        r0 = r18.getAdapter();
    L28:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter");
        AINoteTabFragment r19 = ((HomeTabAdapter) r0).c;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.bytedance.ee.bear.list.ainote.AINoteTabFragment");
        AINoteTabFragment r110 = r19;
        FolderSortStrategy r1 = r110.v;
        if (r1 == null) goto L31;
        r110.ia0(r1);
    L31:
        f.a r111 = f.a;
        p r7 = new p("ai_notes", "", "sub_tab", "", "", "ccm_space_ai_notes_click");
        if (r9 == 0) goto L36;
        if (r9 == 1) goto L35;
        String r20 = "share";
    L37:
        r111.l(r7, "tab_name", r20, this.x);
        return;
    L35:
        r20 = "participate";
        goto L37
    L36:
        r20 = "mine";
        goto L37
    L22:
        r17 = null;
        goto L24
    L19:
        r16 = null;
        goto L20
    L15:
        r14 = null;
        goto L17
    L7:
        SubMenuViewPad r112 = this.p;
        if (r112 == null) goto L12;
        AppCompatImageView r113 = r112.getIvFilterIcon();
        if (r113 == null) goto L12;
        r113.setVisibility(0);
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561227, r3, false);
    }
}
