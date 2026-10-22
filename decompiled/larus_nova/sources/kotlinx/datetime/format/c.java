package kotlinx.datetime.format;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public interface c extends w.a {

    public static final class a {
        public static void a(c r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.u(new kotlinx.datetime.internal.format.e(new y(r101)));
        }

        public static void b(c r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.u(new kotlinx.datetime.internal.format.e(new a1(r101)));
        }

        public static void c(c r100, Padding r101) {
            Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
            r100.u(new kotlinx.datetime.internal.format.e(new z1(r101)));
        }
    }

    void u(kotlinx.datetime.internal.format.n<? super e> r100);
}
