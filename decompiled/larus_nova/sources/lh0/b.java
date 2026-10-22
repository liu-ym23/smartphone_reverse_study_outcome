package lh0;

import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import ih0.h;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f509224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f509225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f509226c;

    public void c() {
    }

    public final IRoom b() {
        DataCenter r100 = this.f509226c;
        if (r100 == null) goto L7;
        IRoom r101 = a0.o(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return a0.f66111a;
    }

    public void d() {
        this.f509224a.clear();
    }

    public final Context getContext() {
        return this.f509225b;
    }

    public b(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f509225b = r100;
        this.f509226c = r101;
        this.f509224a = new CompositeDisposable();
    }

    @Override // lh0.c
    public final void a(h r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        c.a.a(r100, r101);
    }

    public final void e(h r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        r100.a(UpdateLinkmicStatusResultModel.Code.Failed, r101, null);
    }
}
