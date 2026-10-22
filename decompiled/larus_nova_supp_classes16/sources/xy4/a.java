package xy4;

import android.os.SystemClock;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a extends d {
    public long a;

    public a() {
    }

    public final void a(String r11, String r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "channel");
        if (Intrinsics.areEqual(r11, EChannel.DOCS_FULLPKG_CHANNEL.toString()) == false) goto L9;
        long r0 = SystemClock.uptimeMillis();
        int r16 = b.a;
        long r4 = r0 - this.a;
        if (r12 != null) goto L7;
        r12 = "error";
    L7:
        b.a(r4, false, r12, r13, r14);
        return;
    }
}
