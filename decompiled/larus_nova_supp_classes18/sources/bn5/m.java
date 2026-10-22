package bn5;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements TextWatcher {
    public final /* synthetic */ FormulaPickerFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public m(FormulaPickerFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        FormulaPickerFragment r0 = this.a;
        if (r2 == null) goto L5;
        String r3 = r2.toString().trim();
    L6:
        r0.n = r3;
        this.a.aa0();
        return;
    L5:
        r3 = "";
        goto L6
    }
}
