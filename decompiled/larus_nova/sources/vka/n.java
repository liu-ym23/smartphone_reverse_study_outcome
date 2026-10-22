package vka;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n {
    public static final JsonElement a(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!r102.isJsonNull()) == false) goto L7;
        return r102;
    }

    public static final JsonArray b(Cursor r100, boolean r101) {
        JsonArray r102 = new JsonArray();
        if (r100 != null) goto L5;
        return r102;
    L5:
        if (r101 == false) goto L7;
        Function1 r103 = new l();
    L9:
        if (r100.moveToNext() == false) goto L11;
        r102.add((JsonElement) r103.invoke(r100));
        goto L9
    L11:
        return r102;
    L7:
        r103 = new m();
        goto L9
    }
}
