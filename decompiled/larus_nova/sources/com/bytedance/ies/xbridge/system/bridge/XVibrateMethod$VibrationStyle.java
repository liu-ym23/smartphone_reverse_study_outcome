package com.bytedance.ies.xbridge.system.bridge;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/bytedance/ies/xbridge/system/bridge/XVibrateMethod$VibrationStyle", "", "Lcom/bytedance/ies/xbridge/system/bridge/XVibrateMethod$VibrationStyle;", "", "amplitude", "I", "getAmplitude", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LIGHT", "MEDIUM", "HEAVY", "UNKNOWN", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XVibrateMethod$VibrationStyle extends Enum<XVibrateMethod$VibrationStyle> {
    public static final a Companion = null;
    public static final XVibrateMethod$VibrationStyle HEAVY = null;
    public static final XVibrateMethod$VibrationStyle LIGHT = null;
    public static final XVibrateMethod$VibrationStyle MEDIUM = null;
    public static final XVibrateMethod$VibrationStyle UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XVibrateMethod$VibrationStyle[] f249543a = null;
    private final int amplitude;

    public static XVibrateMethod$VibrationStyle valueOf(String r100) {
        return (XVibrateMethod$VibrationStyle) r27.a.a(XVibrateMethod$VibrationStyle.class, r100);
    }

    public static XVibrateMethod$VibrationStyle[] values() {
        return (XVibrateMethod$VibrationStyle[]) f249543a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.xbridge.system.bridge.XVibrateMethod$VibrationStyle$a] */
    static {
        XVibrateMethod$VibrationStyle r100 = new XVibrateMethod$VibrationStyle("LIGHT", 0, 50);
        LIGHT = r100;
        XVibrateMethod$VibrationStyle r101 = new XVibrateMethod$VibrationStyle("MEDIUM", 1, 125);
        MEDIUM = r101;
        XVibrateMethod$VibrationStyle r102 = new XVibrateMethod$VibrationStyle("HEAVY", 2, 255);
        HEAVY = r102;
        XVibrateMethod$VibrationStyle r103 = new XVibrateMethod$VibrationStyle("UNKNOWN", 3, 0);
        UNKNOWN = r103;
        f249543a = new XVibrateMethod$VibrationStyle[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public final int getAmplitude() {
        return this.amplitude;
    }

    public XVibrateMethod$VibrationStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.amplitude = r102;
    }
}
