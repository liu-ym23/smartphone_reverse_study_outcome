package rn5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel;
import com.bytedance.ee.bear.sheet_core.toolbar2.SheetBlockCellAttrFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements OfficeBorderLineViewModel.a {
    public final /* synthetic */ ItemV2 a;
    public final /* synthetic */ SheetBlockCellAttrFragment b;

    @Override // com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel.a
    public final void a(JSONObject r4) {
        SheetBlockCellAttrFragment r0 = this.b;
        ItemV2 r1 = this.a;
        int r2 = SheetBlockCellAttrFragment.x;
        r0.ga0(r1, r4);
    }

    public e(SheetBlockCellAttrFragment r1, ItemV2 r2) {
        this.b = r1;
        this.a = r2;
    }
}
