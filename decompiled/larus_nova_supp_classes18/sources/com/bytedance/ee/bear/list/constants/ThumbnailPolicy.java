package com.bytedance.ee.bear.list.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/list/constants/ThumbnailPolicy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NEAR", "ALLOW_UP_DEFAULT", "ALLOW_DOWN_DEFAULT", "Companion", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThumbnailPolicy extends Enum<ThumbnailPolicy> {
    public static final ThumbnailPolicy ALLOW_DOWN_DEFAULT = null;
    public static final ThumbnailPolicy ALLOW_UP_DEFAULT = null;
    public static final a Companion = null;
    public static final ThumbnailPolicy NEAR = null;
    public static final /* synthetic */ ThumbnailPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ThumbnailPolicy> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.constants.ThumbnailPolicy$a] */
    static {
        ThumbnailPolicy r0 = new ThumbnailPolicy("NEAR", 0, 1);
        NEAR = r0;
        ThumbnailPolicy r1 = new ThumbnailPolicy("ALLOW_UP_DEFAULT", 1, 4);
        ALLOW_UP_DEFAULT = r1;
        ThumbnailPolicy r4 = new ThumbnailPolicy("ALLOW_DOWN_DEFAULT", 2, 5);
        ALLOW_DOWN_DEFAULT = r4;
        ThumbnailPolicy[] r5 = {r0, r1, r4};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ThumbnailPolicy[] values() {
        return (ThumbnailPolicy[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ThumbnailPolicy valueOf(String r1) {
        return (ThumbnailPolicy) r27.a.a(ThumbnailPolicy.class, r1);
    }

    public ThumbnailPolicy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
