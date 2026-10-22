package su1;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f543587a;

    public c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f543587a = r100;
    }

    @Override // su1.e
    public final void a(qu1.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Deque<Object> r102 = r100.f534837a;
        LinkedList r103 = (LinkedList) r102;
        r103.push(this.f543587a);
    }
}
