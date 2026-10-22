package r86;

import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements LynxTabBarView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTabBarView f536520a;

    public d(LynxTabBarView r100) {
        this.f536520a = r100;
    }

    @Override // com.bytedance.ies.xelement.viewpager.LynxTabBarView.b
    public final void a(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.f536520a.f250454e = r100;
    }
}
