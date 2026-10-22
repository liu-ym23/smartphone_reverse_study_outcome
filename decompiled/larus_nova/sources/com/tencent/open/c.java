package com.tencent.open;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes29.dex */
public abstract class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f461741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final WebChromeClient f461742b;

    public abstract void a(String r100);

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f461741a = new b();
    }

    public c(Context r100, int r101) {
        super(r100, r101);
        this.f461742b = new AnonymousClass1(this);
    }
}
