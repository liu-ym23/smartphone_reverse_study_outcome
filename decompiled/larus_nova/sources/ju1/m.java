package ju1;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500411b;

    @Override // ju1.h
    public final String d() {
        return "SimpleStrategy";
    }

    @Override // ju1.h
    public final boolean f() {
        return true;
    }

    @Override // ju1.h
    public final Object a() {
        return Integer.valueOf(this.f500411b);
    }

    @Override // ju1.h
    public final List<String> c() {
        return CollectionsKt.emptyList();
    }

    @Override // ju1.h
    public final List<String> e() {
        return CollectionsKt.emptyList();
    }

    @Override // ju1.h
    public final String b() {
        return this.f500410a;
    }

    public m(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f500410a = r100;
        this.f500411b = r101;
    }
}
