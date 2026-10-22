package kp6;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f505516a;

    public static Gson a() {
        if (f505516a != null) goto L6;
        f505516a = new Gson();
    L6:
        return f505516a;
    }

    public static JsonElement b(Object r100) {
        return GsonProtectorUtils.toJsonTree(a(), r100);
    }
}
