package ni3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b {
    public boolean W3;

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        this.W3 = mq.b.c(r3, "can_show_tag", false);
    }

    public final void v(int r3, int r4, int r5, int r6) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r3, r4, r5, r6);
        if (getChildCount() >= 2) goto L5;
        return;
    L5:
        View r7 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(getView()), 0);
        boolean r0 = true;
        View r8 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(getView()), getChildCount() - 1);
        if (r7.getMeasuredWidth() >= (getView().getMeasuredWidth() - 1)) goto L9;
        r0 = false;
    L9:
        if (r0 == true) goto L11;
    L13:
        r8.layout(0, 0, 0, 0);
        return;
    L11:
        if (this.W3 == false) goto L13;
        r7.layout(r7.getLeft(), r7.getTop(), r7.getRight() - r8.getMeasuredWidth(), r7.getBottom());
    }
}
