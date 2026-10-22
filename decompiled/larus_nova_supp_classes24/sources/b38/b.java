package b38;

import com.larksuite.rucket.core.RucketImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b {
    public static final a a = null;

    public static final class a implements b {
        public static final /* synthetic */ a c = null;
        public final /* synthetic */ RucketImpl b;

        static {
            c = new a();
        }

        @Override // b38.b
        public final <T> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            return (T) this.b.create(r2);
        }

        public a() {
            this.b = new RucketImpl();
        }
    }

    static {
        a = a.c;
    }

    <T> T create(Class<T> r1);
}
