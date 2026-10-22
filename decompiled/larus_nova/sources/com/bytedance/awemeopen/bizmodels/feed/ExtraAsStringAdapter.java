package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r14.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/ExtraAsStringAdapter;", "Lcom/google/gson/TypeAdapter;", "Lr14/s;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class ExtraAsStringAdapter extends TypeAdapter<s> {

    public static final class a {
    }

    static {
    }

    public ExtraAsStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final s read(JsonReader r100) {
        String r101 = null;
        if (r100 != null) goto L37;
        String r102 = null;
    L6:
        JsonObject r103 = new JsonParser().parse(r102).getAsJsonObject();     // Catch: Throwable -> L35
        JsonElement r104 = r103.get("ao_group_source");     // Catch: Throwable -> L35
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getAsInt());     // Catch: Throwable -> L35
    L10:
        JsonElement r106 = r103.get(Constants.JumpUrlConstants.URL_KEY_OPENID);     // Catch: Throwable -> L35
        if (r106 == null) goto L13;
        String r107 = r106.getAsString();     // Catch: Throwable -> L35
    L14:
        JsonElement r108 = r103.get("ao_aweme_host_gid");     // Catch: Throwable -> L35
        if (r108 == null) goto L17;
        String r109 = r108.getAsString();     // Catch: Throwable -> L35
    L18:
        JsonElement r110 = r103.get("filter_exempt");     // Catch: Throwable -> L35
        if (r110 == null) goto L21;
        Boolean r111 = Boolean.valueOf(r110.getAsBoolean());     // Catch: Throwable -> L35
    L22:
        JsonElement r112 = r103.get("ao_recommend_info");     // Catch: Throwable -> L35
        if (r112 == null) goto L27;
        JsonObject r113 = r112.getAsJsonObject();     // Catch: Throwable -> L35
        if (r113 == null) goto L27;
        String r114 = r113.toString();     // Catch: Throwable -> L35
    L28:
        JsonElement r115 = r103.get("log_info");     // Catch: Throwable -> L35
        if (r115 == null) goto L33;
        JsonObject r116 = r115.getAsJsonObject();     // Catch: Throwable -> L35
        if (r116 == null) goto L33;
        r101 = r116.toString();     // Catch: Throwable -> L35
    L33:
        s r117 = new s();     // Catch: Throwable -> L35
        r117.f535649a = r105;     // Catch: Throwable -> L35
        r117.f535650b = r107;     // Catch: Throwable -> L35
        r117.f535651c = r109;     // Catch: Throwable -> L35
        r117.f535652d = r114;     // Catch: Throwable -> L35
        r117.f535653e = r111;     // Catch: Throwable -> L35
        r117.f535654f = r101;     // Catch: Throwable -> L35
        return r117;
    L36:
        return new s();
    L27:
        r114 = null;
        goto L28
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L37:
        r102 = r100.nextString();     // Catch: Throwable -> L35
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, s r101) {
        s r102 = r101;
        if (r100 == null) goto L34;
        if (r102 == null) goto L35;
        JsonObject r103 = new JsonObject();
        Integer r104 = r102.f535649a;
        if (r104 == null) goto L10;
        r103.addProperty("ao_group_source", r104);
    L10:
        String r105 = r102.f535650b;
        if (r105 == null) goto L13;
        r103.addProperty(Constants.JumpUrlConstants.URL_KEY_OPENID, r105);
    L13:
        String r106 = r102.f535651c;
        if (r106 == null) goto L16;
        r103.addProperty("ao_aweme_host_gid", r106);
    L16:
        String r107 = r102.f535651c;
        if (r107 == null) goto L19;
        r103.addProperty("ao_aweme_host_gid", r107);
    L19:
        String r108 = r102.f535652d;
        if (r108 == null) goto L22;
        r103.addProperty("ao_recommend_info", r108);
    L22:
        Boolean r109 = r102.f535653e;
        if (r109 == null) goto L25;
        r103.addProperty("filter_exempt", r109);
    L25:
        String r110 = r102.f535654f;
        if (r110 == null) goto L29;
        r103.addProperty("log_info", r110);
    L29:
        if (r103.size() <= 0) goto L31;
        String r111 = r103.toString();
    L32:
        r100.value(r111);
        return;
    L31:
        r111 = "";
        goto L32
    L35:
        return;
    }
}
