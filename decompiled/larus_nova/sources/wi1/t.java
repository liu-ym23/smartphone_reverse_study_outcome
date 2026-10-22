package wi1;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;

/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ik1.b> {
    @Override // gs2.a
    public final String taskID() {
        return "SessionInnerFeedInitTask";
    }

    @Override // gs2.a
    public final void run() {
        ik1.b r100 = g();
        if (r100 == null) goto L6;
        r100.f490194k = new rn1.a();
        return;
    }

    public t() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
