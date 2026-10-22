package com.larus.uaigc.bean.remove;

import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "Ljava/io/Serializable;", "sendMsgImgStoragePath", "", "maskImgFilePath", "oriImgFilePath", "oriImgUri", "oriImgUrl", "imageUploadInfo", "Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "getSendMsgImgStoragePath", "()Ljava/lang/String;", "setSendMsgImgStoragePath", "(Ljava/lang/String;)V", "getMaskImgFilePath", "setMaskImgFilePath", "getOriImgFilePath", "setOriImgFilePath", "getOriImgUri", "setOriImgUri", "getOriImgUrl", "setOriImgUrl", "getImageUploadInfo", "()Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "setImageUploadInfo", "(Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageEditDataWithMask implements Serializable {
    private ImageUploadInfo imageUploadInfo;
    private String maskImgFilePath;
    private String oriImgFilePath;
    private String oriImgUri;
    private String oriImgUrl;
    private String sendMsgImgStoragePath;

    public ImageEditDataWithMask() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final ImageUploadInfo getImageUploadInfo() {
        return this.imageUploadInfo;
    }

    public final String getMaskImgFilePath() {
        return this.maskImgFilePath;
    }

    public final String getOriImgFilePath() {
        return this.oriImgFilePath;
    }

    public final String getOriImgUri() {
        return this.oriImgUri;
    }

    public final String getOriImgUrl() {
        return this.oriImgUrl;
    }

    public final String getSendMsgImgStoragePath() {
        return this.sendMsgImgStoragePath;
    }

    public final void setImageUploadInfo(ImageUploadInfo r100) {
        this.imageUploadInfo = r100;
    }

    public final void setMaskImgFilePath(String r100) {
        this.maskImgFilePath = r100;
    }

    public final void setOriImgFilePath(String r100) {
        this.oriImgFilePath = r100;
    }

    public final void setOriImgUri(String r100) {
        this.oriImgUri = r100;
    }

    public final void setOriImgUrl(String r100) {
        this.oriImgUrl = r100;
    }

    public final void setSendMsgImgStoragePath(String r100) {
        this.sendMsgImgStoragePath = r100;
    }

    public ImageEditDataWithMask(String r100, String r101, String r102, String r103, String r104, ImageUploadInfo r105) {
        this.sendMsgImgStoragePath = r100;
        this.maskImgFilePath = r101;
        this.oriImgFilePath = r102;
        this.oriImgUri = r103;
        this.oriImgUrl = r104;
        this.imageUploadInfo = r105;
    }

    public /* synthetic */ ImageEditDataWithMask(String r100, String r101, String r102, String r103, String r110, ImageUploadInfo r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        ImageUploadInfo r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
