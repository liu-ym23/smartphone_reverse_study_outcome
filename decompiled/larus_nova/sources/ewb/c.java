package ewb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f474613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f474614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f474615c;

    @Override // ewb.b
    public Context getContext() {
        return this.f474613a;
    }

    public c(Context r100, View r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "notificationContainer");
        this.f474613a = r100;
        this.f474614b = r101;
        this.f474615c = r102;
    }
}
