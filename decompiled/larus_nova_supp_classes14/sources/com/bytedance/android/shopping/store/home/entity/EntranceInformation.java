package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "Ljava/io/Serializable;", "entranceIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "entranceUrl", "", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getEntranceIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getEntranceUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInformation implements Serializable {

    @SerializedName("entrance_icon")
    private final ECUrlModel entranceIcon;

    @SerializedName("entrance_url")
    private final String entranceUrl;

    public EntranceInformation() {
        ECUrlModel r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ EntranceInformation copy$default(EntranceInformation r0, ECUrlModel r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.entranceIcon;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entranceUrl;
    L9:
        return r0.copy(r1, r2);
    }

    public final ECUrlModel component1() {
        return this.entranceIcon;
    }

    public final String component2() {
        return this.entranceUrl;
    }

    public final EntranceInformation copy(ECUrlModel r2, String r3) {
        return new EntranceInformation(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EntranceInformation) == false) goto L10;
        EntranceInformation r4 = (EntranceInformation) r3;
        if (Intrinsics.areEqual(this.entranceIcon, r4.entranceIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.entranceUrl, r4.entranceUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ECUrlModel r0 = this.entranceIcon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.entranceUrl;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EntranceInformation(entranceIcon=" + this.entranceIcon + ", entranceUrl=" + this.entranceUrl + ")";
    }

    public final ECUrlModel getEntranceIcon() {
        return this.entranceIcon;
    }

    public final String getEntranceUrl() {
        return this.entranceUrl;
    }

    public EntranceInformation(ECUrlModel r1, String r2) {
        this.entranceIcon = r1;
        this.entranceUrl = r2;
    }

    public /* synthetic */ EntranceInformation(ECUrlModel r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
