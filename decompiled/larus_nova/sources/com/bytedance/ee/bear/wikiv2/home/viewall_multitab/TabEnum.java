package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/TabEnum;", "", "spaceType", "", "<init>", "(Ljava/lang/String;II)V", "getSpaceType", "()I", AccountType.ALL, "TEAM", "PERSONAL", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabEnum extends Enum<TabEnum> {
    public static final TabEnum ALL = null;
    public static final a Companion = null;
    public static final TabEnum PERSONAL = null;
    public static final TabEnum TEAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabEnum[] f240723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f240724b = null;
    private final int spaceType;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TabEnum> getEntries() {
        return f240724b;
    }

    static {
        TabEnum r100 = new TabEnum(AccountType.ALL, 0, -1);
        ALL = r100;
        TabEnum r101 = new TabEnum("TEAM", 1, 0);
        TEAM = r101;
        TabEnum r102 = new TabEnum("PERSONAL", 2, 1);
        PERSONAL = r102;
        TabEnum[] r103 = {r100, r101, r102};
        f240723a = r103;
        f240724b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TabEnum[] values() {
        return (TabEnum[]) f240723a.clone();
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public static TabEnum valueOf(String r100) {
        return (TabEnum) r27.a.a(TabEnum.class, r100);
    }

    public TabEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.spaceType = r102;
    }
}
