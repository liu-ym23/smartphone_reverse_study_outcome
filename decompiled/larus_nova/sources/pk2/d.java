package pk2;

import com.bytedance.android.ec.model.response.ECPopExtendInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECPopExtendInfo f529589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529590b;

    public static final class a {
    }

    static {
    }

    public d() {
        this(0, 3);
    }

    public /* synthetic */ d(int r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = 0;
    L5:
        this(null, r100);
    }

    public d(ECPopExtendInfo r100, int r101) {
        this.f529589a = r100;
        this.f529590b = r101;
    }
}
