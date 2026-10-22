package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverrideUIMoreItemFactory f234952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f234953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f234954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f234955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f234956e;

    public d0(OverrideUIMoreItemFactory r100, String r101, q r102, x r103, View.OnClickListener r104) {
        this.f234952a = r100;
        this.f234953b = r101;
        this.f234954c = r102;
        this.f234955d = r103;
        this.f234956e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (OverrideUIMoreItemFactory.c(this.f234952a, this.f234953b, this.f234954c, this.f234955d) == true) goto L8;
        View.OnClickListener r101 = this.f234956e;
        if (r101 == null) goto L9;
        r101.onClick(r100);
        return;
    L9:
        return;
    }
}
