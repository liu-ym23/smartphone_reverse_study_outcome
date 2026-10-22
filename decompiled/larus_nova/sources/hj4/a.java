package hj4;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.init.task.AbTestInitiator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f485421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f485422b;

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f485421a;     // Catch: Throwable -> L6
        JSONObject r101 = this.f485422b;     // Catch: Throwable -> L6
        if (d.f485427a == null) goto L9;
        int r102 = AbTestInitiator.f350994g;     // Catch: Throwable -> L6
        IApplog.Companion r103 = IApplog.f287053a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        r103.reportEvent(r100, r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(JSONObject r100) {
        this.f485421a = "local_strategy";
        this.f485422b = r100;
    }
}
