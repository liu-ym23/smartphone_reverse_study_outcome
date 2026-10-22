package com.bytedance.ee.bear.middleground.permission.transfer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.framework.utils.UIUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti5.a;
import ti5.b;
import ti5.c;
import ti5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyData;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/middleground/permission/transfer/IItemClickListener;", "setClickListener", "", "convert", "helper", "item", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferApplyAdapter extends BaseQuickAdapter<d, BaseViewHolder> {
    public a a;

    public TransferApplyAdapter() {
        super(2131565100, new ArrayList());
    }

    public final void convert(BaseViewHolder r7, Object r8) {
        d r9 = (d) r8;
        Intrinsics.checkNotNullParameter(r7, "helper");
        Intrinsics.checkNotNullParameter(r9, "item");
        r7.setText(2131382152, r9.e).setChecked(2131365627, r9.b).setVisible(2131382154, r9.d).setVisible(2131382151, r9.d).setGone(2131369197, r9.f);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new b(this, r9));
        ((LinearLayout) ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131382153)).setOnClickListener(new c(this, (TextView) ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131382154)));
        int r10 = r7.getLayoutPosition();
        Context r0 = ((RecyclerView.ViewHolder) r7).itemView.getContext();
        int r1 = UIUtils.getColor(r0, 2131100548);
        Intrinsics.checkNotNull(r0);
        float r2 = h18.d.b(r0, 10);
        boolean r3 = false;
        if (r10 != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r10 != (getData().size() - 1)) goto L9;
        boolean r11 = true;
    L10:
        if (r4 == false) goto L14;
        if (r11 == false) goto L14;
        r3 = true;
    L14:
        if (r3 == false) goto L16;
        GradientDrawable r12 = lp5.a.b(r1, r2, null);
    L21:
        ((RecyclerView.ViewHolder) r7).itemView.setBackground(r12);
        return;
    L16:
        if (r4 == false) goto L18;
        r12 = lp5.a.g(r1, r2, null);
        goto L21
    L18:
        if (r11 == false) goto L20;
        r12 = lp5.a.a(r1, r2, null);
        goto L21
    L20:
        r12 = lp5.a.e(r1, null);
        goto L21
    L9:
        r11 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }
}
