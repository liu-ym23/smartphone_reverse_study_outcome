package com.ss.android.lark.widget.span;

import android.graphics.drawable.Drawable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class EmojiconInfo extends SpanInfo {
    public Drawable drawable;
    public int emojiSize;
    public String key;

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.key, this.drawable, Integer.valueOf(this.emojiSize)});
    }

    public EmojiconInfo() {
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmojiconInfo) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        EmojiconInfo r101 = (EmojiconInfo) r100;
        if (Objects.equals(this.key, r101.key) == true) goto L14;
    L18:
        return false;
    L14:
        if (Objects.equals(this.drawable, r101.drawable) == false) goto L18;
        if (Objects.equals(Integer.valueOf(this.emojiSize), Integer.valueOf(r101.emojiSize)) == false) goto L18;
        return true;
    }
}
