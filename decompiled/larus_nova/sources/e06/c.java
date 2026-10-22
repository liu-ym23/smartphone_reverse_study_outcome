package e06;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import hz5.l;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f470642a = null;

    static {
        f470642a = new Gson();
    }

    @JvmStatic
    public static final String c(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return GsonProtectorUtils.toJson(f470642a, r100);
    }

    @JvmStatic
    public static final <T> T a(String r100, Class<T> r101) {
        return (T) f470642a.fromJson(r100, r101);
    L4:
        e = move-exception;
        Pair[] r102 = new Pair[1];
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r102[0] = TuplesKt.to("json_string", r100);
        l.b(new iz5.b(null, e, "label_gson_utils", MapsKt.mutableMapOf(r102), 17));
        return null;
    }

    @JvmStatic
    public static final <T> T b(String r100, Type r101) {
        return (T) f470642a.fromJson(r100, r101);
    L4:
        e = move-exception;
        Pair[] r102 = new Pair[1];
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r102[0] = TuplesKt.to("json_string", r100);
        l.b(new iz5.b(null, e, "label_gson_utils", MapsKt.mutableMapOf(r102), 17));
        return null;
    }
}
