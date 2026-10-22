package nf5;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.bean.c;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f518952a;

    public b() {
        Map<String, Boolean> r100 = a.f518950a;
        this.f518952a = a.f518950a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final Map<String, Boolean> h() {
        return this.f518952a;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean d(TranslateConfig r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean a(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.h(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean e(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.g(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean f(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.f(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean b(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.b(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean c(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.d(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.bean.c
    public final boolean g(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return a.e(r100, r101, r102, r103);
    }
}
