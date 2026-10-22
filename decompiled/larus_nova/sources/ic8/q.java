package ic8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;

/* JADX INFO: loaded from: classes25.dex */
public final class q {
    public static final boolean a(DeepThinkFoldStatus r100) {
        if (r100 != DeepThinkFoldStatus.CompleteFold) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean b(DeepThinkFoldStatus r100) {
        if (r100 != DeepThinkFoldStatus.CompleteExpand) goto L5;
        return true;
    L5:
        if (r100 == DeepThinkFoldStatus.HalfFold) goto L11;
        return false;
    L11:
        return true;
    }
}
