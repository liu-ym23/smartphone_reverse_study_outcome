package bn5;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends RecyclerView.OnScrollListener {
    public final /* synthetic */ FormulaPickerFragment a;

    public n(FormulaPickerFragment r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        if (r2 != 1) goto L10;
        EditText r3 = this.a.p;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.hasFocus() == false) goto L12;
        this.a.X90();
        return;
    L12:
        return;
    }
}
