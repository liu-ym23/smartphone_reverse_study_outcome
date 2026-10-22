package t51;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lt51/i;", "", "", "left", "I", "c", "()I", "setLeft", "(I)V", "", "leftRatio", FaceService.girlLabel, "d", "()F", ce.f26395j, "(F)V", "top", ce.f26391f, "l", "topRatio", "h", "m", "right", "e", "setRight", "rightRatio", "f", ce.f26396k, "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBottom", "bottomRatio", "b", RXScreenCaptureService.KEY_INDEX, "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i {

    @SerializedName("bottom")
    private int bottom;

    @SerializedName("bottom_ratio")
    private float bottomRatio;

    @SerializedName("left")
    private int left;

    @SerializedName("left_ratio")
    private float leftRatio;

    @SerializedName("right")
    private int right;

    @SerializedName("right_ratio")
    private float rightRatio;

    @SerializedName("top")
    private int top;

    @SerializedName("top_ratio")
    private float topRatio;

    public i() {
    }

    public final void l() {
        this.top = 134;
    }

    public final String toString() {
        return "UIContainer={left=" + this.left + ",leftRatio=" + this.leftRatio + ",top=" + this.top + ",topRatio=" + this.topRatio + ",right=" + this.right + "rightRatio=" + this.rightRatio + "bottom=" + this.bottom + "bottomRatio=" + this.bottomRatio + com.alipay.sdk.m.u.i.f25855d;
    }

    public final int a() {
        return this.bottom;
    }

    public final float b() {
        return this.bottomRatio;
    }

    public final int c() {
        return this.left;
    }

    public final float d() {
        return this.leftRatio;
    }

    public final int e() {
        return this.right;
    }

    public final float f() {
        return this.rightRatio;
    }

    public final int g() {
        return this.top;
    }

    public final float h() {
        return this.topRatio;
    }

    public final void i(float r100) {
        this.bottomRatio = r100;
    }

    public final void j(float r100) {
        this.leftRatio = r100;
    }

    public final void k(float r100) {
        this.rightRatio = r100;
    }

    public final void m(float r100) {
        this.topRatio = r100;
    }
}
