package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002:\u0004 (/4J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\rR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00102\u001a\u00020\u001f8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\"\u0010:\u001a\u0002038\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\"\u0010I\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\"\u0010P\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR\"\u0010X\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bU\u0010K\u001a\u0004\bV\u0010M\"\u0004\bW\u0010OR\"\u0010`\u001a\u00020Y8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010h\u001a\u00020a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010l\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010K\u001a\u0004\bj\u0010M\"\u0004\bk\u0010OR\"\u0010p\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bm\u0010K\u001a\u0004\bn\u0010M\"\u0004\bo\u0010OR\"\u0010t\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010K\u001a\u0004\br\u0010M\"\u0004\bs\u0010OR\"\u0010|\u001a\u00020u8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\"\u0010\u007f\u001a\u00020u8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010w\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R&\u0010\u0093\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010K\u001a\u0005\b\u0091\u0001\u0010M\"\u0005\b\u0092\u0001\u0010OR&\u0010\u0097\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010K\u001a\u0005\b\u0095\u0001\u0010M\"\u0005\b\u0096\u0001\u0010OR*\u0010\u009d\u0001\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0005\b\u009c\u0001\u0010\u0016R&\u0010¡\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010K\u001a\u0005\b\u009f\u0001\u0010M\"\u0005\b \u0001\u0010OR*\u0010©\u0001\u001a\u00030¢\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R&\u0010\u00ad\u0001\u001a\u00020u8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010w\u001a\u0005\b«\u0001\u0010y\"\u0005\b¬\u0001\u0010{R&\u0010±\u0001\u001a\u00020u8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010w\u001a\u0005\b¯\u0001\u0010y\"\u0005\b°\u0001\u0010{R&\u0010µ\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010K\u001a\u0005\b³\u0001\u0010M\"\u0005\b´\u0001\u0010OR*\u0010½\u0001\u001a\u00030¶\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R*\u0010Á\u0001\u001a\u00030¶\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010¸\u0001\u001a\u0006\b¿\u0001\u0010º\u0001\"\u0006\bÀ\u0001\u0010¼\u0001R&\u0010Å\u0001\u001a\u00020u8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÂ\u0001\u0010w\u001a\u0005\bÃ\u0001\u0010y\"\u0005\bÄ\u0001\u0010{R\u0017\u0010È\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001¨\u0006É\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "setupView", "setupDimView", "Lcom/obric/oui/sheet/v2/OSheetModal$d;", "listener", "setOnShowAnimListener", "Lcom/obric/oui/sheet/v2/OSheetModal$c;", "setOnDismissAnimListener", "", "enable", "setOverlayModeAutoBodyPaddingTopEnabled", "Lcom/obric/oui/sheet/v2/OSheetModal$b;", "setOnConfigurationListener", "Lcom/obric/oui/sheet/v2/OSheetModal$a;", "setOnCancelListener", "appearanceLight", "setSystemInsetsAppearanceLight", "(Ljava/lang/Boolean;)V", "remove", "setRemoveOnDismiss", "cancelable", "setCancelable", "passThrough", "setPassThroughTouchOutside", "dim", "setClearDimFlag", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldContainer", "c", "getDimView", "setDimView", "dimView", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "d", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootContainer", "e", "Landroid/widget/FrameLayout;", "getHeaderContainer", "()Landroid/widget/FrameLayout;", "setHeaderContainer", "(Landroid/widget/FrameLayout;)V", "headerContainer", "f", "getFooterContainer", "setFooterContainer", "footerContainer", ce.f26391f, "getBodyContainer", "setBodyContainer", "bodyContainer", "h", "Z", "getMClearDimFlag", "()Z", "setMClearDimFlag", "(Z)V", "mClearDimFlag", RXScreenCaptureService.KEY_INDEX, "getEnableDimAnim", "setEnableDimAnim", "enableDimAnim", ce.f26395j, "getEnableEnterAnim", "setEnableEnterAnim", "enableEnterAnim", "Lcom/obric/oui/sheet/v2/i;", ce.f26396k, "Lcom/obric/oui/sheet/v2/i;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/i;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/i;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "l", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "heightStyle", "m", "q", "setContentOverlayMode", "isContentOverlayMode", OfficeSDKRequestTag.KEY_NEW_USER, "getIgnoreInsetBottom", "setIgnoreInsetBottom", "ignoreInsetBottom", "o", "getMCancelable", "setMCancelable", "mCancelable", "", "p", "I", "getUserWindowWidth", "()I", "setUserWindowWidth", "(I)V", "userWindowWidth", "getUserWindowHeight", "setUserWindowHeight", "userWindowHeight", "Landroid/util/Size;", "r", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "fullWindowSize", "Lfja/d;", "s", "Lfja/d;", "getRunningAnim", "()Lfja/d;", "setRunningAnim", "(Lfja/d;)V", "runningAnim", "t", "getShowing", "setShowing", "showing", "u", "getEnableMaterial", "setEnableMaterial", "enableMaterial", BaseSwitches.V, "Ljava/lang/Boolean;", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "systemInsetsAppearanceLightValue", "x", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationCallbackRegistered", "Landroid/content/ComponentCallbacks;", "y", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallback", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getBodyContentPaddingTop", "setBodyContentPaddingTop", "bodyContentPaddingTop", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingBottom", "B", "getAutoAddBodyPaddingTopWhenOverlay", "setAutoAddBodyPaddingTopWhenOverlay", "autoAddBodyPaddingTopWhenOverlay", "", "C", FaceService.girlLabel, "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartX", "D", "getRootTransMoveStartY", "setRootTransMoveStartY", "rootTransMoveStartY", ExifInterface.LONGITUDE_EAST, "getBgColor", "setBgColor", "bgColor", "getSheetContext", "()Landroid/content/Context;", "sheetContext", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSheetModal extends FrameLayout implements OSheetBase {
    public static final /* synthetic */ int F = 0;
    public int A;
    public boolean B;
    public float C;
    public float D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f402905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f402906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f402907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadiusLayout f402908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f402909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f402910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f402911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f402912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f402913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f402914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f402915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OSheet.HeightMode f402916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f402917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f402919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f402920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f402921q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Size f402922r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public fja.d f402923s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f402924t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f402925u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f402926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f402927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f402928x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ComponentCallbacks f402929y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f402930z;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public OSheetModal(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 30);
    }

    public OSheetModal(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public OSheetModal(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final Window d() {
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void e() {
        setShowing(false);
        setVisibility(8);
        Context r100 = getContext();
        ViewGroup r101 = null;
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r100;
    L6:
        if (r102 != null) goto L8;
        Window r103 = null;
    L9:
        if (r103 == null) goto L12;
        int r104 = Build.VERSION.SDK_INT;
    L12:
        t();
        if (this.f402927w == false) goto L21;
        ViewParent r105 = getParent();
        if ((r105 instanceof ViewGroup) == false) goto L17;
        r101 = (ViewGroup) r105;
    L17:
        if (r101 == null) goto L22;
        r101.removeView(this);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r103 = r102.getWindow();
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void g() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean h() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void k() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void l() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void o() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void s() {
        OSheetBase.DefaultImpls.a(this, false);
        RadiusLayout r100 = getRootContainer();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OMaterialHelper.t(r100, this);
    }

    public final void setOnCancelListener(a r100) {
    }

    public final void setOnConfigurationListener(b r100) {
    }

    public final void setOnDismissAnimListener(c r100) {
    }

    public final void setOnShowAnimListener(d r100) {
    }

    public final void setPassThroughTouchOutside(boolean r100) {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getBodyContainer() {
        FrameLayout r100 = this.f402911g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    public final View getContentView() {
        View r100 = this.f402905a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getDimView() {
        View r100 = this.f402907c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getFooterContainer() {
        FrameLayout r100 = this.f402910f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getHeaderContainer() {
        FrameLayout r100 = this.f402909e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public RadiusLayout getRootContainer() {
        RadiusLayout r100 = this.f402908d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ViewGroup getScaffoldContainer() {
        ViewGroup r100 = this.f402906b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public i getScaffoldController() {
        i r100 = this.f402915k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    public final void t() {
        Activity r100 = zma.a.f572881a.getActivity(getContext());
        if (r100 == null) goto L7;
        r100.getWindow().getCallback();
        return;
    }

    public int getContentLayoutResId() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (q() == false) goto L5;
        return R.layout.o_sheet_container_overlay;
    L5:
        return R.layout.o_sheet_container;
    }

    public View getEndActionButton() {
        return OSheetBase.DefaultImpls.d(this);
    }

    public OSheetTitleBar getHeaderTitleBar() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getScaffoldController().f402982n;
    }

    public int getMaxBodyHeight() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getScaffoldController().f402978j;
    }

    public View getNegativeButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getFooterContainer().findViewById(R.id.btn_negative);
    }

    public View getPositiveButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getFooterContainer().findViewById(R.id.btn_positive);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Context getSheetContext() {
        return getContext();
    }

    public View getStartActionButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        View r100 = getHeaderContainer().findViewById(R.id.btn_start_action);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return getHeaderContainer().findViewById(R.id.left_action_back);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean i() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == true) goto L7;
        getSheetContext().registerComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(true);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == false) goto L6;
        getSheetContext().unregisterComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(false);
    L6:
        super.onDetachedFromWindow();
        t();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean r() {
        return OSheetBase.DefaultImpls.f(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void a() {
        OSheetBase.DefaultImpls.h(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void b() {
        OSheetBase.DefaultImpls.e(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void f() {
        OSheetBase.DefaultImpls.t(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.B;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBgColor() {
        return this.E;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingBottom() {
        return this.A;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingTop() {
        return this.f402930z;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ComponentCallbacks getConfigurationCallback() {
        return this.f402929y;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getConfigurationCallbackRegistered() {
        return this.f402928x;
    }

    public boolean getEnableDimAnim() {
        return this.f402913i;
    }

    public boolean getEnableEnterAnim() {
        return this.f402914j;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableMaterial() {
        return this.f402925u;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Size getFullWindowSize() {
        return this.f402922r;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheet.HeightMode getHeightStyle() {
        return this.f402916l;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getIgnoreInsetBottom() {
        return this.f402918n;
    }

    public boolean getMCancelable() {
        return this.f402919o;
    }

    public boolean getMClearDimFlag() {
        return this.f402912h;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartX() {
        return this.C;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartY() {
        return this.D;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public fja.d getRunningAnim() {
        return this.f402923s;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getShowing() {
        return this.f402924t;
    }

    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.f402926v;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowHeight() {
        return this.f402921q;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowWidth() {
        return this.f402920p;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void m() {
        OSheetBase.DefaultImpls.b(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean q() {
        return this.f402917m;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final <T extends View> T c(int r100) {
        return (T) getContentView().findViewById(r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void j(float r100) {
        OSheetBase.DefaultImpls.i(this, r100);
    }

    @Override // com.obric.oui.sheet.v2.k
    public final void p(float r100) {
        OSheetBase.DefaultImpls.c(this, r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r100) {
        this.B = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBgColor(int r100) {
        this.E = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402911g = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingBottom(int r100) {
        this.A = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingTop(int r100) {
        this.f402930z = r100;
    }

    public void setBodyView(View r100) {
        OSheetBase.DefaultImpls.j(this, r100);
    }

    public final void setCancelable(boolean r100) {
        setMCancelable(r100);
    }

    public void setCanceledOnTouchOutside(boolean r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        setMCancelable(r100);
    }

    public final void setClearDimFlag(boolean r100) {
        setMClearDimFlag(r100);
    }

    public void setConfigurationCallback(ComponentCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402929y = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallbackRegistered(boolean r100) {
        this.f402928x = r100;
    }

    public void setContentOverlayMode(boolean r100) {
        this.f402917m = r100;
    }

    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402905a = r100;
    }

    public void setDimView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402907c = r100;
    }

    public void setEnableDimAnim(boolean r100) {
        this.f402913i = r100;
    }

    public void setEnableEnterAnim(boolean r100) {
        this.f402914j = r100;
    }

    public void setEnableMaterial(boolean r100) {
        this.f402925u = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402910f = r100;
    }

    public void setFooterView(View r100) {
        OSheetBase.DefaultImpls.m(this, r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFullWindowSize(Size r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402922r = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402909e = r100;
    }

    public void setHeaderView(View r100) {
        OSheetBase.DefaultImpls.p(this, r100);
    }

    public void setHeightMode(OSheet.HeightMode r100) {
        OSheetBase.DefaultImpls.q(this, r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightStyle(OSheet.HeightMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402916l = r100;
    }

    public void setIgnoreInsetBottom(boolean r100) {
        this.f402918n = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMCancelable(boolean r100) {
        this.f402919o = r100;
    }

    public void setMClearDimFlag(boolean r100) {
        this.f402912h = r100;
    }

    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getAutoAddBodyPaddingTopWhenOverlay() == r100) goto L8;
        setAutoAddBodyPaddingTopWhenOverlay(r100);
        if (getShowing() == false) goto L9;
        a();
        return;
    L9:
        return;
    }

    public final void setRemoveOnDismiss(boolean r100) {
        this.f402927w = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootContainer(RadiusLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402908d = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartX(float r100) {
        this.C = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartY(float r100) {
        this.D = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRunningAnim(fja.d r100) {
        this.f402923s = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402906b = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldController(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402915k = r100;
    }

    public void setSheetBgColor(int r100) {
        OSheetBase.DefaultImpls.r(this, r100);
    }

    public void setShowing(boolean r100) {
        this.f402924t = r100;
    }

    public final void setSystemInsetsAppearanceLight(Boolean r100) {
        setSystemInsetsAppearanceLightValue(r100);
    }

    public void setSystemInsetsAppearanceLightValue(Boolean r100) {
        this.f402926v = r100;
    }

    public void setUserWindowHeight(int r100) {
        this.f402921q = r100;
    }

    public void setUserWindowWidth(int r100) {
        this.f402920p = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupDimView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setDimView(new View(r100));
        addView(getDimView(), 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OSheetBase.DefaultImpls.s(this, r100);
        s();
    }

    @Override // com.obric.oui.sheet.v2.k
    public final void n(float r100, float r101, boolean r102) {
        OSheetBase.DefaultImpls.g(this, r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetModal(Context r100, AttributeSet r101, int r102, int r103) {
        LifecycleOwner r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        boolean r105 = true;
        if ((r103 & 16) == 0) goto L11;
        boolean r106 = true;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402913i = true;
        this.f402914j = true;
        this.f402916l = OSheet.HeightMode.WRAP_HEIGHT;
        this.f402917m = false;
        this.f402919o = true;
        this.f402922r = new Size(0, 0);
        this.f402927w = true;
        this.f402929y = new g(this);
        this.B = true;
        this.E = -1;
        if (r106 == false) goto L21;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OMaterialHelper.j(r100) == true) goto L17;
    L19:
        r105 = false;
    L20:
        setEnableMaterial(r105);
        goto L21
    L17:
        if (OMaterialHelper.l() == false) goto L19;
    L21:
        setVisibility(8);
        setContentView(LayoutInflater.from(r100).inflate(getContentLayoutResId(), this, false));
        View r107 = getContentView();
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, -2);
        r108.gravity = 80;
        Unit r109 = Unit.INSTANCE;
        addView(r107, r108);
        setupView(r100);
        if ((r100 instanceof LifecycleOwner) == false) goto L24;
        r104 = (LifecycleOwner) r100;
    L24:
        if (r104 == null) goto L31;
        Lifecycle r110 = r104.getLifecycle();
        if (r110 == null) goto L32;
        r110.addObserver(new AnonymousClass2(this));
        return;
    L32:
        return;
    L31:
        return;
    L11:
        r106 = false;
        goto L12
    }
}
