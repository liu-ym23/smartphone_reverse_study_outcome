package ol3;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.yata.init.AndroidYataLoader;
import com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.b;
import com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.c;
import kotlin.jvm.internal.Intrinsics;
import sc3.j;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements j {
    public a() {
    }

    @Override // sc3.j
    public final void a() {
    }

    @Override // sc3.j
    public final void c() {
        AndroidYataLoader.a();
    }

    @Override // sc3.j
    public final BaseSlcViewManager b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "templateContext");
        if ((r101 instanceof SlcTemplateContext) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r100, "YataSubView") == false) goto L13;
        SliceRender.f50121o.getClass();
        if (SliceRender.c() == false) goto L12;
        return new c((SlcTemplateContext) r101);
    L12:
        return new b((SlcTemplateContext) r101);
    L13:
        return null;
    }
}
