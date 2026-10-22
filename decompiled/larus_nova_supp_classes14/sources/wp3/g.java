package wp3;

import com.bytedance.android.ec.model.ECUrlModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends c {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;

    public static final class a {
        public static g a(ECUrlModel r3, ECUrlModel r4) {
            if (r3 != null) goto L5;
            return null;
        L5:
            if (r4 != null) goto L8;
            return null;
        L8:
            return new g(r3.getFirstUrl(), r4.getFirstUrl(), r3.getWidth(), r3.getHeight());
        }
    }

    static {
    }

    public g(String r1, String r2, int r3, int r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = true;
    }
}
