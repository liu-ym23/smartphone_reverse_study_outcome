package d50;

import android.os.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends c {
    @Override // d50.c
    public final void h(c50.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Message r101 = a(r100);
        if (r101 == null) goto L8;
        this.f466890c.a(this.f466889b, r100);
        this.f466892e = r100.hashCode();
        this.f466888a.sendMessageDelayed(r101, this.f466893f);
        return;
    }

    public d(c50.a r100, HashMap r101, f50.a r102, long r103) {
        super(r100, r101, r102, r103);
    }
}
