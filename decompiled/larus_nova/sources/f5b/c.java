package f5b;

import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final boolean a(SmartReplyEntryInfo r100, SmartReplyEntryInfo r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.getHasPreGenerated() == r101.getHasPreGenerated()) goto L12;
    L16:
        return false;
    L12:
        if (Intrinsics.areEqual(r100.getAiMessageId(), r101.getAiMessageId()) == false) goto L16;
        if (Intrinsics.areEqual(r100.getRecommendContent(), r101.getRecommendContent()) == false) goto L16;
        return true;
    L18:
        return false;
    }
}
