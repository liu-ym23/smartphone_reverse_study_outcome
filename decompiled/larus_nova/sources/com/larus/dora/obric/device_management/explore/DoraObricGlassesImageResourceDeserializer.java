package com.larus.dora.obric.device_management.explore;

import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResourceDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DoraObricGlassesImageResourceDeserializer implements JsonDeserializer<DoraObricGlassesImageResource> {
    public DoraObricGlassesImageResourceDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final DoraObricGlassesImageResource deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r100.getAsJsonObject();
        JsonElement r104 = r103.get("url");
        String r105 = null;
        if (r104 == null) goto L12;
        String r106 = r104.getAsString();
        if (r106 == null) goto L12;
        if ((!StringsKt.isBlank(r106)) == true) goto L10;
        r106 = null;
    L10:
        if (r106 == null) goto L12;
        return new DoraObricGlassesImageResource.RemoteUrl(r106);
    L12:
        JsonElement r107 = r103.get("resId");
        if (r107 == null) goto L23;
        Integer r108 = Integer.valueOf(r107.getAsInt());
        if (r108.intValue() == 0) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == true) goto L21;
        r108 = null;
    L21:
        if (r108 == null) goto L23;
        return new DoraObricGlassesImageResource.Apk(r108.intValue());
    L17:
        r109 = false;
    L23:
        JsonElement r110 = r103.get("uri");
        if (r110 == null) goto L34;
        String r111 = r110.getAsString();
        if (r111 == null) goto L34;
        if ((true ^ StringsKt.isBlank(r111)) == false) goto L30;
        r105 = r111;
    L30:
        if (r105 == null) goto L34;
        return new DoraObricGlassesImageResource.FileUri(UriProtector.parse(r105));
    L34:
        throw new JsonParseException("unknown DoraObricGlassesImageResource payload: " + r103);
    }
}
