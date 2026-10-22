package u86;

import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Pager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> f549184a;

    public e(BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> r100) {
        this.f549184a = r100;
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager.e
    public final void a(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.f549184a.f250597d = r100;
    }
}
