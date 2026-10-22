package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/PromptItem;", "", SubInfo.KEY_FORMAT, "", "formatType", "", "matchUiId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFormat", "()Ljava/lang/String;", "getFormatType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMatchUiId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/canvas/service/bean/PromptItem;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptItem {

    @SerializedName(SubInfo.KEY_FORMAT)
    private final String format;

    @SerializedName("format_type")
    private final Integer formatType;

    @SerializedName("match_ui_id")
    private final String matchUiId;

    public PromptItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PromptItem copy$default(PromptItem r100, String r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.format;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.formatType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.matchUiId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.format;
    }

    public final Integer component2() {
        return this.formatType;
    }

    public final String component3() {
        return this.matchUiId;
    }

    public final PromptItem copy(String r100, Integer r101, String r102) {
        return new PromptItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PromptItem) == true) goto L8;
        return false;
    L8:
        PromptItem r101 = (PromptItem) r100;
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formatType, r101.formatType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.matchUiId, r101.matchUiId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.format;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.formatType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.matchUiId;
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
        return "PromptItem(format=" + this.format + ", formatType=" + this.formatType + ", matchUiId=" + this.matchUiId + ')';
    }

    public final String getFormat() {
        return this.format;
    }

    public final Integer getFormatType() {
        return this.formatType;
    }

    public final String getMatchUiId() {
        return this.matchUiId;
    }

    public PromptItem(String r100, Integer r101, String r102) {
        this.format = r100;
        this.formatType = r101;
        this.matchUiId = r102;
    }

    public /* synthetic */ PromptItem(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
