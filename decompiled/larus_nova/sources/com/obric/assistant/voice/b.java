package com.obric.assistant.voice;

import com.obric.eventkit.eventstaskmanager.AppEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    public static final a a(ContentScene r100, AppEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r101 == null) goto L6;
        String r102 = r101.getContent();
        if (r102 == null) goto L6;
    L7:
        a r103 = new a(r100, r102);
        r103.f394373e = r101;
        return r103;
    L6:
        r102 = "";
        goto L7
    }
}
