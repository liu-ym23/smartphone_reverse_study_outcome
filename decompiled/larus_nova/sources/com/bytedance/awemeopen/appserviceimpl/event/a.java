package com.bytedance.awemeopen.appserviceimpl.event;

import android.content.Context;
import com.bytedance.awemeopen.infra.util.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198103a = 0;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (l.a("com.ss.android.ugc.aweme", r100) == false) goto L7;
        return "douyin";
    L7:
        if (l.a("com.ss.android.ugc.aweme.lite", r100) == false) goto L10;
        return "douyinLite";
    L10:
        return "H5";
    }
}
