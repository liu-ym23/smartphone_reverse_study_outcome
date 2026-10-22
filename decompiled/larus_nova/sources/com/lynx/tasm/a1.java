package com.lynx.tasm;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class a1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTemplateRender f381786a;

    public /* synthetic */ a1(LynxTemplateRender r100) {
        this.f381786a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f381786a.runOnTasmThread(r100);
    }
}
