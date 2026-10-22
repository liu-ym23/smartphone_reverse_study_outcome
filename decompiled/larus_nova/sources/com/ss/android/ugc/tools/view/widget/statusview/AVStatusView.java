package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class AVStatusView extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f455182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455183b;

    public AVStatusView(Context r100) {
        this(r100, null);
    }

    public void setStatus(int r100) {
        int r101 = this.f455183b;
        if (r101 != r100) goto L5;
        return;
    L5:
        View r102 = null;
        if (r101 < 0) goto L15;
        if (r101 >= 0) goto L9;
    L12:
        View r103 = null;
    L13:
        if (r103 == null) goto L15;
        r103.setVisibility(4);
        goto L15
    L9:
        if (r101 >= ((ArrayList) this.f455182a).size()) goto L12;
        r103 = (View) ListProtector.get(this.f455182a, r101);
    L15:
        if (r100 < 0) goto L24;
        setVisibility(0);
        if (r100 >= 0) goto L19;
    L22:
        if (r102 == null) goto L25;
        r102.setVisibility(0);
    L25:
        this.f455183b = r100;
        return;
    L19:
        if (r100 >= ((ArrayList) this.f455182a).size()) goto L22;
        r102 = (View) ListProtector.get(this.f455182a, r100);
        goto L22
    L24:
        setVisibility(4);
        goto L25
    }

    @Override // com.ss.android.ugc.tools.view.widget.statusview.c
    public void setUseScreenHeight(int r100) {
        KeyEvent.Callback r101 = (View) ListProtector.get(this.f455182a, 0);
        if ((r101 instanceof c) == false) goto L5;
        ((c) r101).setUseScreenHeight(r100);
    L5:
        KeyEvent.Callback r102 = (View) ListProtector.get(this.f455182a, 1);
        if ((r102 instanceof c) == false) goto L8;
        ((c) r102).setUseScreenHeight(r100);
    L8:
        KeyEvent.Callback r103 = (View) ListProtector.get(this.f455182a, 2);
        if ((r103 instanceof c) == false) goto L11;
        ((c) r103).setUseScreenHeight(r100);
    L11:
        KeyEvent.Callback r104 = (View) ListProtector.get(this.f455182a, 3);
        if ((r104 instanceof c) == false) goto L14;
        ((c) r104).setUseScreenHeight(r100);
    L14:
        KeyEvent.Callback r105 = (View) ListProtector.get(this.f455182a, 4);
        if ((r105 instanceof c) == false) goto L18;
        ((c) r105).setUseScreenHeight(r100);
        return;
    }

    public AVStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AVStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455182a = new ArrayList(5);
        this.f455183b = -1;
    }
}
