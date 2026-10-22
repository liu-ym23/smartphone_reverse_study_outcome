package jc4;

import com.bytedance.ee.space.sync.PushAction$ESubType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class q extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498132o;

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
    }

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "";
    }

    @Override // jc4.a
    public int getType() {
        return 17;
    }

    @Override // jc4.a
    public final String g() {
        return this.f498132o;
    }

    public q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "decision");
        Intrinsics.checkNotNullParameter(r101, PushAction$ESubType.KEY_NAME);
        this.f498131n = r100;
        this.f498132o = r101;
    }
}
