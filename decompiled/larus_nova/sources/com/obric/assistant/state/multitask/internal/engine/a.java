package com.obric.assistant.state.multitask.internal.engine;

import jha.q;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f393315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f393316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f393317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f393318d;

    public /* synthetic */ a(String r100, String r101, Long r102, q r103) {
        this.f393315a = r100;
        this.f393316b = r101;
        this.f393317c = r102;
        this.f393318d = r103;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f393315a;
        String r101 = this.f393316b;
        Long r102 = this.f393317c;
        q r103 = this.f393318d;
        com.obric.assistant.state.multitask.a.C4634a r104 = new com.obric.assistant.state.multitask.a.C4634a(r100, r101);
        if (r102 == null) goto L5;
        long r105 = r102.longValue();
    L7:
        return new com.obric.assistant.state.multitask.a("TaskFlowEventBus", r104, r105, r103);
    L5:
        r105 = 0;
        goto L7
    }
}
