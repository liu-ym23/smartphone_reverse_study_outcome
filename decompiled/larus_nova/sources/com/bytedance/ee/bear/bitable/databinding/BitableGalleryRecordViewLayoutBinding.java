package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.CommentView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cell.GalleryFieldCellListView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover.GalleryCoverView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.title.GalleryTitleView;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableGalleryRecordViewLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GalleryFieldCellListView f210783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentView f210784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GalleryCoverView f210785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f210786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LKUIRoundableLayout f210787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GalleryTitleView f210788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f210789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f210790i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210782a;
    }

    public BitableGalleryRecordViewLayoutBinding(LinearLayout r100, GalleryFieldCellListView r101, CommentView r102, GalleryCoverView r103, ConstraintLayout r104, LKUIRoundableLayout r105, GalleryTitleView r106, LinearLayout r107, LinearLayout r108) {
        this.f210782a = r100;
        this.f210783b = r101;
        this.f210784c = r102;
        this.f210785d = r103;
        this.f210786e = r104;
        this.f210787f = r105;
        this.f210788g = r106;
        this.f210789h = r107;
        this.f210790i = r108;
    }
}
