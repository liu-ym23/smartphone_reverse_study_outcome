package com.larksuite.component.blockit.hashtag.list;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283047a;

    public e(b r100) {
        this.f283047a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        HashTagSwipeAdapter r102 = this.f283047a.f283043e;
        if (r102 == null) goto L6;
        r102.y2();
        return;
    }
}
