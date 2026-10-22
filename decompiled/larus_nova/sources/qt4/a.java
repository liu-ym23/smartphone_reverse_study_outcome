package qt4;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.bear.bitable.itemview.record.list.ContainerDirection;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f534784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContainerDirection f534786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f534787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f534788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f534789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EFieldUIType f534790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f534791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f534792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IRenderFontStyle f534793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActionPayload f534794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ActionPayload f534795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ActionPayload f534796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f534797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Icon f534798o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f534784a == r101.f534784a) goto L12;
        return false;
    L12:
        if (this.f534785b == r101.f534785b) goto L15;
        return false;
    L15:
        if (this.f534786c == r101.f534786c) goto L18;
        return false;
    L18:
        if (this.f534787d == r101.f534787d) goto L21;
        return false;
    L21:
        if (this.f534788e == r101.f534788e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f534789f, r101.f534789f) == true) goto L27;
        return false;
    L27:
        if (this.f534790g == r101.f534790g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f534791h, r101.f534791h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f534792i, r101.f534792i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f534793j, r101.f534793j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f534794k, r101.f534794k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f534795l, r101.f534795l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f534796m, r101.f534796m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f534797n, r101.f534797n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f534798o, r101.f534798o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f534784a * 31;
        int r101 = 1231;
        if (this.f534785b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        ContainerDirection r104 = this.f534786c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.f534787d) * 31;
        if (this.f534788e == true) goto L14;
        r101 = 1237;
    L14:
        int r108 = (((((((((r107 + r101) * 31) + this.f534789f.hashCode()) * 31) + this.f534790g.hashCode()) * 31) + this.f534791h.hashCode()) * 31) + this.f534792i.hashCode()) * 31;
        IRenderFontStyle r109 = this.f534793j;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        ActionPayload r112 = this.f534794k;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        ActionPayload r115 = this.f534795l;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        ActionPayload r118 = this.f534796m;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Boolean r121 = this.f534797n;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Icon r124 = this.f534798o;
        if (r124 == null) goto L39;
        r105 = r124.hashCode();
    L39:
        return r123 + r105;
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CellContextData(remainWidth=" + this.f534784a + ", needFlow=" + this.f534785b + ", direction=" + this.f534786c + ", maxWidth=" + this.f534787d + ", editable=" + this.f534788e + ", onClick=" + this.f534789f + ", originalFieldUIType=" + this.f534790g + ", recordId=" + this.f534791h + ", fieldId=" + this.f534792i + ", fontStyle=" + this.f534793j + ", clearAction=" + this.f534794k + ", setValueAction=" + this.f534795l + ", clickLinkAction=" + this.f534796m + ", showFieldName=" + this.f534797n + ", emptyDataIcon=" + this.f534798o + ')';
    }

    public /* synthetic */ a(Runnable r110, EFieldUIType r111) {
        this(0, false, null, 0, false, r110, r111, "", "", null, null, null, null, null, null);
    }

    public a(int r100, boolean r101, ContainerDirection r102, int r110, boolean r111, Runnable r112, EFieldUIType r113, String r114, String r115, IRenderFontStyle r116, ActionPayload r117, ActionPayload r118, ActionPayload r119, Boolean r210, Icon r211) {
        Intrinsics.checkNotNullParameter(r112, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r113, "originalFieldUIType");
        Intrinsics.checkNotNullParameter(r114, "recordId");
        Intrinsics.checkNotNullParameter(r115, "fieldId");
        this.f534784a = r100;
        this.f534785b = r101;
        this.f534786c = r102;
        this.f534787d = r110;
        this.f534788e = r111;
        this.f534789f = r112;
        this.f534790g = r113;
        this.f534791h = r114;
        this.f534792i = r115;
        this.f534793j = r116;
        this.f534794k = r117;
        this.f534795l = r118;
        this.f534796m = r119;
        this.f534797n = r210;
        this.f534798o = r211;
    }
}
