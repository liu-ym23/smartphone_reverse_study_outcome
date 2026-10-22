package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$ListMenuDecorView extends ContentFrameLayout {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchKeyEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 0) goto L9;
        if (isOutOfBounds((int) r3.getX(), (int) r3.getY()) == false) goto L9;
        this.this$0.closePanel(0);
        return true;
    L9:
        return super.onInterceptTouchEvent(r3);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public AppCompatDelegateImpl$ListMenuDecorView(AppCompatDelegateImpl r1, Context r2) {
        this.this$0 = r1;
        super(r2);
    }

    private boolean isOutOfBounds(int r2, int r3) {
        if (r2 < (-5)) goto L11;
        if (r3 < (-5)) goto L11;
        if (r2 > (getWidth() + 5)) goto L11;
        if (r3 > (getHeight() + 5)) goto L11;
        return false;
    L11:
        return true;
    }
}
