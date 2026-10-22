package com.bytedance.ee.bear.drive.biz.wps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/PdfEditButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PdfEditButton extends FrameLayout {

    public static final class a implements View.OnGenericMotionListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View r1, MotionEvent r2) {
            return true;
        }
    }

    public static final class b {
    }

    static {
    }

    public PdfEditButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public PdfEditButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public PdfEditButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        View r0 = findViewById(2131371396);
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public PdfEditButton(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        LayoutInflater.from(r2).inflate(2131563385, this, true);
        View r6 = findViewById(2131371396);
        if (r6 == null) goto L12;
        r6.setOnGenericMotionListener(a.a);
        return;
    }
}
