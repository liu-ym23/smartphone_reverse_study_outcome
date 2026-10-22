package ki3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.scroll.c {
    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        ((BaseSlcViewManager) this).j3 = true;
    }

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return I1(r1);
    }

    public final SlcScrollElementView I1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new a(r2);
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCtx");
        Object r0 = r4.get("recommend_item");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 == null) goto L8;
        Object r3 = r1.get("slide_params");
    L10:
        if ((r3 instanceof Map) == false) goto L13;
        r2 = r3;
    L13:
        Map<String, ? extends Object> r5 = (Map) r2;
        Object r6 = getView();
        if (r6 == null) goto L20;
        a r7 = (a) r6;
        if (r5 == null) goto L18;
        r7.i = r5;
    L18:
        return r4;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.slice.elements.customscroll.PdpCustomScrollView");
    L8:
        r3 = null;
        goto L10
    }
}
