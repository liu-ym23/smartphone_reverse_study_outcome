package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxSSRHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSRHydrateStatus f381670a;

    public static final enum SSRHydrateStatus extends Enum<SSRHydrateStatus> {
        public static final SSRHydrateStatus EXECUTING = null;
        public static final SSRHydrateStatus FAILED = null;
        public static final SSRHydrateStatus PENDING = null;
        public static final SSRHydrateStatus STARTED = null;
        public static final SSRHydrateStatus SUCCESSFUL = null;
        public static final SSRHydrateStatus UNDEFINED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SSRHydrateStatus[] f381671a = null;

        static {
            SSRHydrateStatus r100 = new SSRHydrateStatus("UNDEFINED", 0);
            UNDEFINED = r100;
            SSRHydrateStatus r101 = new SSRHydrateStatus("PENDING", 1);
            PENDING = r101;
            SSRHydrateStatus r102 = new SSRHydrateStatus("STARTED", 2);
            STARTED = r102;
            SSRHydrateStatus r103 = new SSRHydrateStatus("EXECUTING", 3);
            EXECUTING = r103;
            SSRHydrateStatus r104 = new SSRHydrateStatus("FAILED", 4);
            FAILED = r104;
            SSRHydrateStatus r105 = new SSRHydrateStatus("SUCCESSFUL", 5);
            SUCCESSFUL = r105;
            f381671a = new SSRHydrateStatus[]{r100, r101, r102, r103, r104, r105};
        }

        public static SSRHydrateStatus[] values() {
            return (SSRHydrateStatus[]) f381671a.clone();
        }

        public static SSRHydrateStatus valueOf(String r100) {
            return (SSRHydrateStatus) r27.a.a(SSRHydrateStatus.class, r100);
        }

        public SSRHydrateStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxSSRHelper() {
        this.f381670a = SSRHydrateStatus.UNDEFINED;
    }
}
