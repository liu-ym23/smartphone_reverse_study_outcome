package com.bytedance.lark.lark_biz_feed_android;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/FeedType;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/FeedType;", "intoInt", "", CancelRetainContactInfoFunctions.All, "Inbox", "Done", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FeedType extends Enum<FeedType> {
    public static final FeedType All = null;
    public static final a Companion = null;
    public static final FeedType Done = null;
    public static final FeedType Inbox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedType[] f253131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253132b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253133a = null;

        static {
            int[] r100 = new int[FeedType.values().length];
            r100[FeedType.All.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FeedType.Inbox.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FeedType.Done.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f253133a = r100;
        }
    }

    public static EnumEntries<FeedType> getEntries() {
        return f253132b;
    }

    public static FeedType valueOf(String r100) {
        return (FeedType) r27.a.a(FeedType.class, r100);
    }

    public static FeedType[] values() {
        return (FeedType[]) f253131a.clone();
    }

    static {
        FeedType r100 = new FeedType(CancelRetainContactInfoFunctions.All, 0);
        All = r100;
        FeedType r101 = new FeedType("Inbox", 1);
        Inbox = r101;
        FeedType r102 = new FeedType("Done", 2);
        Done = r102;
        FeedType[] r103 = {r100, r101, r102};
        f253131a = r103;
        f253132b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public final lark_biz_feed.proto.FeedType into() {
        int r100 = b.f253133a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return lark_biz_feed.proto.FeedType.VAR_FEED_TYPE_DONE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return lark_biz_feed.proto.FeedType.VAR_FEED_TYPE_INBOX;
    L13:
        return lark_biz_feed.proto.FeedType.VAR_FEED_TYPE_ALL;
    }

    public final int intoInt() {
        int r100 = b.f253133a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final FeedType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L10;
        return Done;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: FeedType with ");
    L15:
        return Inbox;
    L13:
        return All;
    }

    public FeedType(String r100, int r101) {
        super(r100, r101);
    }
}
