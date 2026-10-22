package ed2;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.kickout.ui.BannedViewHolder;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannedViewHolder f472193a;

    public d(BannedViewHolder r100) {
        this.f472193a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f472193a.f142276e.getLayoutParams();
        int r104 = s1.f(32.0f);
        r103.width = r104;
        r103.height = (r102 * r104) / r101;
        this.f472193a.f142276e.setLayoutParams(r103);
    }
}
