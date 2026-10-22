package com.bytedance.ee.bear.middleground.feed.depends;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/depends/StringResDef;", "", "<init>", "(Ljava/lang/String;I)V", "Doc_Comment_CopySuccess", "Doc_Comment_CopyFailed", "Doc_Comment_OriginalTitle", "Doc_Comment_Translate_Str", "Doc_Comment_Copy", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StringResDef extends Enum<StringResDef> {
    public static final StringResDef Doc_Comment_Copy = null;
    public static final StringResDef Doc_Comment_CopyFailed = null;
    public static final StringResDef Doc_Comment_CopySuccess = null;
    public static final StringResDef Doc_Comment_OriginalTitle = null;
    public static final StringResDef Doc_Comment_Translate_Str = null;
    public static final /* synthetic */ StringResDef[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StringResDef> getEntries() {
        return b;
    }

    static {
        StringResDef r0 = new StringResDef("Doc_Comment_CopySuccess", 0);
        Doc_Comment_CopySuccess = r0;
        StringResDef r1 = new StringResDef("Doc_Comment_CopyFailed", 1);
        Doc_Comment_CopyFailed = r1;
        StringResDef r3 = new StringResDef("Doc_Comment_OriginalTitle", 2);
        Doc_Comment_OriginalTitle = r3;
        StringResDef r5 = new StringResDef("Doc_Comment_Translate_Str", 3);
        Doc_Comment_Translate_Str = r5;
        StringResDef r7 = new StringResDef("Doc_Comment_Copy", 4);
        Doc_Comment_Copy = r7;
        StringResDef[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static StringResDef[] values() {
        return (StringResDef[]) a.clone();
    }

    public static StringResDef valueOf(String r1) {
        return (StringResDef) a.a(StringResDef.class, r1);
    }

    public StringResDef(String r1, int r2) {
        super(r1, r2);
    }
}
