package kotlinx.datetime.format;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public interface d extends w.d {

    public static final class a {
        public static void d(d r100) {
            r100.b(new kotlinx.datetime.internal.format.e(new a0(0)));
        }

        public static void a(d r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.b(new kotlinx.datetime.internal.format.e(new b0(r101)));
        }

        public static void b(d r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.b(new kotlinx.datetime.internal.format.e(new z0(r101)));
        }

        public static void c(d r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.b(new kotlinx.datetime.internal.format.e(new c1(r101)));
        }
    }

    void b(kotlinx.datetime.internal.format.n<? super d1> r100);
}
