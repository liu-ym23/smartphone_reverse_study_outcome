package oi1;

import com.bytedance.android.livesdk.config.np;
import com.bytedance.android.livesdk.config.qs0;
import com.bytedance.android.livesdk.config.tr;
import com.bytedance.android.livesdk.config.vq0;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.x5;
import ik1.g;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.room.Task.base.a<d, g> {
    @Override // gs2.a
    public final String taskID() {
        return "SettingConfigPreloadTask";
    }

    @Override // gs2.a
    public final void run() {
        g r100 = g();
        if (r100 == null) goto L5;
        r100.f490256f = qs0.f121080a.getValue().booleanValue();
    L5:
        g r101 = g();
        if (r101 == null) goto L8;
        r101.f490253c = vq0.f121471a.getValue();
    L8:
        g r102 = g();
        if (r102 == null) goto L11;
        r102.f490254d = x5.f162538a.getValue();
    L11:
        g r103 = g();
        if (r103 == null) goto L14;
        r103.f490255e = tr.f121320a.getValue();
    L14:
        float r104 = np.f120850a.getValue().getPullStreamThresholdConfig();
        if (r104 <= 0) goto L23;
        g r105 = g();
        if (r105 == null) goto L19;
        r105.f490257g = r104;
    L19:
        g r106 = g();
        if (r106 == null) goto L24;
        r106.f490258h = 1 - r104;
        return;
    L24:
        return;
    }

    public b() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
