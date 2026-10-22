package com.ss.android.lark.contact.base.contact_search;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418808a;

    public h(s r100) {
        this.f418808a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f418808a.f418829v.setVisibility(0);
        this.f418808a.f418830w.setVisibility(8);
        KeyboardUtils.showKeyboard(this.f418808a.f418829v);
        return this.f418808a.f418829v.dispatchTouchEvent(r101);
    }
}
