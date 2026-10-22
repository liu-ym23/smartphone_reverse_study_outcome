package defpackage;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f511444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f511445b;

    static {
        f511444a = new m();
    }

    public m() {
    }

    public final Context getContext() {
        if (f511445b == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Context r101 = f511445b;
        Intrinsics.checkNotNull(r101);
        return r101;
    L10:
        throw new IllegalStateException("BDNAAppContext 没有初始化".toString());
    L5:
        r100 = false;
        goto L6
    }
}
