package com.bytedance.locallife.photo.photopage.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumHorizontalTag.PoiAlbumHorizontalTagViewHolder f262326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumHorizontalTag.PoiAlbumHorizontalTagAdapter f262327b;

    public b(PoiAlbumHorizontalTag.PoiAlbumHorizontalTagViewHolder r100, PoiAlbumHorizontalTag.PoiAlbumHorizontalTagAdapter r101) {
        this.f262326a = r100;
        this.f262327b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f262326a.getAdapterPosition();
        PoiAlbumHorizontalTag.PoiAlbumHorizontalTagAdapter r102 = this.f262327b;
        int r103 = r102.f262245c;
        if (r101 == r103) goto L11;
        if (r103 == r101) goto L7;
        r102.f262245c = r101;
        r102.notifyItemChanged(r103);
        r102.notifyItemChanged(r102.f262245c);
        r102.f262243a.smoothScrollToPosition(r101);
    L7:
        Function1<? super Integer, Unit> r104 = this.f262327b.f262246d;
        if (r104 == null) goto L12;
        r104.invoke(Integer.valueOf(r101));
        return;
    L12:
        return;
    }
}
