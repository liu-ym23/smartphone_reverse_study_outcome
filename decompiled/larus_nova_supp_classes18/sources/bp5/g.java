package bp5;

import android.R;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements a {
    public g() {
    }

    @Override // bp5.a
    public final void a(Window r4, int r5) {
        if (r4 == null) goto L8;
        int r1 = r4.getAttributes().flags;
        if ((((-67108865) & r1) | 0) == r1) goto L8;
        r4.clearFlags(67108864);
    L8:
        d.a(r4, Integer.MIN_VALUE);
        if (r4 == null) goto L23;
        if (r4.getStatusBarColor() == r5) goto L23;
        r4.setStatusBarColor(r5);
    L23:
        View r6 = r4.findViewById(R.id.content);     // Catch: Throwable -> L20
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.getForeground() == null) goto L26;
        r6.setForeground(null);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        tt5.a.f("StatusBarMImpl", th, false);
    }
}
