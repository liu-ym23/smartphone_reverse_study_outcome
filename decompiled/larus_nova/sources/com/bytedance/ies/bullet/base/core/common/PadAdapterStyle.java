package com.bytedance.ies.bullet.base.core.common;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/base/core/common/PadAdapterStyle;", "", "", "style", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "WIDTH_PERCENT", "UNIFORM_STYLE", "CHANNEL_STYLE", UserProfileEvent.POSITION_NONE, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PadAdapterStyle extends Enum<PadAdapterStyle> {
    public static final PadAdapterStyle CHANNEL_STYLE = null;
    public static final PadAdapterStyle NONE = null;
    public static final PadAdapterStyle UNIFORM_STYLE = null;
    public static final PadAdapterStyle WIDTH_PERCENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PadAdapterStyle[] f246313a = null;
    private final String style;

    public static PadAdapterStyle valueOf(String r100) {
        return (PadAdapterStyle) a.a(PadAdapterStyle.class, r100);
    }

    public static PadAdapterStyle[] values() {
        return (PadAdapterStyle[]) f246313a.clone();
    }

    static {
        PadAdapterStyle r100 = new PadAdapterStyle("WIDTH_PERCENT", 0, "width_percent");
        WIDTH_PERCENT = r100;
        PadAdapterStyle r101 = new PadAdapterStyle("UNIFORM_STYLE", 1, "uniform_style");
        UNIFORM_STYLE = r101;
        PadAdapterStyle r102 = new PadAdapterStyle("CHANNEL_STYLE", 2, "channel_style");
        CHANNEL_STYLE = r102;
        PadAdapterStyle r103 = new PadAdapterStyle(UserProfileEvent.POSITION_NONE, 3, "none");
        NONE = r103;
        f246313a = new PadAdapterStyle[]{r100, r101, r102, r103};
    }

    public final String getStyle() {
        return this.style;
    }

    public PadAdapterStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.style = r102;
    }
}
