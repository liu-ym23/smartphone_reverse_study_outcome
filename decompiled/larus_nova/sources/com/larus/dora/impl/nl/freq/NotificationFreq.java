package com.larus.dora.impl.nl.freq;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/nl/freq/NotificationFreq;", "", "freq", "", "descResId", "<init>", "(Ljava/lang/String;III)V", "getFreq", "()I", "getDescResId", "NOTIFICATION_FREQ_5", "NOTIFICATION_FREQ_10", "NOTIFICATION_FREQ_15", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotificationFreq extends Enum<NotificationFreq> {
    public static final a Companion = null;
    public static final NotificationFreq NOTIFICATION_FREQ_10 = null;
    public static final NotificationFreq NOTIFICATION_FREQ_15 = null;
    public static final NotificationFreq NOTIFICATION_FREQ_5 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationFreq[] f336258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336259b = null;
    private final int descResId;
    private final int freq;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<NotificationFreq> getEntries() {
        return f336259b;
    }

    static {
        NotificationFreq r100 = new NotificationFreq("NOTIFICATION_FREQ_5", 0, 5, R.string.larus_dora_broadcast_summary_frequency_seconds_5_cn);
        NOTIFICATION_FREQ_5 = r100;
        NotificationFreq r101 = new NotificationFreq("NOTIFICATION_FREQ_10", 1, 10, R.string.larus_dora_broadcast_summary_frequency_seconds_10_cn);
        NOTIFICATION_FREQ_10 = r101;
        NotificationFreq r102 = new NotificationFreq("NOTIFICATION_FREQ_15", 2, 15, R.string.larus_dora_broadcast_summary_frequency_seconds_15_cn);
        NOTIFICATION_FREQ_15 = r102;
        NotificationFreq[] r103 = {r100, r101, r102};
        f336258a = r103;
        f336259b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static NotificationFreq[] values() {
        return (NotificationFreq[]) f336258a.clone();
    }

    public final int getDescResId() {
        return this.descResId;
    }

    public final int getFreq() {
        return this.freq;
    }

    public static NotificationFreq valueOf(String r100) {
        return (NotificationFreq) r27.a.a(NotificationFreq.class, r100);
    }

    public NotificationFreq(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.freq = r102;
        this.descResId = r103;
    }
}
