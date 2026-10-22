package com.larksuite.component.blockit.hashtag.list;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283044a;

    public c(b r100) {
        this.f283044a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        HashTagSwipeAdapter r102 = this.f283044a.f283043e;
        if (r102 == null) goto L6;
        r102.y2();
        return;
    }
}
