package tp4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UpdateStrategy;
import com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTableCellValue;
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewLogger;
import com.bytedance.ee.bear.bitable.itemview.util.l;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.y0;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MobileViewContainerType f547047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f547049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkTableCellValue f547050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f547051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f547052i;

    @Override // tp4.a
    public final boolean b(cp4.b r100, String r101) {
        return false;
    }

    @Override // tp4.a
    public final void g(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // tp4.a
    public final void destroy() {
        n(MapMonitorConst.EVENT_DESTROY);
        m();
        this.f547051h = null;
        this.f547050g = null;
    }

    public final void m() {
        b r100 = this.f547051h;
        if (r100 == null) goto L6;
        r100.a(new String[]{this.f547048e});
        return;
    }

    @Override // tp4.a
    public final String i() {
        return this.f547048e;
    }

    @Override // tp4.a
    public final void a(LinkTableCellValue r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        n("updateDate");
        if (this.f547050g != null) goto L5;
    L7:
        this.f547050g = r100;
        f r101 = this.f547052i;
        if (r101 == null) goto L11;
        r101.e(r100);
        return;
    L11:
        return;
    L5:
        if (l(r100) == true) goto L7;
        this.f547050g = r100;
        n("update LinkTableId");
        m();
        k(this.f547049f);
        goto L7
    }

    @Override // tp4.a
    public final void d(boolean r100) {
        if (this.f547049f != r100) goto L5;
        return;
    L5:
        k(r100);
    }

    @Override // tp4.a
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f547052i = r100;
        LinkTableCellValue r101 = this.f547050g;
        if (r101 == null) goto L6;
        r100.e(r101);
        return;
    }

    @Override // tp4.a
    public final boolean f(LinkTableCellValue r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return l(r100);
    }

    @Override // tp4.a
    public final void h(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableNativeViewData r101 = r100.f538848a.getValue();
        if (r101 == null) goto L9;
        BaseViewData<?, ?> r102 = r101.getData();
        if (r102 == null) goto L9;
        UpdateStrategy r103 = r102.getUpdateStrategy();
        if (r103 == null) goto L9;
        String r104 = r103.getStrategy();
    L10:
        n("updateViewData, strategy: " + r104);
        f r105 = this.f547052i;
        if (r105 == null) goto L14;
        r105.c(r100);
        return;
    L14:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // tp4.a
    public final void k(boolean r100) {
        this.f547049f = r100;
        LinkTableCellValue r101 = this.f547050g;
        if (r101 == null) goto L8;
        n("attachTableView active: " + r100);
        b r102 = this.f547051h;
        if (r102 == null) goto L9;
        r102.b(this.f547048e, this.f547047d.name(), r101, r100);
        return;
    L9:
        return;
    }

    public final boolean l(LinkTableCellValue r100) {
        LinkTableCellValue r101 = this.f547050g;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getLinkTableId();
    L6:
        boolean r104 = y0.a(r103, r100.getLinkTableId());
        LinkTableCellValue r105 = this.f547050g;
        if (r105 == null) goto L9;
        String r106 = r105.getRecordId();
    L10:
        boolean r107 = y0.a(r106, r100.getRecordId());
        LinkTableCellValue r108 = this.f547050g;
        if (r108 == null) goto L13;
        String r109 = r108.getFieldId();
    L14:
        boolean r110 = y0.a(r109, r100.getFieldId());
        LinkTableCellValue r111 = this.f547050g;
        if (r111 == null) goto L17;
        r102 = r111.getRenderId();
    L17:
        boolean r112 = y0.a(r102, r100.getRenderId());
        if (r104 == false) goto L23;
        if (r107 == false) goto L23;
        if (r110 == false) goto L23;
        if (r112 == false) goto L23;
        return true;
    L23:
        return false;
    L13:
        r109 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        l.a("LinkModel " + this.f547044a + '-' + this.f547045b + '-' + this.f547046c + '-' + this.f547047d + ": " + r100, ItemViewLogger.ItemViewLinkTable, null, null, 12);
    }

    @Override // tp4.a
    public final boolean c(String r100, String r101) {
        LinkTableCellValue r102 = this.f547050g;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getTableId();
    L7:
        if (Intrinsics.areEqual(r100, r104) == false) goto L15;
        LinkTableCellValue r105 = this.f547050g;
        if (r105 == null) goto L12;
        r103 = r105.getRecordId();
    L12:
        if (Intrinsics.areEqual(r101, r103) == false) goto L15;
        if (r100 == null) goto L15;
        return true;
    L15:
        return false;
    L5:
        r104 = null;
        goto L7
    }

    @Override // tp4.a
    public final boolean j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        Intrinsics.checkNotNullParameter(r102, "fieldId");
        if (Intrinsics.areEqual(this.f547044a, r100) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f547045b, r101) == false) goto L9;
        if (Intrinsics.areEqual(this.f547046c, r102) == false) goto L9;
        return true;
    }

    public e(String r100, String r101, String r102, MobileViewContainerType r103) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        Intrinsics.checkNotNullParameter(r102, "fieldId");
        Intrinsics.checkNotNullParameter(r103, "containerType");
        this.f547044a = r100;
        this.f547045b = r101;
        this.f547046c = r102;
        this.f547047d = r103;
        this.f547048e = UUID.randomUUID().toString();
        this.f547049f = true;
        n("init");
    }
}
