package mra;

import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515041a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        String r102 = UriProtector.parse(r100).getScheme();
        if (c.a().optInt("enable_quick_app", 0) != 0) goto L19;
        if (Intrinsics.areEqual("hap", r102) == false) goto L16;
        return true;
    L16:
        if (Intrinsics.areEqual("hwfastapp", r102) == true) goto L33;
    L27:
        return false;
    L33:
        return true;
    L19:
        if (Intrinsics.areEqual("hap", r102) == false) goto L21;
        return true;
    L21:
        if (Intrinsics.areEqual("hwfastapp", r102) == false) goto L23;
        return true;
    L23:
        if (StringsKt.startsWith$default(r100, "http://hapjs.org/app", false, 2, null) == false) goto L25;
        return true;
    L25:
        if (StringsKt.startsWith$default(r100, "https://hapjs.org/app", false, 2, null) == false) goto L27;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final JSONObject b(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = 0;
        if (r100.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == false) goto L20;
        int r104 = r100.length;
    L9:
        if (r102 >= r104) goto L20;
        JSONObject r105 = r100[r102];
        if (r105 == null) goto L19;
        Iterator<String> r106 = r105.keys();     // Catch: JSONException -> L17
    L14:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();     // Catch: JSONException -> L17
        r101.put(r107, r105.get(r107));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L19:
        r102 = r102 + 1;
    L20:
        return r101;
    L5:
        r103 = false;
        goto L7
    }
}
