package vm5;

import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements UDCheckBox.c {
    public final /* synthetic */ FilterPanelColorView a;

    public a(FilterPanelColorView r1) {
        this.a = r1;
    }

    public final void a(UDCheckBox r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        CommonRecyclerView r4 = this.a.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r4 = null;
    L5:
        if (r3 == false) goto L7;
        int r5 = 0;
    L8:
        r4.setVisibility(r5);
        return;
    L7:
        r5 = 8;
        goto L8
    }
}
