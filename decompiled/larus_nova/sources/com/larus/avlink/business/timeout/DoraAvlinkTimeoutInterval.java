package com.larus.avlink.business.timeout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/business/timeout/DoraAvlinkTimeoutInterval;", "", "seconds", "", "<init>", "(Ljava/lang/String;II)V", "getSeconds", "()I", "INTERVAL_5", "INTERVAL_8", "INTERVAL_12", "INTERVAL_15", "INTERVAL_20", "INTERVAL_30", "INTERVAL_40", "dora_business_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkTimeoutInterval extends Enum<DoraAvlinkTimeoutInterval> {
    public static final DoraAvlinkTimeoutInterval INTERVAL_12 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_15 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_20 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_30 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_40 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_5 = null;
    public static final DoraAvlinkTimeoutInterval INTERVAL_8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkTimeoutInterval[] f291706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291707b = null;
    private final int seconds;

    public static EnumEntries<DoraAvlinkTimeoutInterval> getEntries() {
        return f291707b;
    }

    static {
        DoraAvlinkTimeoutInterval r100 = new DoraAvlinkTimeoutInterval("INTERVAL_5", 0, 5);
        INTERVAL_5 = r100;
        DoraAvlinkTimeoutInterval r101 = new DoraAvlinkTimeoutInterval("INTERVAL_8", 1, 8);
        INTERVAL_8 = r101;
        DoraAvlinkTimeoutInterval r102 = new DoraAvlinkTimeoutInterval("INTERVAL_12", 2, 12);
        INTERVAL_12 = r102;
        DoraAvlinkTimeoutInterval r103 = new DoraAvlinkTimeoutInterval("INTERVAL_15", 3, 15);
        INTERVAL_15 = r103;
        DoraAvlinkTimeoutInterval r104 = new DoraAvlinkTimeoutInterval("INTERVAL_20", 4, 20);
        INTERVAL_20 = r104;
        DoraAvlinkTimeoutInterval r105 = new DoraAvlinkTimeoutInterval("INTERVAL_30", 5, 30);
        INTERVAL_30 = r105;
        DoraAvlinkTimeoutInterval r110 = new DoraAvlinkTimeoutInterval("INTERVAL_40", 6, 40);
        INTERVAL_40 = r110;
        DoraAvlinkTimeoutInterval[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f291706a = r111;
        f291707b = EnumEntriesKt.enumEntries(r111);
    }

    public static DoraAvlinkTimeoutInterval[] values() {
        return (DoraAvlinkTimeoutInterval[]) f291706a.clone();
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public static DoraAvlinkTimeoutInterval valueOf(String r100) {
        return (DoraAvlinkTimeoutInterval) r27.a.a(DoraAvlinkTimeoutInterval.class, r100);
    }

    public DoraAvlinkTimeoutInterval(String r100, int r101, int r102) {
        super(r100, r101);
        this.seconds = r102;
    }
}
