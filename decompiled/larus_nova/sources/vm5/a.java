package vm5;

import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView f556343a;

    public a(FilterPanelColorView r100) {
        this.f556343a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        BaseRecyclerView r102 = this.f556343a.f237700f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("colorRecyclerView");
        r102 = null;
    L5:
        if (r101 == false) goto L7;
        int r103 = 0;
    L8:
        r102.setVisibility(r103);
        return;
    L7:
        r103 = 8;
        goto L8
    }
}
