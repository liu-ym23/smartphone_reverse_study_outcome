package com.larus.platform.service.watermark;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class LocalImageWatermarkRequest extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f365823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputPreference f365824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadWatermarkScene f365825c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/service/watermark/LocalImageWatermarkRequest$OutputPreference;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_AS_INPUT", "AS_BITMAP", "AS_PATH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OutputPreference extends Enum<OutputPreference> {
        public static final OutputPreference AS_BITMAP = null;
        public static final OutputPreference AS_PATH = null;
        public static final OutputPreference SAME_AS_INPUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OutputPreference[] f365826a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f365827b = null;

        public static EnumEntries<OutputPreference> getEntries() {
            return f365827b;
        }

        static {
            OutputPreference r100 = new OutputPreference("SAME_AS_INPUT", 0);
            SAME_AS_INPUT = r100;
            OutputPreference r101 = new OutputPreference("AS_BITMAP", 1);
            AS_BITMAP = r101;
            OutputPreference r102 = new OutputPreference("AS_PATH", 2);
            AS_PATH = r102;
            OutputPreference[] r103 = {r100, r101, r102};
            f365826a = r103;
            f365827b = EnumEntriesKt.enumEntries(r103);
        }

        public static OutputPreference[] values() {
            return (OutputPreference[]) f365826a.clone();
        }

        public static OutputPreference valueOf(String r100) {
            return (OutputPreference) r27.a.a(OutputPreference.class, r100);
        }

        public OutputPreference(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalImageWatermarkRequest) == true) goto L8;
        return false;
    L8:
        LocalImageWatermarkRequest r101 = (LocalImageWatermarkRequest) r100;
        if (Intrinsics.areEqual(this.f365823a, r101.f365823a) == true) goto L12;
        return false;
    L12:
        if (this.f365824b == r101.f365824b) goto L15;
        return false;
    L15:
        if (this.f365825c == r101.f365825c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f365823a.hashCode() * 31) + this.f365824b.hashCode()) * 31) + this.f365825c.hashCode();
    }

    public final String toString() {
        return "LocalImageWatermarkRequest(input=" + this.f365823a + ", preferOutput=" + this.f365824b + ", scene=" + this.f365825c + ')';
    }

    public LocalImageWatermarkRequest(b r100, OutputPreference r101, DownloadWatermarkScene r102) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "preferOutput");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f365823a = r100;
        this.f365824b = r101;
        this.f365825c = r102;
    }
}
