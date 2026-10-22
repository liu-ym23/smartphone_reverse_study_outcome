package com.lynx.react.bridge.mapbuffer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Iterator<d.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f381452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f381453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f381454c;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f381452a >= this.f381453b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final d.a next() {
        d r100 = this.f381454c;
        int r101 = this.f381452a;
        this.f381452a = r101 + 1;
        return new d.a(r100, r100.a(r101));
    }

    public c(d r100) {
        this.f381454c = r100;
        this.f381452a = 0;
        this.f381453b = r100.f381456b;
    }
}
