package er4;

import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.bitable.celleditor.editor.rating.RatingEditorModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends com.bytedance.ee.bear.bitable.card.view.cell.rating.b implements g<RatingEditorModel> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final hr4.a f473584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f473585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f473586n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f473587o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public hp4.g.a f473588p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RatingEditorModel f473589q;

    public static final class a implements com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f473590a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
        public final void a() {
            this.f473590a.f473585m.d(true);
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
        public final String getTitle() {
            RatingEditorModel r100 = this.f473590a.f473589q;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getFieldName();
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
        public final mr4.a o() {
            return this.f473590a.f473584l.f486866h;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
        public final void onDismiss() {
            hp4.g.a r100 = this.f473590a.f473588p;
            if (r100 == null) goto L6;
            r100.onDismiss();
            return;
        }

        public a(b r100) {
            this.f473590a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
        public final void b(Integer r100) {
            if (c.o() == false) goto L5;
            b r101 = this.f473590a;
            r101.f473586n = r100;
            r101.f(true);
            return;
        L5:
            this.f473590a.f473585m.c(r100);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
        this.f473588p = null;
        if (Intrinsics.areEqual(this.f473587o, Boolean.TRUE) == false) goto L6;
        this.f473585m.c(this.f473586n);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        if (c.o() == false) goto L8;
        String r100 = getContext().getString(R.string.Bitable_Common_ButtonCancel);
        Integer r101 = Integer.valueOf(R.color.text_title);
        CommonActionPanelLayout r102 = this.f208018d;
        if (r102 == null) goto L9;
        r102.f(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
        if (Intrinsics.areEqual(this.f473587o, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        this.f473587o = Boolean.valueOf(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void h(hp4.g.a r100) {
        this.f473588p = r100;
    }

    public b(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100.getContext(), r100.f486862d);
        this.f473584l = r100;
        this.f473585m = r101;
        this.f208022h = new a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        RatingEditorModel r102 = (RatingEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f473589q = r102;
        c(r102.getRatingSymbolId(), r102.getMin(), r102.getMax());
        update(r102.getValue());
        String r103 = r102.getFieldName();
        CommonActionPanelLayout r104 = this.f208018d;
        if (r104 == null) goto L6;
        r104.setTitle(r103);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        RatingEditorModel r102 = (RatingEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        update(r102.getValue());
    }
}
