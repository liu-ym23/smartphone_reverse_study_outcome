package rm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f538505l;

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(0);
        this.f538505l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f538505l;
    }
}
