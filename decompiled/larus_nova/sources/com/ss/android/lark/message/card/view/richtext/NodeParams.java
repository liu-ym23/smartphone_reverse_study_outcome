package com.ss.android.lark.message.card.view.richtext;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public class NodeParams implements Serializable {
    private static final long serialVersionUID = 3325780907521169105L;
    public int cardVersion;
    public int mBgColor;
    public List<NodeParams> mChildParams;
    public float mDefaultTextSize;
    public Map<String, String> mExtraProperties;
    public int mFontStyleAndWeight;
    public NodeParams mParents;
    public RichTextElement.RichTextProperty mRichTextProperty;
    public RichTextElement.RichTextTag mRichTextTag;
    public transient CharSequence mSpannableString;
    public List<String> mStyleKeys;
    public int mTextColor;
    public float mTextSize;
    public YogaProperty mYogaProperty;

    public int hashCode() {
        YogaProperty r100 = this.mYogaProperty;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RichTextElement.RichTextTag r104 = this.mRichTextTag;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RichTextElement.RichTextProperty r107 = this.mRichTextProperty;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        NodeParams r110 = this.mParents;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<NodeParams> r113 = this.mChildParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((((((r112 + r114) * 31) + this.mBgColor) * 31) + this.mTextColor) * 31) + this.mFontStyleAndWeight) * 31;
        float r116 = this.mTextSize;
        if (r116 == 0.0f) goto L26;
        r101 = Float.floatToIntBits(r116);
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public NodeParams(int r100) {
        this.mYogaProperty = new YogaProperty();
        this.mChildParams = new ArrayList();
        this.mFontStyleAndWeight = 0;
        this.mTextSize = -1.0f;
        this.mDefaultTextSize = -1.0f;
        this.mStyleKeys = new ArrayList();
        this.cardVersion = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L58:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L58;
        NodeParams r101 = (NodeParams) r100;
        if (this.mBgColor == r101.mBgColor) goto L14;
        return false;
    L14:
        if (this.mTextColor == r101.mTextColor) goto L17;
        return false;
    L17:
        if (this.mFontStyleAndWeight == r101.mFontStyleAndWeight) goto L20;
        return false;
    L20:
        if (Float.compare(r101.mTextSize, this.mTextSize) == 0) goto L22;
        return false;
    L22:
        YogaProperty r102 = this.mYogaProperty;
        if (r102 == null) goto L28;
        if (r102.equals(r101.mYogaProperty) == true) goto L31;
    L29:
        return false;
    L31:
        if (this.mRichTextTag == r101.mRichTextTag) goto L33;
        return false;
    L33:
        RichTextElement.RichTextProperty r103 = this.mRichTextProperty;
        if (r103 == null) goto L39;
        if (r103.equals(r101.mRichTextProperty) == false) goto L40;
    L41:
        NodeParams r104 = this.mParents;
        if (r104 == null) goto L47;
        if (r104.equals(r101.mParents) == false) goto L48;
    L49:
        List<NodeParams> r105 = this.mChildParams;
        if (r105 == null) goto L55;
        if (r105.hashCode() != r101.mChildParams.hashCode()) goto L56;
    L57:
        return true;
    L56:
        return false;
    L55:
        if (r101.mChildParams == null) goto L57;
    L48:
        return false;
    L47:
        if (r101.mParents == null) goto L49;
    L40:
        return false;
    L39:
        if (r101.mRichTextProperty == null) goto L41;
    L28:
        if (r101.mYogaProperty == null) goto L31;
        goto L29
    }
}
