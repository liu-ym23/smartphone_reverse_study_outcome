package com.ss.android.lark.widget.richtext.deprecated.entity;

import android.text.SpannableStringBuilder;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class DetailCodeBlockParseResult extends AbstractParseResult {
    private static final long serialVersionUID = 8493577701247584362L;
    private SpannableStringBuilder mSpanBuilder;

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public boolean canPartialUpdate(AbstractParseResult r100) {
        return false;
    }

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public int getHashCode() {
        return Objects.hash(new Object[]{this.mSpanBuilder});
    }

    public DetailCodeBlockParseResult() {
    }

    public SpannableStringBuilder getSpanBuilder() {
        return this.mSpanBuilder;
    }

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public boolean isEquals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DetailCodeBlockParseResult) == true) goto L8;
        return false;
    L8:
        return Objects.equals(this.mSpanBuilder, ((DetailCodeBlockParseResult) r100).getSpanBuilder());
    }

    public void setSpanBuilder(SpannableStringBuilder r100) {
        this.mSpanBuilder = r100;
    }
}
