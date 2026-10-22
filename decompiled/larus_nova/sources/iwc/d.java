package iwc;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;

/* JADX INFO: loaded from: classes42.dex */
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f496312c;

    @Override // iwc.c
    public final void b() {
        Function1<T, Unit> r100 = this.f496311b.f526135h.f526137a;
        if (r100 == null) goto L6;
        r100.invoke(this.f496312c);
    L6:
        this.f496312c = null;
    }

    @Override // iwc.c
    public final T a(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        T r101 = this.f496312c;
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (T) super.a(r100);
    }

    @Override // iwc.c
    public final T c(b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f496312c == null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        this.f496312c = a(r100);     // Catch: Throwable -> L17
    L10:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        T r103 = this.f496312c;
        if (r103 == null) goto L16;
        return r103;
    L16:
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    L7:
        r101 = false;
        goto L8
    }

    public d(org.koin.core.a r100, BeanDefinition<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "koin");
        Intrinsics.checkNotNullParameter(r101, "beanDefinition");
        super(r100, r101);
    }
}
