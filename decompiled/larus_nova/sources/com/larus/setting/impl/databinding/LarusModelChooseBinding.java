package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusModelChooseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f368161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f368162c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368160a;
    }

    public LarusModelChooseBinding(LinearLayout r100, ItemGroup r101, NovaTitleBarEx r102) {
        this.f368160a = r100;
        this.f368161b = r101;
        this.f368162c = r102;
    }
}
