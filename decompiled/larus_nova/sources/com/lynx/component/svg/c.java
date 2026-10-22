package com.lynx.component.svg;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.component.svg.a f381006a;

    public class a implements SVGRender.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f381007a;

        public a(c r100) {
            this.f381007a = r100;
        }

        @Override // com.lynx.serval.svg.SVGRender.c
        public final void a(String r100, SVGRender.a r101) {
            this.f381007a.f381006a.f380989s.b(r100, new b(r101));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f381006a.f380992v == true) goto L10;
        SVGRender r100 = new SVGRender();     // Catch: Throwable -> L7
        r100.setResourceManager(new a(this));     // Catch: Throwable -> L7
        this.f381006a.f380988r = r100;     // Catch: Throwable -> L7
        return;
    }

    public c(com.lynx.component.svg.a r100) {
        this.f381006a = r100;
    }
}
