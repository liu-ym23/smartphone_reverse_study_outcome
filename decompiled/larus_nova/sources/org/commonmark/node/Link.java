package org.commonmark.node;

import uvc.b;
import uvc.c;

/* JADX INFO: loaded from: classes5.dex */
public class Link extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f525773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f525774i;

    @Override // uvc.b
    public final String f() {
        return "destination=" + this.f525773h + ", title=" + this.f525774i;
    }

    public Link() {
    }

    @Override // uvc.b
    public final void a(c r100) {
        r100.D(this);
    }

    public Link(String r100, String r101) {
        this.f525773h = r100;
        this.f525774i = r101;
    }
}
