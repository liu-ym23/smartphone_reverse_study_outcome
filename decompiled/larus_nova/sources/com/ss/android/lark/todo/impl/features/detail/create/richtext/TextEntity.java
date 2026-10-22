package com.ss.android.lark.todo.impl.features.detail.create.richtext;

import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/TextEntity;", "Ljava/io/Serializable;", "text", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setText", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextEntity implements Serializable {
    private RichText text;

    public static /* synthetic */ TextEntity copy$default(TextEntity r100, RichText r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        return r100.copy(r101);
    }

    public final RichText component1() {
        return this.text;
    }

    public final TextEntity copy(RichText r100) {
        return new TextEntity(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextEntity) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.text, ((TextEntity) r100).text) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        RichText r100 = this.text;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TextEntity(text=" + this.text + ')';
    }

    public final RichText getText() {
        return this.text;
    }

    public TextEntity(RichText r100) {
        this.text = r100;
    }

    public final void setText(RichText r100) {
        this.text = r100;
    }
}
