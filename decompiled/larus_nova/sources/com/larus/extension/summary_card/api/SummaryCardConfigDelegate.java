package com.larus.extension.summary_card.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/extension/summary_card/api/SummaryCardConfigDelegate;", "Lcom/larus/extension/summary_card/api/ISummaryCardConfig;", "<init>", "()V", "convertToRealMessageAfterSendingMessage", "", "enabled", "showFallbackSummary", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryCardConfigDelegate implements ISummaryCardConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SummaryCardConfigDelegate f342909b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISummaryCardConfig f342910a;

    static {
        f342909b = new SummaryCardConfigDelegate();
    }

    @Override // com.larus.extension.summary_card.api.ISummaryCardConfig
    public final boolean a() {
        return this.f342910a.a();
    }

    @Override // com.larus.extension.summary_card.api.ISummaryCardConfig
    public final boolean enabled() {
        return this.f342910a.enabled();
    }

    private SummaryCardConfigDelegate() {
        ISummaryCardConfig r100 = (ISummaryCardConfig) ServiceManager.get().getService(ISummaryCardConfig.class);
        if (r100 != null) goto L5;
        r100 = new SummaryCardConfigNoop();
    L5:
        this.f342910a = r100;
    }
}
