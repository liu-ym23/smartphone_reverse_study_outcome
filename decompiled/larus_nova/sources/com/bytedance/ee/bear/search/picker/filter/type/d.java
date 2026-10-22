package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.search.picker.SpaceSearchViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchSelectTypeFragment f236924a;

    public d(SearchSelectTypeFragment r100) {
        this.f236924a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SearchSelectTypeFragment r101 = this.f236924a;
        if (r101.f236909v == false) goto L17;
        SpaceSearchViewModel r102 = r101.f236911x;
        if (r102 == null) goto L19;
        MutableLiveData<ArrayList<e>> r103 = r102.getDocTypeSelectItem();
        if (r103 == null) goto L19;
        r103.postValue(this.f236924a.ga0());
    L19:
        this.f236924a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L17:
        r101.f236909v = true;
        r101.ha0();
    }
}
