package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDriveFileListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f341114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f341115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout f341116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f341117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardView f341118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f341119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f341120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f341121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ProgressBar f341122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f341123k;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341113a;
    }

    public LarusDriveFileListBinding(ConstraintLayout r100, LinearLayout r101, LinearLayout r102, SwipeRefreshLayout r103, RecyclerView r104, CardView r105, ImageView r106, ImageView r107, TextView r108, ProgressBar r110, ImageView r111) {
        this.f341113a = r100;
        this.f341114b = r101;
        this.f341115c = r102;
        this.f341116d = r103;
        this.f341117e = r104;
        this.f341118f = r105;
        this.f341119g = r106;
        this.f341120h = r107;
        this.f341121i = r108;
        this.f341122j = r110;
        this.f341123k = r111;
    }
}
