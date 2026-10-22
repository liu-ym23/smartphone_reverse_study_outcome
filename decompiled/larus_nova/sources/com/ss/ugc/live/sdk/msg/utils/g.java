package com.ss.ugc.live.sdk.msg.utils;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import java.lang.Throwable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class g<V, E extends Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458477a = 0;

    public static final class a {
        public static b a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, BaseHttpRequestInfo.KEY_EXCEPTION);
            return new b(r100);
        }
    }

    public static final class b<E extends Throwable> extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final E f458478b;

        public final int hashCode() {
            return this.f458478b.hashCode();
        }

        public final String toString() {
            return "[Failure: " + this.f458478b + ']';
        }

        public b(E r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f458478b = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.f458478b, ((b) r100).f458478b) == false) goto L10;
            return true;
        }
    }

    public static final class c<V> extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f458479b;

        public final int hashCode() {
            V r100 = this.f458479b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "[Success: " + this.f458479b + ']';
        }

        public c(V r100) {
            this.f458479b = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.f458479b, ((c) r100).f458479b) == false) goto L10;
            return true;
        }
    }

    static {
    }

    public g() {
    }
}
