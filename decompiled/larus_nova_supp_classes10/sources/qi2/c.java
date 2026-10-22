package qi2;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import sg2.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends a {
    public String a;
    public com.bytedance.android.livesdk.livecommerce.room.api.c b;
    public boolean c;
    public u d;

    public c() {
    }

    @Override // qi2.a
    public final boolean b(ee.b r7) {
        if (r7.getMsgType() == 6) goto L5;
        return false;
    L5:
        if (this.c == false) goto L7;
        return true;
    L7:
        if (this.b == null) goto L24;
        long r0 = CastLongProtector.parseLong(this.a);     // Catch: Exception -> L16
        String r8 = r7.getEcomNotice();     // Catch: Exception -> L16
        if (r0 > 0) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r8) == false) goto L13;
        return true;
    L13:
        if (this.b.insertLegalMessage(r0, r8, false) == false) goto L27;
        this.d.b();     // Catch: Exception -> L16
        return true;
    L27:
        return true;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return true;
    L24:
        return true;
    }

    @Override // qi2.a
    public final void c(j r2) {
        this.a = r2.roomId();
        this.b = r2.k();
        this.c = r2.l();
        this.d = r2.g();
    }
}
