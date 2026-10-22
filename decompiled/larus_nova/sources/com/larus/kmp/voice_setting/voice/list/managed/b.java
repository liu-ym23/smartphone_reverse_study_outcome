package com.larus.kmp.voice_setting.voice.list.managed;

import com.larus.kmp.voice_setting.voice.screen.single.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f353461a = null;

        static {
            f353461a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.list.managed.b$b, reason: collision with other inner class name */
    public static final class C4389b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4389b f353462a = null;

        static {
            f353462a = new C4389b();
        }

        public C4389b() {
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f353463a = null;

        static {
            f353463a = new c();
        }

        public c() {
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0 f353464a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f353464a, ((d) r100).f353464a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            t0 r100 = this.f353464a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "More(anchorBounds=" + this.f353464a + ')';
        }

        public d(t0 r100) {
            this.f353464a = r100;
        }
    }
}
