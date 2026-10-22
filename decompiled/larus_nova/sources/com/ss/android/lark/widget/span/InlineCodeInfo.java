package com.ss.android.lark.widget.span;

import android.text.Layout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006/"}, d2 = {"Lcom/ss/android/lark/widget/span/InlineCodeInfo;", "Lcom/ss/android/lark/widget/span/TextStyleInfo;", "<init>", "()V", "leftSpanStart", "", "getLeftSpanStart", "()I", "setLeftSpanStart", "(I)V", "leftSpanEnd", "getLeftSpanEnd", "setLeftSpanEnd", "centerSpanStart", "getCenterSpanStart", "setCenterSpanStart", "centerSpanEnd", "getCenterSpanEnd", "setCenterSpanEnd", "rightSpanStart", "getRightSpanStart", "setRightSpanStart", "rightSpanEnd", "getRightSpanEnd", "setRightSpanEnd", "useTextStyle", "", "getUseTextStyle", "()Z", "setUseTextStyle", "(Z)V", "alignment", "Landroid/text/Layout$Alignment;", "getAlignment", "()Landroid/text/Layout$Alignment;", "setAlignment", "(Landroid/text/Layout$Alignment;)V", "backgroundColorValue", "getBackgroundColorValue", "setBackgroundColorValue", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "isLeftSpanIndexValid", "isCenterSpanIndexValid", "isRightSpanIndexValid", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InlineCodeInfo extends TextStyleInfo {
    public static final a Companion = null;
    public static final String INLINE_CODE_EDGE_PLACEHOLDER = "`";
    private Layout.Alignment alignment;
    private int backgroundColor;
    private int backgroundColorValue;
    private int centerSpanEnd;
    private int centerSpanStart;
    private int leftSpanEnd;
    private int leftSpanStart;
    private int rightSpanEnd;
    private int rightSpanStart;
    private boolean useTextStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isCenterSpanIndexValid() {
        int r100 = this.centerSpanStart;
        if (r100 < 0) goto L8;
        int r101 = this.centerSpanEnd;
        if (r101 < 0) goto L8;
        if (r100 > r101) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isLeftSpanIndexValid() {
        int r100 = this.leftSpanStart;
        if (r100 < 0) goto L8;
        int r101 = this.leftSpanEnd;
        if (r101 < 0) goto L8;
        if (r100 > r101) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isRightSpanIndexValid() {
        int r100 = this.rightSpanStart;
        if (r100 < 0) goto L8;
        int r101 = this.rightSpanEnd;
        if (r101 < 0) goto L8;
        if (r100 > r101) goto L8;
        return true;
    L8:
        return false;
    }

    public InlineCodeInfo() {
        this.type = 18;
        this.text = INLINE_CODE_EDGE_PLACEHOLDER;
        this.leftSpanStart = -1;
        this.leftSpanEnd = -1;
        this.centerSpanStart = -1;
        this.centerSpanEnd = -1;
        this.rightSpanStart = -1;
        this.rightSpanEnd = -1;
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.backgroundColorValue = -1;
        this.backgroundColor = R.color.bg_body;
    }

    public final Layout.Alignment getAlignment() {
        return this.alignment;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundColorValue() {
        return this.backgroundColorValue;
    }

    public final int getCenterSpanEnd() {
        return this.centerSpanEnd;
    }

    public final int getCenterSpanStart() {
        return this.centerSpanStart;
    }

    public final int getLeftSpanEnd() {
        return this.leftSpanEnd;
    }

    public final int getLeftSpanStart() {
        return this.leftSpanStart;
    }

    public final int getRightSpanEnd() {
        return this.rightSpanEnd;
    }

    public final int getRightSpanStart() {
        return this.rightSpanStart;
    }

    public final boolean getUseTextStyle() {
        return this.useTextStyle;
    }

    public final void setAlignment(Layout.Alignment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignment = r100;
    }

    public final void setBackgroundColor(int r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundColorValue(int r100) {
        this.backgroundColorValue = r100;
    }

    public final void setCenterSpanEnd(int r100) {
        this.centerSpanEnd = r100;
    }

    public final void setCenterSpanStart(int r100) {
        this.centerSpanStart = r100;
    }

    public final void setLeftSpanEnd(int r100) {
        this.leftSpanEnd = r100;
    }

    public final void setLeftSpanStart(int r100) {
        this.leftSpanStart = r100;
    }

    public final void setRightSpanEnd(int r100) {
        this.rightSpanEnd = r100;
    }

    public final void setRightSpanStart(int r100) {
        this.rightSpanStart = r100;
    }

    public final void setUseTextStyle(boolean r100) {
        this.useTextStyle = r100;
    }
}
