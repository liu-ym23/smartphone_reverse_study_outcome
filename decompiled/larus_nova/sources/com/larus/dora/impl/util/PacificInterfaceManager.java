package com.larus.dora.impl.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraPreWakeUpTask;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class PacificInterfaceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function1<? super Boolean, Unit> f338120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f338121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f338122c;

    static {
    }

    public static void a(String r100) {
        ILoginService r101 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r101 == null) goto L8;
        q38.a r102 = r101.getAccountInfo();
        if (r102 == null) goto L8;
        String r103 = r102.f531530c;
        if (r103 == null) goto L8;
    L9:
        PolarisFileWrapper r104 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "wakeup_sid");
        if (r104.exists() == true) goto L12;
        return;
    L12:
        final String r105 = "sid_feature_" + r103 + '_' + r100 + '_';
        File[] r106 = r104.listFiles(new m0(r105));
        if (r106 == null) goto L22;
        int r107 = r106.length;
        int r108 = 0;
    L15:
        if (r108 >= r107) goto L28;
        r106[r108].delete();     // Catch: Exception -> L19
        g49.d.d("PacificInterfaceManager", "clearFeatureFile success");     // Catch: Exception -> L19
    L21:
        r108 = r108 + 1;
    L19:
        e = move-exception;
        g49.d.b("PacificInterfaceManager", "clearFeatureFile failed: " + e.getMessage());
        goto L21
    L28:
        return;
    L22:
        return;
    L8:
        r103 = "unknown";
        goto L9
    }

    public static void d(final boolean r100) {
        g49.d.d("PacificInterfaceManager", "setModelReady: " + r100);
        f338121b = r100;
        com.larus.utils.y.c(new o0(r100));
    }

    public static void e(com.larus.dora.impl.settings.voiceprint.e r100) {
        StringBuilder r101 = new StringBuilder("setModelReadyListener: ");
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        g49.d.d("PacificInterfaceManager", r101.toString());
        f338120a = r100;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static String f(String r100) {
        if (r100 == null) goto L4;
        byte[] r101 = r100.getBytes(StandardCharsets.UTF_8);
    L6:
        return g(r101);
    L4:
        r101 = null;
        goto L6
    }

    public static String g(byte[] r110) {
        if (r110 != null) goto L4;
    L13:
        return null;
    L4:
        if (r110.length != 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L13;
        byte[] r101 = MessageDigest.getInstance("SHA-256").digest(r110);     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L11
        return ArraysKt.joinToString$default(r101, "", null, null, 0, null, new n0(), 30, null);
    L11:
        e = move-exception;
        g49.d.c("PacificInterfaceManager", "sha256 error", e);
        goto L13
    L6:
        r100 = false;
        goto L7
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        String r102 = f(r100);
        if (r102 == null) goto L6;
        r100 = r102;
    L6:
        IVoiceEnrollService r103 = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
        if (r103 == null) goto L9;
        boolean r104 = r103.a(r100);
    L10:
        g49.d.d("PacificInterfaceManager", "getDeviceEnrollStatusLocalCache local:" + r104);
        if (r104 == false) goto L13;
        int r105 = DoraPreWakeUpTask.f331888d;
        DoraPreWakeUpTask.Companion.m();
    L13:
        return r104;
    L9:
        r104 = false;
        goto L10
    }

    public static Object b(String r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PacificInterfaceManager$getDeviceEnrollStatus$2(r100, r101, null), r102);
    }

    public static void h(String r100, String r110, String r111) {
        g49.d.d("PacificInterfaceManager", "updateWakeupFingerPrintModelPath: firstKwsModelPath=" + r100 + ", sidEnrollModelPath=" + r110 + ", silentFilePath=" + r111);
        Job r101 = f338122c;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        f338122c = null;
        boolean r102 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L29;
        if (r110 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L29;
        if (r111 != null) goto L22;
    L25:
        boolean r105 = true;
    L26:
        if (r105 == false) goto L29;
        d(false);
        return;
    L22:
        if (r111.length() == 0) goto L25;
        r105 = false;
        goto L26
    L15:
        if (r110.length() == 0) goto L18;
        r104 = false;
    L29:
        if (r111 != null) goto L31;
    L32:
        r102 = true;
    L33:
        if (r102 == true) goto L38;
        IVoiceEnrollService.f273709a.getClass();
        IVoiceEnrollService r106 = IVoiceEnrollService.a.a();
        if (r106 == null) goto L37;
        r106.b(r100, r110, r111);
    L37:
        ObricDoraDelegate.f392872b.b(r100, r110, r111);
        d(true);
        return;
    L38:
        g49.d.d("PacificInterfaceManager", "silentFilePath is empty, start retry check");
        f338122c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PacificInterfaceManager$updateWakeupFingerPrintModelPath$1(r100, r110, null), 3, null);
        return;
    L31:
        if (r111.length() != 0) goto L33;
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
