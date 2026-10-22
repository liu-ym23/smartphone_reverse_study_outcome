package com.larus.office.base.watermark.api.remote;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/larus/office/base/watermark/api/remote/WatermarkDownloadRequest;", "", "uri", "", "url", "scene", "subScene", "contentType", "fileType", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getUrl", "getScene", "getSubScene", "getContentType", "getFileType", "getLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkDownloadRequest {

    @SerializedName("content_type")
    private final String contentType;

    @SerializedName("file_type")
    private final String fileType;

    @SerializedName("language")
    private final String language;

    @SerializedName("scene")
    private final String scene;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private final String subScene;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("url")
    private final String url;

    public WatermarkDownloadRequest() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ WatermarkDownloadRequest copy$default(WatermarkDownloadRequest r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.url;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.scene;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.subScene;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.contentType;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.fileType;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.language;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.scene;
    }

    public final String component4() {
        return this.subScene;
    }

    public final String component5() {
        return this.contentType;
    }

    public final String component6() {
        return this.fileType;
    }

    public final String component7() {
        return this.language;
    }

    public final WatermarkDownloadRequest copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        return new WatermarkDownloadRequest(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WatermarkDownloadRequest) == true) goto L8;
        return false;
    L8:
        WatermarkDownloadRequest r101 = (WatermarkDownloadRequest) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subScene, r101.subScene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentType, r101.contentType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fileType, r101.fileType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.scene;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subScene;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.contentType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.fileType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.language;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "WatermarkDownloadRequest(uri=" + this.uri + ", url=" + this.url + ", scene=" + this.scene + ", subScene=" + this.subScene + ", contentType=" + this.contentType + ", fileType=" + this.fileType + ", language=" + this.language + ')';
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSubScene() {
        return this.subScene;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public WatermarkDownloadRequest(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.uri = r100;
        this.url = r101;
        this.scene = r102;
        this.subScene = r103;
        this.contentType = r104;
        this.fileType = r105;
        this.language = r106;
    }

    public /* synthetic */ WatermarkDownloadRequest(String r100, String r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
