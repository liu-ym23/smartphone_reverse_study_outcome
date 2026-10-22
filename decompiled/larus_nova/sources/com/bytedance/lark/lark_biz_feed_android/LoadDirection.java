package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/LoadDirection;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/LoadDirection;", "intoInt", "", "Next", "Previous", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum LoadDirection extends Enum<LoadDirection> {
    public static final a Companion = null;
    public static final LoadDirection Next = null;
    public static final LoadDirection Previous = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadDirection[] f253140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253141b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253142a = null;

        static {
            int[] r100 = new int[LoadDirection.values().length];
            r100[LoadDirection.Next.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LoadDirection.Previous.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253142a = r100;
        }
    }

    public static EnumEntries<LoadDirection> getEntries() {
        return f253141b;
    }

    public static LoadDirection valueOf(String r100) {
        return (LoadDirection) r27.a.a(LoadDirection.class, r100);
    }

    public static LoadDirection[] values() {
        return (LoadDirection[]) f253140a.clone();
    }

    static {
        LoadDirection r100 = new LoadDirection("Next", 0);
        Next = r100;
        LoadDirection r101 = new LoadDirection("Previous", 1);
        Previous = r101;
        LoadDirection[] r102 = {r100, r101};
        f253140a = r102;
        f253141b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final lark_biz_feed.proto.LoadDirection into() {
        int r100 = b.f253142a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return lark_biz_feed.proto.LoadDirection.VAR_LOAD_DIRECTION_PREVIOUS;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_biz_feed.proto.LoadDirection.VAR_LOAD_DIRECTION_NEXT;
    }

    public final int intoInt() {
        int r100 = b.f253142a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final LoadDirection fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return Previous;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: LoadDirection with ");
    L10:
        return Next;
    }

    public LoadDirection(String r100, int r101) {
        super(r100, r101);
    }
}
