package com.larus.bmhome.chat.markdown.vlm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.im.bean.message.VLMImage;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusVlmImageItemViewBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import th8.a;
import th8.d;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J&\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J6\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/VlmImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "vlmWidgetService", "Lcom/larus/bmhome/chat/markdown/vlm/IVlmImageWidgetService;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Lcom/larus/bmhome/chat/markdown/vlm/IVlmImageWidgetService;)V", "vlmImageRenderInfoList", "", "Lcom/larus/bmhome/chat/markdown/vlm/VlmImageRenderInfo;", "getVlmImageRenderInfoList", "()Ljava/util/List;", "setVlmImageRenderInfoList", "(Ljava/util/List;)V", "getDataByPosition", "index", "", "setUpRenderInfoList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "mobCardShow", "image", "Landroid/view/View;", "imageItem", "realMobCardShow", "cardId", "", "targetWidth", "targetHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmImageAdapter extends RecyclerView.Adapter<VlmImageViewHolder> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r111) {
        VlmImageViewHolder r112 = (VlmImageViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        final d r100 = (d) CollectionsKt.getOrNull(null, r111);
        final SimpleDraweeView r101 = r112.f307322a.f358825b;
        if (RenderType.Picture != null) goto L7;
        r100.getClass();
        VLMImage r102 = (VLMImage) CollectionsKt.getOrNull(null, 0);
        if (r102 == null) goto L7;
        final Long r103 = r102.getCardId();
    L8:
        if (r101 == null) goto L10;
        ExposureTrackerExtKt.a(r101, new a(r103, this, r100, r101, r111));
    L10:
        if (r100 != null) goto L13;
        e1.o(r112.f307322a.f358824a);
        return;
    L13:
        e1.x(r112.f307322a.f358824a);
        ConstraintLayout r113 = r112.f307322a.f358824a;
        throw null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_vlm_image_item_view, null, false);
        int r111 = R.id.mainImage;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.mainImage);
        if (r102 == null) goto L15;
        r111 = R.id.moreImageSize;
        RoundTextView r103 = (RoundTextView) ViewBindings.findChildViewById(r101, R.id.moreImageSize);
        if (r103 == null) goto L15;
        r111 = R.id.sourceView;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.sourceView);
        if (r104 == null) goto L15;
        r111 = R.id.videoCaptionTextView;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.videoCaptionTextView);
        if (r105 == null) goto L15;
        r111 = R.id.videoIcon;
        View r106 = ViewBindings.findChildViewById(r101, R.id.videoIcon);
        if (r106 == null) goto L15;
        return new VlmImageViewHolder(this, new LarusVlmImageItemViewBinding((ConstraintLayout) r101, r102, r103, r104, r105, r106));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }
}
