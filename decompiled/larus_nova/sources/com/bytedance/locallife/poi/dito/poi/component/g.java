package com.bytedance.locallife.poi.dito.poi.component;

import android.view.View;
import com.bytedance.locallife.poi.dito.poi.entity.PoiTag;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f262512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiDetailTagViewHolder f262513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PoiDetailTagAdapter f262514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f262515d;

    public g(View r100, PoiDetailTagViewHolder r101, PoiDetailTagAdapter r102, View r103) {
        this.f262512a = r100;
        this.f262513b = r101;
        this.f262514c = r102;
        this.f262515d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f262512a) == false) goto L5;
        return;
    L5:
        int r101 = this.f262513b.getAdapterPosition();
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (r101 < this.f262514c.getItemCount()) goto L10;
        return;
    L10:
        if (this.f262514c.f262440d.invoke(Integer.valueOf(r101), (PoiTag) ListProtector.get(this.f262514c.f262437a, r101)).booleanValue() == false) goto L15;
        PoiDetailTagAdapter r102 = this.f262514c;
        int r103 = r102.f262438b;
        r102.f262438b = r101;
        r102.notifyItemChanged(r103);
        PoiDetailTagAdapter r104 = this.f262514c;
        r104.notifyItemChanged(r104.f262438b);
        this.f262515d.post(new h(this.f262514c, r101));
        return;
    }
}
