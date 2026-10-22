package iwc;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;

/* JADX INFO: loaded from: classes42.dex */
public final class a<T> extends c<T> {
    @Override // iwc.c
    public final void b() {
        Function1<T, Unit> r100 = this.f496311b.f526135h.f526137a;
        if (r100 == null) goto L7;
        r100.invoke(null);
        return;
    }

    @Override // iwc.c
    public final T c(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return a(r100);
    }

    public a(org.koin.core.a r100, BeanDefinition<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "koin");
        Intrinsics.checkNotNullParameter(r101, "beanDefinition");
        super(r100, r101);
    }
}
