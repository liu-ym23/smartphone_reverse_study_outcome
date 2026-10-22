package com.obric.assistant.chat;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0097\u0001J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0097\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0097\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatContextServiceDelegate;", "Lcom/obric/assistant/chat/IObricChatContextService;", "<init>", "()V", "findChatHost", "Landroidx/fragment/app/FragmentActivity;", "getChatContext", "Lcom/larus/ui/arch/context/external/VContext;", "activity", "Landroid/app/Activity;", "getCurrentChatContext", "isChatActivity", "", "isChatHost", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatContextServiceDelegate implements IObricChatContextService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricChatContextServiceDelegate f386558b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricChatContextService f386559a;

    static {
        f386558b = new ObricChatContextServiceDelegate();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b a() {
        return this.f386559a.a();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b b(Activity r100) {
        return this.f386559a.b(r100);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean c(Activity r100) {
        return this.f386559a.c(r100);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final FragmentActivity d() {
        return this.f386559a.d();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean e(Activity r100) {
        return this.f386559a.e(r100);
    }

    private ObricChatContextServiceDelegate() {
        this.f386559a = (IObricChatContextService) ServiceManager.get().getService(IObricChatContextService.class);
    }
}
