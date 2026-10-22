package xq4;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.chatter.SuggestChatterAdapter;
import com.bytedance.ee.bear.bitable.card.view.cell.chatter.s;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.chatter.ChatterEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.chatter.ChatterEditorValue;
import com.bytedance.ee.bear.utils.AtUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends s implements com.bytedance.ee.bear.bitable.celleditor.editor.g<ChatterEditorModel>, com.bytedance.ee.bear.bitable.celleditor.editor.f {
    public final hr4.a A;
    public final xq4.a B;
    public ChatterEditorModel C;
    public Boolean D;
    public List<? extends GroupEntity> E;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f
    public final void B() {
        this.B.d(true);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void destroy() {
        hideKeyboard();
        if (Intrinsics.areEqual(this.D, Boolean.TRUE) == false) goto L6;
        xq4.a r100 = this.B;
        ChatterEditorValue r101 = new ChatterEditorValue();
        r101.setGroups(this.E);
        r100.c(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
        if (Intrinsics.areEqual(this.D, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        this.D = Boolean.valueOf(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        ChatterEditorModel r102 = (ChatterEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.C = r102;
        Integer r103 = r102.getMaxSelectCount();
        boolean r104 = true;
        if (r103 == null) goto L5;
        int r105 = r103.intValue();
    L6:
        if (r105 > 1) goto L9;
        r104 = false;
    L9:
        com.bytedance.ee.bear.bitable.card.view.cell.chatter.f<T>.e r106 = this.f207572q;
        if (r106 == null) goto L12;
        SuggestChatterAdapter<T> r107 = r106.f207597p;
        r107.f207550d = Integer.valueOf(r105);
    L12:
        String r108 = r102.getFieldName();
        if (r108 != null) goto L15;
        r108 = "";
    L15:
        ChatterEditorValue r109 = r102.getValue();
        if (r109 == null) goto L18;
        List<GroupEntity> r110 = r109.getGroups();
    L19:
        E(r108, r104, r110);
        return;
    L18:
        r110 = null;
        goto L19
    L5:
        r105 = 1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        Intrinsics.checkNotNullParameter((ChatterEditorModel) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
    }

    public g(hr4.a r110, xq4.a r111, String r112, boolean r113, b r114) {
        Intrinsics.checkNotNullParameter(r110, "mEditorContext");
        Intrinsics.checkNotNullParameter(r111, "mActionHandler");
        Intrinsics.checkNotNullParameter(r112, "token");
        super(r110.getContext(), r110.f486859a, r112, AtUtils.h(sbb.e.f541298i), r113, r110.f486862d, r114);
        this.A = r110;
        this.B = r111;
        this.f486404h = new FrameLayout.LayoutParams(-1, -1);
        this.f486406j = r110.f486866h;
        this.f486402f = new d(this);
        com.bytedance.ee.bear.bitable.card.view.cell.chatter.f<T>.e r115 = this.f207572q;
        if (r115 == null) goto L9;
        CellEditDragView r116 = r115.f207583b;
        if (r116 == null) goto L9;
        r116.setHeightChangedListener(new e(this));
        if (com.bytedance.ee.bear.bitable.c.o() == false) goto L9;
        r116.f(r116.getContext().getString(R.string.Bitable_Common_ButtonCancel), Integer.valueOf(R.color.text_title));
    L9:
        if (r113 == false) goto L16;
        com.bytedance.ee.bear.bitable.card.view.cell.chatter.f<T>.e r117 = this.f207572q;
        if (r117 == null) goto L17;
        SuggestChatterAdapter<T> r118 = r117.f207597p;
        if (r118 == 0) goto L18;
        r118.f207554h = new f(this);
        return;
    L18:
        return;
    L17:
        return;
    }
}
