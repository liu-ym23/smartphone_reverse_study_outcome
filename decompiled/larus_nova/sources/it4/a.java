package it4;

import android.view.View;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldData;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import gv4.e;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridFieldData f495719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f495720b;

    public a(GridFieldData r100, e r101) {
        this.f495719a = r100;
        this.f495720b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        GridFieldData r101 = this.f495719a;
        if (r101 == null) goto L10;
        ActionPayload r102 = r101.getClickAction();
        if (r102 == null) goto L11;
        gv4.a r103 = this.f495720b;
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
