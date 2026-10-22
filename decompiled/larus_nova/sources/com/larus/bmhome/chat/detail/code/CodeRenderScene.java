package com.larus.bmhome.chat.detail.code;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/CodeRenderScene;", "", "<init>", "(Ljava/lang/String;I)V", "DeepSearch", "CodeArtifact", "Default", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CodeRenderScene extends Enum<CodeRenderScene> {
    public static final CodeRenderScene CodeArtifact = null;
    public static final CodeRenderScene DeepSearch = null;
    public static final CodeRenderScene Default = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodeRenderScene[] f302717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f302718b = null;

    public static EnumEntries<CodeRenderScene> getEntries() {
        return f302718b;
    }

    static {
        CodeRenderScene r100 = new CodeRenderScene("DeepSearch", 0);
        DeepSearch = r100;
        CodeRenderScene r101 = new CodeRenderScene("CodeArtifact", 1);
        CodeArtifact = r101;
        CodeRenderScene r102 = new CodeRenderScene("Default", 2);
        Default = r102;
        CodeRenderScene[] r103 = {r100, r101, r102};
        f302717a = r103;
        f302718b = EnumEntriesKt.enumEntries(r103);
    }

    public static CodeRenderScene[] values() {
        return (CodeRenderScene[]) f302717a.clone();
    }

    public static CodeRenderScene valueOf(String r100) {
        return (CodeRenderScene) r27.a.a(CodeRenderScene.class, r100);
    }

    public CodeRenderScene(String r100, int r101) {
        super(r100, r101);
    }
}
