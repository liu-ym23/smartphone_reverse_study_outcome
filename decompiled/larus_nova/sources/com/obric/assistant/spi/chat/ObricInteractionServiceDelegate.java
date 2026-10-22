package com.obric.assistant.spi.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.obric.ObricChatActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import jga.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/chat/ObricInteractionServiceDelegate;", "Lcom/obric/assistant/spi/chat/IObricInteractionService;", "<init>", "()V", "adaptSlideBarFragmentArguments", "Landroid/os/Bundle;", "page", "", "arguments", "getOChatContainer", "", "getOrionChatExtensionUtilsCallback", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "activity", "Landroidx/fragment/app/FragmentActivity;", "prepareSideBarMainChatForActivation", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionServiceDelegate implements IObricInteractionService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricInteractionServiceDelegate f392860b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricInteractionService f392861a;

    static {
        f392860b = new ObricInteractionServiceDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final String a() {
        return this.f392861a.a();
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final void b(FragmentActivity r100) {
        this.f392861a.b(r100);
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final Bundle c(int r100, Bundle r101) {
        return this.f392861a.c(r100, r101);
    }

    @Override // com.obric.assistant.spi.chat.IObricInteractionService
    public final a d(ObricChatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f392861a.d(r100);
    }

    private ObricInteractionServiceDelegate() {
        IObricInteractionService r100 = (IObricInteractionService) ServiceManager.get().getService(IObricInteractionService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricInteractionServiceImpl();
    L5:
        this.f392861a = r100;
    }
}
