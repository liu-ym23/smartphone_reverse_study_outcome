package com.obric.datatransfer.client;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.UserManager;
import com.bytedance.common.utility.device.SystemPropertiesUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.obric.datatransfer.logger.TransferLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f396672d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f396674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TransferLogger f396675c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.datatransfer.client.b$b, reason: collision with other inner class name */
    public interface InterfaceC4651b {
        void onComplete(int r100, int r101);

        void onProgress(int r100, int r101);
    }

    static {
    }

    public final void b() {
        int r100 = 0;
    L4:
        if (r100 >= 30) goto L20;
        r100 = r100 + 1;
        TransferLogger.c(this.f396675c, "Waiting for sys.boot_completed...");
        String r101 = SystemPropertiesUtils.getSystemProperty("sys.boot_completed");     // Catch: Exception -> L18
        if (r101 == null) goto L20;
        if (Intrinsics.areEqual(r101, "1") == true) goto L11;
        Thread.sleep(1000);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        this.f396675c.d("Interrupted while waiting for boot completed", e);
        goto L20
    L11:
        TransferLogger.c(this.f396675c, "sys.boot_completed is 1");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        this.f396675c.b("Failed to get sys.boot_completed", e);
    L20:
        TransferLogger.c(this.f396675c, "Boot completed after " + r100 + " retries");
    }

    public final void c() {
        UserManager r100 = (UserManager) this.f396673a.getSystemService(UserManager.class);
        int r101 = 0;
    L4:
        if (r100.isUserUnlocked() == true) goto L12;
        if (r101 >= 30) goto L12;
        r101 = r101 + 1;
        TransferLogger.c(this.f396675c, "Waiting for user unlock...");
        Thread.sleep(1000);     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        this.f396675c.d("Interrupted while waiting for user unlock", e);
    L12:
        TransferLogger.c(this.f396675c, "User unlocked, CE storage available after " + r101 + " retries");
    }

    public b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "authority");
        this.f396673a = r100;
        this.f396674b = r101;
        com.obric.datatransfer.logger.a r102 = TransferLogger.f396682b;
        this.f396675c = TransferLogger.a.a("DataTransferClient");
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
