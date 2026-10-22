package com.bytedance.ies.xelement.common;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xelement/common/PlayerType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "DEFAULT", "SHORT", "LIGHT", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum PlayerType extends Enum<PlayerType> {
    public static final PlayerType DEFAULT = null;
    public static final PlayerType LIGHT = null;
    public static final PlayerType SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerType[] f249861a = null;
    private final String desc;

    public static PlayerType valueOf(String r100) {
        return (PlayerType) a.a(PlayerType.class, r100);
    }

    public static PlayerType[] values() {
        return (PlayerType[]) f249861a.clone();
    }

    static {
        PlayerType r100 = new PlayerType("DEFAULT", 0, "default");
        DEFAULT = r100;
        PlayerType r101 = new PlayerType("SHORT", 1, "short");
        SHORT = r101;
        PlayerType r102 = new PlayerType("LIGHT", 2, "light");
        LIGHT = r102;
        f249861a = new PlayerType[]{r100, r101, r102};
    }

    public final String getDesc() {
        return this.desc;
    }

    public PlayerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
