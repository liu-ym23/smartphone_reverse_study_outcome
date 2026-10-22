package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageDataModelSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f317960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f317961c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317959a;
    }

    public LarusPageDataModelSettingBinding(LinearLayout r100, ItemGroup r101, NovaTitleBarEx r102) {
        this.f317959a = r100;
        this.f317960b = r101;
        this.f317961c = r102;
    }
}
