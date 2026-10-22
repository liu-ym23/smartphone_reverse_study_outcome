package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class m extends BitableSelectorItemView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f211712i;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView
    public final void a() {
        if (getMEnabled() == true) goto L5;
        BitableSelectorItemView.b r100 = getMItemClickListener();
        if (r100 == null) goto L21;
        r100.a(this);
        return;
    L21:
        return;
    L5:
        if (this.f211712i == false) goto L7;
        return;
    L7:
        BitableSelectorItemView.b r101 = getMItemClickListener();
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L19;
        setChecked(!this.f211712i);
        return;
    L19:
        return;
    L10:
        if (r101.b(this) != true) goto L12;
        r102 = true;
        goto L13
    }

    public m(Context r100) {
        super(r100, null, 6, 0);
        d(R.drawable.ud_icon_list_check_bold_outlined, Integer.valueOf(R.color.primary_fill_default));
    }

    public final void setChecked(boolean r100) {
        this.f211712i = r100;
        setRightIconVisible(r100);
    }
}
