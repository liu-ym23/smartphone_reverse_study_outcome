package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS = null;
    private final AppCompatTextHelper mTextHelper;

    static {
        TINT_ATTRS = new int[]{R.attr.checkMark};
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.applyCompoundDrawablesTints();
        return;
    }

    public AppCompatCheckedTextView(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r2), r2, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int r2) {
        setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r1));
    }

    public AppCompatCheckedTextView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r2, int r3) {
        super.setTextAppearance(r2, r3);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetTextAppearance(r2, r3);
        return;
    }

    public AppCompatCheckedTextView(Context r3, AttributeSet r4, int r5) {
        super(TintContextWrapper.wrap(r3), r4, r5);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatTextHelper r6 = new AppCompatTextHelper(this);
        this.mTextHelper = r6;
        this.mTextHelper.loadFromAttributes(r4, r5);
        r6.applyCompoundDrawablesTints();
        TintTypedArray r7 = TintTypedArray.obtainStyledAttributes(getContext(), r4, TINT_ATTRS, r5, 0);
        setCheckMarkDrawable(r7.getDrawable(0));
        r7.recycle();
    }
}
