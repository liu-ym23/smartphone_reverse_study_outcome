package f3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f475304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f475305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f475306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f475307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends BaseModel>, e> f475308e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f475304a, r101.f475304a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475305b, r101.f475305b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475306c, r101.f475306c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f475307d, r101.f475307d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f475308e, r101.f475308e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f475304a.hashCode() * 31) + this.f475305b.hashCode()) * 31) + this.f475306c.hashCode()) * 31) + this.f475307d.hashCode()) * 31) + this.f475308e.hashCode();
    }

    public final String toString() {
        return "AnnotationData(paramClass=" + this.f475304a + ", resultClass=" + this.f475305b + ", paramModel=" + this.f475306c + ", resultModel=" + this.f475307d + ", models=" + this.f475308e + ')';
    }

    public d(Class<?> r100, Class<?> r101, e r102, e r103, Map<Class<? extends BaseModel>, e> r104) {
        Intrinsics.checkNotNullParameter(r100, "paramClass");
        Intrinsics.checkNotNullParameter(r101, "resultClass");
        Intrinsics.checkNotNullParameter(r102, "paramModel");
        Intrinsics.checkNotNullParameter(r103, "resultModel");
        Intrinsics.checkNotNullParameter(r104, "models");
        this.f475304a = r100;
        this.f475305b = r101;
        this.f475306c = r102;
        this.f475307d = r103;
        this.f475308e = r104;
    }
}
