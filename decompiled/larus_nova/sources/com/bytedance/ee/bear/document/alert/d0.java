package com.bytedance.ee.bear.document.alert;

import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d0 implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertModel.RadioOptions f218896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f218897b;

    public d0(AlertModel.RadioOptions r100, TextView r101) {
        this.f218896a = r100;
        this.f218897b = r101;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        if (TextUtils.isEmpty(this.f218896a.getInfo()) == true) goto L11;
        TextView r102 = this.f218897b;
        if (r102 == null) goto L12;
        if (r101 == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    L12:
        return;
    }
}
