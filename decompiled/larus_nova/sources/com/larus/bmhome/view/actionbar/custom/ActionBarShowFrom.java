package com.larus.bmhome.view.actionbar.custom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/ActionBarShowFrom;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DIRECT_SHOW", "PLUS_PANNEL", "CLEAR_MEMORY", "PLUS_PANNEL_SLIDE", "SLIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarShowFrom extends Enum<ActionBarShowFrom> {
    public static final ActionBarShowFrom CLEAR_MEMORY = null;
    public static final ActionBarShowFrom DIRECT_SHOW = null;
    public static final ActionBarShowFrom PLUS_PANNEL = null;
    public static final ActionBarShowFrom PLUS_PANNEL_SLIDE = null;
    public static final ActionBarShowFrom SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarShowFrom[] f315705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315706b = null;
    private final String type;

    public static EnumEntries<ActionBarShowFrom> getEntries() {
        return f315706b;
    }

    static {
        ActionBarShowFrom r100 = new ActionBarShowFrom("DIRECT_SHOW", 0, "direct_show");
        DIRECT_SHOW = r100;
        ActionBarShowFrom r101 = new ActionBarShowFrom("PLUS_PANNEL", 1, "plus_pannel");
        PLUS_PANNEL = r101;
        ActionBarShowFrom r102 = new ActionBarShowFrom("CLEAR_MEMORY", 2, "clear_memory");
        CLEAR_MEMORY = r102;
        ActionBarShowFrom r103 = new ActionBarShowFrom("PLUS_PANNEL_SLIDE", 3, "plus_pannel_slide");
        PLUS_PANNEL_SLIDE = r103;
        ActionBarShowFrom r104 = new ActionBarShowFrom("SLIDE", 4, "slide");
        SLIDE = r104;
        ActionBarShowFrom[] r105 = {r100, r101, r102, r103, r104};
        f315705a = r105;
        f315706b = EnumEntriesKt.enumEntries(r105);
    }

    public static ActionBarShowFrom[] values() {
        return (ActionBarShowFrom[]) f315705a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ActionBarShowFrom valueOf(String r100) {
        return (ActionBarShowFrom) r27.a.a(ActionBarShowFrom.class, r100);
    }

    public ActionBarShowFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
