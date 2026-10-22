package vm5;

import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterPanelColorView;
import com.bytedance.ee.bear.sheet.filter.OfficeSubFilterColorFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSubFilterColorFragment f556345a;

    public c(OfficeSubFilterColorFragment r100) {
        this.f556345a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f556345a.f237743p;
        FilterPanelColorView r102 = null;
        UDCheckBox r103 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r101 = null;
    L6:
        if (r101.isChecked() == true) goto L12;
        UDCheckBox r104 = this.f556345a.f237743p;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
    L11:
        r103.setChecked(true);
        return;
    L10:
        r103 = r104;
        goto L11
    L12:
        this.f556345a.U90("noColor", new String[0]);
        FilterPanelColorView r105 = this.f556345a.f237745r;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r105 = null;
    L15:
        r105.setChecked(false);
        FilterPanelColorView r106 = this.f556345a.f237746s;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L19:
        r102.setChecked(false);
        return;
    L18:
        r102 = r106;
        goto L19
    }
}
