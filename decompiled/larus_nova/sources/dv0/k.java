package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f470122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f470123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f470124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f470125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f470126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f470127f;

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.f470122a.getEntranceInfo();
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.f470122a.getExtra();
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.f470122a.getMiniAppId();
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.f470122a.getRoundId();
    }

    public k(i r100, long r101, long r102, long r103, List r104, long r110) {
        Intrinsics.checkNotNullParameter(r100, "common");
        Intrinsics.checkNotNullParameter(r104, "players");
        this.f470122a = r100;
        this.f470123b = r101;
        this.f470124c = r102;
        this.f470125d = r103;
        this.f470126e = r104;
        this.f470127f = r110;
    }
}
