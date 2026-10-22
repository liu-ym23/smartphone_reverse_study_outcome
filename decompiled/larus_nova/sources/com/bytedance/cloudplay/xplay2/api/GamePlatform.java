package com.bytedance.cloudplay.xplay2.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/GamePlatform;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Android", "PC", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum GamePlatform extends Enum<GamePlatform> {
    public static final GamePlatform Android = null;
    public static final a Companion = null;
    public static final GamePlatform PC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GamePlatform[] f202788a = null;
    private int value;

    public static GamePlatform valueOf(String r100) {
        return (GamePlatform) r27.a.a(GamePlatform.class, r100);
    }

    public static GamePlatform[] values() {
        return (GamePlatform[]) f202788a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.cloudplay.xplay2.api.GamePlatform$a] */
    static {
        GamePlatform r100 = new GamePlatform("Android", 0, 1);
        Android = r100;
        GamePlatform r101 = new GamePlatform("PC", 1, 2);
        PC = r101;
        f202788a = new GamePlatform[]{r100, r101};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public GamePlatform(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
