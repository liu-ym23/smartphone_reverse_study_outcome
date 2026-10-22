package eq2;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f473458a = null;

    static {
        int[] r100 = new int[TaskState.values().length];
        f473458a = r100;
        r100[TaskState.START.ordinal()] = 1;
        r100[TaskState.COMPLETE.ordinal()] = 2;
        r100[TaskState.CANCEL.ordinal()] = 3;
    }
}
