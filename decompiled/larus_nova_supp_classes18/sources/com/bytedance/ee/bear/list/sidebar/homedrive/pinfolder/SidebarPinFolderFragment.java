package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder;

import android.content.Context;
import android.os.Bundle;
import cd5.e;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.list.homepage.BaseHomeFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J(\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/homedrive/pinfolder/SidebarPinFolderFragment;", "Lcom/bytedance/ee/bear/list/homepage/BaseHomeFragment;", "<init>", "()V", "smartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "onCreateViewLazy", "", "savedInstanceState", "Landroid/os/Bundle;", "createHomeHeader", "Lcom/bytedance/ee/bear/list/homepage/widget/BaseHomeHeader;", "fragment", "Lcom/bytedance/ee/bear/facade/common/lazy/LazyBaseFragment;", "context", "Landroid/content/Context;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getLayoutRes", "", "getCurrentModule", "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarPinFolderFragment extends BaseHomeFragment {
    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final e ba0(LazyBaseFragment r1, Context r2, AppBarLayout r3) {
        return null;
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final int da0() {
        return 2131563483;
    }

    public SidebarPinFolderFragment() {
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final void V90(Bundle r2) {
        super.V90(r2);
        if ((findViewById(2131378171) instanceof SmartRefreshLayout) == true) goto L5;
        return;
    }
}
