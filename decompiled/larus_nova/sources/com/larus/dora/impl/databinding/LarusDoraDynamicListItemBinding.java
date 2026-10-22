package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDynamicListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f332510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332511b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332510a;
    }

    public LarusDoraDynamicListItemBinding(MaterialCardView r100, SimpleDraweeView r101) {
        this.f332510a = r100;
        this.f332511b = r101;
    }

    public static LarusDoraDynamicListItemBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_dynamic_list_item, r101, false);
        MaterialCardView r103 = (MaterialCardView) r102;
        int r104 = R.id.image_cover;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.image_cover);
        if (r105 == null) goto L11;
        r104 = R.id.tv_device_desc;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_device_desc)) == null) goto L11;
        r104 = R.id.tv_device_name;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_device_name)) == null) goto L11;
        return new LarusDoraDynamicListItemBinding(r103, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }
}
