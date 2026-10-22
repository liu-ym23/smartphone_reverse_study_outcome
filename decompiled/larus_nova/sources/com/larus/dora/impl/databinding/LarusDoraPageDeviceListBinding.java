package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageDeviceListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f332895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HistoryDeviceNavigationBar f332896c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332894a;
    }

    public LarusDoraPageDeviceListBinding(LinearLayout r100, RecyclerView r101, HistoryDeviceNavigationBar r102) {
        this.f332894a = r100;
        this.f332895b = r101;
        this.f332896c = r102;
    }
}
