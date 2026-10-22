package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f231520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f231521b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Rect r100 = new Rect();
        Rect r101 = new Rect();
        this.f231520a.getGlobalVisibleRect(r100);
        this.f231521b.getGlobalVisibleRect(r101);
        String r102 = this.f231520a.getText().toString();
        int r103 = this.f231520a.getLineCount();
        if (this.f231520a.getLayout() != null) goto L6;
        this.f231520a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L6:
        int r104 = r103 - 1;
        ConstraintLayout.LayoutParams r105 = null;
        if ((r101.left - r100.left) > this.f231520a.getPaint().measureText(StringsKt.replace$default(r102.substring(this.f231520a.getLayout().getLineStart(r104), this.f231520a.getLayout().getLineEnd(r104)), "<doc.at.~#_%=`>", "     ", false, 4, null))) goto L15;
        View r106 = this.f231521b;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r107;
    L12:
        if (r108 == null) goto L14;
        r108.topToBottom = R.id.tv_content_translate;
        r108.bottomToBottom = -1;
        r105 = r108;
    L14:
        r106.setLayoutParams(r105);
    L22:
        this.f231520a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L11:
        r108 = null;
        goto L12
    L15:
        View r109 = this.f231521b;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if ((r110 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
    L19:
        if (r111 == null) goto L21;
        r111.bottomToBottom = R.id.tv_content_translate;
        r111.topToBottom = -1;
        r105 = r111;
    L21:
        r109.setLayoutParams(r105);
        goto L22
    L18:
        r111 = null;
        goto L19
    }

    public p(TextView r100, View r101) {
        this.f231520a = r100;
        this.f231521b = r101;
    }
}
