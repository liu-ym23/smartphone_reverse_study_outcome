package or1;

import com.bytedance.android.livesdkapi.depend.event.FollowStateChangeEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f524923a;

    public q(bm1.b r100) {
        this.f524923a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f524923a.invoke(((FollowStateChangeEvent) r100).getFollowPair());
    }
}
