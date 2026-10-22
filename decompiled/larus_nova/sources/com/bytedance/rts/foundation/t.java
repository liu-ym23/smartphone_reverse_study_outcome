package com.bytedance.rts.foundation;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f267593a = null;

    public static final class a extends ThreadLocal<n> {
        @Override // java.lang.ThreadLocal
        public final n initialValue() {
            return new n();
        }

        public a() {
        }
    }

    public static final class b {
    }

    static {
        f267593a = new a();
    }
}
