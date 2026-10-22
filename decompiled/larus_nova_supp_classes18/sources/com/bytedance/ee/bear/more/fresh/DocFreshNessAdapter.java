package com.bytedance.ee.bear.more.fresh;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import h18.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp5.a;
import pj5.g;
import pj5.h;
import pj5.i;
import pj5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/DocFreshNessAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/more/fresh/IItemClickListener;", "setClickListener", "", "convert", "helper", "item", "setUpdateTime", "setDesc", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFreshNessAdapter extends BaseQuickAdapter<i, BaseViewHolder> {
    public p a;

    public DocFreshNessAdapter() {
        super(2131561258, new ArrayList());
    }

    public final void convert(BaseViewHolder r11, Object r12) {
        i r13 = (i) r12;
        Intrinsics.checkNotNullParameter(r11, "helper");
        Intrinsics.checkNotNullParameter(r13, "item");
        int r2 = r11.getLayoutPosition();
        boolean r3 = true;
        if (r2 != 0) goto L5;
        boolean r5 = true;
    L7:
        if (r2 != (getData().size() - 1)) goto L9;
        boolean r4 = true;
    L10:
        if (r5 == false) goto L13;
        if (r4 == false) goto L13;
        boolean r6 = true;
    L14:
        BaseViewHolder r7 = r11.setText(2131385709, r13.b).setChecked(2131365627, r13.a);
        if (r6 == true) goto L18;
        if (r4 == true) goto L18;
    L19:
        r7.setVisible(2131369197, r3);
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new g(r13, this));
        Context r8 = ((RecyclerView.ViewHolder) r11).itemView.getContext();
        int r9 = n.h(r8, 2131100548);
        Intrinsics.checkNotNull(r8);
        float r10 = d.b(r8, 10);
        if (r6 == false) goto L22;
        GradientDrawable r14 = a.b(r9, r10, null);
    L27:
        ((RecyclerView.ViewHolder) r11).itemView.setBackground(r14);
        if (r13.d == false) goto L33;
        Intrinsics.checkNotNullParameter(r11, "helper");
        Intrinsics.checkNotNullParameter(r13, "item");
        TextView r15 = (TextView) r11.getView(2131373311);
        if (r13.a == true) goto L32;
        r15.setVisibility(8);
        goto L33
    L32:
        r15.setVisibility(0);
        r15.setText(r13.e);
    L33:
        Intrinsics.checkNotNullParameter(r11, "helper");
        Intrinsics.checkNotNullParameter(r13, "item");
        TextView r16 = (TextView) r11.getView(2131391891);
        if (r13.g == true) goto L36;
    L39:
        r16.setVisibility(8);
        return;
    L36:
        if (r13.a == false) goto L39;
        r16.setOnClickListener(new h(this, r13));
        r16.setVisibility(0);
        r16.setText(r16.getContext().getString(2131888831));
        return;
    L22:
        if (r5 == false) goto L24;
        r14 = a.g(r9, r10, null);
        goto L27
    L24:
        if (r4 == false) goto L26;
        r14 = a.a(r9, r10, null);
        goto L27
    L26:
        r14 = a.e(r9, null);
    L18:
        r3 = false;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }
}
