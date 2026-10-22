package dl1;

import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.u;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469098a = 0;

    static {
    }

    public static u a(VideoModel r100, long r101, ReplayVideoPositionInfo r110) {
        Intrinsics.checkNotNullParameter(r100, "videoModel");
        Intrinsics.checkNotNullParameter(r110, "positionInfo");
        jq1.c r102 = sq1.c.a(r101);
        long r103 = ((long) r100.getVideoRefInt(3)) * 1000;
        int r104 = r.f118208a;
        return r.c(r102, r110.getStartPosition(), r110.getStartHighlight(), (int) r103);
    }
}
