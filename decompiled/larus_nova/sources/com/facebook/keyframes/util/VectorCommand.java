package com.facebook.keyframes.util;

import com.facebook.keyframes.KFPath;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public abstract class VectorCommand {
    private static final String SVG_ARG_DELIMITER = ",";
    final ArgFormat mArgFormat;
    final float[] mArgs;
    private float[] mRecyclableArgArray;

    /* JADX INFO: renamed from: com.facebook.keyframes.util.VectorCommand$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat = null;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand = null;

        static {
            int[] r100 = new int[ArgFormat.values().length];
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat = r100;
            r100[ArgFormat.RELATIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat[ArgFormat.ABSOLUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L6:
            int[] r101 = new int[SVGCommand.values().length];
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand = r101;
            r101[SVGCommand.f274107m.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.M.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L44:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.f274108q.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L28:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.Q.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.f274105c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L40:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.C.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L32:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.f274106l.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L38:
            $SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[SVGCommand.L.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static final enum ArgFormat extends Enum<ArgFormat> {
        private static final /* synthetic */ ArgFormat[] $VALUES = null;
        public static final ArgFormat ABSOLUTE = null;
        public static final ArgFormat RELATIVE = null;

        static {
            ArgFormat r100 = new ArgFormat("RELATIVE", 0);
            RELATIVE = r100;
            ArgFormat r101 = new ArgFormat("ABSOLUTE", 1);
            ABSOLUTE = r101;
            $VALUES = new ArgFormat[]{r100, r101};
        }

        public static ArgFormat[] values() {
            return (ArgFormat[]) $VALUES.clone();
        }

        public static ArgFormat valueOf(String r100) {
            return (ArgFormat) Enum.valueOf(ArgFormat.class, r100);
        }

        private ArgFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class CubicToCommand extends VectorCommand {
        @Override // com.facebook.keyframes.util.VectorCommand
        public void apply(KFPath r100) {
            applyInner(r100, this.mArgFormat, this.mArgs);
        }

        public CubicToCommand(ArgFormat r100, float[] r101) {
            super(r100, r101);
        }

        @Override // com.facebook.keyframes.util.VectorCommand
        public void applyInner(KFPath r110, ArgFormat r111, float[] r112) {
            int r100 = AnonymousClass1.$SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat[r111.ordinal()];
            if (r100 == 1) goto L8;
            if (r100 != 2) goto L7;
            r110.cubicTo(r112[0], r112[1], r112[2], r112[3], r112[4], r112[5]);
            return;
        L7:
            throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{r111}));
        L8:
            r110.rCubicTo(r112[0], r112[1], r112[2], r112[3], r112[4], r112[5]);
        }
    }

    public static class LineToCommand extends VectorCommand {
        @Override // com.facebook.keyframes.util.VectorCommand
        public void apply(KFPath r100) {
            applyInner(r100, this.mArgFormat, this.mArgs);
        }

        public LineToCommand(ArgFormat r100, float[] r101) {
            super(r100, r101);
        }

        @Override // com.facebook.keyframes.util.VectorCommand
        public void applyInner(KFPath r100, ArgFormat r101, float[] r102) {
            int r103 = AnonymousClass1.$SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat[r101.ordinal()];
            if (r103 != 1) goto L5;
            r100.rLineTo(r102[0], r102[1]);
            return;
        L5:
            if (r103 != 2) goto L8;
            r100.lineTo(r102[0], r102[1]);
            return;
        L8:
            throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{r101}));
        }
    }

    public static class MoveToCommand extends VectorCommand {
        @Override // com.facebook.keyframes.util.VectorCommand
        public void apply(KFPath r100) {
            applyInner(r100, this.mArgFormat, this.mArgs);
        }

        public MoveToCommand(ArgFormat r100, float[] r101) {
            super(r100, r101);
        }

        @Override // com.facebook.keyframes.util.VectorCommand
        public void applyInner(KFPath r100, ArgFormat r101, float[] r102) {
            int r103 = AnonymousClass1.$SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat[r101.ordinal()];
            if (r103 != 1) goto L5;
            r100.rMoveTo(r102[0], r102[1]);
            return;
        L5:
            if (r103 != 2) goto L8;
            r100.moveTo(r102[0], r102[1]);
            return;
        L8:
            throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{r101}));
        }

        @Override // com.facebook.keyframes.util.VectorCommand
        public void interpolate(VectorCommand r100, float r101, KFPath r102) {
            if ((r100 instanceof MoveToCommand) == false) goto L7;
            super.interpolate(r100, r101, r102);
            return;
        L7:
            throw new IllegalArgumentException("MoveToCommand should only be interpolated with other instances of MoveToCommand");
        }
    }

    public static class QuadraticToCommand extends VectorCommand {
        @Override // com.facebook.keyframes.util.VectorCommand
        public void apply(KFPath r100) {
            applyInner(r100, this.mArgFormat, this.mArgs);
        }

        public QuadraticToCommand(ArgFormat r100, float[] r101) {
            super(r100, r101);
        }

        @Override // com.facebook.keyframes.util.VectorCommand
        public void applyInner(KFPath r100, ArgFormat r101, float[] r102) {
            int r103 = AnonymousClass1.$SwitchMap$com$facebook$keyframes$util$VectorCommand$ArgFormat[r101.ordinal()];
            if (r103 == 1) goto L8;
            if (r103 != 2) goto L7;
            r100.quadTo(r102[0], r102[1], r102[2], r102[3]);
            return;
        L7:
            throw new IllegalArgumentException(String.format(Locale.US, "No such argument format %s", new Object[]{r101}));
        L8:
            r100.rQuadTo(r102[0], r102[1], r102[2], r102[3]);
        }
    }

    public static final enum SVGCommand extends Enum<SVGCommand> {
        private static final /* synthetic */ SVGCommand[] $VALUES = null;
        public static final SVGCommand C = null;
        public static final SVGCommand L = null;
        public static final SVGCommand M = null;
        public static final SVGCommand Q = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SVGCommand f274105c = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final SVGCommand f274106l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final SVGCommand f274107m = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final SVGCommand f274108q = null;
        public final int argCount;
        public final ArgFormat argFormat;

        static {
            ArgFormat r100 = ArgFormat.RELATIVE;
            SVGCommand r101 = new SVGCommand("m", 0, r100, 2);
            f274107m = r101;
            ArgFormat r102 = ArgFormat.ABSOLUTE;
            SVGCommand r103 = new SVGCommand("M", 1, r102, 2);
            M = r103;
            SVGCommand r104 = new SVGCommand("q", 2, r100, 4);
            f274108q = r104;
            SVGCommand r105 = new SVGCommand("Q", 3, r102, 4);
            Q = r105;
            SVGCommand r110 = new SVGCommand("c", 4, r100, 6);
            f274105c = r110;
            SVGCommand r111 = new SVGCommand("C", 5, r102, 6);
            C = r111;
            SVGCommand r112 = new SVGCommand("l", 6, r100, 2);
            f274106l = r112;
            SVGCommand r106 = new SVGCommand("L", 7, r102, 2);
            L = r106;
            $VALUES = new SVGCommand[]{r101, r103, r104, r105, r110, r111, r112, r106};
        }

        public static SVGCommand[] values() {
            return (SVGCommand[]) $VALUES.clone();
        }

        public static SVGCommand valueOf(String r100) {
            return (SVGCommand) Enum.valueOf(SVGCommand.class, r100);
        }

        private SVGCommand(String r100, int r101, ArgFormat r102, int r103) {
            super(r100, r101);
            this.argFormat = r102;
            this.argCount = r103;
        }
    }

    private static float interpolateValue(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    public abstract void apply(KFPath r100);

    public abstract void applyInner(KFPath r100, ArgFormat r101, float[] r102);

    private int getArgumentCount() {
        return this.mArgs.length;
    }

    private float[] getRecyclableArgArray() {
        if (this.mRecyclableArgArray != null) goto L6;
        this.mRecyclableArgArray = new float[this.mArgs.length];
    L6:
        return this.mRecyclableArgArray;
    }

    public static VectorCommand createVectorCommand(String r110) {
        SVGCommand r100 = SVGCommand.valueOf(r110.substring(0, 1));
        String[] r101 = r110.substring(1).split(",");
        float[] r102 = new float[r101.length];
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102[r105] = Float.parseFloat(r101[r104]);
        r104 = r104 + 1;
        r105 = r105 + 1;
        goto L3
    L6:
        switch(AnonymousClass1.$SwitchMap$com$facebook$keyframes$util$VectorCommand$SVGCommand[r100.ordinal()]) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L8;
        };
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "Unhandled vector command: %s", new Object[]{r110}));
    L10:
        if (checkArguments(r100, r102) == false) goto L14;
        return new LineToCommand(r100.argFormat, r102);
    L14:
        throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand LineTo requires two arguments, but got %s", new Object[]{r102.toString()}));
    L16:
        if (checkArguments(r100, r102) == false) goto L20;
        return new CubicToCommand(r100.argFormat, r102);
    L20:
        throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand CubicTo requires six arguments, but got %s", new Object[]{r102.toString()}));
    L22:
        if (checkArguments(r100, r102) == false) goto L26;
        return new QuadraticToCommand(r100.argFormat, r102);
    L26:
        throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand QuadraticTo requires four arguments, but got %s", new Object[]{r102.toString()}));
    L28:
        if (checkArguments(r100, r102) == false) goto L32;
        return new MoveToCommand(r100.argFormat, r102);
    L32:
        throw new IllegalArgumentException(String.format(Locale.US, "VectorCommand MoveTo requires two arguments, but got %s", new Object[]{r102.toString()}));
    }

    public VectorCommand(ArgFormat r100, float[] r101) {
        this.mArgFormat = r100;
        this.mArgs = r101;
    }

    public static boolean checkArguments(SVGCommand r100, float[] r101) {
        if (r100.argCount != r101.length) goto L5;
        return true;
    L5:
        return false;
    }

    public static float[] convertUp(float[] r100, float[] r110, float[] r111) {
        if (r110.length >= r111.length) goto L25;
        if (r110.length != 2) goto L15;
        if (r111.length != 4) goto L10;
        r111[0] = (r100[0] + r110[0]) / 2.0f;
        r111[1] = (r100[1] + r110[1]) / 2.0f;
        r111[2] = r110[0];
        r111[3] = r110[1];
    L19:
        return r111;
    L10:
        if (r111.length != 6) goto L13;
        float r101 = r100[0];
        r111[0] = r101 + ((r110[0] - r101) / 3.0f);
        float r102 = r100[1];
        r111[1] = r102 + ((r110[1] - r102) / 3.0f);
        float r103 = r110[0];
        r111[2] = ((r100[0] - r103) / 3.0f) + r103;
        float r112 = r110[1];
        r111[3] = ((r100[1] - r112) / 3.0f) + r112;
        r111[4] = r103;
        r111[5] = r112;
        goto L19
    L13:
        throw new IllegalArgumentException(String.format("Unknown conversion from %d args to %d", new Object[]{Integer.valueOf(r110.length), Integer.valueOf(r111.length)}));
    L15:
        if (r110.length != 4) goto L23;
        if (r111.length != 6) goto L21;
        float r104 = r100[0];
        r111[0] = r104 + ((r110[0] - r104) * 0.6666667f);
        float r105 = r100[1];
        r111[1] = r105 + ((r110[1] - r105) * 0.6666667f);
        float r106 = r110[2];
        r111[2] = r106 + ((r110[0] - r106) * 0.6666667f);
        float r107 = r110[3];
        r111[3] = r107 + ((r110[1] - r107) * 0.6666667f);
        r111[4] = r110[2];
        r111[5] = r110[3];
        goto L19
    L21:
        throw new IllegalArgumentException(String.format("Unknown conversion from %d args to %d", new Object[]{Integer.valueOf(r110.length), Integer.valueOf(r111.length)}));
    L23:
        throw new IllegalArgumentException(String.format("Unknown conversion from %d args to %d", new Object[]{Integer.valueOf(r110.length), Integer.valueOf(r111.length)}));
    L25:
        throw new IllegalArgumentException("convertUp should only be called to convert a lower order argument array to a higher one.");
    }

    public void interpolate(VectorCommand r100, float r110, KFPath r111) {
        if (this.mArgFormat != r100.mArgFormat) goto L18;
        if (getArgumentCount() <= r100.getArgumentCount()) goto L9;
        float[] r101 = this.mArgs;
        float[] r102 = convertUp(r111.getLastPoint(), r100.mArgs, getRecyclableArgArray());
        float[] r103 = getRecyclableArgArray();
    L7:
        float[] r104 = r103;
        float[] r105 = r101;
        VectorCommand r106 = this;
    L12:
        int r107 = r104.length;
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L15;
        r104[r108] = interpolateValue(r105[r108], r102[r108], r110);
        r108 = r108 + 1;
        goto L13
    L15:
        r106.applyInner(r111, this.mArgFormat, r104);
        return;
    L9:
        if (getArgumentCount() >= r100.getArgumentCount()) goto L11;
        float[] r109 = convertUp(r111.getLastPoint(), this.mArgs, r100.getRecyclableArgArray());
        float[] r112 = r100.mArgs;
        r104 = r100.getRecyclableArgArray();
        r106 = r100;
        r102 = r112;
        r105 = r109;
        goto L12
    L11:
        r101 = this.mArgs;
        r102 = r100.mArgs;
        r103 = getRecyclableArgArray();
        goto L7
    L18:
        throw new IllegalArgumentException("Argument format must match between interpolated commands. RELATIVE and ABSOLUTE coordinates should stay consistent");
    }
}
