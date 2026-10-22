package com.larus.canvas.feature.component.instruction.ui;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "optionCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "optionName", "Landroid/widget/TextView;", "optionCardMask", "Landroid/widget/FrameLayout;", "optionCoverLoading", "Landroid/widget/ProgressBar;", "optionCoverMask", "optionIconContainer", "optionIconLoading", "optionIcon", "darkIconLoadingDrawable", "Landroid/graphics/drawable/Drawable;", "lightIconLoadingDrawable", "bindData", "", "data", "Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasOptionListHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f323173k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f323174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f323175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f323176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f323177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f323178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f323179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f323180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDraweeView f323181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable f323182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f323183j;

    public CanvasOptionListHolder(RadiusCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f323174a = (SimpleDraweeView) r100.findViewById(R.id.image_option_cover);
        this.f323175b = (TextView) r100.findViewById(R.id.tv_option_name);
        this.f323176c = (FrameLayout) r100.findViewById(R.id.option_card_mask);
        this.f323177d = (ProgressBar) r100.findViewById(R.id.option_cover_loading);
        this.f323178e = (FrameLayout) r100.findViewById(R.id.image_cover_loading_mask);
        this.f323179f = (FrameLayout) r100.findViewById(R.id.option_icon_container);
        this.f323180g = (ProgressBar) r100.findViewById(R.id.option_icon_loading);
        this.f323181h = (SimpleDraweeView) r100.findViewById(R.id.image_option_icon);
        this.f323182i = ContextCompat.getDrawable(r100.getContext(), R.drawable.larus_ic_common_download_loading_animated);
        this.f323183j = ContextCompat.getDrawable(r100.getContext(), R.drawable.larus_ic_common_download_loading_animated_black);
    }
}
