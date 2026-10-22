package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.FileNameView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutFileCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f311020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileNameView f311021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardView f311022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f311023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f311024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f311025f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311020a;
    }

    public LarusLayoutFileCardBinding(RelativeLayout r100, FileNameView r101, CardView r102, AppCompatImageView r103, LinearLayout r104, TextView r105) {
        this.f311020a = r100;
        this.f311021b = r101;
        this.f311022c = r102;
        this.f311023d = r103;
        this.f311024e = r104;
        this.f311025f = r105;
    }
}
