package p83;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final <T> T a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "classOfT");
        return (T) new Gson().fromJson(r100, r101);
    L5:
        return null;
    }
}
