package cn5;

import android.text.Editable;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.SheetDateKeyboardFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements UDCheckBox.c {
    public final /* synthetic */ SheetDateKeyboardFragment a;

    public r(SheetDateKeyboardFragment r1) {
        this.a = r1;
    }

    public final void a(UDCheckBox r3, boolean r4) {
        if (r4 == false) goto L8;
        if (this.a.g.isChecked() == false) goto L6;
        SheetDateKeyboardFragment r5 = this.a;
        r5.k = SheetInputData.InputData.DateType.DATETIME;
        r5.j.setPickerMode(PickerModel.MONTHDAY_HOUR_MINUTE_24H);
    L11:
        SheetDateKeyboardFragment r6 = this.a;
        String r7 = r6.k;
        Editable r0 = (Editable) r6.U90().getValue();
        if (r0 == null) goto L15;
        r6.X90(r0).subscribe(new q(r6, r7));
    L15:
        SheetDateKeyboardFragment r8 = this.a;
        r8.e.setDateKeyboardCurType(r8.k);
        return;
    L6:
        SheetDateKeyboardFragment r9 = this.a;
        r9.k = "date";
        r9.j.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        goto L11
    L8:
        if (this.a.g.isChecked() == false) goto L10;
        SheetDateKeyboardFragment r10 = this.a;
        r10.k = SheetInputData.InputData.DateType.TIME;
        r10.j.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        goto L11
    L10:
        this.a.f.setChecked(true);
        goto L11
    }
}
