package f0c;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f475032c;

    @Override // f0c.b
    public final g a() {
        return this.f475032c;
    }

    public f(g r100, Scene r101, lzb.a r102) {
        Intrinsics.checkNotNullParameter(r100, "userPayload");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, new h(UserState.ONLINE, r101, r102));
        this.f475032c = r100;
    }
}
