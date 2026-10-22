package jc4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class o extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final JSONObject f498127o;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String g() {
        return "smarter_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 5;
    }

    @Override // jc4.a
    public final String e() {
        return this.f498126n;
    }

    public o(JSONObject r100) {
        Intrinsics.checkNotNullParameter("smartest_verify", "service");
        this.f498126n = "smartest_verify";
        this.f498127o = r100;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        hc4.f.b(r100, "use_dialog_size_v2", com.bytedance.bdturing.setting.e.h());
    }
}
