package com.obric.assistant.card.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardPhotoGridItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f386199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f386200e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386196a;
    }

    public static ObricCardPhotoGridItemBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.obric_card_photo_grid_item, r101, false);
        int r103 = R.id.image;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.image);
        if (r104 == null) goto L13;
        r103 = R.id.more_mask;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.more_mask);
        if (r105 == null) goto L13;
        r103 = R.id.video_icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r102, R.id.video_icon);
        if (r106 == null) goto L13;
        r103 = R.id.video_icon_mask;
        View r107 = ViewBindings.findChildViewById(r102, R.id.video_icon_mask);
        if (r107 == null) goto L13;
        return new ObricCardPhotoGridItemBinding((ConstraintLayout) r102, r104, r105, r106, r107);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public ObricCardPhotoGridItemBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, ImageView r103, View r104) {
        this.f386196a = r100;
        this.f386197b = r101;
        this.f386198c = r102;
        this.f386199d = r103;
        this.f386200e = r104;
    }
}
