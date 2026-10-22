package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/utils/PcGuideSceneType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WRITING", "CODE", "PPT", "DEEP_RESEARCH", "READING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcGuideSceneType extends Enum<PcGuideSceneType> {
    public static final PcGuideSceneType CODE = null;
    public static final PcGuideSceneType DEEP_RESEARCH = null;
    public static final PcGuideSceneType PPT = null;
    public static final PcGuideSceneType READING = null;
    public static final PcGuideSceneType WRITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcGuideSceneType[] f314950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314951b = null;
    private final String value;

    public static EnumEntries<PcGuideSceneType> getEntries() {
        return f314951b;
    }

    static {
        PcGuideSceneType r100 = new PcGuideSceneType("WRITING", 0, "writing");
        WRITING = r100;
        PcGuideSceneType r101 = new PcGuideSceneType("CODE", 1, "code");
        CODE = r101;
        PcGuideSceneType r102 = new PcGuideSceneType("PPT", 2, "ppt");
        PPT = r102;
        PcGuideSceneType r103 = new PcGuideSceneType("DEEP_RESEARCH", 3, "deep_research");
        DEEP_RESEARCH = r103;
        PcGuideSceneType r104 = new PcGuideSceneType("READING", 4, "reading");
        READING = r104;
        PcGuideSceneType[] r105 = {r100, r101, r102, r103, r104};
        f314950a = r105;
        f314951b = EnumEntriesKt.enumEntries(r105);
    }

    public static PcGuideSceneType[] values() {
        return (PcGuideSceneType[]) f314950a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PcGuideSceneType valueOf(String r100) {
        return (PcGuideSceneType) r27.a.a(PcGuideSceneType.class, r100);
    }

    public PcGuideSceneType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
