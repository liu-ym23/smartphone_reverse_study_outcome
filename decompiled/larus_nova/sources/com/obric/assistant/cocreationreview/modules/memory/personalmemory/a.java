package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import android.view.View;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements k5<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f387437a = null;

    static {
        f387437a = new a();
    }

    public a() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r100, com.obric.assistant.cocreationreview.a r101) {
        Intrinsics.checkNotNullParameter(r100, "buildContext");
        Intrinsics.checkNotNullParameter((g) r101, "record");
        View r102 = new View(r100.getContext());
        r102.setVisibility(8);
        return r102;
    }
}
