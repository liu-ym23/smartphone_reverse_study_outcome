package com.bytedance.timon.foundation.impl;

import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon_monitor_impl.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/foundation/impl/AndroidLoggerImpl;", "Lcom/bytedance/timon/foundation/interfaces/ILogger;", "<init>", "()V", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class AndroidLoggerImpl implements ILogger {
    public AndroidLoggerImpl() {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void a() {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final boolean b() {
        return true;
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void d(String r100, String r101) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void e(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void i(String r100, String r101) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void v(String r100, String r101) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void w(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public final void c(long r100, long r101, b r102) {
        r102.a(false, "-1", "default log not support upload");
    }
}
