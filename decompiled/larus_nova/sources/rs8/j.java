package rs8;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f539118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f539119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f539120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f539121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MessageActionBarAlign f539122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f539123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f539124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f539125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActionStyle f539126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f539127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<View, Unit> f539128m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f539116a, r101.f539116a) == true) goto L12;
        return false;
    L12:
        if (this.f539117b == r101.f539117b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539118c, r101.f539118c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f539119d, r101.f539119d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f539120e, r101.f539120e) == true) goto L24;
        return false;
    L24:
        if (Float.compare(this.f539121f, r101.f539121f) == 0) goto L27;
        return false;
    L27:
        if (this.f539122g == r101.f539122g) goto L30;
        return false;
    L30:
        if (this.f539123h == r101.f539123h) goto L33;
        return false;
    L33:
        if (this.f539124i == r101.f539124i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f539125j, r101.f539125j) == true) goto L39;
        return false;
    L39:
        if (this.f539126k == r101.f539126k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f539127l, r101.f539127l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f539128m, r101.f539128m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f539116a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f539117b) * 31) + this.f539118c.hashCode()) * 31;
        Drawable r104 = this.f539119d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f539120e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + Float.floatToIntBits(this.f539121f)) * 31) + this.f539122g.hashCode()) * 31;
        int r110 = 1231;
        if (this.f539123h == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f539124i == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (r112 + r110) * 31;
        Integer r114 = this.f539125j;
        if (r114 == null) goto L27;
        r101 = r114.hashCode();
    L27:
        return ((((((r113 + r101) * 31) + this.f539126k.hashCode()) * 31) + this.f539127l.hashCode()) * 31) + this.f539128m.hashCode();
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageAction(actionBarKey=" + this.f539116a + ", id=" + this.f539117b + ", description=" + this.f539118c + ", iconDrawable=" + this.f539119d + ", iconNormalUrl=" + this.f539120e + ", iconRotation=" + this.f539121f + ", messageActionBarAlign=" + this.f539122g + ", isSelected=" + this.f539123h + ", isEnable=" + this.f539124i + ", resourceIdForCompose=" + this.f539125j + ", style=" + this.f539126k + ", accessibilityContent=" + this.f539127l + ", onClick=" + this.f539128m + ')';
    }

    @Override // rs8.g
    public final String a() {
        return this.f539116a;
    }

    @Override // rs8.g
    public final MessageActionBarAlign b() {
        return this.f539122g;
    }

    @Override // rs8.g
    public final Function1<View, Unit> c() {
        return this.f539128m;
    }

    @Override // rs8.g
    public final String d() {
        return this.f539127l;
    }

    @Override // rs8.g
    public final CharSequence getDescription() {
        return this.f539118c;
    }

    @Override // rs8.g
    public final int getId() {
        return this.f539117b;
    }

    @Override // rs8.g
    public final ActionStyle getStyle() {
        return this.f539126k;
    }

    public static j e(j r110, boolean r111) {
        String r100 = r110.f539116a;
        int r101 = r110.f539117b;
        CharSequence r102 = r110.f539118c;
        Drawable r103 = r110.f539119d;
        String r104 = r110.f539120e;
        float r105 = r110.f539121f;
        MessageActionBarAlign r106 = r110.f539122g;
        boolean r107 = r110.f539123h;
        Integer r112 = r110.f539125j;
        ActionStyle r113 = r110.f539126k;
        String r114 = r110.f539127l;
        Function1<View, Unit> r115 = r110.f539128m;
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r106, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r113, "style");
        Intrinsics.checkNotNullParameter(r114, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r115, SendEventContainerMethodParamModel.EventKinds.onClick);
        return new j(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r100, int r101, CharSequence r102, Drawable r103, String r104, float r105, MessageActionBarAlign r106, boolean r107, boolean r110, Integer r111, ActionStyle r112, String r113, Function1<? super View, Unit> r114) {
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r106, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r112, "style");
        Intrinsics.checkNotNullParameter(r113, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r114, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f539116a = r100;
        this.f539117b = r101;
        this.f539118c = r102;
        this.f539119d = r103;
        this.f539120e = r104;
        this.f539121f = r105;
        this.f539122g = r106;
        this.f539123h = r107;
        this.f539124i = r110;
        this.f539125j = r111;
        this.f539126k = r112;
        this.f539127l = r113;
        this.f539128m = r114;
    }

    public /* synthetic */ j(String r110, int r111, CharSequence r210, Drawable r211, String r212, float r213, MessageActionBarAlign r214, boolean r215, boolean r216, Integer r217, ActionStyle r218, String r219, Function1 r310, int r311) {
        if ((r311 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r311 & 8) == 0) goto L9;
        Drawable r101 = null;
    L11:
        if ((r311 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r311 & 32) == 0) goto L17;
        float r103 = 0.0f;
    L19:
        if ((r311 & 64) == 0) goto L21;
        MessageActionBarAlign r112 = MessageActionBarAlign.START;
    L23:
        if ((r311 & 128) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r311 & 256) == 0) goto L29;
        boolean r114 = true;
    L31:
        if ((r311 & 512) == 0) goto L33;
        Integer r115 = null;
    L35:
        if ((r311 & 1024) == 0) goto L37;
        ActionStyle r116 = ActionStyle.NORMAL;
    L39:
        if ((r311 & 2048) == 0) goto L41;
        String r117 = "";
    L43:
        if ((r311 & 4096) == 0) goto L45;
        Function1 r118 = new i();
    L46:
        this(r100, r111, r210, r101, r102, r103, r112, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r310;
        goto L46
    L41:
        r117 = r219;
        goto L43
    L37:
        r116 = r218;
        goto L39
    L33:
        r115 = r217;
        goto L35
    L29:
        r114 = r216;
        goto L31
    L25:
        r113 = r215;
        goto L27
    L21:
        r112 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
