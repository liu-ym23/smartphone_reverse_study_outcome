package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f330382a = null;

        static {
            f330382a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 1763533770;
        }

        public final String toString() {
            return "Failure";
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MembershipQuotaSummaryDto f330383a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f330383a, ((b) r100).f330383a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330383a.hashCode();
        }

        public final String toString() {
            return "Success(summary=" + this.f330383a + ')';
        }

        public b(MembershipQuotaSummaryDto r100) {
            Intrinsics.checkNotNullParameter(r100, "summary");
            this.f330383a = r100;
        }
    }
}
