package hb1;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.soloktv.permission.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;
import nz.t;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements i<rh0.a>, k<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k<rh0.a> f484478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<rh0.a> f484479b;

    public final void d() {
        com.bytedance.android.scope.m r100 = com.bytedance.android.scope.m.f163449e;
        f00.a.C5839a r101 = f00.a.f474945b;
        t r102 = (t) r100.d(r101, t.class);
        if (r102 != null) goto L5;
    L9:
        ((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).init();
    L10:
        k<rh0.a> r103 = this.f484478a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L13:
        r103.c();
        return;
    L5:
        if (r102.isOpen() != true) goto L9;
        t r104 = (t) r100.d(r101, t.class);
        if (r104 == null) goto L10;
        r104.init();
        goto L10
    }

    @Override // hb1.k
    public final /* bridge */ /* synthetic */ void c() {
        d();
    }

    public l(i<rh0.a> r100) {
        this.f484479b = r100;
    }

    @Override // hb1.i
    public final void a(k<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f484478a = r100;
        i<rh0.a> r101 = this.f484479b;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        d();
    }

    @Override // hb1.k
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        k<rh0.a> r101 = this.f484478a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }
}
