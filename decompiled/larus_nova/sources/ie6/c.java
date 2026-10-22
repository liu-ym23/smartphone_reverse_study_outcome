package ie6;

import com.bytedance.lark.lynxlib.widget.udtabs.LynxTabBarView;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.lynx.tasm.EventEmitter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements UDTabLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTabBarView f489492a;

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void a(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void c(com.larksuite.component.universe_design.tab.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    public c(LynxTabBarView r100) {
        this.f489492a = r100;
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
    public final void b(com.larksuite.component.universe_design.tab.b r110) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        LynxTabBarView r100 = this.f489492a;
        if (r100.f253292b == true) goto L5;
        return;
    L5:
        if (r110 != null) goto L8;
        r100.getClass();
    L7:
        int r101 = 0;
    L23:
        EventEmitter r102 = this.f489492a.getLynxContext().getEventEmitter();
        m7a.a r103 = new m7a.a(this.f489492a.getSign(), "change");
        LynxTabBarView r104 = this.f489492a;
        String r105 = (String) ((HashMap) r104.f253296f).get(Integer.valueOf(r101));
        String r106 = "";
        if (r105 != null) goto L26;
        r105 = "";
    L26:
        r103.a("tag", r105);
        r103.a("index", Integer.valueOf(r101));
        if (r104.f253291a == false) goto L30;
    L33:
        r103.a("scene", r106);
        Unit r111 = Unit.INSTANCE;
        r102.sendCustomEvent(r103);
        LynxTabBarView r112 = this.f489492a;
        r112.f253291a = false;
        r112.f253294d = null;
        return;
    L30:
        if (r104.f253294d != r110) goto L32;
        r106 = "click";
        goto L33
    L32:
        r106 = "slide";
        goto L33
    L8:
        UDTabLayout r107 = r100.f253293c;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r107 = null;
    L11:
        int r108 = r107.getTabCount();
        if (r108 <= 0) goto L7;
        r101 = 0;
    L14:
        int r109 = r101 + 1;
        UDTabLayout r113 = r100.f253293c;
        if (r113 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r113 = null;
    L18:
        if (r113.getTabAt(r101) == r110) goto L23;
        if (r109 >= r108) goto L7;
        r101 = r109;
        goto L14
    }
}
