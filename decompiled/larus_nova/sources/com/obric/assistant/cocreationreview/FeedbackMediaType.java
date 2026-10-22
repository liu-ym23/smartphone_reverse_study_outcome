package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaType extends Enum<FeedbackMediaType> {
    public static final FeedbackMediaType IMAGE = null;
    public static final FeedbackMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackMediaType[] f387140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387141b = null;

    public static EnumEntries<FeedbackMediaType> getEntries() {
        return f387141b;
    }

    static {
        FeedbackMediaType r100 = new FeedbackMediaType("IMAGE", 0);
        IMAGE = r100;
        FeedbackMediaType r101 = new FeedbackMediaType("VIDEO", 1);
        VIDEO = r101;
        FeedbackMediaType[] r102 = {r100, r101};
        f387140a = r102;
        f387141b = EnumEntriesKt.enumEntries(r102);
    }

    public static FeedbackMediaType[] values() {
        return (FeedbackMediaType[]) f387140a.clone();
    }

    public static FeedbackMediaType valueOf(String r100) {
        return (FeedbackMediaType) r27.a.a(FeedbackMediaType.class, r100);
    }

    public FeedbackMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
