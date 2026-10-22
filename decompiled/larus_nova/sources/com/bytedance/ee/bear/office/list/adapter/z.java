package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class z {

    public static final class a extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OfficeLongPressDisabledDispatchReason f235881b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f235880a, r101.f235880a) == true) goto L12;
            return false;
        L12:
            if (this.f235881b == r101.f235881b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f235880a.hashCode() * 31;
            OfficeLongPressDisabledDispatchReason r101 = this.f235881b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Disabled(tips=" + this.f235880a + ", dispatchReason=" + this.f235881b + ')';
        }

        public a(String r100, OfficeLongPressDisabledDispatchReason r101) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f235880a = r100;
            this.f235881b = r101;
        }
    }

    public static final class b extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f235882a = null;

        static {
            f235882a = new b();
        }

        public b() {
        }
    }

    public static final class c extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235883a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235883a, ((c) r100).f235883a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235883a.hashCode();
        }

        public final String toString() {
            return "Loading(tips=" + this.f235883a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f235883a = r100;
        }
    }

    public static final class d extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f235884a = null;

        static {
            f235884a = new d();
        }

        public d() {
        }
    }

    public z() {
    }
}
