package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivateMsgEntranceItemViewHolder f534463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lo0.a f534464b;

    public m(PrivateMsgEntranceItemViewHolder r100, lo0.a r101) {
        this.f534463a = r100;
        this.f534464b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f534463a.f84990f.b(this.f534464b);
    }
}
