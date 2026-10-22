package com.obric.sva.sdk.sami;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.effectplatform.AuthModelConfig;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/sva/sdk/sami/SamiQnnRuntime;", "", "<init>", "()V", "TAG", "", "preparedQnnDir", "qnnLoadLock", "ensureReady", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "purpose", "updateAdspLibraryPath", "qnnDir", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SamiQnnRuntime {
    public static final SamiQnnRuntime INSTANCE = null;
    private static final String TAG = "SamiQnnRuntime";
    private static volatile String preparedQnnDir;
    private static final Object qnnLoadLock = null;

    private SamiQnnRuntime() {
    }

    public static /* synthetic */ Unit a(String r100, String r101) {
        return updateAdspLibraryPath$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit b(String r100, Throwable r101) {
        return updateAdspLibraryPath$lambda$2(r100, r101);
    }

    static {
        INSTANCE = new SamiQnnRuntime();
        preparedQnnDir = "";
        qnnLoadLock = new Object();
    }

    private final boolean updateAdspLibraryPath(String r100, final String r101) {
        com.obric.assistant.common.utils.b r102 = com.obric.assistant.common.utils.b.f387875a;
        Function1 r103 = new c(r101);
        Function1 r104 = new d(r101);
        r102.getClass();
        return com.obric.assistant.common.utils.b.a(r100, r103, r104);
    }

    private static final Unit updateAdspLibraryPath$lambda$1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        LogUtils.i(TAG, "updateAdspLibraryPath purpose=" + r100 + " set=" + r101, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit updateAdspLibraryPath$lambda$2(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        LogUtils.e(TAG, "updateAdspLibraryPath failed purpose=" + r100 + ": " + r101.getMessage(), new Object[]{r101});
        return Unit.INSTANCE;
    }

    public final boolean ensureReady(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "purpose");
        AuthModelConfig r102 = AuthModelConfig.INSTANCE;
        r102.refreshBuiltinQnn(r100.getApplicationContext(), "SamiQnnRuntime:" + r101);
        String r103 = r102.getQnnLibDir();
        boolean r104 = true;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L10;
        LogUtils.w(TAG, "ensureReady skip purpose=" + r101 + " qnnDir empty", new Object[0]);
        return false;
    L10:
        if (new PolarisFileWrapper(r103).isDirectory() == true) goto L14;
        LogUtils.w(TAG, "ensureReady qnnDir not directory purpose=" + r101 + " qnnDir=" + r103, new Object[0]);
        return false;
    L14:
        if (Intrinsics.areEqual(preparedQnnDir, r103) == false) goto L16;
        return true;
    L16:
        Object r106 = qnnLoadLock;
        monitor-enter(r106);
    L27:
        th = move-exception;
        throw th;
    L19:
        if (Intrinsics.areEqual(preparedQnnDir, r103) == false) goto L22;
    L25:
        monitor-exit(r106);
        return r104;
    L22:
        if (INSTANCE.updateAdspLibraryPath(r103, r101) == true) goto L24;
        r104 = false;
        goto L25
    L24:
        preparedQnnDir = r103;     // Catch: Throwable -> L27
        LogUtils.i(TAG, "ensureReady path ready purpose=" + r101 + " qnnDir=" + r103, new Object[0]);     // Catch: Throwable -> L27
        goto L25
    L5:
        r105 = false;
        goto L6
    }
}
