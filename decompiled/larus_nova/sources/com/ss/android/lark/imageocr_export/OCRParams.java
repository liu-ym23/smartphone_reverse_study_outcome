package com.ss.android.lark.imageocr_export;

import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010!\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/ss/android/lark/imageocr_export/OCRParams;", "Ljava/io/Serializable;", "localImagePath", "", "remoteImageKey", "msgID", "scene", "Lcom/bytedance/lark/pb/media/v1/DownloadFileScene;", "isPreLoad", "", "ocrScene", "Lcom/ss/android/lark/imageocr_export/OCRScene;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/pb/media/v1/DownloadFileScene;ZLcom/ss/android/lark/imageocr_export/OCRScene;)V", "getLocalImagePath", "()Ljava/lang/String;", "setLocalImagePath", "(Ljava/lang/String;)V", "getRemoteImageKey", "setRemoteImageKey", "getMsgID", "setMsgID", "getScene", "()Lcom/bytedance/lark/pb/media/v1/DownloadFileScene;", "setScene", "(Lcom/bytedance/lark/pb/media/v1/DownloadFileScene;)V", "()Z", "setPreLoad", "(Z)V", "getOcrScene", "()Lcom/ss/android/lark/imageocr_export/OCRScene;", "setOcrScene", "(Lcom/ss/android/lark/imageocr_export/OCRScene;)V", "toString", "imageocr_export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OCRParams implements Serializable {
    private boolean isPreLoad;
    private String localImagePath;
    private String msgID;
    private OCRScene ocrScene;
    private String remoteImageKey;
    private DownloadFileScene scene;

    public String toString() {
        return "localImagePath=" + this.localImagePath + ",remoteImageKey=" + this.remoteImageKey + ",msgID=" + this.msgID + ",scene=" + this.scene;
    }

    public final String getLocalImagePath() {
        return this.localImagePath;
    }

    public final String getMsgID() {
        return this.msgID;
    }

    public final OCRScene getOcrScene() {
        return this.ocrScene;
    }

    public final String getRemoteImageKey() {
        return this.remoteImageKey;
    }

    public final DownloadFileScene getScene() {
        return this.scene;
    }

    public final boolean isPreLoad() {
        return this.isPreLoad;
    }

    public final void setLocalImagePath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.localImagePath = r100;
    }

    public final void setMsgID(String r100) {
        this.msgID = r100;
    }

    public final void setOcrScene(OCRScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ocrScene = r100;
    }

    public final void setPreLoad(boolean r100) {
        this.isPreLoad = r100;
    }

    public final void setRemoteImageKey(String r100) {
        this.remoteImageKey = r100;
    }

    public final void setScene(DownloadFileScene r100) {
        this.scene = r100;
    }

    public OCRParams(String r100, String r101, String r102, DownloadFileScene r103, boolean r104, OCRScene r105) {
        Intrinsics.checkNotNullParameter(r100, "localImagePath");
        Intrinsics.checkNotNullParameter(r105, "ocrScene");
        this.localImagePath = r100;
        this.remoteImageKey = r101;
        this.msgID = r102;
        this.scene = r103;
        this.isPreLoad = r104;
        this.ocrScene = r105;
    }

    public /* synthetic */ OCRParams(String r100, String r101, String r102, DownloadFileScene r103, boolean r110, OCRScene r111, int r112, DefaultConstructorMarker r113) {
        DownloadFileScene r104 = null;
        if ((r112 & 2) == 0) goto L5;
        String r105 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r112 & 8) != 0) goto L15;
        r104 = r103;
    L15:
        if ((r112 & 16) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r112 & 32) == 0) goto L21;
        OCRScene r108 = OCRScene.OCR;
    L22:
        this(r100, r105, r106, r104, r107, r108);
        return;
    L21:
        r108 = r111;
        goto L22
    L17:
        r107 = r110;
        goto L19
    L9:
        r106 = r102;
        goto L11
    L5:
        r105 = r101;
        goto L7
    }
}
