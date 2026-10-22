package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/ResourceCenterEnabledForSceneConfig;", "", "uploadFile", "", "imageVLM", "imageOCR", "imageEdu", "<init>", "(ZZZZ)V", "getUploadFile", "()Z", "getImageVLM", "getImageOCR", "getImageEdu", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c4 {

    @SerializedName("edu_image")
    private final boolean imageEdu;

    @SerializedName("ocr_image")
    private final boolean imageOCR;

    @SerializedName("vlm_image")
    private final boolean imageVLM;

    @SerializedName("upload_file")
    private final boolean uploadFile;

    public c4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c4) == true) goto L8;
        return false;
    L8:
        c4 r101 = (c4) r100;
        if (this.uploadFile == r101.uploadFile) goto L12;
        return false;
    L12:
        if (this.imageVLM == r101.imageVLM) goto L15;
        return false;
    L15:
        if (this.imageOCR == r101.imageOCR) goto L18;
        return false;
    L18:
        if (this.imageEdu == r101.imageEdu) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.uploadFile == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.imageVLM == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.imageOCR == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.imageEdu == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceCenterEnabledForSceneConfig(uploadFile=" + this.uploadFile + ", imageVLM=" + this.imageVLM + ", imageOCR=" + this.imageOCR + ", imageEdu=" + this.imageEdu + ')';
    }

    public final boolean a() {
        return this.imageEdu;
    }

    public final boolean b() {
        return this.imageOCR;
    }

    public final boolean c() {
        return this.imageVLM;
    }

    public final boolean d() {
        return this.uploadFile;
    }

    public c4(int r100) {
        this.uploadFile = true;
        this.imageVLM = true;
        this.imageOCR = true;
        this.imageEdu = true;
    }
}
