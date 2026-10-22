package ug8;

import com.larus.bmhome.chat.list.cell.text.components.middle.h0;
import com.larus.bmhome.chat.list.cell.text.interceptor.InterceptedMessageException;
import com.larus.bmhome.chat.list.cell.text.interceptor.MarkdownRenderException;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes25.dex */
public interface b {
    h0 a(h0 r100) throws InterceptedMessageException, MarkdownRenderException;

    Message b(Message r100) throws InterceptedMessageException, MarkdownRenderException;
}
