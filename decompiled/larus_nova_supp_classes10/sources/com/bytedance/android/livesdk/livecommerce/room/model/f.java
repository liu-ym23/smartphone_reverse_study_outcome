package com.bytedance.android.livesdk.livecommerce.room.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/f;", "", "", "roomId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "roomUniqueKey", "f", "ecomEntranceForm", "b", "", "sourcePage", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "", "entranceInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "addToCartEntranceInfo", "a", "Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "promotion", "Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("add_to_cart_entrance_info")
    private final Map<String, Object> addToCartEntranceInfo;

    @SerializedName("ecom_entrance_form")
    private final String ecomEntranceForm;

    @SerializedName("entrance_info")
    private final Map<String, Object> entranceInfo;

    @SerializedName("promotion")
    private final c promotion;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_unique_key")
    private final String roomUniqueKey;

    @SerializedName("source_page")
    private final Integer sourcePage;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L20;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomUniqueKey, r4.roomUniqueKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ecomEntranceForm, r4.ecomEntranceForm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourcePage, r4.sourcePage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.entranceInfo, r4.entranceInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addToCartEntranceInfo, r4.addToCartEntranceInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotion, r4.promotion) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.roomUniqueKey;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.ecomEntranceForm;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.sourcePage;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, Object> r13 = this.entranceInfo;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, Object> r16 = this.addToCartEntranceInfo;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        c r19 = this.promotion;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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

    public final String toString() {
        return "IParams(roomId=" + this.roomId + ", roomUniqueKey=" + this.roomUniqueKey + ", ecomEntranceForm=" + this.ecomEntranceForm + ", sourcePage=" + this.sourcePage + ", entranceInfo=" + this.entranceInfo + ", addToCartEntranceInfo=" + this.addToCartEntranceInfo + ", promotion=" + this.promotion + ")";
    }

    public f() {
        this.roomId = null;
        this.roomUniqueKey = null;
        this.ecomEntranceForm = null;
        this.sourcePage = null;
        this.entranceInfo = null;
        this.addToCartEntranceInfo = null;
        this.promotion = null;
    }

    public final Map<String, Object> a() {
        return this.addToCartEntranceInfo;
    }

    public final String b() {
        return this.ecomEntranceForm;
    }

    public final Map<String, Object> c() {
        return this.entranceInfo;
    }

    public final c d() {
        return this.promotion;
    }

    public final String e() {
        return this.roomId;
    }

    public final String f() {
        return this.roomUniqueKey;
    }

    public final Integer g() {
        return this.sourcePage;
    }
}
