package com.ss.android.lark.keyboard.base;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010B\u001a\u00020\u0013J\b\u0010C\u001a\u00020\u0013H\u0002J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020EJ\u0010\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u0003H\u0002J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u000eHÆ\u0003J\t\u0010S\u001a\u00020\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u0011HÆ\u0003J\t\u0010U\u001a\u00020\u0013HÆ\u0003J\t\u0010V\u001a\u00020\u0013HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0016HÆ\u0003J´\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u000eHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010:\"\u0004\b=\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006_"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "Ljava/io/Serializable;", LocationMonitorConst.IDENTIFIER, "", "fileName", "size", "", DBDefinition.MIME_TYPE, "localResPath", "remoteKey", "resourceId", "sourceMessageId", "sourceChatId", "sourcePosition", "", "uploadProgress", "uploadState", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "isFromDraft", "", "isFolder", "uri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;ZZLandroid/net/Uri;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getFileName", "setFileName", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMimeType", "setMimeType", "getLocalResPath", "setLocalResPath", "getRemoteKey", "setRemoteKey", "getResourceId", "setResourceId", "getSourceMessageId", "setSourceMessageId", "getSourceChatId", "setSourceChatId", "getSourcePosition", "()I", "setSourcePosition", "(I)V", "getUploadProgress", "setUploadProgress", "getUploadState", "()Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "setUploadState", "(Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;)V", "()Z", "setFromDraft", "(Z)V", "setFolder", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "hasLocalOrRemoteResource", "hasAvailableLocalResource", "toPbFile", "Lcom/bytedance/lark/pb/basic/v1/File;", "toSendPbFile", "isRemoteResourceKey", "key", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;ZZLandroid/net/Uri;)Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "equals", "other", "", "hashCode", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAttachmentEntity implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Uri f428212a;
    private String fileName;
    private String identifier;
    private boolean isFolder;
    private boolean isFromDraft;
    private String localResPath;
    private String mimeType;
    private String remoteKey;
    private String resourceId;
    private Long size;
    private String sourceChatId;
    private String sourceMessageId;
    private int sourcePosition;
    private int uploadProgress;
    private ChatAttachmentUploadState uploadState;

    public static /* synthetic */ ChatAttachmentEntity copy$default(ChatAttachmentEntity r110, String r111, String r112, Long r113, String r210, String r211, String r212, String r213, String r214, String r215, int r216, int r217, ChatAttachmentUploadState r218, boolean r219, boolean r310, Uri r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.identifier;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.fileName;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Long r102 = r110.size;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.mimeType;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.localResPath;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.remoteKey;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = r110.resourceId;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.sourceMessageId;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r114 = r110.sourceChatId;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r115 = r110.sourcePosition;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r116 = r110.uploadProgress;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        ChatAttachmentUploadState r117 = r110.uploadState;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        boolean r118 = r110.isFromDraft;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.isFolder;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        Uri r108 = r110.f428212a;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.identifier;
    }

    public final int component10() {
        return this.sourcePosition;
    }

    public final int component11() {
        return this.uploadProgress;
    }

    public final ChatAttachmentUploadState component12() {
        return this.uploadState;
    }

    public final boolean component13() {
        return this.isFromDraft;
    }

    public final boolean component14() {
        return this.isFolder;
    }

    public final Uri component15() {
        return this.f428212a;
    }

    public final String component2() {
        return this.fileName;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final String component5() {
        return this.localResPath;
    }

    public final String component6() {
        return this.remoteKey;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.sourceMessageId;
    }

    public final String component9() {
        return this.sourceChatId;
    }

    public final ChatAttachmentEntity copy(String r110, String r111, Long r210, String r211, String r212, String r213, String r214, String r215, String r216, int r217, int r218, ChatAttachmentUploadState r219, boolean r310, boolean r311, Uri r312) {
        Intrinsics.checkNotNullParameter(r110, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r111, "fileName");
        Intrinsics.checkNotNullParameter(r219, "uploadState");
        return new ChatAttachmentEntity(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatAttachmentEntity) == true) goto L8;
        return false;
    L8:
        ChatAttachmentEntity r101 = (ChatAttachmentEntity) r100;
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localResPath, r101.localResPath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.remoteKey, r101.remoteKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sourceMessageId, r101.sourceMessageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceChatId, r101.sourceChatId) == true) goto L36;
        return false;
    L36:
        if (this.sourcePosition == r101.sourcePosition) goto L39;
        return false;
    L39:
        if (this.uploadProgress == r101.uploadProgress) goto L42;
        return false;
    L42:
        if (this.uploadState == r101.uploadState) goto L45;
        return false;
    L45:
        if (this.isFromDraft == r101.isFromDraft) goto L48;
        return false;
    L48:
        if (this.isFolder == r101.isFolder) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f428212a, r101.f428212a) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.identifier.hashCode() * 31) + this.fileName.hashCode()) * 31;
        Long r101 = this.size;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.mimeType;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.localResPath;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.remoteKey;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.resourceId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.sourceMessageId;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.sourceChatId;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((((((r119 + r121) * 31) + this.sourcePosition) * 31) + this.uploadProgress) * 31) + this.uploadState.hashCode()) * 31;
        int r123 = 1231;
        if (this.isFromDraft == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.isFolder == true) goto L38;
        r123 = 1237;
    L38:
        int r126 = (r125 + r123) * 31;
        Uri r127 = this.f428212a;
        if (r127 == null) goto L43;
        r102 = r127.hashCode();
    L43:
        return r126 + r102;
    L33:
        r124 = 1237;
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
        return "ChatAttachmentEntity(identifier=" + this.identifier + ", fileName=" + this.fileName + ", size=" + this.size + ", mimeType=" + this.mimeType + ", localResPath=" + this.localResPath + ", remoteKey=" + this.remoteKey + ", resourceId=" + this.resourceId + ", sourceMessageId=" + this.sourceMessageId + ", sourceChatId=" + this.sourceChatId + ", sourcePosition=" + this.sourcePosition + ", uploadProgress=" + this.uploadProgress + ", uploadState=" + this.uploadState + ", isFromDraft=" + this.isFromDraft + ", isFolder=" + this.isFolder + ", uri=" + this.f428212a + ')';
    }

    public final boolean hasLocalOrRemoteResource() {
        String r100 = this.localResPath;
        if (r100 != null) goto L5;
    L23:
        boolean r101 = false;
    L24:
        if (r101 == false) goto L26;
        return true;
    L26:
        if (this.f428212a != null) goto L47;
        String r102 = this.remoteKey;
        if (r102 != null) goto L30;
    L33:
        boolean r103 = true;
    L34:
        if (r103 == false) goto L48;
        String r104 = this.resourceId;
        if (r104 != null) goto L38;
    L41:
        boolean r105 = true;
    L42:
        if (r105 == false) goto L49;
        return false;
    L49:
        return true;
    L38:
        if (r104.length() == 0) goto L41;
        r105 = false;
        goto L42
    L48:
        return true;
    L30:
        if (r102.length() == 0) goto L33;
        r103 = false;
        goto L34
    L47:
        return true;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L23;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r100);
        if (r107.exists() == false) goto L23;
        if (r107.canRead() == false) goto L23;
        if (this.isFolder == false) goto L20;
        boolean r108 = r107.isDirectory();
    L21:
        if (r108 == false) goto L23;
        r101 = true;
        goto L24
    L20:
        r108 = r107.isFile();
        goto L21
    L7:
        r106 = false;
        goto L8
    }

    public final File toSendPbFile() {
        String r100 = this.remoteKey;
        boolean r101 = true;
        String r102 = null;
        if (r100 != null) goto L5;
    L12:
        r100 = this.resourceId;
        if (r100 != null) goto L15;
    L20:
        r100 = null;
    L21:
        if (r100 != null) goto L26;
        r100 = this.identifier;
        if (StringsKt.startsWith$default(r100, "file_", false, 2, null) == true) goto L26;
        r100 = null;
    L26:
        if (r100 != null) goto L28;
        String r103 = this.identifier;
    L29:
        String r104 = "";
        if (r100 != null) goto L47;
        String r105 = this.localResPath;
        if (r105 != null) goto L34;
    L41:
        Uri r106 = this.f428212a;
        if (r106 == null) goto L44;
        r102 = r106.toString();
    L44:
        if (r102 == null) goto L47;
        r105 = r102;
    L48:
        File.Builder r107 = new File.Builder().name(this.fileName).key(r103);
        Long r108 = this.size;
        if (r108 == null) goto L51;
        long r109 = r108.longValue();
    L52:
        File.Builder r110 = r107.size(Long.valueOf(r109));
        String r111 = this.mimeType;
        if (r111 == null) goto L57;
        r104 = r111;
    L57:
        return r110.mime(r104).path(r105).is_folder(Boolean.valueOf(this.isFolder)).build();
    L51:
        r109 = 0;
        goto L52
    L34:
        if (r105.length() > 0) goto L37;
        r101 = false;
    L37:
        if (r101 == true) goto L40;
        r105 = null;
    L40:
        if (r105 != null) goto L48;
    L47:
        r105 = "";
        goto L48
    L28:
        r103 = r100;
        goto L29
    L15:
        if (r100.length() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L20;
    L17:
        r112 = false;
        goto L18
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L26;
    L7:
        r113 = false;
        goto L8
    }

    public final File toPbFile() {
        return toSendPbFile();
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getLocalResPath() {
        return this.localResPath;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getRemoteKey() {
        return this.remoteKey;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSourceChatId() {
        return this.sourceChatId;
    }

    public final String getSourceMessageId() {
        return this.sourceMessageId;
    }

    public final int getSourcePosition() {
        return this.sourcePosition;
    }

    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    public final ChatAttachmentUploadState getUploadState() {
        return this.uploadState;
    }

    public final Uri getUri() {
        return this.f428212a;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final boolean isFromDraft() {
        return this.isFromDraft;
    }

    public final void setFileName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileName = r100;
    }

    public final void setFolder(boolean r100) {
        this.isFolder = r100;
    }

    public final void setFromDraft(boolean r100) {
        this.isFromDraft = r100;
    }

    public final void setIdentifier(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.identifier = r100;
    }

    public final void setLocalResPath(String r100) {
        this.localResPath = r100;
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setRemoteKey(String r100) {
        this.remoteKey = r100;
    }

    public final void setResourceId(String r100) {
        this.resourceId = r100;
    }

    public final void setSize(Long r100) {
        this.size = r100;
    }

    public final void setSourceChatId(String r100) {
        this.sourceChatId = r100;
    }

    public final void setSourceMessageId(String r100) {
        this.sourceMessageId = r100;
    }

    public final void setSourcePosition(int r100) {
        this.sourcePosition = r100;
    }

    public final void setUploadProgress(int r100) {
        this.uploadProgress = r100;
    }

    public final void setUploadState(ChatAttachmentUploadState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uploadState = r100;
    }

    public final void setUri(Uri r100) {
        this.f428212a = r100;
    }

    public ChatAttachmentEntity(String r100, String r101, Long r102, String r103, String r110, String r111, String r112, String r113, String r114, int r115, int r116, ChatAttachmentUploadState r117, boolean r118, boolean r119, Uri r210) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r117, "uploadState");
        this.identifier = r100;
        this.fileName = r101;
        this.size = r102;
        this.mimeType = r103;
        this.localResPath = r110;
        this.remoteKey = r111;
        this.resourceId = r112;
        this.sourceMessageId = r113;
        this.sourceChatId = r114;
        this.sourcePosition = r115;
        this.uploadProgress = r116;
        this.uploadState = r117;
        this.isFromDraft = r118;
        this.isFolder = r119;
        this.f428212a = r210;
    }

    public /* synthetic */ ChatAttachmentEntity(String r210, String r211, Long r212, String r213, String r214, String r215, String r216, String r217, String r218, int r219, int r310, ChatAttachmentUploadState r311, boolean r312, boolean r313, Uri r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 4) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r315 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r315 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r315 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r315 & 64) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r315 & 128) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r315 & 256) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r315 & 512) == 0) goto L33;
        int r113 = -1;
    L35:
        if ((r315 & 1024) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((r315 & 2048) == 0) goto L41;
        ChatAttachmentUploadState r115 = ChatAttachmentUploadState.DEFAULT;
    L43:
        if ((r315 & 4096) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r315 & 8192) == 0) goto L49;
        boolean r117 = false;
    L51:
        if ((r315 & 16384) == 0) goto L53;
        Uri r118 = null;
    L54:
        this(r210, r211, r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L51
    L45:
        r116 = r312;
        goto L47
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = r310;
        goto L39
    L33:
        r113 = r219;
        goto L35
    L29:
        r112 = r218;
        goto L31
    L25:
        r111 = r217;
        goto L27
    L21:
        r110 = r216;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
