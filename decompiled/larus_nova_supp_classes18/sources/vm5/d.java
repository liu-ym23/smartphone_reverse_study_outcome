package vm5;

import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.bytedance.ee.bear.sheet.filter.SubFilterColorFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SubFilterColorFragment a;

    public d(SubFilterColorFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        UDCheckBox r6 = this.a.p;
        UDCheckBox r1 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r6 = null;
    L5:
        boolean r7 = r6.isChecked();
        UDCheckBox r2 = this.a.p;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r2 = null;
    L8:
        r2.setChecked(!r7);
        UDCheckBox r8 = this.a.p;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r8 = null;
    L12:
        if (r8.isChecked() == true) goto L18;
        UDCheckBox r9 = this.a.p;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
    L17:
        r1.setChecked(true);
        return;
    L16:
        r1 = r9;
        goto L17
    L18:
        this.a.U90("noColor", new String[0]);
        FilterPanelColorView r10 = this.a.r;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r10 = null;
    L21:
        r10.setChecked(false);
        UDCheckBox r11 = this.a.s;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L25:
        r1.setChecked(false);
        return;
    L24:
        r1 = r11;
        goto L25
    }
}
