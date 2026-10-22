package y83;

import kotlin.jvm.internal.Intrinsics;
import w83.c;
import w83.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T extends w83.c> implements d<T> {
    public final T a;

    @Override // w83.d
    public final void b(String r1, Object r2) {
        Intrinsics.checkNotNullParameter("room_unique_key", "key");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
    }

    @Override // w83.d
    public final w83.b<T> a() {
        return new a(this.a);
    }

    public b(T r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }
}
