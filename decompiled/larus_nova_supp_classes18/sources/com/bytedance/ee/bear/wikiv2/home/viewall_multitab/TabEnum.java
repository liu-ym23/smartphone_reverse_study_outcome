package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/TabEnum;", "", "spaceType", "", "<init>", "(Ljava/lang/String;II)V", "getSpaceType", "()I", "ALL", "TEAM", "PERSONAL", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabEnum extends Enum<TabEnum> {
    public static final TabEnum ALL = null;
    public static final a Companion = null;
    public static final TabEnum PERSONAL = null;
    public static final TabEnum TEAM = null;
    public static final /* synthetic */ TabEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int spaceType;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TabEnum> getEntries() {
        return b;
    }

    static {
        TabEnum r0 = new TabEnum("ALL", 0, -1);
        ALL = r0;
        TabEnum r1 = new TabEnum("TEAM", 1, 0);
        TEAM = r1;
        TabEnum r3 = new TabEnum("PERSONAL", 2, 1);
        PERSONAL = r3;
        TabEnum[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static TabEnum[] values() {
        return (TabEnum[]) a.clone();
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public static TabEnum valueOf(String r1) {
        return (TabEnum) r27.a.a(TabEnum.class, r1);
    }

    public TabEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.spaceType = r3;
    }
}
