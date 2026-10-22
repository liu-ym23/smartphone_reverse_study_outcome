package com.bytedance.ee.bear.middleground.permission.transfer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti5.a;
import ti5.b;
import ti5.c;
import ti5.d;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyData;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/middleground/permission/transfer/IItemClickListener;", "setClickListener", "", "convert", "helper", MapController.ITEM_LAYER_TAG, "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferApplyAdapter extends BaseQuickAdapter<d, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f234284a;

    public TransferApplyAdapter() {
        super(R.layout.transfer_apply_item, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, d r101) {
        d r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        r100.setText(R.id.permissionName, r102.f546117e).setChecked(R.id.checkBox, r102.f546114b).setVisible(R.id.permissionTag, r102.f546116d).setVisible(R.id.permissionIcon, r102.f546116d).setGone(R.id.divider, r102.f546118f);
        r100.itemView.setOnClickListener(new b(this, r102));
        ((LinearLayout) r100.itemView.findViewById(R.id.permissionRoot)).setOnClickListener(new c(this, (TextView) r100.itemView.findViewById(R.id.permissionTag)));
        int r103 = r100.getLayoutPosition();
        Context r104 = r100.itemView.getContext();
        int r105 = UIUtils.getColor(r104, R.color.bg_body);
        Intrinsics.checkNotNull(r104);
        float r106 = h18.d.b(r104, 10);
        boolean r107 = false;
        if (r103 != 0) goto L5;
        boolean r108 = true;
    L7:
        if (r103 != (getData().size() - 1)) goto L9;
        boolean r109 = true;
    L10:
        if (r108 == false) goto L14;
        if (r109 == false) goto L14;
        r107 = true;
    L14:
        if (r107 == false) goto L16;
        GradientDrawable r110 = lp5.a.b(r105, r106, null);
    L21:
        r100.itemView.setBackground(r110);
        return;
    L16:
        if (r108 == false) goto L18;
        r110 = lp5.a.g(r105, r106, null);
        goto L21
    L18:
        if (r109 == false) goto L20;
        r110 = lp5.a.a(r105, r106, null);
        goto L21
    L20:
        r110 = lp5.a.e(r105, null);
        goto L21
    L9:
        r109 = false;
        goto L10
    L5:
        r108 = false;
        goto L7
    }
}
