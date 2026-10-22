package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraSodaVipBannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemGroup f333296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f333297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f333298c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333296a;
    }

    public LarusDoraSodaVipBannerBinding(ItemGroup r100, LinearLayoutCompat r101, ImageView r102) {
        this.f333296a = r100;
        this.f333297b = r101;
        this.f333298c = r102;
    }
}
