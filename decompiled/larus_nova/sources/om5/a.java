package om5;

import com.bytedance.ee.bear.sheet.cellcontent.SheetCellContentPlugin;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements un5.a.InterfaceC7903a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSegment f524291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f524292b;

    @Override // un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        com.bytedance.ee.bear.sheet.cellcontent.a r101 = this.f524292b.f524295g;
        if (r101 == null) goto L6;
        BaseSegment r102 = this.f524291a;
        SheetCellContentPlugin.access$000(((SheetCellContentPlugin.a) r101).f237420a).b(mu5.b.a(r102));
        return;
    }

    public a(c r100, BaseSegment r101) {
        this.f524292b = r100;
        this.f524291a = r101;
    }
}
