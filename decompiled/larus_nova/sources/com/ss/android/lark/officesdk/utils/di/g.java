package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437223a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            DependencyContainer r101 = DependencyContainer.f433166a;
            ntb.h r102 = (ntb.h) DependencyContainer.a(ntb.h.class, null);
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.isEnable(r100);
        }
    }

    static {
    }
}
