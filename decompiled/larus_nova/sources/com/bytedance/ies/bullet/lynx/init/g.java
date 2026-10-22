package com.bytedance.ies.bullet.lynx.init;

import android.util.AndroidRuntimeException;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.lynx.tasm.base.AbsLogDelegate;
import com.lynx.tasm.base.LogSource;
import com.ss.android.agilelogger.ALog;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends AbsLogDelegate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f247349c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q26.j f247350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f247351b;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final int getMinimumLoggingLevel() {
        return 2;
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void log(int r100, String r101, String r102) {
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final int type() {
        return 1;
    }

    public g(q26.j r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceToken");
        this.f247350a = r100;
        this.f247351b = (r) r100.getService(r.class);
        UGLogger.c r101 = UGLogger.f270252a;     // Catch: Throwable -> L5
        UGLogger.c r102 = UGLogger.f270252a;     // Catch: Throwable -> L5
        f247349c = ALog.getALogSimpleWriteFuncAddr();     // Catch: Throwable -> L5
        return;
    L5:
        new AndroidRuntimeException("Just warning log, No ALog dependency found").printStackTrace();
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void d(String r100, String r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j(r100 + '_' + r101, LogLevel.D, "Lynx");
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void e(String r100, String r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j(r100 + '_' + r101, LogLevel.E, "Lynx");
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void i(String r100, String r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j(r100 + '_' + r101, LogLevel.I, "Lynx");
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final boolean isLoggable(LogSource r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r100 != LogSource.JAVA) goto L7;
        if (r101 < this.mMinimumLoggingLevel) goto L7;
    L10:
        return true;
    L7:
        if (r100 == LogSource.Native) goto L9;
    L11:
        return false;
    L9:
        if (r101 != 8) goto L11;
        goto L10
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void k(String r100, String r101) {
        r r102 = this.f247351b;
        if (r102 == null) goto L6;
        JSONObject r103 = new JSONObject();
        r103.put("message", r101);
        Unit r104 = Unit.INSTANCE;
        r102.S(new c1("LynxLog", null, r103, null, null, 246));
        return;
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void v(String r100, String r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j(r100 + '_' + r101, LogLevel.V, "Lynx");
    }

    @Override // com.lynx.tasm.base.AbsLogDelegate
    public final void w(String r100, String r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j(r100 + '_' + r101, LogLevel.W, "Lynx");
    }
}
