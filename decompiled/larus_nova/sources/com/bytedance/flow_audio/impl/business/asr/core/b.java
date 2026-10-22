package com.bytedance.flow_audio.impl.business.asr.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.flow_audio.impl.business.asr.core.d f243879a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243879a, ((a) r100).f243879a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243879a.hashCode();
        }

        public final String toString() {
            return "DispatchEvent(event=" + this.f243879a + ')';
        }

        public a(com.bytedance.flow_audio.impl.business.asr.core.d r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243879a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.flow_audio.impl.business.asr.core.b$b, reason: collision with other inner class name */
    public static final class C3491b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243880a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3491b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243880a, ((C3491b) r100).f243880a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243880a.hashCode();
        }

        public final String toString() {
            return "Failure(error=" + this.f243880a + ')';
        }

        public C3491b(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243880a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f243881a = null;

        static {
            f243881a = new c();
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
            return 1695080043;
        }

        public final String toString() {
            return "StopProcessing";
        }

        public c() {
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f243882a = null;

        static {
            f243882a = new d();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            d r101 = (d) r100;
            return true;
        }

        public final int hashCode() {
            return 506018573;
        }

        public final String toString() {
            return "Success";
        }

        public d() {
        }
    }

    public b() {
    }
}
