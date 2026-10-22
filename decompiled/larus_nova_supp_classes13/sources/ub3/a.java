package ub3;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, Map<String, Object>> a;
    public final Context b;

    /* JADX INFO: renamed from: ub3.a$a, reason: collision with other inner class name */
    public static final class C0234a {
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(eh.b.b(r2))).toString();
        this.a = new LinkedHashMap();
    }
}
