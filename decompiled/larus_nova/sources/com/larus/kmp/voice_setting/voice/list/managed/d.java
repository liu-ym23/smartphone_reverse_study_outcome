package com.larus.kmp.voice_setting.voice.list.managed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface d {

    public static final class a implements d {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "CreateEntry(state=null)";
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.kmp.voice_setting.voice.list.row.t f353474a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f353474a, ((b) r100).f353474a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353474a.hashCode();
        }

        public final String toString() {
            return "Normal(state=" + this.f353474a + ')';
        }

        public b(com.larus.kmp.voice_setting.voice.list.row.t r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f353474a = r100;
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.kmp.voice_setting.voice.list.row.u f353475a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f353475a, ((c) r100).f353475a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353475a.hashCode();
        }

        public final String toString() {
            return "Public(state=" + this.f353475a + ')';
        }

        public c(com.larus.kmp.voice_setting.voice.list.row.u r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f353475a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.list.managed.d$d, reason: collision with other inner class name */
    public static final class C4390d implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4390d f353476a = null;

        static {
            f353476a = new C4390d();
        }

        public C4390d() {
        }
    }
}
