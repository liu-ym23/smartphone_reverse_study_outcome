package com.larus.im.internal.network;

import com.larus.im.callback.IIMError;
import com.larus.im.callback.IMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class e<T> {

    public static final class a<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349175b;

        public a() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f349174a, r101.f349174a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349175b, r101.f349175b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349174a.hashCode() * 31) + this.f349175b.hashCode();
        }

        public final String toString() {
            return "Cancel(error=" + this.f349174a + ", logId=" + this.f349175b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349174a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349175b;
        }

        public a(IIMError r100, String r110, int r111) {
            if ((r111 & 1) == 0) goto L6;
            r100 = new IMError(0, "Cancel", null, null, 12, null);
        L6:
            if ((r111 & 2) == 0) goto L8;
            r110 = "";
        L8:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r110, "logId");
            this.f349174a = r100;
            this.f349175b = r110;
        }
    }

    public static final class b<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349177b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f349176a, r101.f349176a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349177b, r101.f349177b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349176a.hashCode() * 31) + this.f349177b.hashCode();
        }

        public final String toString() {
            return "HttpError(error=" + this.f349176a + ", logId=" + this.f349177b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349176a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349177b;
        }

        public /* synthetic */ b(IIMError r100) {
            this(r100, "");
        }

        public b(IIMError r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r101, "logId");
            this.f349176a = r100;
            this.f349177b = r101;
        }
    }

    public static final class c<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349179b;

        public c() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f349178a, r101.f349178a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349179b, r101.f349179b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349178a.hashCode() * 31) + this.f349179b.hashCode();
        }

        public final String toString() {
            return "Interrupt(error=" + this.f349178a + ", logId=" + this.f349179b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349178a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349179b;
        }

        public c(IIMError r100, String r110, int r111) {
            if ((r111 & 1) == 0) goto L6;
            r100 = new IMError(0, "Interrupt", null, null, 12, null);
        L6:
            if ((r111 & 2) == 0) goto L8;
            r110 = "";
        L8:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r110, "logId");
            this.f349178a = r100;
            this.f349179b = r110;
        }
    }

    public static final class d<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f349181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f349182c;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f349180a, r101.f349180a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349181b, r101.f349181b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349182c, r101.f349182c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f349180a.hashCode() * 31;
            T r101 = this.f349181b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f349182c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ServerError(error=" + this.f349180a + ", body=" + this.f349181b + ", logId=" + this.f349182c + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349180a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349182c;
        }

        public d(IIMError r100, Object r101, int r102) {
            String r103 = null;
            if ((r102 & 2) == 0) goto L6;
            r101 = (T) null;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r103 = "";
        L8:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r103, "logId");
            this.f349180a = r100;
            this.f349181b = (T) r101;
            this.f349182c = r103;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.network.e$e, reason: collision with other inner class name */
    public static final class C4366e<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349184b;

        public C4366e() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4366e) == true) goto L8;
            return false;
        L8:
            C4366e r101 = (C4366e) r100;
            if (Intrinsics.areEqual(this.f349183a, r101.f349183a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349184b, r101.f349184b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349183a.hashCode() * 31) + this.f349184b.hashCode();
        }

        public final String toString() {
            return "StreamDone(error=" + this.f349183a + ", logId=" + this.f349184b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349183a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349184b;
        }

        public C4366e(IIMError r100, String r110, int r111) {
            if ((r111 & 1) == 0) goto L6;
            r100 = new IMError(0, "StreamDone", null, null, 12, null);
        L6:
            if ((r111 & 2) == 0) goto L8;
            r110 = "";
        L8:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r110, "logId");
            this.f349183a = r100;
            this.f349184b = r110;
        }
    }

    public static final class f<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f349185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IIMError f349186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f349187c;

        public f() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f349185a, r101.f349185a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349186b, r101.f349186b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349187c, r101.f349187c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f349185a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((r101 * 31) + this.f349186b.hashCode()) * 31) + this.f349187c.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(body=" + this.f349185a + ", error=" + this.f349186b + ", logId=" + this.f349187c + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349186b;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349187c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Object r100, IIMError r110, int r111) {
            if ((r111 & 2) == 0) goto L6;
            r110 = new IMError(0, "OK", null, null, 12, null);
        L6:
            if ((r111 & 4) == 0) goto L8;
            String r112 = "";
        L9:
            Intrinsics.checkNotNullParameter(r110, "error");
            Intrinsics.checkNotNullParameter(r112, "logId");
            this.f349185a = r100;
            this.f349186b = r110;
            this.f349187c = r112;
            return;
        L8:
            r112 = null;
            goto L9
        }
    }

    public static final class g<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349189b;

        public g() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f349188a, r101.f349188a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349189b, r101.f349189b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349188a.hashCode() * 31) + this.f349189b.hashCode();
        }

        public final String toString() {
            return "TimeoutError(error=" + this.f349188a + ", logId=" + this.f349189b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349188a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349189b;
        }

        public /* synthetic */ g(IMError r100, int r110) {
            if ((r110 & 1) == 0) goto L6;
            r100 = new IMError(-1, "Timeout", null, null, 12, null);
        L6:
            if ((r110 & 2) == 0) goto L8;
            String r111 = "";
        L9:
            this(r100, r111);
            return;
        L8:
            r111 = null;
            goto L9
        }

        public g(IIMError r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r101, "logId");
            this.f349188a = r100;
            this.f349189b = r101;
        }
    }

    public static final class h<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IIMError f349190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349191b;

        public h() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f349190a, r101.f349190a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349191b, r101.f349191b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f349190a.hashCode() * 31) + this.f349191b.hashCode();
        }

        public final String toString() {
            return "Unsupported(error=" + this.f349190a + ", logId=" + this.f349191b + ')';
        }

        @Override // com.larus.im.internal.network.e
        public final IIMError a() {
            return this.f349190a;
        }

        @Override // com.larus.im.internal.network.e
        public final String b() {
            return this.f349191b;
        }

        public h(IIMError r100, int r110) {
            if ((r110 & 1) == 0) goto L6;
            r100 = new IMError(0, "Unsupported", null, null, 12, null);
        L6:
            if ((r110 & 2) == 0) goto L8;
            String r111 = "";
        L9:
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r111, "logId");
            this.f349190a = r100;
            this.f349191b = r111;
            return;
        L8:
            r111 = null;
            goto L9
        }
    }

    public e() {
    }

    public abstract IIMError a();

    public abstract String b();
}
