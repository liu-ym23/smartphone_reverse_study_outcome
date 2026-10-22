package com.ss.android.lark.contact.base.contact_search;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418815a;

    public o(s r100) {
        this.f418815a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f418815a.f418825r.setVisibility(0);
        this.f418815a.f418826s.setVisibility(8);
        KeyboardUtils.showKeyboard(this.f418815a.f418825r);
        return this.f418815a.f418825r.dispatchTouchEvent(r101);
    }
}
