package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.shopping.extensions.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BE\u00120\b\u0002\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J1\u0010\f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003JG\u0010\u0011\u001a\u00020\u000020\b\u0002\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\nHÖ\u0003R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRB\u0010\u000f\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ComponentsWrapper;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "blockJSONObject", "", "hasComponents", "hasISVComponent", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "component1", "Lcom/google/gson/JsonObject;", "component2", "components", "block", "copy", "toString", "", "hashCode", "other", "equals", "Lcom/google/gson/JsonArray;", "moduleWrapperList$delegate", "Lkotlin/Lazy;", "getModuleWrapperList", "()Lcom/google/gson/JsonArray;", "moduleWrapperList", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "Lcom/google/gson/JsonObject;", "getBlock", "()Lcom/google/gson/JsonObject;", "<init>", "(Ljava/util/List;Lcom/google/gson/JsonObject;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentsWrapper implements Serializable {

    @SerializedName("block")
    private final JsonObject block;

    @SerializedName("components")
    private final List<HashMap<String, Object>> components;
    private final Lazy moduleWrapperList$delegate;

    public ComponentsWrapper() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComponentsWrapper copy$default(ComponentsWrapper r0, List r1, JsonObject r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.components;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.block;
    L9:
        return r0.copy(r1, r2);
    }

    public final JSONObject blockJSONObject() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        JsonObject r2 = this.block;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        String r3 = r2.toString();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L18;
        r0 = r5;
    L18:
        return (JSONObject) r0;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final List<HashMap<String, Object>> component1() {
        return this.components;
    }

    public final JsonObject component2() {
        return this.block;
    }

    public final ComponentsWrapper copy(List<? extends HashMap<String, Object>> r2, JsonObject r3) {
        return new ComponentsWrapper(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ComponentsWrapper) == false) goto L10;
        ComponentsWrapper r4 = (ComponentsWrapper) r3;
        if (Intrinsics.areEqual(this.components, r4.components) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.block, r4.block) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<HashMap<String, Object>> r0 = this.components;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        JsonObject r4 = this.block;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ComponentsWrapper(components=" + this.components + ", block=" + this.block + ")";
    }

    public final boolean hasComponents() {
        List<HashMap<String, Object>> r0 = this.components;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L19;
        JsonArray r2 = (JsonArray) this.moduleWrapperList$delegate.getValue();
        if (r2 == null) goto L13;
        Integer r3 = Integer.valueOf(r2.size());
    L15:
        if (k.g(r3, 0) > 0) goto L20;
        return false;
    L20:
        return true;
    L13:
        r3 = null;
        goto L15
    L19:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean hasISVComponent() {
        List<HashMap<String, Object>> r0 = this.components;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r4 = null;
        if (r1 == false) goto L46;
        JsonArray r2 = (JsonArray) this.moduleWrapperList$delegate.getValue();
        if (r2 == null) goto L44;
        List r3 = CollectionsKt.toList(r2);
        if (r3 == null) goto L44;
        Iterator r5 = r3.iterator();
    L17:
        if (r5.hasNext() == false) goto L43;
        Object r6 = r5.next();
        JsonElement r7 = (JsonElement) r6;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L34
        if ((r7 instanceof JsonObject) == true) goto L22;
        r7 = null;
    L22:
        JsonObject r9 = (JsonObject) r7;     // Catch: Throwable -> L34
        if (r9 == null) goto L31;
        JsonObject r10 = r9.getAsJsonObject("decoration_module");     // Catch: Throwable -> L34
        if (r10 == null) goto L31;
        JsonElement r11 = r10.get("component_type");     // Catch: Throwable -> L34
        if (r11 == null) goto L31;
        if (r11.getAsInt() != 1) goto L31;
        boolean r12 = true;
    L32:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r12));     // Catch: Throwable -> L34
    L37:
        if (Result.exceptionOrNull-impl(r13) == null) goto L41;
        r13 = Boolean.FALSE;
    L41:
        if (((Boolean) r13).booleanValue() == false) goto L17;
        r4 = r6;
    L31:
        r12 = false;
    L34:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L43:
        r4 = (JsonElement) r4;
    L44:
        if (r4 == null) goto L73;
    L61:
        return true;
    L73:
        return false;
    L46:
        Iterator<T> r15 = this.components.iterator();
    L48:
        if (r15.hasNext() == false) goto L60;
        Object r16 = r15.next();
        Object r17 = ((HashMap) r16).get("component_type");
        if ((r17 instanceof Number) == true) goto L52;
        r17 = null;
    L52:
        Number r18 = (Number) r17;
        if (r18 != null) goto L55;
    L57:
        boolean r19 = false;
    L58:
        if (r19 == false) goto L48;
        r4 = r16;
        goto L60
    L55:
        if (r18.intValue() != 1) goto L57;
        r19 = true;
    L60:
        if (r4 != null) goto L61;
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final JsonObject getBlock() {
        return this.block;
    }

    public final List<HashMap<String, Object>> getComponents() {
        return this.components;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentsWrapper(List<? extends HashMap<String, Object>> r1, JsonObject r2) {
        this.components = r1;
        this.block = r2;
        this.moduleWrapperList$delegate = LazyKt.lazy(new ComponentsWrapper$moduleWrapperList$2(this));
    }

    public /* synthetic */ ComponentsWrapper(List r2, JsonObject r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
