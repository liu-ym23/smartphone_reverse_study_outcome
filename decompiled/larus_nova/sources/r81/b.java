package r81;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<a> f536503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f536504b = null;

    public b() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    static {
        f536504b = new b();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        WeakReference<a> r100 = f536503a;
        if (r100 == null) goto L8;
        a r101 = r100.get();
        if (r101 == null) goto L9;
        r101.onLowMemory();
        return;
    L9:
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        if (r100 != 5) goto L5;
    L9:
        WeakReference<a> r101 = f536503a;
        if (r101 == null) goto L15;
        a r102 = r101.get();
        if (r102 == null) goto L16;
        r102.onLowMemory();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r100 == 10) goto L9;
        if (r100 == 15) goto L9;
    }
}
