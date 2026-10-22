package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.tab.UDTabLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableDataDrillDownTablistLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDTabLayout f210746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDTabLayout f210747b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210746a;
    }

    public BitableDataDrillDownTablistLayoutBinding(UDTabLayout r100, UDTabLayout r101) {
        this.f210746a = r100;
        this.f210747b = r101;
    }
}
