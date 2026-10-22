package com.ss.android.lark.feed.export.feedcard.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/ActionScene;", "", "<init>", "(Ljava/lang/String;I)V", "SHORTCUT", "FEED", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionScene extends Enum<ActionScene> {
    public static final ActionScene FEED = null;
    public static final ActionScene SHORTCUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionScene[] f421007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421008b = null;

    public static EnumEntries<ActionScene> getEntries() {
        return f421008b;
    }

    static {
        ActionScene r100 = new ActionScene("SHORTCUT", 0);
        SHORTCUT = r100;
        ActionScene r101 = new ActionScene("FEED", 1);
        FEED = r101;
        ActionScene[] r102 = {r100, r101};
        f421007a = r102;
        f421008b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActionScene[] values() {
        return (ActionScene[]) f421007a.clone();
    }

    public static ActionScene valueOf(String r100) {
        return (ActionScene) a.a(ActionScene.class, r100);
    }

    public ActionScene(String r100, int r101) {
        super(r100, r101);
    }
}
