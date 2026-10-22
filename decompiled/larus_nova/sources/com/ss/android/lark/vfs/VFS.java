package com.ss.android.lark.vfs;

import android.app.Application;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VFS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f444817a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f444818a;

        public a(Application r100) {
            Intrinsics.checkNotNullParameter(r100, "application");
            this.f444818a = r100;
        }
    }

    static {
        f444817a = LazyKt.lazy(VFS$facManager$2.INSTANCE);
    }
}
