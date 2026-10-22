package com.ss.bytertc.engine.data;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MediaPlayerCustomSourceMode extends Enum<MediaPlayerCustomSourceMode> {
    private static final /* synthetic */ MediaPlayerCustomSourceMode[] $VALUES = null;
    public static final MediaPlayerCustomSourceMode PULL = null;
    public static final MediaPlayerCustomSourceMode PUSH = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode = null;

        static {
            int[] r100 = new int[MediaPlayerCustomSourceMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode = r100;
            r100[MediaPlayerCustomSourceMode.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[MediaPlayerCustomSourceMode.PULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MediaPlayerCustomSourceMode r100 = new MediaPlayerCustomSourceMode(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0, 0);
        PUSH = r100;
        MediaPlayerCustomSourceMode r101 = new MediaPlayerCustomSourceMode("PULL", 1, 1);
        PULL = r101;
        $VALUES = new MediaPlayerCustomSourceMode[]{r100, r101};
    }

    public static MediaPlayerCustomSourceMode[] values() {
        return (MediaPlayerCustomSourceMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[ordinal()];
        if (r100 != 1) goto L5;
        return FeatureConfigInfo.PUSH_FEATURE_TYPE_ID;
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "PULL";
    }

    public int value() {
        return this.value;
    }

    public static MediaPlayerCustomSourceMode fromId(int r100) {
        MediaPlayerCustomSourceMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MediaPlayerCustomSourceMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MediaPlayerCustomSourceMode valueOf(String r100) {
        return (MediaPlayerCustomSourceMode) a.a(MediaPlayerCustomSourceMode.class, r100);
    }

    private MediaPlayerCustomSourceMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
