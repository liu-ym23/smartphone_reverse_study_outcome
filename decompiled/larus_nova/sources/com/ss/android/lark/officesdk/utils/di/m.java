package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437228a = 0;

    public static final class a {
        @JvmStatic
        public static ntb.r a() {
            DependencyContainer r100 = DependencyContainer.f433166a;
            ntb.r r101 = (ntb.r) DependencyContainer.a(ntb.r.class, null);
            if (r101 == null) goto L6;
            return r101;
        L6:
            throw new IllegalStateException("PassportDependency is not injected");
        }
    }

    static {
    }
}
