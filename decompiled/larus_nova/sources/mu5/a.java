package mu5;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515754a = 0;

    static {
    }

    public static String b(Object r100) {
        return new Gson().toJson(r100);
    L4:
        th = move-exception;
        tt5.a.d("GsonHelper", "GsonHelper.toJson error, error is: " + th.getMessage());
        return "";
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "cls");
        return new Gson().fromJson(r100, r101);
    L5:
        th = move-exception;
        tt5.a.d("GsonHelper", "GsonHelper.toJson error, error is: " + th.getMessage());
        return null;
    }
}
