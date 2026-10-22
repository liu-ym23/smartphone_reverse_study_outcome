package com.ss.android.lark.officesdk.utils.di;

import android.content.Context;
import android.widget.Toast;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ntb.x;

/* JADX INFO: loaded from: classes37.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437234a = 0;

    public static final class a {
        @JvmStatic
        public static void a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "message");
            DependencyContainer r102 = DependencyContainer.f433166a;
            x r103 = (x) DependencyContainer.a(x.class, null);
            if (r103 == null) goto L5;
            r103.show(r100, r101);
            return;
        L5:
            Toast.makeText(r100, r101, 0).show();
        }
    }

    static {
    }
}
