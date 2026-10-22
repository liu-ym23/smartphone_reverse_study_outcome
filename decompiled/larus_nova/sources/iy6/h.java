package iy6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Liy6/h;", "", "", "scene", "I", "getScene", "()I", "videoStyle", "getVideoStyle", "", "data", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Liy6/d;", "headerContainer", "Liy6/d;", "c", "()Liy6/d;", "footerContainer", "b", "", "Liy6/c;", "playItems", "Ljava/util/List;", "d", "()Ljava/util/List;", "setPlayItems", "(Ljava/util/List;)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("data")
    private final String data;

    @SerializedName("footer_container")
    private final d footerContainer;

    @SerializedName("header_container")
    private final d headerContainer;

    @SerializedName("items")
    private List<c> playItems;

    @SerializedName("scene")
    private final int scene;

    @SerializedName(TextureRenderKeys.KEY_IS_VIDEO_STYLE)
    private final int videoStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (this.videoStyle == r101.videoStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.headerContainer, r101.headerContainer) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.footerContainer, r101.footerContainer) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.playItems, r101.playItems) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.scene * 31) + this.videoStyle) * 31;
        String r101 = this.data;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        d r105 = this.headerContainer;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        d r108 = this.footerContainer;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<c> r111 = this.playItems;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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

    public final String toString() {
        return "PoiPlayerPageData(scene=" + this.scene + ", videoStyle=" + this.videoStyle + ", data=" + this.data + ", headerContainer=" + this.headerContainer + ", footerContainer=" + this.footerContainer + ", playItems=" + this.playItems + ')';
    }

    public h() {
        this.scene = -1;
        this.videoStyle = 1;
        this.data = null;
        this.headerContainer = null;
        this.footerContainer = null;
        this.playItems = null;
    }

    public final String a() {
        return this.data;
    }

    public final d b() {
        return this.footerContainer;
    }

    public final d c() {
        return this.headerContainer;
    }

    public final List<c> d() {
        return this.playItems;
    }
}
