package u56;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class i extends t56.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f548866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f548867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f548868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f548869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f548870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f548871f;

    public final Integer a() {
        return Integer.valueOf(this.f548871f.element);
    }

    public final String b() {
        return this.f548869d.element;
    }

    public final Throwable c() {
        return this.f548870e.element;
    }

    public final Integer d() {
        return Integer.valueOf(this.f548867b.element);
    }

    public final String e() {
        return this.f548868c.element;
    }

    public i(LinkedHashMap<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<String> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105) {
        this.f548866a = r100;
        this.f548867b = r101;
        this.f548868c = r102;
        this.f548869d = r103;
        this.f548870e = r104;
        this.f548871f = r105;
    }
}
