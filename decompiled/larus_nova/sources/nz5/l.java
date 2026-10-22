package nz5;

import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.sdk.p;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends a {
    @Override // nz5.a
    public final String b() {
        return "multiple_page";
    }

    @Override // nz5.a
    public final boolean e() {
        return false;
    }

    public l() {
    }

    @Override // nz5.a
    public final boolean c(AnchorInfoModel r100, Object r101) {
        String r102 = p.f245593n.f245597d;
        return r100.j().contains(r102);
    }
}
