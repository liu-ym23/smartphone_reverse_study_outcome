package r53;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f536296l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        Fragment r100 = a().i();
        if (r100 == null) goto L7;
        return new s53.c(r100);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(R.id.sku_bottom_bar_container, null);
        this.f536296l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f536296l;
    }
}
