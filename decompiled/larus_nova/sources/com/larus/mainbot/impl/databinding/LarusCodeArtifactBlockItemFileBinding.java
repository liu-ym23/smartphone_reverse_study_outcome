package com.larus.mainbot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCodeArtifactBlockItemFileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f358543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358544c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358542a;
    }

    public static LarusCodeArtifactBlockItemFileBinding a(LayoutInflater r100, ConstraintLayout r101) {
        if (r101 == null) goto L12;
        r100.inflate(R.layout.larus_code_artifact_block_item_file, r101);
        int r102 = R.id.iv_second_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.iv_second_icon);
        if (r103 == null) goto L10;
        r102 = R.id.tv_file_name;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.tv_file_name);
        if (r104 == null) goto L10;
        return new LarusCodeArtifactBlockItemFileBinding(r101, r103, r104);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L12:
        throw new NullPointerException("parent");
    }

    public LarusCodeArtifactBlockItemFileBinding(ConstraintLayout r100, ImageView r101, TextView r102) {
        this.f358542a = r100;
        this.f358543b = r101;
        this.f358544c = r102;
    }
}
