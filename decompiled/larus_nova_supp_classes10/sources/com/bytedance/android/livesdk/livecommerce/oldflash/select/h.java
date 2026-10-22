package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.view.View;
import androidx.lifecycle.LiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LiveFlashMultiSelectDialogFragment r5 = this.a.a;
        Function1<? super List<String>, Unit> r0 = r5.k;
        if (r0 == null) goto L24;
        LiveFlashMultiSelectViewModel r6 = (LiveFlashMultiSelectViewModel) r5.g;
        if (r6 == null) goto L14;
        LiveData<List<k>> r7 = r6.getCurrentStringListLiveData();
        if (r7 == null) goto L14;
        List r8 = (List) r7.getValue();
        if (r8 == null) goto L14;
        List r9 = r8;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L15;
        r1.add(((k) r10.next()).a);
    L15:
        Unit r11 = (Unit) r0.invoke(r1);
    L14:
        r1 = new ArrayList();
    L24:
        this.a.a.dismiss();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L27;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
