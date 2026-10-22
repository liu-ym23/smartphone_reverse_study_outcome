package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface h extends m1 {

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Throwable, Unit> f504919a;

        public final String toString() {
            return "CancelHandler.UserSupplied[" + this.f504919a.getClass().getSimpleName() + '@' + b0.a(this) + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Throwable, Unit> r100) {
            this.f504919a = r100;
        }

        @Override // kotlinx.coroutines.h
        public final void a(Throwable r100) {
            this.f504919a.invoke(r100);
        }
    }

    void a(Throwable r100);
}
