package com.ss.android.lark.officesdk.utils.di;

import android.content.Context;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437221a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            DependencyContainer r101 = DependencyContainer.f433166a;
            ntb.f r102 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.J(r100);
        }

        @JvmStatic
        public static boolean b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            DependencyContainer r101 = DependencyContainer.f433166a;
            ntb.f r102 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.V(r100);
        }
    }

    static {
    }
}
