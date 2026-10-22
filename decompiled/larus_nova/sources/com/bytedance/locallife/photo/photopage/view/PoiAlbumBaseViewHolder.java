package com.bytedance.locallife.photo.photopage.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class PoiAlbumBaseViewHolder extends RecyclerView.ViewHolder {
    public abstract void T3(int r100);

    public abstract void U3();

    public abstract void V3();

    public abstract void W3();

    public abstract void X3();

    public abstract void Y3();

    public abstract void u();

    public PoiAlbumBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
