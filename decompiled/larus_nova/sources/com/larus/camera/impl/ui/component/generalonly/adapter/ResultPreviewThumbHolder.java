package com.larus.camera.impl.ui.component.generalonly.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/ResultPreviewThumbHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "previewThumbImageView", "Landroid/widget/ImageView;", "getPreviewThumbImageView", "()Landroid/widget/ImageView;", "previewMarkedImageView", "getPreviewMarkedImageView", "previewThumbBorderView", "getPreviewThumbBorderView", "()Landroid/view/View;", "deletePreviewThumbButton", "Landroid/widget/ImageButton;", "getDeletePreviewThumbButton", "()Landroid/widget/ImageButton;", "largeStyleApplied", "", "Ljava/lang/Boolean;", "applyUnifiedStyle", "", "enabled", "dp", "", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultPreviewThumbHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f322094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f322095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f322096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageButton f322097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f322098e;

    public ResultPreviewThumbHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f322094a = (ImageView) r100.findViewById(R.id.iv_preview_thumb);
        this.f322095b = (ImageView) r100.findViewById(R.id.iv_preview_marked);
        this.f322096c = r100.findViewById(R.id.iv_preview_thumb_border);
        this.f322097d = (ImageButton) r100.findViewById(R.id.btn_delete_preview_thumb);
    }

    public final int T3(int r100) {
        Resources r101 = this.itemView.getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }
}
