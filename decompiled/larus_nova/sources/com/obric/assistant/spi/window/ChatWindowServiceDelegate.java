package com.obric.assistant.spi.window;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/window/ChatWindowServiceDelegate;", "Lcom/obric/assistant/spi/window/IChatWindowService;", "<init>", "()V", "getChatFragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroid/app/Activity;", "isChatWindowShowing", "", "isChatWindowStashed", "isWindowContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isWindowHelperActivity", PushClientConstants.TAG_CLASS_NAME, "", "popWindow", "", "registerWindowMaterials", "stashWindow", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowServiceDelegate implements IChatWindowService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChatWindowServiceDelegate f392926b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IChatWindowService f392927a;

    static {
        f392926b = new ChatWindowServiceDelegate();
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final Fragment a(Activity r100) {
        return this.f392927a.a(r100);
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final void b() {
        this.f392927a.b();
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f392927a.c(r100);
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean d(Context r100) {
        return this.f392927a.d(r100);
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean e() {
        return this.f392927a.e();
    }

    private ChatWindowServiceDelegate() {
        IChatWindowService r100 = (IChatWindowService) ServiceManager.get().getService(IChatWindowService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultChatWindowServiceImpl();
    L5:
        this.f392927a = r100;
    }
}
