package com.bytedance.ee.bear.lark.space;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.list.share.HomeSharedFragment;
import com.bytedance.ee.bear.list.star.HomeFavoriteFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0016H\u0016J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/lark/space/PadHomeMainFragment;", "Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "<init>", "()V", "listener", "Lcom/bytedance/ee/bear/lark/space/PadHomeMainFragment$OnSubMenuSelectListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "", "provideHasTemplate", "", "getMenuNameResId", "Lkotlin/Triple;", "", "getModule", "onSubMenuSelect", "index", "id", "text", "setOnSubMenuSelectListener", "getLogTag", "getSubModule", "Companion", "OnSubMenuSelectListener", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PadHomeMainFragment extends BasePadHomeFragment {
    public static final /* synthetic */ int y = 0;
    public b x;

    public static final class a {
    }

    public interface b {
        void a(int r1, int r2, String r3);
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String W90() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<DocPageEnum> fa0() {
        return CollectionsKt.listOf(new DocPageEnum[]{DocPageEnum.RECENT_VISIT, DocPageEnum.SHARE_WITH_ME, DocPageEnum.FAVORITE});
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String getLogTag() {
        return "PadHomeMainFragment";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String m6() {
        return "quick_access";
    }

    public static Triple ga0() {
        return new Triple(2131889630, 2131887980, 2131887927);
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<ad5.e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new ad5.e(HomeTabEnum.RECENT.id, ((Number) ga0().getFirst()).intValue(), PadRecentDocumentFragment.class.getName()));
        r0.add(new ad5.e(HomeTabEnum.SHARE_FOLDER.id, ((Number) ga0().getSecond()).intValue(), HomeSharedFragment.class.getName()));
        r0.add(new ad5.e(HomeTabEnum.FAVORITE.id, ((Number) ga0().getThird()).intValue(), HomeFavoriteFragment.class.getName()));
        return r0;
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final String ca0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131889609);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("PadHomeMainFragment", "onDestroyView() called this:" + hashCode());
    }

    public PadHomeMainFragment() {
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final void da0(int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        b r0 = this.x;
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        tt5.a.h("PadHomeMainFragment", "onCreateView() called with: this:" + hashCode() + " inflater = " + r3 + ", container = " + r4 + ", savedInstanceState = " + r5);
        return r3.inflate(2131561229, r4, false);
    }
}
