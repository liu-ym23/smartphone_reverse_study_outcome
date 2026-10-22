package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.bytedance.dux.utils.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes19.dex */
public class DmtButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EmojiTextViewHelper f248389a;

    private EmojiTextViewHelper getEmojiViewHelper() {
        if (this.f248389a != null) goto L6;
        this.f248389a = new EmojiTextViewHelper(this);
    L6:
        return this.f248389a;
    }

    public DmtButton(Context r100) {
        this(r100, null);
    }

    public void setEnableParseEmoji(boolean r100) {
        getEmojiViewHelper().c(r100);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r100) {
        InputFilter[] r101 = getEmojiViewHelper().b(r100);
        if (r101 != null) goto L5;
    L8:
        super.setFilters(r100);
        return;
    L5:
        if (r101.length == 0) goto L8;
        super.setFilters(r101);
    }

    public void setFontType(String r100) {
        com.bytedance.dux.text.a r101 = com.bytedance.dux.text.a.b();
        monitor-enter(r101);
        monitor-exit(r101);
    }

    public DmtButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        com.bytedance.dux.text.a.b().a(this, r101);
    }

    public DmtButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        com.bytedance.dux.text.a.b().a(this, r101);
    }
}
