package com.ss.android.lark.chameleon.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadScene;", "", "(Ljava/lang/String;I)V", "DEFAULT", "APP_LAUNCH", "CLICK_TAB", "MESSAGE", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PreloadScene extends Enum<PreloadScene> {
    private static final /* synthetic */ PreloadScene[] $VALUES = null;
    public static final PreloadScene APP_LAUNCH = null;
    public static final PreloadScene CLICK_TAB = null;
    public static final PreloadScene DEFAULT = null;
    public static final PreloadScene MESSAGE = null;

    private static final /* synthetic */ PreloadScene[] $values() {
        return new PreloadScene[]{DEFAULT, APP_LAUNCH, CLICK_TAB, MESSAGE};
    }

    public static PreloadScene valueOf(String r100) {
        return (PreloadScene) a.a(PreloadScene.class, r100);
    }

    public static PreloadScene[] values() {
        return (PreloadScene[]) $VALUES.clone();
    }

    static {
        DEFAULT = new PreloadScene("DEFAULT", 0);
        APP_LAUNCH = new PreloadScene("APP_LAUNCH", 1);
        CLICK_TAB = new PreloadScene("CLICK_TAB", 2);
        MESSAGE = new PreloadScene("MESSAGE", 3);
        $VALUES = $values();
    }

    private PreloadScene(String r100, int r101) {
        super(r100, r101);
    }
}
