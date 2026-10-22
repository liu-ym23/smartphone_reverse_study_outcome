package org.commonmark.node;

import uvc.b;
import uvc.c;

/* JADX INFO: loaded from: classes5.dex */
public class Text extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f525783h;

    @Override // uvc.b
    public final String f() {
        return "literal=" + this.f525783h;
    }

    public Text() {
    }

    public Text(String r100) {
        this.f525783h = r100;
    }

    @Override // uvc.b
    public final void a(c r100) {
        r100.l(this);
    }
}
