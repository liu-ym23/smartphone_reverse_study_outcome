package wq4;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;
import com.bytedance.ee.bear.bitable.celleditor.editor.barcode.BarcodeEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.dependency.d0;
import com.bytedance.ee.bear.lark.dependency.o0;
import com.bytedance.ee.bear.lark.dependency.p0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import db5.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends kp4.c implements g<BarcodeEditorModel> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final hr4.a f560693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f560694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f560695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f560696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f560697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EditorLocation f560698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BarcodeEditorModel f560699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Boolean f560700x;

    public static final class a implements kp4.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f560701a;

        @Override // kp4.c.d
        public final void a() {
            this.f560701a.f560694r.d(true);
        }

        @Override // kp4.c.d
        public final void b() {
            this.f560701a.A();
        }

        public a(b r100) {
            this.f560701a = r100;
        }

        @Override // hp4.g.b
        public final void c(String r100) {
            String r101 = r100;
            b r102 = this.f560701a;
            r102.f560697u = r101;
            String r103 = "";
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            String r104 = r102.f560696t;
            if (r104 == null) goto L10;
            r103 = r104;
        L10:
            if (TextUtils.equals(r101, r103) == true) goto L12;
            this.f560701a.f(true);
        L12:
            tt5.a.h("BarcodeEditorPanel", "onEditCompleted()... enableSyncData = " + this.f560701a.f560700x);
        }

        @Override // hp4.g.b
        public final void d(Map<String, Object> r100, String r101) {
            b r102 = this.f560701a;
            hr4.a r103 = r102.f560693q;
            BarcodeEditorModel r104 = r102.f560699w;
            if (r104 == null) goto L5;
            String r105 = r104.getFieldUIType();
        L6:
            r103.b(r105, r100, r101);
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: wq4.b$b, reason: collision with other inner class name */
    public static final class C8151b {
    }

    public static final class c implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f560702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f560703b;

        public c(b r100, Context r101) {
            this.f560702a = r100;
            this.f560703b = r101;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.p0
        public final boolean a(String r100) {
            boolean r101 = TextUtils.isEmpty(r100);
            tt5.a.h("BarcodeEditorPanel", "openScanPage()... return: source = 1, result is empty ? " + r101);
            if (r101 == true) goto L5;
            this.f560702a.z(r100, true);
            Toast.showText(this.f560703b, R.string.Bitable_Barcode_BarcodeInforReplaced_Toast);
        L5:
            b r102 = this.f560702a;
            BitableAnalytic r103 = r102.f560693q.f486862d;
            BarcodeEditorModel r104 = r102.f560699w;
            if (r104 != null) goto L8;
        L10:
            boolean r105 = false;
        L11:
            if (r105 == false) goto L13;
            String r106 = "form";
        L14:
            boolean r107 = !r101;
            BarcodeEditorModel r108 = this.f560702a.f560699w;
            if (r108 != null) goto L17;
        L19:
            boolean r109 = false;
        L20:
            r103.C(r106, r107, true, r109);
            com.bytedance.ee.bear.bitable.celleditor.editor.b r110 = this.f560702a.f560694r;
            int r111 = com.bytedance.ee.bear.bitable.celleditor.editor.b.f209378b;
            r110.d(false);
            return true;
        L17:
            if (r108.getInputType() != 0) goto L19;
            r109 = true;
            goto L20
        L13:
            r106 = GXViewKey.VIEW_TYPE_CONTAINER_GRID;
            goto L14
        L8:
            if (r104.isForm() != true) goto L10;
            r105 = true;
            goto L11
        }
    }

    public static final class d implements o0 {
        public d() {
        }
    }

    static {
    }

    public final void A() {
        boolean r100 = true;
        this.f505500m = true;
        Context r101 = this.f560693q.getContext();
        d r102 = new d();
        c r103 = new c(this, r101);
        ((d0) org.koin.java.a.c(d0.class, null, null, 6)).b(r101, new int[]{0, 1}, r103, r102);
        BitableAnalytic r104 = this.f560693q.f486862d;
        BarcodeEditorModel r105 = this.f560699w;
        if (r105 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L10;
        String r107 = "form";
    L11:
        BarcodeEditorModel r108 = this.f560699w;
        if (r108 != null) goto L14;
    L16:
        r100 = false;
    L17:
        r104.F(r107, r100);
        return;
    L14:
        if (r108.getInputType() != 0) goto L16;
    L10:
        r107 = GXViewKey.VIEW_TYPE_CONTAINER_GRID;
        goto L11
    L5:
        if (r105.isForm() != true) goto L7;
        r106 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
        if (Intrinsics.areEqual(this.f560700x, Boolean.TRUE) == false) goto L6;
        z(this.f560697u, false);
        return;
    }

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        boolean r100 = false;
        if (this.f560695s != 0) goto L23;
        BarcodeEditorModel r101 = this.f560699w;
        String r102 = null;
        if (r101 == null) goto L7;
        List<? extends SegmentModel> r103 = r101.getValue();
    L8:
        db5.a r104 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.b(r103);
        BarcodeEditorModel r105 = this.f560699w;
        if (r105 == null) goto L11;
        r102 = r105.getFieldName();
    L11:
        String r106 = r104.f467804a;
        BarcodeEditorModel r107 = this.f560699w;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        BarcodeEditorModel r109 = this.f560699w;
        if (r109 != null) goto L20;
    L22:
        w(r102, r106, r108, r100);
        return;
    L20:
        if (r109.getScanEnable() != true) goto L22;
        r100 = true;
        goto L22
    L14:
        if (r107.getTextEditable() != true) goto L16;
        r108 = true;
        goto L17
    L7:
        r103 = null;
        goto L8
    L23:
        A();
        com.bytedance.ee.bear.bitable.celleditor.editor.b r110 = this.f560694r;
        int r111 = com.bytedance.ee.bear.bitable.celleditor.editor.b.f209378b;
        r110.d(false);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
        if (Intrinsics.areEqual(this.f560700x, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        this.f560700x = Boolean.valueOf(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        BarcodeEditorModel r102 = (BarcodeEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f560698v = r102.getLocation();
        this.f560699w = r102;
        this.f560696t = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.b(r102.getValue()).f467804a;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        Intrinsics.checkNotNullParameter((BarcodeEditorModel) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
    }

    public final void z(String r100, boolean r101) {
        int r102 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.f207102a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        List<SegmentModel> r103 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(new db5.a(r100, new bo4.a[0], new j[0]));
        if (r101 == false) goto L11;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        ((SegmentModel) r104.next()).editType = "scan";
    L11:
        this.f560694r.b(this.f560698v, r103);
    }

    public b(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100.getContext(), r100.a());
        this.f560693q = r100;
        this.f560694r = r101;
        this.f560695s = r102;
        this.f486402f = new a(this);
        if (com.bytedance.ee.bear.bitable.c.o() == false) goto L6;
        CellEditDragView r103 = this.f505503p.f210988b;
        r103.f(r103.getContext().getString(R.string.Bitable_Common_ButtonCancel), Integer.valueOf(R.color.text_title));
        return;
    }
}
