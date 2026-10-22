package g20;

import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureFunctionItemViewHolderV3;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenFeatureFunctionItemViewHolderV3 f479651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f10.f f479652b;

    public b(OpenFeatureFunctionItemViewHolderV3 r100, f10.f r101) {
        this.f479651a = r100;
        this.f479652b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f479651a.f61668e != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        OpenFeatureFunctionItemViewHolderV3 r101 = this.f479651a;
        a20.e r102 = r101.f61668e;
        if (r102 == null) goto L9;
        r102.a(r101.itemView, this.f479652b, r101.getPosition(), null);
        return;
    }
}
