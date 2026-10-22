package com.lynx.component.svg;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UISvg f381019a;

    public class a implements SVGRender.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f381020a;

        public a(h r100) {
            this.f381020a = r100;
        }

        @Override // com.lynx.serval.svg.SVGRender.c
        public final void a(String r100, SVGRender.a r101) {
            this.f381020a.f381019a.f380960d.b(r100, new g(r101));
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
        if (this.f381019a.f380967k == true) goto L10;
        SVGRender r100 = new SVGRender();     // Catch: Throwable -> L7
        r100.setResourceManager(new a(this));     // Catch: Throwable -> L7
        this.f381019a.f380966j = r100;     // Catch: Throwable -> L7
        return;
    }

    public h(UISvg r100) {
        this.f381019a = r100;
    }
}
