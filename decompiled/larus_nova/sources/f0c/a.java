package f0c;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends b {
    public a(Scene r100, UserState r101, lzb.a r102) {
        Intrinsics.checkNotNullParameter(r101, "initState");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(null, new h(r101, r100, r102));
    }
}
