package c58;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.asr.direct.AsrDirectFillComponent;
import com.larus.asr.direct.IAsrDirectFillAbility$DirectFillStatus;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements TextWatcher {
    public final /* synthetic */ AsrDirectFillComponent a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public n(AsrDirectFillComponent r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r6) {
        AsrDirectFillComponent r0 = this.a;
        int r1 = AsrDirectFillComponent.A;
        va8.o r2 = (va8.o) r0.k.getValue();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L25;
        AsrDirectFillComponent r5 = this.a;
        IAsrDirectFillAbility$DirectFillStatus r7 = r5.u;
        if (r7 == null) goto L27;
        IAsrDirectFillAbility$DirectFillStatus r8 = IAsrDirectFillAbility$DirectFillStatus.FillBackClear;
        if (r7 == r8) goto L28;
        if (r6 != null) goto L17;
    L18:
        r3 = true;
    L19:
        if (r3 == true) goto L22;
        r8 = IAsrDirectFillAbility$DirectFillStatus.FillBackEdit;
    L22:
        if (r7 == r8) goto L26;
        FLogger.a.i("AsrDirectFillComponent", "directFillStatus changed: " + r7 + " -> " + r8);
        r5.Y2(r8);
        return;
    L26:
        return;
    L17:
        if (r6.length() != 0) goto L19;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L5:
        if (r2.n5() != true) goto L7;
        r4 = true;
        goto L8
    }
}
