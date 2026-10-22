package com.bytedance.rts.foundation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static final a a = null;

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
        a = new a();
    }
}
