package hi4;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewMainPagerView;
import com.bytedance.creativex.mediaimport.preview.internal.main.w;
import ki4.r;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends BasePreviewMainPagerView<r> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<Integer, r, fi4.a<r>> f485272h;

    public c(ViewPager r100, w r101) {
        Intrinsics.checkNotNullParameter(r100, "innerViewPager");
        Intrinsics.checkNotNullParameter(r101, "pageViewProvider");
        super(r100);
        this.f485272h = r101;
    }
}
