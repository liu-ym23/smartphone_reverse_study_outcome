package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larksuite.component.universe_design.tab.UDTabLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableProRoleDetailLayoutV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f211018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDTabLayout f211019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseTitleBar f211020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager f211021d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211018a;
    }

    public BitableProRoleDetailLayoutV2Binding(LinearLayout r100, UDTabLayout r101, BaseTitleBar r102, ViewPager r103) {
        this.f211018a = r100;
        this.f211019b = r101;
        this.f211020c = r102;
        this.f211021d = r103;
    }
}
