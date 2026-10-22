package com.ss.android.lark.integrator.ccm;

import cmb.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class WikiModuleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WikiModule f427784a;

    public static class WikiModule {

        @Retention(RetentionPolicy.SOURCE)
        public @interface DocSearchType {
            public static final String WIKI = "wiki";
        }

        public WikiModule() {
            kmb.a.a();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f427785a = 0;

        static {
            new HashMap();
        }
    }

    public static WikiModule a() {
        if (f427784a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f427784a != null) goto L9;
        f427784a = new WikiModule();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f427784a;
    }
}
