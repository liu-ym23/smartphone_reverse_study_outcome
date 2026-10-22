package ki4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class k0 {

    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f503633a;

        public a() {
            Intrinsics.checkNotNullParameter("date_modified", "column");
            this.f503633a = "date_modified";
        }

        public final String toString() {
            return this.f503633a + " DESC";
        }
    }

    public k0() {
    }
}
