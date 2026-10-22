package com.bytedance.ee.bear.lark.space;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.manualoffline.HomeOfflineFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/lark/space/PadOfflineFragment;", "Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "", "provideHasTemplate", "", "getModule", "getLogTag", "getSrcModule", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PadOfflineFragment extends BasePadHomeFragment {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String W90() {
        return "offline";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String X90() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String getLogTag() {
        return "PadOfflineFragment";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<ad5.e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new ad5.e(HomeTabEnum.OFFLINE.id, 2131887949, HomeOfflineFragment.class.getName()));
        return r0;
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<DocPageEnum> fa0() {
        return CollectionsKt.listOf(DocPageEnum.OFFLINE);
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final String ca0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131887949);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("PadOfflineFragment", "onDestroyView() called this:" + hashCode());
    }

    public PadOfflineFragment() {
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        int r4 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.show_back_btn_for757") == false) goto L8;
        SubMenuViewPad r5 = this.p;
        if (r5 == null) goto L9;
        r5.setCustomLeftTextArea(getString(2131887745));
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        tt5.a.h("PadOfflineFragment", "onCreateView() called with:  this:" + hashCode() + " inflater = " + r3 + ", container = " + r4 + ", savedInstanceState = " + r5);
        return r3.inflate(2131561230, r4, false);
    }
}
