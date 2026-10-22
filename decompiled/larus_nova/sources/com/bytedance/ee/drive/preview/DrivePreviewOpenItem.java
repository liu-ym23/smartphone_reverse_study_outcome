package com.bytedance.ee.drive.preview;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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
    public static /* synthetic */ DrivePreviewOpenItem copy$default(DrivePreviewOpenItem r110, String r111, DrivePreviewResType r112, String r113, int r114, String r115, String r116, String r210, String r211, String r212, String r213, String r214, HashMap r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.appId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        DrivePreviewResType r101 = r110.resType;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.token;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = r110.objType;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.url;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.fileExt;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.mountNodeToken;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.mountPoint;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.localFilePath;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.localFileProviderAuthority;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        HashMap r108 = r110.extra;
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

    public final DrivePreviewOpenItem copy(String r110, DrivePreviewResType r111, String r112, int r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, HashMap<String, String> r216) {
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "resType");
        Intrinsics.checkNotNullParameter(r112, "token");
        Intrinsics.checkNotNullParameter(r216, "extra");
        return new DrivePreviewOpenItem(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DrivePreviewOpenItem) == true) goto L8;
        return false;
    L8:
        DrivePreviewOpenItem r101 = (DrivePreviewOpenItem) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (this.resType == r101.resType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L18;
        return false;
    L18:
        if (this.objType == r101.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileExt, r101.fileExt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mountNodeToken, r101.mountNodeToken) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.mountPoint, r101.mountPoint) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.localFilePath, r101.localFilePath) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.localFileProviderAuthority, r101.localFileProviderAuthority) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.appId.hashCode() * 31) + this.resType.hashCode()) * 31) + this.token.hashCode()) * 31) + this.objType) * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.url;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.fileExt;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.mountNodeToken;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.mountPoint;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.localFilePath;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.localFileProviderAuthority;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return ((r119 + r102) * 31) + this.extra.hashCode();
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

    public DrivePreviewOpenItem(String r100, DrivePreviewResType r101, String r102, int r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, HashMap<String, String> r113) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r113, "extra");
        this.appId = r100;
        this.resType = r101;
        this.token = r102;
        this.objType = r103;
        this.title = r104;
        this.url = r105;
        this.fileExt = r106;
        this.mountNodeToken = r107;
        this.mountPoint = r110;
        this.localFilePath = r111;
        this.localFileProviderAuthority = r112;
        this.extra = r113;
    }

    public /* synthetic */ DrivePreviewOpenItem(String r110, DrivePreviewResType r111, String r112, int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, HashMap r218, int r219, DefaultConstructorMarker r310) {
        if ((r219 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r219 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r219 & 64) == 0) goto L13;
        String r113 = null;
    L15:
        if ((r219 & 128) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r219 & 256) == 0) goto L21;
        String r115 = null;
    L23:
        if ((r219 & 512) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r219 & 1024) == 0) goto L29;
        String r117 = null;
    L31:
        if ((r219 & 2048) == 0) goto L33;
        HashMap r118 = new HashMap();
    L34:
        this(r110, r111, r112, r210, r100, r101, r113, r114, r115, r116, r117, r118);
        return;
    L33:
        r118 = r218;
        goto L34
    L29:
        r117 = r217;
        goto L31
    L25:
        r116 = r216;
        goto L27
    L21:
        r115 = r215;
        goto L23
    L17:
        r114 = r214;
        goto L19
    L13:
        r113 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
