package pk2;

import com.bytedance.android.ec.model.response.ECPopExtendInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final ECPopExtendInfo a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public d() {
        this(0, 3);
    }

    public /* synthetic */ d(int r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        r1 = 0;
    L5:
        this(null, r1);
    }

    public d(ECPopExtendInfo r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
