package te7;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
public final class j extends se7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f545619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f545620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f545621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f545622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f545623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f545624f;

    public final Integer a() {
        return Integer.valueOf(this.f545624f.element);
    }

    public final String b() {
        return this.f545622d.element;
    }

    public final Throwable c() {
        return this.f545623e.element;
    }

    public final Integer d() {
        return Integer.valueOf(this.f545620b.element);
    }

    public final String e() {
        return this.f545621c.element;
    }

    public j(LinkedHashMap<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<String> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105) {
        this.f545619a = r100;
        this.f545620b = r101;
        this.f545621c = r102;
        this.f545622d = r103;
        this.f545623e = r104;
        this.f545624f = r105;
    }
}
