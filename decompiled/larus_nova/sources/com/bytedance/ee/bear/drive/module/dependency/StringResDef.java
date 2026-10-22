package com.bytedance.ee.bear.drive.module.dependency;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/module/dependency/StringResDef;", "", "<init>", "(Ljava/lang/String;I)V", "Doc_Comment_CopyFailed", "DLP_CHECKING", "DLP_SENSATIVE", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StringResDef extends Enum<StringResDef> {
    public static final StringResDef DLP_CHECKING = null;
    public static final StringResDef DLP_SENSATIVE = null;
    public static final StringResDef Doc_Comment_CopyFailed = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StringResDef[] f224480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f224481b = null;

    public static EnumEntries<StringResDef> getEntries() {
        return f224481b;
    }

    static {
        StringResDef r100 = new StringResDef("Doc_Comment_CopyFailed", 0);
        Doc_Comment_CopyFailed = r100;
        StringResDef r101 = new StringResDef("DLP_CHECKING", 1);
        DLP_CHECKING = r101;
        StringResDef r102 = new StringResDef("DLP_SENSATIVE", 2);
        DLP_SENSATIVE = r102;
        StringResDef[] r103 = {r100, r101, r102};
        f224480a = r103;
        f224481b = EnumEntriesKt.enumEntries(r103);
    }

    public static StringResDef[] values() {
        return (StringResDef[]) f224480a.clone();
    }

    public static StringResDef valueOf(String r100) {
        return (StringResDef) a.a(StringResDef.class, r100);
    }

    public StringResDef(String r100, int r101) {
        super(r100, r101);
    }
}
