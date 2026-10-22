package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class i1 implements com.bytedance.ee.bear.doc.resupdate.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f427853a;

    public static final class a {
    }

    static {
    }

    @Inject
    public i1() {
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void i() {
        this.f427853a = false;
        tt5.a.h("OfficeResourceImpl", "reInit ignored for office host");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean j() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        return false;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void a() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        tt5.a.h("OfficeResourceImpl", "checkUpdate ignored for office host, channel=DOC_CHANNEL");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void g() {
        tt5.a.h("OfficeResourceImpl", "checkResourceIsValid ignored for office host");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final com.bytedance.ee.bear.doc.resupdate.e0 getResource() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        com.bytedance.ee.bear.doc.resupdate.e0 r100 = new com.bytedance.ee.bear.doc.resupdate.e0();
        r100.f218009c = "DOC_CHANNEL";
        r100.f218008b = "";
        return r100;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final boolean hasInit() {
        return this.f427853a;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void b(l35.c r100) {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        Intrinsics.checkNotNullParameter(r100, "listener");
        tt5.a.h("OfficeResourceImpl", "registerResUpdateListener ignored for office host, channel=DOC_CHANNEL");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("OfficeResourceImpl", "cleanResource ignored for office host");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void h(com.bytedance.ee.bear.doc.resupdate.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        tt5.a.h("OfficeResourceImpl", "downloadFullRes(callback) ignored for office host");
        r100.onFail();
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f427853a = true;
        tt5.a.h("OfficeResourceImpl", "init ignored for office host");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void d(EChannel r100, com.bytedance.ee.bear.doc.resupdate.a0 r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "listener");
        tt5.a.h("OfficeResourceImpl", "unregisterResUpdateListener ignored for office host, channel=" + r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.i
    public final void e(EChannel r100, com.bytedance.ee.bear.doc.resupdate.a0 r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "listener");
        tt5.a.h("OfficeResourceImpl", "registerResUpdateListener ignored for office host, channel=" + r100);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.g
    public final void f(Context r100, String r101, com.bytedance.ee.bear.doc.resupdate.f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.h("OfficeResourceImpl", "downloadSCM ignored for office host, version=" + r101);
        r102.c(new UnsupportedOperationException("IResource is not supported in officesdk"));
    }
}
