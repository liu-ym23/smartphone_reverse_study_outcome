package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f429773a = null;

    static {
        f429773a = new e();
    }

    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = UIHelper.mustacheFormat(R.string.Lark_IM_InsufficientStorageUnableToSendImageOrVideo_Toast1, "type", UIHelper.getString(R.string.Lark_IM_InsufficientStorageUnableToSendImage_Variable));     // Catch: Throwable -> L5
        Context r101 = UIHelper.getContext();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L5
        UDToast.makeToast(r101, r100).show();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
