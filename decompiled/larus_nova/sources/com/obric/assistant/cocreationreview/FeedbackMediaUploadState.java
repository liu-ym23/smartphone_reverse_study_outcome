package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaUploadState;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "UPLOADING", "UPLOADED", "FAILED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaUploadState extends Enum<FeedbackMediaUploadState> {
    public static final FeedbackMediaUploadState FAILED = null;
    public static final FeedbackMediaUploadState READY = null;
    public static final FeedbackMediaUploadState UPLOADED = null;
    public static final FeedbackMediaUploadState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackMediaUploadState[] f387142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387143b = null;

    public static EnumEntries<FeedbackMediaUploadState> getEntries() {
        return f387143b;
    }

    static {
        FeedbackMediaUploadState r100 = new FeedbackMediaUploadState("READY", 0);
        READY = r100;
        FeedbackMediaUploadState r101 = new FeedbackMediaUploadState("UPLOADING", 1);
        UPLOADING = r101;
        FeedbackMediaUploadState r102 = new FeedbackMediaUploadState("UPLOADED", 2);
        UPLOADED = r102;
        FeedbackMediaUploadState r103 = new FeedbackMediaUploadState("FAILED", 3);
        FAILED = r103;
        FeedbackMediaUploadState[] r104 = {r100, r101, r102, r103};
        f387142a = r104;
        f387143b = EnumEntriesKt.enumEntries(r104);
    }

    public static FeedbackMediaUploadState[] values() {
        return (FeedbackMediaUploadState[]) f387142a.clone();
    }

    public static FeedbackMediaUploadState valueOf(String r100) {
        return (FeedbackMediaUploadState) r27.a.a(FeedbackMediaUploadState.class, r100);
    }

    public FeedbackMediaUploadState(String r100, int r101) {
        super(r100, r101);
    }
}
