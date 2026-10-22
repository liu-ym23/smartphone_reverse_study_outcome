package com.ss.android.lark.inline.ai.utils;

import android.content.Context;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427695a = 0;

    static {
    }

    public static String a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r100 = new ArrayList();
        String r111 = ApkUtil.getAppVersionName(r110);
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isMempopeApp() == false) goto L9;
        r100.add("MemPope/".concat(r111));
    L9:
        return CollectionsKt.joinToString$default(r100, " ", null, null, 0, null, null, 62, null);
    }
}
