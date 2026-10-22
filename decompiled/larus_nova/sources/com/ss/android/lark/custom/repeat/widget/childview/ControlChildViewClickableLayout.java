package com.ss.android.lark.custom.repeat.widget.childview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes35.dex */
public class ControlChildViewClickableLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f420358a;

    public ControlChildViewClickableLayout(Context r100) {
        super(r100);
        this.f420358a = true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return !this.f420358a;
    }

    public void setChildViewClickable(boolean r100) {
        this.f420358a = r100;
    }

    public ControlChildViewClickableLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f420358a = true;
    }
}
