package pm1;

import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f529812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReplayVideoPositionInfo f529813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f529814d;

    public b(long r100, ReplayVideoPositionInfo r101) {
        d r102 = d.f529816b;
        Intrinsics.checkNotNullParameter("preload_jsb", "enterSource");
        Intrinsics.checkNotNullParameter(r102, "config");
        super(r102);
        this.f529812b = r100;
        this.f529813c = r101;
        this.f529814d = "preload_jsb";
    }
}
