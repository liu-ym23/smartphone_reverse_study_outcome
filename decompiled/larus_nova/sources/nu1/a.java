package nu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f520601a = null;

    public a() {
    }

    static {
        f520601a = new a();
    }

    @Override // nu1.b
    public final Object a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "expression");
        Intrinsics.checkNotNullParameter(r101, "args");
        return qu1.b.a(r100, r101);
    L5:
        e = move-exception;
        int r102 = k.f510820a;
        k.f("unknown_strategy", r100, e);
        int r103 = DynamicStrategyMonitor.f123031a;
        String r104 = e.getMessage();
        if (r104 != null) goto L9;
        r104 = "express error";
    L9:
        DynamicStrategyMonitor.d("unknown_strategy", "unknown", r100, r104);
        return Boolean.FALSE;
    }
}
