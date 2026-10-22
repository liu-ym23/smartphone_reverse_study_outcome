package com.ss.android.lark.feed.shared.page.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/constant/FeedConstants$FeedErrorCode;", "", "errorCode", "", "<init>", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "ERROR_OPERATION_TO_PENDING_DELETE_FEED", "ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedConstants$FeedErrorCode extends Enum<FeedConstants$FeedErrorCode> {
    public static final FeedConstants$FeedErrorCode ERROR_OPERATION_TO_PENDING_DELETE_FEED = null;
    public static final FeedConstants$FeedErrorCode ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedConstants$FeedErrorCode[] f421393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421394b = null;
    private final int errorCode;

    public static EnumEntries<FeedConstants$FeedErrorCode> getEntries() {
        return f421394b;
    }

    static {
        FeedConstants$FeedErrorCode r100 = new FeedConstants$FeedErrorCode("ERROR_OPERATION_TO_PENDING_DELETE_FEED", 0, 111001);
        ERROR_OPERATION_TO_PENDING_DELETE_FEED = r100;
        FeedConstants$FeedErrorCode r101 = new FeedConstants$FeedErrorCode("ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE", 1, 5067);
        ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE = r101;
        FeedConstants$FeedErrorCode[] r102 = {r100, r101};
        f421393a = r102;
        f421394b = EnumEntriesKt.enumEntries(r102);
    }

    public static FeedConstants$FeedErrorCode[] values() {
        return (FeedConstants$FeedErrorCode[]) f421393a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public static FeedConstants$FeedErrorCode valueOf(String r100) {
        return (FeedConstants$FeedErrorCode) a.a(FeedConstants$FeedErrorCode.class, r100);
    }

    public FeedConstants$FeedErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.errorCode = r102;
    }
}
