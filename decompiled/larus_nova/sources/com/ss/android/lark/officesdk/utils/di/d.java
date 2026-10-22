package com.ss.android.lark.officesdk.utils.di;

import android.app.Application;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437220a = 0;

    public static final class a {
        @JvmStatic
        public static Application a() {
            DependencyContainer r100 = DependencyContainer.f433166a;
            ntb.e r101 = (ntb.e) DependencyContainer.a(ntb.e.class, null);
            if (r101 == null) goto L7;
            return r101.getApplication();
        L7:
            throw new IllegalStateException("IContextDependency not injected");
        }
    }

    static {
    }

    @JvmStatic
    public static final Application a() {
        return a.a();
    }
}
