package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f411406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f411407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f411408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f411409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f411410e;

    public n(AutoCompleteTextView r100, EditText r101, f r102, ChameleonDebugActivity r103, Function0 r104) {
        this.f411406a = r100;
        this.f411407b = r101;
        this.f411408c = r102;
        this.f411409d = r103;
        this.f411410e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        String r102 = StringsKt.trim(this.f411406a.getText().toString()).toString();
        String r103 = StringsKt.trim(this.f411407b.getText().toString()).toString();
        boolean r104 = false;
        if (r102.length() <= 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        CmlDebugSettingUtil.b("chameleon_ip_proxy_bizname", r102);
    L9:
        if (r103.length() <= 0) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L13;
        CmlDebugSettingUtil.b("chameleon_ip_proxy_url", r103);
    L13:
        f.a(this.f411408c, this.f411409d, "保存成功，请前往指定页面调试");
        Function0<Unit> r106 = this.f411410e;
        if (r106 == null) goto L17;
        r106.invoke();
        return;
    L17:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
