package fn8;

import android.util.Size;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RichMediaKind f478018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f478019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Size f478020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f478021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d0 f478022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f478023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<a> f478024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f478025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f478026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f478027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f478028o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f478014a, r101.f478014a) == true) goto L12;
        return false;
    L12:
        if (this.f478015b == r101.f478015b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478016c, r101.f478016c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f478017d, r101.f478017d) == true) goto L21;
        return false;
    L21:
        if (this.f478018e == r101.f478018e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f478019f, r101.f478019f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f478020g, r101.f478020g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f478021h, r101.f478021h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f478022i, r101.f478022i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f478023j, r101.f478023j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f478024k, r101.f478024k) == true) goto L42;
        return false;
    L42:
        if (this.f478025l == r101.f478025l) goto L45;
        return false;
    L45:
        if (this.f478026m == r101.f478026m) goto L48;
        return false;
    L48:
        if (this.f478027n == r101.f478027n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f478028o, r101.f478028o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f478014a.hashCode() * 31) + this.f478015b) * 31;
        String r101 = this.f478016c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f478017d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((((r104 + r106) * 31) + this.f478018e.hashCode()) * 31) + this.f478019f.hashCode()) * 31) + this.f478020g.hashCode()) * 31) + this.f478021h.hashCode()) * 31;
        d0 r108 = this.f478022i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f478023j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f478024k.hashCode()) * 31;
        int r114 = 1231;
        if (this.f478025l == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f478026m == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f478027n == true) goto L30;
        r114 = 1237;
    L30:
        int r119 = (r118 + r114) * 31;
        String r120 = this.f478028o;
        if (r120 == null) goto L35;
        r102 = r120.hashCode();
    L35:
        return r119 + r102;
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "RichMediaItemViewConfig(stableKey=" + this.f478014a + ", position=" + this.f478015b + ", blockId=" + this.f478016c + ", messageId=" + this.f478017d + ", mediaKind=" + this.f478018e + ", coverUrl=" + this.f478019f + ", itemSize=" + this.f478020g + ", bizTag=" + this.f478021h + ", sourceIcon=" + this.f478022i + ", caption=" + this.f478023j + ", actions=" + this.f478024k + ", enableInlinePlayback=" + this.f478025l + ", autoPlayAnimatedCover=" + this.f478026m + ", enableCreationSingleImageExposure=" + this.f478027n + ", creationSingleImageExposureCellId=" + this.f478028o + ')';
    }

    public x(String r100, int r110, String r111, String r112, RichMediaKind r113, String r114, Size r115, String r116, d0 r117, String r118, List<a> r119, boolean r210, boolean r211, boolean r212, String r213) {
        Intrinsics.checkNotNullParameter(r100, "stableKey");
        Intrinsics.checkNotNullParameter(r113, "mediaKind");
        Intrinsics.checkNotNullParameter(r114, "coverUrl");
        Intrinsics.checkNotNullParameter(r115, "itemSize");
        Intrinsics.checkNotNullParameter(r116, "bizTag");
        Intrinsics.checkNotNullParameter(r119, SlcCommonAction.KEY_ACTIONS);
        this.f478014a = r100;
        this.f478015b = r110;
        this.f478016c = r111;
        this.f478017d = r112;
        this.f478018e = r113;
        this.f478019f = r114;
        this.f478020g = r115;
        this.f478021h = r116;
        this.f478022i = r117;
        this.f478023j = r118;
        this.f478024k = r119;
        this.f478025l = r210;
        this.f478026m = r211;
        this.f478027n = r212;
        this.f478028o = r213;
    }
}
