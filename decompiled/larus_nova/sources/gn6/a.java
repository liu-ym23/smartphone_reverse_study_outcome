package gn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends hn6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends hn6.d> f481810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends hn6.e> f481811b;

    public a() {
        this.f481810a = CollectionsKt.listOf(new hn6.d[]{new b(), new c()});
        this.f481811b = CollectionsKt.listOf(new hn6.e[]{new e(), new d()});
    }

    @Override // hn6.a
    public final CheckType b() {
        return CheckType.COVER;
    }

    @Override // hn6.a
    public final List<hn6.d> c() {
        return this.f481810a;
    }

    @Override // hn6.a
    public final List<hn6.e> d() {
        return this.f481811b;
    }
}
