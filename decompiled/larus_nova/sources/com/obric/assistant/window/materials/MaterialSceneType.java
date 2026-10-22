package com.obric.assistant.window.materials;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/window/materials/MaterialSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT", "ACTION_BAR", "ACTION_BAR_SELECTED", "ACTION_BAR_TASK_SKILL", "ACTION_BAR_TASK_SKILL_SELECTED", "BOTTOM_MENU", "WINDOW_BG", "WINDOW_BG_WITH_BOTTOM_RADIUS", "FLOATING_BG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MaterialSceneType extends Enum<MaterialSceneType> {
    public static final MaterialSceneType ACTION_BAR = null;
    public static final MaterialSceneType ACTION_BAR_SELECTED = null;
    public static final MaterialSceneType ACTION_BAR_TASK_SKILL = null;
    public static final MaterialSceneType ACTION_BAR_TASK_SKILL_SELECTED = null;
    public static final MaterialSceneType BOTTOM_MENU = null;
    public static final MaterialSceneType FLOATING_BG = null;
    public static final MaterialSceneType INPUT = null;
    public static final MaterialSceneType WINDOW_BG = null;
    public static final MaterialSceneType WINDOW_BG_WITH_BOTTOM_RADIUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaterialSceneType[] f394930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394931b = null;

    public static EnumEntries<MaterialSceneType> getEntries() {
        return f394931b;
    }

    static {
        MaterialSceneType r100 = new MaterialSceneType("INPUT", 0);
        INPUT = r100;
        MaterialSceneType r101 = new MaterialSceneType("ACTION_BAR", 1);
        ACTION_BAR = r101;
        MaterialSceneType r102 = new MaterialSceneType("ACTION_BAR_SELECTED", 2);
        ACTION_BAR_SELECTED = r102;
        MaterialSceneType r103 = new MaterialSceneType("ACTION_BAR_TASK_SKILL", 3);
        ACTION_BAR_TASK_SKILL = r103;
        MaterialSceneType r104 = new MaterialSceneType("ACTION_BAR_TASK_SKILL_SELECTED", 4);
        ACTION_BAR_TASK_SKILL_SELECTED = r104;
        MaterialSceneType r105 = new MaterialSceneType("BOTTOM_MENU", 5);
        BOTTOM_MENU = r105;
        MaterialSceneType r110 = new MaterialSceneType("WINDOW_BG", 6);
        WINDOW_BG = r110;
        MaterialSceneType r111 = new MaterialSceneType("WINDOW_BG_WITH_BOTTOM_RADIUS", 7);
        WINDOW_BG_WITH_BOTTOM_RADIUS = r111;
        MaterialSceneType r112 = new MaterialSceneType("FLOATING_BG", 8);
        FLOATING_BG = r112;
        MaterialSceneType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f394930a = r113;
        f394931b = EnumEntriesKt.enumEntries(r113);
    }

    public static MaterialSceneType[] values() {
        return (MaterialSceneType[]) f394930a.clone();
    }

    public static MaterialSceneType valueOf(String r100) {
        return (MaterialSceneType) a.a(MaterialSceneType.class, r100);
    }

    public MaterialSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
