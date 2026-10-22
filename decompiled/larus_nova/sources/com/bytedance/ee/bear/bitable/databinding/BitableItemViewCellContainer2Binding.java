package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewFieldViewV2;
import com.bytedance.ee.bear.bitable.itemview.cell.other.EmptyCellV2;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewCellContainer2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f210823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f210824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f210825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EmptyCellV2 f210826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemViewFieldViewV2 f210827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f210828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f210829g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210823a;
    }

    public BitableItemViewCellContainer2Binding(ConstraintLayout r100, LinearLayout r101, FrameLayout r102, EmptyCellV2 r103, ItemViewFieldViewV2 r104, ConstraintLayout r105, AppCompatTextView r106) {
        this.f210823a = r100;
        this.f210824b = r101;
        this.f210825c = r102;
        this.f210826d = r103;
        this.f210827e = r104;
        this.f210828f = r105;
        this.f210829g = r106;
    }
}
