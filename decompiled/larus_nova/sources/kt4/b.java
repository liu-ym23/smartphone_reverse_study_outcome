package kt4;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import gv4.e;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f506048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f506049b;

    public b(SimpleItemModel r100, e r101) {
        this.f506048a = r100;
        this.f506049b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SimpleItemModel r101 = this.f506048a;
        if (r101 == null) goto L10;
        ActionPayload r102 = r101.getClickActionPayload();
        if (r102 == null) goto L11;
        gv4.a r103 = this.f506049b;
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
