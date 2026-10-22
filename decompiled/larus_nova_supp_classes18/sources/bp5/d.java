package bp5;

import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static void a(Window r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.getAttributes().flags;
        if ((((~r4) & r0) | (r4 & r4)) == r0) goto L8;
        r3.addFlags(r4);
        return;
    }
}
