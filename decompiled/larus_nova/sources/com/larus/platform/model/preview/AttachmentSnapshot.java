package com.larus.platform.model.preview;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010<\u001a\u0004\u0018\u00010\tJ\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003J\t\u0010L\u001a\u00020\u0014HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010N\u001a\u00020\u0018HÆ\u0003J\t\u0010O\u001a\u00020\u001aHÆ\u0003J\u0017\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001cHÆ\u0003JØ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001cHÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0018HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006X"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSnapshot;", "Ljava/io/Serializable;", "stableId", "", "source", "Lcom/larus/platform/model/preview/AttachmentSource;", "mediaType", "Lcom/larus/platform/model/preview/AttachmentMediaType;", "displayRef", "Lcom/larus/platform/model/preview/ResourceRef;", "thumbRef", "originRef", "fileName", DBDefinition.MIME_TYPE, "fileSize", "", "resourceId", "checksum", "durationMs", "uploadState", "Lcom/larus/platform/model/preview/AttachmentUploadState;", "editState", "Lcom/larus/platform/model/preview/AttachmentEditState;", "selectedOrder", "", "sendableState", "Lcom/larus/platform/model/preview/AttachmentSendableState;", "extra", "", "<init>", "(Ljava/lang/String;Lcom/larus/platform/model/preview/AttachmentSource;Lcom/larus/platform/model/preview/AttachmentMediaType;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JLcom/larus/platform/model/preview/AttachmentUploadState;Lcom/larus/platform/model/preview/AttachmentEditState;ILcom/larus/platform/model/preview/AttachmentSendableState;Ljava/util/Map;)V", "getStableId", "()Ljava/lang/String;", "getSource", "()Lcom/larus/platform/model/preview/AttachmentSource;", "getMediaType", "()Lcom/larus/platform/model/preview/AttachmentMediaType;", "getDisplayRef", "()Lcom/larus/platform/model/preview/ResourceRef;", "getThumbRef", "getOriginRef", "getFileName", "getMimeType", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResourceId", "getChecksum", "getDurationMs", "()J", "getUploadState", "()Lcom/larus/platform/model/preview/AttachmentUploadState;", "getEditState", "()Lcom/larus/platform/model/preview/AttachmentEditState;", "getSelectedOrder", "()I", "getSendableState", "()Lcom/larus/platform/model/preview/AttachmentSendableState;", "getExtra", "()Ljava/util/Map;", "effectiveRef", "isSendableNow", "", "canEnterSendPipeline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Lcom/larus/platform/model/preview/AttachmentSource;Lcom/larus/platform/model/preview/AttachmentMediaType;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Lcom/larus/platform/model/preview/ResourceRef;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JLcom/larus/platform/model/preview/AttachmentUploadState;Lcom/larus/platform/model/preview/AttachmentEditState;ILcom/larus/platform/model/preview/AttachmentSendableState;Ljava/util/Map;)Lcom/larus/platform/model/preview/AttachmentSnapshot;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentSnapshot implements Serializable {
    private final String checksum;
    private final ResourceRef displayRef;
    private final long durationMs;
    private final AttachmentEditState editState;
    private final Map<String, String> extra;
    private final String fileName;
    private final Long fileSize;
    private final AttachmentMediaType mediaType;
    private final String mimeType;
    private final ResourceRef originRef;
    private final String resourceId;
    private final int selectedOrder;
    private final AttachmentSendableState sendableState;
    private final AttachmentSource source;
    private final String stableId;
    private final ResourceRef thumbRef;
    private final AttachmentUploadState uploadState;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentSnapshot copy$default(AttachmentSnapshot r110, String r111, AttachmentSource r112, AttachmentMediaType r210, ResourceRef r211, ResourceRef r212, ResourceRef r213, String r214, String r215, Long r216, String r217, String r218, long r219, AttachmentUploadState r310, AttachmentEditState r311, int r312, AttachmentSendableState r313, Map r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.stableId;
    L7:
        if ((r315 & 2) == 0) goto L9;
        AttachmentSource r101 = r110.source;
    L11:
        if ((r315 & 4) == 0) goto L13;
        AttachmentMediaType r102 = r110.mediaType;
    L15:
        if ((r315 & 8) == 0) goto L17;
        ResourceRef r103 = r110.displayRef;
    L19:
        if ((r315 & 16) == 0) goto L21;
        ResourceRef r104 = r110.thumbRef;
    L23:
        if ((r315 & 32) == 0) goto L25;
        ResourceRef r105 = r110.originRef;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.fileName;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r107 = r110.mimeType;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Long r113 = r110.fileSize;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.resourceId;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.checksum;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        long r116 = r110.durationMs;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        AttachmentUploadState r117 = r110.uploadState;
    L54:
        AttachmentUploadState r317 = r117;
        if ((r315 & 8192) == 0) goto L57;
        AttachmentEditState r118 = r110.editState;
    L58:
        AttachmentEditState r318 = r118;
        if ((r315 & 16384) == 0) goto L61;
        int r119 = r110.selectedOrder;
    L62:
        int r319 = r119;
        if ((r315 & 32768) == 0) goto L65;
        AttachmentSendableState r120 = r110.sendableState;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        Map r108 = r110.extra;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r317, r318, r319, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L54
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.stableId;
    }

    public final String component10() {
        return this.resourceId;
    }

    public final String component11() {
        return this.checksum;
    }

    public final long component12() {
        return this.durationMs;
    }

    public final AttachmentUploadState component13() {
        return this.uploadState;
    }

    public final AttachmentEditState component14() {
        return this.editState;
    }

    public final int component15() {
        return this.selectedOrder;
    }

    public final AttachmentSendableState component16() {
        return this.sendableState;
    }

    public final Map<String, String> component17() {
        return this.extra;
    }

    public final AttachmentSource component2() {
        return this.source;
    }

    public final AttachmentMediaType component3() {
        return this.mediaType;
    }

    public final ResourceRef component4() {
        return this.displayRef;
    }

    public final ResourceRef component5() {
        return this.thumbRef;
    }

    public final ResourceRef component6() {
        return this.originRef;
    }

    public final String component7() {
        return this.fileName;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final Long component9() {
        return this.fileSize;
    }

    public final AttachmentSnapshot copy(String r210, AttachmentSource r211, AttachmentMediaType r212, ResourceRef r213, ResourceRef r214, ResourceRef r215, String r216, String r217, Long r310, String r311, String r312, long r313, AttachmentUploadState r314, AttachmentEditState r315, int r316, AttachmentSendableState r317, Map<String, String> r318) {
        Intrinsics.checkNotNullParameter(r210, "stableId");
        Intrinsics.checkNotNullParameter(r211, "source");
        Intrinsics.checkNotNullParameter(r212, "mediaType");
        Intrinsics.checkNotNullParameter(r314, "uploadState");
        Intrinsics.checkNotNullParameter(r317, "sendableState");
        Intrinsics.checkNotNullParameter(r318, "extra");
        return new AttachmentSnapshot(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public final ResourceRef effectiveRef() {
        ResourceRef[] r100 = new ResourceRef[3];
        AttachmentEditState r101 = this.editState;
        Object r102 = null;
        if (r101 == null) goto L5;
        ResourceRef r103 = r101.getEditedRef();
    L6:
        r100[0] = r103;
        r100[1] = this.originRef;
        r100[2] = this.displayRef;
        Iterator r104 = SequencesKt.filterNotNull(SequencesKt.sequenceOf(r100)).iterator();
    L8:
        if (r104.hasNext() == false) goto L24;
        Object r105 = r104.next();
        ResourceRef r106 = (ResourceRef) r105;
        if ((!StringsKt.isBlank(r106.getUri())) == true) goto L20;
        String r107 = r106.getRemoteKey();
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L20;
        boolean r109 = false;
    L21:
        if (r109 == false) goto L8;
        r102 = r105;
        goto L24
    L14:
        if ((!StringsKt.isBlank(r107)) != true) goto L16;
        r108 = true;
    L20:
        r109 = true;
    L24:
        return (ResourceRef) r102;
    L5:
        r103 = null;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachmentSnapshot) == true) goto L8;
        return false;
    L8:
        AttachmentSnapshot r101 = (AttachmentSnapshot) r100;
        if (Intrinsics.areEqual(this.stableId, r101.stableId) == true) goto L12;
        return false;
    L12:
        if (this.source == r101.source) goto L15;
        return false;
    L15:
        if (this.mediaType == r101.mediaType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.displayRef, r101.displayRef) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.thumbRef, r101.thumbRef) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.originRef, r101.originRef) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.checksum, r101.checksum) == true) goto L42;
        return false;
    L42:
        if (this.durationMs == r101.durationMs) goto L45;
        return false;
    L45:
        if (this.uploadState == r101.uploadState) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.editState, r101.editState) == true) goto L51;
        return false;
    L51:
        if (this.selectedOrder == r101.selectedOrder) goto L54;
        return false;
    L54:
        if (this.sendableState == r101.sendableState) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.stableId.hashCode() * 31) + this.source.hashCode()) * 31) + this.mediaType.hashCode()) * 31;
        ResourceRef r101 = this.displayRef;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ResourceRef r105 = this.thumbRef;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        ResourceRef r108 = this.originRef;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.fileName;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.mimeType;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.fileSize;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.resourceId;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.checksum;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        long r125 = this.durationMs;
        int r126 = (((((r122 + r124) * 31) + ((int) (r125 ^ (r125 >>> 32)))) * 31) + this.uploadState.hashCode()) * 31;
        AttachmentEditState r127 = this.editState;
        if (r127 == null) goto L39;
        r102 = r127.hashCode();
    L39:
        return ((((((r126 + r102) * 31) + this.selectedOrder) * 31) + this.sendableState.hashCode()) * 31) + this.extra.hashCode();
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AttachmentSnapshot(stableId=" + this.stableId + ", source=" + this.source + ", mediaType=" + this.mediaType + ", displayRef=" + this.displayRef + ", thumbRef=" + this.thumbRef + ", originRef=" + this.originRef + ", fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ", resourceId=" + this.resourceId + ", checksum=" + this.checksum + ", durationMs=" + this.durationMs + ", uploadState=" + this.uploadState + ", editState=" + this.editState + ", selectedOrder=" + this.selectedOrder + ", sendableState=" + this.sendableState + ", extra=" + this.extra + ')';
    }

    public final boolean isSendableNow() {
        if (this.sendableState != AttachmentSendableState.SENDABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canEnterSendPipeline() {
        ResourceRef r100 = effectiveRef();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.sendableState != AttachmentSendableState.NOT_SENDABLE) goto L8;
        return false;
    L8:
        if (this.uploadState != AttachmentUploadState.UPLOADING) goto L10;
        return false;
    L10:
        if (r100.getKind() == ResourceRefKind.UPLOADING) goto L15;
        return true;
    L15:
        return false;
    }

    public final String getChecksum() {
        return this.checksum;
    }

    public final ResourceRef getDisplayRef() {
        return this.displayRef;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final AttachmentEditState getEditState() {
        return this.editState;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final AttachmentMediaType getMediaType() {
        return this.mediaType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final ResourceRef getOriginRef() {
        return this.originRef;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSelectedOrder() {
        return this.selectedOrder;
    }

    public final AttachmentSendableState getSendableState() {
        return this.sendableState;
    }

    public final AttachmentSource getSource() {
        return this.source;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public final ResourceRef getThumbRef() {
        return this.thumbRef;
    }

    public final AttachmentUploadState getUploadState() {
        return this.uploadState;
    }

    public AttachmentSnapshot(String r100, AttachmentSource r110, AttachmentMediaType r111, ResourceRef r112, ResourceRef r113, ResourceRef r114, String r115, String r116, Long r117, String r118, String r119, long r210, AttachmentUploadState r211, AttachmentEditState r212, int r213, AttachmentSendableState r214, Map<String, String> r215) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, "mediaType");
        Intrinsics.checkNotNullParameter(r211, "uploadState");
        Intrinsics.checkNotNullParameter(r214, "sendableState");
        Intrinsics.checkNotNullParameter(r215, "extra");
        this.stableId = r100;
        this.source = r110;
        this.mediaType = r111;
        this.displayRef = r112;
        this.thumbRef = r113;
        this.originRef = r114;
        this.fileName = r115;
        this.mimeType = r116;
        this.fileSize = r117;
        this.resourceId = r118;
        this.checksum = r119;
        this.durationMs = r210;
        this.uploadState = r211;
        this.editState = r212;
        this.selectedOrder = r213;
        this.sendableState = r214;
        this.extra = r215;
    }

    public /* synthetic */ AttachmentSnapshot(String r210, AttachmentSource r211, AttachmentMediaType r212, ResourceRef r213, ResourceRef r214, ResourceRef r215, String r216, String r310, Long r311, String r312, String r313, long r314, AttachmentUploadState r315, AttachmentEditState r316, int r317, AttachmentSendableState r318, Map r410, int r411, DefaultConstructorMarker r412) {
        if ((r411 & 8) == 0) goto L5;
        ResourceRef r100 = null;
    L7:
        if ((r411 & 16) == 0) goto L9;
        ResourceRef r101 = null;
    L11:
        if ((r411 & 32) == 0) goto L13;
        ResourceRef r102 = null;
    L15:
        if ((r411 & 64) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r411 & 128) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r411 & 256) == 0) goto L25;
        Long r112 = null;
    L27:
        if ((r411 & 512) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r411 & 1024) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r411 & 2048) == 0) goto L37;
        long r115 = 0;
    L39:
        if ((r411 & 4096) == 0) goto L41;
        AttachmentUploadState r116 = AttachmentUploadState.NOT_UPLOADED;
    L43:
        if ((r411 & 8192) == 0) goto L45;
        AttachmentEditState r117 = null;
    L47:
        if ((r411 & 16384) == 0) goto L49;
        int r118 = 0;
    L51:
        if ((32768 & r411) == 0) goto L53;
        AttachmentSendableState r217 = AttachmentSendableState.NEEDS_MATERIALIZE;
    L55:
        if ((r411 & 65536) == 0) goto L57;
        Map r218 = MapsKt.emptyMap();
    L58:
        this(r210, r211, r212, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r217, r218);
        return;
    L57:
        r218 = r410;
        goto L58
    L53:
        r217 = r318;
        goto L55
    L49:
        r118 = r317;
        goto L51
    L45:
        r117 = r316;
        goto L47
    L41:
        r116 = r315;
        goto L43
    L37:
        r115 = r314;
        goto L39
    L33:
        r114 = r313;
        goto L35
    L29:
        r113 = r312;
        goto L31
    L25:
        r112 = r311;
        goto L27
    L21:
        r111 = r310;
        goto L23
    L17:
        r110 = r216;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
