package com.bytedance.ee.bear.middleground.feed.depends;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/depends/StringResDef;", "", "<init>", "(Ljava/lang/String;I)V", "Doc_Comment_CopySuccess", "Doc_Comment_CopyFailed", "Doc_Comment_OriginalTitle", "Doc_Comment_Translate_Str", "Doc_Comment_Copy", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StringResDef extends Enum<StringResDef> {
    public static final StringResDef Doc_Comment_Copy = null;
    public static final StringResDef Doc_Comment_CopyFailed = null;
    public static final StringResDef Doc_Comment_CopySuccess = null;
    public static final StringResDef Doc_Comment_OriginalTitle = null;
    public static final StringResDef Doc_Comment_Translate_Str = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StringResDef[] f232605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f232606b = null;

    public static EnumEntries<StringResDef> getEntries() {
        return f232606b;
    }

    static {
        StringResDef r100 = new StringResDef("Doc_Comment_CopySuccess", 0);
        Doc_Comment_CopySuccess = r100;
        StringResDef r101 = new StringResDef("Doc_Comment_CopyFailed", 1);
        Doc_Comment_CopyFailed = r101;
        StringResDef r102 = new StringResDef("Doc_Comment_OriginalTitle", 2);
        Doc_Comment_OriginalTitle = r102;
        StringResDef r103 = new StringResDef("Doc_Comment_Translate_Str", 3);
        Doc_Comment_Translate_Str = r103;
        StringResDef r104 = new StringResDef("Doc_Comment_Copy", 4);
        Doc_Comment_Copy = r104;
        StringResDef[] r105 = {r100, r101, r102, r103, r104};
        f232605a = r105;
        f232606b = EnumEntriesKt.enumEntries(r105);
    }

    public static StringResDef[] values() {
        return (StringResDef[]) f232605a.clone();
    }

    public static StringResDef valueOf(String r100) {
        return (StringResDef) a.a(StringResDef.class, r100);
    }

    public StringResDef(String r100, int r101) {
        super(r100, r101);
    }
}
