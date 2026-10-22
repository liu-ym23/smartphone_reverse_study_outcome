package om5;

import com.bytedance.ee.bear.sheet.cellcontent.SheetCellContentPlugin;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements un5.a.InterfaceC0318a {
    public final /* synthetic */ BaseSegment a;
    public final /* synthetic */ c b;

    @Override // un5.a.InterfaceC0318a
    public final void B3(un5.a r2) {
        com.bytedance.ee.bear.sheet.cellcontent.a r3 = this.b.g;
        if (r3 == null) goto L6;
        BaseSegment r0 = this.a;
        SheetCellContentPlugin.access$000(((SheetCellContentPlugin.a) r3).a).b(mu5.b.a(r0));
        return;
    }

    public a(c r1, BaseSegment r2) {
        this.b = r1;
        this.a = r2;
    }
}
