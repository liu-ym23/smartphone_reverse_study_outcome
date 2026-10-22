package com.larus.bmhome.chat.nestedmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuScene;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_BAR", "SETTINGS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NestedMenuScene extends Enum<NestedMenuScene> {
    public static final NestedMenuScene ACTION_BAR = null;
    public static final NestedMenuScene SETTINGS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NestedMenuScene[] f308227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308228b = null;

    public static EnumEntries<NestedMenuScene> getEntries() {
        return f308228b;
    }

    static {
        NestedMenuScene r100 = new NestedMenuScene("ACTION_BAR", 0);
        ACTION_BAR = r100;
        NestedMenuScene r101 = new NestedMenuScene("SETTINGS", 1);
        SETTINGS = r101;
        NestedMenuScene[] r102 = {r100, r101};
        f308227a = r102;
        f308228b = EnumEntriesKt.enumEntries(r102);
    }

    public static NestedMenuScene[] values() {
        return (NestedMenuScene[]) f308227a.clone();
    }

    public static NestedMenuScene valueOf(String r100) {
        return (NestedMenuScene) r27.a.a(NestedMenuScene.class, r100);
    }

    public NestedMenuScene(String r100, int r101) {
        super(r100, r101);
    }
}
