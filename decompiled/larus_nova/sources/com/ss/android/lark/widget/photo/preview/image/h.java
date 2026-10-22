package com.ss.android.lark.widget.photo.preview.image;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.photo.preview.adapter.PhotoPagerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeImageFragment f446668a;

    public h(LargeImageFragment r100) {
        this.f446668a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PhotoPagerAdapter.b r101 = this.f446668a.f446638o;
        boolean r102 = false;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (r101.onClick(r100) != true) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L10;
        return;
    L10:
        if ((this.f446668a.getContext() instanceof Activity) == false) goto L15;
        Context r103 = this.f446668a.getContext();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) r103).isFinishing() == true) goto L16;
        Context r104 = this.f446668a.getContext();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r104).onBackPressed();
        return;
    L16:
        return;
    }
}
