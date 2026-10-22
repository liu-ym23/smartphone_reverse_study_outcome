package xwc;

import org.slf4j.helpers.h;

/* JADX INFO: loaded from: classes42.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ywc.c f565320a = null;

    static {
        ywc.e r100 = e.d();
        if (r100 == null) goto L5;
        f565320a = r100.b();
        return;
    L5:
        h.a("Failed to find provider.");
        h.a("Defaulting to no-operation MDCAdapter implementation.");
        f565320a = new org.slf4j.helpers.c();
    }
}
