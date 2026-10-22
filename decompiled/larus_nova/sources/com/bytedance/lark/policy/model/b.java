package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/lark/policy/model/CheckPointcutRequest;", "", "pointKey", "", "entityJSONObject", "Lorg/json/JSONObject;", "factors", "", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/List;)V", "getPointKey", "()Ljava/lang/String;", "getEntityJSONObject", "()Lorg/json/JSONObject;", "getFactors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("entityContext")
    private final JSONObject entityJSONObject;

    @SerializedName("factors")
    private final List<String> factors;

    @SerializedName("pointcutKey")
    private final String pointKey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.pointKey, r101.pointKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityJSONObject, r101.entityJSONObject) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.factors, r101.factors) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.pointKey.hashCode() * 31) + this.entityJSONObject.hashCode()) * 31) + this.factors.hashCode();
    }

    public final String toString() {
        return "CheckPointcutRequest(pointKey=" + this.pointKey + ", entityJSONObject=" + this.entityJSONObject + ", factors=" + this.factors + ')';
    }

    public final JSONObject a() {
        return this.entityJSONObject;
    }

    public final List<String> b() {
        return this.factors;
    }

    public final String c() {
        return this.pointKey;
    }

    public b(String r100, JSONObject r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Intrinsics.checkNotNullParameter(r101, "entityJSONObject");
        Intrinsics.checkNotNullParameter(r102, "factors");
        this.pointKey = r100;
        this.entityJSONObject = r101;
        this.factors = r102;
    }
}
