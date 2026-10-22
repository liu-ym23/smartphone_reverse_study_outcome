package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes15.dex */
public class EllipsizeEditText extends FieldEditText {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public KeyListener f211717b1;

    public EllipsizeEditText(Context r100) {
        this(r100, null);
    }

    public EllipsizeEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public EllipsizeEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f211717b1 = getKeyListener();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
        if (r100 == false) goto L5;
        setKeyListener(this.f211717b1);
        return;
    L5:
        setKeyListener(null);
    }
}
