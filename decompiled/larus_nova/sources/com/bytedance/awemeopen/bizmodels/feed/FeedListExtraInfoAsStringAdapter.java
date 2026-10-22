package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import r14.v;
import r14.x;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/FeedListExtraInfoAsStringAdapter;", "Lcom/google/gson/TypeAdapter;", "Lr14/v;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class FeedListExtraInfoAsStringAdapter extends TypeAdapter<v> {

    public static final class a {
    }

    static {
    }

    public FeedListExtraInfoAsStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final v read(JsonReader r100) {
        JsonObject r101 = null;
        if (r100 != null) goto L25;
        String r102 = null;
    L6:
        JsonObject r103 = new JsonParser().parse(r102).getAsJsonObject();     // Catch: Throwable -> L22
        JsonElement r104 = r103.get("access_token_status");     // Catch: Throwable -> L22
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getAsInt());     // Catch: Throwable -> L22
    L10:
        v r106 = new v();     // Catch: Throwable -> L22
        r106.f535655a = r105;     // Catch: Throwable -> L22
        JsonElement r107 = r103.get("ao_host_extra_info");     // Catch: Throwable -> L24
        if (r107 == null) goto L14;
        String r108 = r107.getAsString();     // Catch: Throwable -> L24
    L15:
        JsonObject r109 = new JsonParser().parse(r108).getAsJsonObject();     // Catch: Throwable -> L24
        if (r109 == null) goto L20;
        JsonElement r110 = r109.get("host_chain_params");     // Catch: Throwable -> L24
        if (r110 == null) goto L20;
        r101 = r110.getAsJsonObject();     // Catch: Throwable -> L24
    L20:
        x r111 = new x();     // Catch: Throwable -> L24
        r111.b(String.valueOf(r101));     // Catch: Throwable -> L24
        r106.b(r111);     // Catch: Throwable -> L24
        return r106;
    L14:
        r108 = null;
    L30:
        return r106;
    L23:
        return new v();
    L9:
        r105 = null;
        goto L10
    L25:
        r102 = r100.nextString();     // Catch: Throwable -> L22
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, v r101) {
        v r102 = r101;
        if (r100 == null) goto L16;
        if (r102 == null) goto L17;
        JsonObject r103 = new JsonObject();
        Integer r104 = r102.f535655a;
        if (r104 == null) goto L11;
        r103.addProperty("access_token_status", r104);
    L11:
        if (r103.size() <= 0) goto L13;
        String r105 = r103.toString();
    L14:
        r100.value(r105);
        return;
    L13:
        r105 = "";
        goto L14
    L17:
        return;
    }
}
