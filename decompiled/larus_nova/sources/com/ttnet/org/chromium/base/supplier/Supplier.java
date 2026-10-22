package com.ttnet.org.chromium.base.supplier;

/* JADX INFO: loaded from: classes41.dex */
public interface Supplier<T> {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.Supplier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static boolean $default$hasValue(Supplier r100) {
            Object r101 = r100.get();
            if (AnonymousClass1.$assertionsDisabled == false) goto L5;
        L9:
            if (r101 == null) goto L11;
            return true;
        L11:
            return false;
        L5:
            if (r101 == r100.get()) goto L9;
            throw new AssertionError("Value provided by #get() must not change.");
        }
    }

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.Supplier$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
        }
    }

    T get();

    boolean hasValue();
}
