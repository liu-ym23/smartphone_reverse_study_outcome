package fu3;

import android.app.Activity;
import uu3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a extends b {
    public final /* synthetic */ b a;

    public b$a(b r1) {
        this.a = r1;
    }

    public final void onBackground(Activity r5) {
        b r6 = this.a;
        r6.getClass();
        long r0 = System.currentTimeMillis();
        long r2 = r0 - r6.k;
        r6.k = r0;
        if (r6.n.b == false) goto L5;
        r6.h(false);
    L5:
        r6.f(new h("command_change_to_background", r2));
    }

    public final void onFront(Activity r5) {
        b r6 = this.a;
        r6.getClass();
        long r0 = System.currentTimeMillis();
        long r2 = r0 - r6.k;
        r6.k = r0;
        if (r6.n.b == false) goto L5;
        r6.h(true);
    L5:
        r6.f(new h("command_change_to_front", r2));
    }
}
