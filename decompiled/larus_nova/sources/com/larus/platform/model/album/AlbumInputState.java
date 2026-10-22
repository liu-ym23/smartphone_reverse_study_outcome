package com.larus.platform.model.album;

import com.larus.platform.model.preview.AttachmentSnapshot;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/platform/model/album/AlbumInputState;", "Ljava/io/Serializable;", "text", "", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "sourceNodeId", "inputSnapshotId", "attachmentUris", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getSourceNodeId", "getInputSnapshotId", "getAttachmentUris$annotations", "()V", "getAttachmentUris", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumInputState implements Serializable {
    private final List<String> attachmentUris;
    private final List<AttachmentSnapshot> attachments;
    private final String inputSnapshotId;
    private final String sourceNodeId;
    private final String text;

    public AlbumInputState() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumInputState copy$default(AlbumInputState r100, String r101, List r102, String r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.attachments;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.sourceNodeId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.inputSnapshotId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.attachmentUris;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @Deprecated(message = "Use attachments and inputSnapshotId")
    public static /* synthetic */ void getAttachmentUris$annotations() {
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

    public final String component4() {
        return this.inputSnapshotId;
    }

    public final List<String> component5() {
        return this.attachmentUris;
    }

    public final AlbumInputState copy(String r100, List<AttachmentSnapshot> r101, String r110, String r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attachments");
        Intrinsics.checkNotNullParameter(r110, "sourceNodeId");
        Intrinsics.checkNotNullParameter(r112, "attachmentUris");
        return new AlbumInputState(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumInputState) == true) goto L8;
        return false;
    L8:
        AlbumInputState r101 = (AlbumInputState) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachments, r101.attachments) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceNodeId, r101.sourceNodeId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputSnapshotId, r101.inputSnapshotId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attachmentUris, r101.attachmentUris) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.text.hashCode() * 31) + this.attachments.hashCode()) * 31) + this.sourceNodeId.hashCode()) * 31;
        String r101 = this.inputSnapshotId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.attachmentUris.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AlbumInputState(text=" + this.text + ", attachments=" + this.attachments + ", sourceNodeId=" + this.sourceNodeId + ", inputSnapshotId=" + this.inputSnapshotId + ", attachmentUris=" + this.attachmentUris + ')';
    }

    public final List<String> getAttachmentUris() {
        return this.attachmentUris;
    }

    public final List<AttachmentSnapshot> getAttachments() {
        return this.attachments;
    }

    public final String getInputSnapshotId() {
        return this.inputSnapshotId;
    }

    public final String getSourceNodeId() {
        return this.sourceNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public AlbumInputState(String r100, List<AttachmentSnapshot> r101, String r102, String r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attachments");
        Intrinsics.checkNotNullParameter(r102, "sourceNodeId");
        Intrinsics.checkNotNullParameter(r104, "attachmentUris");
        this.text = r100;
        this.attachments = r101;
        this.sourceNodeId = r102;
        this.inputSnapshotId = r103;
        this.attachmentUris = r104;
    }

    public /* synthetic */ AlbumInputState(String r100, List r101, String r102, String r103, List r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        List r107 = r101;
        if ((r105 & 4) != 0) goto L14;
        r106 = r102;
    L14:
        if ((r105 & 8) == 0) goto L16;
        r103 = null;
    L16:
        String r108 = r103;
        if ((r105 & 16) == 0) goto L19;
        r104 = CollectionsKt.emptyList();
    L19:
        String r109 = r111;
        String r112 = r106;
        this(r109, r107, r112, r108, r104);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
