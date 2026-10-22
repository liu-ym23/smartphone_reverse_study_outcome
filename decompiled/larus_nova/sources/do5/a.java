package do5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.search.base.BaseSearchModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BaseSearchModel {
    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final String getTemplateType() {
        return "egc";
    }

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseSearchModel, com.bytedance.ee.bear.templates.search.base.e
    public final NetService.f S5(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "searchKey");
        Intrinsics.checkNotNullParameter(r102, "buffer");
        NetService.f r103 = super.S5(r100, r101, r102);
        r103.b("source", "3");
        return r103;
    }
}
