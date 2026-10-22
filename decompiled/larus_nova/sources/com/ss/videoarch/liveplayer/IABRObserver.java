package com.ss.videoarch.liveplayer;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface IABRObserver {

    public static final enum StrategySubtype extends Enum<StrategySubtype> {
        public static final StrategySubtype FakeResolution = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategySubtype[] f458612a = null;

        static {
            StrategySubtype r100 = new StrategySubtype("FakeResolution", 0);
            FakeResolution = r100;
            f458612a = new StrategySubtype[]{r100};
        }

        public static StrategySubtype[] values() {
            return (StrategySubtype[]) f458612a.clone();
        }

        public static StrategySubtype valueOf(String r100) {
            return (StrategySubtype) r27.a.a(StrategySubtype.class, r100);
        }

        private StrategySubtype(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum StrategyType extends Enum<StrategyType> {
        public static final StrategyType Bandwidth = null;
        public static final StrategyType Performance = null;
        public static final StrategyType Quality = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategyType[] f458613a = null;

        static {
            StrategyType r100 = new StrategyType("Performance", 0);
            Performance = r100;
            StrategyType r101 = new StrategyType("Bandwidth", 1);
            Bandwidth = r101;
            StrategyType r102 = new StrategyType("Quality", 2);
            Quality = r102;
            f458613a = new StrategyType[]{r100, r101, r102};
        }

        public static StrategyType[] values() {
            return (StrategyType[]) f458613a.clone();
        }

        public static StrategyType valueOf(String r100) {
            return (StrategyType) r27.a.a(StrategyType.class, r100);
        }

        private StrategyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SwitchPermissionRequestResult extends Enum<SwitchPermissionRequestResult> {
        public static final SwitchPermissionRequestResult APPROVED = null;
        public static final SwitchPermissionRequestResult REJECTED_FOR_FIXED_RESOLUTION = null;
        public static final SwitchPermissionRequestResult REJECTED_FOR_FIXED_SUGGESTED_RESOLUTION_INVALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SwitchPermissionRequestResult[] f458614a = null;

        static {
            SwitchPermissionRequestResult r100 = new SwitchPermissionRequestResult("APPROVED", 0);
            APPROVED = r100;
            SwitchPermissionRequestResult r101 = new SwitchPermissionRequestResult("REJECTED_FOR_FIXED_RESOLUTION", 1);
            REJECTED_FOR_FIXED_RESOLUTION = r101;
            SwitchPermissionRequestResult r102 = new SwitchPermissionRequestResult("REJECTED_FOR_FIXED_SUGGESTED_RESOLUTION_INVALID", 2);
            REJECTED_FOR_FIXED_SUGGESTED_RESOLUTION_INVALID = r102;
            f458614a = new SwitchPermissionRequestResult[]{r100, r101, r102};
        }

        public static SwitchPermissionRequestResult[] values() {
            return (SwitchPermissionRequestResult[]) f458614a.clone();
        }

        public static SwitchPermissionRequestResult valueOf(String r100) {
            return (SwitchPermissionRequestResult) r27.a.a(SwitchPermissionRequestResult.class, r100);
        }

        private SwitchPermissionRequestResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    void didAutomaticallySwitch(s r100, b0 r101, b0 r102, JSONObject r103);

    SwitchPermissionRequestResult shouldAutomaticallySwitch(s r100, b0 r101, b0 r102, JSONObject r103);
}
