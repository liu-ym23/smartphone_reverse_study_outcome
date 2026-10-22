package com.obric.assistant;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 implements com.obric.aiagent.assistant.utils.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricAvailableManagerImpl f385207a;

    public a1(ObricAvailableManagerImpl r100) {
        this.f385207a = r100;
    }

    @Override // com.obric.aiagent.assistant.utils.c
    public final void a(String r100, String r101) {
        l4 r102 = this.f385207a.f385143d;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
