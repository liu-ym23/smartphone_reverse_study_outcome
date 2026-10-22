package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.record.page.UploadProgressView;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutRecordHistoryItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f293327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f293331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f293332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f293333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final UploadProgressView f293334i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293326a;
    }

    public LayoutRecordHistoryItemBinding(ConstraintLayout r100, View r101, TextView r102, TextView r103, TextView r104, TextView r105, FrameLayout r106, ImageView r107, UploadProgressView r108) {
        this.f293326a = r100;
        this.f293327b = r101;
        this.f293328c = r102;
        this.f293329d = r103;
        this.f293330e = r104;
        this.f293331f = r105;
        this.f293332g = r106;
        this.f293333h = r107;
        this.f293334i = r108;
    }
}
