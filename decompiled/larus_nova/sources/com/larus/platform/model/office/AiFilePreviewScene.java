package com.larus.platform.model.office;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/office/AiFilePreviewScene;", "", "<init>", "(Ljava/lang/String;I)V", "AI_CHAT", "P2P_CHAT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AiFilePreviewScene extends Enum<AiFilePreviewScene> {
    public static final AiFilePreviewScene AI_CHAT = null;
    public static final AiFilePreviewScene P2P_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AiFilePreviewScene[] f365641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365642b = null;

    public static EnumEntries<AiFilePreviewScene> getEntries() {
        return f365642b;
    }

    static {
        AiFilePreviewScene r100 = new AiFilePreviewScene("AI_CHAT", 0);
        AI_CHAT = r100;
        AiFilePreviewScene r101 = new AiFilePreviewScene("P2P_CHAT", 1);
        P2P_CHAT = r101;
        AiFilePreviewScene[] r102 = {r100, r101};
        f365641a = r102;
        f365642b = EnumEntriesKt.enumEntries(r102);
    }

    public static AiFilePreviewScene[] values() {
        return (AiFilePreviewScene[]) f365641a.clone();
    }

    public static AiFilePreviewScene valueOf(String r100) {
        return (AiFilePreviewScene) a.a(AiFilePreviewScene.class, r100);
    }

    public AiFilePreviewScene(String r100, int r101) {
        super(r100, r101);
    }
}
