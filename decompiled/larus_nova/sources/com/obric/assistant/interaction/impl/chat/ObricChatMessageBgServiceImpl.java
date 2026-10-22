package com.obric.assistant.interaction.impl.chat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.layout.item.i;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.chat.IObricChatMessageBgService;
import fea.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/chat/ObricChatMessageBgServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatMessageBgService;", "<init>", "()V", "configNestedFileViewBackground", "", "nestedFileView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatMessageBgServiceImpl implements IObricChatMessageBgService {
    public ObricChatMessageBgServiceImpl() {
    }

    public static /* synthetic */ void a(View r100) {
        configNestedFileViewBackground$lambda$0(r100);
    }

    private static final void configNestedFileViewBackground$lambda$0(View r100) {
        r100.setBackgroundResource(0);
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L23;
        if ((r102 instanceof i) == true) goto L9;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        r102 = (ViewGroup) r103;
        goto L6
    L5:
        r102 = null;
        goto L6
    L9:
        ((i) r102).setBackgroundResource(0);
        return;
    L23:
        return;
    L14:
        r102 = null;
        goto L6
    }

    @Override // com.obric.assistant.spi.chat.IObricChatMessageBgService
    public void configNestedFileViewBackground(final View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (IWindowContextKt.isWindowContext(r100.getContext()) == false) goto L8;
        r100.post(new a(r100));
        return;
    }
}
