package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface z0 {

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Throwable, Unit> f505165a;

        public final String toString() {
            return "InternalCompletionHandler.UserSupplied[" + this.f505165a.getClass().getSimpleName() + '@' + b0.a(this) + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Throwable, Unit> r100) {
            this.f505165a = r100;
        }

        @Override // kotlinx.coroutines.z0
        public final void a(Throwable r100) {
            this.f505165a.invoke(r100);
        }
    }

    void a(Throwable r100);
}
