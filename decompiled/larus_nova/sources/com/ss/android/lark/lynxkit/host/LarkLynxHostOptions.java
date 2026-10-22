package com.ss.android.lark.lynxkit.host;

import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\t\u0010A\u001a\u00020\u0017HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J«\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0013HÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0013HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.¨\u0006K"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostOptions;", "", "renderOnCreateView", "", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "imageInterceptor", "Lcom/lynx/tasm/behavior/ImageInterceptor;", "templateLoadListener", "Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;", "lifecycleCallback", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;", "closeCallback", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;", "backPressedHandler", "Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;", "pageSystemBarOptions", "Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "dialogWidth", "", "dialogHeight", "dialogGravity", "dialogDimAmount", "", "dialogCancelable", "dialogCanceledOnTouchOutside", "softInputMode", "<init>", "(ZLcom/lynx/tasm/LynxViewClient;Lcom/lynx/tasm/behavior/ImageInterceptor;Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;IIIFZZI)V", "getRenderOnCreateView", "()Z", "getLynxViewClient", "()Lcom/lynx/tasm/LynxViewClient;", "getImageInterceptor", "()Lcom/lynx/tasm/behavior/ImageInterceptor;", "getTemplateLoadListener", "()Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;", "getLifecycleCallback", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;", "getCloseCallback", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;", "getBackPressedHandler", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;", "getPageSystemBarOptions", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "getDialogWidth", "()I", "getDialogHeight", "getDialogGravity", "getDialogDimAmount", "()F", "getDialogCancelable", "getDialogCanceledOnTouchOutside", "getSoftInputMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxHostOptions {
    private final LarkLynxBackPressedHandler backPressedHandler;
    private final LarkLynxHostCloseCallback closeCallback;
    private final boolean dialogCancelable;
    private final boolean dialogCanceledOnTouchOutside;
    private final float dialogDimAmount;
    private final int dialogGravity;
    private final int dialogHeight;
    private final int dialogWidth;
    private final m imageInterceptor;
    private final LarkLynxHostLifecycleCallback lifecycleCallback;
    private final q1 lynxViewClient;
    private final LarkLynxSystemBarOptions pageSystemBarOptions;
    private final boolean renderOnCreateView;
    private final int softInputMode;
    private final sqb.a templateLoadListener;

    public LarkLynxHostOptions() {
        this(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    }

    public static /* synthetic */ LarkLynxHostOptions copy$default(LarkLynxHostOptions r110, boolean r111, q1 r112, m r113, sqb.a r210, LarkLynxHostLifecycleCallback r211, LarkLynxHostCloseCallback r212, LarkLynxBackPressedHandler r213, LarkLynxSystemBarOptions r214, int r215, int r216, int r217, float r218, boolean r219, boolean r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        boolean r100 = r110.renderOnCreateView;
    L7:
        if ((r312 & 2) == 0) goto L9;
        q1 r101 = r110.lynxViewClient;
    L11:
        if ((r312 & 4) == 0) goto L13;
        m r102 = r110.imageInterceptor;
    L15:
        if ((r312 & 8) == 0) goto L17;
        sqb.a r103 = r110.templateLoadListener;
    L19:
        if ((r312 & 16) == 0) goto L21;
        LarkLynxHostLifecycleCallback r104 = r110.lifecycleCallback;
    L23:
        if ((r312 & 32) == 0) goto L25;
        LarkLynxHostCloseCallback r105 = r110.closeCallback;
    L27:
        if ((r312 & 64) == 0) goto L29;
        LarkLynxBackPressedHandler r106 = r110.backPressedHandler;
    L31:
        if ((r312 & 128) == 0) goto L33;
        LarkLynxSystemBarOptions r107 = r110.pageSystemBarOptions;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r114 = r110.dialogWidth;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r115 = r110.dialogHeight;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r116 = r110.dialogGravity;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        float r117 = r110.dialogDimAmount;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        boolean r118 = r110.dialogCancelable;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.dialogCanceledOnTouchOutside;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        int r108 = r110.softInputMode;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final boolean component1() {
        return this.renderOnCreateView;
    }

    public final int component10() {
        return this.dialogHeight;
    }

    public final int component11() {
        return this.dialogGravity;
    }

    public final float component12() {
        return this.dialogDimAmount;
    }

    public final boolean component13() {
        return this.dialogCancelable;
    }

    public final boolean component14() {
        return this.dialogCanceledOnTouchOutside;
    }

    public final int component15() {
        return this.softInputMode;
    }

    public final q1 component2() {
        return this.lynxViewClient;
    }

    public final m component3() {
        return this.imageInterceptor;
    }

    public final sqb.a component4() {
        return this.templateLoadListener;
    }

    public final LarkLynxHostLifecycleCallback component5() {
        return this.lifecycleCallback;
    }

    public final LarkLynxHostCloseCallback component6() {
        return this.closeCallback;
    }

    public final LarkLynxBackPressedHandler component7() {
        return this.backPressedHandler;
    }

    public final LarkLynxSystemBarOptions component8() {
        return this.pageSystemBarOptions;
    }

    public final int component9() {
        return this.dialogWidth;
    }

    public final LarkLynxHostOptions copy(boolean r110, q1 r111, m r210, sqb.a r211, LarkLynxHostLifecycleCallback r212, LarkLynxHostCloseCallback r213, LarkLynxBackPressedHandler r214, LarkLynxSystemBarOptions r215, int r216, int r217, int r218, float r219, boolean r310, boolean r311, int r312) {
        Intrinsics.checkNotNullParameter(r215, "pageSystemBarOptions");
        return new LarkLynxHostOptions(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkLynxHostOptions) == true) goto L8;
        return false;
    L8:
        LarkLynxHostOptions r101 = (LarkLynxHostOptions) r100;
        if (this.renderOnCreateView == r101.renderOnCreateView) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxViewClient, r101.lynxViewClient) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageInterceptor, r101.imageInterceptor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateLoadListener, r101.templateLoadListener) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifecycleCallback, r101.lifecycleCallback) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.closeCallback, r101.closeCallback) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backPressedHandler, r101.backPressedHandler) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageSystemBarOptions, r101.pageSystemBarOptions) == true) goto L33;
        return false;
    L33:
        if (this.dialogWidth == r101.dialogWidth) goto L36;
        return false;
    L36:
        if (this.dialogHeight == r101.dialogHeight) goto L39;
        return false;
    L39:
        if (this.dialogGravity == r101.dialogGravity) goto L42;
        return false;
    L42:
        if (Float.compare(this.dialogDimAmount, r101.dialogDimAmount) == 0) goto L45;
        return false;
    L45:
        if (this.dialogCancelable == r101.dialogCancelable) goto L48;
        return false;
    L48:
        if (this.dialogCanceledOnTouchOutside == r101.dialogCanceledOnTouchOutside) goto L51;
        return false;
    L51:
        if (this.softInputMode == r101.softInputMode) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.renderOnCreateView == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        q1 r103 = this.lynxViewClient;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        m r107 = this.imageInterceptor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        sqb.a r110 = this.templateLoadListener;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        LarkLynxHostLifecycleCallback r113 = this.lifecycleCallback;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        LarkLynxHostCloseCallback r116 = this.closeCallback;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        LarkLynxBackPressedHandler r119 = this.backPressedHandler;
        if (r119 == null) goto L30;
        r104 = r119.hashCode();
    L30:
        int r120 = (((((((((((r118 + r104) * 31) + this.pageSystemBarOptions.hashCode()) * 31) + this.dialogWidth) * 31) + this.dialogHeight) * 31) + this.dialogGravity) * 31) + Float.floatToIntBits(this.dialogDimAmount)) * 31;
        if (this.dialogCancelable == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.dialogCanceledOnTouchOutside == true) goto L39;
        r100 = 1237;
    L39:
        return ((r122 + r100) * 31) + this.softInputMode;
    L33:
        r121 = 1237;
        goto L34
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "LarkLynxHostOptions(renderOnCreateView=" + this.renderOnCreateView + ", lynxViewClient=" + this.lynxViewClient + ", imageInterceptor=" + this.imageInterceptor + ", templateLoadListener=" + this.templateLoadListener + ", lifecycleCallback=" + this.lifecycleCallback + ", closeCallback=" + this.closeCallback + ", backPressedHandler=" + this.backPressedHandler + ", pageSystemBarOptions=" + this.pageSystemBarOptions + ", dialogWidth=" + this.dialogWidth + ", dialogHeight=" + this.dialogHeight + ", dialogGravity=" + this.dialogGravity + ", dialogDimAmount=" + this.dialogDimAmount + ", dialogCancelable=" + this.dialogCancelable + ", dialogCanceledOnTouchOutside=" + this.dialogCanceledOnTouchOutside + ", softInputMode=" + this.softInputMode + ')';
    }

    public final LarkLynxBackPressedHandler getBackPressedHandler() {
        return this.backPressedHandler;
    }

    public final LarkLynxHostCloseCallback getCloseCallback() {
        return this.closeCallback;
    }

    public final boolean getDialogCancelable() {
        return this.dialogCancelable;
    }

    public final boolean getDialogCanceledOnTouchOutside() {
        return this.dialogCanceledOnTouchOutside;
    }

    public final float getDialogDimAmount() {
        return this.dialogDimAmount;
    }

    public final int getDialogGravity() {
        return this.dialogGravity;
    }

    public final int getDialogHeight() {
        return this.dialogHeight;
    }

    public final int getDialogWidth() {
        return this.dialogWidth;
    }

    public final m getImageInterceptor() {
        return this.imageInterceptor;
    }

    public final LarkLynxHostLifecycleCallback getLifecycleCallback() {
        return this.lifecycleCallback;
    }

    public final q1 getLynxViewClient() {
        return this.lynxViewClient;
    }

    public final LarkLynxSystemBarOptions getPageSystemBarOptions() {
        return this.pageSystemBarOptions;
    }

    public final boolean getRenderOnCreateView() {
        return this.renderOnCreateView;
    }

    public final int getSoftInputMode() {
        return this.softInputMode;
    }

    public final sqb.a getTemplateLoadListener() {
        return this.templateLoadListener;
    }

    public LarkLynxHostOptions(boolean r100, q1 r101, m r102, sqb.a r103, LarkLynxHostLifecycleCallback r104, LarkLynxHostCloseCallback r105, LarkLynxBackPressedHandler r110, LarkLynxSystemBarOptions r111, int r112, int r113, int r114, float r115, boolean r116, boolean r117, int r118) {
        Intrinsics.checkNotNullParameter(r111, "pageSystemBarOptions");
        this.renderOnCreateView = r100;
        this.lynxViewClient = r101;
        this.imageInterceptor = r102;
        this.templateLoadListener = r103;
        this.lifecycleCallback = r104;
        this.closeCallback = r105;
        this.backPressedHandler = r110;
        this.pageSystemBarOptions = r111;
        this.dialogWidth = r112;
        this.dialogHeight = r113;
        this.dialogGravity = r114;
        this.dialogDimAmount = r115;
        this.dialogCancelable = r116;
        this.dialogCanceledOnTouchOutside = r117;
        this.softInputMode = r118;
    }

    public /* synthetic */ LarkLynxHostOptions(boolean r210, q1 r211, m r212, sqb.a r213, LarkLynxHostLifecycleCallback r214, LarkLynxHostCloseCallback r215, LarkLynxBackPressedHandler r216, LarkLynxSystemBarOptions r217, int r310, int r311, int r312, float r313, boolean r314, boolean r315, int r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 1) == 0) goto L5;
        boolean r100 = false;
    L6:
        LarkLynxBackPressedHandler r101 = null;
        if ((r317 & 2) == 0) goto L9;
        q1 r102 = null;
    L11:
        if ((r317 & 4) == 0) goto L13;
        m r103 = null;
    L15:
        if ((r317 & 8) == 0) goto L17;
        sqb.a r104 = null;
    L19:
        if ((r317 & 16) == 0) goto L21;
        LarkLynxHostLifecycleCallback r105 = null;
    L23:
        if ((r317 & 32) == 0) goto L25;
        LarkLynxHostCloseCallback r106 = null;
    L27:
        if ((r317 & 64) != 0) goto L31;
        r101 = r216;
    L31:
        if ((r317 & 128) == 0) goto L33;
        LarkLynxSystemBarOptions r107 = new LarkLynxSystemBarOptions(null, false, false, null, false, null, false, null, false, 511, null);
    L34:
        int r110 = -1;
        if ((r317 & 256) == 0) goto L37;
        int r108 = -1;
    L39:
        if ((r317 & 512) != 0) goto L43;
        r110 = r311;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        int r111 = 80;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        float r112 = 0.5f;
    L50:
        boolean r113 = true;
        if ((r317 & 4096) == 0) goto L53;
        boolean r114 = true;
    L55:
        if ((r317 & 8192) != 0) goto L59;
        r113 = r315;
    L59:
        if ((r317 & 16384) == 0) goto L61;
        int r109 = 18;
    L62:
        this(r100, r102, r103, r104, r105, r106, r101, r107, r108, r110, r111, r112, r114, r113, r109);
        return;
    L61:
        r109 = r316;
        goto L62
    L53:
        r114 = r314;
        goto L55
    L49:
        r112 = r313;
        goto L50
    L45:
        r111 = r312;
        goto L47
    L37:
        r108 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L34
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
