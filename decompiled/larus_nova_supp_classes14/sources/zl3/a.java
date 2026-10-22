package zl3;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import wl3.c;
import wl3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bl\u0010mR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\"\u00100\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\"\u00106\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR\"\u0010<\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\"\u0010?\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR\"\u0010B\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\"\u0010E\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\"\u0010H\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR$\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR$\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR$\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\"\u0010d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0004\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR*\u0010i\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010g8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u001b\u001a\u0004\bj\u0010\u001d\"\u0004\bk\u0010\u001f¨\u0006n"}, d2 = {"Lzl3/a;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "", "hash", "I", "getHash", "()I", "g", "(I)V", "className", "getClassName", "d", "width", "getWidth", "A", "height", "getHeight", "h", "", "children", "Ljava/util/List;", "a", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "visibility", "getVisibility", "z", "", "translationX", "F", "getTranslationX", "()F", "w", "(F)V", "translationY", "getTranslationY", "x", "scrollX", "getScrollX", "t", "scrollY", "getScrollY", "u", "marginLeft", "getMarginLeft", "k", "marginRight", "getMarginRight", "l", "marginTop", "getMarginTop", "m", "marginBottom", "getMarginBottom", "j", "paddingLeft", "getPaddingLeft", "o", "paddingTop", "getPaddingTop", "q", "paddingRight", "getPaddingRight", "p", "paddingBottom", "getPaddingBottom", "n", "Lwl3/c;", "properties", "Lwl3/c;", "getProperties", "()Lwl3/c;", "r", "(Lwl3/c;)V", "viewHolder", "getViewHolder", "y", "adapter", "getAdapter", "b", "scaleType", "getScaleType", "s", "backgroundResId", "getBackgroundResId", "c", "contentDescription", "getContentDescription", "e", "focusable", "getFocusable", "f", "textStr", "getTextStr", "v", "", "Lwl3/f;", "xmlAttributes", "getXmlAttributes", "B", "<init>", "()V", "tetris-inspector-sdk_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("ad")
    private String adapter;

    @SerializedName("br")
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

    @SerializedName("i")
    private String id;

    @SerializedName("mb")
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

    @SerializedName("pt")
    private int paddingTop;

    @SerializedName("ps")
    private c properties;

    @SerializedName("st")
    private String scaleType;

    @SerializedName("sx")
    private int scrollX;

    @SerializedName("sy")
    private int scrollY;

    @SerializedName("textStr")
    private String textStr;

    @SerializedName("tx")
    private float translationX;

    @SerializedName("ty")
    private float translationY;

    @SerializedName("vh")
    private String viewHolder;

    @SerializedName("v")
    private int visibility;

    @SerializedName("w")
    private int width;

    @SerializedName("xa")
    private List<? extends f> xmlAttributes;

    public a() {
        this.id = "";
        this.className = "";
        this.children = new ArrayList();
        this.focusable = "auto";
        this.textStr = "";
    }

    public final List<a> a() {
        return this.children;
    }

    public final void A(int r1) {
        this.width = r1;
    }

    public final void B(List<? extends f> r1) {
        this.xmlAttributes = r1;
    }

    public final void b(String r1) {
        this.adapter = r1;
    }

    public final void c(String r1) {
        this.backgroundResId = r1;
    }

    public final void d(String r1) {
        this.className = r1;
    }

    public final void e(String r1) {
        this.contentDescription = r1;
    }

    public final void f(String r1) {
        this.focusable = r1;
    }

    public final void g(int r1) {
        this.hash = r1;
    }

    public final void h(int r1) {
        this.height = r1;
    }

    public final void i(String r1) {
        this.id = r1;
    }

    public final void j(int r1) {
        this.marginBottom = r1;
    }

    public final void k(int r1) {
        this.marginLeft = r1;
    }

    public final void l(int r1) {
        this.marginRight = r1;
    }

    public final void m(int r1) {
        this.marginTop = r1;
    }

    public final void n(int r1) {
        this.paddingBottom = r1;
    }

    public final void o(int r1) {
        this.paddingLeft = r1;
    }

    public final void p(int r1) {
        this.paddingRight = r1;
    }

    public final void q(int r1) {
        this.paddingTop = r1;
    }

    public final void r(c r1) {
        this.properties = r1;
    }

    public final void s(String r1) {
        this.scaleType = r1;
    }

    public final void t(int r1) {
        this.scrollX = r1;
    }

    public final void u(int r1) {
        this.scrollY = r1;
    }

    public final void v(String r1) {
        this.textStr = r1;
    }

    public final void w(float r1) {
        this.translationX = r1;
    }

    public final void x(float r1) {
        this.translationY = r1;
    }

    public final void y(String r1) {
        this.viewHolder = r1;
    }

    public final void z(int r1) {
        this.visibility = r1;
    }
}
