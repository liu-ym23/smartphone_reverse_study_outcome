package com.ss.android.lark.utils.rxjava;

import com.ss.android.lark.log.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes38.dex */
public class RxScheduledExecutor {
    private static final String TAG = "RxScheduledExecutor";

    public interface Consumer<T> {
        void consume(T r100);
    }

    public interface Producer<T> {
        T produce();
    }

    public class a implements io.reactivex.functions.Consumer<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Consumer f444754a;

        public a(Consumer r100) {
            this.f444754a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(b r100) throws Exception {
            b r101 = r100;
            Consumer r102 = this.f444754a;
            if (r102 == null) goto L6;
            r102.consume(r101.f444755a);
            return;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f444755a;

        public b(T r100) {
            this.f444755a = r100;
        }
    }

    public class c implements io.reactivex.functions.Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Consumer f444756a;

        public c(Consumer r100) {
            this.f444756a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            Throwable r101 = r100;
            Consumer r102 = this.f444756a;
            if (r102 == null) goto L6;
            r102.consume(r101);
            return;
        }
    }

    public class d implements ObservableOnSubscribe<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Producer f444757a;

        public d(Producer r100) {
            this.f444757a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<b> r100) throws Exception {
            Producer r101 = this.f444757a;
            if (r101 == null) goto L5;
            Object r102 = r101.produce();
        L6:
            r100.onNext(new b(r102));
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public class e implements Producer<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f444758a;

        @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
        public final Object produce() {
            Runnable r100 = this.f444758a;
            if (r100 == null) goto L6;
            r100.run();
        L6:
            return Boolean.TRUE;
        }

        public e(Runnable r100) {
            this.f444758a = r100;
        }
    }

    public static class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
        public final void consume(Throwable r100) {
            Throwable r101 = r100;
            if (r101 == null) goto L6;
            Log.e(RxScheduledExecutor.TAG, r101.getMessage(), r101);
            return;
        }
    }

    public RxScheduledExecutor() {
    }

    public static void justInIO(Runnable r100) {
        execInIO(new e(r100), null);
    }

    public static <T> Disposable execInIO(Producer<T> r100, Consumer<T> r101) {
        return execInIO(r100, r101, new f());
    }

    public static <T> Disposable execInIO(Producer<T> r100, Consumer<T> r101, Consumer<Throwable> r102) {
        return Observable.create(new d(r100)).subscribeOn(LarkRxSchedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r101), new c(r102));
    }
}
