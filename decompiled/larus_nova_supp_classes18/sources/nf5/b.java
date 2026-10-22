package nf5;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.bean.c;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements c {
    public final Map<String, Boolean> a;

    public b() {
        Map<String, Boolean> r0 = a.a;
        this.a = a.a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final Map<String, Boolean> h() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean d(TranslateConfig r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.a(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean a(TranslateConfig r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.h(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean e(TranslateConfig r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.g(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean f(TranslateConfig r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.f(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean b(TranslateConfig r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.b(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean c(TranslateConfig r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.d(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean g(TranslateConfig r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return a.e(r2, r3, r4, r5);
    }
}
