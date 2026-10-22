package com.ss.android.lark.chat.export.entity.chatter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chatter/NameRule;", "", "<init>", "(Ljava/lang/String;I)V", "NAME", "ALIAS_NAME", "NICKNAME_ALIAS_NAME", "ALIAS_NICKNAME_NAME", "NICKNAME_NAME", "NICKNAME_WITH_ALIAS", "chat-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NameRule extends Enum<NameRule> {
    public static final NameRule ALIAS_NAME = null;
    public static final NameRule ALIAS_NICKNAME_NAME = null;
    public static final NameRule NAME = null;
    public static final NameRule NICKNAME_ALIAS_NAME = null;
    public static final NameRule NICKNAME_NAME = null;
    public static final NameRule NICKNAME_WITH_ALIAS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NameRule[] f415388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415389b = null;

    public static EnumEntries<NameRule> getEntries() {
        return f415389b;
    }

    static {
        NameRule r100 = new NameRule("NAME", 0);
        NAME = r100;
        NameRule r101 = new NameRule("ALIAS_NAME", 1);
        ALIAS_NAME = r101;
        NameRule r102 = new NameRule("NICKNAME_ALIAS_NAME", 2);
        NICKNAME_ALIAS_NAME = r102;
        NameRule r103 = new NameRule("ALIAS_NICKNAME_NAME", 3);
        ALIAS_NICKNAME_NAME = r103;
        NameRule r104 = new NameRule("NICKNAME_NAME", 4);
        NICKNAME_NAME = r104;
        NameRule r105 = new NameRule("NICKNAME_WITH_ALIAS", 5);
        NICKNAME_WITH_ALIAS = r105;
        NameRule[] r110 = {r100, r101, r102, r103, r104, r105};
        f415388a = r110;
        f415389b = EnumEntriesKt.enumEntries(r110);
    }

    public static NameRule[] values() {
        return (NameRule[]) f415388a.clone();
    }

    public static NameRule valueOf(String r100) {
        return (NameRule) r27.a.a(NameRule.class, r100);
    }

    public NameRule(String r100, int r101) {
        super(r100, r101);
    }
}
