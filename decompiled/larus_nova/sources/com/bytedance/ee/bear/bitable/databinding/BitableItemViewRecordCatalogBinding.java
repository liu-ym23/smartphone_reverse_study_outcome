package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.page.RecordCatalogView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewRecordCatalogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecordCatalogView f210866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f210867c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210865a;
    }

    public BitableItemViewRecordCatalogBinding(View r100, RecordCatalogView r101, TextView r102) {
        this.f210865a = r100;
        this.f210866b = r101;
        this.f210867c = r102;
    }
}
