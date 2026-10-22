package e18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface a<T> {

    /* JADX INFO: renamed from: e18.a$a, reason: collision with other inner class name */
    public static final class C5729a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> int a(a<T> r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "any");
            if (r101 != 0) goto L7;
            return 0;
        L7:
            return r100.indexOf(r101);
        }
    }

    int a(Object r100);

    T getItem(int r100);

    int getItemsCount();

    int indexOf(T r100);
}
