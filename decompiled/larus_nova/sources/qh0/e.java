package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements c, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OperateType f532887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f532888b;

    @Override // qh0.b
    public final int getLinkType() {
        return this.f532888b;
    }

    @Override // qh0.b
    public final OperateType getOperateType() {
        return this.f532887a;
    }

    @Override // qh0.c
    public final a<rh0.a> a(a<rh0.a> r100) {
        return new com.bytedance.android.live.liveinteract.plantform.permission.checker.p(this);
    }

    public e(OperateType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "operateType");
        this.f532887a = r100;
        this.f532888b = r101;
    }
}
