package t51;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lt51/b;", "", "", "x", FaceService.girlLabel, "e", "()F", "m", "(F)V", "y", "f", OfficeSDKRequestTag.KEY_NEW_USER, "w", "d", "l", "h", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "position", "I", "b", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "zOrder", ce.f26391f, "o", "type", "getType", ce.f26395j, "", "visible", "Z", "c", "()Z", ce.f26396k, "(Z)V", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private float f544614h;

    @SerializedName("p")
    private int position;

    @SerializedName("type")
    private int type;

    @SerializedName("visible")
    private boolean visible;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private float f544615w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f544616x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f544617y;

    @SerializedName("z_order")
    private int zOrder;

    public final void k() {
        this.visible = false;
    }

    public final void o() {
        this.zOrder = 1;
    }

    public String toString() {
        return "BasePosition(x=" + this.f544616x + ", y=" + this.f544617y + ", w=" + this.f544615w + ", h=" + this.f544614h + ", position=" + this.position + ", zOrder=" + this.zOrder + ", visible=" + this.visible + ')';
    }

    public b() {
        this.visible = true;
    }

    public final float a() {
        return this.f544614h;
    }

    public final int b() {
        return this.position;
    }

    public final boolean c() {
        return this.visible;
    }

    public final float d() {
        return this.f544615w;
    }

    public final float e() {
        return this.f544616x;
    }

    public final float f() {
        return this.f544617y;
    }

    public final int g() {
        return this.zOrder;
    }

    public final int getType() {
        return this.type;
    }

    public final void h(float r100) {
        this.f544614h = r100;
    }

    public final void i(int r100) {
        this.position = r100;
    }

    public final void j(int r100) {
        this.type = r100;
    }

    public final void l(float r100) {
        this.f544615w = r100;
    }

    public final void m(float r100) {
        this.f544616x = r100;
    }

    public final void n(float r100) {
        this.f544617y = r100;
    }
}
