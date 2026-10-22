package lt0;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.profile.standard.tag.view.LiveLifeHonorView;
import com.facebook.imagepipeline.image.ImageInfo;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLifeHonorView f510650a;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(k r100) {
    }

    public b(LiveLifeHonorView r100) {
        this.f510650a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void b(k r100, Exception r101) {
        LiveLifeHonorView.f(this.f510650a, 0);
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(k r100, int r101, int r102, boolean r103) {
        LiveLifeHonorView.f(this.f510650a, (r101 * UtilityKotlinExtentionsKt.i(18)) / r102);
    }
}
