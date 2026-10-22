package com.ss.android.lark.thirdshare.base.export.util;

import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements u6c.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareEntity f441231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f441232b;

    @Override // u6c.c.InterfaceC7842c
    public final void a(File r100) {
        if (this.f441231a.getCallback() == null) goto L5;
        this.f441231a.getCallback().onSuccess(this.f441231a.getCurActionType());
    L5:
        Runnable r101 = this.f441232b;
        if (r101 == null) goto L9;
        r101.run();
        return;
    }

    @Override // u6c.c.InterfaceC7842c
    public final void b(String r100) {
        if (this.f441231a.getCallback() == null) goto L6;
        this.f441231a.getCallback().onFailed(this.f441231a.getCurActionType(), OnShareCallback.SAVE_FAILED.appendMsg(r100));
        return;
    }

    public k(ShareEntity r100, d r101) {
        this.f441231a = r100;
        this.f441232b = r101;
    }
}
