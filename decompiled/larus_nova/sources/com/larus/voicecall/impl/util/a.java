package com.larus.voicecall.impl.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        Object r102 = r100.getSystemService("accessibility");     // Catch: Throwable -> L21
        if ((r102 instanceof AccessibilityManager) == false) goto L6;
        AccessibilityManager r103 = (AccessibilityManager) r102;     // Catch: Throwable -> L21
    L7:
        if (r103 != null) goto L11;
        FLogger.f375446a.e("AccessibilityHelper", " isTalkBackEnabled accessibilityManager is null");     // Catch: Throwable -> L21
        return false;
    L11:
        if (r103.isEnabled() == true) goto L14;
        FLogger.f375446a.e("AccessibilityHelper", " isTalkBackEnabled accessibilityManager not enabled");     // Catch: Throwable -> L21
        return false;
    L14:
        List<AccessibilityServiceInfo> r104 = r103.getEnabledAccessibilityServiceList(1);     // Catch: Throwable -> L21
        Iterator<AccessibilityServiceInfo> r105 = r104.iterator();     // Catch: Throwable -> L21
    L16:
        if (r105.hasNext() == false) goto L18;
        String r106 = r105.next().getResolveInfo().serviceInfo.name;     // Catch: Throwable -> L21
        FLogger.f375446a.i("AccessibilityHelper", " isTalkBackEnabled not found TalkBack. service=" + r106);     // Catch: Throwable -> L21
        goto L16
    L18:
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L21
        return !r104.isEmpty();
    L6:
        r103 = null;
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Throwable r108 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r108 == null) goto L26;
        FLogger.f375446a.e("AccessibilityHelper", " isTalkBackEnabled error", r108);
    L26:
        FLogger.f375446a.i("AccessibilityHelper", " isTalkBackEnabled finally return false");
        return false;
    }
}
