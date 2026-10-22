package ia0;

import ca0.n;
import com.bytedance.android.debug.f;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.pushstream.mock.LiveAnchorPushStreamMockManager;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import dy0.c;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes45.dex */
public interface a extends c, IAssetsManager, n {
    void A5(String r100, LiveAnchorPushStreamMockManager.Companion.a r101);

    Observable<h1> B2(long r100);

    String Nk(String r100);

    void Rg(h1 r100, long r101);

    void Tf(String r100, f r101);

    boolean a7(String r100);

    e kd(String r100);
}
