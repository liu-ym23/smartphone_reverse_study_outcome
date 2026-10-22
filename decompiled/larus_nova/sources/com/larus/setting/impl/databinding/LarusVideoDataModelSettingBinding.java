package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusVideoDataModelSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NovaTitleBarEx f368262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemGroup f368263c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368261a;
    }

    public LarusVideoDataModelSettingBinding(LinearLayout r100, NovaTitleBarEx r101, ItemGroup r102) {
        this.f368261a = r100;
        this.f368262b = r101;
        this.f368263c = r102;
    }
}
