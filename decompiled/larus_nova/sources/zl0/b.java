package zl0;

import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConditionId f572759f;

    @Override // zl0.c, t71.a
    public final Object getIdentity() {
        return this.f572759f;
    }

    @Override // t71.a
    public final boolean b(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        boolean r101 = r100 instanceof v61.a;
        return false;
    }

    public b(DataCenter r100, Long r101) {
        super(r100, r101, 0, null);
        this.f572759f = ConditionId.ANCHOR_EXIT_MIC_NOT_DISPLAY;
    }
}
