package com.bytedance.ies.stark.framework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/stark/framework/MenuState;", "", "OPEN", "OPENING", "CLOSE", "CLOSING", "stark-api_release"}, k = 1, mv = {1, 7, 1})
public final enum MenuState extends Enum<MenuState> {
    public static final MenuState CLOSE = null;
    public static final MenuState CLOSING = null;
    public static final MenuState OPEN = null;
    public static final MenuState OPENING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MenuState[] f248626a = null;

    public static MenuState valueOf(String r100) {
        return (MenuState) r27.a.a(MenuState.class, r100);
    }

    public static MenuState[] values() {
        return (MenuState[]) f248626a.clone();
    }

    static {
        MenuState r100 = new MenuState("OPEN", 0);
        OPEN = r100;
        MenuState r101 = new MenuState("OPENING", 1);
        OPENING = r101;
        MenuState r102 = new MenuState("CLOSE", 2);
        CLOSE = r102;
        MenuState r103 = new MenuState("CLOSING", 3);
        CLOSING = r103;
        f248626a = new MenuState[]{r100, r101, r102, r103};
    }

    public MenuState(String r100, int r101) {
        super(r100, r101);
    }
}
