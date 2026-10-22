package com.bytedance.ee.bear.document.setting;

import android.view.KeyEvent;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ DocumentSettingActivity a;

    public f(DocumentSettingActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        DocumentSettingActivity r0 = this.a;
        KeyEvent.Callback r1 = r0.c;
        if (r1 != null) goto L5;
        r1 = r0.findViewById(2131377678);
        r0.c = (RelativeLayout) r1;
    L5:
        RelativeLayout r2 = (RelativeLayout) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r5.booleanValue() == false) goto L12;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.e() == false) goto L12;
        int r6 = 0;
    L13:
        r2.setVisibility(r6);
        return;
    L12:
        r6 = 8;
        goto L13
    }
}
