package com.larus.doc.impl.review;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/doc/impl/review/DocAppealCreateRequest;", "Ljava/io/Serializable;", "appealType", "", "entityId", "", "<init>", "(ILjava/lang/String;)V", "getAppealType", "()I", "getEntityId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAppealCreateRequest implements Serializable {

    @SerializedName("appeal_type")
    private final int appealType;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private final String entityId;

    /* JADX WARN: Multi-variable type inference failed */
    public DocAppealCreateRequest() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DocAppealCreateRequest copy$default(DocAppealCreateRequest r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appealType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entityId;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.appealType;
    }

    public final String component2() {
        return this.entityId;
    }

    public final DocAppealCreateRequest copy(int r100, String r101) {
        return new DocAppealCreateRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocAppealCreateRequest) == true) goto L8;
        return false;
    L8:
        DocAppealCreateRequest r101 = (DocAppealCreateRequest) r100;
        if (this.appealType == r101.appealType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r101.entityId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.appealType * 31;
        String r101 = this.entityId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DocAppealCreateRequest(appealType=" + this.appealType + ", entityId=" + this.entityId + ')';
    }

    public final int getAppealType() {
        return this.appealType;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public DocAppealCreateRequest(int r100, String r101) {
        this.appealType = r100;
        this.entityId = r101;
    }

    public /* synthetic */ DocAppealCreateRequest(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 24;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
