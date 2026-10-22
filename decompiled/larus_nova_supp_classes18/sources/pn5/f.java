package pn5;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.ee.bear.sheet_core.inputbar.at.span.FormulaColorSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements TextWatcher {
    public final /* synthetic */ SheetAtEditText a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public f(SheetAtEditText r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        FormulaInputStyleData r0 = this.a.S1;
        if (r0 != null) goto L6;
        return;
    L6:
        if (((FormulaColorSpan[]) r5.getSpans(0, r5.length(), FormulaColorSpan.class)).length != 0) goto L8;
        this.a.getClass();
        SheetAtEditText.L(r5, r0);
    L8:
        this.a.P();
    }
}
