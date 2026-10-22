package com.larus.platform.service.watermark;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365852a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365852a, ((a) r100).f365852a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365852a.hashCode();
        }

        public final String toString() {
            return "Degraded(reason=" + this.f365852a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f365852a = r100;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Continuation<? super Unit>, Object> f365854b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f365853a, r101.f365853a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f365854b, r101.f365854b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f365853a.hashCode() * 31) + this.f365854b.hashCode();
        }

        public final String toString() {
            return "Ready(url=" + this.f365853a + ", cleanup=" + this.f365854b + ')';
        }

        public /* synthetic */ b(String r100) {
            this(r100, new WatermarkResult$Ready$1(null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "cleanup");
            this.f365853a = r100;
            this.f365854b = r101;
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365855a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365855a, ((c) r100).f365855a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365855a.hashCode();
        }

        public final String toString() {
            return "ReadyLocalFile(localPath=" + this.f365855a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "localPath");
            this.f365855a = r100;
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.platform.service.watermark.c f365856a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365856a, ((d) r100).f365856a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365856a.hashCode();
        }

        public final String toString() {
            return "ReadyLocalImage(output=" + this.f365856a + ')';
        }

        public d(com.larus.platform.service.watermark.c r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
            this.f365856a = r100;
        }
    }

    public g() {
    }
}
