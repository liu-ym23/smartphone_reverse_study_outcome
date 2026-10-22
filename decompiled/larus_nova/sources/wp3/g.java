package wp3;

import com.bytedance.android.ec.model.ECUrlModel;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f560586f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f560587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f560590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f560591e;

    public static final class a {
        public static g a(ECUrlModel r100, ECUrlModel r101) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r101 != null) goto L8;
            return null;
        L8:
            return new g(r100.getFirstUrl(), r101.getFirstUrl(), r100.getWidth(), r100.getHeight());
        }
    }

    static {
    }

    public g(String r100, String r101, int r102, int r103) {
        this.f560588b = r100;
        this.f560589c = r101;
        this.f560590d = r102;
        this.f560591e = r103;
        this.f560587a = true;
    }
}
