package com.obric.assistant.interaction.impl;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/SystemStateHelper;", "", "<init>", "()V", "TAG", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "updateKeyguardState", "it", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemStateHelper {
    public static final SystemStateHelper INSTANCE = null;
    private static final String TAG = "SystemStateHelper";

    static {
        INSTANCE = new SystemStateHelper();
    }

    private SystemStateHelper() {
    }

    public static /* synthetic */ void a(boolean r100) {
        init$lambda$1$lambda$0(r100);
    }

    private static final void init$lambda$1$lambda$0(boolean r100) {
        INSTANCE.updateKeyguardState(r100);
    }

    private final void updateKeyguardState(boolean r100) {
        if (r100 == false) goto L4;
        InteractionEvent.InteractionKeyguardLockedEvent r101 = InteractionEvent.InteractionKeyguardLockedEvent.LockedEvent.INSTANCE;
    L5:
        FLogger.f375446a.i(TAG, "updateKeyguardState " + r100 + " state");
        IAssistantInteractionServiceKt.getInteractionStateApi().onKeyguardLockedStateEvent(r101);
        return;
    L4:
        r101 = InteractionEvent.InteractionKeyguardLockedEvent.UnlockedEvent.INSTANCE;
        goto L5
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("keyguard");
        if ((r101 instanceof KeyguardManager) == false) goto L5;
        KeyguardManager r102 = (KeyguardManager) r101;
    L7:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.SUBSCRIBE_TO_KEYGUARD_LOCKED_STATE") == 0) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L14;
        if (r102 == null) goto L15;
        INSTANCE.updateKeyguardState(IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        r102.addKeyguardLockedStateListener(r100.getMainExecutor(), new h0());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
