package com.obric.sva.framework.wrapper;

import android.content.Context;
import android.os.Bundle;
import com.android.internal.app.AssistUtils;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class AssistUtilsWrapper {
    private final AssistUtils mAssistUtils;
    private IVoiceInteractionSessionListenerWrapper mListenerWrapper;

    public interface IVoiceInteractionSessionListenerWrapper {
        void onSetUiHints(Bundle r100);
    }

    public static class IVoiceInteractionSessionShowCallbackWrapper {
        public IVoiceInteractionSessionShowCallbackWrapper() {
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return IVoiceInteractionSessionShowCallback.class;
        }
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return AssistUtils.class;
    }

    public AssistUtilsWrapper(Context r100) {
        this.mAssistUtils = new AssistUtils(r100);
    }

    public static /* synthetic */ IVoiceInteractionSessionListenerWrapper access$000(AssistUtilsWrapper r100) {
        return r100.mListenerWrapper;
    }

    public void registerSessionListener(IVoiceInteractionSessionListenerWrapper r100) {
        this.mListenerWrapper = r100;
        this.mAssistUtils.registerVoiceInteractionSessionListener(new AnonymousClass1(this));
    }

    public boolean showSessionForActiveService(Bundle r100, int r101) {
        AssistUtils r102 = this.mAssistUtils;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.showSessionForActiveService(r100, r101, null, null);
    }
}
