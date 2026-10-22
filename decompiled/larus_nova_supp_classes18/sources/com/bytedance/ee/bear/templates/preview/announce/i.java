package com.bytedance.ee.bear.templates.preview.announce;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ TemplateCardPanelFragment a;

    public i(TemplateCardPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        ArrayList r7 = (ArrayList) r6;
        com.bytedance.ee.bear.list.loadstateview.h r0 = null;
        if (r7 == null) goto L19;
        RecyclerView r2 = this.a.i;
        if (r2 == null) goto L7;
        r2.setVisibility(0);
    L7:
        TemplateCardPanelFragment r3 = this.a;
        PanelTemplateAdapter r4 = r3.l;
        if (r4 != null) goto L11;
        if (r4 != null) goto L11;
        r3.l = new PanelTemplateAdapter();
    L11:
        PanelTemplateAdapter r5 = this.a.l;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullParameter(r7, "templates");
        DiffUtil.DiffResult r8 = DiffUtil.calculateDiff(new RecyclerItemsDiff(r5.b, r7, r5), true);
        r5.b = r7;
        r8.dispatchUpdatesTo(r5);
    L14:
        com.bytedance.ee.bear.list.loadstateview.h r9 = this.a.n;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L18:
        r0.i();
        return;
    L17:
        r0 = r9;
        goto L18
    L19:
        RecyclerView r10 = this.a.i;
        if (r10 == null) goto L22;
        r10.setVisibility(4);
    L22:
        com.bytedance.ee.bear.list.loadstateview.h r11 = this.a.n;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L26:
        r0.b(new Throwable());
        return;
    L25:
        r0 = r11;
        goto L26
    }
}
