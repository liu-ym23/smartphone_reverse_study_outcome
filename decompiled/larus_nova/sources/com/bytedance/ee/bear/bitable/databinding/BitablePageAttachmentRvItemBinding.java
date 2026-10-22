package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.PageAttachmentCoverView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePageAttachmentRvItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210986a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210986a;
    }

    public BitablePageAttachmentRvItemBinding(FrameLayout r100, PageAttachmentCoverView r101, LKUIRoundedImageView2 r102) {
        this.f210986a = r100;
    }
}
