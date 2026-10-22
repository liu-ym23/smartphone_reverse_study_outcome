package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioRoute extends Enum<AudioRoute> {
    private static final /* synthetic */ AudioRoute[] $VALUES = null;
    public static final AudioRoute AUDIO_ROUTE_DEFAULT = null;
    public static final AudioRoute AUDIO_ROUTE_EARPIECE = null;
    public static final AudioRoute AUDIO_ROUTE_HEADSET = null;
    public static final AudioRoute AUDIO_ROUTE_HEADSET_BLUETOOTH = null;
    public static final AudioRoute AUDIO_ROUTE_HEADSET_USB = null;
    public static final AudioRoute AUDIO_ROUTE_SPEAKERPHONE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioRoute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioRoute = null;

        static {
            int[] r100 = new int[AudioRoute.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute = r100;
            r100[AudioRoute.AUDIO_ROUTE_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute[AudioRoute.AUDIO_ROUTE_EARPIECE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute[AudioRoute.AUDIO_ROUTE_SPEAKERPHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute[AudioRoute.AUDIO_ROUTE_HEADSET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute[AudioRoute.AUDIO_ROUTE_HEADSET_USB.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$AudioRoute[AudioRoute.AUDIO_ROUTE_HEADSET_BLUETOOTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        AudioRoute r100 = new AudioRoute("AUDIO_ROUTE_DEFAULT", 0, -1);
        AUDIO_ROUTE_DEFAULT = r100;
        AudioRoute r101 = new AudioRoute("AUDIO_ROUTE_HEADSET", 1, 1);
        AUDIO_ROUTE_HEADSET = r101;
        AudioRoute r102 = new AudioRoute("AUDIO_ROUTE_EARPIECE", 2, 2);
        AUDIO_ROUTE_EARPIECE = r102;
        AudioRoute r103 = new AudioRoute("AUDIO_ROUTE_SPEAKERPHONE", 3, 3);
        AUDIO_ROUTE_SPEAKERPHONE = r103;
        AudioRoute r104 = new AudioRoute("AUDIO_ROUTE_HEADSET_BLUETOOTH", 4, 4);
        AUDIO_ROUTE_HEADSET_BLUETOOTH = r104;
        AudioRoute r105 = new AudioRoute("AUDIO_ROUTE_HEADSET_USB", 5, 5);
        AUDIO_ROUTE_HEADSET_USB = r105;
        $VALUES = new AudioRoute[]{r100, r101, r102, r103, r104, r105};
    }

    public static AudioRoute[] values() {
        return (AudioRoute[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioRoute[ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        return "AUDIO_ROUTE_HEADSET_BLUETOOTH";
    L6:
        return "AUDIO_ROUTE_HEADSET_USB";
    L7:
        return "AUDIO_ROUTE_HEADSET";
    L8:
        return "AUDIO_ROUTE_SPEAKERPHONE";
    L9:
        return "AUDIO_ROUTE_EARPIECE";
    L11:
        return "AUDIO_ROUTE_DEFAULT";
    }

    public int value() {
        return this.value;
    }

    public static AudioRoute fromId(int r100) {
        AudioRoute[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioRoute r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioRoute valueOf(String r100) {
        return (AudioRoute) a.a(AudioRoute.class, r100);
    }

    private AudioRoute(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
