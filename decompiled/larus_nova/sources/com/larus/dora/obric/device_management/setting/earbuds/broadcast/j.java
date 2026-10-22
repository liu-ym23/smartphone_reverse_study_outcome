package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import com.obric.oui.forms.OEditText;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class j<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet f339889a;

    public j(DoraObricEarbudsAddRuleInputSheet r100) {
        this.f339889a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        DoraObricEarbudsAddRuleInputSheet r103 = this.f339889a;
        r103.f339731h = r102;
        OEditText r104 = r103.f339728e;
        boolean r105 = false;
        if (r104 == null) goto L12;
        Editable r106 = r104.getText();
        if (r106 == null) goto L12;
        if (r106.length() <= 0) goto L9;
        boolean r107 = true;
    L10:
        if (r107 != true) goto L12;
        r105 = true;
        goto L12
    L9:
        r107 = false;
    L12:
        r103.W90(r105);
        return Unit.INSTANCE;
    }
}
