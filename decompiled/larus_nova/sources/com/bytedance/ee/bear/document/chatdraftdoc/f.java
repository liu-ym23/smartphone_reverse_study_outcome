package com.bytedance.ee.bear.document.chatdraftdoc;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f219203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f219205c;

    public f(String r100, String r101, Function0<Unit> r102) {
        this.f219203a = r100;
        this.f219204b = r101;
        this.f219205c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        i r102 = h.f219209a;
        String r103 = this.f219203a;
        String r104 = this.f219204b;
        com.bytedance.ee.util.ui.j.f(new d(this.f219205c));
        com.bytedance.ee.util.ui.j.d(new e(r104, r103), 250);
    }
}
