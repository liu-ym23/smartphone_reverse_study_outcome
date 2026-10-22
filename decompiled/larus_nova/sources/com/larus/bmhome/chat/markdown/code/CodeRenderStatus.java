package com.larus.bmhome.chat.markdown.code;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeRenderStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Success", "Failed", "Loading", "Placeholder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CodeRenderStatus extends Enum<CodeRenderStatus> {
    public static final CodeRenderStatus Failed = null;
    public static final CodeRenderStatus Loading = null;
    public static final CodeRenderStatus Placeholder = null;
    public static final CodeRenderStatus Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodeRenderStatus[] f306967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306968b = null;

    public static EnumEntries<CodeRenderStatus> getEntries() {
        return f306968b;
    }

    static {
        CodeRenderStatus r100 = new CodeRenderStatus("Success", 0);
        Success = r100;
        CodeRenderStatus r101 = new CodeRenderStatus("Failed", 1);
        Failed = r101;
        CodeRenderStatus r102 = new CodeRenderStatus("Loading", 2);
        Loading = r102;
        CodeRenderStatus r103 = new CodeRenderStatus("Placeholder", 3);
        Placeholder = r103;
        CodeRenderStatus[] r104 = {r100, r101, r102, r103};
        f306967a = r104;
        f306968b = EnumEntriesKt.enumEntries(r104);
    }

    public static CodeRenderStatus[] values() {
        return (CodeRenderStatus[]) f306967a.clone();
    }

    public static CodeRenderStatus valueOf(String r100) {
        return (CodeRenderStatus) r27.a.a(CodeRenderStatus.class, r100);
    }

    public CodeRenderStatus(String r100, int r101) {
        super(r100, r101);
    }
}
