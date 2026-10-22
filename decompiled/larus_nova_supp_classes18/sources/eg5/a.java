package eg5;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ View b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        this.a.getGlobalVisibleRect(r0);
        this.b.getGlobalVisibleRect(r1);
        String r2 = this.a.getText().toString();
        int r3 = this.a.getLineCount();
        if (this.a.getLayout() != null) goto L6;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L6:
        int r4 = r3 - 1;
        RelativeLayout.LayoutParams r5 = null;
        if ((r1.left - r0.left) > this.a.getPaint().measureText(StringsKt.replace$default(r2.substring(this.a.getLayout().getLineStart(r4), this.a.getLayout().getLineEnd(r4)), "<doc.at.~#_%=`>", "     ", false, 4, null))) goto L19;
        ViewGroup.LayoutParams r6 = this.b.getLayoutParams();
        if ((r6 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) r6;
    L12:
        if (r7 == null) goto L14;
        r7.addRule(3, this.a.getId());
    L14:
        ViewGroup.LayoutParams r8 = this.b.getLayoutParams();
        if ((r8 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        r5 = (RelativeLayout.LayoutParams) r8;
    L17:
        if (r5 == null) goto L24;
        r5.addRule(8, -1);
    L24:
        View r9 = this.b;
        r9.setLayoutParams(r9.getLayoutParams());
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L11:
        r7 = null;
        goto L12
    L19:
        ViewGroup.LayoutParams r10 = this.b.getLayoutParams();
        if ((r10 instanceof RelativeLayout.LayoutParams) == false) goto L22;
        r5 = (RelativeLayout.LayoutParams) r10;
    L22:
        if (r5 == null) goto L24;
        r5.addRule(3, -1);
        goto L24
    }

    public a(TextView r1, BearLottieView r2) {
        this.a = r1;
        this.b = r2;
    }
}
