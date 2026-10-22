package dk4;

import java.util.Calendar;
import mj4.f;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class b implements Runnable {
    public /* synthetic */ b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = d.f468996b;
        int r101 = Calendar.getInstance().get(11);
        j.d("NapManager", "hour: " + r101 + ", screen: " + r100 + ", sniffMode: " + c.f468993a);
        if (r100 == 1) goto L5;
    L11:
        if (r100 == 2) goto L13;
        return;
    L13:
        if (c.f468993a != 1) goto L25;
        if (r101 < 7) goto L17;
        if (r101 >= 23) goto L17;
        return;
    L17:
        if (f.b.f514251a.f514229d.i(1, 6, new byte[]{9, 1, (byte) 2}) != 0) goto L27;
        c.f468993a = 2;
        return;
    L27:
        return;
    L25:
        return;
    L5:
        if (c.f468993a != 2) goto L11;
        if (r101 < 7) goto L20;
        if (r101 < 23) goto L9;
        return;
    L9:
        if (f.b.f514251a.f514229d.i(1, 6, new byte[]{9, 1, (byte) 1}) != 0) goto L22;
        c.f468993a = 1;
        return;
    L22:
        return;
    }
}
