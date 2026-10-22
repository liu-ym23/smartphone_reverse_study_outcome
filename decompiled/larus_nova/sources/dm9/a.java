package dm9;

import com.larus.network.bean.BizResponse;
import com.larus.network.http.ApiRespInterceptedException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: dm9.a$a, reason: collision with other inner class name */
    public static final class C5690a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f469228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f469229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f469230c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5690a) == true) goto L8;
            return false;
        L8:
            C5690a r101 = (C5690a) r100;
            if (this.f469228a == r101.f469228a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f469229b, r101.f469229b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f469230c, r101.f469230c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f469228a * 31) + this.f469229b.hashCode()) * 31;
            Throwable r101 = this.f469230c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // dm9.a
        public final String toString() {
            return "Error(code=" + this.f469228a + ", msg=" + this.f469229b + ", throwable=" + this.f469230c + ')';
        }

        public final int a() {
            return this.f469228a;
        }

        public C5690a(int r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f469228a = r100;
            this.f469229b = r101;
            this.f469230c = r102;
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BizResponse<T> f469231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f469232b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f469231a, r101.f469231a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f469232b, r101.f469232b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f469231a.hashCode() * 31;
            Throwable r101 = this.f469232b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // dm9.a
        public final String toString() {
            return "Success(bizResp=" + this.f469231a + ", throwable=" + this.f469232b + ')';
        }

        public final BizResponse<T> a() {
            return this.f469231a;
        }

        public b(BizResponse r100, ApiRespInterceptedException r101) {
            Intrinsics.checkNotNullParameter(r100, "bizResp");
            this.f469231a = r100;
            this.f469232b = r101;
        }
    }

    public a() {
    }

    public String toString() {
        if ((this instanceof b) == false) goto L6;
        return "Success[" + this + ']';
    L6:
        if ((this instanceof C5690a) == false) goto L10;
        return "Error[" + this + ']';
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
