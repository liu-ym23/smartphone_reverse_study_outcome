package jc4;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class g extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f498114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f498115o;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "verify";
    }

    @Override // jc4.a
    public int getType() {
        return 2;
    }

    @Override // jc4.a
    public final boolean b() {
        if (Intrinsics.areEqual("live_h5", this.f498101l) == true) goto L5;
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        return com.bytedance.bdturing.setting.e.i();
    L5:
        return vb4.e.e();
    }

    @Override // jc4.a
    public final String g() {
        if (TextUtils.isEmpty(this.f498115o) == false) goto L7;
        return String.valueOf(this.f498114n);
    L7:
        return this.f498115o;
    }

    public g(int r100) {
        this.f498114n = r100;
        this.f498115o = "";
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        int r101 = this.f498114n;
        if (r101 == 0) goto L5;
        hc4.f.b(r100, "challenge_code", r101);
    L5:
        com.bytedance.bdturing.setting.e r102 = com.bytedance.bdturing.setting.e.f202077a;
        hc4.f.b(r100, "use_dialog_size_v2", com.bytedance.bdturing.setting.e.h());
    }
}
