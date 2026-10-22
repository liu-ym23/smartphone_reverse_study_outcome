package im;

import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f490388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f490389b = null;

    static {
        int[] r100 = new int[LiveVolume.values().length];
        r100[LiveVolume.MUTE.ordinal()] = 1;
        r100[LiveVolume.UNMUTE.ordinal()] = 2;
        int[] r101 = new int[FloatWindowState.values().length];
        f490388a = r101;
        FloatWindowState r102 = FloatWindowState.OPEN;
        r101[r102.ordinal()] = 1;
        FloatWindowState r103 = FloatWindowState.STOP;
        r101[r103.ordinal()] = 2;
        int[] r104 = new int[FloatWindowState.values().length];
        f490389b = r104;
        r104[r102.ordinal()] = 1;
        r104[r103.ordinal()] = 2;
    }
}
