package ie6;

import com.bytedance.lark.lynxlib.widget.udtabs.LynxViewPager;
import com.bytedance.lark.lynxlib.widget.udtabs.Pager;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements UDTabLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxViewPager f489494a;

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void a(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void c(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    public e(LynxViewPager r100) {
        this.f489494a = r100;
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void b(com.larksuite.component.universe_design.tab.b r110) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        CharSequence r100 = r110.f285294c;
        if (r100 == null) goto L36;
        LynxViewPager r101 = this.f489494a;
        if (r101.f253297a == false) goto L36;
        String r102 = r100.toString();
        Pager r103 = r101.f253298b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        r103 = null;
    L10:
        UDTabLayout r104 = r103.getMTabLayout();
        if (r104 != null) goto L13;
        int r105 = 0;
    L14:
        if (r105 <= 0) goto L27;
        int r106 = 0;
    L16:
        int r107 = r106 + 1;
        if (r104 != null) goto L19;
        com.larksuite.component.universe_design.tab.b r108 = null;
    L20:
        if (r108 == null) goto L24;
        if (r108 != r110) goto L24;
    L29:
        if (r101.f253300d == false) goto L32;
        String r111 = "";
    L35:
        LynxViewPager.M(r101, r102, r106, r111);
        r101.f253300d = false;
        goto L36
    L32:
        if (r101.f253299c != r110) goto L34;
        r111 = "click";
        goto L35
    L34:
        r111 = "slide";
    L24:
        if (r107 >= r105) goto L27;
        r106 = r107;
        goto L16
    L19:
        r108 = r104.getTabAt(r106);
    L27:
        r106 = 0;
        goto L29
    L13:
        r105 = r104.getTabCount();
    L36:
        this.f489494a.f253299c = null;
    }
}
