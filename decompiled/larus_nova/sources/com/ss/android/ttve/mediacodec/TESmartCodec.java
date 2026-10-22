package com.ss.android.ttve.mediacodec;

/* JADX INFO: loaded from: classes38.dex */
public final class TESmartCodec {

    public static final enum InputMode extends Enum<InputMode> {
        public static final InputMode BUFFER_RGBA = null;
        public static final InputMode BUFFER_YUV = null;
        public static final InputMode SURFACE_RGBA = null;
        public static final InputMode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InputMode[] f449885a = null;

        static {
            InputMode r100 = new InputMode("UNKNOWN", 0);
            UNKNOWN = r100;
            InputMode r101 = new InputMode("SURFACE_RGBA", 1);
            SURFACE_RGBA = r101;
            InputMode r102 = new InputMode("BUFFER_YUV", 2);
            BUFFER_YUV = r102;
            InputMode r103 = new InputMode("BUFFER_RGBA", 3);
            BUFFER_RGBA = r103;
            f449885a = new InputMode[]{r100, r101, r102, r103};
        }

        public static InputMode[] values() {
            return (InputMode[]) f449885a.clone();
        }

        public static InputMode valueOf(String r100) {
            return (InputMode) r27.a.a(InputMode.class, r100);
        }

        public InputMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Preset extends Enum<Preset> {
        public static final Preset FAST = null;
        public static final Preset MEDIUM = null;
        public static final Preset SLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Preset[] f449886a = null;

        static {
            Preset r100 = new Preset("SLOW", 0);
            SLOW = r100;
            Preset r101 = new Preset("MEDIUM", 1);
            MEDIUM = r101;
            Preset r102 = new Preset("FAST", 2);
            FAST = r102;
            f449886a = new Preset[]{r100, r101, r102};
        }

        public static Preset[] values() {
            return (Preset[]) f449886a.clone();
        }

        public static Preset valueOf(String r100) {
            return (Preset) r27.a.a(Preset.class, r100);
        }

        public Preset(String r100, int r101) {
            super(r100, r101);
        }
    }
}
