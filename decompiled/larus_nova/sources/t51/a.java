package t51;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\b¨\u0006<"}, d2 = {"Lt51/a;", "", "", "adjustBase", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "m", "(I)V", "scale", ce.f26395j, "t", "align", "b", OfficeSDKRequestTag.KEY_NEW_USER, "Lt51/i;", "uiContainer", "Lt51/i;", "l", "()Lt51/i;", BaseSwitches.V, "(Lt51/i;)V", "anchorHeightFixMode", "d", "p", "Lt51/d;", "anchorContainerOffset", "Lt51/d;", "c", "()Lt51/d;", "o", "(Lt51/d;)V", "audienceHeightFixMode", "f", "r", "", "autoCenterV", "Z", "h", "()Z", "setAutoCenterV", "(Z)V", "autoCenterH", ce.f26391f, "s", "Lt51/c;", "canvasTransform", "Lt51/c;", RXScreenCaptureService.KEY_INDEX, "()Lt51/c;", "setCanvasTransform", "(Lt51/c;)V", "topOffset", ce.f26396k, "u", "anchorTopOffset", "e", "q", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("adjust_base")
    private int adjustBase;

    @SerializedName("align")
    private int align;

    @SerializedName("anchor_container_offset")
    private d anchorContainerOffset;

    @SerializedName("anchor_height_fix_mode")
    private int anchorHeightFixMode;

    @SerializedName("anchor_top_offset")
    private int anchorTopOffset;

    @SerializedName("audience_height_fix_mode")
    private int audienceHeightFixMode;

    @SerializedName("auto_center_h")
    private boolean autoCenterH;

    @SerializedName("auto_center_v")
    private boolean autoCenterV;

    @SerializedName("canvas_transform")
    private c canvasTransform;

    @SerializedName("scale")
    private int scale;

    @SerializedName("top_offset")
    private int topOffset;

    @SerializedName("ui_container")
    private i uiContainer;

    public final void s() {
        this.autoCenterH = true;
    }

    public final String toString() {
        return "AdjustRule={adjustBase=" + this.adjustBase + ",scale=" + this.scale + ",align=" + this.align + ",uiContainer=" + this.uiContainer + com.alipay.sdk.m.u.i.f25855d;
    }

    public a() {
        this.uiContainer = new i();
        this.anchorHeightFixMode = AnchorHeightFixMode.RationTransformHeight.ordinal();
        this.anchorContainerOffset = new d();
        this.audienceHeightFixMode = AudienceHeightFixMode.RationTransformHeight.ordinal();
        this.autoCenterH = true;
        this.canvasTransform = new c();
    }

    public final int a() {
        return this.adjustBase;
    }

    public final int b() {
        return this.align;
    }

    public final d c() {
        return this.anchorContainerOffset;
    }

    public final int d() {
        return this.anchorHeightFixMode;
    }

    public final int e() {
        return this.anchorTopOffset;
    }

    public final int f() {
        return this.audienceHeightFixMode;
    }

    public final boolean g() {
        return this.autoCenterH;
    }

    public final boolean h() {
        return this.autoCenterV;
    }

    public final c i() {
        return this.canvasTransform;
    }

    public final int j() {
        return this.scale;
    }

    public final int k() {
        return this.topOffset;
    }

    public final i l() {
        return this.uiContainer;
    }

    public final void m(int r100) {
        this.adjustBase = r100;
    }

    public final void n(int r100) {
        this.align = r100;
    }

    public final void o(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorContainerOffset = r100;
    }

    public final void p(int r100) {
        this.anchorHeightFixMode = r100;
    }

    public final void q(int r100) {
        this.anchorTopOffset = r100;
    }

    public final void r(int r100) {
        this.audienceHeightFixMode = r100;
    }

    public final void t(int r100) {
        this.scale = r100;
    }

    public final void u(int r100) {
        this.topOffset = r100;
    }

    public final void v(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uiContainer = r100;
    }
}
