package pn5;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.ee.bear.sheet_core.inputbar.at.span.FormulaColorSpan;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetAtEditText f529967a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public f(SheetAtEditText r100) {
        this.f529967a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        FormulaInputStyleData r101 = this.f529967a.S1;
        if (r101 != null) goto L6;
        return;
    L6:
        if (((FormulaColorSpan[]) r100.getSpans(0, r100.length(), FormulaColorSpan.class)).length != 0) goto L8;
        this.f529967a.getClass();
        SheetAtEditText.L(r100, r101);
    L8:
        this.f529967a.P();
    }
}
