package p83;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final <T> T a(String r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "classOfT");
        return (T) new Gson().fromJson(r1, r2);
    L5:
        return null;
    }
}
