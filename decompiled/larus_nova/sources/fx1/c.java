package fx1;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.message.model.n4;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class c<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f479100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super TriggerId, ? super T, Unit> f479101c;

    @Override // fx1.e
    public void a() {
        d("startObserve", new Pair[0]);
        this.f479100b.clear();
    }

    @Override // fx1.e
    public void reset() {
        this.f479101c = null;
        this.f479100b.clear();
    }

    public c() {
        this.f479099a = "BaseFeedbackTrigger";
        this.f479100b = new CompositeDisposable();
    }

    public static n4 f(long r100) {
        n4 r101 = new n4();
        r101.actionId = Long.valueOf(r100);
        return r101;
    }

    @Override // fx1.e
    public final void b(Function2<? super TriggerId, ? super T, Unit> r100) {
        this.f479101c = r100;
    }

    public final void c(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoBind");
        this.f479100b.add(r100);
    }

    public final void e(T r100) {
        Function2<? super TriggerId, ? super T, Unit> r101 = this.f479101c;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(getId(), r100);
        return;
    }

    public final void d(String r100, Pair<String, ? extends Object>... r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "args");
        int r102 = FeedbackMonitor.f124865a;
        FeedbackMonitor.Monitor r103 = new FeedbackMonitor.Monitor();
        String r104 = getId().name();
        Intrinsics.checkNotNullParameter(r104, "page");
        r103.f124866a = r104;
        r103.c(r100);
        int r105 = r101.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        Pair<String, ? extends Object> r107 = r101[r106];
        Object r108 = r107.getSecond();
        if (r108 == null) goto L7;
        r103.a(r107.getFirst(), r108);
    L7:
        r106 = r106 + 1;
        goto L3
    L8:
        r103.d();
    }
}
