package com.larus.kmp.voice_setting.voice.screen.single;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface b0 {

    public static final class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.kmp.voice_setting.voice.list.row.t f354873a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f354873a, ((a) r100).f354873a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f354873a.hashCode();
        }

        public final String toString() {
            return "Normal(state=" + this.f354873a + ')';
        }

        public a(com.larus.kmp.voice_setting.voice.list.row.t r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f354873a = r100;
        }
    }

    public static final class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.kmp.voice_setting.voice.list.row.u f354874a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f354874a, ((b) r100).f354874a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f354874a.hashCode();
        }

        public final String toString() {
            return "Public(state=" + this.f354874a + ')';
        }

        public b(com.larus.kmp.voice_setting.voice.list.row.u r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f354874a = r100;
        }
    }
}
