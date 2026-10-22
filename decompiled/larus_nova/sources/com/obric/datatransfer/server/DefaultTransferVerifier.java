package com.obric.datatransfer.server;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.datatransfer.logger.TransferLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class DefaultTransferVerifier implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Long> f396690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Long> f396691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f396692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TransferLogger f396693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DefaultTransferVerifier$receiver$1 f396694e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.datatransfer.server.DefaultTransferVerifier$receiver$1] */
    public DefaultTransferVerifier() {
        this.f396690a = Collections.synchronizedMap(new HashMap());
        this.f396691b = Collections.synchronizedMap(new HashMap());
        this.f396692c = new AtomicBoolean(false);
        com.obric.datatransfer.logger.a r100 = TransferLogger.f396682b;
        this.f396693d = TransferLogger.a.a("DefaultTransferVerifier");
        this.f396694e = new DefaultTransferVerifier$receiver$1(this);
    }

    @Override // com.obric.datatransfer.server.f
    public final boolean a(Context r210) {
        Context r100 = r210;
        String r101 = PerfLog.PARAM_KEY_CONTEXT_ID;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Throwable r102 = null;
        if (this.f396692c.compareAndSet(false, true) == false) goto L35;
        IntentFilter r110 = new IntentFilter();
        r110.addAction("android.intent.action.PACKAGE_ADDED");
        r110.addAction("android.intent.action.PACKAGE_REMOVED");
        r110.addAction("android.intent.action.PACKAGE_REPLACED");
        r110.addDataScheme("package");
        Context r103 = r210.getApplicationContext();
        DefaultTransferVerifier$receiver$1 r111 = this.f396694e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L149;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L149:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r110);
        goto L35
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L21;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r110, 0, null, null, 2, r103).result;     // Catch: Exception -> L30
        if (r104 != 1) goto L14;
        r103.registerReceiver(r111, r110);     // Catch: Exception -> L30
    L148:
        goto L35
    L14:
        if (r104 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L148
    L16:
        if (r104 == 3) goto L148;
        r103.registerReceiver(r111, r110);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r103.registerReceiver(r111, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L148
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r103.registerReceiver(r111, r110);     // Catch: Exception -> L30
        goto L148
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r103, r111, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
    L35:
        int r105 = Binder.getCallingUid();
        long r106 = System.currentTimeMillis();
        TransferLogger.a(this.f396693d, "verify: uid " + r105 + " is calling");
        Long r107 = this.f396690a.get(Integer.valueOf(r105));
        if (r107 != null) goto L38;
    L42:
        Long r108 = this.f396691b.get(Integer.valueOf(r105));
        if (r108 != null) goto L45;
    L49:
        String[] r112 = r210.getPackageManager().getPackagesForUid(r105);
        if (r112 != null) goto L52;
        return false;
    L52:
        int r113 = r112.length;
        int r114 = 0;
    L53:
        if (r114 >= r113) goto L144;
        String r115 = r112[r114];
        if (Intrinsics.areEqual(r115, r210.getPackageName()) == false) goto L57;
        TransferLogger.a(this.f396693d, "checkPermission: " + r115 + " is same as " + r210.getPackageName());
        String r211 = r101;
        int r116 = r113;
    L136:
        boolean r109 = true;
    L140:
        if (r109 == true) goto L141;
        r114 = r114 + 1;
        r100 = r210;
        r113 = r116;
        r101 = r211;
        r102 = null;
        goto L53
    L141:
        this.f396690a.put(Integer.valueOf(r105), Long.valueOf(r106));
        return true;
    L57:
        PackageManager r117 = r210.getPackageManager();
        int r118 = Build.VERSION.SDK_INT;     // Catch: Exception -> L72
        if (r118 < 33) goto L65;
        PackageInfo r119 = r117.getPackageInfo(r115, PackageManager.PackageInfoFlags.of(134217728));     // Catch: Exception -> L72
        if (r119.signingInfo.hasMultipleSigners() == false) goto L63;
        List r120 = ArraysKt.toList(r119.signingInfo.getApkContentsSigners());     // Catch: Exception -> L72
    L75:
        if (r120.isEmpty() == false) goto L77;
        this.f396693d.d("signatures is null or empty for " + r115, r102);
        r211 = r101;
        r116 = r113;
    L139:
        r109 = false;
        goto L140
    L77:
        String r121 = "SHA-256";
        MessageDigest r122 = MessageDigest.getInstance("SHA-256");
        Iterator r123 = r120.iterator();
    L79:
        if (r123.hasNext() == false) goto L138;
        byte[] r124 = r122.digest(((Signature) r123.next()).toByteArray());
        StringBuilder r125 = new StringBuilder();
        Iterator r126 = r123;
        int r127 = r124.length;
        r116 = r113;
        MessageDigest r128 = r122;
        int r129 = 0;
    L81:
        if (r129 >= r127) goto L86;
        String r130 = Integer.toHexString(r124[r129] & UByte.MAX_VALUE);
        int r212 = r127;
        byte[] r213 = r124;
        if (r130.length() != 1) goto L85;
        r125.append('0');
    L85:
        r125.append(r130);
        r129 = r129 + 1;
        r127 = r212;
        r124 = r213;
        goto L81
    L86:
        String r131 = r125.toString();
        Integer r132 = d.f396699a;
        Intrinsics.checkNotNullParameter(r100, r101);
        Intrinsics.checkNotNullParameter(r115, "packageName");
        Intrinsics.checkNotNullParameter(r131, "hexString");
        Integer r133 = d.f396699a;     // Catch: Exception -> L110
        if (r133 == null) goto L90;
        r211 = r101;
        String r214 = r121;
        Integer r134 = r133;
    L114:
        if (r134 == null) goto L132;
        Map<String, Integer> r135 = d.f396700b.get(r115);
        if (r135 == null) goto L119;
        Integer r136 = r135.get(r131);
    L120:
        if (r136 == null) goto L132;
        if (r134.intValue() != 1) goto L128;
        if (r136.intValue() != 1) goto L132;
    L133:
        boolean r137 = true;
    L134:
        if (r137 == true) goto L135;
        r100 = r210;
        r123 = r126;
        r113 = r116;
        r122 = r128;
        r101 = r211;
        r121 = r214;
        goto L79
    L135:
        TransferLogger.a(this.f396693d, "checkPermission: " + r115 + " is valid with hash " + r131);
        goto L136
    L128:
        if (r136.intValue() == 0) goto L133;
        if (r136.intValue() != 1) goto L132;
    L119:
        r136 = null;
    L132:
        r137 = false;
        goto L134
    L90:
        List r138 = d.a(r210.getPackageManager(), r210.getPackageName());     // Catch: Exception -> L110
        if (r138.isEmpty() == false) goto L93;
        r211 = r101;
        r214 = r121;
    L113:
        r134 = null;
        goto L114
    L93:
        byte[] r139 = ((Signature) ListProtector.get(r138, 0)).toByteArray();     // Catch: Exception -> L110
        MessageDigest r140 = MessageDigest.getInstance(r121);     // Catch: Exception -> L110
        r140.update(r139);     // Catch: Exception -> L110
        byte[] r141 = r140.digest();     // Catch: Exception -> L110
        StringBuilder r142 = new StringBuilder();     // Catch: Exception -> L110
        int r143 = r141.length;     // Catch: Exception -> L110
        int r144 = 0;
    L94:
        if (r144 >= r143) goto L104;
        String r145 = Integer.toHexString(r141[r144] & UByte.MAX_VALUE);     // Catch: Exception -> L110
        r211 = r101;
        r214 = r121;
        if (r145.length() != 1) goto L103;
        r142.append('0');     // Catch: Exception -> L146
    L103:
        r142.append(r145);     // Catch: Exception -> L146
        r144 = r144 + 1;     // Catch: Exception -> L146
        r101 = r211;
        r121 = r214;
    L111:
        r214 = r121;
        goto L113
    L104:
        r211 = r101;
        r214 = r121;
        if (Intrinsics.areEqual(r142.toString(), "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8") == false) goto L107;
        int r146 = 0;
    L108:
        d.f396699a = Integer.valueOf(r146);     // Catch: Exception -> L146
        r134 = Integer.valueOf(r146);     // Catch: Exception -> L146
        goto L114
    L107:
        r146 = 1;
    L110:
        r211 = r101;
        goto L111
    L138:
        r211 = r101;
        r116 = r113;
        this.f396693d.d("checkPermission: " + r115 + " is not valid with any hash", null);
        goto L139
    L63:
        r120 = ArraysKt.toList(r119.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L72
        goto L75
    L65:
        if (r118 < 28) goto L70;
        PackageInfo r147 = r117.getPackageInfo(r115, AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Exception -> L72
        if (r147.signingInfo.hasMultipleSigners() == false) goto L69;
        r120 = ArraysKt.toList(r147.signingInfo.getApkContentsSigners());     // Catch: Exception -> L72
        goto L75
    L69:
        r120 = ArraysKt.toList(r147.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L72
        goto L75
    L70:
        r120 = ArraysKt.toList(r117.getPackageInfo(r115, 64).signatures);     // Catch: Exception -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
        r120 = CollectionsKt.emptyList();
        goto L75
    L144:
        this.f396693d.b("verify: refused " + ArraysKt.joinToString$default(r112, null, null, null, 0, null, null, 63, null), null);
        this.f396691b.put(Integer.valueOf(r105), Long.valueOf(r106));
        return false;
    L45:
        if ((r106 - r108.longValue()) >= 5000) goto L48;
        TransferLogger.a(this.f396693d, "verify: uid " + r105 + " is disallowed (cached)");
        return false;
    L48:
        Long r148 = this.f396691b.remove(Integer.valueOf(r105));
        goto L49
    L38:
        if ((r106 - r107.longValue()) >= 5000) goto L41;
        TransferLogger.a(this.f396693d, "verify: uid " + r105 + " is already verified (cached)");
        return true;
    L41:
        Long r149 = this.f396690a.remove(Integer.valueOf(r105));
        goto L42
    }
}
