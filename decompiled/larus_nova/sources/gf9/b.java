package gf9;

import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes4.dex */
public interface b {
    lf9.a a(String r100);

    @Deprecated(message = "will be remove", replaceWith = @ReplaceWith(expression = "onConnectSuccess", imports = {}))
    void b(String r100, RTCEstablishReportScene r101, long r102);

    void c(String r100);

    void d(String r100);
}
