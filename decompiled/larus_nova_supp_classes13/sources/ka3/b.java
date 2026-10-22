package ka3;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        return r2.getSharedPreferences("js_kv_methods_20191113", 0).getString(r3, null);
    }

    public static void b(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.getSharedPreferences("js_kv_methods_20191113", 0).edit().putString(r3, r4).apply();
    }
}
