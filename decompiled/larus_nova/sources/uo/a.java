package uo;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f550902a = null;

    static {
        f550902a = new Gson();
    }

    public static final Object a(JsonObject r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "classOfT");
        if (r100 != null) goto L10;
        return null;
    L10:
        return f550902a.fromJson(r100, r101);
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static final <T> T b(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "classOfT");
        if (r100 != null) goto L10;
        return null;
    L10:
        return (T) f550902a.fromJson(r100, r101);
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }
}
