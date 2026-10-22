package mu8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f515815a = null;

    static {
        f515815a = new GsonBuilder().excludeFieldsWithModifiers(new int[]{128, 8}).create();
        new GsonBuilder().disableHtmlEscaping().excludeFieldsWithModifiers(new int[]{128, 8}).create();
    }

    public static String a(Object r100) {
        return f515815a.toJson(r100);
    L4:
        th = move-exception;
        nu8.a.b("GsonUtils", "exception : " + th.getMessage());
        return "";
    }
}
