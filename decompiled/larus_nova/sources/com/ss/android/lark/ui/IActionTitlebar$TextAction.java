package com.ss.android.lark.ui;

/* JADX INFO: loaded from: classes38.dex */
public class IActionTitlebar$TextAction extends IActionTitlebar$BaseAction {
    private int mColor;
    private a mOnTextChangeListener;
    private b mOnTextColorChangedListener;
    private String mText;
    private int mTextSize;

    public interface a {
    }

    public interface b {
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public String getText() {
        return this.mText;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public IActionTitlebar$TextAction(String r100) {
        this.mColor = -1;
        this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
        this.mText = r100;
    }

    public void setOnTextChangedListener(a r100) {
        this.mOnTextChangeListener = r100;
    }

    public void setOnTextColorChangedListener(b r100) {
        this.mOnTextColorChangedListener = r100;
    }

    public void updateText(String r100) {
        this.mText = r100;
        a r101 = this.mOnTextChangeListener;
        if (r101 == null) goto L9;
        com.ss.android.lark.ui.a.b r102 = (com.ss.android.lark.ui.a.b) r101;
        if (r100 == null) goto L7;
        r102.f444570a.setText(r100);
        return;
    L7:
        r102.getClass();
        return;
    }

    public void updateTextColor(int r100) {
        this.mColor = r100;
        b r101 = this.mOnTextColorChangedListener;
        if (r101 == null) goto L9;
        com.ss.android.lark.ui.a.C5370a r102 = (com.ss.android.lark.ui.a.C5370a) r101;
        if (r100 == 0) goto L7;
        r102.f444569a.setTextColor(r100);
        return;
    L7:
        r102.getClass();
        return;
    }

    public IActionTitlebar$TextAction(String r100, int r101) {
        this.mColor = -1;
        this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
        this.mText = r100;
        this.mColor = r101;
    }

    public IActionTitlebar$TextAction(String r100, int r101, int r102) {
        this.mColor = -1;
        int r103 = CommonTitleBarConstants.DEFAULT_LEFT_TEXT_SIZE;
        this.mText = r100;
        this.mColor = r101;
        this.mTextSize = r102;
    }
}
