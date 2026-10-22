package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagSelectedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagSelectedAdapter$ViewHolder;", "onRemove", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionModel;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "baseDesign", "", "setData", "data", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "Companion", "ViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkTagSelectedAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209398a = 0;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagSelectedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagSelectedAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionModel;", "getSafeTitle", "", "rawTitle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f209399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f209400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkTagSelectedAdapter f209401c;

        public ViewHolder(LinkTagSelectedAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
            this.f209401c = r100;
            super(r101);
            this.f209399a = r101;
            this.f209400b = (TextView) r101.findViewById(R.id.title);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        LinkTagOptionModel r103 = (LinkTagOptionModel) ListProtector.get(null, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        TextView r104 = r102.f209400b;
        String r105 = r103.getText();
        if (r105 != null) goto L6;
        r105 = r102.f209399a.getContext().getString(R.string.Doc_Block_UnnamedRecord);
    L6:
        if (r105.length() <= 200) goto L8;
        r105 = r105.substring(0, 200);
    L8:
        r104.setText(r105);
        r102.f209399a.setOnClickListener(new d(r102.f209401c, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_card_link_tag_selected_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(this, r102);
    }
}
