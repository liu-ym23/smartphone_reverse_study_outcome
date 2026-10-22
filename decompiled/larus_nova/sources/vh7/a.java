package vh7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554979a = 0;

    /* JADX INFO: renamed from: vh7.a$a, reason: collision with other inner class name */
    public interface InterfaceC8006a<T> {
        String getName();
    }

    public static final class b<T> implements InterfaceC8006a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f554980a;

        @Override // vh7.a.InterfaceC8006a
        public final String getName() {
            return this.f554980a;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f554980a = r100;
        }
    }

    static {
    }
}
