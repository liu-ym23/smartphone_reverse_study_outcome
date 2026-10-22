package com.bytedance.ies.bullet.service.sdk.param;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "", "systemValue", "I", "getSystemValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STATE_UNSPECIFIED", "STATE_UNCHANGED", "STATE_HIDDEN", "STATE_ALWAYS_HIDDEN", "STATE_VISIBLE", "STATE_ALWAYS_VISIBLE", "ADJUST_UNSPECIFIED", "ADJUST_RESIZE", "ADJUST_PAN", "IS_FORWARD_NAVIGATION", "ADJUST_NOTHING", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SoftInputMode extends Enum<SoftInputMode> {
    public static final SoftInputMode ADJUST_NOTHING = null;
    public static final SoftInputMode ADJUST_PAN = null;
    public static final SoftInputMode ADJUST_RESIZE = null;
    public static final SoftInputMode ADJUST_UNSPECIFIED = null;
    public static final a Companion = null;
    public static final SoftInputMode IS_FORWARD_NAVIGATION = null;
    public static final SoftInputMode STATE_ALWAYS_HIDDEN = null;
    public static final SoftInputMode STATE_ALWAYS_VISIBLE = null;
    public static final SoftInputMode STATE_HIDDEN = null;
    public static final SoftInputMode STATE_UNCHANGED = null;
    public static final SoftInputMode STATE_UNSPECIFIED = null;
    public static final SoftInputMode STATE_VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SoftInputMode[] f248146a = null;
    private final int systemValue;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static SoftInputMode valueOf(String r100) {
        return (SoftInputMode) r27.a.a(SoftInputMode.class, r100);
    }

    public static SoftInputMode[] values() {
        return (SoftInputMode[]) f248146a.clone();
    }

    static {
        SoftInputMode r100 = new SoftInputMode("STATE_UNSPECIFIED", 0, "state_unspecified", 0);
        STATE_UNSPECIFIED = r100;
        SoftInputMode r101 = new SoftInputMode("STATE_UNCHANGED", 1, "state_unchanged", 1);
        STATE_UNCHANGED = r101;
        SoftInputMode r102 = new SoftInputMode("STATE_HIDDEN", 2, "state_hidden", 2);
        STATE_HIDDEN = r102;
        SoftInputMode r103 = new SoftInputMode("STATE_ALWAYS_HIDDEN", 3, "state_always_hidden", 3);
        STATE_ALWAYS_HIDDEN = r103;
        SoftInputMode r104 = new SoftInputMode("STATE_VISIBLE", 4, "state_visible", 4);
        STATE_VISIBLE = r104;
        SoftInputMode r105 = new SoftInputMode("STATE_ALWAYS_VISIBLE", 5, "state_always_visible", 5);
        STATE_ALWAYS_VISIBLE = r105;
        SoftInputMode r110 = new SoftInputMode("ADJUST_UNSPECIFIED", 6, "adjust_unspecified", 0);
        ADJUST_UNSPECIFIED = r110;
        SoftInputMode r111 = new SoftInputMode("ADJUST_RESIZE", 7, "adjust_resize", 16);
        ADJUST_RESIZE = r111;
        SoftInputMode r112 = new SoftInputMode("ADJUST_PAN", 8, "adjust_pan", 32);
        ADJUST_PAN = r112;
        SoftInputMode r106 = new SoftInputMode("IS_FORWARD_NAVIGATION", 9, "is_forward_navigation", 256);
        IS_FORWARD_NAVIGATION = r106;
        SoftInputMode r107 = new SoftInputMode("ADJUST_NOTHING", 10, "adjust_nothing", 48);
        ADJUST_NOTHING = r107;
        f248146a = new SoftInputMode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r107};
        Companion = new a();
    }

    public final int getSystemValue() {
        return this.systemValue;
    }

    public final String getValue() {
        return this.value;
    }

    public SoftInputMode(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.systemValue = r103;
    }
}
