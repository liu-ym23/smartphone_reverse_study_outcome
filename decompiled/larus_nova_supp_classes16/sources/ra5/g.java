package ra5;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements ComponentCallbacks {
    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public g() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r3) {
        qa5.b.a.a.a.j().a(eu5.b.a, r3);
    }
}
