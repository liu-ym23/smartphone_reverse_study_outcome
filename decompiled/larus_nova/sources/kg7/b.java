package kg7;

import com.bytedance.sync.v2.protocal.ConsumeType;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static ConsumeType a(int r100) {
        ConsumeType r101 = ConsumeType.fromValue(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return ConsumeType.Increment;
    }
}
