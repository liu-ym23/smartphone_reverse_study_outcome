package com.obric.assistant.spi.feedback;

import com.larus.bmhome.auth.ReportReason;
import dx7.b;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H&J\u007f\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/feedback/IFeedbackService;", "", "cacheReasonList", "", "metaList", "", "Lcom/larus/bmhome/auth/ReportReason;", "feedbackReadableMap", "params", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getSubmitFeedbackText", "getSubmitFeedbackSuccessText", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFeedbackService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IFeedbackService r110, List r111, String r112, List r113, List r114, Integer r115, int r116) {
            if ((r116 & 1) == 0) goto L5;
            List r100 = null;
        L7:
            if ((r116 & 4) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r116 & 8) == 0) goto L13;
            List r102 = null;
        L15:
            if ((r116 & 16) == 0) goto L17;
            List r103 = null;
        L19:
            if ((r116 & 64) == 0) goto L21;
            Integer r104 = null;
        L22:
            r110.b(r100, null, r101, r102, r103, null, r104);
            return;
        L21:
            r104 = r115;
            goto L22
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    String a();

    void b(List<Integer> r100, List<String> r101, String r102, List<String> r103, List<String> r104, List<String> r105, Integer r106);

    void c(List<ReportReason> r100);

    String d();

    void e(b r100);
}
