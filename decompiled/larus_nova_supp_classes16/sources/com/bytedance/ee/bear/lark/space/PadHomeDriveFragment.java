package com.bytedance.ee.bear.lark.space;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.title.DocPageEnum;
import com.bytedance.ee.bear.list.share.NewShareFolderFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/lark/space/PadHomeDriveFragment;", "Lcom/bytedance/ee/bear/lark/space/BasePadHomeFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "provideHomeTabs", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideTabs", "Lcom/bytedance/ee/bear/list/homepage/title/DocPageEnum;", "getTitle", "", "provideHasTemplate", "", "getModule", "getSrcModule", "getLogTag", "getMenuNameResId", "Lkotlin/Pair;", "", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PadHomeDriveFragment extends BasePadHomeFragment {
    public static final /* synthetic */ int x = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String W90() {
        return "new_drive";
    }

    @Override // com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String X90() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<DocPageEnum> fa0() {
        return CollectionsKt.listOf(new DocPageEnum[]{DocPageEnum.MY_FOLDER, DocPageEnum.SHARE_FOLDER});
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment, com.bytedance.ee.bear.lark.BaseHeaderFragment
    public final String getLogTag() {
        return "PadHomeDriveFragment";
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final List<ad5.e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new ad5.e(HomeTabEnum.PERSONAL_FOLDER.id, ((Number) new Pair(2131889621, 2131889636).getFirst()).intValue(), HomePersonalFragment.class.getName()));
        r0.add(new ad5.e(HomeTabEnum.SHARE_FOLDER.id, ((Number) new Pair(2131889621, 2131889636).getSecond()).intValue(), NewShareFolderFragment.class.getName()));
        return r0;
    }

    @Override // com.bytedance.ee.bear.lark.space.BasePadHomeFragment
    public final String ca0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = r0.getString(2131888777);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public PadHomeDriveFragment() {
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561228, r3, false);
    }
}
