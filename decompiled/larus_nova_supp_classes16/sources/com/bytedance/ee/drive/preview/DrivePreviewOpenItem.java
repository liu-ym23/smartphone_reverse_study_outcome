package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J%\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0012HÆ\u0003J«\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0012HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;", "Ljava/io/Serializable;", "appId", "", "resType", "Lcom/bytedance/ee/drive/preview/DrivePreviewResType;", "token", "objType", "", "title", "url", "fileExt", "mountNodeToken", "mountPoint", "localFilePath", "localFileProviderAuthority", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/drive/preview/DrivePreviewResType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getAppId", "()Ljava/lang/String;", "getResType", "()Lcom/bytedance/ee/drive/preview/DrivePreviewResType;", "getToken", "getObjType", "()I", "getTitle", "getUrl", "getFileExt", "getMountNodeToken", "getMountPoint", "getLocalFilePath", "getLocalFileProviderAuthority", "getExtra", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewOpenItem implements Serializable {
    public static final a Companion = null;
    public static final String EXTRA_FILE_EXT = "file_ext";
    public static final String EXTRA_MOUNT_NODE_TOKEN = "mount_node_token";
    public static final String EXTRA_MOUNT_POINT = "mount_point";
    private final String appId;
    private final HashMap<String, String> extra;
    private final String fileExt;
    private final String localFilePath;
    private final String localFileProviderAuthority;
    private final String mountNodeToken;
    private final String mountPoint;
    private final int objType;
    private final DrivePreviewResType resType;
    private final String title;
    private final String token;
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrivePreviewOpenItem copy$default(DrivePreviewOpenItem r13, String r14, DrivePreviewResType r16, String r17, int r18, String r19, String r110, String r20, String r21, String r22, String r23, String r24, HashMap r26, int r27, Object r28) {
        if ((r27 & 1) == 0) goto L5;
        String r2 = r13.appId;
    L7:
        if ((r27 & 2) == 0) goto L9;
        DrivePreviewResType r3 = r13.resType;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r4 = r13.token;
    L15:
        if ((r27 & 8) == 0) goto L17;
        int r5 = r13.objType;
    L19:
        if ((r27 & 16) == 0) goto L21;
        String r6 = r13.title;
    L23:
        if ((r27 & 32) == 0) goto L25;
        String r7 = r13.url;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r8 = r13.fileExt;
    L31:
        if ((r27 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r9 = r13.mountNodeToken;
    L35:
        if ((r27 & 256) == 0) goto L37;
        String r10 = r13.mountPoint;
    L39:
        if ((r27 & 512) == 0) goto L41;
        String r11 = r13.localFilePath;
    L43:
        if ((r27 & 1024) == 0) goto L45;
        String r12 = r13.localFileProviderAuthority;
    L47:
        if ((r27 & 2048) == 0) goto L49;
        HashMap r1 = r13.extra;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r26;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r110;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.appId;
    }

    public final String component10() {
        return this.localFilePath;
    }

    public final String component11() {
        return this.localFileProviderAuthority;
    }

    public final HashMap<String, String> component12() {
        return this.extra;
    }

    public final DrivePreviewResType component2() {
        return this.resType;
    }

    public final String component3() {
        return this.token;
    }

    public final int component4() {
        return this.objType;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.fileExt;
    }

    public final String component8() {
        return this.mountNodeToken;
    }

    public final String component9() {
        return this.mountPoint;
    }

    public final DrivePreviewOpenItem copy(String r16, DrivePreviewResType r17, String r18, int r19, String r110, String r20, String r21, String r22, String r23, String r24, String r26, HashMap<String, String> r27) {
        Intrinsics.checkNotNullParameter(r16, "appId");
        Intrinsics.checkNotNullParameter(r17, "resType");
        Intrinsics.checkNotNullParameter(r18, "token");
        Intrinsics.checkNotNullParameter(r27, "extra");
        return new DrivePreviewOpenItem(r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r26, r27);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrivePreviewOpenItem) == true) goto L8;
        return false;
    L8:
        DrivePreviewOpenItem r6 = (DrivePreviewOpenItem) r5;
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (this.resType == r6.resType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L18;
        return false;
    L18:
        if (this.objType == r6.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileExt, r6.fileExt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mountNodeToken, r6.mountNodeToken) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.mountPoint, r6.mountPoint) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.localFilePath, r6.localFilePath) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.localFileProviderAuthority, r6.localFileProviderAuthority) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.appId.hashCode() * 31) + this.resType.hashCode()) * 31) + this.token.hashCode()) * 31) + this.objType) * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.url;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.fileExt;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.mountNodeToken;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.mountPoint;
        if (r14 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r13 + r16) * 31;
        String r18 = this.localFilePath;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.localFileProviderAuthority;
        if (r21 == null) goto L31;
        r2 = r21.hashCode();
    L31:
        return ((r20 + r2) * 31) + this.extra.hashCode();
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DrivePreviewOpenItem(appId=" + this.appId + ", resType=" + this.resType + ", token=" + this.token + ", objType=" + this.objType + ", title=" + this.title + ", url=" + this.url + ", fileExt=" + this.fileExt + ", mountNodeToken=" + this.mountNodeToken + ", mountPoint=" + this.mountPoint + ", localFilePath=" + this.localFilePath + ", localFileProviderAuthority=" + this.localFileProviderAuthority + ", extra=" + this.extra + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileExt() {
        return this.fileExt;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getLocalFileProviderAuthority() {
        return this.localFileProviderAuthority;
    }

    public final String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final DrivePreviewResType getResType() {
        return this.resType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public DrivePreviewOpenItem(String r2, DrivePreviewResType r3, String r4, int r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, HashMap<String, String> r13) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "resType");
        Intrinsics.checkNotNullParameter(r4, "token");
        Intrinsics.checkNotNullParameter(r13, "extra");
        this.appId = r2;
        this.resType = r3;
        this.token = r4;
        this.objType = r5;
        this.title = r6;
        this.url = r7;
        this.fileExt = r8;
        this.mountNodeToken = r9;
        this.mountPoint = r10;
        this.localFilePath = r11;
        this.localFileProviderAuthority = r12;
        this.extra = r13;
    }

    public /* synthetic */ DrivePreviewOpenItem(String r17, DrivePreviewResType r18, String r19, int r20, String r21, String r22, String r23, String r24, String r26, String r27, String r28, HashMap r29, int r210, DefaultConstructorMarker r30) {
        if ((r210 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r210 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r210 & 64) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r210 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r210 & 256) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r210 & 512) == 0) goto L25;
        String r13 = null;
    L27:
        if ((r210 & 1024) == 0) goto L29;
        String r14 = null;
    L31:
        if ((r210 & 2048) == 0) goto L33;
        HashMap r16 = new HashMap();
    L34:
        this(r17, r18, r19, r20, r8, r9, r10, r11, r12, r13, r14, r16);
        return;
    L33:
        r16 = r29;
        goto L34
    L29:
        r14 = r28;
        goto L31
    L25:
        r13 = r27;
        goto L27
    L21:
        r12 = r26;
        goto L23
    L17:
        r11 = r24;
        goto L19
    L13:
        r10 = r23;
        goto L15
    L9:
        r9 = r22;
        goto L11
    L5:
        r8 = r21;
        goto L7
    }
}
