package nz5;

import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.sdk.p;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends a {
    @Override // nz5.a
    public final String b() {
        return "main_page";
    }

    @Override // nz5.a
    public final boolean e() {
        return true;
    }

    public k() {
    }

    @Override // nz5.a
    public final boolean c(AnchorInfoModel r100, Object r101) {
        return !r100.b().contains(p.f245593n.f245597d);
    }
}
