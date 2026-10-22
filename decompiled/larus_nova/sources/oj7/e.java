package oj7;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.atomic.AtomicInteger;
import v26.l;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements x16.b {
    public e() {
    }

    @Override // x16.b
    public final void b(d1 r100, l r101, Throwable r102) {
    }

    @Override // x16.b
    public final void c(d1 r100, l r101) {
    }

    @Override // x16.b
    public final Uri a(String r100, l r101) {
        return UriProtector.parse(r100);
    }

    @Override // x16.b
    public final void d(d1 r100, l r101) {
        AtomicInteger r102 = d.f523587a;
        d.a(r100.f247858a.toString());
    }
}
