package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes19.dex */
public class FullscreenVideoFrame extends FrameLayout {

    public interface a {
    }

    public void setListener(a r100) {
    }

    public FullscreenVideoFrame(Context r100) {
        super(r100);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public FullscreenVideoFrame(Context r100, AttributeSet r101) {
        super(r100, r101);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L7;
        return true;
    L7:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        if (r100 != 4) goto L7;
        return true;
    L7:
        return super.onKeyUp(r100, r101);
    }

    public FullscreenVideoFrame(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
