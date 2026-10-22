package com.larus.browsertakeover.entry;

import com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor;
import hv8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f319480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C4138a f319481b;

    /* JADX INFO: renamed from: com.larus.browsertakeover.entry.a$a, reason: collision with other inner class name */
    public static final class C4138a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hv8.a f319482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f319483b;

        public C4138a(hv8.a r100, RequestActionBrowserOperationInterceptor.CompletionDelegate r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f319482a = r100;
            this.f319483b = r101;
        }
    }

    static {
    }
}
