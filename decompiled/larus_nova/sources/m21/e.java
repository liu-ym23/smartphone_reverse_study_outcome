package m21;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f511643a;

    public e(g r100) {
        this.f511643a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        AnchorLinkUserListContract$View r102 = (AnchorLinkUserListContract$View) this.f511643a.f92392c;
        if (r102 == null) goto L7;
        r102.ca0((IRivalRankRecommendResponse) r101.data);
        return;
    }
}
