package g32;

import f32.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h32.c f479793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h32.d f479794b;

        public a(h32.c r100, h32.d r101) {
            this.f479793a = r100;
            this.f479794b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f479793a.a(this.f479794b);
        }
    }

    public static final <T extends f> Disposable a(h32.c<T> r100, h32.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$listen");
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.b(r101);
        return Disposables.fromAction(new a(r100, r101));
    }
}
