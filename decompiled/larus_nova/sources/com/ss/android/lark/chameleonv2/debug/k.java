package com.ss.android.lark.chameleonv2.debug;

import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f411394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f411395b;

    public k(EditText r100, EditText r101) {
        this.f411394a = r100;
        this.f411395b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Editable r102 = this.f411394a.getText();
        String r103 = "";
        if (r102 == null) goto L8;
        String r104 = r102.toString();
        if (r104 == null) goto L8;
        String r105 = StringsKt.trim(r104).toString();
        if (r105 == null) goto L8;
    L9:
        CmlDebugSettingUtil.b("chameleon_header_username", r105);
        Editable r106 = this.f411395b.getText();
        if (r106 == null) goto L17;
        String r107 = r106.toString();
        if (r107 == null) goto L17;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L17;
        r103 = r108;
    L17:
        CmlDebugSettingUtil.b("chameleon_header_pwd", r103);
        return;
    L8:
        r105 = "";
        goto L9
    }
}
