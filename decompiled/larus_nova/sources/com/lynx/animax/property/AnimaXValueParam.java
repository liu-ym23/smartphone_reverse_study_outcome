package com.lynx.animax.property;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXValueParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f380394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f380395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Number f380396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f380397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f380398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f380399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f380400g;

    public static final enum Type extends Enum<Type> {
        public static final Type BOOLEAN = null;
        public static final Type COLOR = null;
        public static final Type COLOR_FILTER = null;
        public static final Type COORDINATE = null;
        public static final Type NULL = null;
        public static final Type NUMBER = null;
        public static final Type STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f380401a = null;

        static {
            Type r100 = new Type("STRING", 0);
            STRING = r100;
            Type r101 = new Type("NUMBER", 1);
            NUMBER = r101;
            Type r102 = new Type("BOOLEAN", 2);
            BOOLEAN = r102;
            Type r103 = new Type("COORDINATE", 3);
            COORDINATE = r103;
            Type r104 = new Type("COLOR", 4);
            COLOR = r104;
            Type r105 = new Type("COLOR_FILTER", 5);
            COLOR_FILTER = r105;
            Type r110 = new Type("NULL", 6);
            NULL = r110;
            f380401a = new Type[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Type[] values() {
            return (Type[]) f380401a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380402a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f380402a = r100;
            r100[Type.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f380402a[Type.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f380402a[Type.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f380402a[Type.COORDINATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f380402a[Type.COLOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f380402a[Type.COLOR_FILTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f380402a[Type.NULL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f380403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f380404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f380405c;

        public b(double r100, double r101, double r102) {
            this.f380403a = r100;
            this.f380404b = r101;
            this.f380405c = r102;
        }
    }

    public boolean getBooleanValue() {
        Boolean r100 = this.f380397d;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public int getColorValue() {
        Type r100 = this.f380394a;
        boolean r101 = true;
        if (r100 != Type.COLOR) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L14:
        Integer r103 = this.f380399f;
        if (r103 != null) goto L17;
        return 0;
    L17:
        return r103.intValue();
    L8:
        if (r100 == Type.COLOR_FILTER) goto L11;
        r101 = false;
    L11:
        if (r101 == true) goto L14;
        return 0;
    L5:
        r102 = false;
        goto L6
    }

    public int getFilterMode() {
        if (this.f380394a != Type.COLOR_FILTER) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return 0;
    L8:
        return (int) getNumberValue();
    L5:
        r100 = false;
        goto L6
    }

    public double getNumberValue() {
        Number r100 = this.f380396c;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.doubleValue();
    }

    public int getTargetFrame() {
        Integer r100 = this.f380400g;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.intValue();
    }

    public int getTypeIndex() {
        return this.f380394a.ordinal();
    }

    public double getX() {
        b r100 = this.f380398e;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.f380403a;
    }

    public double getY() {
        b r100 = this.f380398e;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.f380404b;
    }

    public double getZ() {
        b r100 = this.f380398e;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.f380405c;
    }

    public final String toString() {
        int r100 = getTargetFrame();
        switch(a.f380402a[this.f380394a.ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        return "AnimaXValueParam{unknown}";
    L7:
        return "AnimaXValueParam{null, targetFrame=" + r100 + i.f25855d;
    L9:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", mode=" + getNumberValue() + ", targetFrame=" + r100 + i.f25855d;
    L11:
        return "AnimaXValueParam{colorValue=" + getColorValue() + ", targetFrame=" + r100 + i.f25855d;
    L13:
        return "AnimaXValueParam{coordinateValue=(" + getX() + "," + getY() + "," + getZ() + "), targetFrame=" + r100 + i.f25855d;
    L15:
        return "AnimaXValueParam{booleanValue=" + getBooleanValue() + ", targetFrame=" + r100 + i.f25855d;
    L17:
        return "AnimaXValueParam{numberValue=" + getNumberValue() + ", targetFrame=" + r100 + i.f25855d;
    L19:
        return "AnimaXValueParam{stringValue='" + this.f380395b + "', targetFrame=" + r100 + i.f25855d;
    }

    public String getStringValue() {
        return this.f380395b;
    }

    public static AnimaXValueParam fromBoolean(boolean r100) {
        return new AnimaXValueParam(Type.BOOLEAN, null, null, Boolean.valueOf(r100), null, null);
    }

    public static AnimaXValueParam fromColor(int r100) {
        return new AnimaXValueParam(Type.COLOR, null, null, null, null, Integer.valueOf(r100));
    }

    public static AnimaXValueParam fromNumber(double r100) {
        return new AnimaXValueParam(Type.NUMBER, null, Double.valueOf(r100), null, null, null);
    }

    public static AnimaXValueParam fromString(String r100) {
        return new AnimaXValueParam(Type.STRING, r100, null, null, null, null);
    }

    public static AnimaXValueParam a(double r110, double r111) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new b(r110, r111, AudioStats.AUDIO_AMPLITUDE_NONE), null);
    }

    public static AnimaXValueParam fromColorFilter(int r100, int r101) {
        return new AnimaXValueParam(Type.COLOR_FILTER, null, Double.valueOf(r101), null, null, Integer.valueOf(r100));
    }

    public static AnimaXValueParam fromCoordinate(double r110, double r111, double r112) {
        return new AnimaXValueParam(Type.COORDINATE, null, null, null, new b(r110, r111, r112), null);
    }

    public AnimaXValueParam(Type r100, String r101, Number r102, Boolean r103, b r104, Integer r105) {
        this.f380394a = r100;
        this.f380395b = r101;
        this.f380396c = r102;
        this.f380397d = r103;
        this.f380398e = r104;
        this.f380399f = r105;
        this.f380400g = null;
    }
}
