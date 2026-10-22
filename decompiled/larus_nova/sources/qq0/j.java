package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayItemViewHolder;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShelfDisplayItemViewHolder f534459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rq0.a f534460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f534461c;

    public j(AudienceShelfDisplayItemViewHolder r100, rq0.a r101, boolean r102) {
        this.f534459a = r100;
        this.f534460b = r101;
        this.f534461c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f534459a.f84984k.a(this.f534460b, MountedMiniAppSource.ShelfPageCard, this.f534461c);
    }
}
