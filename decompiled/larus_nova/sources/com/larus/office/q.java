package com.larus.office;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f363609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Long, Function0<Unit>, v> f363610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f363611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Throwable, Unit> f363612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f363613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, a> f363614f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f363615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f363616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function1<String, Unit>> f363617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public v f363618d;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f363615a, r101.f363615a) == true) goto L12;
            return false;
        L12:
            if (this.f363616b == r101.f363616b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f363617c, r101.f363617c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f363618d, r101.f363618d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f363615a.hashCode() * 31;
            if (this.f363616b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f363617c.hashCode()) * 31;
            v r103 = this.f363618d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Attempt(resolution=" + this.f363615a + ", hostDestroyed=" + this.f363616b + ", pendingReports=" + this.f363617c + ", timeout=" + this.f363618d + ')';
        }

        public a(Object r100) {
            b.C4450b r101 = b.C4450b.f363620a;
            ArrayList r102 = new ArrayList();
            Intrinsics.checkNotNullParameter(r101, "resolution");
            Intrinsics.checkNotNullParameter(r102, "pendingReports");
            this.f363615a = r101;
            this.f363616b = false;
            this.f363617c = r102;
            this.f363618d = null;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f363619a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f363619a, ((a) r100).f363619a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r100 = this.f363619a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Finished(docCardMessageId=" + this.f363619a + ')';
            }

            public a(String r100) {
                this.f363619a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.office.q$b$b, reason: collision with other inner class name */
        public static final class C4450b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4450b f363620a = null;

            static {
                f363620a = new C4450b();
            }

            public C4450b() {
            }
        }

        public b() {
        }
    }

    public q(r r100, Function1 r101, s r102) {
        Intrinsics.checkNotNullParameter(r100, "scheduleTimeout");
        Intrinsics.checkNotNullParameter(r101, "onStateChanged");
        Intrinsics.checkNotNullParameter(r102, "onCallbackError");
        this.f363609a = 300000;
        this.f363610b = r100;
        this.f363611c = r101;
        this.f363612d = r102;
        this.f363613e = new Object();
        this.f363614f = new LinkedHashMap();
    }
}
