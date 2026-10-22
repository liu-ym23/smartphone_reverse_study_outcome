package com.bytedance.ee.bear.document.ai.citation;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocAICitationFragment f218765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShowCitationData f218766b;

    public h(DocAICitationFragment r100, ShowCitationData r101) {
        this.f218765a = r100;
        this.f218766b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Log.i("DocAICitationFragment", "showDeleteDialog -- onDismiss");
        DocAICitationFragment r101 = this.f218765a;
        String r102 = DocAICitationClickType.Close.getType();
        String r103 = this.f218766b.getId();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        int r104 = DocAICitationFragment.f218730r;
        r101.fa0(r102, r103);
    }
}
