package com.bytedance.sdk.xbridge.cn.ui;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.container.util.b;
import com.bytedance.android.anniex.container.util.j;
import com.bytedance.android.anniex.lite.utils.c;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.utils.k;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ia.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.configureStatusBar")
public final class XConfigureStatusBarMethod extends a {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XConfigureStatusBarMethod$StatusBarStyle;", "", "", "style", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DARK", "LIGHT", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum StatusBarStyle extends Enum<StatusBarStyle> {
        public static final a Companion = null;
        public static final StatusBarStyle DARK = null;
        public static final StatusBarStyle LIGHT = null;
        public static final StatusBarStyle UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StatusBarStyle[] f270244a = null;
        private final String style;

        public static final class a {
            public a() {
            }

            public static StatusBarStyle a(String r100) {
                return StatusBarStyle.valueOf(r100.toUpperCase());
            L5:
                return StatusBarStyle.UNKNOWN;
            }
        }

        public static StatusBarStyle valueOf(String r100) {
            return (StatusBarStyle) r27.a.a(StatusBarStyle.class, r100);
        }

        public static StatusBarStyle[] values() {
            return (StatusBarStyle[]) f270244a.clone();
        }

        static {
            StatusBarStyle r100 = new StatusBarStyle("DARK", 0, "dark");
            DARK = r100;
            StatusBarStyle r101 = new StatusBarStyle("LIGHT", 1, "light");
            LIGHT = r101;
            StatusBarStyle r102 = new StatusBarStyle("UNKNOWN", 2, null);
            UNKNOWN = r102;
            f270244a = new StatusBarStyle[]{r100, r101, r102};
            Companion = new a();
        }

        public final String getStyle() {
            return this.style;
        }

        public StatusBarStyle(String r100, int r101, String r102) {
            super(r100, r101);
            this.style = r102;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public XConfigureStatusBarMethod() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        a.b r100 = (a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Activity r102 = k.f270262a.getActivity(r101);
        String r103 = r100.getStyle();
        Boolean r104 = r100.getVisible();
        DialogFragment r105 = c.g(r110);
        boolean r106 = false;
        if (r105 == null) goto L54;
        if (r103 != null) goto L135;
    L32:
        if (r104 != null) goto L34;
    L46:
        String r107 = r100.getBackgroundColor();     // Catch: Exception -> L30
        Dialog r108 = r105.getDialog();     // Catch: Exception -> L30
        if (r108 == null) goto L53;
        Window r109 = r108.getWindow();     // Catch: Exception -> L30
        if (r109 == null) goto L53;
        com.bytedance.sdk.xbridge.cn.ui.utils.a.g(r109, r101, r107);     // Catch: Exception -> L30
    L53:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L34:
        if (r104.booleanValue() == false) goto L41;
        int r113 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;     // Catch: Exception -> L30
        Dialog r114 = r105.getDialog();     // Catch: Exception -> L30
        if (r114 == null) goto L38;
        Window r115 = r114.getWindow();     // Catch: Exception -> L30
    L39:
        if (r115 == null) goto L46;
        r115.clearFlags(1024);     // Catch: Exception -> L30
        goto L46
    L38:
        r115 = null;
        goto L39
    L41:
        Dialog r116 = r105.getDialog();     // Catch: Exception -> L30
        if (r116 == null) goto L46;
        Window r117 = r116.getWindow();     // Catch: Exception -> L30
        if (r117 == null) goto L46;
        int r118 = j.f40627a;     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r117, LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L30
        r117.setFlags(1024, 1024);     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r117, LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L30
        r117.setStatusBarColor(r117.getContext().getResources().getColor(R.color.transparent));     // Catch: Exception -> L30
        goto L46
    L135:
        StatusBarStyle.Companion.getClass();     // Catch: Exception -> L30
        StatusBarStyle r119 = StatusBarStyle.a.a(r103);     // Catch: Exception -> L30
        if (r119 != StatusBarStyle.UNKNOWN) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "StatusBar style can only be dark or light", null, 4, null);     // Catch: Exception -> L30
        return;
    L11:
        id7.c.a("handle: style = ".concat(r103));     // Catch: Exception -> L30
        Dialog r120 = r105.getDialog();     // Catch: Exception -> L30
        if (r120 == null) goto L14;
        Window r121 = r120.getWindow();     // Catch: Exception -> L30
    L15:
        int r122 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;     // Catch: Exception -> L30
        if (r119 != StatusBarStyle.DARK) goto L18;
        r106 = true;
    L18:
        if (r121 == null) goto L32;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L32
    L21:
        if (Build.VERSION.SDK_INT < 23) goto L32;
        View r123 = com.bytedance.sdk.xbridge.cn.ui.utils.a.a(r121);     // Catch: Exception -> L28
        int r124 = r123.getSystemUiVisibility();     // Catch: Exception -> L28
        if (r106 == true) goto L25;
        r123.setSystemUiVisibility(r124 & (-8193));     // Catch: Exception -> L28
    L26:
        r121.clearFlags(67108864);     // Catch: Exception -> L28
        r121.addFlags(Integer.MIN_VALUE);     // Catch: Exception -> L28
    L25:
        r123.setSystemUiVisibility(r124 | 8192);     // Catch: Exception -> L28
        goto L26
    L14:
        r121 = null;
    L30:
        e = move-exception;
        id7.c.a("handle: " + e.getMessage());
        goto L53
    L54:
        ia.c r125 = b.a(r110);
        if (r125 == null) goto L83;
        String r126 = r100.getBackgroundColor();
        if (r126 != null) goto L59;
    L66:
        if (r103 == null) goto L71;
        StatusBarStyle.Companion.getClass();
        if (StatusBarStyle.a.a(r103) != StatusBarStyle.UNKNOWN) goto L70;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "StatusBar style can only be dark or light", null, 4, null);
        return;
    L70:
        ((g) r125).setStatusFontMode(r103);
    L71:
        if (r104 == null) goto L82;
        boolean r127 = r104.booleanValue();
        if ((r125 instanceof ua.c) == false) goto L75;
        ((ua.c) r125).f549231f.q(!r127);
        goto L82
    L75:
        if (r127 == false) goto L81;
        int r128 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;
        if (r102 == null) goto L82;
        Window r129 = r102.getWindow();
        if (r129 == null) goto L82;
        r129.clearFlags(1024);
        goto L82
    L81:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.d(r102);
    L82:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L59:
        if ((r125 instanceof ua.c) == false) goto L61;
        ((ua.c) r125).c(r126);
        goto L66
    L61:
        int r130 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;
        if (r102 == null) goto L64;
        Window r131 = r102.getWindow();
    L65:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.g(r131, r101, r126);
        goto L66
    L64:
        r131 = null;
        goto L65
    L83:
        ia.c r132 = b.b(r110);
        if (r132 == null) goto L107;
        String r133 = r100.getBackgroundColor();
        if (r133 == null) goto L92;
        int r134 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;
        if (r102 == null) goto L90;
        Window r135 = r102.getWindow();
    L91:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.g(r135, r101, r133);
        goto L92
    L90:
        r135 = null;
    L92:
        if (r103 == null) goto L97;
        StatusBarStyle.Companion.getClass();
        if (StatusBarStyle.a.a(r103) != StatusBarStyle.UNKNOWN) goto L96;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "StatusBar style can only be dark or light", null, 4, null);
        return;
    L96:
        ((g) r132).setStatusFontMode(r103);
    L97:
        if (r104 != null) goto L99;
    L106:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L99:
        if (r104.booleanValue() == false) goto L105;
        int r136 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;
        if (r102 == null) goto L106;
        Window r137 = r102.getWindow();
        if (r137 == null) goto L106;
        r137.clearFlags(1024);
        goto L106
    L105:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.d(r102);
        goto L106
    L107:
        if (r103 != null) goto L138;
    L121:
        if (r104 != null) goto L123;
    L130:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.f(r102, r100.getBackgroundColor());     // Catch: Exception -> L119
    L133:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L123:
        if (r104.booleanValue() == false) goto L129;
        int r138 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;     // Catch: Exception -> L119
        if (r102 == null) goto L130;
        Window r139 = r102.getWindow();     // Catch: Exception -> L119
        if (r139 == null) goto L130;
        r139.clearFlags(1024);     // Catch: Exception -> L119
        goto L130
    L129:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.d(r102);     // Catch: Exception -> L119
        goto L130
    L138:
        StatusBarStyle.Companion.getClass();     // Catch: Exception -> L119
        StatusBarStyle r140 = StatusBarStyle.a.a(r103);     // Catch: Exception -> L119
        if (r140 != StatusBarStyle.UNKNOWN) goto L111;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "StatusBar style can only be dark or light", null, 4, null);     // Catch: Exception -> L119
        return;
    L111:
        id7.c.a("handle: style = ".concat(r103));     // Catch: Exception -> L119
        if (r102 == null) goto L114;
        Window r141 = r102.getWindow();     // Catch: Exception -> L119
    L115:
        int r142 = com.bytedance.sdk.xbridge.cn.ui.utils.a.f270249a;     // Catch: Exception -> L119
        if (r140 != StatusBarStyle.DARK) goto L118;
        r106 = true;
    L118:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.i(r102, r141, r106);     // Catch: Exception -> L119
        goto L121
    L114:
        r141 = null;
    L119:
        e = move-exception;
        id7.c.a("handle: " + e.getMessage());
        goto L133
    }
}
