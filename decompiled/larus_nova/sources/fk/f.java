package fk;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements g, com.bytedance.android.ec.hybrid.popup.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.hybrid.popup.f f477568c;

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int c() {
        return this.f477568c.c();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean d() {
        return this.f477568c.d();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean e() {
        return this.f477568c.e();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int f() {
        return this.f477568c.f();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean g() {
        return this.f477568c.g();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final JSONObject getBcm() {
        return this.f477568c.getBcm();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final String getBtm() {
        return this.f477568c.getBtm();
    }

    @Override // fk.g, com.bytedance.android.ec.hybrid.popup.f
    public int getType() {
        return this.f477568c.getType();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int h() {
        return this.f477568c.h();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean i() {
        return this.f477568c.i();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean j() {
        return this.f477568c.j();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean k() {
        return this.f477568c.k();
    }

    @Override // fk.g
    public final String getData() {
        return this.f477567b;
    }

    @Override // fk.g
    public final String getSchema() {
        return this.f477566a;
    }

    public f(com.bytedance.android.ec.hybrid.popup.f r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "popupConfig");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f477568c = r100;
        this.f477566a = r101;
        this.f477567b = r102;
    }
}
