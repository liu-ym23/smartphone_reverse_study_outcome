package y83;

import kotlin.jvm.internal.Intrinsics;
import w83.c;
import w83.d;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T extends w83.c> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f566880a;

    @Override // w83.d
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter("room_unique_key", "key");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
    }

    @Override // w83.d
    public final w83.b<T> a() {
        return new a(this.f566880a);
    }

    public b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f566880a = r100;
    }
}
