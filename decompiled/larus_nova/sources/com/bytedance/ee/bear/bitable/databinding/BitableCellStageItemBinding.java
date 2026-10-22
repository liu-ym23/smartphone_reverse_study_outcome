package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCellStageItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f210739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RingView f210741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InnerRecyclerView f210742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f210743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f210744g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210738a;
    }

    public BitableCellStageItemBinding(LinearLayout r100, LinearLayout r101, AppCompatImageView r102, RingView r103, InnerRecyclerView r104, ConstraintLayout r105, TextView r106) {
        this.f210738a = r100;
        this.f210739b = r101;
        this.f210740c = r102;
        this.f210741d = r103;
        this.f210742e = r104;
        this.f210743f = r105;
        this.f210744g = r106;
    }
}
