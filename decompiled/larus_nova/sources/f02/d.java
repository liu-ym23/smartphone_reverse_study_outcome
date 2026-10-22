package f02;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug.AssetsInfoAdapter;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f474973a;

    public d(a r100) {
        this.f474973a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List<? extends Pair<? extends e, Boolean>> r101 = (List) r100;
        AssetsInfoAdapter r102 = this.f474973a.getAdapter();
        if (r102 == null) goto L6;
        r102.y2(r101);
        return;
    }
}
