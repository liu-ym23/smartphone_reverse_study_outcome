package com.bytedance.lark.policy.model;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/lark/policy/model/ValidateRequest;", "", "pointKey", "", "entityJSONObject", "Lorg/json/JSONObject;", "enableLocalValidate", "", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "getPointKey", "()Ljava/lang/String;", "getEntityJSONObject", "()Lorg/json/JSONObject;", "getEnableLocalValidate", "()Z", ST.UUID_DEVICE, "getUuid", "uuid$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValidateRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f253843b;

    @SerializedName("entityContext")
    private final JSONObject entityJSONObject;

    @SerializedName("pointcutKey")
    private final String pointKey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ValidateRequest) == true) goto L8;
        return false;
    L8:
        ValidateRequest r101 = (ValidateRequest) r100;
        if (Intrinsics.areEqual(this.pointKey, r101.pointKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityJSONObject, r101.entityJSONObject) == true) goto L15;
        return false;
    L15:
        if (this.f253842a == r101.f253842a) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.pointKey.hashCode() * 31) + this.entityJSONObject.hashCode()) * 31;
        if (this.f253842a == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ValidateRequest(pointKey=" + this.pointKey + ", entityJSONObject=" + this.entityJSONObject + ", enableLocalValidate=" + this.f253842a + ')';
    }

    public final String c() {
        return (String) this.f253843b.getValue();
    }

    public final JSONObject a() {
        return this.entityJSONObject;
    }

    public final String b() {
        return this.pointKey;
    }

    public ValidateRequest(String r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Intrinsics.checkNotNullParameter(r101, "entityJSONObject");
        this.pointKey = r100;
        this.entityJSONObject = r101;
        this.f253842a = r102;
        this.f253843b = LazyKt.lazy(ValidateRequest$uuid$2.INSTANCE);
    }
}
