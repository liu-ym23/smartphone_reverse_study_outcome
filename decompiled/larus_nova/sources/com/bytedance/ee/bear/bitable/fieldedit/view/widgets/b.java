package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FieldConfigMetaModel.CommonColor f211758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f211759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.c f211760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f211761d;

    public b(FieldConfigMetaModel.CommonColor r100, a r101, a.c r102, int r103) {
        this.f211758a = r100;
        this.f211759b = r101;
        this.f211760c = r102;
        this.f211761d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FieldConfigMetaModel.CommonColor r101 = this.f211758a;
        if (r101 == null) goto L8;
        a r102 = this.f211759b;
        a.c r103 = this.f211760c;
        int r104 = this.f211761d;
        r102.f211737b.c(r101);
        r102.a(r101);
        r102.f211742g = r101.getId();
        r103.notifyDataSetChanged();
        a.C3035a r105 = r102.f211743h;
        if (r105 == null) goto L9;
        r105.smoothScrollToPosition(r102.f211739d, new RecyclerView.State(), r104);
        return;
    L9:
        return;
    }
}
