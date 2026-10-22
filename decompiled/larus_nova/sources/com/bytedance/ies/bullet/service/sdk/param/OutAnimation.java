package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/OutAnimation;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "aliasValue", "getAliasValue", "AUTO", "BOTTOM", "RIGHT", UserProfileEvent.POSITION_NONE, "IN_NONE_OUT_AUTO", "IN_AUTO_OUT_NONE", "LEFT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum OutAnimation extends Enum<OutAnimation> {
    public static final OutAnimation AUTO = null;
    public static final OutAnimation BOTTOM = null;
    public static final OutAnimation IN_AUTO_OUT_NONE = null;
    public static final OutAnimation IN_NONE_OUT_AUTO = null;
    public static final OutAnimation LEFT = null;
    public static final OutAnimation NONE = null;
    public static final OutAnimation RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OutAnimation[] f248142a = null;
    private final String aliasValue;
    private final String value;

    public static OutAnimation valueOf(String r100) {
        return (OutAnimation) r27.a.a(OutAnimation.class, r100);
    }

    public static OutAnimation[] values() {
        return (OutAnimation[]) f248142a.clone();
    }

    static {
        OutAnimation r100 = new OutAnimation("AUTO", 0, "auto", "0");
        AUTO = r100;
        OutAnimation r101 = new OutAnimation("BOTTOM", 1, "bottom", "1");
        BOTTOM = r101;
        OutAnimation r102 = new OutAnimation("RIGHT", 2, "right", "2");
        RIGHT = r102;
        OutAnimation r103 = new OutAnimation(UserProfileEvent.POSITION_NONE, 3, "none", "3");
        NONE = r103;
        OutAnimation r104 = new OutAnimation("IN_NONE_OUT_AUTO", 4, "in_none_out_auto", "4");
        IN_NONE_OUT_AUTO = r104;
        OutAnimation r105 = new OutAnimation("IN_AUTO_OUT_NONE", 5, "in_auto_out_none", "5");
        IN_AUTO_OUT_NONE = r105;
        OutAnimation r106 = new OutAnimation("LEFT", 6, "left", "6");
        LEFT = r106;
        f248142a = new OutAnimation[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }

    public OutAnimation(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.aliasValue = r103;
    }
}
