package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f414558a;

    public interface a {
        void register();

        void unRegister();
    }

    public final void b() {
        Iterator r100 = ((ArrayList) this.f414558a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).register();
        goto L4
    }

    public final void c() {
        Iterator r100 = ((ArrayList) this.f414558a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).unRegister();
        goto L4
    }

    public c0() {
        this.f414558a = new ArrayList();
    }

    public final void a(a r100) {
        ((ArrayList) this.f414558a).add(r100);
    }
}
