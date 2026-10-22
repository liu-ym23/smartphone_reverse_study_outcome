package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FieldConfigMetaModel.RatingSymboInfo f211783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f211784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.C3039d f211785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f211786d;

    public e(FieldConfigMetaModel.RatingSymboInfo r100, d r101, d.C3039d r102, int r103) {
        this.f211783a = r100;
        this.f211784b = r101;
        this.f211785c = r102;
        this.f211786d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FieldConfigMetaModel.RatingSymboInfo r101 = this.f211783a;
        if (r101 == null) goto L8;
        d r102 = this.f211784b;
        d.C3039d r103 = this.f211785c;
        int r104 = this.f211786d;
        r102.f211772j = r101.getSymbol();
        r102.c(r101);
        r102.f211764b.c(r101);
        r103.notifyDataSetChanged();
        d.a r105 = r102.f211768f;
        if (r105 == null) goto L9;
        r105.smoothScrollToPosition(r102.f211766d, new RecyclerView.State(), r104);
        return;
    L9:
        return;
    }
}
