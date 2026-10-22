package jv4;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.e;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.MenuItemView;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import eu5.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ gv4.a a;
    public final /* synthetic */ SimpleItemModel b;
    public final /* synthetic */ MenuItemView c;

    public a(gv4.a r1, SimpleItemModel r2, MenuItemView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.a(new Action(this.b.getId(), this.b.getClickAction()));
        Context r5 = this.c.getContext();
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        h.a(r5, 10, 50);
    }
}
