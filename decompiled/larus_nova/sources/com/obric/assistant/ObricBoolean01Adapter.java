package com.obric.assistant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/ObricBoolean01Adapter;", "Lcom/google/gson/JsonDeserializer;", "", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBoolean01Adapter implements JsonDeserializer<Boolean> {
    public ObricBoolean01Adapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Boolean deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 == null) goto L38;
        if (r100.isJsonNull() == true) goto L38;
        if (r100.isJsonPrimitive() == false) goto L9;
        JsonPrimitive r103 = r100.getAsJsonPrimitive();
        if (r103.isBoolean() == false) goto L13;
        boolean r104 = r103.getAsBoolean();
    L36:
        return Boolean.valueOf(r104);
    L13:
        boolean r105 = true;
        if (r103.isNumber() == false) goto L28;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        if (r103.getAsInt() != 0) goto L19;
        r105 = false;
    L19:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L21
    L23:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = r108;
    L26:
        r104 = ((Boolean) r107).booleanValue();
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L28:
        if (r103.isString() == false) goto L34;
        String r110 = StringsKt.trim(r103.getAsString()).toString().toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r110, "1") == false) goto L32;
    L33:
        r104 = true;
        goto L36
    L32:
        if (Intrinsics.areEqual(r110, "true") == true) goto L33;
    L34:
        r104 = false;
        goto L36
    L9:
        return Boolean.FALSE;
    L38:
        return Boolean.FALSE;
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ Boolean deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        return deserialize(r100, r101, r102);
    }
}
