package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/LarkFeedListViewObjectFieldType;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/LarkFeedListViewObjectFieldType;", "intoInt", "", "LoadStatus", "ToastStatus", "CanLoadMore", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum LarkFeedListViewObjectFieldType extends Enum<LarkFeedListViewObjectFieldType> {
    public static final LarkFeedListViewObjectFieldType CanLoadMore = null;
    public static final a Companion = null;
    public static final LarkFeedListViewObjectFieldType LoadStatus = null;
    public static final LarkFeedListViewObjectFieldType ToastStatus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkFeedListViewObjectFieldType[] f253134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253135b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253136a = null;

        static {
            int[] r100 = new int[LarkFeedListViewObjectFieldType.values().length];
            r100[LarkFeedListViewObjectFieldType.LoadStatus.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LarkFeedListViewObjectFieldType.ToastStatus.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LarkFeedListViewObjectFieldType.CanLoadMore.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f253136a = r100;
        }
    }

    public static EnumEntries<LarkFeedListViewObjectFieldType> getEntries() {
        return f253135b;
    }

    public static LarkFeedListViewObjectFieldType valueOf(String r100) {
        return (LarkFeedListViewObjectFieldType) r27.a.a(LarkFeedListViewObjectFieldType.class, r100);
    }

    public static LarkFeedListViewObjectFieldType[] values() {
        return (LarkFeedListViewObjectFieldType[]) f253134a.clone();
    }

    static {
        LarkFeedListViewObjectFieldType r100 = new LarkFeedListViewObjectFieldType("LoadStatus", 0);
        LoadStatus = r100;
        LarkFeedListViewObjectFieldType r101 = new LarkFeedListViewObjectFieldType("ToastStatus", 1);
        ToastStatus = r101;
        LarkFeedListViewObjectFieldType r102 = new LarkFeedListViewObjectFieldType("CanLoadMore", 2);
        CanLoadMore = r102;
        LarkFeedListViewObjectFieldType[] r103 = {r100, r101, r102};
        f253134a = r103;
        f253135b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public final lark_biz_feed.proto.LarkFeedListViewObjectFieldType into() {
        int r100 = b.f253136a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return lark_biz_feed.proto.LarkFeedListViewObjectFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_CAN_LOAD_MORE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return lark_biz_feed.proto.LarkFeedListViewObjectFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_TOAST_STATUS;
    L13:
        return lark_biz_feed.proto.LarkFeedListViewObjectFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS;
    }

    public final int intoInt() {
        int r100 = b.f253136a[ordinal()];
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
    public static final LarkFeedListViewObjectFieldType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L10;
        return CanLoadMore;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: LarkFeedListViewObjectFieldType with ");
    L15:
        return ToastStatus;
    L13:
        return LoadStatus;
    }

    public LarkFeedListViewObjectFieldType(String r100, int r101) {
        super(r100, r101);
    }
}
