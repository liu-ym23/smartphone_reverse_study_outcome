package com.bytedance.locallife.groupon.basic.utils;

import com.bytedance.locallife.model.response.BaseResponse;
import com.bytedance.retrofit2.client.Header;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class e<R> {

    public static final class a {
    }

    public static final class b<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Exception f258792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Header> f258793b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f258792a, ((b) r100).f258792a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f258792a.hashCode();
        }

        @Override // com.bytedance.locallife.groupon.basic.utils.e
        public final String toString() {
            return "Error(exception=" + this.f258792a + ')';
        }

        public b(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            this.f258792a = r100;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f258794a = null;

        static {
            f258794a = new c();
        }

        public c() {
        }
    }

    public static final class d<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f258795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Header> f258796b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f258795a, ((d) r100).f258795a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f258795a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        @Override // com.bytedance.locallife.groupon.basic.utils.e
        public final String toString() {
            return "Success(data=" + this.f258795a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(BaseResponse r100) {
            this.f258795a = r100;
        }
    }

    static {
    }

    public e() {
    }

    public String toString() {
        if ((this instanceof d) == false) goto L6;
        return "Success[data=" + ((d) this).f258795a + ']';
    L6:
        if ((this instanceof b) == false) goto L9;
        return "Error[exception=" + ((b) this).f258792a + ']';
    L9:
        if (Intrinsics.areEqual(this, c.f258794a) == false) goto L13;
        return "Loading";
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
