package com.obric.assistant.feedback;

import com.larus.utils.logger.FLogger;
import com.miui.bugreport.logprovider.DumpLogProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/feedback/ObricSystemFeedbackImpl;", "Lcom/obric/assistant/feedback/IObricSystemFeedback;", "<init>", "()V", "TAG", "", "listener", "com/obric/assistant/feedback/ObricSystemFeedbackImpl$listener$1", "Lcom/obric/assistant/feedback/ObricSystemFeedbackImpl$listener$1;", "init", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSystemFeedbackImpl implements IObricSystemFeedback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f389242b;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.feedback.e] */
    @Override // com.obric.assistant.feedback.IObricSystemFeedback
    public final void init() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f389242b, "ObricSystemFeedbackImpl init");
        boolean r101 = t9a.b.a().c("obric_feature_genesis_feedback_support");     // Catch: Exception -> L8
        r100.i(this.f389242b, "ObricSystemFeedbackImpl init isEnable: " + r101);     // Catch: Exception -> L8
        if (r101 == true) goto L6;
        return;
    L6:
        DumpLogProvider.a(new e(this));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e(this.f389242b, "ObricSystemFeedbackImpl init fail", e);
    }

    public ObricSystemFeedbackImpl() {
        this.f389242b = "ObricSystemFeedbackImpl";
    }
}
