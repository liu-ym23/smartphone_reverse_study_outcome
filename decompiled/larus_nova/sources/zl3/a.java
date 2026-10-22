package zl3;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.Keys;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.vivo.push.PushClientConstants;
import faceverify.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import wl3.c;
import wl3.f;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bl\u0010mR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\"\u00100\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\"\u00106\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR\"\u0010<\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\"\u0010?\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR\"\u0010B\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\"\u0010E\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\"\u0010H\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR$\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR$\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR$\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\"\u0010d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0004\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR*\u0010i\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010g8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u001b\u001a\u0004\bj\u0010\u001d\"\u0004\bk\u0010\u001f¨\u0006n"}, d2 = {"Lzl3/a;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "", w.BLOB_ELEM_IMAGE_HASHCODE, "I", "getHash", "()I", ce.f26391f, "(I)V", PushClientConstants.TAG_CLASS_NAME, "getClassName", "d", "width", "getWidth", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "height", "getHeight", "h", "", "children", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", RemoteMessageConst.Notification.VISIBILITY, "getVisibility", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "", LiveDegradeFpsAnimator.TRANSLATION_X, FaceService.girlLabel, "getTranslationX", "()F", "w", "(F)V", LiveDegradeFpsAnimator.TRANSLATION_Y, "getTranslationY", "x", "scrollX", "getScrollX", "t", "scrollY", "getScrollY", "u", "marginLeft", "getMarginLeft", ce.f26396k, "marginRight", "getMarginRight", "l", "marginTop", "getMarginTop", "m", "marginBottom", "getMarginBottom", ce.f26395j, "paddingLeft", "getPaddingLeft", "o", "paddingTop", "getPaddingTop", "q", "paddingRight", "getPaddingRight", "p", "paddingBottom", "getPaddingBottom", OfficeSDKRequestTag.KEY_NEW_USER, "Lwl3/c;", "properties", "Lwl3/c;", "getProperties", "()Lwl3/c;", "r", "(Lwl3/c;)V", "viewHolder", "getViewHolder", "y", "adapter", "getAdapter", "b", "scaleType", "getScaleType", "s", "backgroundResId", "getBackgroundResId", "c", "contentDescription", "getContentDescription", "e", "focusable", "getFocusable", "f", "textStr", "getTextStr", BaseSwitches.V, "", "Lwl3/f;", "xmlAttributes", "getXmlAttributes", "B", "<init>", "()V", "tetris-inspector-sdk_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("ad")
    private String adapter;

    @SerializedName(SRStrategy.MEDIAINFO_KEY_BITRATE)
    private String backgroundResId;

    @SerializedName("c")
    private List<a> children;

    @SerializedName("cl")
    private String className;

    @SerializedName("cdes")
    private String contentDescription;

    @SerializedName("focus_able")
    private String focusable;

    @SerializedName("hc")
    private int hash;

    @SerializedName("h")
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(RXScreenCaptureService.KEY_INDEX)
    private String f572785id;

    @SerializedName(Keys.API_PARAM_KEY_MB)
    private int marginBottom;

    @SerializedName("ml")
    private int marginLeft;

    @SerializedName("mr")
    private int marginRight;

    @SerializedName("mt")
    private int marginTop;

    @SerializedName("pb")
    private int paddingBottom;

    @SerializedName("pl")
    private int paddingLeft;

    @SerializedName("pr")
    private int paddingRight;

    @SerializedName(GXTemplateKey.GAIAX_PT)
    private int paddingTop;

    @SerializedName("ps")
    private c properties;

    @SerializedName(Segment.JsonKey.START)
    private String scaleType;

    @SerializedName("sx")
    private int scrollX;

    @SerializedName("sy")
    private int scrollY;

    @SerializedName("textStr")
    private String textStr;

    @SerializedName(MapBundleKey.MapObjKey.OBJ_TEXT)
    private float translationX;

    @SerializedName("ty")
    private float translationY;

    @SerializedName("vh")
    private String viewHolder;

    @SerializedName(BaseSwitches.V)
    private int visibility;

    @SerializedName("w")
    private int width;

    @SerializedName("xa")
    private List<? extends f> xmlAttributes;

    public a() {
        this.f572785id = "";
        this.className = "";
        this.children = new ArrayList();
        this.focusable = "auto";
        this.textStr = "";
    }

    public final List<a> a() {
        return this.children;
    }

    public final void A(int r100) {
        this.width = r100;
    }

    public final void B(List<? extends f> r100) {
        this.xmlAttributes = r100;
    }

    public final void b(String r100) {
        this.adapter = r100;
    }

    public final void c(String r100) {
        this.backgroundResId = r100;
    }

    public final void d(String r100) {
        this.className = r100;
    }

    public final void e(String r100) {
        this.contentDescription = r100;
    }

    public final void f(String r100) {
        this.focusable = r100;
    }

    public final void g(int r100) {
        this.hash = r100;
    }

    public final void h(int r100) {
        this.height = r100;
    }

    public final void i(String r100) {
        this.f572785id = r100;
    }

    public final void j(int r100) {
        this.marginBottom = r100;
    }

    public final void k(int r100) {
        this.marginLeft = r100;
    }

    public final void l(int r100) {
        this.marginRight = r100;
    }

    public final void m(int r100) {
        this.marginTop = r100;
    }

    public final void n(int r100) {
        this.paddingBottom = r100;
    }

    public final void o(int r100) {
        this.paddingLeft = r100;
    }

    public final void p(int r100) {
        this.paddingRight = r100;
    }

    public final void q(int r100) {
        this.paddingTop = r100;
    }

    public final void r(c r100) {
        this.properties = r100;
    }

    public final void s(String r100) {
        this.scaleType = r100;
    }

    public final void t(int r100) {
        this.scrollX = r100;
    }

    public final void u(int r100) {
        this.scrollY = r100;
    }

    public final void v(String r100) {
        this.textStr = r100;
    }

    public final void w(float r100) {
        this.translationX = r100;
    }

    public final void x(float r100) {
        this.translationY = r100;
    }

    public final void y(String r100) {
        this.viewHolder = r100;
    }

    public final void z(int r100) {
        this.visibility = r100;
    }
}
