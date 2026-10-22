package com.bytedance.locallife.cube.delegate;

import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.lynx.n;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/cube/delegate/PoiResourceLoaderCallbackDelegate;", "Lcom/bytedance/ies/bullet/lynx/n;", "", "release", "beforeLoadTemplate", "Lcom/bytedance/ies/bullet/service/base/d1;", "resourceInfo", "loadTemplateReady", "", "error", "loadTemplateError", "beforeRender", "afterRender", "beforeReadTemplate", "", "url", "", "lynxFile", "Lcom/bytedance/ies/bullet/core/q;", "listener", "afterReadTemplate", "superRenderCallback", "Lcom/bytedance/ies/bullet/lynx/n;", "getSuperRenderCallback", "()Lcom/bytedance/ies/bullet/lynx/n;", "setSuperRenderCallback", "(Lcom/bytedance/ies/bullet/lynx/n;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/locallife/cube/api/i/ICubeListener;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final class PoiResourceLoaderCallbackDelegate extends n {
    private final CopyOnWriteArrayList<ICubeListener> listeners;
    private n superRenderCallback;

    public final void release() {
        this.listeners.clear();
    }

    public PoiResourceLoaderCallbackDelegate() {
        this.listeners = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void afterRender() {
        super.afterRender();
        n r100 = this.superRenderCallback;
        if (r100 == null) goto L5;
        r100.afterRender();
    L5:
        Iterator<T> r101 = this.listeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ICubeListener r102 = (ICubeListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r102.afterRender();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void beforeLoadTemplate() {
        super.beforeLoadTemplate();
        n r100 = this.superRenderCallback;
        if (r100 == null) goto L5;
        r100.beforeLoadTemplate();
    L5:
        Iterator<T> r101 = this.listeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ICubeListener r102 = (ICubeListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r102.beforeLoadTemplate();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void beforeReadTemplate() {
        super.beforeReadTemplate();
        n r100 = this.superRenderCallback;
        if (r100 == null) goto L5;
        r100.beforeReadTemplate();
    L5:
        Iterator<T> r101 = this.listeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ICubeListener r102 = (ICubeListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r102.beforeReadTemplate();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void beforeRender() {
        super.beforeRender();
        n r100 = this.superRenderCallback;
        if (r100 == null) goto L5;
        r100.beforeRender();
    L5:
        Iterator<T> r101 = this.listeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ICubeListener r102 = (ICubeListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r102.beforeRender();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final CopyOnWriteArrayList<ICubeListener> getListeners() {
        return this.listeners;
    }

    public final n getSuperRenderCallback() {
        return this.superRenderCallback;
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void loadTemplateError(Throwable r100) {
        super.loadTemplateError(r100);
        n r101 = this.superRenderCallback;
        if (r101 == null) goto L5;
        r101.loadTemplateError(r100);
    L5:
        Iterator<T> r102 = this.listeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        ICubeListener r103 = (ICubeListener) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        r103.loadTemplateError(r100);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void loadTemplateReady(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceInfo");
        super.loadTemplateReady(r100);
        n r101 = this.superRenderCallback;
        if (r101 == null) goto L5;
        r101.loadTemplateReady(r100);
    L5:
        Iterator<T> r102 = this.listeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        ICubeListener r103 = (ICubeListener) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        r103.loadTemplateReady(r100);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void setSuperRenderCallback(n r100) {
        this.superRenderCallback = r100;
    }

    @Override // com.bytedance.ies.bullet.lynx.n
    public void afterReadTemplate(String r100, byte[] r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "lynxFile");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super.afterReadTemplate(r100, r101, r102);
        n r103 = this.superRenderCallback;
        if (r103 == null) goto L5;
        r103.afterReadTemplate(r100, r101, r102);
    L5:
        Iterator<T> r104 = this.listeners.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        ICubeListener r105 = (ICubeListener) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        r105.afterReadTemplate(r100, r101, r102);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
