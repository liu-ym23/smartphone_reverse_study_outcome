package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFieldTypeSelectionFragment f211694a;

    public f(BitableFieldTypeSelectionFragment r100) {
        this.f211694a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableFieldTypeSelectionFragment r101 = this.f211694a;
        Map<EFieldUIType, String> r102 = BitableFieldTypeSelectionFragment.f211669r;
        r101.W90();
    }
}
