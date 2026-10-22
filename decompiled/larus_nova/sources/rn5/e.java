package rn5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel;
import com.bytedance.ee.bear.sheet_core.toolbar2.SheetBlockCellAttrFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements OfficeBorderLineViewModel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f538677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SheetBlockCellAttrFragment f538678b;

    @Override // com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel.a
    public final void a(JSONObject r100) {
        SheetBlockCellAttrFragment r101 = this.f538678b;
        ItemV2 r102 = this.f538677a;
        int r103 = SheetBlockCellAttrFragment.f238526x;
        r101.ga0(r102, r100);
    }

    public e(SheetBlockCellAttrFragment r100, ItemV2 r101) {
        this.f538678b = r100;
        this.f538677a = r101;
    }
}
