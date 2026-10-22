package bp5;

import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements a {
    public f() {
    }

    @Override // bp5.a
    public final void a(Window r3, int r4) {
        if (r3 == null) goto L7;
        int r0 = r3.getAttributes().flags;
        if ((((-67108865) & r0) | 0) == r0) goto L7;
        r3.clearFlags(67108864);
    L7:
        d.a(r3, Integer.MIN_VALUE);
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.getStatusBarColor() == r4) goto L14;
        r3.setStatusBarColor(r4);
        return;
    }
}
