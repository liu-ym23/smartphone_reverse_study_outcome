package com.larksuite.arch.jack;

import androidx.arch.core.util.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f282798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function<? super Runnable, ? extends Runnable> f282799b;

    public static final class a {
        public a() {
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter("ISubscriber", "tag");
            Intrinsics.checkNotNullParameter(r100, "message");
        }
    }

    static {
        f282798a = new a();
    }
}
