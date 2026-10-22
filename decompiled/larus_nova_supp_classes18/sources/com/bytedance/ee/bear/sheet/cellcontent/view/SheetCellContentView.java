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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetCellContentView extends AppCompatTextView implements r {
    public MovementMethod a;
    public long b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        MovementMethod r0 = LinkMovementMethod.getInstance();
        this.a = r0;
        setMovementMethod(r0);
        setHintTextColor(getContext().getResources().getColor(R.color.transparent));
    }

    public SheetCellContentView(Context r3) {
        super(r3);
        this.b = 0;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r6) {
        if (r6.getAction() != 0) goto L6;
        this.b = System.currentTimeMillis();
    L6:
        if (isTextSelectable() == false) goto L13;
        if (r6.getAction() != 1) goto L13;
        if ((System.currentTimeMillis() - this.b) >= ViewConfiguration.getLongPressTimeout()) goto L13;
        this.a.onTouchEvent(this, (Spannable) getText(), r6);
    L13:
        return super/*android.widget.TextView*/.onTouchEvent(r6);
    }

    public SheetCellContentView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = 0;
        init();
    }

    public SheetCellContentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = 0;
        init();
    }
}
