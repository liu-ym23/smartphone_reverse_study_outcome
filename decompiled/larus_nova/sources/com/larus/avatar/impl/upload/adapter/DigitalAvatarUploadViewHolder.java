package com.larus.avatar.impl.upload.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avatar.impl.upload.widget.RotateImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/larus/avatar/impl/upload/adapter/DigitalAvatarUploadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "addImageView", "getAddImageView", "()Landroid/view/View;", "uploadImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getUploadImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "deleteIconView", "getDeleteIconView", "loadingContainer", "getLoadingContainer", "loadingIcon", "Lcom/larus/avatar/impl/upload/widget/RotateImageView;", "getLoadingIcon", "()Lcom/larus/avatar/impl/upload/widget/RotateImageView;", "retryIcon", "getRetryIcon", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarUploadViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f291289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f291290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f291291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f291292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RotateImageView f291293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f291294f;

    public DigitalAvatarUploadViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f291289a = r100.findViewById(R.id.add_image);
        this.f291290b = (SimpleDraweeView) r100.findViewById(R.id.upload_image);
        this.f291291c = r100.findViewById(R.id.delete_icon);
        this.f291292d = r100.findViewById(R.id.loading_container);
        this.f291293e = (RotateImageView) r100.findViewById(R.id.loading_icon);
        this.f291294f = r100.findViewById(R.id.retry_icon);
    }
}
