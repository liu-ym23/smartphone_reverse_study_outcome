package ju4;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.larksuite.component.universe_design.edittext.UDTextInputLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements TextWatcher {
    public final /* synthetic */ BitableApplyProFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c(BitableApplyProFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        if (String.valueOf(r5).length() <= 300) goto L5;
        boolean r6 = true;
    L6:
        View r1 = null;
        if (r6 == false) goto L19;
        Context r7 = this.a.getContext();
        if (r7 == null) goto L11;
        String r8 = r7.getString(2131886162);
    L12:
        BitableApplyProFragment r2 = this.a;
        View r3 = r2.i;
        if (r3 != null) goto L18;
        View r4 = r2.getView();
        if (r4 == null) goto L17;
        r1 = r4.findViewById(2131375417);
    L17:
        r2.i = (UDTextInputLayout) r1;
        r3 = r1;
    L18:
        ((UDTextInputLayout) r3).b(r8);
        this.a.X90().v();
        return;
    L11:
        r8 = null;
        goto L12
    L19:
        BitableApplyProFragment r9 = this.a;
        UDTextInputLayout r10 = r9.i;
        if (r10 != null) goto L26;
        View r11 = r9.getView();
        if (r11 == null) goto L24;
        r10 = r11.findViewById(2131375417);
    L25:
        r9.i = r10;
        goto L26
    L24:
        r10 = null;
    L26:
        r10.b(null);
        this.a.X90().w();
        return;
    L5:
        r6 = false;
        goto L6
    }
}
