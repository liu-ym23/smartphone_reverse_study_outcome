package com.ss.android.lark.feed.shared.page;

import android.content.DialogInterface;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f421420a = null;

    static {
        f421420a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.ss.android.lark.feed.shared.hitpoint.a.b(false);
        FeedHitPointNew.a(FeedHitPointNew.FeedDelayedPopupClickParam.ESC);
    }
}
