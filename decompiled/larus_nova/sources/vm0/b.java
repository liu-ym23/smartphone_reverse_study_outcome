package vm0;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f555733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f555734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Type f555735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f555736e;

    public final Type getType() {
        return this.f555735d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, Object r101, Object r102, Type r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f555732a = r100;
        this.f555733b = r101;
        this.f555734c = r102;
        this.f555735d = r103;
        this.f555736e = false;
    }
}
