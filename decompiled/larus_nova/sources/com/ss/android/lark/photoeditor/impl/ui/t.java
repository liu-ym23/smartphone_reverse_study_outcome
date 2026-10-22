package com.ss.android.lark.photoeditor.impl.ui;

import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class t implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f438628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f438629b;

    public t(String[] r100, Map r101) {
        this.f438628a = r100;
        this.f438629b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r101 < 0) goto L10;
        String[] r102 = this.f438628a;
        if (r101 >= r102.length) goto L12;
        String r103 = r102[r101];
        r0c.d r104 = (r0c.d) this.f438629b.get(r103);
        if (r104 == null) goto L11;
        r104.getAction().run();
        return;
    L11:
        return;
    L12:
        return;
    }
}
