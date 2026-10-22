package com.ss.android.lark.feed.export.feedcard.action;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionStatus;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "SUCCESS", "ERROR", GXAnimation.STATE_END, "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionStatus extends Enum<FeedActionStatus> {
    public static final FeedActionStatus END = null;
    public static final FeedActionStatus ERROR = null;
    public static final FeedActionStatus START = null;
    public static final FeedActionStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedActionStatus[] f421011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421012b = null;

    public static EnumEntries<FeedActionStatus> getEntries() {
        return f421012b;
    }

    static {
        FeedActionStatus r100 = new FeedActionStatus(GXAnimation.STATE_START, 0);
        START = r100;
        FeedActionStatus r101 = new FeedActionStatus("SUCCESS", 1);
        SUCCESS = r101;
        FeedActionStatus r102 = new FeedActionStatus("ERROR", 2);
        ERROR = r102;
        FeedActionStatus r103 = new FeedActionStatus(GXAnimation.STATE_END, 3);
        END = r103;
        FeedActionStatus[] r104 = {r100, r101, r102, r103};
        f421011a = r104;
        f421012b = EnumEntriesKt.enumEntries(r104);
    }

    public static FeedActionStatus[] values() {
        return (FeedActionStatus[]) f421011a.clone();
    }

    public static FeedActionStatus valueOf(String r100) {
        return (FeedActionStatus) a.a(FeedActionStatus.class, r100);
    }

    public FeedActionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
