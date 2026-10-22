package com.obric.assistant.spi.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.obric.ObricChatActivity;
import jga.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/spi/chat/DefaultObricInteractionServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricInteractionService;", "<init>", "()V", "getOChatContainer", "", "getOrionChatExtensionUtilsCallback", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "activity", "Landroidx/fragment/app/FragmentActivity;", "prepareSideBarMainChatForActivation", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricInteractionServiceImpl implements IObricInteractionService {
    public DefaultObricInteractionServiceImpl() {
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final String a() {
        return "";
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final void b(FragmentActivity r100) {
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final Bundle c(int r100, Bundle r101) {
        return r101;
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final a d(ObricChatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return null;
    }
}
