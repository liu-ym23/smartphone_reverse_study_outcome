package com.larus.avlink.liveai.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/larus/avlink/liveai/model/LiveAiEventScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "MANUAL", "AUTO", "toString", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LiveAiEventScene extends Enum<LiveAiEventScene> {
    public static final LiveAiEventScene AUTO = null;
    public static final a Companion = null;
    public static final LiveAiEventScene MANUAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAiEventScene[] f293395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293396b = null;
    private final String scene;

    public static EnumEntries<LiveAiEventScene> getEntries() {
        return f293396b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.liveai.model.LiveAiEventScene$a] */
    static {
        LiveAiEventScene r100 = new LiveAiEventScene("MANUAL", 0, "MANUAL");
        MANUAL = r100;
        LiveAiEventScene r101 = new LiveAiEventScene("AUTO", 1, "AUTO");
        AUTO = r101;
        LiveAiEventScene[] r102 = {r100, r101};
        f293395a = r102;
        f293396b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static LiveAiEventScene[] values() {
        return (LiveAiEventScene[]) f293395a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "scene:" + this.scene + ' ';
    }

    public final String getScene() {
        return this.scene;
    }

    public static LiveAiEventScene valueOf(String r100) {
        return (LiveAiEventScene) r27.a.a(LiveAiEventScene.class, r100);
    }

    public LiveAiEventScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
