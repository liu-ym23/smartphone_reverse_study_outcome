package n32;

import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;
import sh6.c;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: n32.a$a, reason: collision with other inner class name */
    public static final class C6886a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f516913a;

        public C6886a(Function1 r100) {
            this.f516913a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Function1 r101 = this.f516913a;
            Object r102 = c.b((b) r100);
            if (r102 == null) goto L6;
            r101.invoke(r102);
            return;
        }
    }

    public static final <T> Disposable a(j<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeUse");
        Intrinsics.checkNotNullParameter(r101, "action");
        T r102 = r100.getValue();
        if (r100.hasValue() == false) goto L7;
        if (r102 == null) goto L7;
        r101.invoke(r102);
        return null;
    L7:
        return r100.b().subscribe(new C6886a(r101));
    }
}
