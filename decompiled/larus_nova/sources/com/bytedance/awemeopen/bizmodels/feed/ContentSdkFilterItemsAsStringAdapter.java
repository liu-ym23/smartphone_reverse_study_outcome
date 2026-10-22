package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import r14.r;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/ContentSdkFilterItemsAsStringAdapter;", "Lcom/google/gson/TypeAdapter;", "Lr14/r;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class ContentSdkFilterItemsAsStringAdapter extends TypeAdapter<r> {

    public static final class a {
    }

    static {
    }

    public ContentSdkFilterItemsAsStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final r read(JsonReader r100) {
        if (r100 != null) goto L24;
        String r101 = null;
    L6:
        JsonArray r102 = new JsonParser().parse(r101).getAsJsonArray();     // Catch: Throwable -> L22
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L22
        Iterator<JsonElement> r104 = r102.iterator();     // Catch: Throwable -> L22
    L8:
        if (r104.hasNext() == false) goto L20;
        JsonObject r105 = r104.next().getAsJsonObject();     // Catch: Throwable -> L22
        JsonElement r106 = r105.get("ItemId");     // Catch: Throwable -> L22
        if (r106 == null) goto L12;
        String r107 = r106.getAsString();     // Catch: Throwable -> L22
    L13:
        JsonElement r108 = r105.get("Reason");     // Catch: Throwable -> L22
        if (r108 == null) goto L16;
        String r109 = r108.getAsString();     // Catch: Throwable -> L22
    L17:
        r.a r110 = new r.a(r107, r109);     // Catch: Throwable -> L22
        if (r103.contains(r110) == true) goto L8;
        r103.add(r110);     // Catch: Throwable -> L22
        goto L8
    L16:
        r109 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L20:
        r r111 = new r();     // Catch: Throwable -> L22
        r111.f535646a = r103;     // Catch: Throwable -> L22
        return r111;
    L23:
        return new r();
    L24:
        r101 = r100.nextString();     // Catch: Throwable -> L22
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, r r101) {
        r r102 = r101;
        if (r100 == null) goto L28;
        if (r102 == null) goto L29;
        JsonArray r103 = new JsonArray();
        List<r.a> r104 = r102.f535646a;
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L22;
        List<r.a> r106 = r102.f535646a;
        if (r106 == null) goto L22;
        Iterator<T> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L22;
        r.a r108 = (r.a) r107.next();
        JsonObject r109 = new JsonObject();
        r109.addProperty("ItemId", r108.f535647a);
        r109.addProperty("Reason", r108.f535648b);
        r103.add(r109);
    L22:
        if (r103.size() <= 0) goto L24;
        String r110 = r103.toString();
    L25:
        r100.value(r110);
        return;
    L24:
        r110 = "";
        goto L25
    L10:
        if (r104.isEmpty() == true) goto L13;
        r105 = false;
        goto L14
    L29:
        return;
    }
}
