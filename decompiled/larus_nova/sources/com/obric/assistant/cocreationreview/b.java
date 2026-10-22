package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class b {

    public static final class a extends b {
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
            return "Editable(meta=null)";
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.b$b, reason: collision with other inner class name */
    public static final class C4599b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4599b f387192a = null;

        static {
            f387192a = new C4599b();
        }

        public C4599b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f387193a = null;

        static {
            f387193a = new c();
        }

        public c() {
        }
    }

    public b() {
    }
}
