package com.larus.bmhome.praise;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/praise/IAiChatPraiseTriggerService;", "", "isExpectShowPraiseDialog", "", "tryShowPraiseDialog", "", "delayMillSec", "", "from", "", "feedbackScene", "messageId", "markForPraiseDialog", "checkForPraiseDialog", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiChatPraiseTriggerService {

    public static final class a {
        public static /* synthetic */ void a(IAiChatPraiseTriggerService r100, String r101, String r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            r100.b(0, r101, r102, null);
        }
    }

    boolean a();

    void b(long r100, String r101, String r102, String r103);

    void c(String r100);

    void d();
}
