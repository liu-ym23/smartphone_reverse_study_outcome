package com.ss.android.account.share.data.write;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f406337b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f406338a;

    /* JADX INFO: renamed from: com.ss.android.account.share.data.write.a$a, reason: collision with other inner class name */
    public static final class C4701a {
        @JvmStatic
        public static a a(Context r100) {
            if (a.f406337b == null) goto L5;
        L15:
            a r101 = a.f406337b;
            if (r101 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            return r101;
        L5:
            monitor-enter(a.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (a.f406337b != null) goto L9;
            a.f406337b = new a(r100.getApplicationContext());     // Catch: Throwable -> L12
        L9:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(a.class);
            goto L15
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f406338a;
    }

    public a(Context r100) {
        this.f406338a = r100;
    }
}
