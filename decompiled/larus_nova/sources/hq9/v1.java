package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/larus/platform/model/ImageShare;", "", "shareImageEnable", "", "defaultTab", "", "rememberLastChoice", "textToImageEnable", "downloadImageEnable", "enablePuzzle", "<init>", "(ZIZZZZ)V", "getShareImageEnable", "()Z", "getDefaultTab", "()I", "getRememberLastChoice", "getTextToImageEnable", "getDownloadImageEnable", "getEnablePuzzle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v1 {

    @SerializedName("default_tab")
    private final int defaultTab;

    @SerializedName("download_to_share_enable")
    private final boolean downloadImageEnable;

    @SerializedName("enable_puzzle")
    private final boolean enablePuzzle;

    @SerializedName("remember_last_choice")
    private final boolean rememberLastChoice;

    @SerializedName("use_new_save_panel")
    private final boolean shareImageEnable;

    @SerializedName("text_to_image_enable")
    private final boolean textToImageEnable;

    public v1() {
        this(false, 0, false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v1) == true) goto L8;
        return false;
    L8:
        v1 r101 = (v1) r100;
        if (this.shareImageEnable == r101.shareImageEnable) goto L12;
        return false;
    L12:
        if (this.defaultTab == r101.defaultTab) goto L15;
        return false;
    L15:
        if (this.rememberLastChoice == r101.rememberLastChoice) goto L18;
        return false;
    L18:
        if (this.textToImageEnable == r101.textToImageEnable) goto L21;
        return false;
    L21:
        if (this.downloadImageEnable == r101.downloadImageEnable) goto L24;
        return false;
    L24:
        if (this.enablePuzzle == r101.enablePuzzle) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.shareImageEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.defaultTab) * 31;
        if (this.rememberLastChoice == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.textToImageEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.downloadImageEnable == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enablePuzzle == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
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
        return "ImageShare(shareImageEnable=" + this.shareImageEnable + ", defaultTab=" + this.defaultTab + ", rememberLastChoice=" + this.rememberLastChoice + ", textToImageEnable=" + this.textToImageEnable + ", downloadImageEnable=" + this.downloadImageEnable + ", enablePuzzle=" + this.enablePuzzle + ')';
    }

    public final int a() {
        return this.defaultTab;
    }

    public final boolean b() {
        return this.downloadImageEnable;
    }

    public final boolean c() {
        return this.enablePuzzle;
    }

    public final boolean d() {
        return this.rememberLastChoice;
    }

    public final boolean e() {
        return this.shareImageEnable;
    }

    public final boolean f() {
        return this.textToImageEnable;
    }

    public v1(boolean r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.shareImageEnable = r100;
        this.defaultTab = r101;
        this.rememberLastChoice = r102;
        this.textToImageEnable = r103;
        this.downloadImageEnable = r104;
        this.enablePuzzle = r105;
    }
}
