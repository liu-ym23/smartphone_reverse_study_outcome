package com.bytedance.ee.bear.pathnavigationview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kl5.a;
import kl5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ\u001d\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter;", "M", "Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationModel;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;", "<init>", "()V", "itemClickListener", "Lcom/bytedance/ee/bear/pathnavigationview/PathNodeClickListener;", "setNodeClickListener", "", "listener", "convert", "helper", "item", "(Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationModel;)V", "Companion", "NodeViewHolder", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathNavigationAdapter<M extends kl5.a> extends BaseQuickAdapter<M, NodeViewHolder> {
    public b<M> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NodeViewHolder extends BaseViewHolder {
        public NodeViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public PathNavigationAdapter() {
        super(2131559199);
    }

    public final void convert(BaseViewHolder r7, Object r8) {
        NodeViewHolder r9 = (NodeViewHolder) r7;
        kl5.a r10 = (kl5.a) r8;
        Intrinsics.checkNotNullParameter(r9, "helper");
        Intrinsics.checkNotNullParameter(r10, "item");
        int r0 = getData().indexOf(r10);
        boolean r2 = true;
        if (r0 == (getData().size() - 1)) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        int r1 = 2131106607;
    L9:
        ((TextView) ((RecyclerView.ViewHolder) r9).itemView.findViewById(2131380636)).setTextColor(((RecyclerView.ViewHolder) r9).itemView.getResources().getColor(r1));
        ImageView r3 = (ImageView) ((RecyclerView.ViewHolder) r9).itemView.findViewById(2131380637);
        if (r2 == false) goto L12;
        int r4 = 8;
    L13:
        r3.setVisibility(r4);
        ((RecyclerView.ViewHolder) r9).itemView.setClickable(!r2);
        ((TextView) ((RecyclerView.ViewHolder) r9).itemView.findViewById(2131380636)).setText(r10.getName());
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new com.bytedance.ee.bear.pathnavigationview.a(r2, this, r0, r10));
        if (r0 != 0) goto L16;
        ((RecyclerView.ViewHolder) r9).itemView.setPadding(n.d(16), 0, 0, 0);
        return;
    L16:
        if (r2 == false) goto L18;
        ((RecyclerView.ViewHolder) r9).itemView.setPadding(0, 0, n.d(16), 0);
        return;
    L18:
        ((RecyclerView.ViewHolder) r9).itemView.setPadding(0, 0, 0, 0);
        return;
    L12:
        r4 = 0;
        goto L13
    L8:
        r1 = 2131105548;
        goto L9
    }
}
