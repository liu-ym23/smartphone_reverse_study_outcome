package in6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckType;
import hn6.e;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends hn6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends e> f490609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f490610b;

    public a() {
        this.f490609a = CollectionsKt.listOf(new e[]{new b(), new d()});
        this.f490610b = CollectionsKt.listOf(new c());
    }

    @Override // hn6.a
    public final CheckType b() {
        return CheckType.VALID;
    }

    @Override // hn6.a
    public final List<hn6.d> c() {
        return this.f490610b;
    }

    @Override // hn6.a
    public final List<e> d() {
        return this.f490609a;
    }
}
