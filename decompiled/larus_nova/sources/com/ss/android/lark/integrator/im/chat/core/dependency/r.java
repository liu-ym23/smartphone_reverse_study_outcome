package com.ss.android.lark.integrator.im.chat.core.dependency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import w4b.c0;

/* JADX INFO: loaded from: classes36.dex */
public final class r implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<aqb.g, qpc.d> f427927a = null;

    public class a implements qpc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ aqb.g f427928a;

        public a(aqb.g r100) {
            this.f427928a = r100;
        }

        @Override // qpc.d
        public final void onPushUploadProgress(String r100, int r101) {
            this.f427928a.onPushUploadProgress(r100, r101);
        }
    }

    public r() {
    }

    @Override // w4b.c0
    public final void c() {
    }

    @Override // w4b.c0
    public final void e() {
    }

    @Override // w4b.c0
    public final void f() {
    }

    @Override // w4b.c0
    public final void h() {
    }

    @Override // w4b.c0
    public final void i() {
    }

    @Override // w4b.c0
    public final void j() {
    }

    @Override // w4b.c0
    public final void k() {
    }

    @Override // w4b.c0
    public final void l() {
    }

    static {
        f427927a = new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    @Override // w4b.c0
    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.e r100) {
        nmb.a.a().getCCMDependency().a();
    }

    @Override // w4b.c0
    public final void b(aqb.g r100) {
        a r101 = new a(r100);
        ((ConcurrentHashMap) f427927a).put(r100, r101);
        nmb.a.a().getCoreDependency().o(r101);
    }

    @Override // w4b.c0
    public final void d(aqb.g r100) {
        Map<aqb.g, qpc.d> r101 = f427927a;
        qpc.d r102 = (qpc.d) ((ConcurrentHashMap) r101).get(r100);
        ((ConcurrentHashMap) r101).remove(r100);
        if (r102 == null) goto L6;
        nmb.a.a().getCoreDependency().removePushResourceUploadProgressListener(r102);
        return;
    }

    @Override // w4b.c0
    public final void g(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.e r100) {
        nmb.a.a().getCCMDependency().c();
    }
}
