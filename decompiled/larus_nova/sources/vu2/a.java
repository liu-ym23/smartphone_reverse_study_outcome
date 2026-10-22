package vu2;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function0<Unit> f557350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f557351b = null;

    public a() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    static {
        f557351b = new a();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        Objects.toString(f557350a);
        Function0<Unit> r100 = f557350a;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        Objects.toString(f557350a);
        if (r100 != 5) goto L5;
    L9:
        Function0<Unit> r101 = f557350a;
        if (r101 == null) goto L13;
        Unit r102 = r101.invoke();
        return;
    L13:
        return;
    L5:
        if (r100 == 10) goto L9;
        if (r100 == 15) goto L9;
    }
}
