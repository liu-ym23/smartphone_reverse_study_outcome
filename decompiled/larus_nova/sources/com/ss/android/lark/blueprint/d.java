package com.ss.android.lark.blueprint;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<?> f410637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vza.e f410638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f410639c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f410640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vza.e f410641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vza.d f410642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final vza.a f410643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public o<?> f410644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f410645f;

        public final Context getContext() {
            return this.f410640a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f410640a = r100;
            this.f410641b = new vza.e();
            this.f410642c = new vza.d();
            this.f410643d = new vza.a();
            this.f410645f = 100;
        }

        public final void b(wza.d r100) {
            Intrinsics.checkNotNullParameter(r100, "layoutFactory");
            vza.e r101 = this.f410641b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "layoutFactory");
            r101.f557760b.put(r100.getType(), r100);
        }

        public final void a(j r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "createBlock");
            vza.e r102 = this.f410641b;
            c r103 = new c(r100, r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "blockFactory");
            r102.f557761c.put(r103.getKey(), r103);
        }
    }

    public d(a r100) {
        o<?> r101 = null;
        if (r100.f410645f <= 0) goto L9;
        o<?> r102 = r100.f410644e;
        if (r102 == null) goto L7;
        r101 = r102;
    L8:
        o<?> r103 = new h(r101, r100.f410645f);
    L14:
        this.f410637a = r103;
        vza.e r104 = r100.f410641b;
        this.f410638b = r104;
        this.f410639c = new g(r100.getContext(), r104, r100.f410642c, r100.f410643d, new vza.b(), new vza.c());
        return;
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("cellSpecMapper");
        goto L8
    L9:
        o<?> r105 = r100.f410644e;
        if (r105 == null) goto L12;
        r101 = r105;
    L13:
        r103 = r101;
        goto L14
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("cellSpecMapper");
        goto L13
    }
}
