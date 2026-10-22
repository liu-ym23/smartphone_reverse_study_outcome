package com.larksuite.component.blockit.hashtag.add;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283013a;

    public e(b r100) {
        this.f283013a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        ((EditText) this.f283013a.f283002a.findViewById(R.id.etSearchHashTag)).setText("");
    }
}
