package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListViewObjectLiveQueryFieldType;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/LarkFeedListViewObjectLiveQueryFieldType;", "intoInt", "", "FeedList", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum LarkFeedListViewObjectLiveQueryFieldType extends Enum<LarkFeedListViewObjectLiveQueryFieldType> {
    public static final a Companion = null;
    public static final LarkFeedListViewObjectLiveQueryFieldType FeedList = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkFeedListViewObjectLiveQueryFieldType[] f253137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253138b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253139a = null;

        static {
            int[] r100 = new int[LarkFeedListViewObjectLiveQueryFieldType.values().length];
            r100[LarkFeedListViewObjectLiveQueryFieldType.FeedList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f253139a = r100;
        }
    }

    public static EnumEntries<LarkFeedListViewObjectLiveQueryFieldType> getEntries() {
        return f253138b;
    }

    public static LarkFeedListViewObjectLiveQueryFieldType valueOf(String r100) {
        return (LarkFeedListViewObjectLiveQueryFieldType) r27.a.a(LarkFeedListViewObjectLiveQueryFieldType.class, r100);
    }

    public static LarkFeedListViewObjectLiveQueryFieldType[] values() {
        return (LarkFeedListViewObjectLiveQueryFieldType[]) f253137a.clone();
    }

    static {
        LarkFeedListViewObjectLiveQueryFieldType r100 = new LarkFeedListViewObjectLiveQueryFieldType();
        FeedList = r100;
        LarkFeedListViewObjectLiveQueryFieldType[] r101 = {r100};
        f253137a = r101;
        f253138b = EnumEntriesKt.enumEntries(r101);
        Companion = new a();
    }

    public LarkFeedListViewObjectLiveQueryFieldType() {
        super("FeedList", 0);
    }

    public final lark_biz_feed.proto.LarkFeedListViewObjectLiveQueryFieldType into() {
        if (b.f253139a[ordinal()] != 1) goto L7;
        return lark_biz_feed.proto.LarkFeedListViewObjectLiveQueryFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final int intoInt() {
        if (b.f253139a[ordinal()] != 1) goto L7;
        return 0;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final LarkFeedListViewObjectLiveQueryFieldType fromInt(int r100) {
        Companion.getClass();
        if (r100 != 0) goto L7;
        return FeedList;
    L7:
        throw new RuntimeException("Unmatched primitive enum value: LarkFeedListViewObjectLiveQueryFieldType with ");
    }
}
