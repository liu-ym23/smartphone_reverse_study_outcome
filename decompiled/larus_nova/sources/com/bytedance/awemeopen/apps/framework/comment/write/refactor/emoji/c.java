package com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji;

import android.text.Editable;
import android.view.KeyEvent;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiGifPresenter f194531a;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final String c() {
        CommentMentionEditText r100 = (CommentMentionEditText) this.f194531a.f194515h.getValue();
        if (r100 == null) goto L5;
        Editable r101 = r100.getText();
    L7:
        return String.valueOf(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final void d() {
        ez3.e r100 = this.f194531a.E();
        if (r100 == null) goto L6;
        r100.v("emoji_panel_send_btn");
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.e
    public final void e() {
        vy3.a r100 = this.f194531a.f194518k;
        if (r100 == null) goto L6;
        KeyEvent r101 = new KeyEvent(0, 67);
        r100.f557610c.sendKeyEvent(r101);
        return;
    }

    public c(EmojiGifPresenter r100) {
        this.f194531a = r100;
    }
}
