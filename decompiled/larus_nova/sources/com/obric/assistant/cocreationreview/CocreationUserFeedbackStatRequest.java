package com.obric.assistant.cocreationreview;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003Jg\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;", "", "uniqId", "", "date", "total", "", "completed", "skipped", "likes", "unlikes", "details", "", "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIILjava/util/List;)V", "getUniqId", "()Ljava/lang/String;", "getDate", "getTotal", "()I", "getCompleted", "getSkipped", "getLikes", "getUnlikes", "getDetails", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackStatRequest {

    @SerializedName("completed")
    private final int completed;

    @SerializedName("date")
    private final String date;

    @SerializedName("details")
    private final List<CocreationUserFeedbackStatDetail> details;

    @SerializedName("likes")
    private final int likes;

    @SerializedName("skipped")
    private final int skipped;

    @SerializedName("total")
    private final int total;

    @SerializedName("uniq_id")
    private final String uniqId;

    @SerializedName("unlikes")
    private final int unlikes;

    public CocreationUserFeedbackStatRequest() {
        this(null, null, 0, 0, 0, 0, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CocreationUserFeedbackStatRequest copy$default(CocreationUserFeedbackStatRequest r100, String r110, String r111, int r112, int r113, int r114, int r115, int r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.uniqId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.date;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.total;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.completed;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.skipped;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.likes;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.unlikes;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.details;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.uniqId;
    }

    public final String component2() {
        return this.date;
    }

    public final int component3() {
        return this.total;
    }

    public final int component4() {
        return this.completed;
    }

    public final int component5() {
        return this.skipped;
    }

    public final int component6() {
        return this.likes;
    }

    public final int component7() {
        return this.unlikes;
    }

    public final List<CocreationUserFeedbackStatDetail> component8() {
        return this.details;
    }

    public final CocreationUserFeedbackStatRequest copy(String r110, String r111, int r112, int r113, int r114, int r115, int r116, List<CocreationUserFeedbackStatDetail> r117) {
        return new CocreationUserFeedbackStatRequest(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CocreationUserFeedbackStatRequest) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackStatRequest r101 = (CocreationUserFeedbackStatRequest) r100;
        if (Intrinsics.areEqual(this.uniqId, r101.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L15;
        return false;
    L15:
        if (this.total == r101.total) goto L18;
        return false;
    L18:
        if (this.completed == r101.completed) goto L21;
        return false;
    L21:
        if (this.skipped == r101.skipped) goto L24;
        return false;
    L24:
        if (this.likes == r101.likes) goto L27;
        return false;
    L27:
        if (this.unlikes == r101.unlikes) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.details, r101.details) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.uniqId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.date;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.total) * 31) + this.completed) * 31) + this.skipped) * 31) + this.likes) * 31) + this.unlikes) * 31;
        List<CocreationUserFeedbackStatDetail> r107 = this.details;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CocreationUserFeedbackStatRequest(uniqId=" + this.uniqId + ", date=" + this.date + ", total=" + this.total + ", completed=" + this.completed + ", skipped=" + this.skipped + ", likes=" + this.likes + ", unlikes=" + this.unlikes + ", details=" + this.details + ')';
    }

    public final int getCompleted() {
        return this.completed;
    }

    public final String getDate() {
        return this.date;
    }

    public final List<CocreationUserFeedbackStatDetail> getDetails() {
        return this.details;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final int getSkipped() {
        return this.skipped;
    }

    public final int getTotal() {
        return this.total;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final int getUnlikes() {
        return this.unlikes;
    }

    public CocreationUserFeedbackStatRequest(String r100, String r101, int r102, int r103, int r104, int r105, int r106, List<CocreationUserFeedbackStatDetail> r107) {
        this.uniqId = r100;
        this.date = r101;
        this.total = r102;
        this.completed = r103;
        this.skipped = r104;
        this.likes = r105;
        this.unlikes = r106;
        this.details = r107;
    }

    public /* synthetic */ CocreationUserFeedbackStatRequest(String r110, String r111, int r112, int r113, int r114, int r115, int r116, List r117, int r118, DefaultConstructorMarker r210) {
        List r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L10:
        int r103 = 0;
        if ((r118 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r103 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r105, r106, r107, r103, r100);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
