package lk0;

import android.content.Context;
import bn0.b;
import com.bytedance.android.live.livelink.guestlink.GuestLinkService;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements o, jb6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f509539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f509540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fc6.a f509541c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // jb6.a
    public final GuestLinkService Bo(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GuestLinkService(r100, r101, this.f509541c, this.f509539a);
    }

    @Override // jb6.a
    public final MultiLinkService wi(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new MultiLinkService(r100, r101, this.f509541c, this.f509539a);
    }

    public a(b r100, g r101, fc6.a r102) {
        Intrinsics.checkNotNullParameter(r100, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "hostService");
        this.f509539a = r100;
        this.f509540b = r101;
        this.f509541c = r102;
    }
}
