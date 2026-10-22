package com.obric.assistant.spi.window;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/window/DefaultChatWindowServiceImpl;", "Lcom/obric/assistant/spi/window/IChatWindowService;", "<init>", "()V", "isWindowContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "stashWindow", "", "popWindow", "isChatWindowShowing", "isChatWindowStashed", "isWindowHelperActivity", "activity", "Landroid/app/Activity;", PushClientConstants.TAG_CLASS_NAME, "", "getChatFragment", "Landroidx/fragment/app/Fragment;", "registerWindowMaterials", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultChatWindowServiceImpl implements IChatWindowService {
    public DefaultChatWindowServiceImpl() {
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final Fragment a(Activity r100) {
        return null;
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return false;
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean d(Context r100) {
        return false;
    }

    @Override // com.obric.assistant.spi.window.IChatWindowService
    public final boolean e() {
        return false;
    }
}
