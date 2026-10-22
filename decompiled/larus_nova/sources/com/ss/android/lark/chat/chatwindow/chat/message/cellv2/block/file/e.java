package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f413149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f413150b;

    public e(g r100, Context r101) {
        this.f413149a = r100;
        this.f413150b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f413149a.showToast(UIUtils.getString(this.f413150b, R.string.Lark_IM_ViewOrDownloadFile_FileDeleted_Text));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
