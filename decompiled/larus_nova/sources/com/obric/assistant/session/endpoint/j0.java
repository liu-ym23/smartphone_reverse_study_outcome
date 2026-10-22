package com.obric.assistant.session.endpoint;

/* JADX INFO: loaded from: classes33.dex */
public final class j0 {
    public static final AiKeyActivationStartResult a(boolean r100) {
        if (r100 == true) goto L5;
        return AiKeyActivationStartResult.FAILED;
    L5:
        return AiKeyActivationStartResult.DEFERRED;
    }
}
