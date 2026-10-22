package com.obric.assistant.spi.markdown;

import android.view.View;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/spi/markdown/IObricMarkdownResolverService;", "", JSEventListener.ACTION_RESOLVE, "", "view", "Landroid/view/View;", "link", "", "enableLinkStyle", "chatMessage", "Lcom/larus/im/bean/message/Message;", "needUnderline", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricMarkdownResolverService {
    boolean a(String r100);

    boolean b(String r100);

    boolean c(View r100, String r101, boolean r102, Message r103);
}
