package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "Ljava/io/Serializable;", "lynxId", "", "lynxUrl", "lynxData", "Lcom/google/gson/JsonObject;", "config", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;)V", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "setConfig", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;)V", "getLynxData", "()Lcom/google/gson/JsonObject;", "getLynxId", "()Ljava/lang/String;", "getLynxUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantLynx implements Serializable {
    private ConfigMode config;

    @SerializedName("data")
    private final JsonObject lynxData;

    @SerializedName("id")
    private final String lynxId;

    @SerializedName("url")
    private final String lynxUrl;

    public HeaderPendantLynx() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ HeaderPendantLynx copy$default(HeaderPendantLynx r0, String r1, String r2, JsonObject r3, ConfigMode r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.lynxId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.lynxUrl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.lynxData;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.config;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.lynxId;
    }

    public final String component2() {
        return this.lynxUrl;
    }

    public final JsonObject component3() {
        return this.lynxData;
    }

    public final ConfigMode component4() {
        return this.config;
    }

    public final HeaderPendantLynx copy(String r2, String r3, JsonObject r4, ConfigMode r5) {
        return new HeaderPendantLynx(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderPendantLynx) == false) goto L14;
        HeaderPendantLynx r4 = (HeaderPendantLynx) r3;
        if (Intrinsics.areEqual(this.lynxId, r4.lynxId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxUrl, r4.lynxUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxData, r4.lynxData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r4.config) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.lynxId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.lynxUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        JsonObject r7 = this.lynxData;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ConfigMode r10 = this.config;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPendantLynx(lynxId=" + this.lynxId + ", lynxUrl=" + this.lynxUrl + ", lynxData=" + this.lynxData + ", config=" + this.config + ")";
    }

    public final ConfigMode getConfig() {
        return this.config;
    }

    public final JsonObject getLynxData() {
        return this.lynxData;
    }

    public final String getLynxId() {
        return this.lynxId;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final void setConfig(ConfigMode r1) {
        this.config = r1;
    }

    public HeaderPendantLynx(String r1, String r2, JsonObject r3, ConfigMode r4) {
        this.lynxId = r1;
        this.lynxUrl = r2;
        this.lynxData = r3;
        this.config = r4;
    }

    public /* synthetic */ HeaderPendantLynx(String r2, String r3, JsonObject r4, ConfigMode r5, int r6, DefaultConstructorMarker r7) {
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
