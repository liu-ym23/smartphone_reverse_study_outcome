package com.bytedance.revenue.platform.api.core;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "", "<init>", "()V", "Adapter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-kmp-core_release"}, k = 1, mv = {1, 7, 1})
public final class JsonOrBytesJvm {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final JsonParser f267499e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonElement f267500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f267501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f267502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f267503d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm$Adapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "lib-kmp-core_release"}, k = 1, mv = {1, 7, 1})
    public static final class Adapter implements JsonSerializer<JsonOrBytesJvm>, JsonDeserializer<JsonOrBytesJvm> {
        public Adapter() {
        }

        @Override // com.google.gson.JsonDeserializer
        public final JsonOrBytesJvm deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "typeOfT");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new JsonOrBytesJvm(r100);
        }

        @Override // com.google.gson.JsonSerializer
        public final JsonElement serialize(JsonOrBytesJvm r100, Type r101, JsonSerializationContext r102) {
            JsonOrBytesJvm r103 = r100;
            Intrinsics.checkNotNullParameter(r103, "src");
            Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return r103.b();
        }
    }

    public static final class a {
    }

    public JsonOrBytesJvm() {
        this(null, null);
    }

    static {
        f267499e = new JsonParser();
    }

    public final boolean a() {
        if (this.f267500a == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f267501b != null) goto L8;
        return false;
    }

    public final JsonElement b() {
        return (JsonElement) this.f267502c.getValue();
    }

    public final String toString() {
        return "JsonOrBytes(json=" + this.f267500a + ", bytes=" + Arrays.toString(this.f267501b) + ')';
    }

    public JsonOrBytesJvm(JsonElement r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        this(r100, null);
    }

    public JsonOrBytesJvm(JsonElement r100, byte[] r101) {
        this.f267500a = r100;
        this.f267501b = r101;
        this.f267502c = LazyKt.lazy(new JsonOrBytesJvm$jsonValue$2(this));
        this.f267503d = LazyKt.lazy(new JsonOrBytesJvm$bytesValue$2(this));
    }
}
