package k1a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {
    public static final void a(Fragment r100, Function1<? super Attachable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "init");
        FragmentAttachExtKt.c(r100, r101);
    }

    public static final void b(BaseComponentWidget<Object> r100, Function1<? super Attachable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "init");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "init");
        FragmentActivity r102 = com.larus.ui.arch.component.internal.attach.a.a(r100, r100);
        Attachable.Companion.getClass();
        Attachable r103 = Attachable.a.a(r102);
        if (r103.getComponentStateController$component_release(r100) != null) goto L12;
        int r104 = y1a.a.f565679a;
        y1a.a.a(LynxViewpagerItem.BIND_ON_ATTACH, "create stateController ".concat(r100.getClass().getSimpleName()));
        ComponentStateController r105 = new ComponentStateController(r100, r102);
        if (r100.f375154j == null) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        r105.b(r100.F2());
    L11:
        r103.putComponentStateController$component_release(r100, r105);
        goto L12
    L10:
        r105.b(null);
        r1a.b r107 = new r1a.b(r100, r105);
        Intrinsics.checkNotNullParameter(r107, "listener");
        r100.f375152h.add(r107);
        goto L11
    L7:
        r106 = false;
    L12:
        r101.invoke(r103);
    }
}
