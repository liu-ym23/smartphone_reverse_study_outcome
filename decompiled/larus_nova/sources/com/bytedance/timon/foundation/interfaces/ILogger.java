package com.bytedance.timon.foundation.interfaces;

import com.bytedance.timon_monitor_impl.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/ILogger;", "", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public interface ILogger {
    void a();

    boolean b();

    void c(long r100, long r101, b r102);

    void d(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void i(String r100, String r101);

    void v(String r100, String r101);

    void w(String r100, String r101, Throwable r102);
}
