package com.larus.extension.summary_card.impl.component;

/* JADX INFO: loaded from: classes26.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f343015a = null;

        static {
            f343015a = new a();
        }

        public a() {
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f343016a = null;

        static {
            f343016a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f343017a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f343017a == ((c) r100).f343017a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f343017a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "EXPANDING(isRealMessage=" + this.f343017a + ')';
        }

        public c(boolean r100) {
            this.f343017a = r100;
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f343018a = null;

        static {
            f343018a = new d();
        }

        public d() {
        }
    }

    public f() {
    }
}
