package ld;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements ObservableOnSubscribe<sh6.b<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NextLiveData f508642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f508643b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f508644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f508645b;

        public a(b r100, C6678b r101) {
            this.f508644a = r100;
            this.f508645b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f508644a.f508642a.removeObserver(this.f508645b);
        }
    }

    /* JADX INFO: renamed from: ld.b$b, reason: collision with other inner class name */
    public static final class C6678b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f508646a;

        public C6678b(ObservableEmitter r100) {
            this.f508646a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (r100 == null) goto L4;
            this.f508646a.onNext(new sh6.d(r100));
            return;
        L4:
            this.f508646a.onNext(sh6.a.f541970a);
        }
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<sh6.b<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        C6678b r101 = new C6678b(r100);
        r100.setCancellable(new a(this, r101));
        this.f508642a.observeForever(r101, this.f508643b);
    }

    public b(NextLiveData<Object> r100, boolean r101) {
        this.f508642a = r100;
        this.f508643b = r101;
    }
}
