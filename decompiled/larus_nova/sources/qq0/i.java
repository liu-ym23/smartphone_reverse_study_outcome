package qq0;

import android.view.View;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayItemViewHolder;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShelfDisplayItemViewHolder f534456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rq0.a f534457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f534458c;

    public i(AudienceShelfDisplayItemViewHolder r100, rq0.a r101, boolean r102) {
        this.f534456a = r100;
        this.f534457b = r101;
        this.f534458c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f534456a.f84984k.a(this.f534457b, MountedMiniAppSource.ShelfPageCardActionButton, this.f534458c);
    }
}
