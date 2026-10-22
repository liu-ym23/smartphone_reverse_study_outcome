package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface a0 {

    public static final class a implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NexPulseResponseData f369957a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f369957a, ((a) r100).f369957a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f369957a.hashCode();
        }

        public final String toString() {
            return "CacheOnly(response=" + this.f369957a + ')';
        }

        public a(NexPulseResponseData r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f369957a = r100;
        }
    }

    public static final class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NexPulseResponseData f369958a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f369958a, ((b) r100).f369958a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f369958a.hashCode();
        }

        public final String toString() {
            return "CacheThenNetwork(response=" + this.f369958a + ')';
        }

        public b(NexPulseResponseData r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f369958a = r100;
        }
    }

    public static final class c implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f369959a = null;

        static {
            f369959a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return 1913856615;
        }

        public final String toString() {
            return "NetworkOnly";
        }
    }

    public static final class d implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f369960a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f369960a, ((d) r100).f369960a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f369960a.hashCode();
        }

        public final String toString() {
            return "Suppress(reason=" + this.f369960a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f369960a = r100;
        }
    }
}
