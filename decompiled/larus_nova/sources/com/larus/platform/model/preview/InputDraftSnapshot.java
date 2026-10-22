package com.larus.platform.model.preview;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/preview/InputDraftSnapshot;", "Ljava/io/Serializable;", "text", "", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "sourceNodeId", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getSourceNodeId", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputDraftSnapshot implements Serializable {
    private final List<AttachmentSnapshot> attachments;
    private final long createdAt;
    private final String sourceNodeId;
    private final String text;

    public InputDraftSnapshot() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputDraftSnapshot copy$default(InputDraftSnapshot r100, String r101, List r102, String r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.attachments;
    L8:
        List r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.sourceNodeId;
    L11:
        String r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.createdAt;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final List<AttachmentSnapshot> component2() {
        return this.attachments;
    }

    public final String component3() {
        return this.sourceNodeId;
    }

    public final long component4() {
        return this.createdAt;
    }

    public final InputDraftSnapshot copy(String r100, List<AttachmentSnapshot> r101, String r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attachments");
        Intrinsics.checkNotNullParameter(r110, "sourceNodeId");
        return new InputDraftSnapshot(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputDraftSnapshot) == true) goto L8;
        return false;
    L8:
        InputDraftSnapshot r101 = (InputDraftSnapshot) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachments, r101.attachments) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceNodeId, r101.sourceNodeId) == true) goto L18;
        return false;
    L18:
        if (this.createdAt == r101.createdAt) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.text.hashCode() * 31) + this.attachments.hashCode()) * 31) + this.sourceNodeId.hashCode()) * 31;
        long r101 = this.createdAt;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "InputDraftSnapshot(text=" + this.text + ", attachments=" + this.attachments + ", sourceNodeId=" + this.sourceNodeId + ", createdAt=" + this.createdAt + ')';
    }

    public final List<AttachmentSnapshot> getAttachments() {
        return this.attachments;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getSourceNodeId() {
        return this.sourceNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public InputDraftSnapshot(String r100, List<AttachmentSnapshot> r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attachments");
        Intrinsics.checkNotNullParameter(r102, "sourceNodeId");
        this.text = r100;
        this.attachments = r101;
        this.sourceNodeId = r102;
        this.createdAt = r103;
    }

    public /* synthetic */ InputDraftSnapshot(String r100, List r101, String r102, long r103, int r104, DefaultConstructorMarker r105) {
        String r106 = "";
        if ((r104 & 1) == 0) goto L5;
        String r107 = "";
    L7:
        if ((r104 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        List r108 = r101;
        if ((r104 & 4) != 0) goto L14;
        r106 = r102;
    L14:
        if ((r104 & 8) == 0) goto L16;
        r103 = System.currentTimeMillis();
    L16:
        long r109 = r103;
        this(r107, r108, r106, r109);
        return;
    L5:
        r107 = r100;
        goto L7
    }
}
