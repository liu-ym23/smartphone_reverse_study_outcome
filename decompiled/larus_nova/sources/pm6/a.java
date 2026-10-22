package pm6;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import bu6.b;
import bu6.c;
import com.bytedance.locallife.host.search.Word;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements bu6.a {
    public a() {
    }

    @Override // bu6.a, ns6.a
    public final List<String> a() {
        return null;
    }

    @Override // bu6.a
    public final void m(FragmentActivity r100, b r101, Function2<? super List<Word>, ? super String, Unit> r102, Function1<? super Exception, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "lifeSearchParams");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        Intrinsics.checkNotNullParameter(r103, "onFailed");
    }

    @Override // bu6.a
    public final void q(Context r100, c r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "routeCallback");
    }

    @Override // bu6.a
    public final Map X() {
        Intrinsics.checkNotNullParameter("favourite_poi", "eventName");
        return new LinkedHashMap();
    }
}
