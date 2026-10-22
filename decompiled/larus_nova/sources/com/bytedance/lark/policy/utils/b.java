package com.bytedance.lark.policy.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f253886a = null;

    static {
        f253886a = new Gson();
    }

    public static final JSONObject b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new JSONObject(f253886a.toJson(r100));
    L5:
        e = move-exception;
        int r101 = Logger.f253883a;
        Logger.b("JSONObject::toJSONObject", "toJSONObject error,errorInfo:" + e);
        return new JSONObject();
    }

    public static final Object a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "path");
        List r102 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);     // Catch: JSONException -> L11
        int r103 = r102.size() - 2;     // Catch: JSONException -> L11
        if (r103 < 0) goto L9;
        int r104 = 0;
    L6:
        r100 = JSONObjectProtectorUtils.getJSONObject(r100, (String) ListProtector.get(r102, r104));     // Catch: JSONException -> L11
        if (r104 == r103) goto L9;
        r104 = r104 + 1;     // Catch: JSONException -> L11
    L9:
        return r100.get((String) ListProtector.get(r102, r102.size() - 1));
    L11:
        return null;
    }
}
