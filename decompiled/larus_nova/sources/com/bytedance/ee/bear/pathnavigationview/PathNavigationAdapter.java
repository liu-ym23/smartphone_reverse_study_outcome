package com.bytedance.ee.bear.pathnavigationview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kl5.a;
import kl5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ\u001d\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter;", "M", "Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationModel;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;", "<init>", "()V", "itemClickListener", "Lcom/bytedance/ee/bear/pathnavigationview/PathNodeClickListener;", "setNodeClickListener", "", "listener", "convert", "helper", MapController.ITEM_LAYER_TAG, "(Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationModel;)V", "Companion", "NodeViewHolder", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathNavigationAdapter<M extends kl5.a> extends BaseQuickAdapter<M, NodeViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b<M> f236232a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationAdapter$NodeViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NodeViewHolder extends BaseViewHolder {
        public NodeViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    public PathNavigationAdapter() {
        super(R.layout.biz_widget_path_navigation_item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r101) {
        NodeViewHolder r102 = (NodeViewHolder) r100;
        kl5.a r103 = (kl5.a) r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = getData().indexOf(r103);
        boolean r105 = true;
        if (r104 == (getData().size() - 1)) goto L6;
        r105 = false;
    L6:
        if (r105 == false) goto L8;
        int r106 = R.color.text_caption;
    L9:
        ((TextView) r102.itemView.findViewById(R.id.navigationNodeName)).setTextColor(r102.itemView.getResources().getColor(r106));
        ImageView r107 = (ImageView) r102.itemView.findViewById(R.id.navigationNodeNext);
        if (r105 == false) goto L12;
        int r108 = 8;
    L13:
        r107.setVisibility(r108);
        r102.itemView.setClickable(!r105);
        ((TextView) r102.itemView.findViewById(R.id.navigationNodeName)).setText(r103.getName());
        r102.itemView.setOnClickListener(new com.bytedance.ee.bear.pathnavigationview.a(r105, this, r104, r103));
        if (r104 != 0) goto L16;
        r102.itemView.setPadding(n.d(16), 0, 0, 0);
        return;
    L16:
        if (r105 == false) goto L18;
        r102.itemView.setPadding(0, 0, n.d(16), 0);
        return;
    L18:
        r102.itemView.setPadding(0, 0, 0, 0);
        return;
    L12:
        r108 = 0;
        goto L13
    L8:
        r106 = R.color.primary_fill_default;
        goto L9
    }
}
