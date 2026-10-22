package com.ss.android.lark.opmonitor.trace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class OPTraceGSONParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f437603a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/opmonitor/trace/OPTraceGSONParser$OPTraceTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OPTraceTypeAdapter implements JsonDeserializer<OPTrace> {
        public OPTraceTypeAdapter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.JsonDeserializer
        public final OPTrace deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
            if (r100 == null) goto L48;
            JsonObject r103 = r100.getAsJsonObject();     // Catch: Exception -> L36
            if (r103 == null) goto L49;
            JsonElement r104 = r103.get("trace");     // Catch: Exception -> L36
            if (r104 == null) goto L9;
            JsonObject r105 = r104.getAsJsonObject();     // Catch: Exception -> L36
        L10:
            if (r105 == null) goto L12;
            Object r106 = OPTraceGSONParser.f437603a.fromJson(r105, new b().getType());     // Catch: Exception -> L36
        L13:
            Ref.ObjectRef r107 = new Ref.ObjectRef();     // Catch: Exception -> L36
            TracingSpanImpl r108 = (TracingSpanImpl) r106;     // Catch: Exception -> L36
            if (r108 == null) goto L16;
            T r109 = new OPTrace(r108);     // Catch: Exception -> L36
        L17:
            r107.element = r109;     // Catch: Exception -> L36
            JsonElement r110 = r103.get("monitorCache");     // Catch: Exception -> L36
            if (r110 == null) goto L20;
            JsonArray r111 = r110.getAsJsonArray();     // Catch: Exception -> L36
        L21:
            if (r111 == null) goto L30;
            Iterator<JsonElement> r112 = r111.iterator();     // Catch: Exception -> L36
        L24:
            if (r112.hasNext() == false) goto L30;
            JsonElement r113 = r112.next();     // Catch: Exception -> L36
            if (r113 == null) goto L24;
            String r114 = OPTraceGSONParser.f437603a.toJson(r113);     // Catch: Exception -> L36
            if (r114 == null) goto L24;
            ((OPTrace) r107.element).getMonitors().add(r114);     // Catch: Exception -> L36
        L30:
            JsonElement r115 = r103.get("batchEnabled");     // Catch: Exception -> L36
            if (r115 == null) goto L33;
            boolean r116 = r115.getAsBoolean();     // Catch: Exception -> L36
        L34:
            ((OPTrace) r107.element).setBatchEnabled(r116);     // Catch: Exception -> L36
            return (OPTrace) r107.element;
        L33:
            r116 = false;
            goto L34
        L20:
            r111 = null;
            goto L21
        L16:
            r109 = gyb.a.a();     // Catch: Exception -> L36
            goto L17
        L12:
            r106 = null;
            goto L13
        L9:
            r105 = null;
            goto L10
        L49:
            return null;
        L36:
            e = move-exception;
            Log.e("OPTraceGSONParser", "deserialize error:" + e.getMessage());
            return null;
        L48:
            return null;
        }
    }

    public static final class a {
    }

    static {
        f437603a = new GsonBuilder().registerTypeAdapter(OPTrace.class, new OPTraceTypeAdapter()).excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();
    }
}
