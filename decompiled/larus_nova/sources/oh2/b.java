package oh2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f523250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f523251m;

    public b() {
        super(0);
    }

    public final Context getContext() {
        return this.f523251m;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f523251m = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = this.f523250l;
        if (r102 == null) goto L9;
        if (r102 == null) goto L7;
        return r102;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        throw new IllegalStateException("set rootView or override onCreateView");
    }
}
