package com.ss.android.lark.biz.im.api.extension.message.system;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    boolean a(ContentValue r100, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r101);

    String b(ContentValue r100, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r101);

    void c(SpannableStringBuilder r100, ContentValue r101, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r102);

    b d(a r100);

    SystemMessageActionType getType();
}
