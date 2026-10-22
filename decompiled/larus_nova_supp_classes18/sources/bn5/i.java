package bn5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class i implements FormulaPickerFragment.e {
    public final /* synthetic */ FormulaPickerFragment a;
    public final /* synthetic */ FormulaPickerFragment.d b;
    public final /* synthetic */ String c;

    public /* synthetic */ i(FormulaPickerFragment r1, FormulaPickerFragment.d r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(boolean r6) {
        FormulaPickerFragment r0 = this.a;
        FormulaPickerFragment.d r1 = this.b;
        String r2 = this.c;
        r0.k = false;
        Fragment r3 = r0.getParentFragment();
        if (r3 == null) goto L5;
        FragmentManager r4 = r3.getChildFragmentManager();
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r1 == null) goto L12;
        r1.Bo(r2, r6);
        return;
    L12:
        tt5.a.k("FormulaPickerFragment", "onFunctionPicked listener is null");
        return;
    L8:
        if (r0.isAdded() == false) goto L10;
        r4.beginTransaction().remove(r0).commitNowAllowingStateLoss();
        goto L10
    L5:
        r4 = r0.getFragmentManager();
        goto L6
    }
}
