package eo5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.search.base.BaseSearchModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseSearchModel {
    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final String getTemplateType() {
        return "ugc";
    }

    public a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseSearchModel, com.bytedance.ee.bear.templates.search.base.e
    public final NetService.f S5(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "searchKey");
        Intrinsics.checkNotNullParameter(r4, "buffer");
        NetService.f r5 = super.S5(r2, r3, r4);
        r5.b("source", "2");
        return r5;
    }
}
