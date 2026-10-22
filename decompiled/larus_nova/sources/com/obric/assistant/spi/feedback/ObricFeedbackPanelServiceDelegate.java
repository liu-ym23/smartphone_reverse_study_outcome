package com.obric.assistant.spi.feedback;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import nga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/feedback/ObricFeedbackPanelServiceDelegate;", "Lcom/obric/assistant/spi/feedback/IObricFeedbackPanelService;", "<init>", "()V", "createExperiencePlanProvider", "Lcom/obric/assistant/spi/feedback/IObricExperiencePlanFeedbackProvider;", "initExperiencePlan", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFeedbackPanelServiceDelegate implements IObricFeedbackPanelService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricFeedbackPanelServiceDelegate f392880b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricFeedbackPanelService f392881a;

    static {
        f392880b = new ObricFeedbackPanelServiceDelegate();
    }

    @Override // com.obric.assistant.spi.feedback.IObricFeedbackPanelService
    public final void a() {
        this.f392881a.a();
    }

    @Override // com.obric.assistant.spi.feedback.IObricFeedbackPanelService
    public final a b() {
        return this.f392881a.b();
    }

    private ObricFeedbackPanelServiceDelegate() {
        this.f392881a = (IObricFeedbackPanelService) ServiceManager.get().getService(IObricFeedbackPanelService.class);
    }
}
