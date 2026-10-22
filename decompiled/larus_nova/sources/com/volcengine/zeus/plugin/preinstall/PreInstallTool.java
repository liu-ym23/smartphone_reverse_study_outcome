package com.volcengine.zeus.plugin.preinstall;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.plugin.PluginProtocolVersionChecker;
import dqc.c;
import hqc.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kqc.e;
import mqc.f;
import mqc.h;
import mqc.i;
import mqc.r;

/* JADX INFO: loaded from: classes41.dex */
public final class PreInstallTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreInstallTool f462820a = null;

    public PreInstallTool() {
    }

    static {
        f462820a = new PreInstallTool();
    }

    public static Pair a(PolarisFileWrapper r100) {
        if (GlobalParam.getInstance().checkMatchHostAbi() == true) goto L22;
        ZeusLogger.i("ZeusPreInstallTool", "checkMatchHostAbi is disabled, skip checkMatchHostAbi");
        return TuplesKt.to(Boolean.TRUE, null);
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        f<Boolean, Map<String, List<ZipEntry>>> r102 = dqc.b.i(r100);     // Catch: Throwable -> L10
        Boolean r103 = r102.f514947a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L10
        boolean r104 = r103.booleanValue();     // Catch: Throwable -> L10
        Map<String, List<ZipEntry>> r105 = r102.f514948b;     // Catch: Throwable -> L10
        if (r104 == true) goto L7;
        ZeusLogger.w("ZeusPreInstallTool", "checkMatchHostAbi failed: plugin so not match");     // Catch: Throwable -> L10
        Pair r106 = TuplesKt.to(Boolean.FALSE, r105);     // Catch: Throwable -> L10
    L8:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L10
    L12:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L15;
        ZeusLogger.w("ZeusPreInstallTool", "checkMatchHostAbi failed: " + r108.getMessage(), r108);
    L15:
        Pair r109 = TuplesKt.to(Boolean.FALSE, null);
        if (Result.m9455isFailureimpl(r107) == false) goto L19;
        r107 = r109;
    L19:
        return (Pair) r107;
    L7:
        ZeusLogger.i("ZeusPreInstallTool", "checkMatchHostAbi success: plugin so matched");     // Catch: Throwable -> L10
        r106 = TuplesKt.to(Boolean.TRUE, r105);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean h(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        boolean r103 = false;
        int r104 = e.a(r100, false, new StringBuilder(), new b(this, r101));     // Catch: Throwable -> L9
        if (r104 != 200) goto L5;
    L6:
        r103 = true;
    L7:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        ZeusLogger.w("ZeusPreInstallTool", "modifyRes failed: " + r106.getMessage() + ", pluginApkFile = " + r100.getAbsolutePath() + ", hostApkFile = " + r101.getAbsolutePath(), r106);
    L14:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = r107;
    L18:
        return ((Boolean) r105).booleanValue();
    L5:
        if (r104 != 100) goto L7;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void c(int r100, String r101, int r102) {
        ZeusLogger.i("ZeusPreInstallTool", "clearPreInstall: hostVersionCode = " + r100 + ", pluginPkgName = " + r101 + ", pluginVersionCode = " + r102);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        ZeusPreInstallSpUtil.c(r101, r102);     // Catch: Throwable -> L5
        PolarisFileWrapper r104 = new PolarisFileWrapper(c.f(r101, r102, true));     // Catch: Throwable -> L5
        ZeusLogger.i("ZeusPreInstallTool", "delete dir " + r104);     // Catch: Throwable -> L5
        i.e(r104);     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L13;
        ZeusLogger.w("ZeusPreInstallTool", "clearPreInstall failed: " + r106.getMessage(), r106);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean e(Plugin r100, com.volcengine.zeus.util.apkextractor.a r101, PolarisFileWrapper r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        if (r102.exists() == false) goto L6;
        r102.delete();     // Catch: Throwable -> L12
    L6:
        ZeusLogger.i("ZeusPreInstallTool", "extractPluginApkToSourceDir: internalPath = " + r100.getInternalPath() + ", dstFile = " + r102);     // Catch: Throwable -> L12
        String r104 = r100.getInternalPath();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r104, "entryName");     // Catch: Throwable -> L12
        i.d(((ZipFile) r101.f462916a.getValue()).getInputStream(((ZipFile) r101.f462916a.getValue()).getEntry(r104)), new PolarisFileOutputStreamWrapper(r102));     // Catch: Throwable -> L12
        if (r102.exists() == false) goto L9;
        boolean r105 = true;
    L10:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        ZeusLogger.w("ZeusPreInstallTool", "extractPluginApkToSourceDir failed: " + r107.getMessage() + ", pkgName = " + r100.mPkgName + ", internalPath = " + r100.getInternalPath(), r107);
    L17:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
        r106 = r108;
    L21:
        return ((Boolean) r106).booleanValue();
    L9:
        ZeusLogger.w("ZeusPreInstallTool", "extractPluginApkToSourceDir failed: " + r102 + " not exists");     // Catch: Throwable -> L12
        r105 = false;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static String f(PolarisFileWrapper r100, String r101, int r102) {
        Object r103 = "";
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        String r105 = h.a(r100);     // Catch: Throwable -> L9
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L11:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L15;
        ZeusLogger.w("ZeusPreInstallTool", "getExtraInfo failed: " + r107.getMessage() + ", pkgName = " + r101 + ", versionCode = " + r102, r107);
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L19;
        r103 = r106;
    L19:
        return (String) r103;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static boolean g(int r100, String r110, int r111) {
        int r101 = ZeusPreInstallSpUtil.a().getInt("host_version", -1);
        boolean r102 = false;
        if (r100 == r101) goto L6;
        ZeusLogger.i("ZeusPreInstallTool", "isPreInstalled: hostVersionCode != preInstallHostVersion, hostVersionCode = " + r100 + ", preInstallHostVersion = " + r101);
        return false;
    L6:
        Intrinsics.checkNotNullParameter(r110, "pluginPkgName");
        boolean r103 = ZeusPreInstallSpUtil.a().getBoolean(ZeusPreInstallSpUtil.b("is_pre_installed", r110, r111), false);
        int r104 = ZeusPreInstallSpUtil.a().getInt("tool_version", -1);
        String r105 = ZeusPreInstallSpUtil.a().getString("host_abi", null);
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        String r106 = dqc.b.f();
        PolarisFileWrapper r107 = new PolarisFileWrapper(c.f(r110, r111, true));
        if (r103 == false) goto L18;
        if (r104 != 1) goto L18;
        if (Intrinsics.areEqual(r105, r106) == false) goto L18;
        if (r107.exists() == false) goto L18;
        r102 = true;
    L18:
        ZeusLogger.i("ZeusPreInstallTool", StringsKt.trimIndent("\n            isPreInstalled: hostVersion = " + r100 + ", pluginPkgName = " + r110 + ", pluginVersion = " + r111 + ", finalResult = " + r102 + ",\n            isPreInstalled = " + r103 + ",\n            preInstallToolVersion = " + r104 + ", curToolVersion = 1,\n            preInstallHostAbi = " + r105 + ", curHostAbi = " + r106 + ",\n            preInstallDir = " + r107 + ", is dir exists = " + r107.exists() + "\n        "));
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v3, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v23, types: [T, com.bytedance.security.android.aopcheck.PolarisFileWrapper] */
    /* JADX WARN: Type inference failed for: r2v47, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12 */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3 */
    /* JADX WARN: Type inference failed for: r32v4 */
    /* JADX WARN: Type inference failed for: r32v5 */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    public final boolean j(final Plugin r310, final com.volcengine.zeus.util.apkextractor.a r311, final hqc.e r312) {
        String r110 = "checkPermissions failed: ";
        String r111 = "checkMatchHostAbi not match: ";
        Intrinsics.checkNotNullParameter(r310, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r311, "hostApkExtractor");
        Intrinsics.checkNotNullParameter(r312, "hostPkgInfo");
        long r112 = System.currentTimeMillis();
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = null;
        final ?? r113 = new Ref.BooleanRef();
        r113.element = true;
        ZeusLogger.i("ZeusPreInstallTool", "preInstall: pkgName = " + r310.mPkgName + ", internalVersionCode = " + r310.getInternalVersionCode() + ", internalPath = " + r310.getInternalPath());
        if (r312.f486846a != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        ZeusLogger.w("ZeusPreInstallTool", "preInstall: hostPkgInfo not valid: " + r312);
        return false;
    L11:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 35) goto L15;
        ZeusLogger.w("ZeusPreInstallTool", "preInstall: sdk version not match " + r102);
        return false;
    L15:
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = null;
        Application r210 = Zeus.getAppApplication();
        Object r211 = c.f469733d;
        if (r211 != null) goto L28;
        r211 = c.class;
        monitor-enter(r211);
        Object r212 = c.f469733d;     // Catch: Throwable -> L25
        if (r212 != null) goto L23;
        File r115 = r210.getFilesDir();     // Catch: Throwable -> L25
        String r213 = g.f462704a;     // Catch: Throwable -> L25
        c.f469733d = new PolarisFileWrapper(r115, ".zeus_pre_i");     // Catch: Throwable -> L25
    L23:
        monitor-exit(r211);     // Catch: Throwable -> L25
    L29:
        final PolarisFileWrapper r116 = new PolarisFileWrapper(c.b(c.f469733d), r310.mPkgName + '-' + r310.getInternalVersionCode() + ".apk");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L102
        PolarisFileWrapper r117 = new PolarisFileWrapper(r311.f462917b);     // Catch: Throwable -> L102
        if (e(r310, r311, r116) == true) goto L33;
        r100.element = "extractPluginApkToFile failed";     // Catch: Throwable -> L102
        ZeusLogger.w("ZeusPreInstallTool", "extractPluginApkToFile failed: " + r116 + " not exists");     // Catch: Throwable -> L102
    L64:
        ?? r104 = r116;
        ?? r313 = r113;
        String r314 = "preInstall finish. isSuccess = ";
        boolean r118 = false;
        r212 = null;
        r113 = r100;
    L96:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r118));     // Catch: Throwable -> L98
        r104 = r104;
        ?? r119 = r113;
        ?? r315 = r313;
    L105:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L148
        if (r106 == null) goto L108;
        r119.element = r106.getMessage();     // Catch: Throwable -> L148
        StringBuilder r107 = new StringBuilder("preInstall failed: ");     // Catch: Throwable -> L148
        r107.append(r106.getMessage());     // Catch: Throwable -> L148
        r107.append(", pkgName = ");     // Catch: Throwable -> L148
        Plugin r108 = r310;
        r107.append(r108.mPkgName);     // Catch: Throwable -> L148
        r107.append(", internalVersionCode = ");     // Catch: Throwable -> L148
        r107.append(r310.getInternalVersionCode());     // Catch: Throwable -> L148
        r107.append(", internalPath = ");     // Catch: Throwable -> L148
        r107.append(r310.getInternalPath());     // Catch: Throwable -> L148
        ZeusLogger.w("ZeusPreInstallTool", r107.toString(), r106);     // Catch: Throwable -> L148
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L148
    L110:
        if (Result.m9456isSuccessimpl(r105) == false) goto L112;
        ZeusLogger.i("ZeusPreInstallTool", r314 + ((Boolean) r105).booleanValue() + ", pkgName = " + r108.mPkgName + ", internalVersionCode = " + r310.getInternalVersionCode() + ", internalPath = " + r310.getInternalPath());     // Catch: Throwable -> L148
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L148
    L112:
        Object r121 = Boolean.FALSE;     // Catch: Throwable -> L148
        if (Result.m9455isFailureimpl(r105) == true) goto L116;
        r121 = r105;
    L116:
        boolean r122 = ((Boolean) r121).booleanValue();     // Catch: Throwable -> L148
        if (r122 == false) goto L169;
    L128:
        if (r122 == false) goto L131;
        long r123 = System.currentTimeMillis() - r112;     // Catch: Throwable -> L148
        f462820a.getClass();     // Catch: Throwable -> L148
        r.a(r108.mPkgName, Integer.valueOf(r310.getInternalVersionCode()), "pre_install_plugin", r123, null);     // Catch: Throwable -> L148
    L131:
        if (r315.element == false) goto L139;
        if (r122 == false) goto L134;
        f462820a.getClass();     // Catch: Throwable -> L148
        r.b(r108.mPkgName, r310.getInternalVersionCode(), "pre_install_plugin", "success", null, null);     // Catch: Throwable -> L148
        goto L139
    L134:
        PreInstallTool r124 = f462820a;     // Catch: Throwable -> L148
        String r125 = (String) r119.element;     // Catch: Throwable -> L148
        if (r125 != null) goto L138;
        r125 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L138:
        r124.getClass();     // Catch: Throwable -> L148
        r.b(r108.mPkgName, r310.getInternalVersionCode(), "pre_install_plugin", "fail", null, r125);     // Catch: Throwable -> L148
    L139:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L148
        boolean r127 = ((Boolean) r121).booleanValue();     // Catch: Throwable -> L148
        i.e(r104);     // Catch: Throwable -> L142
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L142
    L144:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L147;
        ZeusLogger.w("ZeusPreInstallTool", "delete tempPluginApkFile failed: " + r129.getMessage(), r129);
        Unit r130 = Unit.INSTANCE;
    L147:
        return r127;
    L142:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L148:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L152
        i.e(r104);     // Catch: Throwable -> L152
        Object r133 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L152
    L154:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L175;
        ZeusLogger.w("ZeusPreInstallTool", "delete tempPluginApkFile failed: " + r134.getMessage(), r134);
        Unit r135 = Unit.INSTANCE;
        throw th;
    L175:
        throw th;
    L152:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L154
    L169:
        File r137 = (File) r114.element;     // Catch: Throwable -> L123
        if (r137 == null) goto L121;
        ZeusLogger.i("ZeusPreInstallTool", "deletePluginVersionDir: " + r137);     // Catch: Throwable -> L123
        i.e(r137);     // Catch: Throwable -> L123
        r212 = Unit.INSTANCE;     // Catch: Throwable -> L123
    L121:
        Object r138 = Result.m9449constructorimpl(r212);     // Catch: Throwable -> L123
    L125:
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);     // Catch: Throwable -> L148
        if (r139 == null) goto L128;
        ZeusLogger.w("ZeusPreInstallTool", "deletePluginVersionDir clean failed: " + r139.getMessage(), r139);     // Catch: Throwable -> L148
        Unit r140 = Unit.INSTANCE;     // Catch: Throwable -> L148
        goto L128
    L123:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L148
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L148
        goto L125
    L108:
        r108 = r310;
    L98:
        th = th;
    L165:
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L148
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L148
        r104 = r104;
        r119 = r113;
        r315 = r313;
        goto L105
    L33:
        hqc.e r143 = d.b(r116);     // Catch: Throwable -> L102
        if (r143 != null) goto L161;
        r313 = r113;
        r314 = "preInstall finish. isSuccess = ";
        r212 = null;
        r113 = r100;
        r113.element = "getSimplePackageInfo failed";     // Catch: Throwable -> L100
        ?? r144 = new StringBuilder("getSimplePackageInfo failed: ");     // Catch: Throwable -> L100
        r104 = r116;
        r144.append(r104);     // Catch: Throwable -> L98
        r144.append(" not exists");     // Catch: Throwable -> L98
        ZeusLogger.w("ZeusPreInstallTool", r144.toString());     // Catch: Throwable -> L98
        ?? r145 = r104;
        ?? r146 = r113;
        ?? r316 = r313;
    L95:
        r118 = false;
        r104 = r145;
        r113 = r146;
        r313 = r316;
        goto L96
    L161:
    L89:
        th = th;
        r211 = r116;
        r313 = r113;
        r314 = "preInstall finish. isSuccess = ";
        r212 = null;
        r113 = r100;
    L91:
        r104 = r211;
        goto L165
    L36:
        if (r143.f486846a != null) goto L38;
    L40:
        boolean r147 = false;
    L41:
        if (r147 == true) goto L44;
        r100.element = "pluginPkgInfo not valid";     // Catch: Throwable -> L102
        ZeusLogger.w("ZeusPreInstallTool", "preInstall: pluginPkgInfo not valid: " + r143);     // Catch: Throwable -> L102
        goto L64
    L44:
        PluginManager r148 = PluginManager.getInstance();     // Catch: Throwable -> L89
        String r149 = r143.f486846a;     // Catch: Throwable -> L89
        if (r149 != null) goto L48;
        r149 = "";
    L48:
        Plugin r150 = r148.getPlugin(r149);     // Catch: Throwable -> L89
        if (r150 == null) goto L55;
        if (r150.getVersion() < r143.f486847b) goto L55;
        ZeusLogger.i("ZeusPreInstallTool", "preInstall: plugin " + r143.f486846a + " already installed, version " + r150.getVersion() + " >= " + r143.f486847b);     // Catch: Throwable -> L102
        r113.element = false;     // Catch: Throwable -> L102
    L55:
        String r151 = r311.c();     // Catch: Throwable -> L89
        Lazy r152 = PluginProtocolVersionChecker.f462770a;     // Catch: Throwable -> L89
        if (PluginProtocolVersionChecker.b(r143.f486846a, String.valueOf(r143.f486847b), r151) == true) goto L59;
        r100.element = "PluginProtocolVersionChecker check failed";     // Catch: Throwable -> L102
        ZeusLogger.w("ZeusPreInstallTool", "PluginProtocolVersionChecker check failed");     // Catch: Throwable -> L102
        goto L64
    L59:
        c(r312.f486847b, r143.f486846a, r143.f486847b);     // Catch: Throwable -> L89
        String r153 = dqc.b.f();     // Catch: Throwable -> L89
        ZeusLogger.i("ZeusPreInstallTool", "preInstall: hostAbi = " + r153);     // Catch: Throwable -> L89
        r114.element = new PolarisFileWrapper(c.f(r143.f486846a, r143.f486847b, true));     // Catch: Throwable -> L89
        PolarisFileWrapper r154 = new PolarisFileWrapper(c.h(r143.f486846a, r143.f486847b, true));     // Catch: Throwable -> L89
        i.e(r154);     // Catch: Throwable -> L89
        Unit r155 = Unit.INSTANCE;     // Catch: Throwable -> L89
        if (r116.renameTo(r154) == false) goto L62;
    L65:
        r211 = r116;
        r212 = null;
        r314 = "preInstall finish. isSuccess = ";
        ?? r317 = r113;
        r113 = r100;
    L87:
        th = th;
        r313 = r317;
        goto L91
    L68:
        if (com.volcengine.zeus.signature.e.a(r154.getAbsolutePath(), new PreInstallTool$preInstall$$inlined$runCatching$lambda$1(r311, r310, r116, r100, r113, r312, r114)) == true) goto L71;
        r113.element = "checkSignature failed";     // Catch: Throwable -> L87
        ZeusLogger.w("ZeusPreInstallTool", "checkSignature failed: " + r154);     // Catch: Throwable -> L87
    L85:
        r145 = r211;
        r146 = r113;
        r316 = r317;
        goto L95
    L71:
        Pair r156 = a(r154);     // Catch: Throwable -> L87
        boolean r157 = ((Boolean) r156.component1()).booleanValue();     // Catch: Throwable -> L87
        Map r158 = (Map) r156.component2();     // Catch: Throwable -> L87
        if (r157 == true) goto L75;
        r113.element = "checkMatchHostAbi not match";     // Catch: Throwable -> L87
        ZeusLogger.w("ZeusPreInstallTool", r111 + r154);     // Catch: Throwable -> L87
        goto L85
    L75:
        if (b(r117, r154, r143.f486846a, r143.f486847b) == true) goto L80;
        r113.element = "checkPermissions failed";     // Catch: Throwable -> L87
        ZeusLogger.w("ZeusPreInstallTool", r110 + r154);     // Catch: Throwable -> L87
        goto L85
    L80:
        if (h(r154, r117) == true) goto L82;
        r113.element = "modifyRes failed";     // Catch: Throwable -> L100
        ZeusLogger.w("ZeusPreInstallTool", "modifyRes failed: " + r154);     // Catch: Throwable -> L100
        goto L85
    L82:
        String r159 = f(r154, r143.f486846a, r143.f486847b);     // Catch: Throwable -> L100
        if (d(r143.f486846a, r143.f486847b, r158, r153) == true) goto L86;
        r113.element = "copySo failed";     // Catch: Throwable -> L100
        ZeusLogger.w("ZeusPreInstallTool", "copySo failed: " + r154);     // Catch: Throwable -> L100
        goto L85
    L86:
        gqc.b r160 = gqc.b.a();     // Catch: Throwable -> L100
        String r161 = r154.getPath();     // Catch: Throwable -> L100
        r160.getClass();     // Catch: Throwable -> L100
        gqc.b.d(r161);     // Catch: Throwable -> L100
        Lazy r162 = ZeusPreInstallSpUtil.f462821a;     // Catch: Throwable -> L100
        ZeusPreInstallSpUtil.e(r143.f486846a, r143.f486847b, r159);     // Catch: Throwable -> L100
        r104 = r211;
        r118 = true;
        r113 = r113;
        r313 = r317;
        goto L96
    L62:
        if (r154.exists() == false) goto L65;
        r100.element = "renameToPluginApkToSourceDir failed";     // Catch: Throwable -> L102
        ZeusLogger.w("ZeusPreInstallTool", "renameToPluginApkToSourceDir failed: " + r154 + " not exists");     // Catch: Throwable -> L102
        goto L64
    L38:
        if (r143.f486847b <= 0) goto L40;
        r147 = true;
    L100:
        th = th;
    L102:
        th = th;
        r104 = r116;
        r313 = r113;
        r314 = "preInstall finish. isSuccess = ";
        r212 = null;
        r113 = r100;
    L25:
        th = move-exception;
        throw th;
    L28:
        r110 = "checkPermissions failed: ";
        r111 = "checkMatchHostAbi not match: ";
        goto L29
    L5:
        if (r312.f486847b <= 0) goto L7;
        r101 = true;
        goto L8
    }

    public static boolean b(PolarisFileWrapper r100, PolarisFileWrapper r101, String r110, int r111) {
        boolean r102 = true;
        if (GlobalParam.getInstance().checkPermission() == true) goto L45;
        ZeusLogger.i("ZeusPreInstallTool", "checkPermission is disabled, skip checkPermissions");
        return true;
    L45:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L35
        PackageInfo r104 = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(r100.getAbsolutePath(), 4096);     // Catch: Throwable -> L35
        PackageInfo r105 = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(r101.getAbsolutePath(), 4096);     // Catch: Throwable -> L35
        String[] r106 = null;
        if (r104 == null) goto L9;
        String[] r107 = r104.requestedPermissions;     // Catch: Throwable -> L35
    L11:
        if (r107 != null) goto L14;
        r107 = new String[0];     // Catch: Throwable -> L35
    L14:
        Set r108 = ArraysKt.toSet(r107);     // Catch: Throwable -> L35
        if (r105 == null) goto L17;
        r106 = r105.requestedPermissions;     // Catch: Throwable -> L35
    L17:
        if (r106 != null) goto L19;
    L32:
        ZeusLogger.i("ZeusPreInstallTool", "plugin apk not declare any permission");     // Catch: Throwable -> L35
    L33:
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L35
    L37:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L40;
        ZeusLogger.w("ZeusPreInstallTool", "checkPermissions failed: " + r112.getMessage() + ", pkgName = " + r110 + ", versionCode = " + r111, r112);
    L40:
        Boolean r113 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r109) == false) goto L44;
        r109 = r113;
    L44:
        return ((Boolean) r109).booleanValue();
    L19:
        if (r105.requestedPermissions.length <= 0) goto L32;
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L35
        String[] r115 = r105.requestedPermissions;     // Catch: Throwable -> L35
        int r116 = r115.length;     // Catch: Throwable -> L35
        int r117 = 0;
    L21:
        if (r117 >= r116) goto L29;
        String r118 = r115[r117];     // Catch: Throwable -> L35
        if (r118 == null) goto L27;
        if (r108.contains(r118) == true) goto L27;
        r114.add(r118);     // Catch: Throwable -> L35
    L27:
        r117 = r117 + 1;     // Catch: Throwable -> L35
        goto L21
    L29:
        if (r114.isEmpty() == true) goto L31;
        ZeusLogger.w("ZeusPreInstallTool", "The following permissions are declared in the plugin but not in the host: " + r114);     // Catch: Throwable -> L35
        r102 = false;
        goto L33
    L31:
        ZeusLogger.i("ZeusPreInstallTool", "plugin apk declare all permissions in host");     // Catch: Throwable -> L35
        goto L33
    L9:
        r107 = null;
    L35:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public static boolean d(String r100, int r101, Map r102, String r103) {
        ZeusLogger.i("ZeusPreInstallTool", "copySo: pkgName =" + r100 + ", versionCode = " + r101 + ", hostAbi = " + r103 + ", pluginSoEntries = " + r102);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        dqc.b.c(new PolarisFileWrapper(c.h(r100, r101, true)), new PolarisFileWrapper(c.e(r100, r101, true)), r100, r102);     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L10;
        ZeusLogger.w("ZeusPreInstallTool", "copySo failed: " + r106.getMessage() + ", pkgName = " + r100 + ", versionCode = " + r101, r106);
    L10:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = r107;
    L14:
        return ((Boolean) r105).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean i(int r100, String r101, String r102, int r103) {
        String r104 = c.f(r102, r103, true);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L24:
        ZeusLogger.w("ZeusPreInstallTool", "preInstallPackageVersionDirPath or packageVersionDirPath is empty");     // Catch: Throwable -> L27
        c(r100, r102, r103);
        return false;
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L24;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L27
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104);     // Catch: Throwable -> L27
        if (r106.exists() == true) goto L11;
    L21:
        ZeusLogger.w("ZeusPreInstallTool", "rename preInstallPackageVersionDir to packageVersionDir failed");     // Catch: Throwable -> L27
        c(r100, r102, r103);
        return false;
    L11:
        if (r106.renameTo(r105) == false) goto L21;
        if (r105.exists() == false) goto L21;
        ZeusLogger.w("ZeusPreInstallTool", "rename preInstallPackageVersionDir to packageVersionDir success");     // Catch: Throwable -> L27
        Lazy r107 = ZeusPreInstallSpUtil.f462821a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r102, "pluginPkgName");     // Catch: Throwable -> L27
        String r108 = ZeusPreInstallSpUtil.a().getString(ZeusPreInstallSpUtil.b("extra_info", r102, r103), null);     // Catch: Throwable -> L27
        if (r108 != null) goto L18;
        r108 = "";
    L18:
        ZeusLogger.i("ZeusPreInstallTool", "pre installed extraInfo = ".concat(r108));     // Catch: Throwable -> L27
        h.b(r102, r103, r108);     // Catch: Throwable -> L27
        c(r100, r102, r103);
        return true;
    L27:
        th = move-exception;
        c(r100, r102, r103);
        throw th;
    }

    public static boolean k(int r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "pluginPackageVersionDirPath");
        Intrinsics.checkNotNullParameter(r102, "pluginPkgName");
        ZeusLogger.i("ZeusPreInstallTool", "tryInstallFromPreInstallDir: hostVersionCode = " + r100 + ", pluginPkgName = " + r102 + ", pluginVersionCode = " + r103 + ", pluginPackageVersionDirPath = " + r101);
        PreInstallTask.f462815i.getClass();
        boolean r104 = false;
        if (PreInstallTask.f462811e.b(null) == false) goto L28;
        ZeusLogger.i("ZeusPreInstallTool", "tryInstallFromPreInstallDir: got lock");
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        if (g(r100, r102, r103) == false) goto L11;
        ZeusLogger.i("ZeusPreInstallTool", "is pre installed");     // Catch: Throwable -> L14
        if (i(r100, r101, r102, r103) == false) goto L10;
        ZeusLogger.i("ZeusPreInstallTool", "move pre installed plugin state success");     // Catch: Throwable -> L14
        r104 = true;
    L12:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L25
        if (r107 == null) goto L19;
        ZeusLogger.w("ZeusPreInstallTool", "tryInstallFromPreInstallDir: failed, e = " + r107, r107);     // Catch: Throwable -> L25
    L19:
        Boolean r108 = Boolean.FALSE;     // Catch: Throwable -> L25
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        r106 = r108;
    L22:
        boolean r109 = ((Boolean) r106).booleanValue();     // Catch: Throwable -> L25
        PreInstallTask.f462815i.getClass();
        PreInstallTask.f462811e.unlock(null);
        return r109;
    L10:
        ZeusLogger.w("ZeusPreInstallTool", "move pre installed plugin state failed");     // Catch: Throwable -> L14
        goto L12
    L11:
        ZeusLogger.i("ZeusPreInstallTool", "is not pre installed");     // Catch: Throwable -> L14
    L25:
        th = move-exception;
        PreInstallTask.f462815i.getClass();
        PreInstallTask.f462811e.unlock(null);
        throw th;
    L14:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L25
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
        goto L16
    L28:
        ZeusLogger.i("ZeusPreInstallTool", "tryInstallFromPreInstallDir: not got lock, return false");
        return false;
    }
}
