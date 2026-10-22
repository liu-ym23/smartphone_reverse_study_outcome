package dp0;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f469565a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f469565a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 2;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.MEDIA.ordinal()] = 5;
    }
}
