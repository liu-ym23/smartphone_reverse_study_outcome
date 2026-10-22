package com.bytedance.dux.theme;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/dux/theme/ForceDayNight;", "", "", "attrValue", "I", "getAttrValue", "()I", UserProfileEvent.POSITION_NONE, "LIGHT", "DARK", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum ForceDayNight extends Enum<ForceDayNight> {
    public static final ForceDayNight DARK = null;
    public static final ForceDayNight LIGHT = null;
    public static final ForceDayNight NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForceDayNight[] f205768a = null;
    private final int attrValue;

    public static ForceDayNight valueOf(String r100) {
        return (ForceDayNight) a.a(ForceDayNight.class, r100);
    }

    public static ForceDayNight[] values() {
        return (ForceDayNight[]) f205768a.clone();
    }

    static {
        ForceDayNight r100 = new ForceDayNight(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ForceDayNight r101 = new ForceDayNight("LIGHT", 1, 1);
        LIGHT = r101;
        ForceDayNight r102 = new ForceDayNight("DARK", 2, 2);
        DARK = r102;
        f205768a = new ForceDayNight[]{r100, r101, r102};
    }

    public final int getAttrValue() {
        return this.attrValue;
    }

    public ForceDayNight(String r100, int r101, int r102) {
        super(r100, r101);
        this.attrValue = r102;
    }
}
