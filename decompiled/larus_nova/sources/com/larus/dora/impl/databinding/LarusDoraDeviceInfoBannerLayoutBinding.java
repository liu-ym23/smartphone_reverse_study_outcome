package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceInfoBannerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemGroup f332379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f332380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f332381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f332382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332383e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332379a;
    }

    public LarusDoraDeviceInfoBannerLayoutBinding(ItemGroup r100, LinearLayoutCompat r101, ImageView r102, AppCompatTextView r103, DoraTextView r104) {
        this.f332379a = r100;
        this.f332380b = r101;
        this.f332381c = r102;
        this.f332382d = r103;
        this.f332383e = r104;
    }
}
