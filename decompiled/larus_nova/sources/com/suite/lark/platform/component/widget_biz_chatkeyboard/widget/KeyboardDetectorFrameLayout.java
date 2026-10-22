package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.KeyboardUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class KeyboardDetectorFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f460813a;

    public interface a {
        void a();

        void b();
    }

    public KeyboardDetectorFrameLayout(Context r100) {
        this(r100, null);
    }

    public KeyboardDetectorFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = getHeight() - r102;
        if (r103 <= 400) goto L9;
        KeyboardUtils.setKeyboardHeight(r103);
        Iterator r104 = ((ArrayList) this.f460813a).iterator();
    L6:
        if (r104.hasNext() == false) goto L14;
        ((a) r104.next()).a();
    L14:
        super.onMeasure(r100, r101);
        return;
    L9:
        if (r103 >= (-400)) goto L14;
        Iterator r105 = ((ArrayList) this.f460813a).iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        ((a) r105.next()).b();
        goto L12
    }

    public KeyboardDetectorFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f460813a = new ArrayList(2);
    }
}
