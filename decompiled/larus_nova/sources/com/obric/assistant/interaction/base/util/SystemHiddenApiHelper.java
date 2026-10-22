package com.obric.assistant.interaction.base.util;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/base/util/SystemHiddenApiHelper;", "", "<init>", "()V", "TAG", "", "performVibratorSmtFeedback", "", "effect", "Lcom/obric/assistant/interaction/base/feedback/VibratorSmtFeedbackEffect;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemHiddenApiHelper {
    public static final SystemHiddenApiHelper INSTANCE = null;
    private static final String TAG = "SystemHiddenApiHelper";

    static {
        INSTANCE = new SystemHiddenApiHelper();
    }

    private SystemHiddenApiHelper() {
    }

    public final void performVibratorSmtFeedback(VibratorSmtFeedbackEffect r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        FLogger r101 = FLogger.f375446a;
        r101.i(TAG, "performVibratorSmtFeedback " + r100);
        IVibratorSmtFeedback r102 = (IVibratorSmtFeedback) ServiceManager.get().getService(IVibratorSmtFeedback.class);
        if (r102 == null) goto L5;
        r102.perform(r100);
        return;
    L5:
        r101.w(TAG, "VibratorSmtFeedback service is unavailable");
    }
}
