package iu5;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    public class a implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f495801a;

        public a(Runnable r100) {
            this.f495801a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(String r100) throws Exception {
            this.f495801a.run();
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.f("SwitchThreadUtils", r100, false);
        }
    }

    public static void a(Runnable r100) {
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new a(r100), new b());
    }
}
