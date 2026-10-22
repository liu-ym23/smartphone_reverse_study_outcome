package com.obric.assistant.ability.chat.input;

import com.bytedance.ee.bear.sheet.fab.FabItem;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/ability/chat/input/SkillSelectSource;", "", "<init>", "(Ljava/lang/String;I)V", FabItem.FabSheetItem.CellType.ROW, "MENTION", "ROUTE_USE", "ROUTE_DEMO", "DRAFT", "INVALIDATED", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkillSelectSource extends Enum<SkillSelectSource> {
    public static final SkillSelectSource DRAFT = null;
    public static final SkillSelectSource INVALIDATED = null;
    public static final SkillSelectSource MENTION = null;
    public static final SkillSelectSource ROUTE_DEMO = null;
    public static final SkillSelectSource ROUTE_USE = null;
    public static final SkillSelectSource ROW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkillSelectSource[] f385219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385220b = null;

    public static EnumEntries<SkillSelectSource> getEntries() {
        return f385220b;
    }

    static {
        SkillSelectSource r100 = new SkillSelectSource(FabItem.FabSheetItem.CellType.ROW, 0);
        ROW = r100;
        SkillSelectSource r101 = new SkillSelectSource("MENTION", 1);
        MENTION = r101;
        SkillSelectSource r102 = new SkillSelectSource("ROUTE_USE", 2);
        ROUTE_USE = r102;
        SkillSelectSource r103 = new SkillSelectSource("ROUTE_DEMO", 3);
        ROUTE_DEMO = r103;
        SkillSelectSource r104 = new SkillSelectSource("DRAFT", 4);
        DRAFT = r104;
        SkillSelectSource r105 = new SkillSelectSource("INVALIDATED", 5);
        INVALIDATED = r105;
        SkillSelectSource[] r110 = {r100, r101, r102, r103, r104, r105};
        f385219a = r110;
        f385220b = EnumEntriesKt.enumEntries(r110);
    }

    public static SkillSelectSource[] values() {
        return (SkillSelectSource[]) f385219a.clone();
    }

    public static SkillSelectSource valueOf(String r100) {
        return (SkillSelectSource) a.a(SkillSelectSource.class, r100);
    }

    public SkillSelectSource(String r100, int r101) {
        super(r100, r101);
    }
}
