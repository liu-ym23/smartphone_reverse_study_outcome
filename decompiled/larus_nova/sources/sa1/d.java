package sa1;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchViewHolder;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchViewHolder f541150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageModel f541151b;

    public d(LiveSearchViewHolder r100, ImageModel r101) {
        this.f541150a = r100;
        this.f541151b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        LiveSearchViewHolder r109 = this.f541150a;
        ImageModel r110 = this.f541151b;
        int r111 = r110.width;
        int r112 = r110.height;
        int r113 = LiveSearchViewHolder.f100822t;
        r109.U3(r111, r112);
    }
}
