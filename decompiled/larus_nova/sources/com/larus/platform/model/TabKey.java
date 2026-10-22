package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/TabKey;", "", "tabKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTabKey", "()Ljava/lang/String;", "MY", "RECOMMEND", "FEMALE", "MALE", "CHARACTERS", "ACCENT", "ENGLISH", "MULTILANGUAGE", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabKey extends Enum<TabKey> {
    public static final TabKey ACCENT = null;
    public static final TabKey CHARACTERS = null;
    public static final a Companion = null;
    public static final TabKey ENGLISH = null;
    public static final TabKey FEMALE = null;
    public static final TabKey MALE = null;
    public static final TabKey MULTILANGUAGE = null;
    public static final TabKey MY = null;
    public static final TabKey RECOMMEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabKey[] f365494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365495b = null;
    private final String tabKey;

    public static EnumEntries<TabKey> getEntries() {
        return f365495b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.platform.model.TabKey$a] */
    static {
        TabKey r100 = new TabKey("MY", 0, "my");
        MY = r100;
        TabKey r101 = new TabKey("RECOMMEND", 1, "recommend");
        RECOMMEND = r101;
        TabKey r102 = new TabKey("FEMALE", 2, "female");
        FEMALE = r102;
        TabKey r103 = new TabKey("MALE", 3, "male");
        MALE = r103;
        TabKey r104 = new TabKey("CHARACTERS", 4, "characters");
        CHARACTERS = r104;
        TabKey r105 = new TabKey("ACCENT", 5, "accent");
        ACCENT = r105;
        TabKey r110 = new TabKey("ENGLISH", 6, "english");
        ENGLISH = r110;
        TabKey r111 = new TabKey("MULTILANGUAGE", 7, "multilanguage");
        MULTILANGUAGE = r111;
        TabKey[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f365494a = r112;
        f365495b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static TabKey[] values() {
        return (TabKey[]) f365494a.clone();
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public static TabKey valueOf(String r100) {
        return (TabKey) r27.a.a(TabKey.class, r100);
    }

    public TabKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.tabKey = r102;
    }
}
