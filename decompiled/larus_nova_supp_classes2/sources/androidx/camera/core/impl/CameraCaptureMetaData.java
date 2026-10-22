package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraCaptureMetaData {

    public static final enum AeMode extends Enum<AeMode> {
        private static final /* synthetic */ AeMode[] $VALUES = null;
        public static final AeMode OFF = null;
        public static final AeMode ON = null;
        public static final AeMode ON_ALWAYS_FLASH = null;
        public static final AeMode ON_AUTO_FLASH = null;
        public static final AeMode ON_AUTO_FLASH_REDEYE = null;
        public static final AeMode ON_EXTERNAL_FLASH = null;
        public static final AeMode UNKNOWN = null;

        private static /* synthetic */ AeMode[] $values() {
            return new AeMode[]{UNKNOWN, OFF, ON, ON_AUTO_FLASH, ON_ALWAYS_FLASH, ON_AUTO_FLASH_REDEYE, ON_EXTERNAL_FLASH};
        }

        static {
            UNKNOWN = new AeMode("UNKNOWN", 0);
            OFF = new AeMode("OFF", 1);
            ON = new AeMode("ON", 2);
            ON_AUTO_FLASH = new AeMode("ON_AUTO_FLASH", 3);
            ON_ALWAYS_FLASH = new AeMode("ON_ALWAYS_FLASH", 4);
            ON_AUTO_FLASH_REDEYE = new AeMode("ON_AUTO_FLASH_REDEYE", 5);
            ON_EXTERNAL_FLASH = new AeMode("ON_EXTERNAL_FLASH", 6);
            $VALUES = $values();
        }

        public static AeMode[] values() {
            return (AeMode[]) $VALUES.clone();
        }

        public static AeMode valueOf(String r1) {
            return (AeMode) r27.a.a(AeMode.class, r1);
        }

        private AeMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum AeState extends Enum<AeState> {
        private static final /* synthetic */ AeState[] $VALUES = null;
        public static final AeState CONVERGED = null;
        public static final AeState FLASH_REQUIRED = null;
        public static final AeState INACTIVE = null;
        public static final AeState LOCKED = null;
        public static final AeState SEARCHING = null;
        public static final AeState UNKNOWN = null;

        private static /* synthetic */ AeState[] $values() {
            return new AeState[]{UNKNOWN, INACTIVE, SEARCHING, FLASH_REQUIRED, CONVERGED, LOCKED};
        }

        static {
            UNKNOWN = new AeState("UNKNOWN", 0);
            INACTIVE = new AeState("INACTIVE", 1);
            SEARCHING = new AeState("SEARCHING", 2);
            FLASH_REQUIRED = new AeState("FLASH_REQUIRED", 3);
            CONVERGED = new AeState("CONVERGED", 4);
            LOCKED = new AeState("LOCKED", 5);
            $VALUES = $values();
        }

        public static AeState[] values() {
            return (AeState[]) $VALUES.clone();
        }

        public static AeState valueOf(String r1) {
            return (AeState) r27.a.a(AeState.class, r1);
        }

        private AeState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum AfMode extends Enum<AfMode> {
        private static final /* synthetic */ AfMode[] $VALUES = null;
        public static final AfMode OFF = null;
        public static final AfMode ON_CONTINUOUS_AUTO = null;
        public static final AfMode ON_MANUAL_AUTO = null;
        public static final AfMode UNKNOWN = null;

        private static /* synthetic */ AfMode[] $values() {
            return new AfMode[]{UNKNOWN, OFF, ON_MANUAL_AUTO, ON_CONTINUOUS_AUTO};
        }

        static {
            UNKNOWN = new AfMode("UNKNOWN", 0);
            OFF = new AfMode("OFF", 1);
            ON_MANUAL_AUTO = new AfMode("ON_MANUAL_AUTO", 2);
            ON_CONTINUOUS_AUTO = new AfMode("ON_CONTINUOUS_AUTO", 3);
            $VALUES = $values();
        }

        public static AfMode[] values() {
            return (AfMode[]) $VALUES.clone();
        }

        public static AfMode valueOf(String r1) {
            return (AfMode) r27.a.a(AfMode.class, r1);
        }

        private AfMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum AfState extends Enum<AfState> {
        private static final /* synthetic */ AfState[] $VALUES = null;
        public static final AfState INACTIVE = null;
        public static final AfState LOCKED_FOCUSED = null;
        public static final AfState LOCKED_NOT_FOCUSED = null;
        public static final AfState PASSIVE_FOCUSED = null;
        public static final AfState PASSIVE_NOT_FOCUSED = null;
        public static final AfState SCANNING = null;
        public static final AfState UNKNOWN = null;

        private static /* synthetic */ AfState[] $values() {
            return new AfState[]{UNKNOWN, INACTIVE, SCANNING, PASSIVE_FOCUSED, PASSIVE_NOT_FOCUSED, LOCKED_FOCUSED, LOCKED_NOT_FOCUSED};
        }

        static {
            UNKNOWN = new AfState("UNKNOWN", 0);
            INACTIVE = new AfState("INACTIVE", 1);
            SCANNING = new AfState("SCANNING", 2);
            PASSIVE_FOCUSED = new AfState("PASSIVE_FOCUSED", 3);
            PASSIVE_NOT_FOCUSED = new AfState("PASSIVE_NOT_FOCUSED", 4);
            LOCKED_FOCUSED = new AfState("LOCKED_FOCUSED", 5);
            LOCKED_NOT_FOCUSED = new AfState("LOCKED_NOT_FOCUSED", 6);
            $VALUES = $values();
        }

        public static AfState[] values() {
            return (AfState[]) $VALUES.clone();
        }

        public static AfState valueOf(String r1) {
            return (AfState) r27.a.a(AfState.class, r1);
        }

        private AfState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum AwbMode extends Enum<AwbMode> {
        private static final /* synthetic */ AwbMode[] $VALUES = null;
        public static final AwbMode AUTO = null;
        public static final AwbMode CLOUDY_DAYLIGHT = null;
        public static final AwbMode DAYLIGHT = null;
        public static final AwbMode FLUORESCENT = null;
        public static final AwbMode INCANDESCENT = null;
        public static final AwbMode OFF = null;
        public static final AwbMode SHADE = null;
        public static final AwbMode TWILIGHT = null;
        public static final AwbMode UNKNOWN = null;
        public static final AwbMode WARM_FLUORESCENT = null;

        private static /* synthetic */ AwbMode[] $values() {
            return new AwbMode[]{UNKNOWN, OFF, AUTO, INCANDESCENT, FLUORESCENT, WARM_FLUORESCENT, DAYLIGHT, CLOUDY_DAYLIGHT, TWILIGHT, SHADE};
        }

        static {
            UNKNOWN = new AwbMode("UNKNOWN", 0);
            OFF = new AwbMode("OFF", 1);
            AUTO = new AwbMode("AUTO", 2);
            INCANDESCENT = new AwbMode("INCANDESCENT", 3);
            FLUORESCENT = new AwbMode("FLUORESCENT", 4);
            WARM_FLUORESCENT = new AwbMode("WARM_FLUORESCENT", 5);
            DAYLIGHT = new AwbMode("DAYLIGHT", 6);
            CLOUDY_DAYLIGHT = new AwbMode("CLOUDY_DAYLIGHT", 7);
            TWILIGHT = new AwbMode("TWILIGHT", 8);
            SHADE = new AwbMode("SHADE", 9);
            $VALUES = $values();
        }

        public static AwbMode[] values() {
            return (AwbMode[]) $VALUES.clone();
        }

        public static AwbMode valueOf(String r1) {
            return (AwbMode) r27.a.a(AwbMode.class, r1);
        }

        private AwbMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum AwbState extends Enum<AwbState> {
        private static final /* synthetic */ AwbState[] $VALUES = null;
        public static final AwbState CONVERGED = null;
        public static final AwbState INACTIVE = null;
        public static final AwbState LOCKED = null;
        public static final AwbState METERING = null;
        public static final AwbState UNKNOWN = null;

        private static /* synthetic */ AwbState[] $values() {
            return new AwbState[]{UNKNOWN, INACTIVE, METERING, CONVERGED, LOCKED};
        }

        static {
            UNKNOWN = new AwbState("UNKNOWN", 0);
            INACTIVE = new AwbState("INACTIVE", 1);
            METERING = new AwbState("METERING", 2);
            CONVERGED = new AwbState("CONVERGED", 3);
            LOCKED = new AwbState("LOCKED", 4);
            $VALUES = $values();
        }

        public static AwbState[] values() {
            return (AwbState[]) $VALUES.clone();
        }

        public static AwbState valueOf(String r1) {
            return (AwbState) r27.a.a(AwbState.class, r1);
        }

        private AwbState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum FlashState extends Enum<FlashState> {
        private static final /* synthetic */ FlashState[] $VALUES = null;
        public static final FlashState FIRED = null;
        public static final FlashState NONE = null;
        public static final FlashState READY = null;
        public static final FlashState UNKNOWN = null;

        private static /* synthetic */ FlashState[] $values() {
            return new FlashState[]{UNKNOWN, NONE, READY, FIRED};
        }

        static {
            UNKNOWN = new FlashState("UNKNOWN", 0);
            NONE = new FlashState("NONE", 1);
            READY = new FlashState("READY", 2);
            FIRED = new FlashState("FIRED", 3);
            $VALUES = $values();
        }

        public static FlashState[] values() {
            return (FlashState[]) $VALUES.clone();
        }

        public static FlashState valueOf(String r1) {
            return (FlashState) r27.a.a(FlashState.class, r1);
        }

        private FlashState(String r1, int r2) {
            super(r1, r2);
        }
    }

    private CameraCaptureMetaData() {
    }
}
