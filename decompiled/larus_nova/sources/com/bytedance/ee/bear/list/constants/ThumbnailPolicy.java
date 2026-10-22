package com.bytedance.ee.bear.list.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/list/constants/ThumbnailPolicy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NEAR", "ALLOW_UP_DEFAULT", "ALLOW_DOWN_DEFAULT", "Companion", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThumbnailPolicy extends Enum<ThumbnailPolicy> {
    public static final ThumbnailPolicy ALLOW_DOWN_DEFAULT = null;
    public static final ThumbnailPolicy ALLOW_UP_DEFAULT = null;
    public static final a Companion = null;
    public static final ThumbnailPolicy NEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThumbnailPolicy[] f227693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f227694b = null;
    private final int value;

    public static EnumEntries<ThumbnailPolicy> getEntries() {
        return f227694b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.constants.ThumbnailPolicy$a] */
    static {
        ThumbnailPolicy r100 = new ThumbnailPolicy("NEAR", 0, 1);
        NEAR = r100;
        ThumbnailPolicy r101 = new ThumbnailPolicy("ALLOW_UP_DEFAULT", 1, 4);
        ALLOW_UP_DEFAULT = r101;
        ThumbnailPolicy r102 = new ThumbnailPolicy("ALLOW_DOWN_DEFAULT", 2, 5);
        ALLOW_DOWN_DEFAULT = r102;
        ThumbnailPolicy[] r103 = {r100, r101, r102};
        f227693a = r103;
        f227694b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ThumbnailPolicy[] values() {
        return (ThumbnailPolicy[]) f227693a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ThumbnailPolicy valueOf(String r100) {
        return (ThumbnailPolicy) r27.a.a(ThumbnailPolicy.class, r100);
    }

    public ThumbnailPolicy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
