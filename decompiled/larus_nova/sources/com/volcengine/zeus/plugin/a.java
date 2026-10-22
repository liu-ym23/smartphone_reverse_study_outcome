package com.volcengine.zeus.plugin;

import android.content.Context;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f462771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f462772b;

    public a(Context r100, String r101) {
        this.f462771a = r100;
        this.f462772b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f462771a, "检测到内置插件与宿主版本不兼容，请处理后重试", 1).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier show toast failed. pluginPkgName=" + this.f462772b, th);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
