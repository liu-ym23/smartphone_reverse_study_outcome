package com.obric.assistant.cocreationreview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes32.dex */
public final class k {
    public static final ContentValues b(a5 r100) {
        ContentValues r101 = new ContentValues();
        r101.put("record_id", r100.f387183a);
        r101.put("created_at", Long.valueOf(r100.f387188f));
        Vote r102 = r100.f387184b;
        if (r102 == null) goto L5;
        String r103 = r102.getRaw();
    L6:
        r101.put("vote", r103);
        Set<String> r104 = r100.f387185c;
        JSONArray r105 = new JSONArray();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.put((String) r106.next());
        goto L8
    L10:
        r101.put("reasons", r105.toString());
        r101.put("comment", r100.f387186d);
        List<b5> r107 = r100.f387189g;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        JsonArray r108 = new JsonArray();
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r107.iterator();
    L12:
        if (r110.hasNext() == false) goto L26;
        Object r111 = r110.next();
        b5 r112 = (b5) r111;
        boolean r113 = false;
        if (r112.f387205h != FeedbackMediaUploadState.UPLOADED) goto L24;
        String r114 = r112.f387208k;
        if (r114 != null) goto L18;
    L21:
        boolean r115 = true;
    L22:
        if (r115 == true) goto L24;
        r113 = true;
        goto L24
    L18:
        if (StringsKt.isBlank(r114) == true) goto L21;
        r115 = false;
    L24:
        if (r113 == false) goto L12;
        r109.add(r111);
        goto L12
    L26:
        Iterator r116 = r109.iterator();
    L28:
        if (r116.hasNext() == false) goto L30;
        b5 r117 = (b5) r116.next();
        JsonObject r118 = new JsonObject();
        r118.addProperty("id", r117.f387198a);
        r118.addProperty("local_uri", r117.f387199b);
        r118.addProperty("type", r117.getType().name());
        r118.addProperty(IGoogleService.ResponseKey.DISPLAY_NAME, r117.f387201d);
        r118.addProperty("duration_ms", Long.valueOf(r117.f387202e));
        r118.addProperty("remote_uri", r117.f387208k);
        r108.add(r118);
        goto L28
    L30:
        r101.put("media_json", r108.toString());
        r101.put("feedback_value", r100.f387190h);
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    public static final a5 c(Cursor r210) {
        Vote.a r100 = Vote.Companion;
        int r101 = r210.getColumnIndexOrThrow("vote");
        if (r210.isNull(r101) == false) goto L5;
        String r102 = null;
    L6:
        r100.getClass();
        Vote r103 = Vote.a.a(r102);
        JSONArray r104 = new JSONArray(r210.getString(r210.getColumnIndexOrThrow("reasons")));
        LinkedHashSet r105 = new LinkedHashSet();
        int r106 = r104.length();
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L13;
        String r108 = r104.optString(r107);
        Intrinsics.checkNotNull(r108);
        if ((true ^ StringsKt.isBlank(r108)) == false) goto L12;
        r105.add(r108);
    L12:
        r107 = r107 + 1;
        goto L8
    L13:
        String r109 = r210.getString(r210.getColumnIndexOrThrow("record_id"));
        String r110 = r210.getString(r210.getColumnIndexOrThrow("comment"));
        if (r103 != null) goto L16;
    L18:
        boolean r111 = false;
    L19:
        long r112 = r210.getLong(r210.getColumnIndexOrThrow("created_at"));
        String r113 = r210.getString(r210.getColumnIndexOrThrow("media_json"));
        Intrinsics.checkNotNullParameter(r113, "<this>");
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L22
        Object r115 = Result.m9449constructorimpl(JsonParser.parseString(r113).getAsJsonArray());     // Catch: Throwable -> L22
    L24:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L28;
        int r117 = s3.f387719a;
        s3.c("feedback.media.persistence", "parse failed message=" + r116.getMessage());
    L28:
        if (Result.m9455isFailureimpl(r115) == false) goto L30;
        r115 = null;
    L30:
        JsonArray r118 = (JsonArray) r115;
        if (r118 != null) goto L33;
        List r119 = CollectionsKt.emptyList();
    L75:
        int r120 = r210.getColumnIndexOrThrow("feedback_value");
        if (r210.isNull(r120) == true) goto L86;
        Integer r121 = Integer.valueOf(r210.getInt(r120));
        int r122 = r121.intValue();
        if (r122 >= 0) goto L81;
    L83:
        boolean r123 = false;
    L84:
        if (r123 == false) goto L86;
        Integer r124 = r121;
    L88:
        return new a5(r109, r103, r105, r110, r111, r112, r119, r124);
    L81:
        if (r122 >= 10000) goto L83;
        r123 = true;
    L86:
        r124 = null;
        goto L88
    L33:
        ArrayList r125 = new ArrayList();
        Iterator<JsonElement> r126 = r118.iterator();
    L35:
        if (r126.hasNext() == false) goto L74;
        JsonElement r127 = r126.next();
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L62
        JsonObject r129 = r127.getAsJsonObject();     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r129);     // Catch: Throwable -> L62
        String r130 = m.a(r129, "id");     // Catch: Throwable -> L62
        String r131 = m.a(r129, "local_uri");     // Catch: Throwable -> L62
        FeedbackMediaType r132 = FeedbackMediaType.valueOf(m.a(r129, "type"));     // Catch: Throwable -> L62
        String r211 = m.a(r129, "remote_uri");     // Catch: Throwable -> L62
        JsonElement r133 = r129.get(IGoogleService.ResponseKey.DISPLAY_NAME);     // Catch: Throwable -> L62
        if (r133 != null) goto L40;
    L45:
        String r134 = null;
    L46:
        if (r134 != null) goto L48;
        r134 = "";
    L48:
        String r212 = r134;
        JsonElement r135 = r129.get("duration_ms");     // Catch: Throwable -> L62
        if (r135 != null) goto L51;
    L56:
        Long r136 = null;
    L57:
        if (r136 == null) goto L59;
        long r213 = r136.longValue();     // Catch: Throwable -> L62
    L60:
        Object r137 = Result.m9449constructorimpl(new b5(r130, r131, r132, r212, r213, FeedbackMediaUploadState.UPLOADED, 100, r211, 2656));     // Catch: Throwable -> L62
    L64:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L68;
        int r139 = s3.f387719a;
        s3.c("feedback.media.persistence", "drop invalid item message=" + r138.getMessage() + ", item=" + StringsKt.take(r127.toString(), 200));
    L68:
        if (Result.m9455isFailureimpl(r137) == false) goto L70;
        r137 = null;
    L70:
        b5 r140 = (b5) r137;
        if (r140 == null) goto L35;
        r125.add(r140);
        goto L35
    L59:
        r213 = 0;
        goto L60
    L51:
        if (r135.isJsonNull() == false) goto L54;
        r135 = null;
    L54:
        if (r135 == null) goto L56;
        r136 = Long.valueOf(r135.getAsLong());     // Catch: Throwable -> L62
        goto L57
    L40:
        if (r133.isJsonNull() == false) goto L43;
        r133 = null;
    L43:
        if (r133 == null) goto L45;
        r134 = r133.getAsString();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L74:
        r119 = r125;
    L22:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L16:
        if ((!r105.isEmpty()) == false) goto L18;
        r111 = true;
        goto L19
    L5:
        r102 = r210.getString(r101);
        goto L6
    }

    public static final boolean a(SQLiteDatabase r100, String r101) {
        Cursor r102 = r100.rawQuery("PRAGMA table_info(feedback_data)", null);
        Cursor r103 = r102;     // Catch: Throwable -> L12
        int r104 = r103.getColumnIndexOrThrow("name");     // Catch: Throwable -> L12
    L5:
        if (r103.moveToNext() == false) goto L9;
        if (Intrinsics.areEqual(r103.getString(r104), r101) == false) goto L5;
        boolean r105 = true;
    L10:
        CloseableKt.closeFinally(r102, null);
        return r105;
    L9:
        r105 = false;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }
}
