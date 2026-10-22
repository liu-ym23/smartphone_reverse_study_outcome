package xk1;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final lm3.d a(Context r100, lm3.c.a r101, lm3.c.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("您当前正在使用移动网络，是否继续缓存？", "msg");
        Intrinsics.checkNotNullParameter(r101, "cancelListener");
        Intrinsics.checkNotNullParameter(r102, "okListener");
        lm3.c r103 = new lm3.c();
        r103.f509864b = "暂不缓存";
        r103.f509865c = r101;
        Unit r104 = Unit.INSTANCE;
        lm3.c r105 = new lm3.c();
        r105.f509864b = "继续缓存";
        r105.f509865c = r102;
        List<? extends lm3.c> r106 = CollectionsKt.listOf(new lm3.c[]{r103, r105});
        lm3.d.a r107 = new lm3.d.a(r100);
        r107.f509871b = "您当前正在使用移动网络，是否继续缓存？";
        r107.f509874e = r106;
        return r107.a();
    }
}
