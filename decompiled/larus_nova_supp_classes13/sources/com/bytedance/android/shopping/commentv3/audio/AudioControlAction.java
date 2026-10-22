package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/AudioControlAction;", "", "PLAY", "STOP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudioControlAction extends Enum<AudioControlAction> {
    public static final AudioControlAction PLAY = null;
    public static final AudioControlAction STOP = null;
    public static final /* synthetic */ AudioControlAction[] a = null;

    static {
        AudioControlAction r1 = new AudioControlAction("PLAY", 0);
        PLAY = r1;
        AudioControlAction r2 = new AudioControlAction("STOP", 1);
        STOP = r2;
        a = new AudioControlAction[]{r1, r2};
    }

    public static AudioControlAction valueOf(String r1) {
        return (AudioControlAction) r27.a.a(AudioControlAction.class, r1);
    }

    public static AudioControlAction[] values() {
        return (AudioControlAction[]) a.clone();
    }

    public AudioControlAction(String r1, int r2) {
        super(r1, r2);
    }
}
