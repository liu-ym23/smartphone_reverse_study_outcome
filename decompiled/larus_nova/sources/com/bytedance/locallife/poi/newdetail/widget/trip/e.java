package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiHeadViewHolder f263678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadAdapter f263679c;

    public e(View r100, PoiHeadViewHolder r101, TripPoiHeadAdapter r102) {
        this.f263677a = r100;
        this.f263678b = r101;
        this.f263679c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263677a) == false) goto L5;
        return;
    L5:
        int r101 = this.f263678b.getAdapterPosition();
        if (r101 < 0) goto L19;
        List<? extends PoiPhoto> r102 = this.f263679c.f263533i;
        if (r102 == null) goto L10;
        int r103 = r102.size();
    L11:
        if (r101 >= r103) goto L20;
        TripPoiHeadAdapter r104 = this.f263679c;
        f r105 = r104.f263531g;
        if (r105 == null) goto L15;
        List<? extends PoiPhoto> r106 = r104.f263533i;
        Intrinsics.checkNotNull(r106);
        r105.d(r101, (PoiPhoto) ListProtector.get(r106, r101), this.f263678b.V3());
    L15:
        s r107 = this.f263679c.f263532h;
        if (r107 == null) goto L21;
        r107.c();
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r103 = 0;
        goto L11
    }
}
