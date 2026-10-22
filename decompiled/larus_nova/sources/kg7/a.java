package kg7;

import com.bytedance.sync.v2.protocal.Bucket;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static int a(Bucket r100) {
        if (r100 != null) goto L6;
        return Bucket.Device.getValue();
    L6:
        return r100.getValue();
    }

    public static Bucket b(int r100) {
        Bucket r101 = Bucket.fromValue(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Bucket.Device;
    }
}
