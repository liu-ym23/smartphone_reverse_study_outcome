package com.larus.avlink.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/model/ProactiveSummaryScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SystemNotify", "Music", "News", "Remind", "ProactiveMsg", "DeepResearch", "DoraAutoGreet", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveSummaryScene extends Enum<ProactiveSummaryScene> {
    public static final ProactiveSummaryScene DeepResearch = null;
    public static final ProactiveSummaryScene DoraAutoGreet = null;
    public static final ProactiveSummaryScene Music = null;
    public static final ProactiveSummaryScene News = null;
    public static final ProactiveSummaryScene ProactiveMsg = null;
    public static final ProactiveSummaryScene Remind = null;
    public static final ProactiveSummaryScene SystemNotify = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactiveSummaryScene[] f293414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293415b = null;
    private final int value;

    public static EnumEntries<ProactiveSummaryScene> getEntries() {
        return f293415b;
    }

    static {
        ProactiveSummaryScene r100 = new ProactiveSummaryScene("SystemNotify", 0, 1);
        SystemNotify = r100;
        ProactiveSummaryScene r101 = new ProactiveSummaryScene("Music", 1, 2);
        Music = r101;
        ProactiveSummaryScene r102 = new ProactiveSummaryScene("News", 2, 3);
        News = r102;
        ProactiveSummaryScene r103 = new ProactiveSummaryScene("Remind", 3, 4);
        Remind = r103;
        ProactiveSummaryScene r104 = new ProactiveSummaryScene("ProactiveMsg", 4, 5);
        ProactiveMsg = r104;
        ProactiveSummaryScene r110 = new ProactiveSummaryScene("DeepResearch", 5, 6);
        DeepResearch = r110;
        ProactiveSummaryScene r111 = new ProactiveSummaryScene("DoraAutoGreet", 6, 7);
        DoraAutoGreet = r111;
        ProactiveSummaryScene[] r112 = {r100, r101, r102, r103, r104, r110, r111};
        f293414a = r112;
        f293415b = EnumEntriesKt.enumEntries(r112);
    }

    public static ProactiveSummaryScene[] values() {
        return (ProactiveSummaryScene[]) f293414a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProactiveSummaryScene valueOf(String r100) {
        return (ProactiveSummaryScene) r27.a.a(ProactiveSummaryScene.class, r100);
    }

    public ProactiveSummaryScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
