package t6b;

import com.ss.android.lark.biz.im.extension.PageType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f544797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<yya.l> f544798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f544799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f544800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public yya.f f544801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PageType f544802l;

    @Override // t6b.g
    public final List<yya.l> c() {
        return this.f544798h;
    }

    @Override // t6b.g
    public final yya.f d() {
        return this.f544801k;
    }

    @Override // t6b.g
    public final List<Integer> e() {
        return this.f544799i;
    }

    @Override // t6b.g
    public final PageType f() {
        return this.f544802l;
    }

    @Override // t6b.g
    public final boolean g() {
        return this.f544797g;
    }

    @Override // t6b.g
    public final boolean h() {
        return this.f544800j;
    }

    public h(g r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(null, false, null, 63);
        this.f544797g = r100.g();
        this.f544798h = CollectionsKt.toMutableList(r100.c());
        this.f544799i = CollectionsKt.toMutableList(r100.e());
        this.f544800j = r100.h();
        this.f544801k = r100.d();
        this.f544802l = r100.f();
    }
}
