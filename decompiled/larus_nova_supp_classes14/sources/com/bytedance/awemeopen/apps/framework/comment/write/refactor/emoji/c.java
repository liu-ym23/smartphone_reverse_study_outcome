package com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji;

import android.text.Editable;
import android.view.KeyEvent;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e {
    public final /* synthetic */ EmojiGifPresenter a;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final String c() {
        CommentMentionEditText r0 = (CommentMentionEditText) this.a.h.getValue();
        if (r0 == null) goto L5;
        Editable r1 = r0.getText();
    L7:
        return String.valueOf(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final void d() {
        ez3.e r0 = this.a.E();
        if (r0 == null) goto L6;
        r0.v("emoji_panel_send_btn");
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final void e() {
        vy3.a r0 = this.a.k;
        if (r0 == null) goto L6;
        KeyEvent r1 = new KeyEvent(0, 67);
        r0.c.sendKeyEvent(r1);
        return;
    }

    public c(EmojiGifPresenter r1) {
        this.a = r1;
    }
}
