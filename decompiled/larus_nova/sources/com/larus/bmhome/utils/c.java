package com.larus.bmhome.utils;

import com.bytedance.apm.ApmAgent;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f314979a = null;

    static {
        f314979a = LazyKt.lazy(new b());
    }

    public static void a(String r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (((Set) f314979a.getValue()).contains(r100) == true) goto L6;
        if (r102 == true) goto L6;
        return;
    L6:
        ApmAgent.monitorEvent(r100, r101, null, null);
    }
}
