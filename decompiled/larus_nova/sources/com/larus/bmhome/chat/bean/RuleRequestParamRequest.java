package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J2\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/bean/RuleRequestParamRequest;", "", "text", "", "itemId", "", "isHit", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getItemId", "()Ljava/lang/Long;", "setItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setHit", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/RuleRequestParamRequest;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RuleRequestParamRequest {

    @SerializedName("is_hit")
    private Boolean isHit;

    @SerializedName("item_id")
    private Long itemId;

    @SerializedName("text")
    private String text;

    public RuleRequestParamRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RuleRequestParamRequest copy$default(RuleRequestParamRequest r100, String r101, Long r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.itemId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isHit;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.text;
    }

    public final Long component2() {
        return this.itemId;
    }

    public final Boolean component3() {
        return this.isHit;
    }

    public final RuleRequestParamRequest copy(String r100, Long r101, Boolean r102) {
        return new RuleRequestParamRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RuleRequestParamRequest) == true) goto L8;
        return false;
    L8:
        RuleRequestParamRequest r101 = (RuleRequestParamRequest) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isHit, r101.isHit) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.itemId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isHit;
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
        return "RuleRequestParamRequest(text=" + this.text + ", itemId=" + this.itemId + ", isHit=" + this.isHit + ')';
    }

    public final Long getItemId() {
        return this.itemId;
    }

    public final String getText() {
        return this.text;
    }

    public final Boolean isHit() {
        return this.isHit;
    }

    public final void setHit(Boolean r100) {
        this.isHit = r100;
    }

    public final void setItemId(Long r100) {
        this.itemId = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public RuleRequestParamRequest(String r100, Long r101, Boolean r102) {
        this.text = r100;
        this.itemId = r101;
        this.isHit = r102;
    }

    public /* synthetic */ RuleRequestParamRequest(String r100, Long r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = Boolean.FALSE;
    L11:
        this(r100, r101, r102);
    }
}
