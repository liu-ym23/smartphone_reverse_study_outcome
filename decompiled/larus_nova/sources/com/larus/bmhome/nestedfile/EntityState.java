package com.larus.bmhome.nestedfile;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006*"}, d2 = {"Lcom/larus/bmhome/nestedfile/EntityState;", "Ljava/io/Serializable;", "fileIdentifier", "", "updateFields", "", "", "reviewState", "parseState", "audioDetailUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getFileIdentifier", "()Ljava/lang/String;", "setFileIdentifier", "(Ljava/lang/String;)V", "getUpdateFields", "()Ljava/util/List;", "setUpdateFields", "(Ljava/util/List;)V", "getReviewState", "()Ljava/lang/Integer;", "setReviewState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getParseState", "setParseState", "getAudioDetailUrl", "setAudioDetailUrl", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/nestedfile/EntityState;", "equals", "", "other", "", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntityState implements Serializable {

    @SerializedName("audio_detail_url")
    private String audioDetailUrl;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private String fileIdentifier;

    @SerializedName("parse_state")
    private Integer parseState;

    @SerializedName("review_state")
    private Integer reviewState;

    @SerializedName("update_fields")
    private List<Integer> updateFields;

    public EntityState() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityState copy$default(EntityState r100, String r101, List r102, Integer r103, Integer r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.fileIdentifier;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.updateFields;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.reviewState;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.parseState;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.audioDetailUrl;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.fileIdentifier;
    }

    public final List<Integer> component2() {
        return this.updateFields;
    }

    public final Integer component3() {
        return this.reviewState;
    }

    public final Integer component4() {
        return this.parseState;
    }

    public final String component5() {
        return this.audioDetailUrl;
    }

    public final EntityState copy(String r100, List<Integer> r101, Integer r110, Integer r111, String r112) {
        return new EntityState(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntityState) == true) goto L8;
        return false;
    L8:
        EntityState r101 = (EntityState) r100;
        if (Intrinsics.areEqual(this.fileIdentifier, r101.fileIdentifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updateFields, r101.updateFields) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.reviewState, r101.reviewState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parseState, r101.parseState) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.audioDetailUrl, r101.audioDetailUrl) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.fileIdentifier;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.updateFields;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.reviewState;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.parseState;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.audioDetailUrl;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String getAudioDetailUrl() {
        return this.audioDetailUrl;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final Integer getParseState() {
        return this.parseState;
    }

    public final Integer getReviewState() {
        return this.reviewState;
    }

    public final List<Integer> getUpdateFields() {
        return this.updateFields;
    }

    public final void setAudioDetailUrl(String r100) {
        this.audioDetailUrl = r100;
    }

    public final void setFileIdentifier(String r100) {
        this.fileIdentifier = r100;
    }

    public final void setParseState(Integer r100) {
        this.parseState = r100;
    }

    public final void setReviewState(Integer r100) {
        this.reviewState = r100;
    }

    public final void setUpdateFields(List<Integer> r100) {
        this.updateFields = r100;
    }

    public EntityState(String r100, List<Integer> r101, Integer r102, Integer r103, String r104) {
        this.fileIdentifier = r100;
        this.updateFields = r101;
        this.reviewState = r102;
        this.parseState = r103;
        this.audioDetailUrl = r104;
    }

    public /* synthetic */ EntityState(String r100, List r101, Integer r102, Integer r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        List r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
