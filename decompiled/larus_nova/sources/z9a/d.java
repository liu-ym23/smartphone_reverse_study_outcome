package z9a;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.jvm.internal.Intrinsics;
import v9a.f;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f571072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f571073b = null;

    public d() {
    }

    static {
        f571072a = new d();
    L15:
        th = move-exception;
        ILogDepend.f384986a.e("VibrateFeedback", "init failed", th);
    L17:
        f571073b = (a) ServiceManager.get().getService(a.class, false);
        return;
    L4:
        if (f.f553878h.a().b() == false) goto L21;
        ServiceManager.get().bind(a.class, new SingletonProvider(new b()));     // Catch: Throwable -> L7
        ILogDepend.f384986a.i("VibrateFeedback", "bind PacificVibrateFeedback");     // Catch: Throwable -> L7
    L23:
    L7:
        th = move-exception;
        ILogDepend.f384986a.e("VibrateFeedback", "bind PacificVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    L21:
        ServiceManager.get().bind(a.class, new SingletonProvider(new c()));     // Catch: Throwable -> L12
        ILogDepend.f384986a.i("VibrateFeedback", "bind CommonVibrateFeedback");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ILogDepend.f384986a.e("VibrateFeedback", "bind CommonVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    }

    @Override // z9a.a
    public final void a(FeedbackType r100) {
        Intrinsics.checkNotNullParameter(r100, "feedbackType");
        a r101 = f571073b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
