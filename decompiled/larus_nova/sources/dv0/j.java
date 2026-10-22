package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f470121a;

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.f470121a.getEntranceInfo();
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.f470121a.getExtra();
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.f470121a.getMiniAppId();
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.f470121a.getRoundId();
    }

    public j(i r100) {
        Intrinsics.checkNotNullParameter(r100, "common");
        this.f470121a = r100;
    }
}
