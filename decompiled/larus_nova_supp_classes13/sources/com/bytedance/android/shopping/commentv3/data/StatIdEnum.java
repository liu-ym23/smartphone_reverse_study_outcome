package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/StatIdEnum;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "INVALID", "ALL", "PIC_VIDEO", "VERY_GOOD", "JUST_SO_SO", "APPEND_COMMENT", "BAD", "NEWEST", "JUST_SO_SO_OR_BAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StatIdEnum extends Enum<StatIdEnum> {
    public static final StatIdEnum ALL = null;
    public static final StatIdEnum APPEND_COMMENT = null;
    public static final StatIdEnum BAD = null;
    public static final StatIdEnum INVALID = null;
    public static final StatIdEnum JUST_SO_SO = null;
    public static final StatIdEnum JUST_SO_SO_OR_BAD = null;
    public static final StatIdEnum NEWEST = null;
    public static final StatIdEnum PIC_VIDEO = null;
    public static final StatIdEnum VERY_GOOD = null;
    public static final /* synthetic */ StatIdEnum[] a = null;
    private long id;

    public static StatIdEnum valueOf(String r1) {
        return (StatIdEnum) r27.a.a(StatIdEnum.class, r1);
    }

    public static StatIdEnum[] values() {
        return (StatIdEnum[]) a.clone();
    }

    static {
        StatIdEnum r1 = new StatIdEnum("INVALID", 0, -1);
        INVALID = r1;
        StatIdEnum r2 = new StatIdEnum("ALL", 1, 1);
        ALL = r2;
        StatIdEnum r3 = new StatIdEnum("PIC_VIDEO", 2, 2);
        PIC_VIDEO = r3;
        StatIdEnum r4 = new StatIdEnum("VERY_GOOD", 3, 3);
        VERY_GOOD = r4;
        StatIdEnum r5 = new StatIdEnum("JUST_SO_SO", 4, 4);
        JUST_SO_SO = r5;
        StatIdEnum r6 = new StatIdEnum("APPEND_COMMENT", 5, 5);
        APPEND_COMMENT = r6;
        StatIdEnum r7 = new StatIdEnum("BAD", 6, 6);
        BAD = r7;
        StatIdEnum r8 = new StatIdEnum("NEWEST", 7, 7);
        NEWEST = r8;
        StatIdEnum r9 = new StatIdEnum("JUST_SO_SO_OR_BAD", 8, 8);
        JUST_SO_SO_OR_BAD = r9;
        a = new StatIdEnum[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public StatIdEnum(String r1, int r2, long r3) {
        super(r1, r2);
        this.id = r3;
    }
}
