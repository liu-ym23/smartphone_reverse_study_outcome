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
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f509220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f509221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f509222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.b f509223d;

    public void c() {
    }

    public final IRoom b() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r100 = this.f509223d;
        if (r100 == null) goto L7;
        IRoom r101 = r100.r();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return a0.f66111a;
    }

    public void d() {
        this.f509220a.clear();
    }

    public final Context getContext() {
        return this.f509221b;
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

    public a(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        this.f509221b = r100;
        this.f509222c = r101;
        this.f509223d = r102;
        this.f509220a = new CompositeDisposable();
    }
}
