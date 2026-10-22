package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class CocreationReviewShortcut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387121a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewShortcut$Result;", "", "<init>", "(Ljava/lang/String;I)V", "REQUESTED", "ALREADY_PINNED", "UNSUPPORTED", "FAILED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result ALREADY_PINNED = null;
        public static final Result FAILED = null;
        public static final Result REQUESTED = null;
        public static final Result UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f387122a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f387123b = null;

        public static EnumEntries<Result> getEntries() {
            return f387123b;
        }

        static {
            Result r100 = new Result("REQUESTED", 0);
            REQUESTED = r100;
            Result r101 = new Result("ALREADY_PINNED", 1);
            ALREADY_PINNED = r101;
            Result r102 = new Result("UNSUPPORTED", 2);
            UNSUPPORTED = r102;
            Result r103 = new Result("FAILED", 3);
            FAILED = r103;
            Result[] r104 = {r100, r101, r102, r103};
            f387122a = r104;
            f387123b = EnumEntriesKt.enumEntries(r104);
        }

        public static Result[] values() {
            return (Result[]) f387122a.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        public Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
