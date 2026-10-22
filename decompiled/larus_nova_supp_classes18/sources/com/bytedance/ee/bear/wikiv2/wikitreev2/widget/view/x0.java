package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.app.Dialog;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x0<T> implements Consumer {
    public final /* synthetic */ WikiTreeCtrlView a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

    public x0(WikiTreeCtrlView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        WikNodePerm r7 = (WikNodePerm) r6;
        tt5.a.b(this.a.e, "requestNodePerm. wikiPerm: " + r7);
        WikiDialogs r0 = this.a.j;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.b;
        Intrinsics.checkNotNull(r7);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r7, "wikiPerm");
        WikiCreateSelectPanelDialog r2 = r0.e;
        if (r2 == null) goto L26;
        Dialog r3 = r2.getDialog();
        boolean r4 = false;
        if (r3 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L25:
        tt5.a.b("WikiDialogs", "updateCreateTypeSelector, dialog dismiss, return. ");
        goto L26
    L12:
        if (TextUtils.equals(r2.l, r1.b) == false) goto L25;
        boolean r8 = r7.can_create;
        Dialog r9 = r2.getDialog();
        if (r9 != null) goto L17;
    L19:
        if (r4 == false) goto L26;
        WikiCreateSelectPanelDialog._ViewModel r10 = (WikiCreateSelectPanelDialog._ViewModel) r2.j.getValue();
        if (r10 == null) goto L26;
        MutableLiveData<Boolean> r11 = r10.getCanCreateDoc();
        if (r11 == null) goto L26;
        r11.setValue(Boolean.valueOf(r8));
        goto L26
    L17:
        if (r9.isShowing() != true) goto L19;
        r4 = true;
        goto L19
    L7:
        if (r3.isShowing() != true) goto L9;
        r5 = true;
    L26:
        this.a.j.o(this.b, r7);
    }
}
