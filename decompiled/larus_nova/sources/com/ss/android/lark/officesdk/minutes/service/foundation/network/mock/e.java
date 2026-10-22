package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import kotlin.Result;

/* JADX INFO: loaded from: classes37.dex */
public abstract class e<T> {

    public static final class a<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f433951a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Result.m9451equalsimpl0(this.f433951a, ((a) r100).f433951a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Result.m9454hashCodeimpl(this.f433951a);
        }

        public final String toString() {
            return "Hit(result=" + Result.m9457toStringimpl(this.f433951a) + ')';
        }

        public a(Object r100) {
            this.f433951a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f433952a = null;

        static {
            f433952a = new b();
        }

        public b() {
        }
    }

    public e() {
    }
}
