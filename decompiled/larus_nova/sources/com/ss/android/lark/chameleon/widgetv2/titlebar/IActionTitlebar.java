package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public interface IActionTitlebar {

    public interface Action {
        int getBackground();

        int getDrawableRes();

        Object getTag();

        String getText();

        void performAction(View r100);

        Action setTag(Object r100);
    }

    public static class BaseAction implements Action {
        private Object mTag;

        public BaseAction() {
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getBackground() {
            return 0;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getDrawableRes() {
            return 0;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public String getText() {
            return null;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public void performAction(View r100) {
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public Object getTag() {
            return this.mTag;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public Action setTag(Object r100) {
            this.mTag = r100;
            return this;
        }
    }

    public static class ImageAction extends BaseAction {
        private Drawable mDrawable;
        private int mDrawableRes;
        private OnDrawableUpdateListener mOnDrawableUpdateListener;
        private int mTintRes;

        public interface OnDrawableUpdateListener {
            void onDrawableResUpdated(int r100);

            void onDrawableUpdated(Drawable r100);
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.BaseAction, com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getDrawableRes() {
            return this.mDrawableRes;
        }

        public int getTintRes() {
            return this.mTintRes;
        }

        public ImageAction(Drawable r100) {
            this.mDrawable = r100;
        }

        public void setOnDrawableUpdateListener(OnDrawableUpdateListener r100) {
            this.mOnDrawableUpdateListener = r100;
        }

        public void updateDrawable(Drawable r100) {
            this.mDrawableRes = 0;
            this.mDrawable = r100;
            OnDrawableUpdateListener r101 = this.mOnDrawableUpdateListener;
            if (r101 == null) goto L6;
            r101.onDrawableUpdated(r100);
            return;
        }

        public void updateDrawableResource(int r100) {
            this.mDrawableRes = r100;
            this.mDrawable = null;
            OnDrawableUpdateListener r101 = this.mOnDrawableUpdateListener;
            if (r101 == null) goto L6;
            r101.onDrawableResUpdated(r100);
            return;
        }

        public ImageAction(int r100) {
            this(r100, 0);
        }

        public ImageAction(int r100, int r101) {
            this.mDrawableRes = r100;
            this.mTintRes = r101;
        }
    }

    public static class TextAction extends BaseAction {
        private int mColor;
        private OnTextChangeListener mOnTextChangeListener;
        private OnTextColorChangedListener mOnTextColorChangedListener;
        private String mText;
        private int mTextSize;

        public interface OnTextChangeListener {
            void onTextChange(String r100);
        }

        public interface OnTextColorChangedListener {
            void onTextColorChange(int r100);
        }

        public int getColor() {
            return this.mColor;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.BaseAction, com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public String getText() {
            return this.mText;
        }

        public int getTextSize() {
            return this.mTextSize;
        }

        public TextAction(String r100) {
            this.mColor = -1;
            this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
            this.mText = r100;
        }

        public void setOnTextChangedListener(OnTextChangeListener r100) {
            this.mOnTextChangeListener = r100;
        }

        public void setOnTextColorChangedListener(OnTextColorChangedListener r100) {
            this.mOnTextColorChangedListener = r100;
        }

        public void updateText(String r100) {
            this.mText = r100;
            OnTextChangeListener r101 = this.mOnTextChangeListener;
            if (r101 == null) goto L6;
            r101.onTextChange(r100);
            return;
        }

        public void updateTextColor(int r100) {
            this.mColor = r100;
            OnTextColorChangedListener r101 = this.mOnTextColorChangedListener;
            if (r101 == null) goto L6;
            r101.onTextColorChange(r100);
            return;
        }

        public TextAction(String r100, int r101) {
            this.mColor = -1;
            this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
            this.mText = r100;
            this.mColor = r101;
        }

        public TextAction(String r100, int r101, int r102) {
            this.mColor = -1;
            int r103 = CommonTitleBarConstants.DEFAULT_LEFT_TEXT_SIZE;
            this.mText = r100;
            this.mColor = r101;
            this.mTextSize = r102;
        }
    }

    public static class ViewAction extends BaseAction {
        private final View mView;

        public View getView() {
            return this.mView;
        }

        public ViewAction(View r100) {
            this.mView = r100;
        }
    }

    View addAction(Action r100);

    void removeAllActions();

    void setTitle(CharSequence r100);
}
