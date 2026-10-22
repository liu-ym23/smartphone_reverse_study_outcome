package com.larus.avatar.impl.manager;

import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.avatar.impl.manager.a$a, reason: collision with other inner class name */
    public static final class C3979a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3979a f290795a = null;

        static {
            f290795a = new C3979a();
        }

        public C3979a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f290796a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f290796a == ((b) r100).f290796a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f290796a;
        }

        public final String toString() {
            return "OpenPhotoPicker(maxSelectCount=" + this.f290796a + ')';
        }

        public b(int r100) {
            this.f290796a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ey9.k> f290797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f290798b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f290797a, r101.f290797a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f290798b, r101.f290798b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            List<ey9.k> r100 = this.f290797a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f290798b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OpenUploadWithPreGen(preGenImages=" + this.f290797a + ", replicaCreateId=" + this.f290798b + ')';
        }

        public c(List<ey9.k> r100, String r101) {
            this.f290797a = r100;
            this.f290798b = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f290799a = null;

        static {
            f290799a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f290800a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f290800a, ((e) r100).f290800a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f290800a.hashCode();
        }

        public final String toString() {
            return "ShowDeleteConfirmDialog(digitalAvatarId=" + this.f290800a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "digitalAvatarId");
            this.f290800a = r100;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f290801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Triple<Integer, Integer, Integer> f290802b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f290801a, r101.f290801a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f290802b, r101.f290802b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f290801a.hashCode() * 31;
            Triple<Integer, Integer, Integer> r101 = this.f290802b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ShowQuotaRemindDeleteDialog(digitalAvatarId=" + this.f290801a + ", quotaInfo=" + this.f290802b + ')';
        }

        public f(String r100, Triple<Integer, Integer, Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "digitalAvatarId");
            this.f290801a = r100;
            this.f290802b = r101;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Triple<Integer, Integer, Integer> f290803a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f290803a, ((g) r100).f290803a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Triple<Integer, Integer, Integer> r100 = this.f290803a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ShowQuotaRemindReGenDialog(quotaInfo=" + this.f290803a + ')';
        }

        public g(Triple<Integer, Integer, Integer> r100) {
            this.f290803a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f290804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DigitalAvatarToastType f290805b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f290804a == r101.f290804a) goto L12;
            return false;
        L12:
            if (this.f290805b == r101.f290805b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f290804a * 31) + this.f290805b.hashCode();
        }

        public final String toString() {
            return "ShowToast(messageResId=" + this.f290804a + ", type=" + this.f290805b + ')';
        }

        public final DigitalAvatarToastType getType() {
            return this.f290805b;
        }

        public h(int r100, DigitalAvatarToastType r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f290804a = r100;
            this.f290805b = r101;
        }
    }

    public a() {
    }
}
