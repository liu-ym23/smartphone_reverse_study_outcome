package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.chatbase.view.TextChatView2;

/* JADX INFO: loaded from: classes35.dex */
public class TextMessageViewHolder_ViewBinding implements Unbinder {
    @Override // butterknife.Unbinder
    public final void unbind() {
        throw new IllegalStateException("Bindings already cleared.");
    }

    public TextMessageViewHolder_ViewBinding(TextMessageViewHolder r100, View r101) {
        TextChatView2 r102 = (TextChatView2) Utils.findRequiredViewAsType(r101, R.id.text_content, "field 'mMessageTextView'", TextChatView2.class);
        throw null;
    }
}
