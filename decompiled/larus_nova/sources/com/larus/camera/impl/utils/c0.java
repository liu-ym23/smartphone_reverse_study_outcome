package com.larus.camera.impl.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f322738d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Boolean> f322739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f322740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f322741c;

    public static final class a {
        public static float a(int r100, boolean r101) {
            if (r100 != 90) goto L5;
            return -90.0f;
        L5:
            if (r100 == 270) goto L11;
            if (r101 == true) goto L8;
        L10:
            return 0.0f;
        L8:
            if (r100 != 180) goto L10;
            return 180.0f;
        L11:
            return 90.0f;
        }
    }

    static {
    }

    public c0(Context r100, com.larus.camera.impl.ui.viewmodel.g0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onChange");
        this.f322739a = r101;
        this.f322740b = -1;
        d0 r102 = new d0(this, r100.getApplicationContext());
        this.f322741c = r102;
        r102.enable();
    }
}
