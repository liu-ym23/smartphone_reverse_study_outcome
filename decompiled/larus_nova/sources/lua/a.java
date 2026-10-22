package lua;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f510836a = null;

    static {
        f510836a = new Gson();
    }

    public static final <T> T a(String r100, Class<T> r101) {
        Log.i("FastJsonUtil", "jsonData: " + r100 + ", clazz: " + r101.getName());
        if (r100 != null) goto L10;
        Log.i("FastJsonUtil", "fromJson failed, jsonData is null, clazz: ".concat(r101.getName()));
        return null;
    L10:
        T r102 = (T) f510836a.fromJson(r100, TypeToken.get(r101).getType());
        Log.i("FastJsonUtil", "fromJson success, result: " + r102);     // Catch: Throwable -> L8
        return r102;
    L8:
        Log.e("FastJsonUtil", "fromJson failed, clazz: ".concat(r101.getName()));
        return null;
    }
}
