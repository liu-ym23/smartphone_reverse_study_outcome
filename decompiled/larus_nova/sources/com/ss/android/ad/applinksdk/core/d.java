package com.ss.android.ad.applinksdk.core;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f406356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f406357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f406358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f406359d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f406360e = null;

    public static final class a implements hra.a {
        public a() {
        }
    }

    public static final class b implements hra.b {
        public b() {
        }
    }

    public d() {
    }

    static {
        f406360e = new d();
        f406359d = "";
    }

    public static hra.a a() {
        if (f406356a != null) goto L6;
        f406356a = new a();
        Unit r100 = Unit.INSTANCE;
    L6:
        a r101 = f406356a;
        if (r101 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        return r101;
    }

    public static hra.b b() {
        if (f406357b != null) goto L6;
        f406357b = new b();
        Unit r100 = Unit.INSTANCE;
    L6:
        b r101 = f406357b;
        if (r101 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        return r101;
    }
}
