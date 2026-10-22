package kv4;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final Context a;
    public final c b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new c();
    }
}
