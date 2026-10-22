package com.obric.assistant.state.impl.v2.core;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.api.v2.core.bean.ObricStateKey;
import com.obric.assistant.state.impl.v2.core.statehandler.complextask.ComplexTaskStateHandler;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hha.a f393191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final fha.a f393192b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gha.a f393193c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final iha.a f393194d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ComplexTaskStateHandler f393195e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<ObricStateKey, ObricState> f393196f = null;

    static {
        f393191a = new hha.a();
        f393192b = new fha.a();
        f393193c = new gha.a();
        f393194d = new iha.a();
        f393195e = new ComplexTaskStateHandler();
        f393196f = new ConcurrentHashMap();
    }

    public static void a(ObricState r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        String r101 = r100.getConversationId();
        ObricInteractionScene r102 = r100.getScene();
        if (r102 != null) goto L5;
        r102 = ObricInteractionScene.DEFAULT;
    L5:
        ObricStateKey r103 = new ObricStateKey(r101, r102);
        ConcurrentHashMap<ObricStateKey, ObricState> r104 = f393196f;
        ObricState r105 = r104.get(r103);
        r104.put(r103, r100);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r105 != null) goto L9;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == true) goto L25;
        FLogger.f375446a.i("[ObricStateMachine]", "onObricStateChanged, " + r100.getCurrentIslandState() + ", " + r100.getConversationId() + ", " + r100.getScene());
        ObricStateDispatcher.f393177a.c(r100);
        return;
    L25:
        return;
    L9:
        if (r100.getCurrentIslandState() != r105.getCurrentIslandState()) goto L21;
        if (Intrinsics.areEqual(r100.getConversationId(), r105.getConversationId()) == false) goto L21;
        if (r100.getScene() != r105.getScene()) goto L21;
        if (Intrinsics.areEqual(r100.getSourceMessageId(), r105.getSourceMessageId()) == false) goto L21;
        if (r100.getPriority() != r105.getPriority()) goto L21;
        if (Intrinsics.areEqual(r100.getExt(), r105.getExt()) == false) goto L21;
        r106 = true;
        goto L22
    }
}
