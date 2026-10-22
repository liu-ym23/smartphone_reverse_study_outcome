package e21;

import com.bytedance.android.live.revlink.impl.model.BizType;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final boolean a(int r100) {
        if (r100 != BizType.PK.ordinal()) goto L5;
    L8:
        return true;
    L5:
        if (r100 == BizType.OpenGame.ordinal()) goto L8;
        return false;
    }
}
