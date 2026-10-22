package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowVoiceInteractionIDLStubWrapper>> f384598a = null;

    static {
        f384598a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IFlowVoiceInteractionIDL.Stub a(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final FlowVoiceInteractionIDLStub r101 = new FlowVoiceInteractionIDLStub();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<IBinder, WeakReference<FlowVoiceInteractionIDLStubWrapper>> r102 = f384598a;
        monitor-enter(r102);
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r101.asBinder());     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        FlowVoiceInteractionIDLStubWrapper r104 = (FlowVoiceInteractionIDLStubWrapper) r103.get();     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
        r104.log = true;     // Catch: Throwable -> L25
        monitor-exit(r102);
    L21:
        return r104;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r102);
        if ((r101 instanceof FlowVoiceInteractionIDLStubWrapper) == false) goto L16;
        r104 = new FlowVoiceInteractionIDLStubWrapper(((FlowVoiceInteractionIDLStubWrapper) r101).origin, true);
    L17:
        monitor-enter(r102);
        CollectionsKt.removeAll(((LinkedHashMap) r102).entrySet(), new x3());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowVoiceInteractionIDL", "Stub.wrap, (" + r104 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowVoiceInteractionIDLStubWrapper> r107 = r102.put(r101.asBinder(), new WeakReference(r104));     // Catch: Throwable -> L22
        monitor-exit(r102);
        r104.linkToDeath(new w3(r101), 0);
    L22:
        th = move-exception;
        throw th;
    L16:
        r104 = new FlowVoiceInteractionIDLStubWrapper(r101, true);
    L25:
        th = move-exception;
        throw th;
    }
}
