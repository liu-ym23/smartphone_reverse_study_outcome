package com.larus.home.impl.main.side_bar.view;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes29.dex */
public final class a2 extends gx8.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a2 f344858b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f344859c = null;

    public static final class a implements gx8.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f344860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f344861b;

        public a() {
            this.f344860a = "side_bar_open";
            this.f344861b = "basic_performance_operation_count";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }

        @Override // gx8.e
        public final String getEventType() {
            return this.f344860a;
        }

        @Override // gx8.e
        public final String getUploadName() {
            return this.f344861b;
        }
    }

    @Override // gx8.a
    public final gx8.d b() {
        return null;
    }

    static {
        f344858b = new a2();
        f344859c = LazyKt.lazy(new z1());
    }

    public a2() {
    }
}
