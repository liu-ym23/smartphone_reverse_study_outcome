package vm5;

import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.bytedance.ee.bear.sheet.filter.OfficeSubFilterColorFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSubFilterColorFragment f556344a;

    public b(OfficeSubFilterColorFragment r100) {
        this.f556344a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f556344a.f237743p;
        FilterPanelColorView r102 = null;
        UDCheckBox r103 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r101 = null;
    L5:
        boolean r104 = r101.isChecked();
        UDCheckBox r105 = this.f556344a.f237743p;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r105 = null;
    L8:
        r105.setChecked(!r104);
        UDCheckBox r106 = this.f556344a.f237743p;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r106 = null;
    L12:
        if (r106.isChecked() == true) goto L18;
        UDCheckBox r107 = this.f556344a.f237743p;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
    L17:
        r103.setChecked(true);
        return;
    L16:
        r103 = r107;
        goto L17
    L18:
        this.f556344a.U90("noColor", new String[0]);
        FilterPanelColorView r108 = this.f556344a.f237745r;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r108 = null;
    L21:
        r108.setChecked(false);
        FilterPanelColorView r109 = this.f556344a.f237746s;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L25:
        r102.setChecked(false);
        return;
    L24:
        r102 = r109;
        goto L25
    }
}
