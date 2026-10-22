package com.bytedance.locallife.photo.photopage.fragment;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes21.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumFragment f262216a;

    public o(PoiAlbumFragment r100) {
        this.f262216a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L7:
        RecyclerView r102 = this.f262216a.f262180f;
        if (r102 == null) goto L10;
        r102.setPadding(0, r101.intValue(), 0, 0);
    L10:
        RecyclerView r103 = this.f262216a.f262180f;
        if (r103 == null) goto L15;
        r103.scrollToPosition(0);
        return;
    L15:
        return;
    L6:
        if (r101.intValue() != 0) goto L7;
    }
}
