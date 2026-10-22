package pi1;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import ls2.c;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<d, c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bp2.a f529318g;

    @Override // gs2.a
    public final String taskID() {
        return "PrivacyLeakDectorInitTask";
    }

    public a() {
        this.f529318g = null;
    }

    @Override // gs2.a
    public final void run() {
        d r100 = h();
        if (r100 == null) goto L8;
        bp2.a r101 = this.f529318g;
        if (r101 == null) goto L9;
        r101.a((FragmentActivity) r100.f510523l);
        return;
    L9:
        return;
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
