package com.larus.bmhome.chat.detail;

import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.trace.CopyContentTypeString;

/* JADX INFO: loaded from: classes25.dex */
public interface i {
    String c();

    void d(by7.e r100, BotModel r101, String r102, long r103, CustomMarkdownTextView r104, String r105, int r106, boolean r107, @CopyContentTypeString String r110, AbstractCommonDetailFragment.c r111);

    void e(String r100);

    void j(Message r100);

    void setConversationId(String r100);

    void v();
}
