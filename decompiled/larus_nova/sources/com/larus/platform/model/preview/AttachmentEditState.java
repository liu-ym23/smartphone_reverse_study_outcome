package com.larus.platform.model.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentEditState;", "Ljava/io/Serializable;", "editedRef", "Lcom/larus/platform/model/preview/ResourceRef;", "originStableId", "", "editType", "Lcom/larus/platform/model/preview/AttachmentEditType;", "<init>", "(Lcom/larus/platform/model/preview/ResourceRef;Ljava/lang/String;Lcom/larus/platform/model/preview/AttachmentEditType;)V", "getEditedRef", "()Lcom/larus/platform/model/preview/ResourceRef;", "getOriginStableId", "()Ljava/lang/String;", "getEditType", "()Lcom/larus/platform/model/preview/AttachmentEditType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentEditState implements Serializable {
    private final AttachmentEditType editType;
    private final ResourceRef editedRef;
    private final String originStableId;

    public static /* synthetic */ AttachmentEditState copy$default(AttachmentEditState r100, ResourceRef r101, String r102, AttachmentEditType r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.editedRef;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.originStableId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.editType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ResourceRef component1() {
        return this.editedRef;
    }

    public final String component2() {
        return this.originStableId;
    }

    public final AttachmentEditType component3() {
        return this.editType;
    }

    public final AttachmentEditState copy(ResourceRef r100, String r101, AttachmentEditType r102) {
        Intrinsics.checkNotNullParameter(r100, "editedRef");
        Intrinsics.checkNotNullParameter(r101, "originStableId");
        Intrinsics.checkNotNullParameter(r102, "editType");
        return new AttachmentEditState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachmentEditState) == true) goto L8;
        return false;
    L8:
        AttachmentEditState r101 = (AttachmentEditState) r100;
        if (Intrinsics.areEqual(this.editedRef, r101.editedRef) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originStableId, r101.originStableId) == true) goto L15;
        return false;
    L15:
        if (this.editType == r101.editType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.editedRef.hashCode() * 31) + this.originStableId.hashCode()) * 31) + this.editType.hashCode();
    }

    public String toString() {
        return "AttachmentEditState(editedRef=" + this.editedRef + ", originStableId=" + this.originStableId + ", editType=" + this.editType + ')';
    }

    public final AttachmentEditType getEditType() {
        return this.editType;
    }

    public final ResourceRef getEditedRef() {
        return this.editedRef;
    }

    public final String getOriginStableId() {
        return this.originStableId;
    }

    public AttachmentEditState(ResourceRef r100, String r101, AttachmentEditType r102) {
        Intrinsics.checkNotNullParameter(r100, "editedRef");
        Intrinsics.checkNotNullParameter(r101, "originStableId");
        Intrinsics.checkNotNullParameter(r102, "editType");
        this.editedRef = r100;
        this.originStableId = r101;
        this.editType = r102;
    }

    public /* synthetic */ AttachmentEditState(ResourceRef r100, String r101, AttachmentEditType r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = AttachmentEditType.MARK;
    L5:
        this(r100, r101, r102);
    }
}
