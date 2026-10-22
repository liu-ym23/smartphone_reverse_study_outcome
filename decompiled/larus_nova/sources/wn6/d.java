package wn6;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.biz.fps.RecyclerViewFpsMonitor$onScrollListener$1;
import com.bytedance.locallife.photo.photopage.fragment.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends a<RecyclerView> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerViewFpsMonitor$onScrollListener$1 f560473f;

    @Override // wn6.a
    public final void b() {
        super.b();
        ((RecyclerView) this.f560467a).removeOnScrollListener(this.f560473f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.locallife.biz.fps.RecyclerViewFpsMonitor$onScrollListener$1] */
    public d(RecyclerView r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter("life_album_photo", "scene");
        Intrinsics.checkNotNullParameter(r101, "dynamicPropertyGetter");
        super(r100, "life_album_photo", r101);
        ?? r102 = new RecyclerViewFpsMonitor$onScrollListener$1(this);
        this.f560473f = r102;
        r100.addOnScrollListener(r102);
    }
}
