package to;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f546890a = 0;

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f546891b;

        public final String toString() {
            return "DirectDescriptor(uniqueId='" + this.f546891b + "')";
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            this.f546891b = r100;
        }
    }

    public static final class b {
        public static e a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uniqueIdDescription");
            if (StringsKt.contains$default(r100, ".", false, 2, null) == false) goto L7;
            return new c(StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null));
        L7:
            return new a(r100);
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f546892b;

        public final String toString() {
            return "PathDirectDescriptor(uniqueIdChain=" + CollectionsKt.joinToString$default(this.f546892b, ".", null, null, 0, null, null, 62, null) + ')';
        }

        public c(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "uniqueIdChain");
            this.f546892b = r100;
        }
    }

    static {
    }

    public e() {
    }
}
