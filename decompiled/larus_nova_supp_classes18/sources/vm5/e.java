package vm5;

import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.bytedance.ee.bear.sheet.filter.SubFilterColorFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ SubFilterColorFragment a;

    public e(SubFilterColorFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        UDCheckBox r6 = this.a.p;
        UDCheckBox r1 = null;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r6 = null;
    L6:
        if (r6.isChecked() == true) goto L12;
        UDCheckBox r7 = this.a.p;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
    L11:
        r1.setChecked(true);
        return;
    L10:
        r1 = r7;
        goto L11
    L12:
        this.a.U90("noColor", new String[0]);
        FilterPanelColorView r8 = this.a.r;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r8 = null;
    L15:
        r8.setChecked(false);
        UDCheckBox r9 = this.a.s;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L19:
        r1.setChecked(false);
        return;
    L18:
        r1 = r9;
        goto L19
    }
}
