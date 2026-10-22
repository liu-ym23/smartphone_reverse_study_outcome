package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public abstract class VEDataSource {

    public static final enum OutputMode extends Enum<OutputMode> {
        public static final OutputMode Encode = null;
        public static final OutputMode Render = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OutputMode[] f455534a = null;

        static {
            OutputMode r100 = new OutputMode("Render", 0);
            Render = r100;
            OutputMode r101 = new OutputMode("Encode", 1);
            Encode = r101;
            f455534a = new OutputMode[]{r100, r101};
        }

        public static OutputMode[] values() {
            return (OutputMode[]) f455534a.clone();
        }

        public static OutputMode valueOf(String r100) {
            return (OutputMode) r27.a.a(OutputMode.class, r100);
        }

        public OutputMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VEDataSource() {
        OutputMode r100 = OutputMode.Render;
    }
}
