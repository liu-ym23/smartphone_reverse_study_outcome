package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418493a = 0;

    static {
    }

    public g() {
    }

    public static void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r102 = new Bundle();
        r102.putString("url", r101);
        r102.putBoolean("isNeedLogin", false);
        int r103 = g8b.b.f480460a;
        g8b.b.a.a().getDependency().e().a(r100, r102);
    }
}
