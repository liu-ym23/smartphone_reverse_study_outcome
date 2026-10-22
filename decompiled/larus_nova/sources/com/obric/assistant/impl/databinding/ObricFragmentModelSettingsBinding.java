package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricFragmentModelSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f389518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f389519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f389520c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389518a;
    }

    public ObricFragmentModelSettingsBinding(LinearLayout r100, ItemGroup r101, NovaTitleBarEx r102) {
        this.f389518a = r100;
        this.f389519b = r101;
        this.f389520c = r102;
    }
}
