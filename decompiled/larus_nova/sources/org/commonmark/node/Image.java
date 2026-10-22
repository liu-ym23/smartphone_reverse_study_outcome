package org.commonmark.node;

import uvc.b;
import uvc.c;

/* JADX INFO: loaded from: classes5.dex */
public class Image extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f525770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f525771i;

    @Override // uvc.b
    public final String f() {
        return "destination=" + this.f525770h + ", title=" + this.f525771i;
    }

    public Image() {
    }

    @Override // uvc.b
    public final void a(c r100) {
        r100.h(this);
    }

    public Image(String r100, String r101) {
        this.f525770h = r100;
        this.f525771i = r101;
    }
}
