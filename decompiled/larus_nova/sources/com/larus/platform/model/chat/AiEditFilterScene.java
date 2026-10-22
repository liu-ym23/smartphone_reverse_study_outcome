package com.larus.platform.model.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/chat/AiEditFilterScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "EDU", "HEALTH", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AiEditFilterScene extends Enum<AiEditFilterScene> {
    public static final a Companion = null;
    public static final AiEditFilterScene EDU = null;
    public static final AiEditFilterScene HEALTH = null;
    public static final AiEditFilterScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AiEditFilterScene[] f365559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365560b = null;
    private final String value;

    public static EnumEntries<AiEditFilterScene> getEntries() {
        return f365560b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.model.chat.AiEditFilterScene$a] */
    static {
        AiEditFilterScene r100 = new AiEditFilterScene("UNKNOWN", 0, "");
        UNKNOWN = r100;
        AiEditFilterScene r101 = new AiEditFilterScene("EDU", 1, "edu");
        EDU = r101;
        AiEditFilterScene r102 = new AiEditFilterScene("HEALTH", 2, "health");
        HEALTH = r102;
        AiEditFilterScene[] r103 = {r100, r101, r102};
        f365559a = r103;
        f365560b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AiEditFilterScene[] values() {
        return (AiEditFilterScene[]) f365559a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AiEditFilterScene valueOf(String r100) {
        return (AiEditFilterScene) r27.a.a(AiEditFilterScene.class, r100);
    }

    public AiEditFilterScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
