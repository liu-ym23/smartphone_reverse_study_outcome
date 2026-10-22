package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeMeta;", "Ljava/io/Serializable;", "trackMeta", "", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeBusinessMeta;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeBusinessMeta;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeBusinessMeta;", "getTrackMeta", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4ReceivingNoticeBusinessMeta businessMeta;

    @SerializedName("track_meta")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4ReceivingNoticeMeta() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4ReceivingNoticeMeta copy$default(AnchorV4ReceivingNoticeMeta r0, String r1, AnchorV4ReceivingNoticeBusinessMeta r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.trackMeta;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.businessMeta;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.trackMeta;
    }

    public final AnchorV4ReceivingNoticeBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4ReceivingNoticeMeta copy(String r2, AnchorV4ReceivingNoticeBusinessMeta r3) {
        return new AnchorV4ReceivingNoticeMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ReceivingNoticeMeta) == false) goto L10;
        AnchorV4ReceivingNoticeMeta r4 = (AnchorV4ReceivingNoticeMeta) r3;
        if (Intrinsics.areEqual(this.trackMeta, r4.trackMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessMeta, r4.businessMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.trackMeta;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4ReceivingNoticeBusinessMeta r4 = this.businessMeta;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4ReceivingNoticeMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4ReceivingNoticeBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final String getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4ReceivingNoticeMeta(String r1, AnchorV4ReceivingNoticeBusinessMeta r2) {
        this.trackMeta = r1;
        this.businessMeta = r2;
    }

    public /* synthetic */ AnchorV4ReceivingNoticeMeta(String r2, AnchorV4ReceivingNoticeBusinessMeta r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
