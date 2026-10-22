package com.bytedance.ee.bear.sheet.cellcontent.view;

import android.R;
import android.content.Context;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import sa5.r;

/* JADX INFO: loaded from: classes18.dex */
public class SheetCellContentView extends AppCompatTextView implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MovementMethod f237442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f237443b;

    public final void init() {
        MovementMethod r100 = LinkMovementMethod.getInstance();
        this.f237442a = r100;
        setMovementMethod(r100);
        setHintTextColor(getContext().getResources().getColor(R.color.transparent));
    }

    public SheetCellContentView(Context r100) {
        super(r100);
        this.f237443b = 0;
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.f237443b = System.currentTimeMillis();
    L6:
        if (isTextSelectable() == false) goto L13;
        if (r100.getAction() != 1) goto L13;
        if ((System.currentTimeMillis() - this.f237443b) >= ViewConfiguration.getLongPressTimeout()) goto L13;
        this.f237442a.onTouchEvent(this, (Spannable) getText(), r100);
    L13:
        return super.onTouchEvent(r100);
    }

    public SheetCellContentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f237443b = 0;
        init();
    }

    public SheetCellContentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f237443b = 0;
        init();
    }
}
