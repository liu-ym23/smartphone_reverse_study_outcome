package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.color.h0;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import fja.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import vma.i;
import wma.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0004J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0004J\u0012\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0014R\"\u0010\u001b\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010&\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010.\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\"\u00105\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R*\u0010J\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010N\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bK\u00100\u001a\u0004\bL\u00102\"\u0004\bM\u00104R*\u0010R\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bO\u0010E\u001a\u0004\bP\u0010G\"\u0004\bQ\u0010IR\"\u0010V\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0016\u001a\u0004\bT\u0010\u0018\"\u0004\bU\u0010\u001aR\"\u0010X\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u00100\u001a\u0004\bX\u00102\"\u0004\bY\u00104R\"\u0010Z\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bZ\u00100\u001a\u0004\bZ\u00102\"\u0004\b[\u00104¨\u0006]"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/g;", "", "", "enabled", "", "setEnabled", "Landroid/view/View;", "view", "setBackdropTarget", "", "radius", "setContentSelfBlur", "progress", "setContentShadowAlphaProgress", "", "color", "setBgColor", "setPressColor", "getCurrentPressScaleForAnimation", ce.f26396k, "I", "getBgColorNormal", "()I", "setBgColorNormal", "(I)V", "bgColorNormal", "l", "getBgColorDisabled", "setBgColorDisabled", "bgColorDisabled", "p", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentView", "q", "getContentContainer", "setContentContainer", "contentContainer", "u", "getCurrentTheme", "setCurrentTheme", "currentTheme", BaseSwitches.V, "Z", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "enableMaterial", "", "w", "Ljava/lang/String;", "getMaterialTokenString", "()Ljava/lang/String;", "setMaterialTokenString", "(Ljava/lang/String;)V", "materialTokenString", "x", "getMaterialDisabledTokenString", "setMaterialDisabledTokenString", "materialDisabledTokenString", "", "Lcom/obric/oui/material/c;", "y", "[Lcom/obric/oui/material/c;", "getMaterials", "()[Lcom/obric/oui/material/c;", "setMaterials", "([Lcom/obric/oui/material/c;)V", "materials", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getMaterialApplied", "setMaterialApplied", "materialApplied", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getMaterialsDisabled", "setMaterialsDisabled", "materialsDisabled", "B", "getMaterialSrcType", "setMaterialSrcType", "materialSrcType", "C", "isMaterialFromDrawable", "setMaterialFromDrawable", "isBackdropView", "setBackdropView", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OShadowFrame extends OUIFrameLayout implements g {
    public c[] A;
    public int B;
    public boolean C;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f399141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f399142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f399146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f399147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f399148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OUIFrameLayout f399149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OUIFrameLayout f399150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<q> f399151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<q> f399152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f399153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f399154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f399155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f399156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f399157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c[] f399158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f399159z;

    public static final class a {
    }

    static {
    }

    public OShadowFrame(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public OShadowFrame(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public OShadowFrame(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    public abstract void k(Context r100, OUIFrameLayout r101, TypedArray r102);

    public boolean r() {
        return true;
    }

    public final void setBackdropView(boolean r100) {
    }

    public final void f() {
        d r100 = this.f399141h;
        if (r100 == null) goto L6;
        int r101 = d.f477533d;
        r100.a(false);
    L6:
        d r102 = this.f399142i;
        if (r102 == null) goto L10;
        int r103 = d.f477533d;
        r102.a(false);
    L10:
        this.f399141h = null;
        this.f399142i = null;
    }

    public final OUIFrameLayout getContentContainer() {
        OUIFrameLayout r100 = this.f399150q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r100 = this.f399149p;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public final boolean m() {
        int r100 = this.f399144k;
        if (r100 != 0) goto L7;
        return i.a(this);
    L7:
        if (this.f399154u != 2) goto L9;
    L12:
        return true;
    L9:
        if (h0.b(r100) == true) goto L12;
        return false;
    }

    public float getCurrentPressScaleForAnimation() {
        return getScaleX();
    }

    public final List<q> i() {
        List<q> r100 = getCurrentShadows();
        if (r100 != null) goto L5;
        return null;
    L5:
        List<q> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        r102.add(((q) r103.next()).a());
        goto L7
    L10:
        return r102;
    }

    public final void o() {
        f();
        e(this.f399146m);
        List<q> r100 = this.f399151r;
        q r101 = null;
        if (r100 != null) goto L5;
        q r102 = null;
    L6:
        List<q> r103 = this.f399151r;
        if (r103 == null) goto L10;
        r101 = (q) CollectionsKt.getOrNull(r103, 1);
    L10:
        c(r102, r101, false);
        return;
    L5:
        r102 = (q) CollectionsKt.getOrNull(r100, 0);
        goto L6
    }

    public final int getBgColorDisabled() {
        return this.f399145l;
    }

    public final int getBgColorNormal() {
        return this.f399144k;
    }

    public final int getCurrentTheme() {
        return this.f399154u;
    }

    public final boolean getEnableMaterial() {
        return this.f399155v;
    }

    public final boolean getMaterialApplied() {
        return this.f399159z;
    }

    public final String getMaterialDisabledTokenString() {
        return this.f399157x;
    }

    public final int getMaterialSrcType() {
        return this.B;
    }

    public final String getMaterialTokenString() {
        return this.f399156w;
    }

    public final c[] getMaterials() {
        return this.f399158y;
    }

    public final c[] getMaterialsDisabled() {
        return this.A;
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        this.B = r100;
        p.g(getContentView(), r100);
    }

    public void d(int r100) {
        if (this.f399154u == r100) goto L14;
        this.f399154u = r100;
        String r101 = this.f399156w;
        if (r101 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r101, !m()));
    L8:
        String r102 = this.f399157x;
        if (r102 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r102, !m()));
    L12:
        t(isEnabled());
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = super.dispatchTouchEvent(r100);
        int r102 = r100.getAction();
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L6;
    L8:
        j(false);
    L10:
        return r101;
    L6:
        if (r102 == 3) goto L8;
    L9:
        j(true);
        goto L10
    }

    public void e(float r100) {
        setScaleX(r100);
        setScaleY(r100);
    }

    public final void g(boolean r100) {
        ColorUtils.setAlphaComponent(this.f399144k, 48);
        if (h0.a(this.f399144k) == false) goto L9;
        int r101 = com.obric.oui.material.d.f401462a;
        Function1<Boolean, c[]> r102 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r103 = !r100;
        c[] r104 = com.obric.oui.material.d.a(r102.invoke(Boolean.valueOf(r103)), this.f399144k);
        if (this.f399145l == 0) goto L7;
        c[] r105 = com.obric.oui.material.d.a(r102.invoke(Boolean.valueOf(r103)), this.f399145l);
    L8:
        q(r104, r105);
        return;
    L7:
        r105 = null;
        goto L8
    L9:
        String r106 = this.f399156w;
        if (r106 == null) goto L15;
        boolean r107 = !r100;
        c[] r108 = MaterialToken.parseSet(r106, r107);
        this.f399158y = r108;
        String r109 = this.f399157x;
        if (r109 == null) goto L14;
        this.A = MaterialToken.parseSet(r109, r107);
        return;
    L14:
        this.A = r108;
        return;
    L15:
        Function1<Boolean, c[]> r110 = MaterialToken.OUI_Bg_Floating;
        boolean r111 = !r100;
        q(r110.invoke(Boolean.valueOf(r111)), r110.invoke(Boolean.valueOf(r111)));
    }

    public final void j(boolean r100) {
        if (isEnabled() == true) goto L7;
        b.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L7:
        if (r() == true) goto L10;
        f();
        return;
    L10:
        b.a("OShadowFrame", Intrinsics.stringPlus("doPressAnim: ", Boolean.valueOf(r100)));
        f();
        float r101 = getCurrentPressScaleForAnimation();
        List<q> r102 = i();
        if (r100 == false) goto L13;
        this.f399141h = s(r101, this.f399147n, r102, this.f399152s);
        return;
    L13:
        this.f399142i = s(r101, this.f399146m, r102, this.f399151r);
    }

    public final List<q> n(float r100) {
        List<q> r101 = this.f399151r;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        r102.add(h((q) r103.next(), r100));
        goto L7
    L10:
        return r102;
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        OUIFrameLayout r101 = getContentView();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        OMaterialHelper.t(r101, r100);
    }

    public void setBgColor(int r100) {
        if (this.f399144k == r100) goto L14;
        this.f399144k = r100;
        this.f399145l = r100;
        boolean r101 = h0.b(r100);
        g(r101);
        if (r101 == false) goto L7;
        int r102 = 2;
    L9:
        if (r102 == this.f399154u) goto L12;
        d(r102);
        return;
    L12:
        t(isEnabled());
        return;
    L7:
        r102 = 1;
        goto L9
    }

    public final void setBgColorDisabled(int r100) {
        this.f399145l = r100;
    }

    public final void setBgColorNormal(int r100) {
        this.f399144k = r100;
    }

    public final void setContentContainer(OUIFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f399150q = r100;
    }

    public final void setContentSelfBlur(float r110) {
        OMaterialHelper.r(getContentContainer(), getContentContainer());
        OUIFrameLayout r100 = getContentContainer();
        Context r101 = getContext();
        float[] r102 = com.obric.oui.material.q.f401492a;
        Float r103 = null;
        if (r101 != null) goto L5;
        Resources r104 = null;
    L6:
        if (r104 == null) goto L10;
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        if (r105 == null) goto L10;
        Float r106 = Float.valueOf(r105.density);
    L12:
        if (r106 == null) goto L50;
        float r107 = r106.floatValue();
        boolean r108 = false;
        if (Float.isInfinite(r110) == false) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L50;
        if (r110 < 0.0f) goto L50;
        if (Float.isInfinite(r107) == false) goto L27;
    L29:
        boolean r111 = false;
    L30:
        if (r111 == false) goto L50;
        if (r107 <= 0.0f) goto L50;
        float r112 = r107 * r110;
        if (Float.isInfinite(r112) == false) goto L37;
    L39:
        if (r108 == false) goto L50;
        float[] r113 = com.obric.oui.material.q.f401492a;
        if (r112 < ArraysKt.first(r113)) goto L50;
        if (r112 > ArraysKt.last(r113)) goto L50;
        int r114 = ArraysKt.binarySearch$default(r113, r112, 0, 0, 6, null);
        float[] r115 = com.obric.oui.material.q.f401493b;
        if (r114 < 0) goto L49;
        r103 = Float.valueOf(r115[r114]);
        goto L50
    L49:
        int r116 = (-r114) - 1;
        int r117 = r116 - 1;
        float r118 = r113[r117];
        float r119 = r113[r116];
        float r120 = r115[r117];
        r103 = Float.valueOf(r120 + (((r112 - r118) / (r119 - r118)) * (r115[r116] - r120)));
        goto L50
    L37:
        if (Float.isNaN(r112) == true) goto L39;
        r108 = true;
        goto L39
    L27:
        if (Float.isNaN(r107) == true) goto L29;
        r111 = true;
        goto L30
    L17:
        if (Float.isNaN(r110) == true) goto L19;
        r109 = true;
    L50:
        if (r103 == null) goto L53;
        r110 = r103.floatValue();
    L53:
        OMaterialHelper.o(r100, r110, 1.0f, 0, 0, 1.0f);
        return;
    L10:
        r106 = null;
        goto L12
    L5:
        r104 = r101.getResources();
        goto L6
    }

    public final void setContentShadowAlphaProgress(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.f399153t != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f399153t = r101;
        List<q> r103 = this.f399151r;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r101 < 1.0f) goto L14;
        C1(r103);
        return;
    L14:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = ((ArrayList) r103).iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        r104.add(h((q) r105.next(), r101));
        goto L16
    L18:
        C1(r104);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setContentView(OUIFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f399149p = r100;
    }

    public final void setCurrentTheme(int r100) {
        this.f399154u = r100;
    }

    public final void setEnableMaterial(boolean r100) {
        this.f399155v = r100;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        getContentView().setEnabled(r100);
        getContentContainer().setEnabled(r100);
        t(r100);
    }

    public final void setMaterialApplied(boolean r100) {
        this.f399159z = r100;
    }

    public final void setMaterialDisabledTokenString(String r100) {
        this.f399157x = r100;
    }

    public final void setMaterialFromDrawable(boolean r100) {
        this.C = r100;
    }

    public final void setMaterialSrcType(int r100) {
        this.B = r100;
    }

    public final void setMaterialTokenString(String r100) {
        this.f399156w = r100;
    }

    public final void setMaterials(c[] r100) {
        this.f399158y = r100;
    }

    public final void setMaterialsDisabled(c[] r100) {
        this.A = r100;
    }

    public void setPressColor(int r100) {
        this.f399143j = r100;
        getContentView().setOverridePressColor(this.f399143j);
        getContentView().m1("OShadowFrame");
    }

    public void t(boolean r100) {
        if (this.f399159z == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r100 == false) goto L7;
        getContentView().setBackgroundColor(this.f399144k);
        return;
    L7:
        getContentView().setBackgroundColor(this.f399145l);
        return;
    L9:
        if (this.C == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r100 == false) goto L17;
        c[] r101 = this.f399158y;
        if (r101 == null) goto L25;
        p.d(getContentView(), r101, false, getMaterialSrcType(), 10);
        return;
    L25:
        return;
    L17:
        c[] r102 = this.A;
        if (r102 == null) goto L26;
        p.d(getContentView(), r102, false, getMaterialSrcType(), 10);
        return;
    }

    public static q h(q r100, float r101) {
        q r102 = r100.a();
        r102.f399592a = ColorUtils.setAlphaComponent(r100.f399592a, RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(r100.f399592a) * r101), 0, 255));
        return r102;
    }

    public final void l(Context r100, TypedArray r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "typedArray");
        this.B = r101.getInt(7, 2);
        String r102 = r101.getString(4);
        boolean r103 = h0.a(this.f399144k);
        if (r102 != null) goto L6;
        if (r103 == true) goto L6;
        r102 = getResources().getString(R.string.oui_material_bg_floating);
    L6:
        this.f399156w = r102;
        boolean r104 = m();
        if (r103 == false) goto L12;
        int r105 = com.obric.oui.material.d.f401462a;
        Function1<Boolean, c[]> r106 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r107 = !r104;
        this.f399158y = com.obric.oui.material.d.a(r106.invoke(Boolean.valueOf(r107)), this.f399144k);
        if (this.f399145l == 0) goto L17;
        this.A = com.obric.oui.material.d.a(r106.invoke(Boolean.valueOf(r107)), this.f399145l);
    L17:
        if (this.f399158y != null) goto L20;
        this.f399155v = false;
        this.f399159z = false;
        return;
    L20:
        return;
    L12:
        if (this.f399156w == null) goto L17;
        boolean r108 = !r104;
        this.f399158y = MaterialToken.parseSet(r102, r108);
        String r109 = r101.getString(6);
        this.f399157x = r109;
        if (r109 == null) goto L17;
        this.A = MaterialToken.parseSet(r109, r108);
        goto L17
    }

    public final void q(c[] r100, c[] r101) {
        this.f399158y = r100;
        this.A = r101;
        this.f399156w = null;
        this.f399157x = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OShadowFrame(Context r100, AttributeSet r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111, 8);
        this.f399146m = 1.0f;
        this.f399147n = 1.0f;
        this.f399148o = 0.01f;
        this.f399153t = 1.0f;
        this.B = 2;
        int r101 = 0;
        if (p.b(this) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f399155v = r102;
        this.f399159z = r102;
        TypedArray r113 = r100.obtainStyledAttributes(r110, new int[]{R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorDisabled, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetIcon, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialBackground, R.attr.oui_widgetMaterialDisabled, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetPaddingB, R.attr.oui_widgetPaddingL, R.attr.oui_widgetPaddingR, R.attr.oui_widgetPaddingT, R.attr.oui_widgetPressColor, R.attr.oui_widgetPressScale, R.attr.oui_widgetRadius, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowPressed, R.attr.oui_widgetText, R.attr.oui_widgetTextColor, R.attr.oui_widgetTextStyle, R.attr.oui_widgetTintColor});
        if (this.f399155v == false) goto L11;
        boolean r103 = r113.getBoolean(2, true);
        this.f399155v = r103;
        this.f399159z = r103;
    L11:
        OUIFrameLayout r104 = null;
        int r105 = 14;
        setContentView(new OUIFrameLayout(r100, 0 == true ? 1 : 0, r101, r105));
        setContentContainer(new OUIFrameLayout(r100, 0 == true ? 1 : 0, r101, r105));
        getContentView().setDuplicateParentStateEnabled(true);
        getContentContainer().setDuplicateParentStateEnabled(true);
        this.f399144k = r113.getColor(0, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        this.f399145l = r113.getColor(1, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        if (this.f399144k == 0) goto L14;
        getContentView().setBackgroundColor(this.f399144k);
    L14:
        this.f399147n = r113.getFloat(13, 1.0f);
        setChangeAlphaWhenPress(false);
        int r114 = r113.getDimensionPixelSize(9, 0);
        int r106 = r113.getDimensionPixelSize(10, 0);
        int r107 = r113.getDimensionPixelSize(11, 0);
        int r115 = r113.getDimensionPixelSize(8, 0);
        int r108 = r113.getDimensionPixelSize(14, 0);
        Drawable r109 = r113.getDrawable(5);
        getContentView().setRadius(r108);
        getContentContainer().setPadding(r114, r107, r106, r115);
        getContentContainer().setRadius(r108);
        this.f399143j = r113.getColor(12, 0);
        getContentView().setOverridePressColor(this.f399143j);
        getContentView().m1("OShadowFrame");
        getContentView().addView(getContentContainer(), new FrameLayout.LayoutParams(-1, -1));
        addView(getContentView(), new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r108);
        k(r100, getContentContainer(), r113);
        if (r109 == null) goto L17;
        boolean r116 = true;
    L18:
        this.C = r116;
        if (r116 == false) goto L21;
        getContentView().setBackground(r109);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L21:
        int r117 = vma.c.f556351a;
        OUIFrameLayout r118 = getContentView();
        if (r118 != null) goto L24;
        r118 = null;
    L24:
        if (r118 == null) goto L27;
        r118.setChangeAlphaWhenDisable(false);
    L27:
        OUIFrameLayout r119 = getContentView();
        if (r119 != null) goto L30;
        r119 = null;
    L30:
        if (r119 == null) goto L33;
        r119.setChangeAlphaWhenEnabledChanged(false);
    L33:
        OUIFrameLayout r120 = getContentContainer();
        if (r120 == null) goto L37;
        r104 = r120;
    L37:
        if (r104 == null) goto L40;
        r104.setChangeAlphaWhenDisable(false);
    L40:
        setChangeAlphaWhenDisable(false);
        List<q> r121 = l.b(r100, r113, 15);
        if (r121 == null) goto L43;
        this.f399151r = r121;
        Intrinsics.checkNotNull(r121);
        q r122 = (q) CollectionsKt.getOrNull(r121, 0);
        List<q> r123 = this.f399151r;
        Intrinsics.checkNotNull(r123);
        c(r122, (q) CollectionsKt.getOrNull(r123, 1), false);
    L43:
        List<q> r124 = l.b(r100, r113, 16);
        if (r124 == null) goto L46;
        this.f399152s = r124;
    L46:
        r113.recycle();
        setClipChildren(false);
        setClickable(true);
        t(isEnabled());
        return;
    L17:
        r116 = false;
        goto L18
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        r102 = true;
        goto L8
    }

    public final void p(int r100, int r101, String r102, String r103) {
        this.f399144k = r100;
        this.f399145l = r101;
        int r104 = 1;
        if (r102 == null) goto L16;
        if ((!Intrinsics.areEqual(this.f399156w, r102)) == false) goto L8;
        this.f399156w = r102;
        this.f399158y = MaterialToken.parseSet(r102, !m());
    L8:
        String r105 = this.f399157x;
        if (r105 != null) goto L11;
        boolean r106 = true;
    L13:
        if ((!r106) == false) goto L16;
        this.f399157x = r103;
        this.A = MaterialToken.parseSet(r103, !m());
        goto L16
    L11:
        r106 = StringsKt.contentEquals(r105, r103);
    L16:
        if (h0.b(r100) == false) goto L19;
        r104 = 2;
    L19:
        if (r104 == this.f399154u) goto L22;
        d(r104);
        return;
    L22:
        t(isEnabled());
    }

    public final d s(final float r110, final float r111, final List<q> r112, final List<q> r113) {
        com.obric.common.oea.foundation.animation.builder.d.a r100 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r101 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
        r101.f396390b = this.f399148o;
        Unit r102 = Unit.INSTANCE;
        r100.b(r110, r111, r101, null);
        Function3<String, Object, Object, Unit> r103 = new OShadowFrame$startPressScaleAnimation$2(this, r110, r111, r112, r113);
        Intrinsics.checkNotNullParameter(r103, "callback");
        r100.f396382d = r103;
        Function2<Boolean, Throwable, Unit> r114 = new OShadowFrame$startPressScaleAnimation$3(this, r113);
        Intrinsics.checkNotNullParameter(r114, "callback");
        r100.f396383e = r114;
        return r100.a().a();
    }

    public /* synthetic */ OShadowFrame(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, 0);
    }
}
