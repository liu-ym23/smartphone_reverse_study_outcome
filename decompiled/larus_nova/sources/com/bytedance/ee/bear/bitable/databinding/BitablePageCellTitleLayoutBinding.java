package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.title.TitleTextView;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageCellTitleLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f210998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f210999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SyncIconImageView f211000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TitleTextView f211001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f211002e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210998a;
    }

    public BitablePageCellTitleLayoutBinding(ConstraintLayout r100, ConstraintLayout r101, SyncIconImageView r102, TitleTextView r103, FrameLayout r104) {
        this.f210998a = r100;
        this.f210999b = r101;
        this.f211000c = r102;
        this.f211001d = r103;
        this.f211002e = r104;
    }
}
