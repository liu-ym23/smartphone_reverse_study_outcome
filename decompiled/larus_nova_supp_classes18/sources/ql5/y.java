package ql5;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.ee.bear.reminder.ReminderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements TextWatcher {
    public final /* synthetic */ ReminderFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y(ReminderFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        ReminderFragment r3 = this.a;
        if (r3.T != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3.L.getText(), this.a.T.j) == true) goto L9;
        this.a.ia0();
        return;
    }
}
