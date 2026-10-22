package dh7;

import com.bytedance.timon.pipeline.TimonSystem;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f468623a = null;

    static {
        int[] r100 = new int[TimonSystem.InvokeType.values().length];
        f468623a = r100;
        r100[TimonSystem.InvokeType.PRE_INVOKE.ordinal()] = 1;
        r100[TimonSystem.InvokeType.POST_INVOKE.ordinal()] = 2;
        r100[TimonSystem.InvokeType.ALL.ordinal()] = 3;
    }
}
