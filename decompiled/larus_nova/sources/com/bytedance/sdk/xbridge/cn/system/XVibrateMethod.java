package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.vibrate")
public final class XVibrateMethod extends ye7.e {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XVibrateMethod$VibrationStyle;", "", "", "amplitude", "I", "getAmplitude", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LIGHT", "MEDIUM", "HEAVY", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum VibrationStyle extends Enum<VibrationStyle> {
        public static final a Companion = null;
        public static final VibrationStyle HEAVY = null;
        public static final VibrationStyle LIGHT = null;
        public static final VibrationStyle MEDIUM = null;
        public static final VibrationStyle UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VibrationStyle[] f270170a = null;
        private final int amplitude;

        public static final class a {
            public a() {
            }
        }

        public static VibrationStyle valueOf(String r100) {
            return (VibrationStyle) r27.a.a(VibrationStyle.class, r100);
        }

        public static VibrationStyle[] values() {
            return (VibrationStyle[]) f270170a.clone();
        }

        static {
            VibrationStyle r100 = new VibrationStyle("LIGHT", 0, 50);
            LIGHT = r100;
            VibrationStyle r101 = new VibrationStyle("MEDIUM", 1, 125);
            MEDIUM = r101;
            VibrationStyle r102 = new VibrationStyle("HEAVY", 2, 255);
            HEAVY = r102;
            VibrationStyle r103 = new VibrationStyle("UNKNOWN", 3, 0);
            UNKNOWN = r103;
            f270170a = new VibrationStyle[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public final int getAmplitude() {
            return this.amplitude;
        }

        public VibrationStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.amplitude = r102;
        }
    }

    public XVibrateMethod() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        ye7.e.b r112 = (ye7.e.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Activity r101 = r100.getOwnerActivity();
        if (r101 != null) goto L32;
        id7.c.a("Context is null");
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "Context is null.", null, 4, null);
        return;
    L32:
        VibrationStyle.a r102 = VibrationStyle.Companion;     // Catch: Exception -> L27
        String r103 = r112.getStyle();     // Catch: Exception -> L27
        r102.getClass();     // Catch: Exception -> L27
        if (r103 != null) goto L30;
        VibrationStyle r104 = VibrationStyle.UNKNOWN;     // Catch: Exception -> L27
    L12:
        if (r104 != VibrationStyle.UNKNOWN) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r111, -3, "Illegal style", null, 4, null);     // Catch: Exception -> L27
        return;
    L14:
        int r105 = r104.getAmplitude();     // Catch: Exception -> L27
        Number r113 = r112.getDuration();     // Catch: Exception -> L27
        if (r113 == null) goto L17;
        Long r114 = Long.valueOf(r113.longValue());     // Catch: Exception -> L27
    L18:
        Object r106 = r101.getSystemService("vibrator");     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L27
        Vibrator r107 = (Vibrator) r106;     // Catch: Exception -> L27
        if (Build.VERSION.SDK_INT < 26) goto L24;
        if (r114 == null) goto L22;
        VibrationEffect r115 = VibrationEffect.createOneShot(r114.longValue(), r105);     // Catch: Exception -> L27
    L23:
        r107.vibrate(r115, null);     // Catch: Exception -> L27
    L26:
        id7.c.a("Vibrate success");
        r111.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(ye7.e.c.class)), "vibrate execute success.");
        return;
    L22:
        r115 = null;
        goto L23
    L24:
        if (r114 == null) goto L26;
        r107.vibrate(r114.longValue());     // Catch: Exception -> L27
        goto L26
    L17:
        r114 = null;
        goto L18
    L30:
        r104 = VibrationStyle.valueOf(r103.toUpperCase());     // Catch: Exception -> L9
    L9:
        r104 = VibrationStyle.UNKNOWN;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "Can not get vibrate service.", null, 4, null);
        id7.c.a(String.valueOf(e.getMessage()));
    }
}
