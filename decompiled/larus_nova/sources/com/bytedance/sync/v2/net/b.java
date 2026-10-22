package com.bytedance.sync.v2.net;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.bytedance.sync.v2.protocal.Flag;
import hg7.g;
import hg7.i;
import hg7.l;
import yf7.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xf7.g f270447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f270448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f270449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f270450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f270451e;

    @Override // hg7.g
    public final boolean l() {
        return false;
    }

    @Override // hg7.g
    public final void F(ig7.a r110) {
        zf7.b.a("[SendMsg] send msg with https : " + jg7.d.M(r110.f489739a) + ", can fallback: " + r110.f489740b);
        if (r110.f489739a != null) goto L5;
        Uri.Builder r100 = null;
    L6:
        if (r100 != null) goto L9;
        zf7.b.b("[SendMsg] mismatch url with payload:" + jg7.d.M(r110.f489739a));
        return;
    L9:
        r100.appendQueryParameter("aid", this.f270447a.f563454a);
        int r101 = com.bytedance.sync.v2.utils.a.f270548a;
        int r102 = com.bytedance.sync.v2.utils.a.a(r110.f489739a).intValue();
        long r103 = System.currentTimeMillis();
        int r104 = cg7.b.c(this.f270450d).b().i();
        if (Flag.Poll.getValue() != r102) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
    L38:
        if (Flag.Poll.getValue() != r102) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L25;
        this.f270451e = r103;
    L25:
        BsyncProtocol r107 = ((k) rgc.b.a(k.class)).p(this.f270450d, r110.f489739a);
        if (r107 == null) goto L29;
        M(r110.f489742d, 1, r102);
        zf7.b.a("[SendMsg] send payload success with https " + jg7.d.M(r110.f489739a));
        this.f270448b.a(1, r107);
        return;
    L29:
        if (r110.f489740b == false) goto L34;
        zf7.b.a("[SendMsg] send payload failed with https " + jg7.d.M(r110.f489739a) + ",do fallback");
        r110.f489740b = false;
        g r108 = this.f270449c;
        if (r108 == null) goto L33;
        r108.F(r110);
        return;
    L33:
        M(r110.f489742d, 2, r102);
        return;
    L34:
        zf7.b.b("[SendMsg] send payload failed with https " + jg7.d.M(r110.f489739a) + ", throw it");
        M(r110.f489742d, 2, r102);
        return;
    L22:
        r106 = false;
        goto L23
    L16:
        if ((r103 - this.f270451e) >= r104) goto L38;
        zf7.b.b("[SendMsg] send poll the distance from last send is less than pollInterval");
        return;
    L13:
        r105 = false;
        goto L14
    L5:
        r100 = UriProtector.parse(this.f270447a.f563460g).buildUpon().appendPath("v2/bytesync/api/pipeline").appendQueryParameter("device_id", ((yf7.c) rgc.b.a(yf7.c.class)).getDeviceInfo().f468523a).appendQueryParameter("platform", "0");
        goto L6
    }

    public final void M(NetTrace r100, int r101, int r102) {
        if (r100 == null) goto L5;
        r100.f270441a = 2;
        r100.f270442b = r101;
        r100.f270443c = r102;
        r100.f270444d = this.f270447a.f563456c.a() ? 1 : 0;
        r100.a();
    L5:
        int r103 = com.bytedance.sync.v2.utils.a.f270548a;
        if (Flag.Sync.getValue() != r102) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L16;
        ((l) rgc.b.a(l.class)).C(2, System.currentTimeMillis());
        return;
    L16:
        return;
    L9:
        r104 = false;
        goto L10
    }

    public b(Context r100, xf7.g r101, i r102, jg7.c r103) {
        this.f270450d = r100;
        this.f270447a = r101;
        this.f270448b = r102;
        this.f270449c = r103;
        this.f270451e = -1;
    }
}
