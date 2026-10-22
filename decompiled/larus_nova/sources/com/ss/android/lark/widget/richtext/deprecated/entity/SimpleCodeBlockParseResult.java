package com.ss.android.lark.widget.richtext.deprecated.entity;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class SimpleCodeBlockParseResult extends AbstractParseResult {
    private static final long serialVersionUID = 8493577701247584362L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient SpannableStringBuilder f448306a;
    private RichTextElement.CodeBlockProperty mProperty;

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public int getHashCode() {
        return Objects.hash(new Object[]{this.mProperty, this.f448306a});
    }

    public SimpleCodeBlockParseResult() {
    }

    public RichTextElement.CodeBlockProperty getProperty() {
        return this.mProperty;
    }

    public SpannableStringBuilder getSpanBuilder() {
        return this.f448306a;
    }

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public boolean canPartialUpdate(AbstractParseResult r100) {
        return isEquals(r100);
    }

    @Override // com.ss.android.lark.widget.richtext.deprecated.entity.AbstractParseResult
    public boolean isEquals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SimpleCodeBlockParseResult) == false) goto L14;
        SimpleCodeBlockParseResult r101 = (SimpleCodeBlockParseResult) r100;
        if (Objects.equals(this.mProperty, r101.getProperty()) == true) goto L10;
    L12:
        return false;
    L10:
        if (Objects.equals(this.f448306a, r101.getSpanBuilder()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public void setProperty(RichTextElement.CodeBlockProperty r100) {
        this.mProperty = r100;
    }

    public void setSpanBuilder(SpannableStringBuilder r100) {
        this.f448306a = r100;
    }
}
