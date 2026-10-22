package sa1;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchViewHolder f541152a;

    public e(LiveSearchViewHolder r100) {
        this.f541152a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f541152a.f100827c.getLayoutParams();
        r103.width = (int) (r103.height * (r101 / r102));
        this.f541152a.f100827c.setLayoutParams(r103);
    }
}
