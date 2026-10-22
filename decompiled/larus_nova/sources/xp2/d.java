package xp2;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.livesdk.revenue.util.DataContextUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.util.j<r, xp2.a> f564698a;

    public static final class a implements com.bytedance.android.livesdk.revenue.util.c<r, xp2.a> {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.revenue.util.c
        public final r a(xp2.a r100) {
            xp2.a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "y");
            return ((f) r101).f564704a;
        }

        @Override // com.bytedance.android.livesdk.revenue.util.c
        public final xp2.a transform(r r100) {
            r r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "x");
            return new f(r101);
        }
    }

    public d(AudienceGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f564698a = DataContextUtilsKt.c(r100.getCurrentGame(), new a());
    }
}
