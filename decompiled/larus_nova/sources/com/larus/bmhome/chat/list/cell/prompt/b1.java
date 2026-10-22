package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class b1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f305554a;

    public /* synthetic */ b1(c1 r100) {
        this.f305554a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1 r100 = this.f305554a;
        IAIChatRenderTraceService.f365896a.m(r100.a(), "");
        FLogger.f375446a.i("WcbFillInputMgr", "clear autoFillPrompt");
    }
}
