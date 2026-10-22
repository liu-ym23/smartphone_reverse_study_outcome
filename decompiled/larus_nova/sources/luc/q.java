package luc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
public final class q implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f510881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510882b;

    @Override // luc.f
    public final boolean a() {
        return this.f510881a.a();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final String b(int r100) {
        return this.f510881a.b(r100);
    }

    @Override // luc.f
    public final int d() {
        return this.f510881a.d();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final List<Annotation> e(int r100) {
        return this.f510881a.e(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f510881a.g(r100);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return this.f510881a.getAnnotations();
    }

    @Override // luc.f
    public final o getKind() {
        return this.f510881a.getKind();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final f h(int r100) {
        return this.f510881a.h(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final boolean i(int r100) {
        return this.f510881a.i(r100);
    }

    @Override // luc.f
    public final boolean isInline() {
        return this.f510881a.isInline();
    }

    @Override // luc.f
    public final String f() {
        return this.f510882b;
    }

    public q(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "original");
        this.f510881a = r101;
        this.f510882b = r100;
    }
}
