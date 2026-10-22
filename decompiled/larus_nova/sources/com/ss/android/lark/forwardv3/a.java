package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.a$a, reason: collision with other inner class name */
    public static final class C5022a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f425120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f425121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IExternalForwardExecutor.ExternalForwardFailureReason f425122c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5022a) == true) goto L8;
            return false;
        L8:
            C5022a r101 = (C5022a) r100;
            if (Intrinsics.areEqual(this.f425120a, r101.f425120a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f425121b, r101.f425121b) == true) goto L15;
            return false;
        L15:
            if (this.f425122c == r101.f425122c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f425120a.hashCode() * 31;
            Throwable r101 = this.f425121b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f425122c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(rawErrorMsg=" + this.f425120a + ", throwable=" + this.f425121b + ", reason=" + this.f425122c + ')';
        }

        public C5022a(String r100, Throwable r101, int r102) {
            IExternalForwardExecutor.ExternalForwardFailureReason r103 = null;
            if ((r102 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r103 = IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN;
        L8:
            Intrinsics.checkNotNullParameter(r100, "rawErrorMsg");
            Intrinsics.checkNotNullParameter(r103, "reason");
            this.f425120a = r100;
            this.f425121b = r101;
            this.f425122c = r103;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, ForwardTargetBaseInfoNew> f425123a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f425123a, ((b) r100).f425123a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f425123a.hashCode();
        }

        public final String toString() {
            return "Success(result=" + this.f425123a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<String, ? extends ForwardTargetBaseInfoNew> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f425123a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f425124a = null;

        static {
            f425124a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
