package com.obric.sva.sdk.ui;

import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003Je\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00105\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u000eHÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006:"}, d2 = {"Lcom/obric/sva/sdk/ui/ViewBgAnimData;", "Lcom/obric/sva/sdk/ui/ViewAnimData;", "view", "Landroid/view/View;", "propertyName", "", "startValue", "", "endValue", "interpolator", "Landroid/view/animation/Interpolator;", "startValue1", "endValue1", "radius", "", "clipBounds", "", "<init>", "(Landroid/view/View;Ljava/lang/String;FFLandroid/view/animation/Interpolator;FFIZ)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "getPropertyName", "()Ljava/lang/String;", "setPropertyName", "(Ljava/lang/String;)V", "getStartValue", "()F", "setStartValue", "(F)V", "getEndValue", "setEndValue", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "getStartValue1", "getEndValue1", "getRadius", "()I", "getClipBounds", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewBgAnimData extends ViewAnimData {
    private final boolean clipBounds;
    private float endValue;
    private final float endValue1;
    private Interpolator interpolator;
    private String propertyName;
    private final int radius;
    private float startValue;
    private final float startValue1;
    private View view;

    public static /* synthetic */ ViewBgAnimData copy$default(ViewBgAnimData r110, View r111, String r112, float r113, float r114, Interpolator r115, float r116, float r117, int r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        View r100 = r110.view;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.propertyName;
    L11:
        if ((r210 & 4) == 0) goto L13;
        float r102 = r110.startValue;
    L15:
        if ((r210 & 8) == 0) goto L17;
        float r103 = r110.endValue;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Interpolator r104 = r110.interpolator;
    L23:
        if ((r210 & 32) == 0) goto L25;
        float r105 = r110.startValue1;
    L27:
        if ((r210 & 64) == 0) goto L29;
        float r106 = r110.endValue1;
    L31:
        if ((r210 & 128) == 0) goto L33;
        int r107 = r110.radius;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.clipBounds;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final View component1() {
        return this.view;
    }

    public final String component2() {
        return this.propertyName;
    }

    public final float component3() {
        return this.startValue;
    }

    public final float component4() {
        return this.endValue;
    }

    public final Interpolator component5() {
        return this.interpolator;
    }

    public final float component6() {
        return this.startValue1;
    }

    public final float component7() {
        return this.endValue1;
    }

    public final int component8() {
        return this.radius;
    }

    public final boolean component9() {
        return this.clipBounds;
    }

    public final ViewBgAnimData copy(View r110, String r111, float r112, float r113, Interpolator r114, float r115, float r116, int r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r111, "propertyName");
        Intrinsics.checkNotNullParameter(r114, "interpolator");
        return new ViewBgAnimData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewBgAnimData) == true) goto L8;
        return false;
    L8:
        ViewBgAnimData r101 = (ViewBgAnimData) r100;
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.propertyName, r101.propertyName) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.startValue, r101.startValue) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.endValue, r101.endValue) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.interpolator, r101.interpolator) == true) goto L24;
        return false;
    L24:
        if (Float.compare(this.startValue1, r101.startValue1) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.endValue1, r101.endValue1) == 0) goto L30;
        return false;
    L30:
        if (this.radius == r101.radius) goto L33;
        return false;
    L33:
        if (this.clipBounds == r101.clipBounds) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        View r100 = this.view;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((((((((((r101 * 31) + this.propertyName.hashCode()) * 31) + Float.floatToIntBits(this.startValue)) * 31) + Float.floatToIntBits(this.endValue)) * 31) + this.interpolator.hashCode()) * 31) + Float.floatToIntBits(this.startValue1)) * 31) + Float.floatToIntBits(this.endValue1)) * 31) + this.radius) * 31;
        if (this.clipBounds == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ViewBgAnimData(view=" + this.view + ", propertyName=" + this.propertyName + ", startValue=" + this.startValue + ", endValue=" + this.endValue + ", interpolator=" + this.interpolator + ", startValue1=" + this.startValue1 + ", endValue1=" + this.endValue1 + ", radius=" + this.radius + ", clipBounds=" + this.clipBounds + ')';
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public boolean getClipBounds() {
        return this.clipBounds;
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public float getEndValue() {
        return this.endValue;
    }

    public final float getEndValue1() {
        return this.endValue1;
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public String getPropertyName() {
        return this.propertyName;
    }

    public final int getRadius() {
        return this.radius;
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public float getStartValue() {
        return this.startValue;
    }

    public final float getStartValue1() {
        return this.startValue1;
    }

    @Override // com.obric.sva.sdk.ui.ViewAnimData
    public View getView() {
        return this.view;
    }

    public void setEndValue(float r100) {
        this.endValue = r100;
    }

    public void setInterpolator(Interpolator r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interpolator = r100;
    }

    public void setPropertyName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.propertyName = r100;
    }

    public void setStartValue(float r100) {
        this.startValue = r100;
    }

    public void setView(View r100) {
        this.view = r100;
    }

    public ViewBgAnimData(View r110, String r111, float r112, float r113, Interpolator r114, float r115, float r116, int r117, boolean r118) {
        Intrinsics.checkNotNullParameter(r111, "propertyName");
        Intrinsics.checkNotNullParameter(r114, "interpolator");
        super(r110, r111, r112, r113, r118, r114);
        this.view = r110;
        this.propertyName = r111;
        this.startValue = r112;
        this.endValue = r113;
        this.interpolator = r114;
        this.startValue1 = r115;
        this.endValue1 = r116;
        this.radius = r117;
        this.clipBounds = r118;
    }

    public /* synthetic */ ViewBgAnimData(View r110, String r111, float r112, float r113, Interpolator r114, float r115, float r116, int r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 16) == 0) goto L5;
        Interpolator r100 = new LinearInterpolator();
    L7:
        if ((r212 & 256) == 0) goto L9;
        boolean r117 = false;
    L10:
        this(r110, r111, r112, r113, r100, r115, r116, r210, r117);
        return;
    L9:
        r117 = r211;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
