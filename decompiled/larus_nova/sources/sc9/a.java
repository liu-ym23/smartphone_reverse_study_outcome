package sc9;

import buc.b;
import hd9.d;
import hd9.n;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f541406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final buc.a f541407b = null;

    static {
        f541407b = b.a(false);
        new ReentrantLock();
    }

    public static n a() {
        if (f541406a == null) goto L8;
        n r100 = f541406a;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    L9:
        return r100;
    L8:
        return d.f484621a;
    }
}
