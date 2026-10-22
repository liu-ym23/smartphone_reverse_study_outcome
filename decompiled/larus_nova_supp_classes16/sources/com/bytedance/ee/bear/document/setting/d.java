package com.bytedance.ee.bear.document.setting;

import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ DocumentSettingActivity a;

    public d(DocumentSettingActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        DocumentSettingActivity r0 = this.a;
        UDSwitch r1 = r0.d;
        if (r1 != null) goto L5;
        r1 = r0.findViewById(2131391818);
        r0.d = r1;
    L5:
        Intrinsics.checkNotNull(r5);
        r1.setChecked(r5.booleanValue());
    }
}
