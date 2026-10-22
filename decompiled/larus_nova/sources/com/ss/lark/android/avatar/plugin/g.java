package com.ss.lark.android.avatar.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.pb.chatters.PutResetUserAvatarResultRequest;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f456654a;

    public g(b r100) {
        this.f456654a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b r102 = this.f456654a;
        b.b(r102, r102.f456644h, PutResetUserAvatarResultRequest.Status.ABORT);
    }
}
