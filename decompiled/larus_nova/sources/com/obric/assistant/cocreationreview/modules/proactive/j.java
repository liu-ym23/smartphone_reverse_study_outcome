package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.m5;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f387484a = null;

    static {
        f387484a = new j();
    }

    public j() {
    }

    @Override // com.obric.assistant.cocreationreview.m5
    public final e5 a(Context r100) {
        return new g(new ProactiveAgentRepository(r100));
    }
}
