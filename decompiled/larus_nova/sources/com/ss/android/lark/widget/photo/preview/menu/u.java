package com.ss.android.lark.widget.photo.preview.menu;

import androidx.lifecycle.Observer;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f447017a;

    public u(q r100) {
        this.f447017a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L9;
        q r102 = this.f447017a;
        r101.intValue();
        if (r101.intValue() != 100) goto L7;
        r102.b().setText(UIHelper.getString(R.string.Lark_Legacy_Loaded));
        return;
    L7:
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        r103.append('%');
        String r104 = r103.toString();
        r102.b().setText(r104);
        return;
    }
}
