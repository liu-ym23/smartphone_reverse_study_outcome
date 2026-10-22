package com.bytedance.ee.bear.document.dependency;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/dependency/StringResDef;", "", "<init>", "(Ljava/lang/String;I)V", "Doc_Comment_Image_Quote", "Doc_Comment_CopyFailed", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StringResDef extends Enum<StringResDef> {
    public static final StringResDef Doc_Comment_CopyFailed = null;
    public static final StringResDef Doc_Comment_Image_Quote = null;
    public static final /* synthetic */ StringResDef[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StringResDef> getEntries() {
        return b;
    }

    static {
        StringResDef r0 = new StringResDef("Doc_Comment_Image_Quote", 0);
        Doc_Comment_Image_Quote = r0;
        StringResDef r1 = new StringResDef("Doc_Comment_CopyFailed", 1);
        Doc_Comment_CopyFailed = r1;
        StringResDef[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
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
