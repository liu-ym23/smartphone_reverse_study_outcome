package no9;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519991a = 0;

    static {
    }

    public static List h() {
        return CollectionsKt.listOf(new Integer[]{1, 29, 30, 31});
    }

    public static Integer e(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return null;
    L15:
        if (r100.intValue() != 58) goto L17;
        return 31;
    L10:
        if (r100.intValue() != 252) goto L12;
        return 30;
    L5:
        if (r100.intValue() != 17) goto L7;
        return 29;
    }

    public static a g(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = c(r100, new String[]{"token", "objToken", "obj_token"});
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = c(r100, new String[]{"title", "name"});
        if (r102 != null) goto L11;
        r102 = r101;
    L11:
        String r103 = c(r100, new String[]{"url", "link", "href"});
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        return new a(r101, r102, r103);
    }

    public static Integer a(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        Object r104 = r100.get(r101[r103]);
        if ((r104 instanceof Number) == true) goto L7;
        if ((r104 instanceof String) == false) goto L14;
        Integer r105 = StringsKt.toIntOrNull((String) r104);
        if (r105 == null) goto L14;
        return Integer.valueOf(r105.intValue());
    L14:
        r103 = r103 + 1;
        goto L3
    L7:
        return Integer.valueOf(((Number) r104).intValue());
    L15:
        return null;
    }

    public static String b(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        Object r104 = null;
        if (r103 >= r102) goto L18;
        Object r105 = r100.get(r101[r103]);
        if ((r105 instanceof Number) == true) goto L8;
        if ((r105 instanceof String) == false) goto L17;
        if ((!StringsKt.isBlank((String) r105)) == false) goto L14;
        r104 = r105;
    L14:
        String r106 = (String) r104;
        if (r106 == null) goto L17;
        return r106;
    L17:
        r103 = r103 + 1;
        goto L3
    L8:
        return String.valueOf(((Number) r105).longValue());
    L18:
        return null;
    }

    public static String c(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        String r104 = null;
        if (r103 >= r102) goto L13;
        String r105 = r100.getString(r101[r103]);
        if (r105 == null) goto L12;
        if ((!StringsKt.isBlank(r105)) == false) goto L10;
        r104 = r105;
    L10:
        if (r104 == null) goto L12;
        return r104;
    L12:
        r103 = r103 + 1;
        goto L3
    L13:
        return null;
    }

    public static JSONObject d(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        Object r104 = null;
        if (r103 >= r102) goto L23;
        Object r105 = r100.get(r101[r103]);
        if ((r105 instanceof JSONObject) == true) goto L8;
        if ((r105 instanceof String) == false) goto L22;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(JSON.parseObject((String) r105));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == true) goto L19;
        r104 = r107;
    L19:
        JSONObject r108 = (JSONObject) r104;
        if (r108 == null) goto L22;
        return r108;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L22:
        r103 = r103 + 1;
        goto L3
    L8:
        return (JSONObject) r105;
    L23:
        return null;
    }

    public static void f(JSONObject r100, String r101, String r102) {
        String r103 = r100.getString(r101);
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L18;
        if (r102 != null) goto L12;
    L15:
        if (r104 == true) goto L19;
        r100.put2(r101, r102);
        return;
    L19:
        return;
    L12:
        if (StringsKt.isBlank(r102) == true) goto L15;
        r104 = false;
        goto L15
    L18:
        return;
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r105 = false;
        goto L9
    }
}
