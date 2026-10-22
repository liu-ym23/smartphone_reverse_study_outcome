package com.larus.kmp.voice_setting.voice.mix;

/* JADX INFO: loaded from: classes30.dex */
public interface v {

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f353933a = null;

        static {
            f353933a = new a();
        }

        public a() {
        }
    }

    public static final class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f353934a = null;

        static {
            f353934a = new b();
        }

        public b() {
        }
    }

    public static final class c implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f353935a = null;

        static {
            f353935a = new c();
        }

        public c() {
        }
    }

    public static final class d implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f353936a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f353936a == ((d) r100).f353936a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f353936a;
        }

        public final String toString() {
            return "ProgressChanged(value=" + this.f353936a + ')';
        }

        public d(int r100) {
            this.f353936a = r100;
        }
    }

    public static final class e implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f353937a = null;

        static {
            f353937a = new e();
        }

        public e() {
        }
    }

    public static final class f implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f353938a = null;

        static {
            f353938a = new f();
        }

        public f() {
        }
    }
}
