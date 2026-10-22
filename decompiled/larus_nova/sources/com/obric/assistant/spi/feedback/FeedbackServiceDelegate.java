package com.obric.assistant.spi.feedback;

import com.larus.bmhome.auth.ReportReason;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dx7.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001Jr\u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/feedback/FeedbackServiceDelegate;", "Lcom/obric/assistant/spi/feedback/IFeedbackService;", "<init>", "()V", "cacheReasonList", "", "metaList", "", "Lcom/larus/bmhome/auth/ReportReason;", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "feedbackReadableMap", "params", "", "getSubmitFeedbackSuccessText", "getSubmitFeedbackText", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackServiceDelegate implements IFeedbackService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FeedbackServiceDelegate f392878b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFeedbackService f392879a;

    static {
        f392878b = new FeedbackServiceDelegate();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String a() {
        return this.f392879a.a();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void b(List<Integer> r100, List<String> r110, String r111, List<String> r112, List<String> r113, List<String> r114, Integer r115) {
        this.f392879a.b(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void c(List<ReportReason> r100) {
        Intrinsics.checkNotNullParameter(r100, "metaList");
        this.f392879a.c(r100);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String d() {
        return this.f392879a.d();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f392879a.e(r100);
    }

    private FeedbackServiceDelegate() {
        IFeedbackService r100 = (IFeedbackService) ServiceManager.get().getService(IFeedbackService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultFeedbackServiceImpl();
    L5:
        this.f392879a = r100;
    }
}
