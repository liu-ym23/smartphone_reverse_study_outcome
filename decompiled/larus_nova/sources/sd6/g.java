package sd6;

import faceverify.w;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class g<T> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f541466a;

    public g(T r100) {
        this.f541466a = r100;
    }

    @Override // sd6.a
    public final void a(Stack r100, re6.c r101, rd6.d r102) {
        Intrinsics.checkNotNullParameter(r100, "stack");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_IMAGE_RUNTIMEINFO);
        r100.push(this.f541466a);
    }
}
