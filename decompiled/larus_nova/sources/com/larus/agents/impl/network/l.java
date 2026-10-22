package com.larus.agents.impl.network;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286705a = 0;

    static {
    }

    public static Object a(String r100, Class r101, JSONObject r102, ContinuationImpl r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WorkExperienceRemote$post$2(r101, r100, r102, null), r103);
    }
}
