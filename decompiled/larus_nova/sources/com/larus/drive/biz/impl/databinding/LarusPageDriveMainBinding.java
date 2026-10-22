package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.drive.biz.impl.view.widget.DriveTagListView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusPageDriveMainBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NovaTitleBarEx f341143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DriveTagListView f341144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardView f341145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f341146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f341147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f341148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProgressBar f341149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f341150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewPager2 f341151j;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341142a;
    }

    public LarusPageDriveMainBinding(ConstraintLayout r100, NovaTitleBarEx r101, DriveTagListView r102, CardView r103, ImageView r104, ImageView r105, TextView r106, ProgressBar r107, ImageView r108, ViewPager2 r110) {
        this.f341142a = r100;
        this.f341143b = r101;
        this.f341144c = r102;
        this.f341145d = r103;
        this.f341146e = r104;
        this.f341147f = r105;
        this.f341148g = r106;
        this.f341149h = r107;
        this.f341150i = r108;
        this.f341151j = r110;
    }
}
