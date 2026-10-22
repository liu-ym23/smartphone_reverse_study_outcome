package eg5;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f472608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f472609b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Rect r100 = new Rect();
        Rect r101 = new Rect();
        this.f472608a.getGlobalVisibleRect(r100);
        this.f472609b.getGlobalVisibleRect(r101);
        String r102 = this.f472608a.getText().toString();
        int r103 = this.f472608a.getLineCount();
        if (this.f472608a.getLayout() != null) goto L6;
        this.f472608a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L6:
        int r104 = r103 - 1;
        RelativeLayout.LayoutParams r105 = null;
        if ((r101.left - r100.left) > this.f472608a.getPaint().measureText(StringsKt.replace$default(r102.substring(this.f472608a.getLayout().getLineStart(r104), this.f472608a.getLayout().getLineEnd(r104)), "<doc.at.~#_%=`>", "     ", false, 4, null))) goto L19;
        ViewGroup.LayoutParams r106 = this.f472609b.getLayoutParams();
        if ((r106 instanceof RelativeLayout.LayoutParams) == false) goto L11;
        RelativeLayout.LayoutParams r107 = (RelativeLayout.LayoutParams) r106;
    L12:
        if (r107 == null) goto L14;
        r107.addRule(3, this.f472608a.getId());
    L14:
        ViewGroup.LayoutParams r108 = this.f472609b.getLayoutParams();
        if ((r108 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        r105 = (RelativeLayout.LayoutParams) r108;
    L17:
        if (r105 == null) goto L24;
        r105.addRule(8, -1);
    L24:
        View r109 = this.f472609b;
        r109.setLayoutParams(r109.getLayoutParams());
        this.f472608a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L11:
        r107 = null;
        goto L12
    L19:
        ViewGroup.LayoutParams r110 = this.f472609b.getLayoutParams();
        if ((r110 instanceof RelativeLayout.LayoutParams) == false) goto L22;
        r105 = (RelativeLayout.LayoutParams) r110;
    L22:
        if (r105 == null) goto L24;
        r105.addRule(3, -1);
        goto L24
    }

    public a(TextView r100, BearLottieView r101) {
        this.f472608a = r100;
        this.f472609b = r101;
    }
}
