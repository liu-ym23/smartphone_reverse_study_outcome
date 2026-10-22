package com.bytedance.ee.bear.content.common.morepanel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000bJ\"\u0010\u0019\u001a\u00020\u00132\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/content/common/morepanel/ViewHolder;", "<init>", "()V", "mData", "", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "mContext", "Landroid/content/Context;", "mListener", "Lcom/bytedance/ee/bear/content/common/morepanel/OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "initBackground", "setOnItemClickListener", "listener", "updateData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonPanelAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<CommonMorePanelItemData> a;
    public Context b;
    public hw4.d c;

    public final int getItemCount() {
        return this.a.size();
    }

    public CommonPanelAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        ViewHolder r12 = (ViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        CommonMorePanelItemData r0 = (CommonMorePanelItemData) ListProtector.get(this.a, r11);
        int r1 = getItemCount();
        if (r11 != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r11 != (r1 - 1)) goto L9;
        boolean r2 = true;
    L10:
        if (r4 == false) goto L13;
        if (r2 == false) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        int r3 = 2131235311;
    L21:
        ((RecyclerView.ViewHolder) r12).itemView.setBackgroundResource(r3);
        View r6 = ((RecyclerView.ViewHolder) r12).itemView;
        Context r7 = this.b;
        ViewGroup.LayoutParams r8 = null;
        if (r7 == null) goto L26;
        Resources r9 = r7.getResources();
        if (r9 == null) goto L26;
        ColorStateList r13 = r9.getColorStateList(2131101932);
    L27:
        r6.setBackgroundTintList(r13);
        if (r0.b <= 0) goto L35;
        ImageView r14 = r12.a;
        if (r14 == null) goto L32;
        r14.setVisibility(0);
    L32:
        ImageView r16 = r12.a;
        if (r16 == null) goto L39;
        r16.setImageResource(r0.b);
    L39:
        if (r0.d <= 0) goto L46;
        ImageView r17 = r12.c;
        if (r17 == null) goto L43;
        r17.setVisibility(0);
    L43:
        ImageView r18 = r12.c;
        if (r18 == null) goto L50;
        r18.setImageResource(r0.d);
    L50:
        if (r0.f == false) goto L59;
        l.c(r12.a, 2131102418);
        l.c(r12.c, 2131102418);
        Context r19 = this.b;
        if (r19 == null) goto L68;
        TextView r20 = r12.b;
        if (r20 == null) goto L56;
        r20.setTextColor(r19.getResources().getColor(2131106622));
    L56:
        TextView r21 = r12.d;
        if (r21 == null) goto L68;
        r21.setTextColor(r19.getResources().getColor(2131106607));
    L68:
        if (r0.g <= 0) goto L76;
        ImageView r22 = r12.c;
        if (r22 == null) goto L72;
        r8 = r22.getLayoutParams();
    L72:
        if (r8 == null) goto L76;
        int r23 = r0.g;
        r8.height = r23;
        r8.width = r23;
        ImageView r24 = r12.c;
        if (r24 == null) goto L76;
        r24.setLayoutParams(r8);
    L76:
        int r26 = r0.h;
        if (r26 <= 0) goto L79;
        l.c(r12.c, r26);
    L79:
        TextView r27 = r12.b;
        if (r27 == null) goto L82;
        r27.setText(r0.c);
    L82:
        TextView r28 = r12.d;
        if (r28 == null) goto L86;
        r28.setText(r0.e);
    L86:
        if (r11 != (this.a.size() - 1)) goto L90;
        View r29 = r12.e;
        if (r29 == null) goto L93;
        r29.setVisibility(8);
    L93:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new hw4.c(r0, this, r11));
        return;
    L90:
        View r30 = r12.e;
        if (r30 == null) goto L93;
        r30.setVisibility(0);
        goto L93
    L59:
        l.c(r12.a, 2131102417);
        l.c(r12.c, 2131102417);
        Context r31 = this.b;
        if (r31 == null) goto L68;
        TextView r32 = r12.b;
        if (r32 == null) goto L64;
        r32.setTextColor(r31.getResources().getColor(2131106611));
    L64:
        TextView r33 = r12.d;
        if (r33 == null) goto L68;
        r33.setTextColor(r31.getResources().getColor(2131106611));
        goto L68
    L46:
        ImageView r34 = r12.c;
        if (r34 == null) goto L50;
        r34.setVisibility(8);
        goto L50
    L35:
        ImageView r36 = r12.a;
        if (r36 == null) goto L39;
        r36.setVisibility(8);
    L26:
        r13 = null;
        goto L27
    L16:
        if (r4 == false) goto L18;
        r3 = 2131235323;
        goto L21
    L18:
        if (r2 == false) goto L20;
        r3 = 2131235317;
        goto L21
    L20:
        r3 = 2131235305;
    L13:
        r5 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        this.b = r4.getContext();
        return new ViewHolder(LayoutInflater.from(this.b).inflate(2131559892, r4, false));
    }
}
