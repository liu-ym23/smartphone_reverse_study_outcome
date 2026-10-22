package ve5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c {

    public static final class a extends c {
        public static final a a = null;

        static {
            a = new a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return -164958669;
        }

        public final String toString() {
            return "Ignore";
        }

        public a() {
        }
    }

    public static final class b extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Navigate(url=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
            this.a = r2;
        }
    }

    public c() {
    }
}
