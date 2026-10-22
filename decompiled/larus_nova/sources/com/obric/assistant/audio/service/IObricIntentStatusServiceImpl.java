package com.obric.assistant.audio.service;

import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pba.a;
import pba.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/audio/service/IObricIntentStatusServiceImpl;", "Lcom/obric/assistant/audio/service/IObricIntentStatusService;", "<init>", "()V", "autoGuiProgressCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/audio/callback/IAutoGuiProgressCallback;", "intentStatusCallback", "Lcom/obric/assistant/audio/callback/IObricIntentStatusChangedObserver;", "notifyAutoGuiInProgress", "", "cvsId", "", "questionId", "registerAutoGuiProgressCallback", "callback", "unregisterAutoGuiProgressCallback", "notifyObricIntentStatusChanged", "isActive", "", "registerObricIntentStatusChangedObserver", "unregisterObricIntentStatusChangedObserver", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IObricIntentStatusServiceImpl implements IObricIntentStatusService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f385659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f385660b;

    public IObricIntentStatusServiceImpl() {
        this.f385659a = new CopyOnWriteArrayList();
        this.f385660b = new CopyOnWriteArrayList();
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void b(boolean r100) {
        Iterator<T> r101 = this.f385660b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).a(r100);
        goto L4
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void c(ObricPowerManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f385660b.add(r100);
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        Iterator<a> r102 = this.f385659a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    }
}
