package com.ss.android.lark.widget.photo.preview.image;

import android.view.View;
import com.ss.android.lark.widget.photo.preview.adapter.PhotoPagerAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeImageFragment f446667a;

    public g(LargeImageFragment r100) {
        this.f446667a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        PhotoPagerAdapter.b r101 = this.f446667a.f446638o;
        if (r101 == null) goto L7;
        r101.a();
        return true;
    L7:
        return true;
    }
}
