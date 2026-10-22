package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.ee.bear.bitable.card.view.cell.number.STNumberKeyboardView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class u0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211648a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    public u0(ProgressFieldPropertyEditViewHolder r100) {
        this.f211648a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        ProgressFieldPropertyEditViewHolder r101 = this.f211648a;
        if (r101.f211224y != r101.f211223x) goto L22;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r102 = r101.f211219t;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.f207923c != true) goto L9;
    L10:
        if (r103 == false) goto L23;
        Editable r104 = null;
        if (r102 == null) goto L17;
        STNumberKeyboardView r105 = r102.f207922b;
        if (r105 == null) goto L17;
        r104 = r105.getEditableText();
    L17:
        if (Intrinsics.areEqual(r100, r104) == true) goto L24;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r106 = this.f211648a.f211219t;
        if (r106 == null) goto L25;
        r106.a(r100);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L9:
        r103 = false;
        goto L10
    }
}
