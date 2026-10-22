package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEventTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "()V", "mInnerJsonParser", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppEventTypeAdapter implements JsonDeserializer<AppEvent> {
    private final Gson mInnerJsonParser;

    public AppEventTypeAdapter() {
        this.mInnerJsonParser = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AppEvent deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Object r103 = null;
        if (r100 == null) goto L5;
        JsonObject r104 = r100.getAsJsonObject();
    L6:
        if (r104 == null) goto L10;
        JsonElement r105 = r104.get("type");
        if (r105 == null) goto L10;
        String r106 = r105.getAsString();
    L11:
        Iterator<T> r107 = EventTypeKt.a().iterator();
    L13:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((Triple) r108).getFirst(), r106) == false) goto L13;
        r103 = r108;
    L17:
        Triple r109 = (Triple) r103;
        if (r109 == null) goto L24;
        Class r110 = (Class) r109.getSecond();
        if (r110 == null) goto L24;
        return (AppEvent) GsonProtectorUtils.fromJson(this.mInnerJsonParser, r100, r110);
    L24:
        throw new IllegalArgumentException("Unknown entity type: " + r106);
    L10:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ AppEvent deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        return deserialize(r100, r101, r102);
    }
}
