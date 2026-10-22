package e1c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<o1c.c<?, ?>> f470787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f470788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<?> f470789c;

    public e(Ref.ObjectRef r100, AudioResourceLoadTask.b r101, IGetDataCallback r102) {
        this.f470787a = r100;
        this.f470788b = r101;
        this.f470789c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o1c.c<?, ?> r100 = this.f470787a.element;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.task.ITask<kotlin.Any?, kotlin.Any?>");     // Catch: Throwable -> L4
        r100.J1(this.f470788b, this.f470789c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
