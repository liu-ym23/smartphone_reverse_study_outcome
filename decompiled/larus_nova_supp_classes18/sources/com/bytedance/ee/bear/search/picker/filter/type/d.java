package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.search.picker.SpaceSearchViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SearchSelectTypeFragment a;

    public d(SearchSelectTypeFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SearchSelectTypeFragment r3 = this.a;
        if (r3.v == false) goto L17;
        SpaceSearchViewModel r4 = r3.x;
        if (r4 == null) goto L19;
        MutableLiveData<ArrayList<e>> r5 = r4.getDocTypeSelectItem();
        if (r5 == null) goto L19;
        r5.postValue(this.a.ga0());
    L19:
        this.a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L21;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L17:
        r3.v = true;
        r3.ha0();
    }
}
