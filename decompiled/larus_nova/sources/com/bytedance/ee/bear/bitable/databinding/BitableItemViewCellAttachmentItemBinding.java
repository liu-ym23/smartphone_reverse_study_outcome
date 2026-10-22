package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.PageAttachmentView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewCellAttachmentItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f210818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PageAttachmentView f210820d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210817a;
    }

    public BitableItemViewCellAttachmentItemBinding(View r100, FrameLayout r101, AppCompatImageView r102, PageAttachmentView r103) {
        this.f210817a = r100;
        this.f210818b = r101;
        this.f210819c = r102;
        this.f210820d = r103;
    }
}
