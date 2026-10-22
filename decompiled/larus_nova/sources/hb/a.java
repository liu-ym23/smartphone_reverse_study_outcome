package hb;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f484429a = null;

    static {
        f484429a = new Gson();
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonStr");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return GsonProtectorUtils.fromJson(f484429a, r100, r101);
    }
}
