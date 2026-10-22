package u01;

import android.view.View;
import com.bytedance.android.livesdkapi.feed.IFeedViewState;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements IPkFeedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qc0.c f548134a;

    @Override // com.bytedance.android.livesdkapi.feed.IPkFeedView
    public final String getPkExpandType() {
        this.f548134a.getPkExpandType();
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPkFeedView
    public final String getProgressAnimUrl() {
        this.f548134a.getProgressAnimUrl();
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPkFeedView
    public final View getTeamTaskExtendView() {
        this.f548134a.getTeamTaskExtendView();
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPkFeedView
    public final IFeedViewState getViewState() {
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r100 = this.f548134a.getViewState();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new a(r100);
    }

    public i(qc0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f548134a = r100;
    }
}
