package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemAccountGroupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f368142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemGroup f368143c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368141a;
    }

    public LarusItemAccountGroupBinding(LinearLayout r100, TextView r101, ItemGroup r102) {
        this.f368141a = r100;
        this.f368142b = r101;
        this.f368143c = r102;
    }
}
