package xc7;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements zc7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f563220a = null;

    public b() {
    }

    @Override // zc7.c
    public final void a() {
    }

    static {
        f563220a = new b();
    }

    @Override // zc7.c
    public final void onPageStarted(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        d r101 = a.f563219a;
        if (r100 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        ((ConcurrentHashMap) c.f563221a).remove(r100);
        return;
    }
}
