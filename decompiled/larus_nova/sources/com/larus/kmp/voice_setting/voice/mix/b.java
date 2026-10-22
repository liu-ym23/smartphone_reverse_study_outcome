package com.larus.kmp.voice_setting.voice.mix;

/* JADX INFO: loaded from: classes30.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f353762a = null;

        static {
            f353762a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.mix.b$b, reason: collision with other inner class name */
    public static final class C4391b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4391b f353763a = null;

        static {
            f353763a = new C4391b();
        }

        public C4391b() {
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f353764a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f353764a == ((c) r100).f353764a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353764a;
        }

        public final String toString() {
            return "PitchProgressChanged(progress=" + this.f353764a + ')';
        }

        public c(int r100) {
            this.f353764a = r100;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f353765a = null;

        static {
            f353765a = new d();
        }

        public d() {
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f353766a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f353766a == ((e) r100).f353766a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353766a;
        }

        public final String toString() {
            return "RateProgressChanged(progress=" + this.f353766a + ')';
        }

        public e(int r100) {
            this.f353766a = r100;
        }
    }
}
