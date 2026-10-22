package com.larus.multitask_management.api.spi.net;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T> {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f359399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f359400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f359401c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f359399a == r101.f359399a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359400b, r101.f359400b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f359401c, r101.f359401c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f359399a * 31) + this.f359400b.hashCode()) * 31;
            Throwable r101 = this.f359401c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // com.larus.multitask_management.api.spi.net.b
        public final String toString() {
            return "Error(code=" + this.f359399a + ", msg=" + this.f359400b + ", throwable=" + this.f359401c + ')';
        }

        public a(int r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f359399a = r100;
            this.f359400b = r101;
            this.f359401c = r102;
        }
    }

    /* JADX INFO: renamed from: com.larus.multitask_management.api.spi.net.b$b, reason: collision with other inner class name */
    public static final class C4423b<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.multitask_management.api.spi.net.a<T> f359402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f359403b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4423b) == true) goto L8;
            return false;
        L8:
            C4423b r101 = (C4423b) r100;
            if (Intrinsics.areEqual(this.f359402a, r101.f359402a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359403b, r101.f359403b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f359402a.hashCode() * 31;
            Throwable r101 = this.f359403b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // com.larus.multitask_management.api.spi.net.b
        public final String toString() {
            return "Success(bizResp=" + this.f359402a + ", throwable=" + this.f359403b + ')';
        }

        public C4423b(com.larus.multitask_management.api.spi.net.a r100) {
            Intrinsics.checkNotNullParameter(r100, "bizResp");
            this.f359402a = r100;
            this.f359403b = null;
        }
    }

    public b() {
    }

    public String toString() {
        if ((this instanceof C4423b) == false) goto L6;
        return "Success[" + this + ']';
    L6:
        if ((this instanceof a) == false) goto L10;
        return "Error[" + this + ']';
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
