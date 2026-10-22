package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraHistoryDeviceInfoLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332707c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332705a;
    }

    public LarusDoraHistoryDeviceInfoLayoutBinding(LinearLayout r100, SimpleDraweeView r101, AppCompatTextView r102) {
        this.f332705a = r100;
        this.f332706b = r101;
        this.f332707c = r102;
    }
}
