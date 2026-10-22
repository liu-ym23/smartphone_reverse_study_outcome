package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenFileInfo f421622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f421623b;

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final void v() {
        hfb.b.d r100 = a.f421619a;
        a.a(this.f421623b, this.f421622a);
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final boolean w() {
        String r100 = this.f421622a.threadId;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L14;
        hfb.b.d r102 = a.f421619a;
        if (r102 == null) goto L19;
        String r103 = this.f421622a.threadId;
        r102.h();
    L19:
        return true;
    L14:
        if (this.f421622a.mJumpPosition != (-1)) goto L16;
        return false;
    L16:
        hfb.b.d r104 = a.f421619a;
        if (r104 == null) goto L19;
        r104.f();
        goto L19
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public b(OpenFileInfo r100, Context r101) {
        this.f421622a = r100;
        this.f421623b = r101;
    }
}
