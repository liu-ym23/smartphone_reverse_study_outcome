package nn5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.sheet.borderline.BorderLineViewModel;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockCellAttrFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements BorderLineViewModel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f519650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SheetBlockCellAttrFragment f519651b;

    @Override // com.bytedance.ee.bear.sheet.borderline.BorderLineViewModel.a
    public final void a(JSONObject r100) {
        SheetBlockCellAttrFragment r101 = this.f519651b;
        ItemV2 r102 = this.f519650a;
        int r103 = SheetBlockCellAttrFragment.f238421v;
        r101.ga0(r102, r100);
    }

    public e(SheetBlockCellAttrFragment r100, ItemV2 r101) {
        this.f519651b = r100;
        this.f519650a = r101;
    }
}
