package com.larksuite.component.blockit.hashtag.add;

import android.text.Editable;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283010a;

    public c(b r100) {
        this.f283010a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        String r101 = String.valueOf(r100);
        b r102 = this.f283010a;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L11;
        ((ImageView) r102.f283002a.findViewById(R.id.ivSearchDelete)).setVisibility(8);
        j.a r104 = r102.f283006e;
        if (r104 == null) goto L15;
        r104.r7(r101);
        return;
    L15:
        return;
    L11:
        ((ImageView) r102.f283002a.findViewById(R.id.ivSearchDelete)).setVisibility(0);
        j.a r105 = r102.f283006e;
        if (r105 == null) goto L17;
        r105.r7(r101);
        return;
    L17:
        return;
    L5:
        r103 = false;
        goto L7
    }
}
