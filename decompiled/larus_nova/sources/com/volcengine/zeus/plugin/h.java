package com.volcengine.zeus.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.PluginGroundProvider;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f462808a;

    public h(boolean r100) {
        this.f462808a = r100;
    }

    public final void a() {
        Set<String> r100 = i.f462809a;
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        PluginGroundProvider r101 = GlobalParam.getInstance().getPluginGroundProvider();
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();
        boolean r104 = false;
        if (r101 == null) goto L11;
        boolean r105 = r101.isForeground(r103);
    L13:
        if (this.f462808a == true) goto L15;
        if (r105 == false) goto L15;
    L16:
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "PluginReloadManager checkAndReload: " + r103 + ", isForeground=" + r105 + ", shouldReload=" + r104);
        if (r104 == false) goto L7;
        i.a(r103);     // Catch: Exception -> L20
    L22:
        r102.remove();
    L20:
        e = move-exception;
        e.printStackTrace();
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginReloadManager force-stop app processes failed, plugin=" + r103, e);
    L15:
        r104 = true;
        goto L16
    L11:
        r105 = false;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
