package com.ss.android.ttvecamera.actionsound;

import android.media.MediaActionSound;

/* JADX INFO: loaded from: classes38.dex */
public class VEMediaActionSound implements ITEMediaActionSound {
    private MediaActionSound mediaActionSound;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.actionsound.VEMediaActionSound$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType = null;

        static {
            int[] r100 = new int[VEMediaActionSoundType.values().length];
            $SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType = r100;
            r100[VEMediaActionSoundType.SHUTTER_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType[VEMediaActionSoundType.FOCUS_COMPLETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType[VEMediaActionSoundType.START_VIDEO_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType[VEMediaActionSoundType.STOP_VIDEO_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // com.ss.android.ttvecamera.actionsound.ITEMediaActionSound
    public void release() {
        this.mediaActionSound.release();
    }

    public VEMediaActionSound() {
        this.mediaActionSound = null;
        this.mediaActionSound = new MediaActionSound();
    }

    private int getInternalSoundName(VEMediaActionSoundType r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$actionsound$VEMediaActionSoundType[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 == 4) goto L12;
        return -1;
    L12:
        return 3;
    }

    @Override // com.ss.android.ttvecamera.actionsound.ITEMediaActionSound
    public void play(VEMediaActionSoundType r100) {
        int r101 = getInternalSoundName(r100);
        if (r101 >= 0) goto L5;
        return;
    L5:
        this.mediaActionSound.play(r101);
    }

    @Override // com.ss.android.ttvecamera.actionsound.ITEMediaActionSound
    public void preload(VEMediaActionSoundType r100) {
        int r101 = getInternalSoundName(r100);
        if (r101 >= 0) goto L5;
        return;
    L5:
        this.mediaActionSound.load(r101);
    }
}
