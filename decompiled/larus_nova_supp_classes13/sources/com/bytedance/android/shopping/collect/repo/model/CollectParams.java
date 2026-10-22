package com.bytedance.android.shopping.collect.repo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003Je\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\rHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "Ljava/io/Serializable;", "secUid", "", "uid", "guestUid", "ecomSceneId", "monitorId", "previousPage", "isFromPersonal", "", "session_id", "collectExperimentValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "getCollectExperimentValue", "()I", "setCollectExperimentValue", "(I)V", "getEcomSceneId", "()Ljava/lang/String;", "getGuestUid", "()Z", "setFromPersonal", "(Z)V", "getMonitorId", "setMonitorId", "(Ljava/lang/String;)V", "getPreviousPage", "setPreviousPage", "getSecUid", "getSession_id", "setSession_id", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectParams implements Serializable {

    @SerializedName("collect_experiment_value")
    private int collectExperimentValue;

    @SerializedName("ecom_scene_id")
    private final String ecomSceneId;

    @SerializedName("guest_uid")
    private final String guestUid;

    @SerializedName("is_from_personal")
    private boolean isFromPersonal;

    @SerializedName("monitor_id")
    private String monitorId;

    @SerializedName("previous_page")
    private String previousPage;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("session_id")
    private String session_id;

    @SerializedName("uid")
    private final String uid;

    public CollectParams() {
        this(null, null, null, null, null, null, false, null, 0, 511, null);
    }

    public static /* synthetic */ CollectParams copy$default(CollectParams r10, String r11, String r12, String r13, String r14, String r15, String r16, boolean r17, String r18, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.secUid;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.uid;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.guestUid;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.ecomSceneId;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.monitorId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.previousPage;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.isFromPersonal;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.session_id;
    L35:
        if ((r20 & 256) == 0) goto L37;
        int r1 = r10.collectExperimentValue;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
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
        return this.ecomSceneId;
    }

    public final String component5() {
        return this.monitorId;
    }

    public final String component6() {
        return this.previousPage;
    }

    public final boolean component7() {
        return this.isFromPersonal;
    }

    public final String component8() {
        return this.session_id;
    }

    public final int component9() {
        return this.collectExperimentValue;
    }

    public final CollectParams copy(String r12, String r13, String r14, String r15, String r16, String r17, boolean r18, String r19, int r20) {
        Intrinsics.checkNotNullParameter(r12, "secUid");
        Intrinsics.checkNotNullParameter(r13, "uid");
        Intrinsics.checkNotNullParameter(r14, "guestUid");
        Intrinsics.checkNotNullParameter(r15, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r16, "monitorId");
        Intrinsics.checkNotNullParameter(r17, "previousPage");
        return new CollectParams(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CollectParams) == false) goto L24;
        CollectParams r4 = (CollectParams) r3;
        if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.guestUid, r4.guestUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomSceneId, r4.ecomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorId, r4.monitorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.previousPage, r4.previousPage) == true) goto L18;
        return false;
    L18:
        if (this.isFromPersonal == r4.isFromPersonal) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.session_id, r4.session_id) == true) goto L22;
        return false;
    L22:
        if (this.collectExperimentValue == r4.collectExperimentValue) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v24 */
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
        String r10 = this.ecomSceneId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.monitorId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.previousPage;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.isFromPersonal;
        ?? r20 = r19;
        if (r19 == false) goto L29;
        r20 = 1;
    L29:
        int r21 = (r18 + r20) * 31;
        String r22 = this.session_id;
        if (r22 == null) goto L33;
        r1 = r22.hashCode();
    L33:
        return ((r21 + r1) * 31) + this.collectExperimentValue;
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

    public String toString() {
        return "CollectParams(secUid=" + this.secUid + ", uid=" + this.uid + ", guestUid=" + this.guestUid + ", ecomSceneId=" + this.ecomSceneId + ", monitorId=" + this.monitorId + ", previousPage=" + this.previousPage + ", isFromPersonal=" + this.isFromPersonal + ", session_id=" + this.session_id + ", collectExperimentValue=" + this.collectExperimentValue + ")";
    }

    public final int getCollectExperimentValue() {
        return this.collectExperimentValue;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getGuestUid() {
        return this.guestUid;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getSession_id() {
        return this.session_id;
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

    public final void setMonitorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.monitorId = r2;
    }

    public final void setPreviousPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previousPage = r2;
    }

    public final void setSession_id(String r1) {
        this.session_id = r1;
    }

    public CollectParams(String r2, String r3, String r4, String r5, String r6, String r7, boolean r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, "secUid");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "guestUid");
        Intrinsics.checkNotNullParameter(r5, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r6, "monitorId");
        Intrinsics.checkNotNullParameter(r7, "previousPage");
        this.secUid = r2;
        this.uid = r3;
        this.guestUid = r4;
        this.ecomSceneId = r5;
        this.monitorId = r6;
        this.previousPage = r7;
        this.isFromPersonal = r8;
        this.session_id = r9;
        this.collectExperimentValue = r10;
    }

    public /* synthetic */ CollectParams(String r11, String r12, String r13, String r14, String r15, String r16, boolean r17, String r18, int r19, int r20, DefaultConstructorMarker r21) {
        String r2 = "";
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r20 & 32) != 0) goto L26;
        r2 = r16;
    L26:
        int r8 = 0;
        if ((r20 & 64) == 0) goto L29;
        boolean r7 = false;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = "none";
    L35:
        if ((r20 & 256) != 0) goto L38;
        r8 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r2, r7, r9, r8);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r7 = r17;
        goto L31
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
