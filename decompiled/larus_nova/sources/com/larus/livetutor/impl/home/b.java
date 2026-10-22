package com.larus.livetutor.impl.home;

import com.larus.livetutor.api.idl.FixedQuery;
import com.larus.livetutor.api.idl.FlashCardEntrance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlashCardEntrance f356117a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356117a, ((a) r100).f356117a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356117a.hashCode();
        }

        public final String toString() {
            return "BannerItem(banner=" + this.f356117a + ')';
        }

        public a(FlashCardEntrance r100) {
            Intrinsics.checkNotNullParameter(r100, "banner");
            this.f356117a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.home.b$b, reason: collision with other inner class name */
    public static final class C4410b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FixedQuery f356118a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4410b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f356118a, ((C4410b) r100).f356118a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f356118a.hashCode();
        }

        public final String toString() {
            return "QueryItem(query=" + this.f356118a + ')';
        }

        public C4410b(FixedQuery r100) {
            Intrinsics.checkNotNullParameter(r100, "query");
            this.f356118a = r100;
        }
    }

    public b() {
    }
}
