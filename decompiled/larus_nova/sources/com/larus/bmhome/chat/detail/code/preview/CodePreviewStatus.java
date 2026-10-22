package com.larus.bmhome.chat.detail.code.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/preview/CodePreviewStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "LOADING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CodePreviewStatus extends Enum<CodePreviewStatus> {
    public static final CodePreviewStatus FAIL = null;
    public static final CodePreviewStatus LOADING = null;
    public static final CodePreviewStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodePreviewStatus[] f302780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f302781b = null;

    public static EnumEntries<CodePreviewStatus> getEntries() {
        return f302781b;
    }

    static {
        CodePreviewStatus r100 = new CodePreviewStatus("SUCCESS", 0);
        SUCCESS = r100;
        CodePreviewStatus r101 = new CodePreviewStatus("FAIL", 1);
        FAIL = r101;
        CodePreviewStatus r102 = new CodePreviewStatus("LOADING", 2);
        LOADING = r102;
        CodePreviewStatus[] r103 = {r100, r101, r102};
        f302780a = r103;
        f302781b = EnumEntriesKt.enumEntries(r103);
    }

    public static CodePreviewStatus[] values() {
        return (CodePreviewStatus[]) f302780a.clone();
    }

    public static CodePreviewStatus valueOf(String r100) {
        return (CodePreviewStatus) r27.a.a(CodePreviewStatus.class, r100);
    }

    public CodePreviewStatus(String r100, int r101) {
        super(r100, r101);
    }
}
