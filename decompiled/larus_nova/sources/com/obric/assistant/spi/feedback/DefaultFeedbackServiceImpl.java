package com.obric.assistant.spi.feedback;

import com.larus.bmhome.auth.ReportReason;
import dx7.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016Jq\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/feedback/DefaultFeedbackServiceImpl;", "Lcom/obric/assistant/spi/feedback/IFeedbackService;", "<init>", "()V", "cacheReasonList", "", "metaList", "", "Lcom/larus/bmhome/auth/ReportReason;", "feedbackReadableMap", "params", "", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getSubmitFeedbackText", "getSubmitFeedbackSuccessText", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultFeedbackServiceImpl implements IFeedbackService {
    public DefaultFeedbackServiceImpl() {
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String a() {
        return null;
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void b(List<Integer> r100, List<String> r101, String r102, List<String> r103, List<String> r104, List<String> r105, Integer r106) {
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void c(List<ReportReason> r100) {
        Intrinsics.checkNotNullParameter(r100, "metaList");
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String d() {
        return null;
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }
}
