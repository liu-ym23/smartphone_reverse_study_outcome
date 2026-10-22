package zt4;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableResourceData f573585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.preload.g.a f573586f;

    @Override // zt4.a
    public final String d() {
        return "clientVar";
    }

    @Override // zt4.a
    public final boolean f() {
        return false;
    }

    @Override // zt4.a
    public final boolean g() {
        return false;
    }

    @Override // zt4.a
    public final void a() {
        this.f573581a.A("BITABLE_NATIVE_PRELOAD_CLIENTVAR_END", System.currentTimeMillis());
        com.bytedance.ee.bear.bitable.preload.g.a r100 = this.f573586f;
        if (r100 == null) goto L12;
        BitableResourceData r101 = this.f573585e;
        if (r101 == null) goto L9;
        String r102 = r101.getResValue();
        if (r102 == null) goto L9;
        long r103 = r102.length();
    L10:
        com.bytedance.ee.bear.bitable.preload.g.d(r100, r103, "", "");
        return;
    L9:
        r103 = -1;
        goto L10
    }

    @Override // zt4.a
    public final void b() {
        this.f573586f = com.bytedance.ee.bear.bitable.preload.g.b("BITABLE_CLIENT_VARS", "Use");
        this.f573581a.A("BITABLE_NATIVE_PRELOAD_CLIENTVAR_START", System.currentTimeMillis());
    }

    @Override // zt4.a
    public final boolean h() {
        BitableResourceData r100 = this.f573585e;
        if (r100 == null) goto L10;
        String r101 = r100.getResValue();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() > 0) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public b(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
    }
}
