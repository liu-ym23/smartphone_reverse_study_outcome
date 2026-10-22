package com.bytedance.android.shopping.card_list.params;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "Ljava/io/Serializable;", "secUid", "", "uid", "guestUid", "previousPage", "isFromPersonal", "", "collectExperimentValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getCollectExperimentValue", "()I", "setCollectExperimentValue", "(I)V", "getGuestUid", "()Ljava/lang/String;", "()Z", "setFromPersonal", "(Z)V", "getPreviousPage", "setPreviousPage", "(Ljava/lang/String;)V", "getSecUid", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectPassThroughData implements Serializable {

    @SerializedName("collect_experiment_value")
    private int collectExperimentValue;

    @SerializedName("guest_uid")
    private final String guestUid;

    @SerializedName("is_from_personal")
    private boolean isFromPersonal;

    @SerializedName("previous_page")
    private String previousPage;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("uid")
    private final String uid;

    public CollectPassThroughData() {
        this(null, null, null, null, false, 0, 63, null);
    }

    public static /* synthetic */ CollectPassThroughData copy$default(CollectPassThroughData r4, String r5, String r6, String r7, String r8, boolean r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.secUid;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.uid;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.guestUid;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.previousPage;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isFromPersonal;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.collectExperimentValue;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.secUid;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.guestUid;
    }

    public final String component4() {
        return this.previousPage;
    }

    public final boolean component5() {
        return this.isFromPersonal;
    }

    public final int component6() {
        return this.collectExperimentValue;
    }

    public final CollectPassThroughData copy(String r9, String r10, String r11, String r12, boolean r13, int r14) {
        Intrinsics.checkNotNullParameter(r9, "secUid");
        Intrinsics.checkNotNullParameter(r10, "uid");
        Intrinsics.checkNotNullParameter(r11, "guestUid");
        return new CollectPassThroughData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CollectPassThroughData) == false) goto L18;
        CollectPassThroughData r4 = (CollectPassThroughData) r3;
        if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.guestUid, r4.guestUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previousPage, r4.previousPage) == true) goto L14;
        return false;
    L14:
        if (this.isFromPersonal == r4.isFromPersonal) goto L16;
        return false;
    L16:
        if (this.collectExperimentValue == r4.collectExperimentValue) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        String r0 = this.secUid;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.uid;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.guestUid;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.previousPage;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        int r11 = (r9 + r1) * 31;
        boolean r12 = this.isFromPersonal;
        ?? r13 = r12;
        if (r12 == false) goto L21;
        r13 = 1;
    L21:
        return ((r11 + r13) * 31) + this.collectExperimentValue;
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
        return "CollectPassThroughData(secUid=" + this.secUid + ", uid=" + this.uid + ", guestUid=" + this.guestUid + ", previousPage=" + this.previousPage + ", isFromPersonal=" + this.isFromPersonal + ", collectExperimentValue=" + this.collectExperimentValue + ")";
    }

    public final int getCollectExperimentValue() {
        return this.collectExperimentValue;
    }

    public final String getGuestUid() {
        return this.guestUid;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean isFromPersonal() {
        return this.isFromPersonal;
    }

    public final void setCollectExperimentValue(int r1) {
        this.collectExperimentValue = r1;
    }

    public final void setFromPersonal(boolean r1) {
        this.isFromPersonal = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public CollectPassThroughData(String r2, String r3, String r4, String r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "secUid");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "guestUid");
        this.secUid = r2;
        this.uid = r3;
        this.guestUid = r4;
        this.previousPage = r5;
        this.isFromPersonal = r6;
        this.collectExperimentValue = r7;
    }

    public /* synthetic */ CollectPassThroughData(String r5, String r6, String r7, String r8, boolean r9, int r10, int r11, DefaultConstructorMarker r12) {
        String r0 = "";
        if ((r11 & 1) == 0) goto L5;
        String r13 = "";
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r11 & 4) != 0) goto L15;
        r0 = r7;
    L15:
        if ((r11 & 8) == 0) goto L17;
        r8 = null;
    L17:
        String r2 = r8;
        if ((r11 & 16) == 0) goto L20;
        boolean r3 = false;
    L22:
        if ((r11 & 32) == 0) goto L24;
        int r14 = 0;
    L25:
        this(r13, r1, r0, r2, r3, r14);
        return;
    L24:
        r14 = r10;
        goto L25
    L20:
        r3 = r9;
        goto L22
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
