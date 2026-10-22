package ew;

import com.bytedance.android.gamecp.host_api.cloudgame.IFeatureService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements IFeatureService {
    public j() {
    }

    @Override // com.bytedance.android.gamecp.host_api.cloudgame.IFeatureService
    public final void a() {
        Intrinsics.checkNotNullParameter("gamecp_detail_preload_config", "factorName");
    }
}
