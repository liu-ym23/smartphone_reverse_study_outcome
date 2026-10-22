package zq4;

import android.widget.TextView;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.date.DateEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lp4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends f implements g<DateEditorModel> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hr4.a f573336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f573337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f573338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DateEditorModel f573339x;

    public static final class a implements hp4.g.b<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f573340a;

        public a(b r100) {
            this.f573340a = r100;
        }

        @Override // hp4.g.b
        public final void c(Long r100) {
            com.bytedance.ee.bear.bitable.celleditor.editor.b r101 = this.f573340a.f573337v;
            r101.b(null, r100);
        }

        @Override // hp4.g.b
        public final void d(Map<String, Object> r100, String r101) {
            b r102 = this.f573340a;
            hr4.a r103 = r102.f573336u;
            DateEditorModel r104 = r102.f573339x;
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

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
    }

    public b(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100.getContext());
        this.f573336u = r100;
        this.f573337v = r101;
        this.f573338w = true;
        this.f486402f = new a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        DateEditorModel r102 = (DateEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f573339x = r102;
        Long r103 = r102.getValue();
        r102.getDateFormat();
        String r104 = r102.getTimeFormat();
        boolean r105 = this.f573338w;
        String r106 = r102.getTimeZone();
        this.f510222n = r103;
        this.f510223o = r104;
        this.f510227s = r106;
        this.f510224p = !r105;
        if (r105 == false) goto L5;
        w();
    L5:
        String r107 = r102.getFieldName();
        TextView r108 = this.f510228t;
        if (r108 == null) goto L8;
        r108.setText(r107);
    L8:
        this.f573338w = false;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        Intrinsics.checkNotNullParameter((DateEditorModel) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
    }
}
