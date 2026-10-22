package com.bytedance.ies.xbridge.ui.bridge;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/ies/xbridge/ui/bridge/XConfigureStatusBarMethod$StatusBarStyle", "", "Lcom/bytedance/ies/xbridge/ui/bridge/XConfigureStatusBarMethod$StatusBarStyle;", "", "style", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DARK", "LIGHT", "UNKNOWN", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XConfigureStatusBarMethod$StatusBarStyle extends Enum<XConfigureStatusBarMethod$StatusBarStyle> {
    public static final a Companion = null;
    public static final XConfigureStatusBarMethod$StatusBarStyle DARK = null;
    public static final XConfigureStatusBarMethod$StatusBarStyle LIGHT = null;
    public static final XConfigureStatusBarMethod$StatusBarStyle UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XConfigureStatusBarMethod$StatusBarStyle[] f249550a = null;
    private final String style;

    public static XConfigureStatusBarMethod$StatusBarStyle valueOf(String r100) {
        return (XConfigureStatusBarMethod$StatusBarStyle) r27.a.a(XConfigureStatusBarMethod$StatusBarStyle.class, r100);
    }

    public static XConfigureStatusBarMethod$StatusBarStyle[] values() {
        return (XConfigureStatusBarMethod$StatusBarStyle[]) f249550a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.xbridge.ui.bridge.XConfigureStatusBarMethod$StatusBarStyle$a] */
    static {
        XConfigureStatusBarMethod$StatusBarStyle r100 = new XConfigureStatusBarMethod$StatusBarStyle("DARK", 0, "dark");
        DARK = r100;
        XConfigureStatusBarMethod$StatusBarStyle r101 = new XConfigureStatusBarMethod$StatusBarStyle("LIGHT", 1, "light");
        LIGHT = r101;
        XConfigureStatusBarMethod$StatusBarStyle r102 = new XConfigureStatusBarMethod$StatusBarStyle("UNKNOWN", 2, null);
        UNKNOWN = r102;
        f249550a = new XConfigureStatusBarMethod$StatusBarStyle[]{r100, r101, r102};
        Companion = new a();
    }

    public final String getStyle() {
        return this.style;
    }

    public XConfigureStatusBarMethod$StatusBarStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.style = r102;
    }
}
