package ol3;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.yata.init.AndroidYataLoader;
import com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.b;
import com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.c;
import kotlin.jvm.internal.Intrinsics;
import sc3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements j {
    public a() {
    }

    public final void a() {
    }

    public final void c() {
        AndroidYataLoader.a();
    }

    public final BaseSlcViewManager b(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "templateContext");
        if ((r4 instanceof SlcTemplateContext) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r3, "YataSubView") == false) goto L13;
        SliceRender.o.getClass();
        if (SliceRender.c() == false) goto L12;
        return new c((SlcTemplateContext) r4);
    L12:
        return new b((SlcTemplateContext) r4);
    L13:
        return null;
    }
}
