package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public SnackbarContentLayout(Context r100) {
        this(r100, null);
    }

    public SnackbarContentLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.maxWidth, R.attr.elevation, R.attr.maxActionInlineWidth});
        this.maxWidth = r102.getDimensionPixelSize(0, -1);
        this.maxInlineActionWidth = r102.getDimensionPixelSize(2, -1);
        r102.recycle();
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int r100, int r101) {
        this.messageView.setAlpha(0.0f);
        long r102 = r101;
        long r103 = r100;
        this.messageView.animate().alpha(1.0f).setDuration(r102).setStartDelay(r103).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(r102).setStartDelay(r103).start();
        return;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int r100, int r101) {
        this.messageView.setAlpha(1.0f);
        long r102 = r101;
        long r103 = r100;
        this.messageView.animate().alpha(0.0f).setDuration(r102).setStartDelay(r103).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(r102).setStartDelay(r103).start();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.maxWidth <= 0) goto L7;
        int r102 = getMeasuredWidth();
        int r103 = this.maxWidth;
        if (r102 <= r103) goto L7;
        r100 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        super.onMeasure(r100, r101);
    L7:
        int r104 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r105 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean r106 = false;
        if (this.messageView.getLayout().getLineCount() <= 1) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L13;
    L19:
        if (r107 == true) goto L23;
        r104 = r105;
    L23:
        if (updateViewsWithinLayout(0, r104, r104) == false) goto L25;
    L24:
        r106 = true;
    L25:
        if (r106 == false) goto L28;
        super.onMeasure(r100, r101);
        return;
    L28:
        return;
    L13:
        if (this.maxInlineActionWidth <= 0) goto L19;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L19;
        if (updateViewsWithinLayout(1, r104, r104 - r105) == false) goto L25;
    L10:
        r107 = false;
        goto L11
    }

    private static void updateTopBottomPadding(View r100, int r101, int r102) {
        if (ViewCompat.isPaddingRelative(r100) == false) goto L5;
        ViewCompat.setPaddingRelative(r100, ViewCompat.getPaddingStart(r100), r101, ViewCompat.getPaddingEnd(r100), r102);
        return;
    L5:
        r100.setPadding(r100.getPaddingLeft(), r101, r100.getPaddingRight(), r102);
    }

    private boolean updateViewsWithinLayout(int r100, int r101, int r102) {
        if (r100 == getOrientation()) goto L5;
        setOrientation(r100);
        boolean r103 = true;
    L7:
        if (this.messageView.getPaddingTop() == r101) goto L9;
    L12:
        updateTopBottomPadding(this.messageView, r101, r102);
        return true;
    L9:
        if (this.messageView.getPaddingBottom() != r102) goto L12;
        return r103;
    L5:
        r103 = false;
        goto L7
    }
}
