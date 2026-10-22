package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingHistoryUploadAgeInfo {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f434658d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f434659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f434661c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/perf/appreciable/MmRecordingHistoryUploadAgeInfo$AgeBucket;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WITHIN_1H", "BETWEEN_1H_6H", "BETWEEN_6H_24H", "EXPIRED_24H", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AgeBucket extends Enum<AgeBucket> {
        public static final AgeBucket BETWEEN_1H_6H = null;
        public static final AgeBucket BETWEEN_6H_24H = null;
        public static final AgeBucket EXPIRED_24H = null;
        public static final AgeBucket UNKNOWN = null;
        public static final AgeBucket WITHIN_1H = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AgeBucket[] f434662a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434663b = null;
        private final String value;

        public static EnumEntries<AgeBucket> getEntries() {
            return f434663b;
        }

        static {
            AgeBucket r100 = new AgeBucket("WITHIN_1H", 0, "within_1h");
            WITHIN_1H = r100;
            AgeBucket r101 = new AgeBucket("BETWEEN_1H_6H", 1, "between_1h_6h");
            BETWEEN_1H_6H = r101;
            AgeBucket r102 = new AgeBucket("BETWEEN_6H_24H", 2, "between_6h_24h");
            BETWEEN_6H_24H = r102;
            AgeBucket r103 = new AgeBucket("EXPIRED_24H", 3, "expired_24h");
            EXPIRED_24H = r103;
            AgeBucket r104 = new AgeBucket("UNKNOWN", 4, "unknown");
            UNKNOWN = r104;
            AgeBucket[] r105 = {r100, r101, r102, r103, r104};
            f434662a = r105;
            f434663b = EnumEntriesKt.enumEntries(r105);
        }

        public static AgeBucket[] values() {
            return (AgeBucket[]) f434662a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AgeBucket valueOf(String r100) {
            return (AgeBucket) r27.a.a(AgeBucket.class, r100);
        }

        public AgeBucket(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingHistoryUploadAgeInfo) == true) goto L8;
        return false;
    L8:
        MmRecordingHistoryUploadAgeInfo r101 = (MmRecordingHistoryUploadAgeInfo) r100;
        if (this.f434659a == r101.f434659a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434660b, r101.f434660b) == true) goto L15;
        return false;
    L15:
        if (this.f434661c == r101.f434661c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f434659a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f434660b.hashCode()) * 31;
        if (this.f434661c == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingHistoryUploadAgeInfo(ageMs=" + this.f434659a + ", ageBucket=" + this.f434660b + ", isOver24h=" + this.f434661c + ')';
    }

    public MmRecordingHistoryUploadAgeInfo(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "ageBucket");
        this.f434659a = r100;
        this.f434660b = r101;
        this.f434661c = r102;
    }
}
