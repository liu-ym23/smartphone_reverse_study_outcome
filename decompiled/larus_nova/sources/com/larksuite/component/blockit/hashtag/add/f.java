package com.larksuite.component.blockit.hashtag.add;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283014a;

    public f(b r100) {
        this.f283014a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        b r101 = this.f283014a;
        EditText r102 = (EditText) r101.f283002a.findViewById(R.id.etSearchHashTag);
        r102.setFocusable(true);
        r102.setFocusableInTouchMode(true);
        r102.requestFocus();
        r101.f283002a.postDelayed(new h(r101), 150);
    }
}
