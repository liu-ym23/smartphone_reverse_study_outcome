package gd1;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    public final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f480909a;

        public a(Function0 r100) {
            this.f480909a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final /* synthetic */ void run() {
            this.f480909a.invoke();
        }
    }

    public static final Completable a(Completable r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$doAfterSubscribe");
        Intrinsics.checkNotNullParameter(r101, "action");
        return Completable.mergeArray(new CompletableSource[]{r100, Completable.complete().doOnComplete(new a(r101))});
    }
}
