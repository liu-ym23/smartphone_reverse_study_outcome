package h67;

import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void a(int r100, int r101, String r102, String r110, long r111) {
        if (r100 != 0) goto L4;
        NormalEvent.eventReport(0, r101, r102, r110, r111);
        return;
    L4:
        ErrorEvent.eventReport(0, r101, r102, r110, r100, null);
    }
}
