package com.bytedance.ee.bear.document.setting;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ DocumentSettingActivity a;

    public e(DocumentSettingActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        this.a.h = r5;
        if (r5 != null) goto L6;
    L11:
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.intValue() != 2) goto L21;
        DocumentSettingActivity r6 = this.a;
        KeyEvent.Callback r1 = r6.f;
        if (r1 != null) goto L18;
        r1 = r6.findViewById(2131384642);
        r6.f = (TextView) r1;
    L18:
        ((TextView) r1).setText(this.a.C1().getAnyText(this.a));
        return;
    L21:
        return;
    L6:
        if (r5.intValue() != 1) goto L11;
        DocumentSettingActivity r7 = this.a;
        KeyEvent.Callback r2 = r7.f;
        if (r2 != null) goto L10;
        r2 = r7.findViewById(2131384642);
        r7.f = (TextView) r2;
    L10:
        ((TextView) r2).setText(this.a.getString(2131889545));
    }
}
