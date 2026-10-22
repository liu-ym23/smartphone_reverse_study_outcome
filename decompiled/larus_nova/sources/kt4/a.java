package kt4;

import android.view.View;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.hierarchy.HierarchyCounterView;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import gv4.e;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f506046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f506047b;

    public a(SimpleItemModel r100, HierarchyCounterView r101, e r102) {
        this.f506046a = r100;
        this.f506047b = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SimpleItemModel r101 = this.f506046a;
        if (r101 == null) goto L11;
        ActionPayload r102 = r101.getClickActionPayload();
        if (r102 == null) goto L11;
        gv4.a r103 = this.f506047b;
        if (r103 == null) goto L9;
        r103.a(r102);
        Unit r104 = Unit.INSTANCE;
    L10:
        if (r104 == null) goto L11;
        return;
    L9:
        r104 = null;
    L11:
        tt5.a.d("NATIVE_VIEW_TAG", "HierarchyCounterView>> click error. no actionPayload.");
    }
}
