package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class p extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f498129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f498130p;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "sms";
    }

    @Override // jc4.a
    public final String g() {
        return "sms";
    }

    @Override // jc4.a
    public int getType() {
        return 1;
    }

    public p() {
        this.f498128n = null;
        this.f498129o = false;
        this.f498130p = null;
        this.f498090a = true;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "scene", this.f498128n);
        hc4.f.b(r100, "show_success_toast", this.f498129o ? 1 : 0);
        hc4.f.c(r100, "uid", this.f498130p);
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        hc4.f.b(r100, "use_dialog_size_v2", com.bytedance.bdturing.setting.e.h());
    }
}
