package yi1;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f567854a = null;

    static {
        int[] r100 = new int[ContainerLifecycle.values().length];
        f567854a = r100;
        r100[ContainerLifecycle.ON_VIEW_CREATE.ordinal()] = 1;
        r100[ContainerLifecycle.ON_RESUME.ordinal()] = 2;
        r100[ContainerLifecycle.ON_PAUSE.ordinal()] = 3;
        r100[ContainerLifecycle.ON_STOP.ordinal()] = 4;
        r100[ContainerLifecycle.ON_DESTROY.ordinal()] = 5;
    }
}
