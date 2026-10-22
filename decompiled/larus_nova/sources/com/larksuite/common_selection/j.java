package com.larksuite.common_selection;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;

/* JADX INFO: loaded from: classes24.dex */
public final class j implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f282899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectionHandleType f282900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SelectionContainer f282901c;

    public j(i r100, SelectionHandleType r101, SelectionContainer r102) {
        this.f282899a = r100;
        this.f282900b = r101;
        this.f282901c = r102;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L11;
        i r102 = this.f282899a;
        SelectionHandleType r103 = this.f282900b;
        r102.f282881n = r103;
        if (r103 != null) goto L10;
        b r104 = r102.f282886s;
        if (r104 == null) goto L9;
        r104.f282865a.dismiss();
    L9:
        r102.f282886s = null;
    L10:
        this.f282901c.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L11:
        return false;
    }
}
