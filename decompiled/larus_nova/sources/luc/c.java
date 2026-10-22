package luc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f510844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<?> f510845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510846c;

    @Override // luc.f
    public final boolean a() {
        return this.f510844a.a();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final String b(int r100) {
        return this.f510844a.b(r100);
    }

    @Override // luc.f
    public final int d() {
        return this.f510844a.d();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final List<Annotation> e(int r100) {
        return this.f510844a.e(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f510844a.g(r100);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return this.f510844a.getAnnotations();
    }

    @Override // luc.f
    public final o getKind() {
        return this.f510844a.getKind();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final f h(int r100) {
        return this.f510844a.h(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final boolean i(int r100) {
        return this.f510844a.i(r100);
    }

    @Override // luc.f
    public final boolean isInline() {
        return this.f510844a.isInline();
    }

    public final int hashCode() {
        return (this.f510845b.hashCode() * 31) + this.f510846c.hashCode();
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f510845b + ", original: " + this.f510844a + ')';
    }

    @Override // luc.f
    public final String f() {
        return this.f510846c;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L5;
        c r101 = (c) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f510844a, r101.f510844a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r101.f510845b, this.f510845b) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public c(i r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "kClass");
        this.f510844a = r100;
        this.f510845b = r101;
        this.f510846c = r100.f510860a + Typography.less + r101.getSimpleName() + Typography.greater;
    }
}
