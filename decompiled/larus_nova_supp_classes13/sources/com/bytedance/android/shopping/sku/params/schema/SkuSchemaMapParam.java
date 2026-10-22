package com.bytedance.android.shopping.sku.params.schema;

import android.net.Uri;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R%\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "", "Ljava/io/Serializable;", "", "key", "value", "", "appendOrReplaceParams", "Landroid/net/Uri;", "uri", "initData", "", "getInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "", "getLong", "(Ljava/lang/String;)Ljava/lang/Long;", "", "mutableMap", "Ljava/util/Map;", "", "map", "getMap", "()Ljava/util/Map;", "paramKey", "Ljava/lang/String;", "getParamKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SkuSchemaMapParam implements Serializable {
    private final Map<String, Object> map;

    @SerializedName("mutable_map")
    private final Map<String, Object> mutableMap;
    private final String paramKey;

    public final Map<String, Object> getMap() {
        return this.map;
    }

    public final String getParamKey() {
        return this.paramKey;
    }

    public SkuSchemaMapParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "paramKey");
        this.paramKey = r2;
        Map<String, Object> r3 = Collections.synchronizedMap(new LinkedHashMap());
        this.mutableMap = r3;
        this.map = r3;
    }

    public final Float getFloat(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r2 = this.map.get(r4);     // Catch: Throwable -> L14
        if ((r2 instanceof Number) == false) goto L7;
        this.mutableMap.put(r4, Float.valueOf(((Number) r2).floatValue()));     // Catch: Throwable -> L14
    L9:
        Object r5 = this.map.get(r4);     // Catch: Throwable -> L14
        if ((r5 instanceof Float) == true) goto L12;
        r5 = null;
    L12:
        return (Float) r5;
    L7:
        if ((r2 instanceof String) == false) goto L9;
        this.mutableMap.put(r4, Float.valueOf(CastFloatProtector.parseFloat((String) r2)));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public final Integer getInt(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r2 = this.map.get(r4);     // Catch: Throwable -> L14
        if ((r2 instanceof Number) == false) goto L7;
        this.mutableMap.put(r4, Integer.valueOf(((Number) r2).intValue()));     // Catch: Throwable -> L14
    L9:
        Object r5 = this.map.get(r4);     // Catch: Throwable -> L14
        if ((r5 instanceof Integer) == true) goto L12;
        r5 = null;
    L12:
        return (Integer) r5;
    L7:
        if ((r2 instanceof String) == false) goto L9;
        this.mutableMap.put(r4, Integer.valueOf(CastIntegerProtector.parseInt((String) r2)));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public final Long getLong(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r2 = this.map.get(r6);     // Catch: Throwable -> L14
        if ((r2 instanceof Number) == false) goto L7;
        this.mutableMap.put(r6, Long.valueOf(((Number) r2).longValue()));     // Catch: Throwable -> L14
    L9:
        Object r7 = this.map.get(r6);     // Catch: Throwable -> L14
        if ((r7 instanceof Long) == true) goto L12;
        r7 = null;
    L12:
        return (Long) r7;
    L7:
        if ((r2 instanceof String) == false) goto L9;
        this.mutableMap.put(r6, Long.valueOf(CastLongProtector.parseLong((String) r2)));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public final void initData(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        Map<String, Object> r0 = this.mutableMap;
        String r2 = null;
        String r5 = UriProtector.getQueryParameter(r4, this.paramKey);     // Catch: Throwable -> L5
    L6:
        if (r5 != null) goto L8;
    L12:
        JSONObject r6 = new JSONObject();
    L13:
        r0.putAll(MapsKt.toMutableMap(a.b(r6)));
        return;
    L8:
        if ((!Intrinsics.areEqual(r5, "null")) == false) goto L10;
        r2 = r5;
    L10:
        if (r2 == null) goto L12;
        r6 = k.u(r2);
    L5:
        r5 = null;
        goto L6
    }

    public final void appendOrReplaceParams(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.mutableMap.put(r2, r3);
    }
}
