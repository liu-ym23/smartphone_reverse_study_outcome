package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00120\b\u0002\u0010\u0004\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R>\u0010\u0004\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ECStoreHybridTabInitialDataResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "bundleUrl", "", "components", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "passThrough2FE", "block", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getBlock", "()Lcom/google/gson/JsonObject;", "getBundleUrl", "()Ljava/lang/String;", "getComponents", "()Ljava/util/List;", "getPassThrough2FE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabInitialDataResponseDTO extends CommerceBaseResponse {

    @SerializedName("block")
    private final JsonObject block;

    @SerializedName("bundle_url")
    private final String bundleUrl;

    @SerializedName("components")
    private final List<HashMap<String, Object>> components;

    @SerializedName("pass_through_fe")
    private final String passThrough2FE;

    public ECStoreHybridTabInitialDataResponseDTO() {
        this(null, null, null, null, 15, null);
    }

    public final JsonObject getBlock() {
        return this.block;
    }

    public final String getBundleUrl() {
        return this.bundleUrl;
    }

    public final List<HashMap<String, Object>> getComponents() {
        return this.components;
    }

    public final String getPassThrough2FE() {
        return this.passThrough2FE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECStoreHybridTabInitialDataResponseDTO(String r1, List<? extends HashMap<String, Object>> r2, String r3, JsonObject r4) {
        this.bundleUrl = r1;
        this.components = r2;
        this.passThrough2FE = r3;
        this.block = r4;
    }

    public /* synthetic */ ECStoreHybridTabInitialDataResponseDTO(String r2, List r3, String r4, JsonObject r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
