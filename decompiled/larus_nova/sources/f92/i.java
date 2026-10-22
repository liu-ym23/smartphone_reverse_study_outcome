package f92;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lf92/i;", "", "", "x", "D", "e", "()D", ce.f26396k, "(D)V", "y", "f", "l", "width", "d", ce.f26395j, "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ce.f26391f, "", "pushMode", "I", "c", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "layoutType", "b", "h", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("height")
    private double height;

    @SerializedName("layout_type")
    private int layoutType;

    @SerializedName("push_mode")
    private int pushMode;

    @SerializedName("width")
    private double width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private double f475961x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private double f475962y;

    public i() {
    }

    public final double a() {
        return this.height;
    }

    public final int b() {
        return this.layoutType;
    }

    public final int c() {
        return this.pushMode;
    }

    public final double d() {
        return this.width;
    }

    public final double e() {
        return this.f475961x;
    }

    public final double f() {
        return this.f475962y;
    }

    public final void g(double r100) {
        this.height = r100;
    }

    public final void h(int r100) {
        this.layoutType = r100;
    }

    public final void i(int r100) {
        this.pushMode = r100;
    }

    public final void j(double r100) {
        this.width = r100;
    }

    public final void k(double r100) {
        this.f475961x = r100;
    }

    public final void l(double r100) {
        this.f475962y = r100;
    }
}
