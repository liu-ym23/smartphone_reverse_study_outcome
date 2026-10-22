package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.EntityProvider;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wxa.e;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010H\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u009e\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\r2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\f\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\u0010\u0010,\"\u0004\b4\u0010.R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006P"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileEntity;", "Ljava/io/Serializable;", "entityType", "", "uplinkEntityContent", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityContent;", "fileIdentifier", "", "fileReviewStatus", "fileParsedStatus", "upLinkProcess", "upLinkStatus", "isFromDraft", "", "uri", "Landroid/net/Uri;", "isOriginalImageChecked", "uplinkFileDriveContent", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileDriveContent;", "doubaoFileInfo", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;", "<init>", "(Ljava/lang/Integer;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityContent;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Landroid/net/Uri;Ljava/lang/Boolean;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileDriveContent;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;)V", "getEntityType", "()Ljava/lang/Integer;", "setEntityType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUplinkEntityContent", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityContent;", "setUplinkEntityContent", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityContent;)V", "getFileIdentifier", "()Ljava/lang/String;", "setFileIdentifier", "(Ljava/lang/String;)V", "getFileReviewStatus", "setFileReviewStatus", "getFileParsedStatus", "setFileParsedStatus", "getUpLinkProcess", "setUpLinkProcess", "getUpLinkStatus", "setUpLinkStatus", "()Ljava/lang/Boolean;", "setFromDraft", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "setOriginalImageChecked", "getUplinkFileDriveContent", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileDriveContent;", "setUplinkFileDriveContent", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileDriveContent;)V", "getDoubaoFileInfo", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;", "setDoubaoFileInfo", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;)V", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Integer;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityContent;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Landroid/net/Uri;Ljava/lang/Boolean;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileDriveContent;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/DoubaoFileInfo;)Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileEntity;", "equals", "other", "", "hashCode", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UplinkFileEntity implements Serializable {

    @SerializedName("doubao_file_info")
    private DoubaoFileInfo doubaoFileInfo;

    @SerializedName(EntityProvider.KEY_ENTITY_TYPE)
    private Integer entityType;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private String fileIdentifier;

    @SerializedName("file_parse_state")
    private Integer fileParsedStatus;

    @SerializedName("file_name_state")
    private Integer fileReviewStatus;
    private transient Boolean isFromDraft;
    private transient Boolean isOriginalImageChecked;

    @SerializedName("upload_process")
    private Integer upLinkProcess;

    @SerializedName("upload_status")
    private Integer upLinkStatus;

    @SerializedName("entity_content")
    private UplinkEntityContent uplinkEntityContent;
    private transient e uplinkFileDriveContent;
    private transient Uri uri;

    public UplinkFileEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ UplinkFileEntity copy$default(UplinkFileEntity r110, Integer r111, UplinkEntityContent r112, String r113, Integer r114, Integer r115, Integer r116, Integer r210, Boolean r211, Uri r212, Boolean r213, e r214, DoubaoFileInfo r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        Integer r100 = r110.entityType;
    L7:
        if ((r216 & 2) == 0) goto L9;
        UplinkEntityContent r101 = r110.uplinkEntityContent;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.fileIdentifier;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r103 = r110.fileReviewStatus;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Integer r104 = r110.fileParsedStatus;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Integer r105 = r110.upLinkProcess;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r106 = r110.upLinkStatus;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r107 = r110.isFromDraft;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Uri r117 = r110.uri;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r118 = r110.isOriginalImageChecked;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        e r119 = r110.uplinkFileDriveContent;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        DoubaoFileInfo r108 = r110.doubaoFileInfo;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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

    public final Integer component1() {
        return this.entityType;
    }

    public final Boolean component10() {
        return this.isOriginalImageChecked;
    }

    public final e component11() {
        return this.uplinkFileDriveContent;
    }

    public final DoubaoFileInfo component12() {
        return this.doubaoFileInfo;
    }

    public final UplinkEntityContent component2() {
        return this.uplinkEntityContent;
    }

    public final String component3() {
        return this.fileIdentifier;
    }

    public final Integer component4() {
        return this.fileReviewStatus;
    }

    public final Integer component5() {
        return this.fileParsedStatus;
    }

    public final Integer component6() {
        return this.upLinkProcess;
    }

    public final Integer component7() {
        return this.upLinkStatus;
    }

    public final Boolean component8() {
        return this.isFromDraft;
    }

    public final Uri component9() {
        return this.uri;
    }

    public final UplinkFileEntity copy(Integer r110, UplinkEntityContent r111, String r112, Integer r113, Integer r114, Integer r210, Integer r211, Boolean r212, Uri r213, Boolean r214, e r215, DoubaoFileInfo r216) {
        return new UplinkFileEntity(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UplinkFileEntity) == true) goto L8;
        return false;
    L8:
        UplinkFileEntity r101 = (UplinkFileEntity) r100;
        if (Intrinsics.areEqual(this.entityType, r101.entityType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uplinkEntityContent, r101.uplinkEntityContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileIdentifier, r101.fileIdentifier) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileReviewStatus, r101.fileReviewStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileParsedStatus, r101.fileParsedStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.upLinkProcess, r101.upLinkProcess) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.upLinkStatus, r101.upLinkStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isFromDraft, r101.isFromDraft) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isOriginalImageChecked, r101.isOriginalImageChecked) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.uplinkFileDriveContent, r101.uplinkFileDriveContent) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.doubaoFileInfo, r101.doubaoFileInfo) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.entityType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UplinkEntityContent r104 = this.uplinkEntityContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fileIdentifier;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.fileReviewStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.fileParsedStatus;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.upLinkProcess;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.upLinkStatus;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isFromDraft;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Uri r125 = this.uri;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isOriginalImageChecked;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        e r131 = this.uplinkFileDriveContent;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        DoubaoFileInfo r134 = this.doubaoFileInfo;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public final DoubaoFileInfo getDoubaoFileInfo() {
        return this.doubaoFileInfo;
    }

    public final Integer getEntityType() {
        return this.entityType;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final Integer getFileParsedStatus() {
        return this.fileParsedStatus;
    }

    public final Integer getFileReviewStatus() {
        return this.fileReviewStatus;
    }

    public final Integer getUpLinkProcess() {
        return this.upLinkProcess;
    }

    public final Integer getUpLinkStatus() {
        return this.upLinkStatus;
    }

    public final UplinkEntityContent getUplinkEntityContent() {
        return this.uplinkEntityContent;
    }

    public final e getUplinkFileDriveContent() {
        return this.uplinkFileDriveContent;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final Boolean isFromDraft() {
        return this.isFromDraft;
    }

    public final Boolean isOriginalImageChecked() {
        return this.isOriginalImageChecked;
    }

    public final void setDoubaoFileInfo(DoubaoFileInfo r100) {
        this.doubaoFileInfo = r100;
    }

    public final void setEntityType(Integer r100) {
        this.entityType = r100;
    }

    public final void setFileIdentifier(String r100) {
        this.fileIdentifier = r100;
    }

    public final void setFileParsedStatus(Integer r100) {
        this.fileParsedStatus = r100;
    }

    public final void setFileReviewStatus(Integer r100) {
        this.fileReviewStatus = r100;
    }

    public final void setFromDraft(Boolean r100) {
        this.isFromDraft = r100;
    }

    public final void setOriginalImageChecked(Boolean r100) {
        this.isOriginalImageChecked = r100;
    }

    public final void setUpLinkProcess(Integer r100) {
        this.upLinkProcess = r100;
    }

    public final void setUpLinkStatus(Integer r100) {
        this.upLinkStatus = r100;
    }

    public final void setUplinkEntityContent(UplinkEntityContent r100) {
        this.uplinkEntityContent = r100;
    }

    public final void setUplinkFileDriveContent(e r100) {
        this.uplinkFileDriveContent = r100;
    }

    public final void setUri(Uri r100) {
        this.uri = r100;
    }

    public UplinkFileEntity(Integer r100, UplinkEntityContent r101, String r102, Integer r103, Integer r104, Integer r105, Integer r106, Boolean r107, Uri r108, Boolean r110, e r111, DoubaoFileInfo r112) {
        this.entityType = r100;
        this.uplinkEntityContent = r101;
        this.fileIdentifier = r102;
        this.fileReviewStatus = r103;
        this.fileParsedStatus = r104;
        this.upLinkProcess = r105;
        this.upLinkStatus = r106;
        this.isFromDraft = r107;
        this.uri = r108;
        this.isOriginalImageChecked = r110;
        this.uplinkFileDriveContent = r111;
        this.doubaoFileInfo = r112;
    }

    public /* synthetic */ UplinkFileEntity(Integer r110, UplinkEntityContent r111, String r112, Integer r113, Integer r114, Integer r115, Integer r210, Boolean r211, Uri r212, Boolean r213, e r214, DoubaoFileInfo r215, int r216, DefaultConstructorMarker r217) {
        DoubaoFileInfo r100 = null;
        if ((r216 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        UplinkEntityContent r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r104 = Integer.valueOf(FileReviewState.ACCESS.getValue());
    L19:
        if ((r216 & 16) == 0) goto L21;
        Integer r105 = Integer.valueOf(FileParseState.SUCCESS.getValue());
    L23:
        if ((r216 & 32) == 0) goto L25;
        Integer r106 = -1;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r107 = Integer.valueOf(UpLinkState.DEFAULT.getValue());
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Uri r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        e r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
}
