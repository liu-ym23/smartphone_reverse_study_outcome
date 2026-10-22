package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.databinding.BitableCardLinkTagOptionItemBinding;
import com.bytedance.ee.bear.bitable.databinding.BitableCardLinkTagOptionLoadingItemBinding;
import com.bytedance.ee.bear.facade.common.widget.InterceptTouchEventLinearLayout;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000e\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionModel;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "hasMore", "", "enableMultiSelect", "setData", "data", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "Companion", "OptionViewHolder", "LoadingViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkTagOptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardLinkTagOptionLoadingItemBinding;", "<init>", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableCardLinkTagOptionLoadingItemBinding;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(BitableCardLinkTagOptionLoadingItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f210668a);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionAdapter$OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardLinkTagOptionItemBinding;", "<init>", "(Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionAdapter;Lcom/bytedance/ee/bear/bitable/databinding/BitableCardLinkTagOptionItemBinding;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionModel;", "getSafeTitle", "", "rawTitle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OptionViewHolder extends RecyclerView.ViewHolder {
        public OptionViewHolder(LinkTagOptionAdapter r100, BitableCardLinkTagOptionItemBinding r101) {
            Intrinsics.checkNotNullParameter(r101, "binding");
            super(r101.f210667a);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof OptionViewHolder) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 2) goto L9;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_card_link_tag_option_loading_item, r100, false);
        if (r102 == null) goto L8;
        return new LoadingViewHolder(new BitableCardLinkTagOptionLoadingItemBinding((FrameLayout) r102));
    L8:
        throw new NullPointerException("rootView");
    L9:
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_card_link_tag_option_item, r100, false);
        int r104 = R.id.checkBox;
        UDCheckBox r105 = (UDCheckBox) ViewBindings.findChildViewById(r103, R.id.checkBox);
        if (r105 == null) goto L16;
        r104 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.title);
        if (r106 == null) goto L16;
        return new OptionViewHolder(this, new BitableCardLinkTagOptionItemBinding((InterceptTouchEventLinearLayout) r103, r105, r106));
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
