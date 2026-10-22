package com.bytedance.ee.bear.document.setting;

import android.view.KeyEvent;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentSettingActivity f221753a;

    public d(DocumentSettingActivity r100) {
        this.f221753a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        DocumentSettingActivity r102 = this.f221753a;
        KeyEvent.Callback r103 = r102.f221734d;
        if (r103 != null) goto L5;
        r103 = r102.findViewById(R.id.ud_switch);
        r102.f221734d = (UDSwitch) r103;
    L5:
        Intrinsics.checkNotNull(r101);
        ((UDSwitch) r103).setChecked(r101.booleanValue());
    }
}
